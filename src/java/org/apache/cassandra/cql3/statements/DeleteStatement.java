/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.cassandra.cql3.statements;

import java.util.List;

import org.apache.cassandra.config.CFMetaData;
import org.apache.cassandra.config.ColumnDefinition;
import org.apache.cassandra.cql3.*;
import org.apache.cassandra.cql3.restrictions.StatementRestrictions;
import org.apache.cassandra.db.Clustering;
import org.apache.cassandra.db.Slice;
import org.apache.cassandra.db.partitions.PartitionUpdate;
import org.apache.cassandra.exceptions.InvalidRequestException;
import org.apache.cassandra.utils.Pair;

import static org.apache.cassandra.cql3.statements.RequestValidations.checkFalse;
import static org.apache.cassandra.cql3.statements.RequestValidations.checkTrue;

/**
 * A <code>DELETE</code> parsed from a CQL query statement.
 */
//还不支持在where中使用or
//必须指定where并且条件字段必须是primary key
public class DeleteStatement extends ModificationStatement
{
    //对于delete语句，Attributes只支持USING TIMESTAMP，不支持TTL
    private DeleteStatement(int boundTerms,
                            CFMetaData cfm,
                            Operations operations,
                            StatementRestrictions restrictions,
                            Conditions conditions,
                            Attributes attrs)
    {
        super(StatementType.DELETE, boundTerms, cfm, operations, restrictions, conditions, attrs);
    }

    @Override
    public void addUpdateForKey(PartitionUpdate update, Clustering clustering, UpdateParameters params)
    throws InvalidRequestException
    {
        List<Operation> regularDeletions = getRegularOperations();
        List<Operation> staticDeletions = getStaticOperations();

        if (regularDeletions.isEmpty() && staticDeletions.isEmpty())
        {
            // We're not deleting any specific columns so it's either a full partition deletion ....
            if (clustering.size() == 0)
            {
                update.addPartitionDeletion(params.deletionTime());
            }
            // ... or a row deletion ...
            else if (clustering.size() == cfm.clusteringColumns().size())
            {
                params.newRow(clustering);
                params.addRowDeletion();
                update.add(params.buildRow());
            }
            // ... or a range of rows deletion.
            else
            {
                update.add(params.makeRangeTombstone(cfm.comparator, clustering)); //删除二级聚簇中的多行记录
            }
        }
        else //delete xxx from 语法
        {
            if (!regularDeletions.isEmpty())
            {
//<<<<<<< HEAD
//                //删除REGULAR、COMPACT_VALUE这种类型的字段时必须在where中完整指定所有的CLUSTERING_COLUMN
//                // We can't delete specific (regular) columns if not all clustering columns have been specified.
//                if (cbuilder.remainingCount() > 0)
//                    throw new InvalidRequestException(String.format("Primary key column '%s' must be specified in order to delete column '%s'", getFirstEmptyKey().name, regularDeletions.get(0).column.name));
//=======
                params.newRow(clustering);

                for (Operation op : regularDeletions)
                    op.execute(update.partitionKey(), params);
                update.add(params.buildRow());
            }

            if (!staticDeletions.isEmpty())
            {
                params.newRow(Clustering.STATIC_CLUSTERING);
                for (Operation op : staticDeletions)
                    op.execute(update.partitionKey(), params);
                update.add(params.buildRow());
            }
        }

        params.validateIndexedColumns(update);
    }

    @Override
    public void addUpdateForKey(PartitionUpdate update, Slice slice, UpdateParameters params)
    {
        List<Operation> regularDeletions = getRegularOperations();
        List<Operation> staticDeletions = getStaticOperations();

        checkTrue(regularDeletions.isEmpty() && staticDeletions.isEmpty(),
                  "Range deletions are not supported for specific columns");

        update.add(params.makeRangeTombstone(slice));
    }

    public static class Parsed extends ModificationStatement.Parsed
    {
        private final List<Operation.RawDeletion> deletions;
        private final WhereClause whereClause;

        public Parsed(CFName name,
                      Attributes.Raw attrs,
                      List<Operation.RawDeletion> deletions,
                      WhereClause whereClause,
                      List<Pair<ColumnIdentifier.Raw, ColumnCondition.Raw>> conditions,
                      boolean ifExists)
        {
            super(name, attrs, conditions, false, ifExists);
            this.deletions = deletions;
            this.whereClause = whereClause;
        }

        //不能用delete xxx from这种格式删除PARTITION_KEY和CLUSTERING_COLUMN这两种字段
        @Override
        protected ModificationStatement prepareInternal(CFMetaData cfm,
                                                        VariableSpecifications boundNames,
                                                        Conditions conditions,
                                                        Attributes attrs)
        {
            Operations operations = new Operations();

            for (Operation.RawDeletion deletion : deletions)
            {
                ColumnDefinition def = getColumnDefinition(cfm, deletion.affectedColumn());

                // For compact, we only have one value except the key, so the only form of DELETE that make sense is without a column
                // list. However, we support having the value name for coherence with the static/sparse case
                checkFalse(def.isPrimaryKeyColumn(), "Invalid identifier %s for deletion (should not be a PRIMARY KEY part)", def.name);

                Operation op = deletion.prepare(cfm.ksName, def);
                op.collectMarkerSpecification(boundNames);
                operations.add(op);
            }

            StatementRestrictions restrictions = newRestrictions(StatementType.DELETE,
                                                                 cfm,
                                                                 boundNames,
                                                                 operations,
                                                                 whereClause,
                                                                 conditions);

            DeleteStatement stmt = new DeleteStatement(boundNames.size(),
                                                       cfm,
                                                       operations,
                                                       restrictions,
                                                       conditions,
                                                       attrs);

            if (stmt.hasConditions())
                checkTrue(restrictions.hasAllPKColumnsRestrictedByEqualities(),
                          "DELETE statements must restrict all PRIMARY KEY columns with equality relations" +
                          " in order to use IF conditions");
            return stmt;
        }
    }
}
