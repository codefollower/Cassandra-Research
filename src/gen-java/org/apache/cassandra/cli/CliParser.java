// $ANTLR 3.2 Sep 23, 2009 12:02:23 E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g 2013-09-08 20:26:10

package org.apache.cassandra.cli;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.tree.*;

/**
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
public class CliParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "NODE_CONNECT", "NODE_DESCRIBE", "NODE_DESCRIBE_CLUSTER", "NODE_USE_TABLE", "NODE_TRACE_NEXT_QUERY", "NODE_SET_TRACE_PROBABILITY", "NODE_EXIT", "NODE_HELP", "NODE_NO_OP", "NODE_SHOW_CLUSTER_NAME", "NODE_SHOW_VERSION", "NODE_SHOW_KEYSPACES", "NODE_SHOW_SCHEMA", "NODE_THRIFT_GET", "NODE_THRIFT_GET_WITH_CONDITIONS", "NODE_THRIFT_SET", "NODE_THRIFT_COUNT", "NODE_THRIFT_DEL", "NODE_THRIFT_INCR", "NODE_THRIFT_DECR", "NODE_ADD_COLUMN_FAMILY", "NODE_ADD_KEYSPACE", "NODE_DEL_KEYSPACE", "NODE_DEL_COLUMN_FAMILY", "NODE_UPDATE_KEYSPACE", "NODE_UPDATE_COLUMN_FAMILY", "NODE_LIST", "NODE_TRUNCATE", "NODE_ASSUME", "NODE_CONSISTENCY_LEVEL", "NODE_DROP_INDEX", "NODE_COLUMN_ACCESS", "NODE_ID_LIST", "NODE_NEW_CF_ACCESS", "NODE_NEW_KEYSPACE_ACCESS", "CONVERT_TO_TYPE", "FUNCTION_CALL", "CONDITION", "CONDITIONS", "ARRAY", "HASH", "PAIR", "NODE_LIMIT", "NODE_COLUMNS", "NODE_REVERSED", "NODE_KEY_RANGE", "SEMICOLON", "CONNECT", "HELP", "USE", "TRACE", "NEXT", "QUERY", "SET", "PROBABILITY", "DESCRIBE", "EXIT", "QUIT", "SHOW", "KEYSPACES", "SCHEMA", "API_VERSION", "CREATE", "KEYSPACE", "UPDATE", "COLUMN", "FAMILY", "DROP", "INDEX", "GET", "INCR", "DECR", "DEL", "COUNT", "LIST", "TRUNCATE", "ASSUME", "CONSISTENCYLEVEL", "IntegerPositiveLiteral", "Identifier", "StringLiteral", "WITH", "TTL", "BY", "ON", "AND", "IntegerNegativeLiteral", "DoubleLiteral", "IP_ADDRESS", "CONFIG", "FILE", "LIMIT", "Letter", "Digit", "Alnum", "SingleStringCharacter", "EscapeSequence", "CharacterEscapeSequence", "HexEscapeSequence", "UnicodeEscapeSequence", "SingleEscapeCharacter", "NonEscapeCharacter", "EscapeCharacter", "DecimalDigit", "HexDigit", "WS", "COMMENT", "'/'", "'CLUSTER'", "'CLUSTER NAME'", "'?'", "'AS'", "'WHERE'", "'='", "'>'", "'<'", "'>='", "'<='", "'.'", "'['", "','", "']'", "'{'", "'}'", "':'", "'COLUMNS'", "'REVERSED'", "'('", "')'"
    };
    public static final int NODE_DESCRIBE=5;
    public static final int NODE_THRIFT_GET_WITH_CONDITIONS=18;
    public static final int NODE_TRACE_NEXT_QUERY=8;
    public static final int TTL=86;
    public static final int TRACE=54;
    public static final int NODE_SHOW_KEYSPACES=15;
    public static final int CONDITION=41;
    public static final int COUNT=77;
    public static final int DecimalDigit=107;
    public static final int EOF=-1;
    public static final int Identifier=83;
    public static final int NODE_UPDATE_COLUMN_FAMILY=29;
    public static final int SingleStringCharacter=99;
    public static final int NODE_USE_TABLE=7;
    public static final int NODE_DEL_KEYSPACE=26;
    public static final int CREATE=66;
    public static final int NODE_CONNECT=4;
    public static final int INCR=74;
    public static final int CONNECT=51;
    public static final int SingleEscapeCharacter=104;
    public static final int FAMILY=70;
    public static final int GET=73;
    public static final int COMMENT=110;
    public static final int SHOW=62;
    public static final int ARRAY=43;
    public static final int NODE_ADD_KEYSPACE=25;
    public static final int EXIT=60;
    public static final int NODE_COLUMNS=47;
    public static final int NODE_THRIFT_DEL=21;
    public static final int IntegerNegativeLiteral=90;
    public static final int ON=88;
    public static final int NODE_DROP_INDEX=34;
    public static final int SEMICOLON=50;
    public static final int KEYSPACES=63;
    public static final int CONDITIONS=42;
    public static final int FILE=94;
    public static final int LIST=78;
    public static final int NODE_LIMIT=46;
    public static final int NODE_DESCRIBE_CLUSTER=6;
    public static final int IP_ADDRESS=92;
    public static final int T__126=126;
    public static final int NODE_THRIFT_SET=19;
    public static final int NODE_NO_OP=12;
    public static final int T__125=125;
    public static final int T__128=128;
    public static final int T__127=127;
    public static final int NODE_ID_LIST=36;
    public static final int WS=109;
    public static final int T__129=129;
    public static final int ASSUME=80;
    public static final int NODE_THRIFT_COUNT=20;
    public static final int DESCRIBE=59;
    public static final int Alnum=98;
    public static final int QUERY=56;
    public static final int CharacterEscapeSequence=101;
    public static final int NODE_SHOW_CLUSTER_NAME=13;
    public static final int USE=53;
    public static final int NODE_THRIFT_DECR=23;
    public static final int FUNCTION_CALL=40;
    public static final int T__130=130;
    public static final int EscapeSequence=100;
    public static final int Letter=96;
    public static final int DoubleLiteral=91;
    public static final int T__131=131;
    public static final int T__132=132;
    public static final int HELP=52;
    public static final int HexEscapeSequence=102;
    public static final int NODE_EXIT=10;
    public static final int LIMIT=95;
    public static final int T__118=118;
    public static final int DEL=76;
    public static final int T__119=119;
    public static final int T__116=116;
    public static final int T__117=117;
    public static final int T__114=114;
    public static final int NODE_SHOW_SCHEMA=16;
    public static final int T__115=115;
    public static final int T__124=124;
    public static final int T__123=123;
    public static final int NODE_LIST=30;
    public static final int UPDATE=68;
    public static final int T__122=122;
    public static final int NODE_UPDATE_KEYSPACE=28;
    public static final int T__121=121;
    public static final int T__120=120;
    public static final int AND=89;
    public static final int NODE_NEW_CF_ACCESS=37;
    public static final int CONSISTENCYLEVEL=81;
    public static final int HexDigit=108;
    public static final int QUIT=61;
    public static final int INDEX=72;
    public static final int NODE_TRUNCATE=31;
    public static final int NODE_SHOW_VERSION=14;
    public static final int NODE_NEW_KEYSPACE_ACCESS=38;
    public static final int NODE_REVERSED=48;
    public static final int TRUNCATE=79;
    public static final int COLUMN=69;
    public static final int T__111=111;
    public static final int T__113=113;
    public static final int EscapeCharacter=106;
    public static final int T__112=112;
    public static final int NEXT=55;
    public static final int PAIR=45;
    public static final int NODE_CONSISTENCY_LEVEL=33;
    public static final int WITH=85;
    public static final int BY=87;
    public static final int UnicodeEscapeSequence=103;
    public static final int NODE_SET_TRACE_PROBABILITY=9;
    public static final int HASH=44;
    public static final int SET=57;
    public static final int Digit=97;
    public static final int API_VERSION=65;
    public static final int NODE_ASSUME=32;
    public static final int CONVERT_TO_TYPE=39;
    public static final int NODE_THRIFT_GET=17;
    public static final int NODE_DEL_COLUMN_FAMILY=27;
    public static final int NODE_KEY_RANGE=49;
    public static final int KEYSPACE=67;
    public static final int StringLiteral=84;
    public static final int NODE_HELP=11;
    public static final int CONFIG=93;
    public static final int IntegerPositiveLiteral=82;
    public static final int SCHEMA=64;
    public static final int DROP=71;
    public static final int NonEscapeCharacter=105;
    public static final int DECR=75;
    public static final int NODE_ADD_COLUMN_FAMILY=24;
    public static final int PROBABILITY=58;
    public static final int NODE_THRIFT_INCR=22;
    public static final int NODE_COLUMN_ACCESS=35;

    // delegates
    // delegators


        public CliParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CliParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected TreeAdaptor adaptor = new CommonTreeAdaptor();

    public void setTreeAdaptor(TreeAdaptor adaptor) {
        this.adaptor = adaptor;
    }
    public TreeAdaptor getTreeAdaptor() {
        return adaptor;
    }

    public String[] getTokenNames() { return CliParser.tokenNames; }
    public String getGrammarFileName() { return "E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g"; }


        public void reportError(RecognitionException e) 
        {
            String errorMessage = "Syntax error at position " + e.charPositionInLine + ": " + this.getErrorMessage(e, this.getTokenNames());

            throw new RuntimeException(errorMessage);
        }


    public static class root_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "root"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:135:1: root : statement ( SEMICOLON )? EOF -> statement ;
    public final CliParser.root_return root() throws RecognitionException {
        CliParser.root_return retval = new CliParser.root_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SEMICOLON2=null;
        Token EOF3=null;
        CliParser.statement_return statement1 = null;


        CommonTree SEMICOLON2_tree=null;
        CommonTree EOF3_tree=null;
        RewriteRuleTokenStream stream_SEMICOLON=new RewriteRuleTokenStream(adaptor,"token SEMICOLON");
        RewriteRuleTokenStream stream_EOF=new RewriteRuleTokenStream(adaptor,"token EOF");
        RewriteRuleSubtreeStream stream_statement=new RewriteRuleSubtreeStream(adaptor,"rule statement");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:135:5: ( statement ( SEMICOLON )? EOF -> statement )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:135:7: statement ( SEMICOLON )? EOF
            {
            pushFollow(FOLLOW_statement_in_root449);
            statement1=statement();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_statement.add(statement1.getTree());
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:135:17: ( SEMICOLON )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==SEMICOLON) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:0:0: SEMICOLON
                    {
                    SEMICOLON2=(Token)match(input,SEMICOLON,FOLLOW_SEMICOLON_in_root451); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SEMICOLON.add(SEMICOLON2);


                    }
                    break;

            }

            EOF3=(Token)match(input,EOF,FOLLOW_EOF_in_root454); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_EOF.add(EOF3);



            // AST REWRITE
            // elements: statement
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 135:32: -> statement
            {
                adaptor.addChild(root_0, stream_statement.nextTree());

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "root"

    public static class statement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "statement"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:137:1: statement : ( connectStatement | exitStatement | countStatement | describeTable | describeCluster | addKeyspace | addColumnFamily | updateKeyspace | updateColumnFamily | delColumnFamily | delKeyspace | useKeyspace | traceNextQuery | setTraceProbability | delStatement | getStatement | helpStatement | setStatement | incrStatement | showStatement | listStatement | truncateStatement | assumeStatement | consistencyLevelStatement | dropIndex | -> ^( NODE_NO_OP ) );
    public final CliParser.statement_return statement() throws RecognitionException {
        CliParser.statement_return retval = new CliParser.statement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.connectStatement_return connectStatement4 = null;

        CliParser.exitStatement_return exitStatement5 = null;

        CliParser.countStatement_return countStatement6 = null;

        CliParser.describeTable_return describeTable7 = null;

        CliParser.describeCluster_return describeCluster8 = null;

        CliParser.addKeyspace_return addKeyspace9 = null;

        CliParser.addColumnFamily_return addColumnFamily10 = null;

        CliParser.updateKeyspace_return updateKeyspace11 = null;

        CliParser.updateColumnFamily_return updateColumnFamily12 = null;

        CliParser.delColumnFamily_return delColumnFamily13 = null;

        CliParser.delKeyspace_return delKeyspace14 = null;

        CliParser.useKeyspace_return useKeyspace15 = null;

        CliParser.traceNextQuery_return traceNextQuery16 = null;

        CliParser.setTraceProbability_return setTraceProbability17 = null;

        CliParser.delStatement_return delStatement18 = null;

        CliParser.getStatement_return getStatement19 = null;

        CliParser.helpStatement_return helpStatement20 = null;

        CliParser.setStatement_return setStatement21 = null;

        CliParser.incrStatement_return incrStatement22 = null;

        CliParser.showStatement_return showStatement23 = null;

        CliParser.listStatement_return listStatement24 = null;

        CliParser.truncateStatement_return truncateStatement25 = null;

        CliParser.assumeStatement_return assumeStatement26 = null;

        CliParser.consistencyLevelStatement_return consistencyLevelStatement27 = null;

        CliParser.dropIndex_return dropIndex28 = null;



        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:138:5: ( connectStatement | exitStatement | countStatement | describeTable | describeCluster | addKeyspace | addColumnFamily | updateKeyspace | updateColumnFamily | delColumnFamily | delKeyspace | useKeyspace | traceNextQuery | setTraceProbability | delStatement | getStatement | helpStatement | setStatement | incrStatement | showStatement | listStatement | truncateStatement | assumeStatement | consistencyLevelStatement | dropIndex | -> ^( NODE_NO_OP ) )
            int alt2=26;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:138:7: connectStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_connectStatement_in_statement470);
                    connectStatement4=connectStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, connectStatement4.getTree());

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:139:7: exitStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_exitStatement_in_statement478);
                    exitStatement5=exitStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, exitStatement5.getTree());

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:140:7: countStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_countStatement_in_statement486);
                    countStatement6=countStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, countStatement6.getTree());

                    }
                    break;
                case 4 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:141:7: describeTable
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_describeTable_in_statement494);
                    describeTable7=describeTable();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, describeTable7.getTree());

                    }
                    break;
                case 5 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:142:7: describeCluster
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_describeCluster_in_statement502);
                    describeCluster8=describeCluster();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, describeCluster8.getTree());

                    }
                    break;
                case 6 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:143:7: addKeyspace
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_addKeyspace_in_statement510);
                    addKeyspace9=addKeyspace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, addKeyspace9.getTree());

                    }
                    break;
                case 7 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:144:7: addColumnFamily
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_addColumnFamily_in_statement518);
                    addColumnFamily10=addColumnFamily();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, addColumnFamily10.getTree());

                    }
                    break;
                case 8 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:145:7: updateKeyspace
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_updateKeyspace_in_statement526);
                    updateKeyspace11=updateKeyspace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, updateKeyspace11.getTree());

                    }
                    break;
                case 9 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:146:7: updateColumnFamily
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_updateColumnFamily_in_statement534);
                    updateColumnFamily12=updateColumnFamily();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, updateColumnFamily12.getTree());

                    }
                    break;
                case 10 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:147:7: delColumnFamily
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_delColumnFamily_in_statement542);
                    delColumnFamily13=delColumnFamily();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, delColumnFamily13.getTree());

                    }
                    break;
                case 11 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:148:7: delKeyspace
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_delKeyspace_in_statement550);
                    delKeyspace14=delKeyspace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, delKeyspace14.getTree());

                    }
                    break;
                case 12 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:149:7: useKeyspace
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_useKeyspace_in_statement558);
                    useKeyspace15=useKeyspace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, useKeyspace15.getTree());

                    }
                    break;
                case 13 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:150:7: traceNextQuery
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_traceNextQuery_in_statement566);
                    traceNextQuery16=traceNextQuery();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, traceNextQuery16.getTree());

                    }
                    break;
                case 14 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:151:7: setTraceProbability
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_setTraceProbability_in_statement574);
                    setTraceProbability17=setTraceProbability();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, setTraceProbability17.getTree());

                    }
                    break;
                case 15 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:152:7: delStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_delStatement_in_statement582);
                    delStatement18=delStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, delStatement18.getTree());

                    }
                    break;
                case 16 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:153:7: getStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_getStatement_in_statement590);
                    getStatement19=getStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, getStatement19.getTree());

                    }
                    break;
                case 17 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:154:7: helpStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_helpStatement_in_statement598);
                    helpStatement20=helpStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, helpStatement20.getTree());

                    }
                    break;
                case 18 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:155:7: setStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_setStatement_in_statement606);
                    setStatement21=setStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, setStatement21.getTree());

                    }
                    break;
                case 19 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:156:7: incrStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_incrStatement_in_statement614);
                    incrStatement22=incrStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, incrStatement22.getTree());

                    }
                    break;
                case 20 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:157:7: showStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_showStatement_in_statement622);
                    showStatement23=showStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, showStatement23.getTree());

                    }
                    break;
                case 21 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:158:7: listStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_listStatement_in_statement630);
                    listStatement24=listStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, listStatement24.getTree());

                    }
                    break;
                case 22 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:159:7: truncateStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_truncateStatement_in_statement638);
                    truncateStatement25=truncateStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, truncateStatement25.getTree());

                    }
                    break;
                case 23 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:160:7: assumeStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_assumeStatement_in_statement646);
                    assumeStatement26=assumeStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, assumeStatement26.getTree());

                    }
                    break;
                case 24 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:161:7: consistencyLevelStatement
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_consistencyLevelStatement_in_statement654);
                    consistencyLevelStatement27=consistencyLevelStatement();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, consistencyLevelStatement27.getTree());

                    }
                    break;
                case 25 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:162:7: dropIndex
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_dropIndex_in_statement662);
                    dropIndex28=dropIndex();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, dropIndex28.getTree());

                    }
                    break;
                case 26 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:163:7: 
                    {

                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 163:7: -> ^( NODE_NO_OP )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:163:10: ^( NODE_NO_OP )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_NO_OP, "NODE_NO_OP"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "statement"

    public static class connectStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "connectStatement"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:166:1: connectStatement : ( CONNECT host '/' port ( username password )? -> ^( NODE_CONNECT host port ( username password )? ) | CONNECT ip_address '/' port ( username password )? -> ^( NODE_CONNECT ip_address port ( username password )? ) );
    public final CliParser.connectStatement_return connectStatement() throws RecognitionException {
        CliParser.connectStatement_return retval = new CliParser.connectStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CONNECT29=null;
        Token char_literal31=null;
        Token CONNECT35=null;
        Token char_literal37=null;
        CliParser.host_return host30 = null;

        CliParser.port_return port32 = null;

        CliParser.username_return username33 = null;

        CliParser.password_return password34 = null;

        CliParser.ip_address_return ip_address36 = null;

        CliParser.port_return port38 = null;

        CliParser.username_return username39 = null;

        CliParser.password_return password40 = null;


        CommonTree CONNECT29_tree=null;
        CommonTree char_literal31_tree=null;
        CommonTree CONNECT35_tree=null;
        CommonTree char_literal37_tree=null;
        RewriteRuleTokenStream stream_111=new RewriteRuleTokenStream(adaptor,"token 111");
        RewriteRuleTokenStream stream_CONNECT=new RewriteRuleTokenStream(adaptor,"token CONNECT");
        RewriteRuleSubtreeStream stream_port=new RewriteRuleSubtreeStream(adaptor,"rule port");
        RewriteRuleSubtreeStream stream_ip_address=new RewriteRuleSubtreeStream(adaptor,"rule ip_address");
        RewriteRuleSubtreeStream stream_username=new RewriteRuleSubtreeStream(adaptor,"rule username");
        RewriteRuleSubtreeStream stream_host=new RewriteRuleSubtreeStream(adaptor,"rule host");
        RewriteRuleSubtreeStream stream_password=new RewriteRuleSubtreeStream(adaptor,"rule password");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:167:5: ( CONNECT host '/' port ( username password )? -> ^( NODE_CONNECT host port ( username password )? ) | CONNECT ip_address '/' port ( username password )? -> ^( NODE_CONNECT ip_address port ( username password )? ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==CONNECT) ) {
                int LA5_1 = input.LA(2);

                if ( (LA5_1==IP_ADDRESS) ) {
                    alt5=2;
                }
                else if ( (LA5_1==Identifier) ) {
                    alt5=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 5, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:167:7: CONNECT host '/' port ( username password )?
                    {
                    CONNECT29=(Token)match(input,CONNECT,FOLLOW_CONNECT_in_connectStatement691); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CONNECT.add(CONNECT29);

                    pushFollow(FOLLOW_host_in_connectStatement693);
                    host30=host();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_host.add(host30.getTree());
                    char_literal31=(Token)match(input,111,FOLLOW_111_in_connectStatement695); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_111.add(char_literal31);

                    pushFollow(FOLLOW_port_in_connectStatement697);
                    port32=port();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_port.add(port32.getTree());
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:167:29: ( username password )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==Identifier) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:167:30: username password
                            {
                            pushFollow(FOLLOW_username_in_connectStatement700);
                            username33=username();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_username.add(username33.getTree());
                            pushFollow(FOLLOW_password_in_connectStatement702);
                            password34=password();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_password.add(password34.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: username, port, password, host
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 168:9: -> ^( NODE_CONNECT host port ( username password )? )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:168:12: ^( NODE_CONNECT host port ( username password )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_CONNECT, "NODE_CONNECT"), root_1);

                        adaptor.addChild(root_1, stream_host.nextTree());
                        adaptor.addChild(root_1, stream_port.nextTree());
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:168:37: ( username password )?
                        if ( stream_username.hasNext()||stream_password.hasNext() ) {
                            adaptor.addChild(root_1, stream_username.nextTree());
                            adaptor.addChild(root_1, stream_password.nextTree());

                        }
                        stream_username.reset();
                        stream_password.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:169:7: CONNECT ip_address '/' port ( username password )?
                    {
                    CONNECT35=(Token)match(input,CONNECT,FOLLOW_CONNECT_in_connectStatement737); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CONNECT.add(CONNECT35);

                    pushFollow(FOLLOW_ip_address_in_connectStatement739);
                    ip_address36=ip_address();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_ip_address.add(ip_address36.getTree());
                    char_literal37=(Token)match(input,111,FOLLOW_111_in_connectStatement741); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_111.add(char_literal37);

                    pushFollow(FOLLOW_port_in_connectStatement743);
                    port38=port();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_port.add(port38.getTree());
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:169:35: ( username password )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==Identifier) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:169:36: username password
                            {
                            pushFollow(FOLLOW_username_in_connectStatement746);
                            username39=username();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_username.add(username39.getTree());
                            pushFollow(FOLLOW_password_in_connectStatement748);
                            password40=password();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_password.add(password40.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: port, ip_address, username, password
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 170:9: -> ^( NODE_CONNECT ip_address port ( username password )? )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:170:12: ^( NODE_CONNECT ip_address port ( username password )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_CONNECT, "NODE_CONNECT"), root_1);

                        adaptor.addChild(root_1, stream_ip_address.nextTree());
                        adaptor.addChild(root_1, stream_port.nextTree());
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:170:43: ( username password )?
                        if ( stream_username.hasNext()||stream_password.hasNext() ) {
                            adaptor.addChild(root_1, stream_username.nextTree());
                            adaptor.addChild(root_1, stream_password.nextTree());

                        }
                        stream_username.reset();
                        stream_password.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "connectStatement"

    public static class helpStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "helpStatement"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:173:1: helpStatement : ( HELP HELP -> ^( NODE_HELP NODE_HELP ) | HELP CONNECT -> ^( NODE_HELP NODE_CONNECT ) | HELP USE -> ^( NODE_HELP NODE_USE_TABLE ) | HELP TRACE NEXT QUERY -> ^( NODE_HELP NODE_TRACE_NEXT_QUERY ) | HELP SET TRACE PROBABILITY -> ^( NODE_HELP NODE_SET_TRACE_PROBABILITY ) | HELP DESCRIBE -> ^( NODE_HELP NODE_DESCRIBE ) | HELP DESCRIBE 'CLUSTER' -> ^( NODE_HELP NODE_DESCRIBE_CLUSTER ) | HELP EXIT -> ^( NODE_HELP NODE_EXIT ) | HELP QUIT -> ^( NODE_HELP NODE_EXIT ) | HELP SHOW 'CLUSTER NAME' -> ^( NODE_HELP NODE_SHOW_CLUSTER_NAME ) | HELP SHOW KEYSPACES -> ^( NODE_HELP NODE_SHOW_KEYSPACES ) | HELP SHOW SCHEMA -> ^( NODE_HELP NODE_SHOW_SCHEMA ) | HELP SHOW API_VERSION -> ^( NODE_HELP NODE_SHOW_VERSION ) | HELP CREATE KEYSPACE -> ^( NODE_HELP NODE_ADD_KEYSPACE ) | HELP UPDATE KEYSPACE -> ^( NODE_HELP NODE_UPDATE_KEYSPACE ) | HELP CREATE COLUMN FAMILY -> ^( NODE_HELP NODE_ADD_COLUMN_FAMILY ) | HELP UPDATE COLUMN FAMILY -> ^( NODE_HELP NODE_UPDATE_COLUMN_FAMILY ) | HELP DROP KEYSPACE -> ^( NODE_HELP NODE_DEL_KEYSPACE ) | HELP DROP COLUMN FAMILY -> ^( NODE_HELP NODE_DEL_COLUMN_FAMILY ) | HELP DROP INDEX -> ^( NODE_HELP NODE_DROP_INDEX ) | HELP GET -> ^( NODE_HELP NODE_THRIFT_GET ) | HELP SET -> ^( NODE_HELP NODE_THRIFT_SET ) | HELP INCR -> ^( NODE_HELP NODE_THRIFT_INCR ) | HELP DECR -> ^( NODE_HELP NODE_THRIFT_DECR ) | HELP DEL -> ^( NODE_HELP NODE_THRIFT_DEL ) | HELP COUNT -> ^( NODE_HELP NODE_THRIFT_COUNT ) | HELP LIST -> ^( NODE_HELP NODE_LIST ) | HELP TRUNCATE -> ^( NODE_HELP NODE_TRUNCATE ) | HELP ASSUME -> ^( NODE_HELP NODE_ASSUME ) | HELP CONSISTENCYLEVEL -> ^( NODE_HELP NODE_CONSISTENCY_LEVEL ) | HELP -> ^( NODE_HELP ) | '?' -> ^( NODE_HELP ) );
    public final CliParser.helpStatement_return helpStatement() throws RecognitionException {
        CliParser.helpStatement_return retval = new CliParser.helpStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token HELP41=null;
        Token HELP42=null;
        Token HELP43=null;
        Token CONNECT44=null;
        Token HELP45=null;
        Token USE46=null;
        Token HELP47=null;
        Token TRACE48=null;
        Token NEXT49=null;
        Token QUERY50=null;
        Token HELP51=null;
        Token SET52=null;
        Token TRACE53=null;
        Token PROBABILITY54=null;
        Token HELP55=null;
        Token DESCRIBE56=null;
        Token HELP57=null;
        Token DESCRIBE58=null;
        Token string_literal59=null;
        Token HELP60=null;
        Token EXIT61=null;
        Token HELP62=null;
        Token QUIT63=null;
        Token HELP64=null;
        Token SHOW65=null;
        Token string_literal66=null;
        Token HELP67=null;
        Token SHOW68=null;
        Token KEYSPACES69=null;
        Token HELP70=null;
        Token SHOW71=null;
        Token SCHEMA72=null;
        Token HELP73=null;
        Token SHOW74=null;
        Token API_VERSION75=null;
        Token HELP76=null;
        Token CREATE77=null;
        Token KEYSPACE78=null;
        Token HELP79=null;
        Token UPDATE80=null;
        Token KEYSPACE81=null;
        Token HELP82=null;
        Token CREATE83=null;
        Token COLUMN84=null;
        Token FAMILY85=null;
        Token HELP86=null;
        Token UPDATE87=null;
        Token COLUMN88=null;
        Token FAMILY89=null;
        Token HELP90=null;
        Token DROP91=null;
        Token KEYSPACE92=null;
        Token HELP93=null;
        Token DROP94=null;
        Token COLUMN95=null;
        Token FAMILY96=null;
        Token HELP97=null;
        Token DROP98=null;
        Token INDEX99=null;
        Token HELP100=null;
        Token GET101=null;
        Token HELP102=null;
        Token SET103=null;
        Token HELP104=null;
        Token INCR105=null;
        Token HELP106=null;
        Token DECR107=null;
        Token HELP108=null;
        Token DEL109=null;
        Token HELP110=null;
        Token COUNT111=null;
        Token HELP112=null;
        Token LIST113=null;
        Token HELP114=null;
        Token TRUNCATE115=null;
        Token HELP116=null;
        Token ASSUME117=null;
        Token HELP118=null;
        Token CONSISTENCYLEVEL119=null;
        Token HELP120=null;
        Token char_literal121=null;

        CommonTree HELP41_tree=null;
        CommonTree HELP42_tree=null;
        CommonTree HELP43_tree=null;
        CommonTree CONNECT44_tree=null;
        CommonTree HELP45_tree=null;
        CommonTree USE46_tree=null;
        CommonTree HELP47_tree=null;
        CommonTree TRACE48_tree=null;
        CommonTree NEXT49_tree=null;
        CommonTree QUERY50_tree=null;
        CommonTree HELP51_tree=null;
        CommonTree SET52_tree=null;
        CommonTree TRACE53_tree=null;
        CommonTree PROBABILITY54_tree=null;
        CommonTree HELP55_tree=null;
        CommonTree DESCRIBE56_tree=null;
        CommonTree HELP57_tree=null;
        CommonTree DESCRIBE58_tree=null;
        CommonTree string_literal59_tree=null;
        CommonTree HELP60_tree=null;
        CommonTree EXIT61_tree=null;
        CommonTree HELP62_tree=null;
        CommonTree QUIT63_tree=null;
        CommonTree HELP64_tree=null;
        CommonTree SHOW65_tree=null;
        CommonTree string_literal66_tree=null;
        CommonTree HELP67_tree=null;
        CommonTree SHOW68_tree=null;
        CommonTree KEYSPACES69_tree=null;
        CommonTree HELP70_tree=null;
        CommonTree SHOW71_tree=null;
        CommonTree SCHEMA72_tree=null;
        CommonTree HELP73_tree=null;
        CommonTree SHOW74_tree=null;
        CommonTree API_VERSION75_tree=null;
        CommonTree HELP76_tree=null;
        CommonTree CREATE77_tree=null;
        CommonTree KEYSPACE78_tree=null;
        CommonTree HELP79_tree=null;
        CommonTree UPDATE80_tree=null;
        CommonTree KEYSPACE81_tree=null;
        CommonTree HELP82_tree=null;
        CommonTree CREATE83_tree=null;
        CommonTree COLUMN84_tree=null;
        CommonTree FAMILY85_tree=null;
        CommonTree HELP86_tree=null;
        CommonTree UPDATE87_tree=null;
        CommonTree COLUMN88_tree=null;
        CommonTree FAMILY89_tree=null;
        CommonTree HELP90_tree=null;
        CommonTree DROP91_tree=null;
        CommonTree KEYSPACE92_tree=null;
        CommonTree HELP93_tree=null;
        CommonTree DROP94_tree=null;
        CommonTree COLUMN95_tree=null;
        CommonTree FAMILY96_tree=null;
        CommonTree HELP97_tree=null;
        CommonTree DROP98_tree=null;
        CommonTree INDEX99_tree=null;
        CommonTree HELP100_tree=null;
        CommonTree GET101_tree=null;
        CommonTree HELP102_tree=null;
        CommonTree SET103_tree=null;
        CommonTree HELP104_tree=null;
        CommonTree INCR105_tree=null;
        CommonTree HELP106_tree=null;
        CommonTree DECR107_tree=null;
        CommonTree HELP108_tree=null;
        CommonTree DEL109_tree=null;
        CommonTree HELP110_tree=null;
        CommonTree COUNT111_tree=null;
        CommonTree HELP112_tree=null;
        CommonTree LIST113_tree=null;
        CommonTree HELP114_tree=null;
        CommonTree TRUNCATE115_tree=null;
        CommonTree HELP116_tree=null;
        CommonTree ASSUME117_tree=null;
        CommonTree HELP118_tree=null;
        CommonTree CONSISTENCYLEVEL119_tree=null;
        CommonTree HELP120_tree=null;
        CommonTree char_literal121_tree=null;
        RewriteRuleTokenStream stream_EXIT=new RewriteRuleTokenStream(adaptor,"token EXIT");
        RewriteRuleTokenStream stream_HELP=new RewriteRuleTokenStream(adaptor,"token HELP");
        RewriteRuleTokenStream stream_114=new RewriteRuleTokenStream(adaptor,"token 114");
        RewriteRuleTokenStream stream_112=new RewriteRuleTokenStream(adaptor,"token 112");
        RewriteRuleTokenStream stream_113=new RewriteRuleTokenStream(adaptor,"token 113");
        RewriteRuleTokenStream stream_DEL=new RewriteRuleTokenStream(adaptor,"token DEL");
        RewriteRuleTokenStream stream_TRACE=new RewriteRuleTokenStream(adaptor,"token TRACE");
        RewriteRuleTokenStream stream_UPDATE=new RewriteRuleTokenStream(adaptor,"token UPDATE");
        RewriteRuleTokenStream stream_SET=new RewriteRuleTokenStream(adaptor,"token SET");
        RewriteRuleTokenStream stream_COUNT=new RewriteRuleTokenStream(adaptor,"token COUNT");
        RewriteRuleTokenStream stream_KEYSPACES=new RewriteRuleTokenStream(adaptor,"token KEYSPACES");
        RewriteRuleTokenStream stream_API_VERSION=new RewriteRuleTokenStream(adaptor,"token API_VERSION");
        RewriteRuleTokenStream stream_CONSISTENCYLEVEL=new RewriteRuleTokenStream(adaptor,"token CONSISTENCYLEVEL");
        RewriteRuleTokenStream stream_LIST=new RewriteRuleTokenStream(adaptor,"token LIST");
        RewriteRuleTokenStream stream_QUIT=new RewriteRuleTokenStream(adaptor,"token QUIT");
        RewriteRuleTokenStream stream_KEYSPACE=new RewriteRuleTokenStream(adaptor,"token KEYSPACE");
        RewriteRuleTokenStream stream_INDEX=new RewriteRuleTokenStream(adaptor,"token INDEX");
        RewriteRuleTokenStream stream_CREATE=new RewriteRuleTokenStream(adaptor,"token CREATE");
        RewriteRuleTokenStream stream_SCHEMA=new RewriteRuleTokenStream(adaptor,"token SCHEMA");
        RewriteRuleTokenStream stream_INCR=new RewriteRuleTokenStream(adaptor,"token INCR");
        RewriteRuleTokenStream stream_CONNECT=new RewriteRuleTokenStream(adaptor,"token CONNECT");
        RewriteRuleTokenStream stream_DROP=new RewriteRuleTokenStream(adaptor,"token DROP");
        RewriteRuleTokenStream stream_ASSUME=new RewriteRuleTokenStream(adaptor,"token ASSUME");
        RewriteRuleTokenStream stream_TRUNCATE=new RewriteRuleTokenStream(adaptor,"token TRUNCATE");
        RewriteRuleTokenStream stream_DESCRIBE=new RewriteRuleTokenStream(adaptor,"token DESCRIBE");
        RewriteRuleTokenStream stream_COLUMN=new RewriteRuleTokenStream(adaptor,"token COLUMN");
        RewriteRuleTokenStream stream_DECR=new RewriteRuleTokenStream(adaptor,"token DECR");
        RewriteRuleTokenStream stream_FAMILY=new RewriteRuleTokenStream(adaptor,"token FAMILY");
        RewriteRuleTokenStream stream_QUERY=new RewriteRuleTokenStream(adaptor,"token QUERY");
        RewriteRuleTokenStream stream_NEXT=new RewriteRuleTokenStream(adaptor,"token NEXT");
        RewriteRuleTokenStream stream_GET=new RewriteRuleTokenStream(adaptor,"token GET");
        RewriteRuleTokenStream stream_PROBABILITY=new RewriteRuleTokenStream(adaptor,"token PROBABILITY");
        RewriteRuleTokenStream stream_USE=new RewriteRuleTokenStream(adaptor,"token USE");
        RewriteRuleTokenStream stream_SHOW=new RewriteRuleTokenStream(adaptor,"token SHOW");

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:174:5: ( HELP HELP -> ^( NODE_HELP NODE_HELP ) | HELP CONNECT -> ^( NODE_HELP NODE_CONNECT ) | HELP USE -> ^( NODE_HELP NODE_USE_TABLE ) | HELP TRACE NEXT QUERY -> ^( NODE_HELP NODE_TRACE_NEXT_QUERY ) | HELP SET TRACE PROBABILITY -> ^( NODE_HELP NODE_SET_TRACE_PROBABILITY ) | HELP DESCRIBE -> ^( NODE_HELP NODE_DESCRIBE ) | HELP DESCRIBE 'CLUSTER' -> ^( NODE_HELP NODE_DESCRIBE_CLUSTER ) | HELP EXIT -> ^( NODE_HELP NODE_EXIT ) | HELP QUIT -> ^( NODE_HELP NODE_EXIT ) | HELP SHOW 'CLUSTER NAME' -> ^( NODE_HELP NODE_SHOW_CLUSTER_NAME ) | HELP SHOW KEYSPACES -> ^( NODE_HELP NODE_SHOW_KEYSPACES ) | HELP SHOW SCHEMA -> ^( NODE_HELP NODE_SHOW_SCHEMA ) | HELP SHOW API_VERSION -> ^( NODE_HELP NODE_SHOW_VERSION ) | HELP CREATE KEYSPACE -> ^( NODE_HELP NODE_ADD_KEYSPACE ) | HELP UPDATE KEYSPACE -> ^( NODE_HELP NODE_UPDATE_KEYSPACE ) | HELP CREATE COLUMN FAMILY -> ^( NODE_HELP NODE_ADD_COLUMN_FAMILY ) | HELP UPDATE COLUMN FAMILY -> ^( NODE_HELP NODE_UPDATE_COLUMN_FAMILY ) | HELP DROP KEYSPACE -> ^( NODE_HELP NODE_DEL_KEYSPACE ) | HELP DROP COLUMN FAMILY -> ^( NODE_HELP NODE_DEL_COLUMN_FAMILY ) | HELP DROP INDEX -> ^( NODE_HELP NODE_DROP_INDEX ) | HELP GET -> ^( NODE_HELP NODE_THRIFT_GET ) | HELP SET -> ^( NODE_HELP NODE_THRIFT_SET ) | HELP INCR -> ^( NODE_HELP NODE_THRIFT_INCR ) | HELP DECR -> ^( NODE_HELP NODE_THRIFT_DECR ) | HELP DEL -> ^( NODE_HELP NODE_THRIFT_DEL ) | HELP COUNT -> ^( NODE_HELP NODE_THRIFT_COUNT ) | HELP LIST -> ^( NODE_HELP NODE_LIST ) | HELP TRUNCATE -> ^( NODE_HELP NODE_TRUNCATE ) | HELP ASSUME -> ^( NODE_HELP NODE_ASSUME ) | HELP CONSISTENCYLEVEL -> ^( NODE_HELP NODE_CONSISTENCY_LEVEL ) | HELP -> ^( NODE_HELP ) | '?' -> ^( NODE_HELP ) )
            int alt6=32;
            alt6 = dfa6.predict(input);
            switch (alt6) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:174:7: HELP HELP
                    {
                    HELP41=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement792); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP41);

                    HELP42=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement794); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP42);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 175:9: -> ^( NODE_HELP NODE_HELP )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:175:12: ^( NODE_HELP NODE_HELP )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:176:7: HELP CONNECT
                    {
                    HELP43=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement819); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP43);

                    CONNECT44=(Token)match(input,CONNECT,FOLLOW_CONNECT_in_helpStatement821); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CONNECT.add(CONNECT44);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 177:9: -> ^( NODE_HELP NODE_CONNECT )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:177:12: ^( NODE_HELP NODE_CONNECT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_CONNECT, "NODE_CONNECT"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 3 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:178:7: HELP USE
                    {
                    HELP45=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement846); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP45);

                    USE46=(Token)match(input,USE,FOLLOW_USE_in_helpStatement848); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_USE.add(USE46);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 179:9: -> ^( NODE_HELP NODE_USE_TABLE )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:179:12: ^( NODE_HELP NODE_USE_TABLE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_USE_TABLE, "NODE_USE_TABLE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 4 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:180:7: HELP TRACE NEXT QUERY
                    {
                    HELP47=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement873); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP47);

                    TRACE48=(Token)match(input,TRACE,FOLLOW_TRACE_in_helpStatement875); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TRACE.add(TRACE48);

                    NEXT49=(Token)match(input,NEXT,FOLLOW_NEXT_in_helpStatement877); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_NEXT.add(NEXT49);

                    QUERY50=(Token)match(input,QUERY,FOLLOW_QUERY_in_helpStatement879); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QUERY.add(QUERY50);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 181:9: -> ^( NODE_HELP NODE_TRACE_NEXT_QUERY )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:181:12: ^( NODE_HELP NODE_TRACE_NEXT_QUERY )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_TRACE_NEXT_QUERY, "NODE_TRACE_NEXT_QUERY"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 5 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:182:7: HELP SET TRACE PROBABILITY
                    {
                    HELP51=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement903); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP51);

                    SET52=(Token)match(input,SET,FOLLOW_SET_in_helpStatement905); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SET.add(SET52);

                    TRACE53=(Token)match(input,TRACE,FOLLOW_TRACE_in_helpStatement907); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TRACE.add(TRACE53);

                    PROBABILITY54=(Token)match(input,PROBABILITY,FOLLOW_PROBABILITY_in_helpStatement909); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_PROBABILITY.add(PROBABILITY54);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 183:9: -> ^( NODE_HELP NODE_SET_TRACE_PROBABILITY )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:183:12: ^( NODE_HELP NODE_SET_TRACE_PROBABILITY )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_SET_TRACE_PROBABILITY, "NODE_SET_TRACE_PROBABILITY"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 6 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:184:7: HELP DESCRIBE
                    {
                    HELP55=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement933); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP55);

                    DESCRIBE56=(Token)match(input,DESCRIBE,FOLLOW_DESCRIBE_in_helpStatement935); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DESCRIBE.add(DESCRIBE56);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 185:9: -> ^( NODE_HELP NODE_DESCRIBE )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:185:12: ^( NODE_HELP NODE_DESCRIBE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_DESCRIBE, "NODE_DESCRIBE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 7 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:186:7: HELP DESCRIBE 'CLUSTER'
                    {
                    HELP57=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement959); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP57);

                    DESCRIBE58=(Token)match(input,DESCRIBE,FOLLOW_DESCRIBE_in_helpStatement961); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DESCRIBE.add(DESCRIBE58);

                    string_literal59=(Token)match(input,112,FOLLOW_112_in_helpStatement963); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_112.add(string_literal59);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 187:9: -> ^( NODE_HELP NODE_DESCRIBE_CLUSTER )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:187:12: ^( NODE_HELP NODE_DESCRIBE_CLUSTER )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_DESCRIBE_CLUSTER, "NODE_DESCRIBE_CLUSTER"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 8 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:188:7: HELP EXIT
                    {
                    HELP60=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement987); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP60);

                    EXIT61=(Token)match(input,EXIT,FOLLOW_EXIT_in_helpStatement989); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EXIT.add(EXIT61);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 189:9: -> ^( NODE_HELP NODE_EXIT )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:189:12: ^( NODE_HELP NODE_EXIT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_EXIT, "NODE_EXIT"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 9 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:190:7: HELP QUIT
                    {
                    HELP62=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1014); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP62);

                    QUIT63=(Token)match(input,QUIT,FOLLOW_QUIT_in_helpStatement1016); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QUIT.add(QUIT63);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 191:9: -> ^( NODE_HELP NODE_EXIT )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:191:12: ^( NODE_HELP NODE_EXIT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_EXIT, "NODE_EXIT"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 10 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:192:7: HELP SHOW 'CLUSTER NAME'
                    {
                    HELP64=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1041); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP64);

                    SHOW65=(Token)match(input,SHOW,FOLLOW_SHOW_in_helpStatement1043); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SHOW.add(SHOW65);

                    string_literal66=(Token)match(input,113,FOLLOW_113_in_helpStatement1045); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_113.add(string_literal66);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 193:9: -> ^( NODE_HELP NODE_SHOW_CLUSTER_NAME )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:193:12: ^( NODE_HELP NODE_SHOW_CLUSTER_NAME )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_SHOW_CLUSTER_NAME, "NODE_SHOW_CLUSTER_NAME"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 11 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:194:7: HELP SHOW KEYSPACES
                    {
                    HELP67=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1069); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP67);

                    SHOW68=(Token)match(input,SHOW,FOLLOW_SHOW_in_helpStatement1071); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SHOW.add(SHOW68);

                    KEYSPACES69=(Token)match(input,KEYSPACES,FOLLOW_KEYSPACES_in_helpStatement1073); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KEYSPACES.add(KEYSPACES69);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 195:9: -> ^( NODE_HELP NODE_SHOW_KEYSPACES )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:195:12: ^( NODE_HELP NODE_SHOW_KEYSPACES )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_SHOW_KEYSPACES, "NODE_SHOW_KEYSPACES"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 12 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:196:7: HELP SHOW SCHEMA
                    {
                    HELP70=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1098); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP70);

                    SHOW71=(Token)match(input,SHOW,FOLLOW_SHOW_in_helpStatement1100); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SHOW.add(SHOW71);

                    SCHEMA72=(Token)match(input,SCHEMA,FOLLOW_SCHEMA_in_helpStatement1102); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SCHEMA.add(SCHEMA72);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 197:13: -> ^( NODE_HELP NODE_SHOW_SCHEMA )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:197:16: ^( NODE_HELP NODE_SHOW_SCHEMA )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_SHOW_SCHEMA, "NODE_SHOW_SCHEMA"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 13 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:198:7: HELP SHOW API_VERSION
                    {
                    HELP73=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1130); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP73);

                    SHOW74=(Token)match(input,SHOW,FOLLOW_SHOW_in_helpStatement1132); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SHOW.add(SHOW74);

                    API_VERSION75=(Token)match(input,API_VERSION,FOLLOW_API_VERSION_in_helpStatement1134); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_API_VERSION.add(API_VERSION75);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 199:9: -> ^( NODE_HELP NODE_SHOW_VERSION )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:199:12: ^( NODE_HELP NODE_SHOW_VERSION )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_SHOW_VERSION, "NODE_SHOW_VERSION"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 14 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:200:7: HELP CREATE KEYSPACE
                    {
                    HELP76=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1158); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP76);

                    CREATE77=(Token)match(input,CREATE,FOLLOW_CREATE_in_helpStatement1160); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CREATE.add(CREATE77);

                    KEYSPACE78=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_helpStatement1162); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE78);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 201:9: -> ^( NODE_HELP NODE_ADD_KEYSPACE )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:201:12: ^( NODE_HELP NODE_ADD_KEYSPACE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_ADD_KEYSPACE, "NODE_ADD_KEYSPACE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 15 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:202:7: HELP UPDATE KEYSPACE
                    {
                    HELP79=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1187); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP79);

                    UPDATE80=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_helpStatement1189); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UPDATE.add(UPDATE80);

                    KEYSPACE81=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_helpStatement1191); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE81);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 203:9: -> ^( NODE_HELP NODE_UPDATE_KEYSPACE )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:203:12: ^( NODE_HELP NODE_UPDATE_KEYSPACE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_UPDATE_KEYSPACE, "NODE_UPDATE_KEYSPACE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 16 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:204:7: HELP CREATE COLUMN FAMILY
                    {
                    HELP82=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1215); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP82);

                    CREATE83=(Token)match(input,CREATE,FOLLOW_CREATE_in_helpStatement1217); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CREATE.add(CREATE83);

                    COLUMN84=(Token)match(input,COLUMN,FOLLOW_COLUMN_in_helpStatement1219); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLUMN.add(COLUMN84);

                    FAMILY85=(Token)match(input,FAMILY,FOLLOW_FAMILY_in_helpStatement1221); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FAMILY.add(FAMILY85);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 205:9: -> ^( NODE_HELP NODE_ADD_COLUMN_FAMILY )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:205:12: ^( NODE_HELP NODE_ADD_COLUMN_FAMILY )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_ADD_COLUMN_FAMILY, "NODE_ADD_COLUMN_FAMILY"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 17 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:206:7: HELP UPDATE COLUMN FAMILY
                    {
                    HELP86=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1246); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP86);

                    UPDATE87=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_helpStatement1248); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_UPDATE.add(UPDATE87);

                    COLUMN88=(Token)match(input,COLUMN,FOLLOW_COLUMN_in_helpStatement1250); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLUMN.add(COLUMN88);

                    FAMILY89=(Token)match(input,FAMILY,FOLLOW_FAMILY_in_helpStatement1252); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FAMILY.add(FAMILY89);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 207:9: -> ^( NODE_HELP NODE_UPDATE_COLUMN_FAMILY )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:207:12: ^( NODE_HELP NODE_UPDATE_COLUMN_FAMILY )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_UPDATE_COLUMN_FAMILY, "NODE_UPDATE_COLUMN_FAMILY"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 18 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:208:7: HELP DROP KEYSPACE
                    {
                    HELP90=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1276); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP90);

                    DROP91=(Token)match(input,DROP,FOLLOW_DROP_in_helpStatement1278); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DROP.add(DROP91);

                    KEYSPACE92=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_helpStatement1280); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE92);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 209:9: -> ^( NODE_HELP NODE_DEL_KEYSPACE )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:209:12: ^( NODE_HELP NODE_DEL_KEYSPACE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_DEL_KEYSPACE, "NODE_DEL_KEYSPACE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 19 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:210:7: HELP DROP COLUMN FAMILY
                    {
                    HELP93=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1305); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP93);

                    DROP94=(Token)match(input,DROP,FOLLOW_DROP_in_helpStatement1307); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DROP.add(DROP94);

                    COLUMN95=(Token)match(input,COLUMN,FOLLOW_COLUMN_in_helpStatement1309); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COLUMN.add(COLUMN95);

                    FAMILY96=(Token)match(input,FAMILY,FOLLOW_FAMILY_in_helpStatement1311); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_FAMILY.add(FAMILY96);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 211:9: -> ^( NODE_HELP NODE_DEL_COLUMN_FAMILY )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:211:12: ^( NODE_HELP NODE_DEL_COLUMN_FAMILY )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_DEL_COLUMN_FAMILY, "NODE_DEL_COLUMN_FAMILY"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 20 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:212:7: HELP DROP INDEX
                    {
                    HELP97=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1336); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP97);

                    DROP98=(Token)match(input,DROP,FOLLOW_DROP_in_helpStatement1338); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DROP.add(DROP98);

                    INDEX99=(Token)match(input,INDEX,FOLLOW_INDEX_in_helpStatement1340); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INDEX.add(INDEX99);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 213:9: -> ^( NODE_HELP NODE_DROP_INDEX )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:213:12: ^( NODE_HELP NODE_DROP_INDEX )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_DROP_INDEX, "NODE_DROP_INDEX"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 21 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:214:7: HELP GET
                    {
                    HELP100=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1364); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP100);

                    GET101=(Token)match(input,GET,FOLLOW_GET_in_helpStatement1366); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GET.add(GET101);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 215:9: -> ^( NODE_HELP NODE_THRIFT_GET )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:215:12: ^( NODE_HELP NODE_THRIFT_GET )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_THRIFT_GET, "NODE_THRIFT_GET"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 22 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:216:7: HELP SET
                    {
                    HELP102=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1391); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP102);

                    SET103=(Token)match(input,SET,FOLLOW_SET_in_helpStatement1393); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_SET.add(SET103);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 217:9: -> ^( NODE_HELP NODE_THRIFT_SET )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:217:12: ^( NODE_HELP NODE_THRIFT_SET )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_THRIFT_SET, "NODE_THRIFT_SET"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 23 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:218:7: HELP INCR
                    {
                    HELP104=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1418); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP104);

                    INCR105=(Token)match(input,INCR,FOLLOW_INCR_in_helpStatement1420); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INCR.add(INCR105);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 219:9: -> ^( NODE_HELP NODE_THRIFT_INCR )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:219:12: ^( NODE_HELP NODE_THRIFT_INCR )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_THRIFT_INCR, "NODE_THRIFT_INCR"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 24 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:220:7: HELP DECR
                    {
                    HELP106=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1444); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP106);

                    DECR107=(Token)match(input,DECR,FOLLOW_DECR_in_helpStatement1446); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DECR.add(DECR107);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 221:9: -> ^( NODE_HELP NODE_THRIFT_DECR )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:221:12: ^( NODE_HELP NODE_THRIFT_DECR )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_THRIFT_DECR, "NODE_THRIFT_DECR"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 25 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:222:7: HELP DEL
                    {
                    HELP108=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1470); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP108);

                    DEL109=(Token)match(input,DEL,FOLLOW_DEL_in_helpStatement1472); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DEL.add(DEL109);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 223:9: -> ^( NODE_HELP NODE_THRIFT_DEL )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:223:12: ^( NODE_HELP NODE_THRIFT_DEL )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_THRIFT_DEL, "NODE_THRIFT_DEL"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 26 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:224:7: HELP COUNT
                    {
                    HELP110=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1497); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP110);

                    COUNT111=(Token)match(input,COUNT,FOLLOW_COUNT_in_helpStatement1499); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_COUNT.add(COUNT111);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 225:9: -> ^( NODE_HELP NODE_THRIFT_COUNT )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:225:12: ^( NODE_HELP NODE_THRIFT_COUNT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_THRIFT_COUNT, "NODE_THRIFT_COUNT"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 27 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:226:7: HELP LIST
                    {
                    HELP112=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1524); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP112);

                    LIST113=(Token)match(input,LIST,FOLLOW_LIST_in_helpStatement1526); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_LIST.add(LIST113);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 227:9: -> ^( NODE_HELP NODE_LIST )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:227:12: ^( NODE_HELP NODE_LIST )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_LIST, "NODE_LIST"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 28 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:228:7: HELP TRUNCATE
                    {
                    HELP114=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1551); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP114);

                    TRUNCATE115=(Token)match(input,TRUNCATE,FOLLOW_TRUNCATE_in_helpStatement1553); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TRUNCATE.add(TRUNCATE115);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 229:9: -> ^( NODE_HELP NODE_TRUNCATE )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:229:12: ^( NODE_HELP NODE_TRUNCATE )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_TRUNCATE, "NODE_TRUNCATE"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 29 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:230:7: HELP ASSUME
                    {
                    HELP116=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1577); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP116);

                    ASSUME117=(Token)match(input,ASSUME,FOLLOW_ASSUME_in_helpStatement1579); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_ASSUME.add(ASSUME117);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 231:9: -> ^( NODE_HELP NODE_ASSUME )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:231:12: ^( NODE_HELP NODE_ASSUME )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_ASSUME, "NODE_ASSUME"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 30 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:232:7: HELP CONSISTENCYLEVEL
                    {
                    HELP118=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1603); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP118);

                    CONSISTENCYLEVEL119=(Token)match(input,CONSISTENCYLEVEL,FOLLOW_CONSISTENCYLEVEL_in_helpStatement1605); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_CONSISTENCYLEVEL.add(CONSISTENCYLEVEL119);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 233:9: -> ^( NODE_HELP NODE_CONSISTENCY_LEVEL )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:233:12: ^( NODE_HELP NODE_CONSISTENCY_LEVEL )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_1, (CommonTree)adaptor.create(NODE_CONSISTENCY_LEVEL, "NODE_CONSISTENCY_LEVEL"));

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 31 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:234:7: HELP
                    {
                    HELP120=(Token)match(input,HELP,FOLLOW_HELP_in_helpStatement1629); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_HELP.add(HELP120);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 235:9: -> ^( NODE_HELP )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:235:12: ^( NODE_HELP )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 32 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:236:7: '?'
                    {
                    char_literal121=(Token)match(input,114,FOLLOW_114_in_helpStatement1652); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_114.add(char_literal121);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 237:9: -> ^( NODE_HELP )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:237:12: ^( NODE_HELP )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_HELP, "NODE_HELP"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "helpStatement"

    public static class exitStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "exitStatement"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:240:1: exitStatement : ( QUIT -> ^( NODE_EXIT ) | EXIT -> ^( NODE_EXIT ) );
    public final CliParser.exitStatement_return exitStatement() throws RecognitionException {
        CliParser.exitStatement_return retval = new CliParser.exitStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token QUIT122=null;
        Token EXIT123=null;

        CommonTree QUIT122_tree=null;
        CommonTree EXIT123_tree=null;
        RewriteRuleTokenStream stream_EXIT=new RewriteRuleTokenStream(adaptor,"token EXIT");
        RewriteRuleTokenStream stream_QUIT=new RewriteRuleTokenStream(adaptor,"token QUIT");

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:241:5: ( QUIT -> ^( NODE_EXIT ) | EXIT -> ^( NODE_EXIT ) )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==QUIT) ) {
                alt7=1;
            }
            else if ( (LA7_0==EXIT) ) {
                alt7=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:241:7: QUIT
                    {
                    QUIT122=(Token)match(input,QUIT,FOLLOW_QUIT_in_exitStatement1687); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_QUIT.add(QUIT122);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 241:12: -> ^( NODE_EXIT )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:241:15: ^( NODE_EXIT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_EXIT, "NODE_EXIT"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:242:7: EXIT
                    {
                    EXIT123=(Token)match(input,EXIT,FOLLOW_EXIT_in_exitStatement1701); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_EXIT.add(EXIT123);



                    // AST REWRITE
                    // elements: 
                    // token labels: 
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 242:12: -> ^( NODE_EXIT )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:242:15: ^( NODE_EXIT )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_EXIT, "NODE_EXIT"), root_1);

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "exitStatement"

    public static class getStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getStatement"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:245:1: getStatement : ( GET columnFamilyExpr ( 'AS' typeIdentifier )? ( 'LIMIT' limit= IntegerPositiveLiteral )? -> ^( NODE_THRIFT_GET columnFamilyExpr ( ^( CONVERT_TO_TYPE typeIdentifier ) )? ( ^( NODE_LIMIT $limit) )? ) | GET columnFamily 'WHERE' getCondition ( 'AND' getCondition )* ( 'LIMIT' limit= IntegerPositiveLiteral )? -> ^( NODE_THRIFT_GET_WITH_CONDITIONS columnFamily ^( CONDITIONS ( getCondition )+ ) ( ^( NODE_LIMIT $limit) )? ) );
    public final CliParser.getStatement_return getStatement() throws RecognitionException {
        CliParser.getStatement_return retval = new CliParser.getStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token limit=null;
        Token GET124=null;
        Token string_literal126=null;
        Token string_literal128=null;
        Token GET129=null;
        Token string_literal131=null;
        Token string_literal133=null;
        Token string_literal135=null;
        CliParser.columnFamilyExpr_return columnFamilyExpr125 = null;

        CliParser.typeIdentifier_return typeIdentifier127 = null;

        CliParser.columnFamily_return columnFamily130 = null;

        CliParser.getCondition_return getCondition132 = null;

        CliParser.getCondition_return getCondition134 = null;


        CommonTree limit_tree=null;
        CommonTree GET124_tree=null;
        CommonTree string_literal126_tree=null;
        CommonTree string_literal128_tree=null;
        CommonTree GET129_tree=null;
        CommonTree string_literal131_tree=null;
        CommonTree string_literal133_tree=null;
        CommonTree string_literal135_tree=null;
        RewriteRuleTokenStream stream_116=new RewriteRuleTokenStream(adaptor,"token 116");
        RewriteRuleTokenStream stream_IntegerPositiveLiteral=new RewriteRuleTokenStream(adaptor,"token IntegerPositiveLiteral");
        RewriteRuleTokenStream stream_115=new RewriteRuleTokenStream(adaptor,"token 115");
        RewriteRuleTokenStream stream_GET=new RewriteRuleTokenStream(adaptor,"token GET");
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_LIMIT=new RewriteRuleTokenStream(adaptor,"token LIMIT");
        RewriteRuleSubtreeStream stream_typeIdentifier=new RewriteRuleSubtreeStream(adaptor,"rule typeIdentifier");
        RewriteRuleSubtreeStream stream_getCondition=new RewriteRuleSubtreeStream(adaptor,"rule getCondition");
        RewriteRuleSubtreeStream stream_columnFamilyExpr=new RewriteRuleSubtreeStream(adaptor,"rule columnFamilyExpr");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:246:5: ( GET columnFamilyExpr ( 'AS' typeIdentifier )? ( 'LIMIT' limit= IntegerPositiveLiteral )? -> ^( NODE_THRIFT_GET columnFamilyExpr ( ^( CONVERT_TO_TYPE typeIdentifier ) )? ( ^( NODE_LIMIT $limit) )? ) | GET columnFamily 'WHERE' getCondition ( 'AND' getCondition )* ( 'LIMIT' limit= IntegerPositiveLiteral )? -> ^( NODE_THRIFT_GET_WITH_CONDITIONS columnFamily ^( CONDITIONS ( getCondition )+ ) ( ^( NODE_LIMIT $limit) )? ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==GET) ) {
                int LA12_1 = input.LA(2);

                if ( ((LA12_1>=IntegerPositiveLiteral && LA12_1<=StringLiteral)||LA12_1==IntegerNegativeLiteral) ) {
                    int LA12_2 = input.LA(3);

                    if ( (LA12_2==123) ) {
                        alt12=1;
                    }
                    else if ( (LA12_2==116) ) {
                        alt12=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return retval;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 2, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 12, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:246:7: GET columnFamilyExpr ( 'AS' typeIdentifier )? ( 'LIMIT' limit= IntegerPositiveLiteral )?
                    {
                    GET124=(Token)match(input,GET,FOLLOW_GET_in_getStatement1724); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GET.add(GET124);

                    pushFollow(FOLLOW_columnFamilyExpr_in_getStatement1726);
                    columnFamilyExpr125=columnFamilyExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_columnFamilyExpr.add(columnFamilyExpr125.getTree());
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:246:28: ( 'AS' typeIdentifier )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0==115) ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:246:29: 'AS' typeIdentifier
                            {
                            string_literal126=(Token)match(input,115,FOLLOW_115_in_getStatement1729); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_115.add(string_literal126);

                            pushFollow(FOLLOW_typeIdentifier_in_getStatement1731);
                            typeIdentifier127=typeIdentifier();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_typeIdentifier.add(typeIdentifier127.getTree());

                            }
                            break;

                    }

                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:246:51: ( 'LIMIT' limit= IntegerPositiveLiteral )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0==LIMIT) ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:246:52: 'LIMIT' limit= IntegerPositiveLiteral
                            {
                            string_literal128=(Token)match(input,LIMIT,FOLLOW_LIMIT_in_getStatement1736); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LIMIT.add(string_literal128);

                            limit=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_getStatement1740); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IntegerPositiveLiteral.add(limit);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: limit, typeIdentifier, columnFamilyExpr
                    // token labels: limit
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_limit=new RewriteRuleTokenStream(adaptor,"token limit",limit);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 247:9: -> ^( NODE_THRIFT_GET columnFamilyExpr ( ^( CONVERT_TO_TYPE typeIdentifier ) )? ( ^( NODE_LIMIT $limit) )? )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:247:12: ^( NODE_THRIFT_GET columnFamilyExpr ( ^( CONVERT_TO_TYPE typeIdentifier ) )? ( ^( NODE_LIMIT $limit) )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_GET, "NODE_THRIFT_GET"), root_1);

                        adaptor.addChild(root_1, stream_columnFamilyExpr.nextTree());
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:247:47: ( ^( CONVERT_TO_TYPE typeIdentifier ) )?
                        if ( stream_typeIdentifier.hasNext() ) {
                            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:247:49: ^( CONVERT_TO_TYPE typeIdentifier )
                            {
                            CommonTree root_2 = (CommonTree)adaptor.nil();
                            root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONVERT_TO_TYPE, "CONVERT_TO_TYPE"), root_2);

                            adaptor.addChild(root_2, stream_typeIdentifier.nextTree());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_typeIdentifier.reset();
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:247:86: ( ^( NODE_LIMIT $limit) )?
                        if ( stream_limit.hasNext() ) {
                            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:247:86: ^( NODE_LIMIT $limit)
                            {
                            CommonTree root_2 = (CommonTree)adaptor.nil();
                            root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_LIMIT, "NODE_LIMIT"), root_2);

                            adaptor.addChild(root_2, stream_limit.nextNode());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_limit.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:248:7: GET columnFamily 'WHERE' getCondition ( 'AND' getCondition )* ( 'LIMIT' limit= IntegerPositiveLiteral )?
                    {
                    GET129=(Token)match(input,GET,FOLLOW_GET_in_getStatement1785); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_GET.add(GET129);

                    pushFollow(FOLLOW_columnFamily_in_getStatement1787);
                    columnFamily130=columnFamily();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily130.getTree());
                    string_literal131=(Token)match(input,116,FOLLOW_116_in_getStatement1789); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_116.add(string_literal131);

                    pushFollow(FOLLOW_getCondition_in_getStatement1791);
                    getCondition132=getCondition();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_getCondition.add(getCondition132.getTree());
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:248:45: ( 'AND' getCondition )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==AND) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:248:46: 'AND' getCondition
                    	    {
                    	    string_literal133=(Token)match(input,AND,FOLLOW_AND_in_getStatement1794); if (state.failed) return retval; 
                    	    if ( state.backtracking==0 ) stream_AND.add(string_literal133);

                    	    pushFollow(FOLLOW_getCondition_in_getStatement1796);
                    	    getCondition134=getCondition();

                    	    state._fsp--;
                    	    if (state.failed) return retval;
                    	    if ( state.backtracking==0 ) stream_getCondition.add(getCondition134.getTree());

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);

                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:248:67: ( 'LIMIT' limit= IntegerPositiveLiteral )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==LIMIT) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:248:68: 'LIMIT' limit= IntegerPositiveLiteral
                            {
                            string_literal135=(Token)match(input,LIMIT,FOLLOW_LIMIT_in_getStatement1801); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_LIMIT.add(string_literal135);

                            limit=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_getStatement1805); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_IntegerPositiveLiteral.add(limit);


                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: limit, getCondition, columnFamily
                    // token labels: limit
                    // rule labels: retval
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleTokenStream stream_limit=new RewriteRuleTokenStream(adaptor,"token limit",limit);
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 249:9: -> ^( NODE_THRIFT_GET_WITH_CONDITIONS columnFamily ^( CONDITIONS ( getCondition )+ ) ( ^( NODE_LIMIT $limit) )? )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:249:12: ^( NODE_THRIFT_GET_WITH_CONDITIONS columnFamily ^( CONDITIONS ( getCondition )+ ) ( ^( NODE_LIMIT $limit) )? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_GET_WITH_CONDITIONS, "NODE_THRIFT_GET_WITH_CONDITIONS"), root_1);

                        adaptor.addChild(root_1, stream_columnFamily.nextTree());
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:249:59: ^( CONDITIONS ( getCondition )+ )
                        {
                        CommonTree root_2 = (CommonTree)adaptor.nil();
                        root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDITIONS, "CONDITIONS"), root_2);

                        if ( !(stream_getCondition.hasNext()) ) {
                            throw new RewriteEarlyExitException();
                        }
                        while ( stream_getCondition.hasNext() ) {
                            adaptor.addChild(root_2, stream_getCondition.nextTree());

                        }
                        stream_getCondition.reset();

                        adaptor.addChild(root_1, root_2);
                        }
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:249:87: ( ^( NODE_LIMIT $limit) )?
                        if ( stream_limit.hasNext() ) {
                            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:249:87: ^( NODE_LIMIT $limit)
                            {
                            CommonTree root_2 = (CommonTree)adaptor.nil();
                            root_2 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_LIMIT, "NODE_LIMIT"), root_2);

                            adaptor.addChild(root_2, stream_limit.nextNode());

                            adaptor.addChild(root_1, root_2);
                            }

                        }
                        stream_limit.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getStatement"

    public static class getCondition_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "getCondition"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:252:1: getCondition : columnOrSuperColumn operator value -> ^( CONDITION operator columnOrSuperColumn value ) ;
    public final CliParser.getCondition_return getCondition() throws RecognitionException {
        CliParser.getCondition_return retval = new CliParser.getCondition_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.columnOrSuperColumn_return columnOrSuperColumn136 = null;

        CliParser.operator_return operator137 = null;

        CliParser.value_return value138 = null;


        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        RewriteRuleSubtreeStream stream_columnOrSuperColumn=new RewriteRuleSubtreeStream(adaptor,"rule columnOrSuperColumn");
        RewriteRuleSubtreeStream stream_operator=new RewriteRuleSubtreeStream(adaptor,"rule operator");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:253:5: ( columnOrSuperColumn operator value -> ^( CONDITION operator columnOrSuperColumn value ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:253:7: columnOrSuperColumn operator value
            {
            pushFollow(FOLLOW_columnOrSuperColumn_in_getCondition1856);
            columnOrSuperColumn136=columnOrSuperColumn();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnOrSuperColumn.add(columnOrSuperColumn136.getTree());
            pushFollow(FOLLOW_operator_in_getCondition1858);
            operator137=operator();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_operator.add(operator137.getTree());
            pushFollow(FOLLOW_value_in_getCondition1860);
            value138=value();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_value.add(value138.getTree());


            // AST REWRITE
            // elements: value, operator, columnOrSuperColumn
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 254:9: -> ^( CONDITION operator columnOrSuperColumn value )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:254:12: ^( CONDITION operator columnOrSuperColumn value )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(CONDITION, "CONDITION"), root_1);

                adaptor.addChild(root_1, stream_operator.nextTree());
                adaptor.addChild(root_1, stream_columnOrSuperColumn.nextTree());
                adaptor.addChild(root_1, stream_value.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "getCondition"

    public static class operator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "operator"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:257:1: operator : ( '=' | '>' | '<' | '>=' | '<=' );
    public final CliParser.operator_return operator() throws RecognitionException {
        CliParser.operator_return retval = new CliParser.operator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set139=null;

        CommonTree set139_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:258:5: ( '=' | '>' | '<' | '>=' | '<=' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set139=(Token)input.LT(1);
            if ( (input.LA(1)>=117 && input.LA(1)<=121) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set139));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "operator"

    public static class typeIdentifier_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "typeIdentifier"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:261:1: typeIdentifier : ( Identifier | StringLiteral | IntegerPositiveLiteral );
    public final CliParser.typeIdentifier_return typeIdentifier() throws RecognitionException {
        CliParser.typeIdentifier_return retval = new CliParser.typeIdentifier_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set140=null;

        CommonTree set140_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:262:5: ( Identifier | StringLiteral | IntegerPositiveLiteral )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set140=(Token)input.LT(1);
            if ( (input.LA(1)>=IntegerPositiveLiteral && input.LA(1)<=StringLiteral) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set140));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "typeIdentifier"

    public static class setStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "setStatement"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:265:1: setStatement : SET columnFamilyExpr '=' objectValue= value ( WITH TTL '=' ttlValue= IntegerPositiveLiteral )? -> ^( NODE_THRIFT_SET columnFamilyExpr $objectValue ( $ttlValue)? ) ;
    public final CliParser.setStatement_return setStatement() throws RecognitionException {
        CliParser.setStatement_return retval = new CliParser.setStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token ttlValue=null;
        Token SET141=null;
        Token char_literal143=null;
        Token WITH144=null;
        Token TTL145=null;
        Token char_literal146=null;
        CliParser.value_return objectValue = null;

        CliParser.columnFamilyExpr_return columnFamilyExpr142 = null;


        CommonTree ttlValue_tree=null;
        CommonTree SET141_tree=null;
        CommonTree char_literal143_tree=null;
        CommonTree WITH144_tree=null;
        CommonTree TTL145_tree=null;
        CommonTree char_literal146_tree=null;
        RewriteRuleTokenStream stream_117=new RewriteRuleTokenStream(adaptor,"token 117");
        RewriteRuleTokenStream stream_IntegerPositiveLiteral=new RewriteRuleTokenStream(adaptor,"token IntegerPositiveLiteral");
        RewriteRuleTokenStream stream_SET=new RewriteRuleTokenStream(adaptor,"token SET");
        RewriteRuleTokenStream stream_WITH=new RewriteRuleTokenStream(adaptor,"token WITH");
        RewriteRuleTokenStream stream_TTL=new RewriteRuleTokenStream(adaptor,"token TTL");
        RewriteRuleSubtreeStream stream_columnFamilyExpr=new RewriteRuleSubtreeStream(adaptor,"rule columnFamilyExpr");
        RewriteRuleSubtreeStream stream_value=new RewriteRuleSubtreeStream(adaptor,"rule value");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:266:5: ( SET columnFamilyExpr '=' objectValue= value ( WITH TTL '=' ttlValue= IntegerPositiveLiteral )? -> ^( NODE_THRIFT_SET columnFamilyExpr $objectValue ( $ttlValue)? ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:266:7: SET columnFamilyExpr '=' objectValue= value ( WITH TTL '=' ttlValue= IntegerPositiveLiteral )?
            {
            SET141=(Token)match(input,SET,FOLLOW_SET_in_setStatement1956); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SET.add(SET141);

            pushFollow(FOLLOW_columnFamilyExpr_in_setStatement1958);
            columnFamilyExpr142=columnFamilyExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamilyExpr.add(columnFamilyExpr142.getTree());
            char_literal143=(Token)match(input,117,FOLLOW_117_in_setStatement1960); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_117.add(char_literal143);

            pushFollow(FOLLOW_value_in_setStatement1964);
            objectValue=value();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_value.add(objectValue.getTree());
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:266:50: ( WITH TTL '=' ttlValue= IntegerPositiveLiteral )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==WITH) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:266:51: WITH TTL '=' ttlValue= IntegerPositiveLiteral
                    {
                    WITH144=(Token)match(input,WITH,FOLLOW_WITH_in_setStatement1967); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_WITH.add(WITH144);

                    TTL145=(Token)match(input,TTL,FOLLOW_TTL_in_setStatement1969); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_TTL.add(TTL145);

                    char_literal146=(Token)match(input,117,FOLLOW_117_in_setStatement1971); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_117.add(char_literal146);

                    ttlValue=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_setStatement1975); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_IntegerPositiveLiteral.add(ttlValue);


                    }
                    break;

            }



            // AST REWRITE
            // elements: columnFamilyExpr, objectValue, ttlValue
            // token labels: ttlValue
            // rule labels: retval, objectValue
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_ttlValue=new RewriteRuleTokenStream(adaptor,"token ttlValue",ttlValue);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_objectValue=new RewriteRuleSubtreeStream(adaptor,"rule objectValue",objectValue!=null?objectValue.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 267:9: -> ^( NODE_THRIFT_SET columnFamilyExpr $objectValue ( $ttlValue)? )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:267:12: ^( NODE_THRIFT_SET columnFamilyExpr $objectValue ( $ttlValue)? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_SET, "NODE_THRIFT_SET"), root_1);

                adaptor.addChild(root_1, stream_columnFamilyExpr.nextTree());
                adaptor.addChild(root_1, stream_objectValue.nextTree());
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:267:60: ( $ttlValue)?
                if ( stream_ttlValue.hasNext() ) {
                    adaptor.addChild(root_1, stream_ttlValue.nextNode());

                }
                stream_ttlValue.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "setStatement"

    public static class incrStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "incrStatement"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:270:1: incrStatement : ( INCR columnFamilyExpr ( BY byValue= incrementValue )? -> ^( NODE_THRIFT_INCR columnFamilyExpr ( $byValue)? ) | DECR columnFamilyExpr ( BY byValue= incrementValue )? -> ^( NODE_THRIFT_DECR columnFamilyExpr ( $byValue)? ) );
    public final CliParser.incrStatement_return incrStatement() throws RecognitionException {
        CliParser.incrStatement_return retval = new CliParser.incrStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token INCR147=null;
        Token BY149=null;
        Token DECR150=null;
        Token BY152=null;
        CliParser.incrementValue_return byValue = null;

        CliParser.columnFamilyExpr_return columnFamilyExpr148 = null;

        CliParser.columnFamilyExpr_return columnFamilyExpr151 = null;


        CommonTree INCR147_tree=null;
        CommonTree BY149_tree=null;
        CommonTree DECR150_tree=null;
        CommonTree BY152_tree=null;
        RewriteRuleTokenStream stream_DECR=new RewriteRuleTokenStream(adaptor,"token DECR");
        RewriteRuleTokenStream stream_BY=new RewriteRuleTokenStream(adaptor,"token BY");
        RewriteRuleTokenStream stream_INCR=new RewriteRuleTokenStream(adaptor,"token INCR");
        RewriteRuleSubtreeStream stream_columnFamilyExpr=new RewriteRuleSubtreeStream(adaptor,"rule columnFamilyExpr");
        RewriteRuleSubtreeStream stream_incrementValue=new RewriteRuleSubtreeStream(adaptor,"rule incrementValue");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:271:5: ( INCR columnFamilyExpr ( BY byValue= incrementValue )? -> ^( NODE_THRIFT_INCR columnFamilyExpr ( $byValue)? ) | DECR columnFamilyExpr ( BY byValue= incrementValue )? -> ^( NODE_THRIFT_DECR columnFamilyExpr ( $byValue)? ) )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==INCR) ) {
                alt16=1;
            }
            else if ( (LA16_0==DECR) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:271:7: INCR columnFamilyExpr ( BY byValue= incrementValue )?
                    {
                    INCR147=(Token)match(input,INCR,FOLLOW_INCR_in_incrStatement2021); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_INCR.add(INCR147);

                    pushFollow(FOLLOW_columnFamilyExpr_in_incrStatement2023);
                    columnFamilyExpr148=columnFamilyExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_columnFamilyExpr.add(columnFamilyExpr148.getTree());
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:271:29: ( BY byValue= incrementValue )?
                    int alt14=2;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==BY) ) {
                        alt14=1;
                    }
                    switch (alt14) {
                        case 1 :
                            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:271:30: BY byValue= incrementValue
                            {
                            BY149=(Token)match(input,BY,FOLLOW_BY_in_incrStatement2026); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_BY.add(BY149);

                            pushFollow(FOLLOW_incrementValue_in_incrStatement2030);
                            byValue=incrementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_incrementValue.add(byValue.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: columnFamilyExpr, byValue
                    // token labels: 
                    // rule labels: retval, byValue
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_byValue=new RewriteRuleSubtreeStream(adaptor,"rule byValue",byValue!=null?byValue.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 272:9: -> ^( NODE_THRIFT_INCR columnFamilyExpr ( $byValue)? )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:272:12: ^( NODE_THRIFT_INCR columnFamilyExpr ( $byValue)? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_INCR, "NODE_THRIFT_INCR"), root_1);

                        adaptor.addChild(root_1, stream_columnFamilyExpr.nextTree());
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:272:48: ( $byValue)?
                        if ( stream_byValue.hasNext() ) {
                            adaptor.addChild(root_1, stream_byValue.nextTree());

                        }
                        stream_byValue.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;
                case 2 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:273:7: DECR columnFamilyExpr ( BY byValue= incrementValue )?
                    {
                    DECR150=(Token)match(input,DECR,FOLLOW_DECR_in_incrStatement2064); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_DECR.add(DECR150);

                    pushFollow(FOLLOW_columnFamilyExpr_in_incrStatement2066);
                    columnFamilyExpr151=columnFamilyExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_columnFamilyExpr.add(columnFamilyExpr151.getTree());
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:273:29: ( BY byValue= incrementValue )?
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==BY) ) {
                        alt15=1;
                    }
                    switch (alt15) {
                        case 1 :
                            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:273:30: BY byValue= incrementValue
                            {
                            BY152=(Token)match(input,BY,FOLLOW_BY_in_incrStatement2069); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_BY.add(BY152);

                            pushFollow(FOLLOW_incrementValue_in_incrStatement2073);
                            byValue=incrementValue();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_incrementValue.add(byValue.getTree());

                            }
                            break;

                    }



                    // AST REWRITE
                    // elements: byValue, columnFamilyExpr
                    // token labels: 
                    // rule labels: retval, byValue
                    // token list labels: 
                    // rule list labels: 
                    // wildcard labels: 
                    if ( state.backtracking==0 ) {
                    retval.tree = root_0;
                    RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
                    RewriteRuleSubtreeStream stream_byValue=new RewriteRuleSubtreeStream(adaptor,"rule byValue",byValue!=null?byValue.tree:null);

                    root_0 = (CommonTree)adaptor.nil();
                    // 274:9: -> ^( NODE_THRIFT_DECR columnFamilyExpr ( $byValue)? )
                    {
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:274:12: ^( NODE_THRIFT_DECR columnFamilyExpr ( $byValue)? )
                        {
                        CommonTree root_1 = (CommonTree)adaptor.nil();
                        root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_DECR, "NODE_THRIFT_DECR"), root_1);

                        adaptor.addChild(root_1, stream_columnFamilyExpr.nextTree());
                        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:274:48: ( $byValue)?
                        if ( stream_byValue.hasNext() ) {
                            adaptor.addChild(root_1, stream_byValue.nextTree());

                        }
                        stream_byValue.reset();

                        adaptor.addChild(root_0, root_1);
                        }

                    }

                    retval.tree = root_0;}
                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "incrStatement"

    public static class countStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "countStatement"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:277:1: countStatement : COUNT columnFamilyExpr -> ^( NODE_THRIFT_COUNT columnFamilyExpr ) ;
    public final CliParser.countStatement_return countStatement() throws RecognitionException {
        CliParser.countStatement_return retval = new CliParser.countStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token COUNT153=null;
        CliParser.columnFamilyExpr_return columnFamilyExpr154 = null;


        CommonTree COUNT153_tree=null;
        RewriteRuleTokenStream stream_COUNT=new RewriteRuleTokenStream(adaptor,"token COUNT");
        RewriteRuleSubtreeStream stream_columnFamilyExpr=new RewriteRuleSubtreeStream(adaptor,"rule columnFamilyExpr");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:278:5: ( COUNT columnFamilyExpr -> ^( NODE_THRIFT_COUNT columnFamilyExpr ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:278:7: COUNT columnFamilyExpr
            {
            COUNT153=(Token)match(input,COUNT,FOLLOW_COUNT_in_countStatement2116); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COUNT.add(COUNT153);

            pushFollow(FOLLOW_columnFamilyExpr_in_countStatement2118);
            columnFamilyExpr154=columnFamilyExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamilyExpr.add(columnFamilyExpr154.getTree());


            // AST REWRITE
            // elements: columnFamilyExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 279:9: -> ^( NODE_THRIFT_COUNT columnFamilyExpr )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:279:12: ^( NODE_THRIFT_COUNT columnFamilyExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_COUNT, "NODE_THRIFT_COUNT"), root_1);

                adaptor.addChild(root_1, stream_columnFamilyExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "countStatement"

    public static class delStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delStatement"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:282:1: delStatement : DEL columnFamilyExpr -> ^( NODE_THRIFT_DEL columnFamilyExpr ) ;
    public final CliParser.delStatement_return delStatement() throws RecognitionException {
        CliParser.delStatement_return retval = new CliParser.delStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DEL155=null;
        CliParser.columnFamilyExpr_return columnFamilyExpr156 = null;


        CommonTree DEL155_tree=null;
        RewriteRuleTokenStream stream_DEL=new RewriteRuleTokenStream(adaptor,"token DEL");
        RewriteRuleSubtreeStream stream_columnFamilyExpr=new RewriteRuleSubtreeStream(adaptor,"rule columnFamilyExpr");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:283:5: ( DEL columnFamilyExpr -> ^( NODE_THRIFT_DEL columnFamilyExpr ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:283:7: DEL columnFamilyExpr
            {
            DEL155=(Token)match(input,DEL,FOLLOW_DEL_in_delStatement2152); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DEL.add(DEL155);

            pushFollow(FOLLOW_columnFamilyExpr_in_delStatement2154);
            columnFamilyExpr156=columnFamilyExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamilyExpr.add(columnFamilyExpr156.getTree());


            // AST REWRITE
            // elements: columnFamilyExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 284:9: -> ^( NODE_THRIFT_DEL columnFamilyExpr )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:284:12: ^( NODE_THRIFT_DEL columnFamilyExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_THRIFT_DEL, "NODE_THRIFT_DEL"), root_1);

                adaptor.addChild(root_1, stream_columnFamilyExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "delStatement"

    public static class showStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "showStatement"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:287:1: showStatement : ( showClusterName | showVersion | showKeyspaces | showSchema );
    public final CliParser.showStatement_return showStatement() throws RecognitionException {
        CliParser.showStatement_return retval = new CliParser.showStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.showClusterName_return showClusterName157 = null;

        CliParser.showVersion_return showVersion158 = null;

        CliParser.showKeyspaces_return showKeyspaces159 = null;

        CliParser.showSchema_return showSchema160 = null;



        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:288:5: ( showClusterName | showVersion | showKeyspaces | showSchema )
            int alt17=4;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==SHOW) ) {
                switch ( input.LA(2) ) {
                case 113:
                    {
                    alt17=1;
                    }
                    break;
                case API_VERSION:
                    {
                    alt17=2;
                    }
                    break;
                case KEYSPACES:
                    {
                    alt17=3;
                    }
                    break;
                case SCHEMA:
                    {
                    alt17=4;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 17, 1, input);

                    throw nvae;
                }

            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:288:7: showClusterName
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_showClusterName_in_showStatement2188);
                    showClusterName157=showClusterName();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, showClusterName157.getTree());

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:289:7: showVersion
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_showVersion_in_showStatement2196);
                    showVersion158=showVersion();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, showVersion158.getTree());

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:290:7: showKeyspaces
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_showKeyspaces_in_showStatement2204);
                    showKeyspaces159=showKeyspaces();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, showKeyspaces159.getTree());

                    }
                    break;
                case 4 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:291:7: showSchema
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_showSchema_in_showStatement2212);
                    showSchema160=showSchema();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, showSchema160.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "showStatement"

    public static class listStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "listStatement"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:294:1: listStatement : LIST columnFamily ( keyRangeExpr )? ( rowLimitExpr )? ( columnLimitExpr )? -> ^( NODE_LIST columnFamily ( keyRangeExpr )? ( rowLimitExpr )? ( columnLimitExpr )? ) ;
    public final CliParser.listStatement_return listStatement() throws RecognitionException {
        CliParser.listStatement_return retval = new CliParser.listStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token LIST161=null;
        CliParser.columnFamily_return columnFamily162 = null;

        CliParser.keyRangeExpr_return keyRangeExpr163 = null;

        CliParser.rowLimitExpr_return rowLimitExpr164 = null;

        CliParser.columnLimitExpr_return columnLimitExpr165 = null;


        CommonTree LIST161_tree=null;
        RewriteRuleTokenStream stream_LIST=new RewriteRuleTokenStream(adaptor,"token LIST");
        RewriteRuleSubtreeStream stream_rowLimitExpr=new RewriteRuleSubtreeStream(adaptor,"rule rowLimitExpr");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        RewriteRuleSubtreeStream stream_columnLimitExpr=new RewriteRuleSubtreeStream(adaptor,"rule columnLimitExpr");
        RewriteRuleSubtreeStream stream_keyRangeExpr=new RewriteRuleSubtreeStream(adaptor,"rule keyRangeExpr");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:295:5: ( LIST columnFamily ( keyRangeExpr )? ( rowLimitExpr )? ( columnLimitExpr )? -> ^( NODE_LIST columnFamily ( keyRangeExpr )? ( rowLimitExpr )? ( columnLimitExpr )? ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:295:7: LIST columnFamily ( keyRangeExpr )? ( rowLimitExpr )? ( columnLimitExpr )?
            {
            LIST161=(Token)match(input,LIST,FOLLOW_LIST_in_listStatement2229); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LIST.add(LIST161);

            pushFollow(FOLLOW_columnFamily_in_listStatement2231);
            columnFamily162=columnFamily();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily162.getTree());
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:295:25: ( keyRangeExpr )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==123) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:0:0: keyRangeExpr
                    {
                    pushFollow(FOLLOW_keyRangeExpr_in_listStatement2233);
                    keyRangeExpr163=keyRangeExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_keyRangeExpr.add(keyRangeExpr163.getTree());

                    }
                    break;

            }

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:295:39: ( rowLimitExpr )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==LIMIT) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:0:0: rowLimitExpr
                    {
                    pushFollow(FOLLOW_rowLimitExpr_in_listStatement2236);
                    rowLimitExpr164=rowLimitExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_rowLimitExpr.add(rowLimitExpr164.getTree());

                    }
                    break;

            }

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:295:53: ( columnLimitExpr )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==129) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:0:0: columnLimitExpr
                    {
                    pushFollow(FOLLOW_columnLimitExpr_in_listStatement2239);
                    columnLimitExpr165=columnLimitExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_columnLimitExpr.add(columnLimitExpr165.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: rowLimitExpr, columnLimitExpr, columnFamily, keyRangeExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 296:9: -> ^( NODE_LIST columnFamily ( keyRangeExpr )? ( rowLimitExpr )? ( columnLimitExpr )? )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:296:12: ^( NODE_LIST columnFamily ( keyRangeExpr )? ( rowLimitExpr )? ( columnLimitExpr )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_LIST, "NODE_LIST"), root_1);

                adaptor.addChild(root_1, stream_columnFamily.nextTree());
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:296:37: ( keyRangeExpr )?
                if ( stream_keyRangeExpr.hasNext() ) {
                    adaptor.addChild(root_1, stream_keyRangeExpr.nextTree());

                }
                stream_keyRangeExpr.reset();
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:296:51: ( rowLimitExpr )?
                if ( stream_rowLimitExpr.hasNext() ) {
                    adaptor.addChild(root_1, stream_rowLimitExpr.nextTree());

                }
                stream_rowLimitExpr.reset();
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:296:65: ( columnLimitExpr )?
                if ( stream_columnLimitExpr.hasNext() ) {
                    adaptor.addChild(root_1, stream_columnLimitExpr.nextTree());

                }
                stream_columnLimitExpr.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "listStatement"

    public static class truncateStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "truncateStatement"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:299:1: truncateStatement : TRUNCATE columnFamily -> ^( NODE_TRUNCATE columnFamily ) ;
    public final CliParser.truncateStatement_return truncateStatement() throws RecognitionException {
        CliParser.truncateStatement_return retval = new CliParser.truncateStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TRUNCATE166=null;
        CliParser.columnFamily_return columnFamily167 = null;


        CommonTree TRUNCATE166_tree=null;
        RewriteRuleTokenStream stream_TRUNCATE=new RewriteRuleTokenStream(adaptor,"token TRUNCATE");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:300:5: ( TRUNCATE columnFamily -> ^( NODE_TRUNCATE columnFamily ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:300:7: TRUNCATE columnFamily
            {
            TRUNCATE166=(Token)match(input,TRUNCATE,FOLLOW_TRUNCATE_in_truncateStatement2282); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TRUNCATE.add(TRUNCATE166);

            pushFollow(FOLLOW_columnFamily_in_truncateStatement2284);
            columnFamily167=columnFamily();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily167.getTree());


            // AST REWRITE
            // elements: columnFamily
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 301:9: -> ^( NODE_TRUNCATE columnFamily )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:301:12: ^( NODE_TRUNCATE columnFamily )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_TRUNCATE, "NODE_TRUNCATE"), root_1);

                adaptor.addChild(root_1, stream_columnFamily.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "truncateStatement"

    public static class assumeStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "assumeStatement"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:304:1: assumeStatement : ASSUME columnFamily assumptionElement= Identifier 'AS' entityName -> ^( NODE_ASSUME columnFamily $assumptionElement entityName ) ;
    public final CliParser.assumeStatement_return assumeStatement() throws RecognitionException {
        CliParser.assumeStatement_return retval = new CliParser.assumeStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token assumptionElement=null;
        Token ASSUME168=null;
        Token string_literal170=null;
        CliParser.columnFamily_return columnFamily169 = null;

        CliParser.entityName_return entityName171 = null;


        CommonTree assumptionElement_tree=null;
        CommonTree ASSUME168_tree=null;
        CommonTree string_literal170_tree=null;
        RewriteRuleTokenStream stream_115=new RewriteRuleTokenStream(adaptor,"token 115");
        RewriteRuleTokenStream stream_ASSUME=new RewriteRuleTokenStream(adaptor,"token ASSUME");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        RewriteRuleSubtreeStream stream_entityName=new RewriteRuleSubtreeStream(adaptor,"rule entityName");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:305:5: ( ASSUME columnFamily assumptionElement= Identifier 'AS' entityName -> ^( NODE_ASSUME columnFamily $assumptionElement entityName ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:305:7: ASSUME columnFamily assumptionElement= Identifier 'AS' entityName
            {
            ASSUME168=(Token)match(input,ASSUME,FOLLOW_ASSUME_in_assumeStatement2317); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ASSUME.add(ASSUME168);

            pushFollow(FOLLOW_columnFamily_in_assumeStatement2319);
            columnFamily169=columnFamily();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily169.getTree());
            assumptionElement=(Token)match(input,Identifier,FOLLOW_Identifier_in_assumeStatement2323); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Identifier.add(assumptionElement);

            string_literal170=(Token)match(input,115,FOLLOW_115_in_assumeStatement2325); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_115.add(string_literal170);

            pushFollow(FOLLOW_entityName_in_assumeStatement2327);
            entityName171=entityName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_entityName.add(entityName171.getTree());


            // AST REWRITE
            // elements: assumptionElement, columnFamily, entityName
            // token labels: assumptionElement
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_assumptionElement=new RewriteRuleTokenStream(adaptor,"token assumptionElement",assumptionElement);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 306:9: -> ^( NODE_ASSUME columnFamily $assumptionElement entityName )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:306:12: ^( NODE_ASSUME columnFamily $assumptionElement entityName )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_ASSUME, "NODE_ASSUME"), root_1);

                adaptor.addChild(root_1, stream_columnFamily.nextTree());
                adaptor.addChild(root_1, stream_assumptionElement.nextNode());
                adaptor.addChild(root_1, stream_entityName.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assumeStatement"

    public static class consistencyLevelStatement_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "consistencyLevelStatement"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:309:1: consistencyLevelStatement : CONSISTENCYLEVEL 'AS' defaultType= Identifier -> ^( NODE_CONSISTENCY_LEVEL $defaultType) ;
    public final CliParser.consistencyLevelStatement_return consistencyLevelStatement() throws RecognitionException {
        CliParser.consistencyLevelStatement_return retval = new CliParser.consistencyLevelStatement_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token defaultType=null;
        Token CONSISTENCYLEVEL172=null;
        Token string_literal173=null;

        CommonTree defaultType_tree=null;
        CommonTree CONSISTENCYLEVEL172_tree=null;
        CommonTree string_literal173_tree=null;
        RewriteRuleTokenStream stream_115=new RewriteRuleTokenStream(adaptor,"token 115");
        RewriteRuleTokenStream stream_CONSISTENCYLEVEL=new RewriteRuleTokenStream(adaptor,"token CONSISTENCYLEVEL");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:310:5: ( CONSISTENCYLEVEL 'AS' defaultType= Identifier -> ^( NODE_CONSISTENCY_LEVEL $defaultType) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:310:7: CONSISTENCYLEVEL 'AS' defaultType= Identifier
            {
            CONSISTENCYLEVEL172=(Token)match(input,CONSISTENCYLEVEL,FOLLOW_CONSISTENCYLEVEL_in_consistencyLevelStatement2365); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CONSISTENCYLEVEL.add(CONSISTENCYLEVEL172);

            string_literal173=(Token)match(input,115,FOLLOW_115_in_consistencyLevelStatement2367); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_115.add(string_literal173);

            defaultType=(Token)match(input,Identifier,FOLLOW_Identifier_in_consistencyLevelStatement2371); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Identifier.add(defaultType);



            // AST REWRITE
            // elements: defaultType
            // token labels: defaultType
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_defaultType=new RewriteRuleTokenStream(adaptor,"token defaultType",defaultType);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 311:9: -> ^( NODE_CONSISTENCY_LEVEL $defaultType)
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:311:12: ^( NODE_CONSISTENCY_LEVEL $defaultType)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_CONSISTENCY_LEVEL, "NODE_CONSISTENCY_LEVEL"), root_1);

                adaptor.addChild(root_1, stream_defaultType.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "consistencyLevelStatement"

    public static class showClusterName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "showClusterName"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:314:1: showClusterName : SHOW 'CLUSTER NAME' -> ^( NODE_SHOW_CLUSTER_NAME ) ;
    public final CliParser.showClusterName_return showClusterName() throws RecognitionException {
        CliParser.showClusterName_return retval = new CliParser.showClusterName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SHOW174=null;
        Token string_literal175=null;

        CommonTree SHOW174_tree=null;
        CommonTree string_literal175_tree=null;
        RewriteRuleTokenStream stream_113=new RewriteRuleTokenStream(adaptor,"token 113");
        RewriteRuleTokenStream stream_SHOW=new RewriteRuleTokenStream(adaptor,"token SHOW");

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:315:5: ( SHOW 'CLUSTER NAME' -> ^( NODE_SHOW_CLUSTER_NAME ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:315:7: SHOW 'CLUSTER NAME'
            {
            SHOW174=(Token)match(input,SHOW,FOLLOW_SHOW_in_showClusterName2405); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SHOW.add(SHOW174);

            string_literal175=(Token)match(input,113,FOLLOW_113_in_showClusterName2407); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_113.add(string_literal175);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 316:9: -> ^( NODE_SHOW_CLUSTER_NAME )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:316:12: ^( NODE_SHOW_CLUSTER_NAME )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_SHOW_CLUSTER_NAME, "NODE_SHOW_CLUSTER_NAME"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "showClusterName"

    public static class addKeyspace_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "addKeyspace"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:319:1: addKeyspace : CREATE KEYSPACE keyValuePairExpr -> ^( NODE_ADD_KEYSPACE keyValuePairExpr ) ;
    public final CliParser.addKeyspace_return addKeyspace() throws RecognitionException {
        CliParser.addKeyspace_return retval = new CliParser.addKeyspace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CREATE176=null;
        Token KEYSPACE177=null;
        CliParser.keyValuePairExpr_return keyValuePairExpr178 = null;


        CommonTree CREATE176_tree=null;
        CommonTree KEYSPACE177_tree=null;
        RewriteRuleTokenStream stream_CREATE=new RewriteRuleTokenStream(adaptor,"token CREATE");
        RewriteRuleTokenStream stream_KEYSPACE=new RewriteRuleTokenStream(adaptor,"token KEYSPACE");
        RewriteRuleSubtreeStream stream_keyValuePairExpr=new RewriteRuleSubtreeStream(adaptor,"rule keyValuePairExpr");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:320:5: ( CREATE KEYSPACE keyValuePairExpr -> ^( NODE_ADD_KEYSPACE keyValuePairExpr ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:320:7: CREATE KEYSPACE keyValuePairExpr
            {
            CREATE176=(Token)match(input,CREATE,FOLLOW_CREATE_in_addKeyspace2438); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CREATE.add(CREATE176);

            KEYSPACE177=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_addKeyspace2440); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE177);

            pushFollow(FOLLOW_keyValuePairExpr_in_addKeyspace2442);
            keyValuePairExpr178=keyValuePairExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyValuePairExpr.add(keyValuePairExpr178.getTree());


            // AST REWRITE
            // elements: keyValuePairExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 321:9: -> ^( NODE_ADD_KEYSPACE keyValuePairExpr )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:321:12: ^( NODE_ADD_KEYSPACE keyValuePairExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_ADD_KEYSPACE, "NODE_ADD_KEYSPACE"), root_1);

                adaptor.addChild(root_1, stream_keyValuePairExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "addKeyspace"

    public static class addColumnFamily_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "addColumnFamily"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:324:1: addColumnFamily : CREATE COLUMN FAMILY keyValuePairExpr -> ^( NODE_ADD_COLUMN_FAMILY keyValuePairExpr ) ;
    public final CliParser.addColumnFamily_return addColumnFamily() throws RecognitionException {
        CliParser.addColumnFamily_return retval = new CliParser.addColumnFamily_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token CREATE179=null;
        Token COLUMN180=null;
        Token FAMILY181=null;
        CliParser.keyValuePairExpr_return keyValuePairExpr182 = null;


        CommonTree CREATE179_tree=null;
        CommonTree COLUMN180_tree=null;
        CommonTree FAMILY181_tree=null;
        RewriteRuleTokenStream stream_FAMILY=new RewriteRuleTokenStream(adaptor,"token FAMILY");
        RewriteRuleTokenStream stream_CREATE=new RewriteRuleTokenStream(adaptor,"token CREATE");
        RewriteRuleTokenStream stream_COLUMN=new RewriteRuleTokenStream(adaptor,"token COLUMN");
        RewriteRuleSubtreeStream stream_keyValuePairExpr=new RewriteRuleSubtreeStream(adaptor,"rule keyValuePairExpr");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:325:5: ( CREATE COLUMN FAMILY keyValuePairExpr -> ^( NODE_ADD_COLUMN_FAMILY keyValuePairExpr ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:325:7: CREATE COLUMN FAMILY keyValuePairExpr
            {
            CREATE179=(Token)match(input,CREATE,FOLLOW_CREATE_in_addColumnFamily2476); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_CREATE.add(CREATE179);

            COLUMN180=(Token)match(input,COLUMN,FOLLOW_COLUMN_in_addColumnFamily2478); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLUMN.add(COLUMN180);

            FAMILY181=(Token)match(input,FAMILY,FOLLOW_FAMILY_in_addColumnFamily2480); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FAMILY.add(FAMILY181);

            pushFollow(FOLLOW_keyValuePairExpr_in_addColumnFamily2482);
            keyValuePairExpr182=keyValuePairExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyValuePairExpr.add(keyValuePairExpr182.getTree());


            // AST REWRITE
            // elements: keyValuePairExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 326:9: -> ^( NODE_ADD_COLUMN_FAMILY keyValuePairExpr )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:326:12: ^( NODE_ADD_COLUMN_FAMILY keyValuePairExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_ADD_COLUMN_FAMILY, "NODE_ADD_COLUMN_FAMILY"), root_1);

                adaptor.addChild(root_1, stream_keyValuePairExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "addColumnFamily"

    public static class updateKeyspace_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "updateKeyspace"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:329:1: updateKeyspace : UPDATE KEYSPACE keyValuePairExpr -> ^( NODE_UPDATE_KEYSPACE keyValuePairExpr ) ;
    public final CliParser.updateKeyspace_return updateKeyspace() throws RecognitionException {
        CliParser.updateKeyspace_return retval = new CliParser.updateKeyspace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token UPDATE183=null;
        Token KEYSPACE184=null;
        CliParser.keyValuePairExpr_return keyValuePairExpr185 = null;


        CommonTree UPDATE183_tree=null;
        CommonTree KEYSPACE184_tree=null;
        RewriteRuleTokenStream stream_UPDATE=new RewriteRuleTokenStream(adaptor,"token UPDATE");
        RewriteRuleTokenStream stream_KEYSPACE=new RewriteRuleTokenStream(adaptor,"token KEYSPACE");
        RewriteRuleSubtreeStream stream_keyValuePairExpr=new RewriteRuleSubtreeStream(adaptor,"rule keyValuePairExpr");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:330:5: ( UPDATE KEYSPACE keyValuePairExpr -> ^( NODE_UPDATE_KEYSPACE keyValuePairExpr ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:330:7: UPDATE KEYSPACE keyValuePairExpr
            {
            UPDATE183=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_updateKeyspace2516); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_UPDATE.add(UPDATE183);

            KEYSPACE184=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_updateKeyspace2518); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE184);

            pushFollow(FOLLOW_keyValuePairExpr_in_updateKeyspace2520);
            keyValuePairExpr185=keyValuePairExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyValuePairExpr.add(keyValuePairExpr185.getTree());


            // AST REWRITE
            // elements: keyValuePairExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 331:9: -> ^( NODE_UPDATE_KEYSPACE keyValuePairExpr )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:331:12: ^( NODE_UPDATE_KEYSPACE keyValuePairExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_UPDATE_KEYSPACE, "NODE_UPDATE_KEYSPACE"), root_1);

                adaptor.addChild(root_1, stream_keyValuePairExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "updateKeyspace"

    public static class updateColumnFamily_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "updateColumnFamily"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:334:1: updateColumnFamily : UPDATE COLUMN FAMILY keyValuePairExpr -> ^( NODE_UPDATE_COLUMN_FAMILY keyValuePairExpr ) ;
    public final CliParser.updateColumnFamily_return updateColumnFamily() throws RecognitionException {
        CliParser.updateColumnFamily_return retval = new CliParser.updateColumnFamily_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token UPDATE186=null;
        Token COLUMN187=null;
        Token FAMILY188=null;
        CliParser.keyValuePairExpr_return keyValuePairExpr189 = null;


        CommonTree UPDATE186_tree=null;
        CommonTree COLUMN187_tree=null;
        CommonTree FAMILY188_tree=null;
        RewriteRuleTokenStream stream_FAMILY=new RewriteRuleTokenStream(adaptor,"token FAMILY");
        RewriteRuleTokenStream stream_UPDATE=new RewriteRuleTokenStream(adaptor,"token UPDATE");
        RewriteRuleTokenStream stream_COLUMN=new RewriteRuleTokenStream(adaptor,"token COLUMN");
        RewriteRuleSubtreeStream stream_keyValuePairExpr=new RewriteRuleSubtreeStream(adaptor,"rule keyValuePairExpr");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:335:5: ( UPDATE COLUMN FAMILY keyValuePairExpr -> ^( NODE_UPDATE_COLUMN_FAMILY keyValuePairExpr ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:335:7: UPDATE COLUMN FAMILY keyValuePairExpr
            {
            UPDATE186=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_updateColumnFamily2553); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_UPDATE.add(UPDATE186);

            COLUMN187=(Token)match(input,COLUMN,FOLLOW_COLUMN_in_updateColumnFamily2555); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLUMN.add(COLUMN187);

            FAMILY188=(Token)match(input,FAMILY,FOLLOW_FAMILY_in_updateColumnFamily2557); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FAMILY.add(FAMILY188);

            pushFollow(FOLLOW_keyValuePairExpr_in_updateColumnFamily2559);
            keyValuePairExpr189=keyValuePairExpr();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyValuePairExpr.add(keyValuePairExpr189.getTree());


            // AST REWRITE
            // elements: keyValuePairExpr
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 336:9: -> ^( NODE_UPDATE_COLUMN_FAMILY keyValuePairExpr )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:336:12: ^( NODE_UPDATE_COLUMN_FAMILY keyValuePairExpr )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_UPDATE_COLUMN_FAMILY, "NODE_UPDATE_COLUMN_FAMILY"), root_1);

                adaptor.addChild(root_1, stream_keyValuePairExpr.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "updateColumnFamily"

    public static class delKeyspace_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delKeyspace"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:339:1: delKeyspace : DROP KEYSPACE keyspace -> ^( NODE_DEL_KEYSPACE keyspace ) ;
    public final CliParser.delKeyspace_return delKeyspace() throws RecognitionException {
        CliParser.delKeyspace_return retval = new CliParser.delKeyspace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DROP190=null;
        Token KEYSPACE191=null;
        CliParser.keyspace_return keyspace192 = null;


        CommonTree DROP190_tree=null;
        CommonTree KEYSPACE191_tree=null;
        RewriteRuleTokenStream stream_DROP=new RewriteRuleTokenStream(adaptor,"token DROP");
        RewriteRuleTokenStream stream_KEYSPACE=new RewriteRuleTokenStream(adaptor,"token KEYSPACE");
        RewriteRuleSubtreeStream stream_keyspace=new RewriteRuleSubtreeStream(adaptor,"rule keyspace");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:340:5: ( DROP KEYSPACE keyspace -> ^( NODE_DEL_KEYSPACE keyspace ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:340:7: DROP KEYSPACE keyspace
            {
            DROP190=(Token)match(input,DROP,FOLLOW_DROP_in_delKeyspace2592); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DROP.add(DROP190);

            KEYSPACE191=(Token)match(input,KEYSPACE,FOLLOW_KEYSPACE_in_delKeyspace2594); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_KEYSPACE.add(KEYSPACE191);

            pushFollow(FOLLOW_keyspace_in_delKeyspace2596);
            keyspace192=keyspace();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyspace.add(keyspace192.getTree());


            // AST REWRITE
            // elements: keyspace
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 341:9: -> ^( NODE_DEL_KEYSPACE keyspace )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:341:12: ^( NODE_DEL_KEYSPACE keyspace )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_DEL_KEYSPACE, "NODE_DEL_KEYSPACE"), root_1);

                adaptor.addChild(root_1, stream_keyspace.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "delKeyspace"

    public static class delColumnFamily_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "delColumnFamily"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:344:1: delColumnFamily : DROP COLUMN FAMILY columnFamily -> ^( NODE_DEL_COLUMN_FAMILY columnFamily ) ;
    public final CliParser.delColumnFamily_return delColumnFamily() throws RecognitionException {
        CliParser.delColumnFamily_return retval = new CliParser.delColumnFamily_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DROP193=null;
        Token COLUMN194=null;
        Token FAMILY195=null;
        CliParser.columnFamily_return columnFamily196 = null;


        CommonTree DROP193_tree=null;
        CommonTree COLUMN194_tree=null;
        CommonTree FAMILY195_tree=null;
        RewriteRuleTokenStream stream_FAMILY=new RewriteRuleTokenStream(adaptor,"token FAMILY");
        RewriteRuleTokenStream stream_DROP=new RewriteRuleTokenStream(adaptor,"token DROP");
        RewriteRuleTokenStream stream_COLUMN=new RewriteRuleTokenStream(adaptor,"token COLUMN");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:345:5: ( DROP COLUMN FAMILY columnFamily -> ^( NODE_DEL_COLUMN_FAMILY columnFamily ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:345:7: DROP COLUMN FAMILY columnFamily
            {
            DROP193=(Token)match(input,DROP,FOLLOW_DROP_in_delColumnFamily2630); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DROP.add(DROP193);

            COLUMN194=(Token)match(input,COLUMN,FOLLOW_COLUMN_in_delColumnFamily2632); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_COLUMN.add(COLUMN194);

            FAMILY195=(Token)match(input,FAMILY,FOLLOW_FAMILY_in_delColumnFamily2634); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_FAMILY.add(FAMILY195);

            pushFollow(FOLLOW_columnFamily_in_delColumnFamily2636);
            columnFamily196=columnFamily();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily196.getTree());


            // AST REWRITE
            // elements: columnFamily
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 346:9: -> ^( NODE_DEL_COLUMN_FAMILY columnFamily )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:346:12: ^( NODE_DEL_COLUMN_FAMILY columnFamily )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_DEL_COLUMN_FAMILY, "NODE_DEL_COLUMN_FAMILY"), root_1);

                adaptor.addChild(root_1, stream_columnFamily.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "delColumnFamily"

    public static class dropIndex_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "dropIndex"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:349:1: dropIndex : DROP INDEX ON columnFamily '.' columnName -> ^( NODE_DROP_INDEX columnFamily columnName ) ;
    public final CliParser.dropIndex_return dropIndex() throws RecognitionException {
        CliParser.dropIndex_return retval = new CliParser.dropIndex_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DROP197=null;
        Token INDEX198=null;
        Token ON199=null;
        Token char_literal201=null;
        CliParser.columnFamily_return columnFamily200 = null;

        CliParser.columnName_return columnName202 = null;


        CommonTree DROP197_tree=null;
        CommonTree INDEX198_tree=null;
        CommonTree ON199_tree=null;
        CommonTree char_literal201_tree=null;
        RewriteRuleTokenStream stream_INDEX=new RewriteRuleTokenStream(adaptor,"token INDEX");
        RewriteRuleTokenStream stream_ON=new RewriteRuleTokenStream(adaptor,"token ON");
        RewriteRuleTokenStream stream_122=new RewriteRuleTokenStream(adaptor,"token 122");
        RewriteRuleTokenStream stream_DROP=new RewriteRuleTokenStream(adaptor,"token DROP");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        RewriteRuleSubtreeStream stream_columnName=new RewriteRuleSubtreeStream(adaptor,"rule columnName");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:350:5: ( DROP INDEX ON columnFamily '.' columnName -> ^( NODE_DROP_INDEX columnFamily columnName ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:350:7: DROP INDEX ON columnFamily '.' columnName
            {
            DROP197=(Token)match(input,DROP,FOLLOW_DROP_in_dropIndex2670); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DROP.add(DROP197);

            INDEX198=(Token)match(input,INDEX,FOLLOW_INDEX_in_dropIndex2672); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_INDEX.add(INDEX198);

            ON199=(Token)match(input,ON,FOLLOW_ON_in_dropIndex2674); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_ON.add(ON199);

            pushFollow(FOLLOW_columnFamily_in_dropIndex2676);
            columnFamily200=columnFamily();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily200.getTree());
            char_literal201=(Token)match(input,122,FOLLOW_122_in_dropIndex2678); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_122.add(char_literal201);

            pushFollow(FOLLOW_columnName_in_dropIndex2680);
            columnName202=columnName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnName.add(columnName202.getTree());


            // AST REWRITE
            // elements: columnName, columnFamily
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 351:9: -> ^( NODE_DROP_INDEX columnFamily columnName )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:351:12: ^( NODE_DROP_INDEX columnFamily columnName )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_DROP_INDEX, "NODE_DROP_INDEX"), root_1);

                adaptor.addChild(root_1, stream_columnFamily.nextTree());
                adaptor.addChild(root_1, stream_columnName.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "dropIndex"

    public static class showVersion_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "showVersion"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:354:1: showVersion : SHOW API_VERSION -> ^( NODE_SHOW_VERSION ) ;
    public final CliParser.showVersion_return showVersion() throws RecognitionException {
        CliParser.showVersion_return retval = new CliParser.showVersion_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SHOW203=null;
        Token API_VERSION204=null;

        CommonTree SHOW203_tree=null;
        CommonTree API_VERSION204_tree=null;
        RewriteRuleTokenStream stream_API_VERSION=new RewriteRuleTokenStream(adaptor,"token API_VERSION");
        RewriteRuleTokenStream stream_SHOW=new RewriteRuleTokenStream(adaptor,"token SHOW");

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:355:5: ( SHOW API_VERSION -> ^( NODE_SHOW_VERSION ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:355:7: SHOW API_VERSION
            {
            SHOW203=(Token)match(input,SHOW,FOLLOW_SHOW_in_showVersion2715); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SHOW.add(SHOW203);

            API_VERSION204=(Token)match(input,API_VERSION,FOLLOW_API_VERSION_in_showVersion2717); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_API_VERSION.add(API_VERSION204);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 356:9: -> ^( NODE_SHOW_VERSION )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:356:12: ^( NODE_SHOW_VERSION )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_SHOW_VERSION, "NODE_SHOW_VERSION"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "showVersion"

    public static class showKeyspaces_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "showKeyspaces"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:359:1: showKeyspaces : SHOW KEYSPACES -> ^( NODE_SHOW_KEYSPACES ) ;
    public final CliParser.showKeyspaces_return showKeyspaces() throws RecognitionException {
        CliParser.showKeyspaces_return retval = new CliParser.showKeyspaces_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SHOW205=null;
        Token KEYSPACES206=null;

        CommonTree SHOW205_tree=null;
        CommonTree KEYSPACES206_tree=null;
        RewriteRuleTokenStream stream_KEYSPACES=new RewriteRuleTokenStream(adaptor,"token KEYSPACES");
        RewriteRuleTokenStream stream_SHOW=new RewriteRuleTokenStream(adaptor,"token SHOW");

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:360:5: ( SHOW KEYSPACES -> ^( NODE_SHOW_KEYSPACES ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:360:7: SHOW KEYSPACES
            {
            SHOW205=(Token)match(input,SHOW,FOLLOW_SHOW_in_showKeyspaces2748); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SHOW.add(SHOW205);

            KEYSPACES206=(Token)match(input,KEYSPACES,FOLLOW_KEYSPACES_in_showKeyspaces2750); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_KEYSPACES.add(KEYSPACES206);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 361:9: -> ^( NODE_SHOW_KEYSPACES )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:361:12: ^( NODE_SHOW_KEYSPACES )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_SHOW_KEYSPACES, "NODE_SHOW_KEYSPACES"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "showKeyspaces"

    public static class showSchema_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "showSchema"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:364:1: showSchema : SHOW SCHEMA ( keyspace )? -> ^( NODE_SHOW_SCHEMA ( keyspace )? ) ;
    public final CliParser.showSchema_return showSchema() throws RecognitionException {
        CliParser.showSchema_return retval = new CliParser.showSchema_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SHOW207=null;
        Token SCHEMA208=null;
        CliParser.keyspace_return keyspace209 = null;


        CommonTree SHOW207_tree=null;
        CommonTree SCHEMA208_tree=null;
        RewriteRuleTokenStream stream_SCHEMA=new RewriteRuleTokenStream(adaptor,"token SCHEMA");
        RewriteRuleTokenStream stream_SHOW=new RewriteRuleTokenStream(adaptor,"token SHOW");
        RewriteRuleSubtreeStream stream_keyspace=new RewriteRuleSubtreeStream(adaptor,"rule keyspace");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:365:5: ( SHOW SCHEMA ( keyspace )? -> ^( NODE_SHOW_SCHEMA ( keyspace )? ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:365:7: SHOW SCHEMA ( keyspace )?
            {
            SHOW207=(Token)match(input,SHOW,FOLLOW_SHOW_in_showSchema2782); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SHOW.add(SHOW207);

            SCHEMA208=(Token)match(input,SCHEMA,FOLLOW_SCHEMA_in_showSchema2784); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SCHEMA.add(SCHEMA208);

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:365:19: ( keyspace )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( ((LA21_0>=IntegerPositiveLiteral && LA21_0<=StringLiteral)||LA21_0==IntegerNegativeLiteral) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:365:20: keyspace
                    {
                    pushFollow(FOLLOW_keyspace_in_showSchema2787);
                    keyspace209=keyspace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_keyspace.add(keyspace209.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: keyspace
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 366:9: -> ^( NODE_SHOW_SCHEMA ( keyspace )? )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:366:12: ^( NODE_SHOW_SCHEMA ( keyspace )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_SHOW_SCHEMA, "NODE_SHOW_SCHEMA"), root_1);

                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:366:31: ( keyspace )?
                if ( stream_keyspace.hasNext() ) {
                    adaptor.addChild(root_1, stream_keyspace.nextTree());

                }
                stream_keyspace.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "showSchema"

    public static class describeTable_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "describeTable"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:369:1: describeTable : DESCRIBE ( keyspace )? -> ^( NODE_DESCRIBE ( keyspace )? ) ;
    public final CliParser.describeTable_return describeTable() throws RecognitionException {
        CliParser.describeTable_return retval = new CliParser.describeTable_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DESCRIBE210=null;
        CliParser.keyspace_return keyspace211 = null;


        CommonTree DESCRIBE210_tree=null;
        RewriteRuleTokenStream stream_DESCRIBE=new RewriteRuleTokenStream(adaptor,"token DESCRIBE");
        RewriteRuleSubtreeStream stream_keyspace=new RewriteRuleSubtreeStream(adaptor,"rule keyspace");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:370:5: ( DESCRIBE ( keyspace )? -> ^( NODE_DESCRIBE ( keyspace )? ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:370:7: DESCRIBE ( keyspace )?
            {
            DESCRIBE210=(Token)match(input,DESCRIBE,FOLLOW_DESCRIBE_in_describeTable2825); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DESCRIBE.add(DESCRIBE210);

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:370:16: ( keyspace )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( ((LA22_0>=IntegerPositiveLiteral && LA22_0<=StringLiteral)||LA22_0==IntegerNegativeLiteral) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:370:17: keyspace
                    {
                    pushFollow(FOLLOW_keyspace_in_describeTable2828);
                    keyspace211=keyspace();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_keyspace.add(keyspace211.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: keyspace
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 371:9: -> ^( NODE_DESCRIBE ( keyspace )? )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:371:12: ^( NODE_DESCRIBE ( keyspace )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_DESCRIBE, "NODE_DESCRIBE"), root_1);

                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:371:28: ( keyspace )?
                if ( stream_keyspace.hasNext() ) {
                    adaptor.addChild(root_1, stream_keyspace.nextTree());

                }
                stream_keyspace.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "describeTable"

    public static class describeCluster_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "describeCluster"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:374:1: describeCluster : DESCRIBE 'CLUSTER' -> ^( NODE_DESCRIBE_CLUSTER ) ;
    public final CliParser.describeCluster_return describeCluster() throws RecognitionException {
        CliParser.describeCluster_return retval = new CliParser.describeCluster_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DESCRIBE212=null;
        Token string_literal213=null;

        CommonTree DESCRIBE212_tree=null;
        CommonTree string_literal213_tree=null;
        RewriteRuleTokenStream stream_112=new RewriteRuleTokenStream(adaptor,"token 112");
        RewriteRuleTokenStream stream_DESCRIBE=new RewriteRuleTokenStream(adaptor,"token DESCRIBE");

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:375:5: ( DESCRIBE 'CLUSTER' -> ^( NODE_DESCRIBE_CLUSTER ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:375:7: DESCRIBE 'CLUSTER'
            {
            DESCRIBE212=(Token)match(input,DESCRIBE,FOLLOW_DESCRIBE_in_describeCluster2870); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_DESCRIBE.add(DESCRIBE212);

            string_literal213=(Token)match(input,112,FOLLOW_112_in_describeCluster2872); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_112.add(string_literal213);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 376:9: -> ^( NODE_DESCRIBE_CLUSTER )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:376:12: ^( NODE_DESCRIBE_CLUSTER )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_DESCRIBE_CLUSTER, "NODE_DESCRIBE_CLUSTER"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "describeCluster"

    public static class useKeyspace_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "useKeyspace"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:379:1: useKeyspace : USE keyspace ( username )? ( password )? -> ^( NODE_USE_TABLE keyspace ( username )? ( password )? ) ;
    public final CliParser.useKeyspace_return useKeyspace() throws RecognitionException {
        CliParser.useKeyspace_return retval = new CliParser.useKeyspace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token USE214=null;
        CliParser.keyspace_return keyspace215 = null;

        CliParser.username_return username216 = null;

        CliParser.password_return password217 = null;


        CommonTree USE214_tree=null;
        RewriteRuleTokenStream stream_USE=new RewriteRuleTokenStream(adaptor,"token USE");
        RewriteRuleSubtreeStream stream_username=new RewriteRuleSubtreeStream(adaptor,"rule username");
        RewriteRuleSubtreeStream stream_keyspace=new RewriteRuleSubtreeStream(adaptor,"rule keyspace");
        RewriteRuleSubtreeStream stream_password=new RewriteRuleSubtreeStream(adaptor,"rule password");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:380:5: ( USE keyspace ( username )? ( password )? -> ^( NODE_USE_TABLE keyspace ( username )? ( password )? ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:380:7: USE keyspace ( username )? ( password )?
            {
            USE214=(Token)match(input,USE,FOLLOW_USE_in_useKeyspace2903); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_USE.add(USE214);

            pushFollow(FOLLOW_keyspace_in_useKeyspace2905);
            keyspace215=keyspace();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_keyspace.add(keyspace215.getTree());
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:380:20: ( username )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==Identifier) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:380:22: username
                    {
                    pushFollow(FOLLOW_username_in_useKeyspace2909);
                    username216=username();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_username.add(username216.getTree());

                    }
                    break;

            }

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:380:34: ( password )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==StringLiteral) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:380:36: password
                    {
                    pushFollow(FOLLOW_password_in_useKeyspace2916);
                    password217=password();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_password.add(password217.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: keyspace, username, password
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 381:9: -> ^( NODE_USE_TABLE keyspace ( username )? ( password )? )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:381:12: ^( NODE_USE_TABLE keyspace ( username )? ( password )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_USE_TABLE, "NODE_USE_TABLE"), root_1);

                adaptor.addChild(root_1, stream_keyspace.nextTree());
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:381:38: ( username )?
                if ( stream_username.hasNext() ) {
                    adaptor.addChild(root_1, stream_username.nextTree());

                }
                stream_username.reset();
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:381:52: ( password )?
                if ( stream_password.hasNext() ) {
                    adaptor.addChild(root_1, stream_password.nextTree());

                }
                stream_password.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "useKeyspace"

    public static class traceNextQuery_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "traceNextQuery"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:384:1: traceNextQuery : TRACE NEXT QUERY -> ^( NODE_TRACE_NEXT_QUERY ) ;
    public final CliParser.traceNextQuery_return traceNextQuery() throws RecognitionException {
        CliParser.traceNextQuery_return retval = new CliParser.traceNextQuery_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token TRACE218=null;
        Token NEXT219=null;
        Token QUERY220=null;

        CommonTree TRACE218_tree=null;
        CommonTree NEXT219_tree=null;
        CommonTree QUERY220_tree=null;
        RewriteRuleTokenStream stream_QUERY=new RewriteRuleTokenStream(adaptor,"token QUERY");
        RewriteRuleTokenStream stream_NEXT=new RewriteRuleTokenStream(adaptor,"token NEXT");
        RewriteRuleTokenStream stream_TRACE=new RewriteRuleTokenStream(adaptor,"token TRACE");

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:385:5: ( TRACE NEXT QUERY -> ^( NODE_TRACE_NEXT_QUERY ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:385:7: TRACE NEXT QUERY
            {
            TRACE218=(Token)match(input,TRACE,FOLLOW_TRACE_in_traceNextQuery2971); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TRACE.add(TRACE218);

            NEXT219=(Token)match(input,NEXT,FOLLOW_NEXT_in_traceNextQuery2973); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_NEXT.add(NEXT219);

            QUERY220=(Token)match(input,QUERY,FOLLOW_QUERY_in_traceNextQuery2975); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_QUERY.add(QUERY220);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 386:9: -> ^( NODE_TRACE_NEXT_QUERY )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:386:12: ^( NODE_TRACE_NEXT_QUERY )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_TRACE_NEXT_QUERY, "NODE_TRACE_NEXT_QUERY"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "traceNextQuery"

    public static class setTraceProbability_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "setTraceProbability"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:389:1: setTraceProbability : SET TRACE PROBABILITY tracingProbability -> ^( NODE_SET_TRACE_PROBABILITY tracingProbability ) ;
    public final CliParser.setTraceProbability_return setTraceProbability() throws RecognitionException {
        CliParser.setTraceProbability_return retval = new CliParser.setTraceProbability_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token SET221=null;
        Token TRACE222=null;
        Token PROBABILITY223=null;
        CliParser.tracingProbability_return tracingProbability224 = null;


        CommonTree SET221_tree=null;
        CommonTree TRACE222_tree=null;
        CommonTree PROBABILITY223_tree=null;
        RewriteRuleTokenStream stream_SET=new RewriteRuleTokenStream(adaptor,"token SET");
        RewriteRuleTokenStream stream_PROBABILITY=new RewriteRuleTokenStream(adaptor,"token PROBABILITY");
        RewriteRuleTokenStream stream_TRACE=new RewriteRuleTokenStream(adaptor,"token TRACE");
        RewriteRuleSubtreeStream stream_tracingProbability=new RewriteRuleSubtreeStream(adaptor,"rule tracingProbability");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:390:5: ( SET TRACE PROBABILITY tracingProbability -> ^( NODE_SET_TRACE_PROBABILITY tracingProbability ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:390:7: SET TRACE PROBABILITY tracingProbability
            {
            SET221=(Token)match(input,SET,FOLLOW_SET_in_setTraceProbability3006); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_SET.add(SET221);

            TRACE222=(Token)match(input,TRACE,FOLLOW_TRACE_in_setTraceProbability3008); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_TRACE.add(TRACE222);

            PROBABILITY223=(Token)match(input,PROBABILITY,FOLLOW_PROBABILITY_in_setTraceProbability3010); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_PROBABILITY.add(PROBABILITY223);

            pushFollow(FOLLOW_tracingProbability_in_setTraceProbability3012);
            tracingProbability224=tracingProbability();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_tracingProbability.add(tracingProbability224.getTree());


            // AST REWRITE
            // elements: tracingProbability
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 391:9: -> ^( NODE_SET_TRACE_PROBABILITY tracingProbability )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:391:12: ^( NODE_SET_TRACE_PROBABILITY tracingProbability )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_SET_TRACE_PROBABILITY, "NODE_SET_TRACE_PROBABILITY"), root_1);

                adaptor.addChild(root_1, stream_tracingProbability.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "setTraceProbability"

    public static class keyValuePairExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyValuePairExpr"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:394:1: keyValuePairExpr : entityName ( ( AND | WITH ) keyValuePair )* -> ^( NODE_NEW_KEYSPACE_ACCESS entityName ( keyValuePair )* ) ;
    public final CliParser.keyValuePairExpr_return keyValuePairExpr() throws RecognitionException {
        CliParser.keyValuePairExpr_return retval = new CliParser.keyValuePairExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token AND226=null;
        Token WITH227=null;
        CliParser.entityName_return entityName225 = null;

        CliParser.keyValuePair_return keyValuePair228 = null;


        CommonTree AND226_tree=null;
        CommonTree WITH227_tree=null;
        RewriteRuleTokenStream stream_AND=new RewriteRuleTokenStream(adaptor,"token AND");
        RewriteRuleTokenStream stream_WITH=new RewriteRuleTokenStream(adaptor,"token WITH");
        RewriteRuleSubtreeStream stream_keyValuePair=new RewriteRuleSubtreeStream(adaptor,"rule keyValuePair");
        RewriteRuleSubtreeStream stream_entityName=new RewriteRuleSubtreeStream(adaptor,"rule entityName");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:395:5: ( entityName ( ( AND | WITH ) keyValuePair )* -> ^( NODE_NEW_KEYSPACE_ACCESS entityName ( keyValuePair )* ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:395:7: entityName ( ( AND | WITH ) keyValuePair )*
            {
            pushFollow(FOLLOW_entityName_in_keyValuePairExpr3045);
            entityName225=entityName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_entityName.add(entityName225.getTree());
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:395:18: ( ( AND | WITH ) keyValuePair )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==WITH||LA26_0==AND) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:395:20: ( AND | WITH ) keyValuePair
            	    {
            	    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:395:20: ( AND | WITH )
            	    int alt25=2;
            	    int LA25_0 = input.LA(1);

            	    if ( (LA25_0==AND) ) {
            	        alt25=1;
            	    }
            	    else if ( (LA25_0==WITH) ) {
            	        alt25=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return retval;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 25, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt25) {
            	        case 1 :
            	            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:395:21: AND
            	            {
            	            AND226=(Token)match(input,AND,FOLLOW_AND_in_keyValuePairExpr3050); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_AND.add(AND226);


            	            }
            	            break;
            	        case 2 :
            	            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:395:27: WITH
            	            {
            	            WITH227=(Token)match(input,WITH,FOLLOW_WITH_in_keyValuePairExpr3054); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_WITH.add(WITH227);


            	            }
            	            break;

            	    }

            	    pushFollow(FOLLOW_keyValuePair_in_keyValuePairExpr3057);
            	    keyValuePair228=keyValuePair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_keyValuePair.add(keyValuePair228.getTree());

            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);



            // AST REWRITE
            // elements: keyValuePair, entityName
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 396:9: -> ^( NODE_NEW_KEYSPACE_ACCESS entityName ( keyValuePair )* )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:396:12: ^( NODE_NEW_KEYSPACE_ACCESS entityName ( keyValuePair )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_NEW_KEYSPACE_ACCESS, "NODE_NEW_KEYSPACE_ACCESS"), root_1);

                adaptor.addChild(root_1, stream_entityName.nextTree());
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:396:50: ( keyValuePair )*
                while ( stream_keyValuePair.hasNext() ) {
                    adaptor.addChild(root_1, stream_keyValuePair.nextTree());

                }
                stream_keyValuePair.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyValuePairExpr"

    public static class keyValuePair_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyValuePair"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:399:1: keyValuePair : attr_name '=' attrValue -> attr_name attrValue ;
    public final CliParser.keyValuePair_return keyValuePair() throws RecognitionException {
        CliParser.keyValuePair_return retval = new CliParser.keyValuePair_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal230=null;
        CliParser.attr_name_return attr_name229 = null;

        CliParser.attrValue_return attrValue231 = null;


        CommonTree char_literal230_tree=null;
        RewriteRuleTokenStream stream_117=new RewriteRuleTokenStream(adaptor,"token 117");
        RewriteRuleSubtreeStream stream_attr_name=new RewriteRuleSubtreeStream(adaptor,"rule attr_name");
        RewriteRuleSubtreeStream stream_attrValue=new RewriteRuleSubtreeStream(adaptor,"rule attrValue");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:400:5: ( attr_name '=' attrValue -> attr_name attrValue )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:400:7: attr_name '=' attrValue
            {
            pushFollow(FOLLOW_attr_name_in_keyValuePair3114);
            attr_name229=attr_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attr_name.add(attr_name229.getTree());
            char_literal230=(Token)match(input,117,FOLLOW_117_in_keyValuePair3116); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_117.add(char_literal230);

            pushFollow(FOLLOW_attrValue_in_keyValuePair3118);
            attrValue231=attrValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_attrValue.add(attrValue231.getTree());


            // AST REWRITE
            // elements: attrValue, attr_name
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 401:9: -> attr_name attrValue
            {
                adaptor.addChild(root_0, stream_attr_name.nextTree());
                adaptor.addChild(root_0, stream_attrValue.nextTree());

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyValuePair"

    public static class attrValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrValue"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:404:1: attrValue : ( arrayConstruct | hashConstruct | attrValueString | attrValueInt | attrValueDouble );
    public final CliParser.attrValue_return attrValue() throws RecognitionException {
        CliParser.attrValue_return retval = new CliParser.attrValue_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.arrayConstruct_return arrayConstruct232 = null;

        CliParser.hashConstruct_return hashConstruct233 = null;

        CliParser.attrValueString_return attrValueString234 = null;

        CliParser.attrValueInt_return attrValueInt235 = null;

        CliParser.attrValueDouble_return attrValueDouble236 = null;



        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:405:5: ( arrayConstruct | hashConstruct | attrValueString | attrValueInt | attrValueDouble )
            int alt27=5;
            switch ( input.LA(1) ) {
            case 123:
                {
                alt27=1;
                }
                break;
            case 126:
                {
                alt27=2;
                }
                break;
            case Identifier:
            case StringLiteral:
                {
                alt27=3;
                }
                break;
            case IntegerPositiveLiteral:
            case IntegerNegativeLiteral:
                {
                alt27=4;
                }
                break;
            case DoubleLiteral:
                {
                alt27=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }

            switch (alt27) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:405:7: arrayConstruct
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_arrayConstruct_in_attrValue3150);
                    arrayConstruct232=arrayConstruct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, arrayConstruct232.getTree());

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:406:7: hashConstruct
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_hashConstruct_in_attrValue3158);
                    hashConstruct233=hashConstruct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, hashConstruct233.getTree());

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:407:7: attrValueString
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_attrValueString_in_attrValue3166);
                    attrValueString234=attrValueString();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attrValueString234.getTree());

                    }
                    break;
                case 4 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:408:7: attrValueInt
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_attrValueInt_in_attrValue3174);
                    attrValueInt235=attrValueInt();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attrValueInt235.getTree());

                    }
                    break;
                case 5 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:409:7: attrValueDouble
                    {
                    root_0 = (CommonTree)adaptor.nil();

                    pushFollow(FOLLOW_attrValueDouble_in_attrValue3182);
                    attrValueDouble236=attrValueDouble();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, attrValueDouble236.getTree());

                    }
                    break;

            }
            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attrValue"

    public static class arrayConstruct_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "arrayConstruct"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:413:1: arrayConstruct : '[' ( hashConstruct ( ',' )? )* ']' -> ^( ARRAY ( hashConstruct )* ) ;
    public final CliParser.arrayConstruct_return arrayConstruct() throws RecognitionException {
        CliParser.arrayConstruct_return retval = new CliParser.arrayConstruct_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal237=null;
        Token char_literal239=null;
        Token char_literal240=null;
        CliParser.hashConstruct_return hashConstruct238 = null;


        CommonTree char_literal237_tree=null;
        CommonTree char_literal239_tree=null;
        CommonTree char_literal240_tree=null;
        RewriteRuleTokenStream stream_125=new RewriteRuleTokenStream(adaptor,"token 125");
        RewriteRuleTokenStream stream_123=new RewriteRuleTokenStream(adaptor,"token 123");
        RewriteRuleTokenStream stream_124=new RewriteRuleTokenStream(adaptor,"token 124");
        RewriteRuleSubtreeStream stream_hashConstruct=new RewriteRuleSubtreeStream(adaptor,"rule hashConstruct");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:414:5: ( '[' ( hashConstruct ( ',' )? )* ']' -> ^( ARRAY ( hashConstruct )* ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:414:7: '[' ( hashConstruct ( ',' )? )* ']'
            {
            char_literal237=(Token)match(input,123,FOLLOW_123_in_arrayConstruct3201); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_123.add(char_literal237);

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:414:11: ( hashConstruct ( ',' )? )*
            loop29:
            do {
                int alt29=2;
                int LA29_0 = input.LA(1);

                if ( (LA29_0==126) ) {
                    alt29=1;
                }


                switch (alt29) {
            	case 1 :
            	    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:414:12: hashConstruct ( ',' )?
            	    {
            	    pushFollow(FOLLOW_hashConstruct_in_arrayConstruct3204);
            	    hashConstruct238=hashConstruct();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_hashConstruct.add(hashConstruct238.getTree());
            	    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:414:26: ( ',' )?
            	    int alt28=2;
            	    int LA28_0 = input.LA(1);

            	    if ( (LA28_0==124) ) {
            	        alt28=1;
            	    }
            	    switch (alt28) {
            	        case 1 :
            	            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:0:0: ','
            	            {
            	            char_literal239=(Token)match(input,124,FOLLOW_124_in_arrayConstruct3206); if (state.failed) return retval; 
            	            if ( state.backtracking==0 ) stream_124.add(char_literal239);


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop29;
                }
            } while (true);

            char_literal240=(Token)match(input,125,FOLLOW_125_in_arrayConstruct3211); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_125.add(char_literal240);



            // AST REWRITE
            // elements: hashConstruct
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 415:9: -> ^( ARRAY ( hashConstruct )* )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:415:12: ^( ARRAY ( hashConstruct )* )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(ARRAY, "ARRAY"), root_1);

                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:415:20: ( hashConstruct )*
                while ( stream_hashConstruct.hasNext() ) {
                    adaptor.addChild(root_1, stream_hashConstruct.nextTree());

                }
                stream_hashConstruct.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arrayConstruct"

    public static class hashConstruct_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "hashConstruct"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:418:1: hashConstruct : '{' hashElementPair ( ',' hashElementPair )* '}' -> ^( HASH ( hashElementPair )+ ) ;
    public final CliParser.hashConstruct_return hashConstruct() throws RecognitionException {
        CliParser.hashConstruct_return retval = new CliParser.hashConstruct_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal241=null;
        Token char_literal243=null;
        Token char_literal245=null;
        CliParser.hashElementPair_return hashElementPair242 = null;

        CliParser.hashElementPair_return hashElementPair244 = null;


        CommonTree char_literal241_tree=null;
        CommonTree char_literal243_tree=null;
        CommonTree char_literal245_tree=null;
        RewriteRuleTokenStream stream_126=new RewriteRuleTokenStream(adaptor,"token 126");
        RewriteRuleTokenStream stream_127=new RewriteRuleTokenStream(adaptor,"token 127");
        RewriteRuleTokenStream stream_124=new RewriteRuleTokenStream(adaptor,"token 124");
        RewriteRuleSubtreeStream stream_hashElementPair=new RewriteRuleSubtreeStream(adaptor,"rule hashElementPair");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:419:5: ( '{' hashElementPair ( ',' hashElementPair )* '}' -> ^( HASH ( hashElementPair )+ ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:419:7: '{' hashElementPair ( ',' hashElementPair )* '}'
            {
            char_literal241=(Token)match(input,126,FOLLOW_126_in_hashConstruct3249); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_126.add(char_literal241);

            pushFollow(FOLLOW_hashElementPair_in_hashConstruct3251);
            hashElementPair242=hashElementPair();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_hashElementPair.add(hashElementPair242.getTree());
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:419:27: ( ',' hashElementPair )*
            loop30:
            do {
                int alt30=2;
                int LA30_0 = input.LA(1);

                if ( (LA30_0==124) ) {
                    alt30=1;
                }


                switch (alt30) {
            	case 1 :
            	    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:419:28: ',' hashElementPair
            	    {
            	    char_literal243=(Token)match(input,124,FOLLOW_124_in_hashConstruct3254); if (state.failed) return retval; 
            	    if ( state.backtracking==0 ) stream_124.add(char_literal243);

            	    pushFollow(FOLLOW_hashElementPair_in_hashConstruct3256);
            	    hashElementPair244=hashElementPair();

            	    state._fsp--;
            	    if (state.failed) return retval;
            	    if ( state.backtracking==0 ) stream_hashElementPair.add(hashElementPair244.getTree());

            	    }
            	    break;

            	default :
            	    break loop30;
                }
            } while (true);

            char_literal245=(Token)match(input,127,FOLLOW_127_in_hashConstruct3260); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_127.add(char_literal245);



            // AST REWRITE
            // elements: hashElementPair
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 420:9: -> ^( HASH ( hashElementPair )+ )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:420:12: ^( HASH ( hashElementPair )+ )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(HASH, "HASH"), root_1);

                if ( !(stream_hashElementPair.hasNext()) ) {
                    throw new RewriteEarlyExitException();
                }
                while ( stream_hashElementPair.hasNext() ) {
                    adaptor.addChild(root_1, stream_hashElementPair.nextTree());

                }
                stream_hashElementPair.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "hashConstruct"

    public static class hashElementPair_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "hashElementPair"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:423:1: hashElementPair : rowKey ':' rowValue -> ^( PAIR rowKey rowValue ) ;
    public final CliParser.hashElementPair_return hashElementPair() throws RecognitionException {
        CliParser.hashElementPair_return retval = new CliParser.hashElementPair_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal247=null;
        CliParser.rowKey_return rowKey246 = null;

        CliParser.rowValue_return rowValue248 = null;


        CommonTree char_literal247_tree=null;
        RewriteRuleTokenStream stream_128=new RewriteRuleTokenStream(adaptor,"token 128");
        RewriteRuleSubtreeStream stream_rowKey=new RewriteRuleSubtreeStream(adaptor,"rule rowKey");
        RewriteRuleSubtreeStream stream_rowValue=new RewriteRuleSubtreeStream(adaptor,"rule rowValue");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:424:5: ( rowKey ':' rowValue -> ^( PAIR rowKey rowValue ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:424:7: rowKey ':' rowValue
            {
            pushFollow(FOLLOW_rowKey_in_hashElementPair3296);
            rowKey246=rowKey();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rowKey.add(rowKey246.getTree());
            char_literal247=(Token)match(input,128,FOLLOW_128_in_hashElementPair3298); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_128.add(char_literal247);

            pushFollow(FOLLOW_rowValue_in_hashElementPair3300);
            rowValue248=rowValue();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rowValue.add(rowValue248.getTree());


            // AST REWRITE
            // elements: rowValue, rowKey
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 425:9: -> ^( PAIR rowKey rowValue )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:425:12: ^( PAIR rowKey rowValue )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(PAIR, "PAIR"), root_1);

                adaptor.addChild(root_1, stream_rowKey.nextTree());
                adaptor.addChild(root_1, stream_rowValue.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "hashElementPair"

    public static class columnFamilyExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "columnFamilyExpr"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:428:1: columnFamilyExpr : columnFamily '[' rowKey ']' ( '[' column= columnOrSuperColumn ']' ( '[' super_column= columnOrSuperColumn ']' )? )? -> ^( NODE_COLUMN_ACCESS columnFamily rowKey ( $column ( $super_column)? )? ) ;
    public final CliParser.columnFamilyExpr_return columnFamilyExpr() throws RecognitionException {
        CliParser.columnFamilyExpr_return retval = new CliParser.columnFamilyExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal250=null;
        Token char_literal252=null;
        Token char_literal253=null;
        Token char_literal254=null;
        Token char_literal255=null;
        Token char_literal256=null;
        CliParser.columnOrSuperColumn_return column = null;

        CliParser.columnOrSuperColumn_return super_column = null;

        CliParser.columnFamily_return columnFamily249 = null;

        CliParser.rowKey_return rowKey251 = null;


        CommonTree char_literal250_tree=null;
        CommonTree char_literal252_tree=null;
        CommonTree char_literal253_tree=null;
        CommonTree char_literal254_tree=null;
        CommonTree char_literal255_tree=null;
        CommonTree char_literal256_tree=null;
        RewriteRuleTokenStream stream_125=new RewriteRuleTokenStream(adaptor,"token 125");
        RewriteRuleTokenStream stream_123=new RewriteRuleTokenStream(adaptor,"token 123");
        RewriteRuleSubtreeStream stream_columnFamily=new RewriteRuleSubtreeStream(adaptor,"rule columnFamily");
        RewriteRuleSubtreeStream stream_rowKey=new RewriteRuleSubtreeStream(adaptor,"rule rowKey");
        RewriteRuleSubtreeStream stream_columnOrSuperColumn=new RewriteRuleSubtreeStream(adaptor,"rule columnOrSuperColumn");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:429:5: ( columnFamily '[' rowKey ']' ( '[' column= columnOrSuperColumn ']' ( '[' super_column= columnOrSuperColumn ']' )? )? -> ^( NODE_COLUMN_ACCESS columnFamily rowKey ( $column ( $super_column)? )? ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:429:7: columnFamily '[' rowKey ']' ( '[' column= columnOrSuperColumn ']' ( '[' super_column= columnOrSuperColumn ']' )? )?
            {
            pushFollow(FOLLOW_columnFamily_in_columnFamilyExpr3335);
            columnFamily249=columnFamily();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_columnFamily.add(columnFamily249.getTree());
            char_literal250=(Token)match(input,123,FOLLOW_123_in_columnFamilyExpr3337); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_123.add(char_literal250);

            pushFollow(FOLLOW_rowKey_in_columnFamilyExpr3339);
            rowKey251=rowKey();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_rowKey.add(rowKey251.getTree());
            char_literal252=(Token)match(input,125,FOLLOW_125_in_columnFamilyExpr3341); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_125.add(char_literal252);

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:430:9: ( '[' column= columnOrSuperColumn ']' ( '[' super_column= columnOrSuperColumn ']' )? )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==123) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:430:11: '[' column= columnOrSuperColumn ']' ( '[' super_column= columnOrSuperColumn ']' )?
                    {
                    char_literal253=(Token)match(input,123,FOLLOW_123_in_columnFamilyExpr3354); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_123.add(char_literal253);

                    pushFollow(FOLLOW_columnOrSuperColumn_in_columnFamilyExpr3358);
                    column=columnOrSuperColumn();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_columnOrSuperColumn.add(column.getTree());
                    char_literal254=(Token)match(input,125,FOLLOW_125_in_columnFamilyExpr3360); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_125.add(char_literal254);

                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:431:13: ( '[' super_column= columnOrSuperColumn ']' )?
                    int alt31=2;
                    int LA31_0 = input.LA(1);

                    if ( (LA31_0==123) ) {
                        alt31=1;
                    }
                    switch (alt31) {
                        case 1 :
                            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:431:14: '[' super_column= columnOrSuperColumn ']'
                            {
                            char_literal255=(Token)match(input,123,FOLLOW_123_in_columnFamilyExpr3376); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_123.add(char_literal255);

                            pushFollow(FOLLOW_columnOrSuperColumn_in_columnFamilyExpr3380);
                            super_column=columnOrSuperColumn();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_columnOrSuperColumn.add(super_column.getTree());
                            char_literal256=(Token)match(input,125,FOLLOW_125_in_columnFamilyExpr3382); if (state.failed) return retval; 
                            if ( state.backtracking==0 ) stream_125.add(char_literal256);


                            }
                            break;

                    }


                    }
                    break;

            }



            // AST REWRITE
            // elements: rowKey, columnFamily, super_column, column
            // token labels: 
            // rule labels: retval, column, super_column
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_column=new RewriteRuleSubtreeStream(adaptor,"rule column",column!=null?column.tree:null);
            RewriteRuleSubtreeStream stream_super_column=new RewriteRuleSubtreeStream(adaptor,"rule super_column",super_column!=null?super_column.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 433:7: -> ^( NODE_COLUMN_ACCESS columnFamily rowKey ( $column ( $super_column)? )? )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:433:10: ^( NODE_COLUMN_ACCESS columnFamily rowKey ( $column ( $super_column)? )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_COLUMN_ACCESS, "NODE_COLUMN_ACCESS"), root_1);

                adaptor.addChild(root_1, stream_columnFamily.nextTree());
                adaptor.addChild(root_1, stream_rowKey.nextTree());
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:433:51: ( $column ( $super_column)? )?
                if ( stream_super_column.hasNext()||stream_column.hasNext() ) {
                    adaptor.addChild(root_1, stream_column.nextTree());
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:433:60: ( $super_column)?
                    if ( stream_super_column.hasNext() ) {
                        adaptor.addChild(root_1, stream_super_column.nextTree());

                    }
                    stream_super_column.reset();

                }
                stream_super_column.reset();
                stream_column.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "columnFamilyExpr"

    public static class keyRangeExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyRangeExpr"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:436:1: keyRangeExpr : '[' ( (startKey= entityName )? ':' (endKey= entityName )? )? ']' -> ^( NODE_KEY_RANGE ( $startKey)? ( $endKey)? ) ;
    public final CliParser.keyRangeExpr_return keyRangeExpr() throws RecognitionException {
        CliParser.keyRangeExpr_return retval = new CliParser.keyRangeExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token char_literal257=null;
        Token char_literal258=null;
        Token char_literal259=null;
        CliParser.entityName_return startKey = null;

        CliParser.entityName_return endKey = null;


        CommonTree char_literal257_tree=null;
        CommonTree char_literal258_tree=null;
        CommonTree char_literal259_tree=null;
        RewriteRuleTokenStream stream_125=new RewriteRuleTokenStream(adaptor,"token 125");
        RewriteRuleTokenStream stream_128=new RewriteRuleTokenStream(adaptor,"token 128");
        RewriteRuleTokenStream stream_123=new RewriteRuleTokenStream(adaptor,"token 123");
        RewriteRuleSubtreeStream stream_entityName=new RewriteRuleSubtreeStream(adaptor,"rule entityName");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:437:5: ( '[' ( (startKey= entityName )? ':' (endKey= entityName )? )? ']' -> ^( NODE_KEY_RANGE ( $startKey)? ( $endKey)? ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:437:10: '[' ( (startKey= entityName )? ':' (endKey= entityName )? )? ']'
            {
            char_literal257=(Token)match(input,123,FOLLOW_123_in_keyRangeExpr3445); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_123.add(char_literal257);

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:437:14: ( (startKey= entityName )? ':' (endKey= entityName )? )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( ((LA35_0>=IntegerPositiveLiteral && LA35_0<=StringLiteral)||LA35_0==IntegerNegativeLiteral||LA35_0==128) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:437:16: (startKey= entityName )? ':' (endKey= entityName )?
                    {
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:437:24: (startKey= entityName )?
                    int alt33=2;
                    int LA33_0 = input.LA(1);

                    if ( ((LA33_0>=IntegerPositiveLiteral && LA33_0<=StringLiteral)||LA33_0==IntegerNegativeLiteral) ) {
                        alt33=1;
                    }
                    switch (alt33) {
                        case 1 :
                            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:0:0: startKey= entityName
                            {
                            pushFollow(FOLLOW_entityName_in_keyRangeExpr3451);
                            startKey=entityName();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_entityName.add(startKey.getTree());

                            }
                            break;

                    }

                    char_literal258=(Token)match(input,128,FOLLOW_128_in_keyRangeExpr3454); if (state.failed) return retval; 
                    if ( state.backtracking==0 ) stream_128.add(char_literal258);

                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:437:47: (endKey= entityName )?
                    int alt34=2;
                    int LA34_0 = input.LA(1);

                    if ( ((LA34_0>=IntegerPositiveLiteral && LA34_0<=StringLiteral)||LA34_0==IntegerNegativeLiteral) ) {
                        alt34=1;
                    }
                    switch (alt34) {
                        case 1 :
                            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:0:0: endKey= entityName
                            {
                            pushFollow(FOLLOW_entityName_in_keyRangeExpr3458);
                            endKey=entityName();

                            state._fsp--;
                            if (state.failed) return retval;
                            if ( state.backtracking==0 ) stream_entityName.add(endKey.getTree());

                            }
                            break;

                    }


                    }
                    break;

            }

            char_literal259=(Token)match(input,125,FOLLOW_125_in_keyRangeExpr3464); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_125.add(char_literal259);



            // AST REWRITE
            // elements: endKey, startKey
            // token labels: 
            // rule labels: endKey, retval, startKey
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_endKey=new RewriteRuleSubtreeStream(adaptor,"rule endKey",endKey!=null?endKey.tree:null);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);
            RewriteRuleSubtreeStream stream_startKey=new RewriteRuleSubtreeStream(adaptor,"rule startKey",startKey!=null?startKey.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 438:7: -> ^( NODE_KEY_RANGE ( $startKey)? ( $endKey)? )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:438:10: ^( NODE_KEY_RANGE ( $startKey)? ( $endKey)? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_KEY_RANGE, "NODE_KEY_RANGE"), root_1);

                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:438:27: ( $startKey)?
                if ( stream_startKey.hasNext() ) {
                    adaptor.addChild(root_1, stream_startKey.nextTree());

                }
                stream_startKey.reset();
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:438:38: ( $endKey)?
                if ( stream_endKey.hasNext() ) {
                    adaptor.addChild(root_1, stream_endKey.nextTree());

                }
                stream_endKey.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyRangeExpr"

    public static class rowLimitExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rowLimitExpr"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:441:1: rowLimitExpr : 'LIMIT' limit= IntegerPositiveLiteral -> ^( NODE_LIMIT $limit) ;
    public final CliParser.rowLimitExpr_return rowLimitExpr() throws RecognitionException {
        CliParser.rowLimitExpr_return retval = new CliParser.rowLimitExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token limit=null;
        Token string_literal260=null;

        CommonTree limit_tree=null;
        CommonTree string_literal260_tree=null;
        RewriteRuleTokenStream stream_IntegerPositiveLiteral=new RewriteRuleTokenStream(adaptor,"token IntegerPositiveLiteral");
        RewriteRuleTokenStream stream_LIMIT=new RewriteRuleTokenStream(adaptor,"token LIMIT");

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:442:5: ( 'LIMIT' limit= IntegerPositiveLiteral -> ^( NODE_LIMIT $limit) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:442:7: 'LIMIT' limit= IntegerPositiveLiteral
            {
            string_literal260=(Token)match(input,LIMIT,FOLLOW_LIMIT_in_rowLimitExpr3501); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_LIMIT.add(string_literal260);

            limit=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_rowLimitExpr3505); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IntegerPositiveLiteral.add(limit);



            // AST REWRITE
            // elements: limit
            // token labels: limit
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_limit=new RewriteRuleTokenStream(adaptor,"token limit",limit);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 443:9: -> ^( NODE_LIMIT $limit)
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:443:12: ^( NODE_LIMIT $limit)
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_LIMIT, "NODE_LIMIT"), root_1);

                adaptor.addChild(root_1, stream_limit.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rowLimitExpr"

    public static class columnLimitExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "columnLimitExpr"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:446:1: columnLimitExpr : 'COLUMNS' columns= IntegerPositiveLiteral ( reversedExpr )? -> ^( NODE_COLUMNS $columns ( reversedExpr )? ) ;
    public final CliParser.columnLimitExpr_return columnLimitExpr() throws RecognitionException {
        CliParser.columnLimitExpr_return retval = new CliParser.columnLimitExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token columns=null;
        Token string_literal261=null;
        CliParser.reversedExpr_return reversedExpr262 = null;


        CommonTree columns_tree=null;
        CommonTree string_literal261_tree=null;
        RewriteRuleTokenStream stream_IntegerPositiveLiteral=new RewriteRuleTokenStream(adaptor,"token IntegerPositiveLiteral");
        RewriteRuleTokenStream stream_129=new RewriteRuleTokenStream(adaptor,"token 129");
        RewriteRuleSubtreeStream stream_reversedExpr=new RewriteRuleSubtreeStream(adaptor,"rule reversedExpr");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:447:5: ( 'COLUMNS' columns= IntegerPositiveLiteral ( reversedExpr )? -> ^( NODE_COLUMNS $columns ( reversedExpr )? ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:447:7: 'COLUMNS' columns= IntegerPositiveLiteral ( reversedExpr )?
            {
            string_literal261=(Token)match(input,129,FOLLOW_129_in_columnLimitExpr3539); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_129.add(string_literal261);

            columns=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_columnLimitExpr3543); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IntegerPositiveLiteral.add(columns);

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:447:48: ( reversedExpr )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==130) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:0:0: reversedExpr
                    {
                    pushFollow(FOLLOW_reversedExpr_in_columnLimitExpr3545);
                    reversedExpr262=reversedExpr();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_reversedExpr.add(reversedExpr262.getTree());

                    }
                    break;

            }



            // AST REWRITE
            // elements: reversedExpr, columns
            // token labels: columns
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_columns=new RewriteRuleTokenStream(adaptor,"token columns",columns);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 448:9: -> ^( NODE_COLUMNS $columns ( reversedExpr )? )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:448:12: ^( NODE_COLUMNS $columns ( reversedExpr )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_COLUMNS, "NODE_COLUMNS"), root_1);

                adaptor.addChild(root_1, stream_columns.nextNode());
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:448:36: ( reversedExpr )?
                if ( stream_reversedExpr.hasNext() ) {
                    adaptor.addChild(root_1, stream_reversedExpr.nextTree());

                }
                stream_reversedExpr.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "columnLimitExpr"

    public static class reversedExpr_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "reversedExpr"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:451:1: reversedExpr : 'REVERSED' -> ^( NODE_REVERSED ) ;
    public final CliParser.reversedExpr_return reversedExpr() throws RecognitionException {
        CliParser.reversedExpr_return retval = new CliParser.reversedExpr_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token string_literal263=null;

        CommonTree string_literal263_tree=null;
        RewriteRuleTokenStream stream_130=new RewriteRuleTokenStream(adaptor,"token 130");

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:452:5: ( 'REVERSED' -> ^( NODE_REVERSED ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:452:7: 'REVERSED'
            {
            string_literal263=(Token)match(input,130,FOLLOW_130_in_reversedExpr3583); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_130.add(string_literal263);



            // AST REWRITE
            // elements: 
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 453:9: -> ^( NODE_REVERSED )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:453:12: ^( NODE_REVERSED )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_REVERSED, "NODE_REVERSED"), root_1);

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "reversedExpr"

    public static class columnName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "columnName"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:456:1: columnName : entityName ;
    public final CliParser.columnName_return columnName() throws RecognitionException {
        CliParser.columnName_return retval = new CliParser.columnName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.entityName_return entityName264 = null;



        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:457:2: ( entityName )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:457:4: entityName
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_entityName_in_columnName3611);
            entityName264=entityName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, entityName264.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "columnName"

    public static class attr_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attr_name"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:460:1: attr_name : Identifier ;
    public final CliParser.attr_name_return attr_name() throws RecognitionException {
        CliParser.attr_name_return retval = new CliParser.attr_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier265=null;

        CommonTree Identifier265_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:461:5: ( Identifier )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:461:7: Identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier265=(Token)match(input,Identifier,FOLLOW_Identifier_in_attr_name3625); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier265_tree = (CommonTree)adaptor.create(Identifier265);
            adaptor.addChild(root_0, Identifier265_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attr_name"

    public static class attrValueString_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrValueString"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:464:1: attrValueString : ( Identifier | StringLiteral ) ;
    public final CliParser.attrValueString_return attrValueString() throws RecognitionException {
        CliParser.attrValueString_return retval = new CliParser.attrValueString_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set266=null;

        CommonTree set266_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:465:5: ( ( Identifier | StringLiteral ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:465:7: ( Identifier | StringLiteral )
            {
            root_0 = (CommonTree)adaptor.nil();

            set266=(Token)input.LT(1);
            if ( (input.LA(1)>=Identifier && input.LA(1)<=StringLiteral) ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set266));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attrValueString"

    public static class attrValueInt_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrValueInt"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:468:1: attrValueInt : ( IntegerPositiveLiteral | IntegerNegativeLiteral );
    public final CliParser.attrValueInt_return attrValueInt() throws RecognitionException {
        CliParser.attrValueInt_return retval = new CliParser.attrValueInt_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set267=null;

        CommonTree set267_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:469:5: ( IntegerPositiveLiteral | IntegerNegativeLiteral )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set267=(Token)input.LT(1);
            if ( input.LA(1)==IntegerPositiveLiteral||input.LA(1)==IntegerNegativeLiteral ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set267));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attrValueInt"

    public static class attrValueDouble_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "attrValueDouble"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:473:1: attrValueDouble : DoubleLiteral ;
    public final CliParser.attrValueDouble_return attrValueDouble() throws RecognitionException {
        CliParser.attrValueDouble_return retval = new CliParser.attrValueDouble_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DoubleLiteral268=null;

        CommonTree DoubleLiteral268_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:474:5: ( DoubleLiteral )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:474:7: DoubleLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            DoubleLiteral268=(Token)match(input,DoubleLiteral,FOLLOW_DoubleLiteral_in_attrValueDouble3694); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DoubleLiteral268_tree = (CommonTree)adaptor.create(DoubleLiteral268);
            adaptor.addChild(root_0, DoubleLiteral268_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attrValueDouble"

    public static class keyspace_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyspace"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:477:1: keyspace : entityName ;
    public final CliParser.keyspace_return keyspace() throws RecognitionException {
        CliParser.keyspace_return retval = new CliParser.keyspace_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.entityName_return entityName269 = null;



        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:478:2: ( entityName )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:478:4: entityName
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_entityName_in_keyspace3710);
            entityName269=entityName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, entityName269.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyspace"

    public static class replica_placement_strategy_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "replica_placement_strategy"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:481:1: replica_placement_strategy : StringLiteral ;
    public final CliParser.replica_placement_strategy_return replica_placement_strategy() throws RecognitionException {
        CliParser.replica_placement_strategy_return retval = new CliParser.replica_placement_strategy_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token StringLiteral270=null;

        CommonTree StringLiteral270_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:482:5: ( StringLiteral )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:482:7: StringLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            StringLiteral270=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_replica_placement_strategy3724); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            StringLiteral270_tree = (CommonTree)adaptor.create(StringLiteral270);
            adaptor.addChild(root_0, StringLiteral270_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "replica_placement_strategy"

    public static class keyspaceNewName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "keyspaceNewName"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:485:1: keyspaceNewName : entityName ;
    public final CliParser.keyspaceNewName_return keyspaceNewName() throws RecognitionException {
        CliParser.keyspaceNewName_return retval = new CliParser.keyspaceNewName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.entityName_return entityName271 = null;



        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:486:2: ( entityName )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:486:4: entityName
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_entityName_in_keyspaceNewName3738);
            entityName271=entityName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, entityName271.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "keyspaceNewName"

    public static class comparator_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "comparator"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:489:1: comparator : StringLiteral ;
    public final CliParser.comparator_return comparator() throws RecognitionException {
        CliParser.comparator_return retval = new CliParser.comparator_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token StringLiteral272=null;

        CommonTree StringLiteral272_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:490:5: ( StringLiteral )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:490:7: StringLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            StringLiteral272=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_comparator3752); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            StringLiteral272_tree = (CommonTree)adaptor.create(StringLiteral272);
            adaptor.addChild(root_0, StringLiteral272_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "comparator"

    public static class command_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "command"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:493:1: command : Identifier ;
    public final CliParser.command_return command() throws RecognitionException {
        CliParser.command_return retval = new CliParser.command_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier273=null;

        CommonTree Identifier273_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:493:9: ( Identifier )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:493:11: Identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier273=(Token)match(input,Identifier,FOLLOW_Identifier_in_command3771); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier273_tree = (CommonTree)adaptor.create(Identifier273);
            adaptor.addChild(root_0, Identifier273_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "command"

    public static class newColumnFamily_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "newColumnFamily"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:496:1: newColumnFamily : entityName ;
    public final CliParser.newColumnFamily_return newColumnFamily() throws RecognitionException {
        CliParser.newColumnFamily_return retval = new CliParser.newColumnFamily_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.entityName_return entityName274 = null;



        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:497:2: ( entityName )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:497:4: entityName
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_entityName_in_newColumnFamily3785);
            entityName274=entityName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, entityName274.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "newColumnFamily"

    public static class username_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "username"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:500:1: username : Identifier ;
    public final CliParser.username_return username() throws RecognitionException {
        CliParser.username_return retval = new CliParser.username_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier275=null;

        CommonTree Identifier275_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:500:9: ( Identifier )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:500:11: Identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier275=(Token)match(input,Identifier,FOLLOW_Identifier_in_username3794); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier275_tree = (CommonTree)adaptor.create(Identifier275);
            adaptor.addChild(root_0, Identifier275_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "username"

    public static class password_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "password"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:503:1: password : StringLiteral ;
    public final CliParser.password_return password() throws RecognitionException {
        CliParser.password_return retval = new CliParser.password_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token StringLiteral276=null;

        CommonTree StringLiteral276_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:503:9: ( StringLiteral )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:503:11: StringLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            StringLiteral276=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_password3806); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            StringLiteral276_tree = (CommonTree)adaptor.create(StringLiteral276);
            adaptor.addChild(root_0, StringLiteral276_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "password"

    public static class columnFamily_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "columnFamily"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:506:1: columnFamily : entityName ;
    public final CliParser.columnFamily_return columnFamily() throws RecognitionException {
        CliParser.columnFamily_return retval = new CliParser.columnFamily_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.entityName_return entityName277 = null;



        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:507:3: ( entityName )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:507:5: entityName
            {
            root_0 = (CommonTree)adaptor.nil();

            pushFollow(FOLLOW_entityName_in_columnFamily3821);
            entityName277=entityName();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) adaptor.addChild(root_0, entityName277.getTree());

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "columnFamily"

    public static class entityName_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "entityName"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:510:1: entityName : ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral ) ;
    public final CliParser.entityName_return entityName() throws RecognitionException {
        CliParser.entityName_return retval = new CliParser.entityName_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set278=null;

        CommonTree set278_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:511:3: ( ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:511:5: ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral )
            {
            root_0 = (CommonTree)adaptor.nil();

            set278=(Token)input.LT(1);
            if ( (input.LA(1)>=IntegerPositiveLiteral && input.LA(1)<=StringLiteral)||input.LA(1)==IntegerNegativeLiteral ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set278));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "entityName"

    public static class rowKey_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rowKey"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:514:1: rowKey : ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall ) ;
    public final CliParser.rowKey_return rowKey() throws RecognitionException {
        CliParser.rowKey_return retval = new CliParser.rowKey_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier279=null;
        Token StringLiteral280=null;
        Token IntegerPositiveLiteral281=null;
        Token IntegerNegativeLiteral282=null;
        CliParser.functionCall_return functionCall283 = null;


        CommonTree Identifier279_tree=null;
        CommonTree StringLiteral280_tree=null;
        CommonTree IntegerPositiveLiteral281_tree=null;
        CommonTree IntegerNegativeLiteral282_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:515:5: ( ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:515:8: ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall )
            {
            root_0 = (CommonTree)adaptor.nil();

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:515:8: ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall )
            int alt37=5;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA37_1 = input.LA(2);

                if ( (LA37_1==131) ) {
                    alt37=5;
                }
                else if ( (LA37_1==125||LA37_1==128) ) {
                    alt37=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 37, 1, input);

                    throw nvae;
                }
                }
                break;
            case StringLiteral:
                {
                alt37=2;
                }
                break;
            case IntegerPositiveLiteral:
                {
                alt37=3;
                }
                break;
            case IntegerNegativeLiteral:
                {
                alt37=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:515:9: Identifier
                    {
                    Identifier279=(Token)match(input,Identifier,FOLLOW_Identifier_in_rowKey3866); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Identifier279_tree = (CommonTree)adaptor.create(Identifier279);
                    adaptor.addChild(root_0, Identifier279_tree);
                    }

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:515:22: StringLiteral
                    {
                    StringLiteral280=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_rowKey3870); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    StringLiteral280_tree = (CommonTree)adaptor.create(StringLiteral280);
                    adaptor.addChild(root_0, StringLiteral280_tree);
                    }

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:515:38: IntegerPositiveLiteral
                    {
                    IntegerPositiveLiteral281=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_rowKey3874); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerPositiveLiteral281_tree = (CommonTree)adaptor.create(IntegerPositiveLiteral281);
                    adaptor.addChild(root_0, IntegerPositiveLiteral281_tree);
                    }

                    }
                    break;
                case 4 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:515:63: IntegerNegativeLiteral
                    {
                    IntegerNegativeLiteral282=(Token)match(input,IntegerNegativeLiteral,FOLLOW_IntegerNegativeLiteral_in_rowKey3878); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerNegativeLiteral282_tree = (CommonTree)adaptor.create(IntegerNegativeLiteral282);
                    adaptor.addChild(root_0, IntegerNegativeLiteral282_tree);
                    }

                    }
                    break;
                case 5 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:515:88: functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_rowKey3882);
                    functionCall283=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCall283.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rowKey"

    public static class rowValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "rowValue"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:518:1: rowValue : ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall | hashConstruct ) ;
    public final CliParser.rowValue_return rowValue() throws RecognitionException {
        CliParser.rowValue_return retval = new CliParser.rowValue_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier284=null;
        Token StringLiteral285=null;
        Token IntegerPositiveLiteral286=null;
        Token IntegerNegativeLiteral287=null;
        CliParser.functionCall_return functionCall288 = null;

        CliParser.hashConstruct_return hashConstruct289 = null;


        CommonTree Identifier284_tree=null;
        CommonTree StringLiteral285_tree=null;
        CommonTree IntegerPositiveLiteral286_tree=null;
        CommonTree IntegerNegativeLiteral287_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:519:5: ( ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall | hashConstruct ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:519:8: ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall | hashConstruct )
            {
            root_0 = (CommonTree)adaptor.nil();

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:519:8: ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral | functionCall | hashConstruct )
            int alt38=6;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA38_1 = input.LA(2);

                if ( (LA38_1==131) ) {
                    alt38=5;
                }
                else if ( (LA38_1==EOF||LA38_1==124||LA38_1==127) ) {
                    alt38=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 38, 1, input);

                    throw nvae;
                }
                }
                break;
            case StringLiteral:
                {
                alt38=2;
                }
                break;
            case IntegerPositiveLiteral:
                {
                alt38=3;
                }
                break;
            case IntegerNegativeLiteral:
                {
                alt38=4;
                }
                break;
            case 126:
                {
                alt38=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:519:9: Identifier
                    {
                    Identifier284=(Token)match(input,Identifier,FOLLOW_Identifier_in_rowValue3904); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Identifier284_tree = (CommonTree)adaptor.create(Identifier284);
                    adaptor.addChild(root_0, Identifier284_tree);
                    }

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:519:22: StringLiteral
                    {
                    StringLiteral285=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_rowValue3908); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    StringLiteral285_tree = (CommonTree)adaptor.create(StringLiteral285);
                    adaptor.addChild(root_0, StringLiteral285_tree);
                    }

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:519:38: IntegerPositiveLiteral
                    {
                    IntegerPositiveLiteral286=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_rowValue3912); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerPositiveLiteral286_tree = (CommonTree)adaptor.create(IntegerPositiveLiteral286);
                    adaptor.addChild(root_0, IntegerPositiveLiteral286_tree);
                    }

                    }
                    break;
                case 4 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:519:63: IntegerNegativeLiteral
                    {
                    IntegerNegativeLiteral287=(Token)match(input,IntegerNegativeLiteral,FOLLOW_IntegerNegativeLiteral_in_rowValue3916); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerNegativeLiteral287_tree = (CommonTree)adaptor.create(IntegerNegativeLiteral287);
                    adaptor.addChild(root_0, IntegerNegativeLiteral287_tree);
                    }

                    }
                    break;
                case 5 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:519:88: functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_rowValue3920);
                    functionCall288=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCall288.getTree());

                    }
                    break;
                case 6 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:519:103: hashConstruct
                    {
                    pushFollow(FOLLOW_hashConstruct_in_rowValue3924);
                    hashConstruct289=hashConstruct();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, hashConstruct289.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "rowValue"

    public static class value_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "value"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:522:1: value : ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall ) ;
    public final CliParser.value_return value() throws RecognitionException {
        CliParser.value_return retval = new CliParser.value_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier290=null;
        Token IntegerPositiveLiteral291=null;
        Token IntegerNegativeLiteral292=null;
        Token StringLiteral293=null;
        CliParser.functionCall_return functionCall294 = null;


        CommonTree Identifier290_tree=null;
        CommonTree IntegerPositiveLiteral291_tree=null;
        CommonTree IntegerNegativeLiteral292_tree=null;
        CommonTree StringLiteral293_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:523:5: ( ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:523:7: ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall )
            {
            root_0 = (CommonTree)adaptor.nil();

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:523:7: ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall )
            int alt39=5;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA39_1 = input.LA(2);

                if ( (LA39_1==131) ) {
                    alt39=5;
                }
                else if ( (LA39_1==EOF||LA39_1==SEMICOLON||LA39_1==WITH||LA39_1==AND||LA39_1==LIMIT) ) {
                    alt39=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 39, 1, input);

                    throw nvae;
                }
                }
                break;
            case IntegerPositiveLiteral:
                {
                alt39=2;
                }
                break;
            case IntegerNegativeLiteral:
                {
                alt39=3;
                }
                break;
            case StringLiteral:
                {
                alt39=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:523:8: Identifier
                    {
                    Identifier290=(Token)match(input,Identifier,FOLLOW_Identifier_in_value3946); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Identifier290_tree = (CommonTree)adaptor.create(Identifier290);
                    adaptor.addChild(root_0, Identifier290_tree);
                    }

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:523:21: IntegerPositiveLiteral
                    {
                    IntegerPositiveLiteral291=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_value3950); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerPositiveLiteral291_tree = (CommonTree)adaptor.create(IntegerPositiveLiteral291);
                    adaptor.addChild(root_0, IntegerPositiveLiteral291_tree);
                    }

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:523:46: IntegerNegativeLiteral
                    {
                    IntegerNegativeLiteral292=(Token)match(input,IntegerNegativeLiteral,FOLLOW_IntegerNegativeLiteral_in_value3954); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerNegativeLiteral292_tree = (CommonTree)adaptor.create(IntegerNegativeLiteral292);
                    adaptor.addChild(root_0, IntegerNegativeLiteral292_tree);
                    }

                    }
                    break;
                case 4 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:523:71: StringLiteral
                    {
                    StringLiteral293=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_value3958); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    StringLiteral293_tree = (CommonTree)adaptor.create(StringLiteral293);
                    adaptor.addChild(root_0, StringLiteral293_tree);
                    }

                    }
                    break;
                case 5 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:523:87: functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_value3962);
                    functionCall294=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCall294.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "value"

    public static class functionCall_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionCall"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:526:1: functionCall : functionName= Identifier '(' ( functionArgument )? ')' -> ^( FUNCTION_CALL $functionName ( functionArgument )? ) ;
    public final CliParser.functionCall_return functionCall() throws RecognitionException {
        CliParser.functionCall_return retval = new CliParser.functionCall_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token functionName=null;
        Token char_literal295=null;
        Token char_literal297=null;
        CliParser.functionArgument_return functionArgument296 = null;


        CommonTree functionName_tree=null;
        CommonTree char_literal295_tree=null;
        CommonTree char_literal297_tree=null;
        RewriteRuleTokenStream stream_132=new RewriteRuleTokenStream(adaptor,"token 132");
        RewriteRuleTokenStream stream_Identifier=new RewriteRuleTokenStream(adaptor,"token Identifier");
        RewriteRuleTokenStream stream_131=new RewriteRuleTokenStream(adaptor,"token 131");
        RewriteRuleSubtreeStream stream_functionArgument=new RewriteRuleSubtreeStream(adaptor,"rule functionArgument");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:527:5: (functionName= Identifier '(' ( functionArgument )? ')' -> ^( FUNCTION_CALL $functionName ( functionArgument )? ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:527:7: functionName= Identifier '(' ( functionArgument )? ')'
            {
            functionName=(Token)match(input,Identifier,FOLLOW_Identifier_in_functionCall3983); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_Identifier.add(functionName);

            char_literal295=(Token)match(input,131,FOLLOW_131_in_functionCall3985); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_131.add(char_literal295);

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:527:35: ( functionArgument )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( ((LA40_0>=IntegerPositiveLiteral && LA40_0<=StringLiteral)||LA40_0==IntegerNegativeLiteral) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:0:0: functionArgument
                    {
                    pushFollow(FOLLOW_functionArgument_in_functionCall3987);
                    functionArgument296=functionArgument();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) stream_functionArgument.add(functionArgument296.getTree());

                    }
                    break;

            }

            char_literal297=(Token)match(input,132,FOLLOW_132_in_functionCall3990); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_132.add(char_literal297);



            // AST REWRITE
            // elements: functionName, functionArgument
            // token labels: functionName
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleTokenStream stream_functionName=new RewriteRuleTokenStream(adaptor,"token functionName",functionName);
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 528:9: -> ^( FUNCTION_CALL $functionName ( functionArgument )? )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:528:12: ^( FUNCTION_CALL $functionName ( functionArgument )? )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(FUNCTION_CALL, "FUNCTION_CALL"), root_1);

                adaptor.addChild(root_1, stream_functionName.nextNode());
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:528:42: ( functionArgument )?
                if ( stream_functionArgument.hasNext() ) {
                    adaptor.addChild(root_1, stream_functionArgument.nextTree());

                }
                stream_functionArgument.reset();

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionCall"

    public static class functionArgument_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "functionArgument"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:531:1: functionArgument : ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral );
    public final CliParser.functionArgument_return functionArgument() throws RecognitionException {
        CliParser.functionArgument_return retval = new CliParser.functionArgument_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set298=null;

        CommonTree set298_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:532:5: ( Identifier | StringLiteral | IntegerPositiveLiteral | IntegerNegativeLiteral )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set298=(Token)input.LT(1);
            if ( (input.LA(1)>=IntegerPositiveLiteral && input.LA(1)<=StringLiteral)||input.LA(1)==IntegerNegativeLiteral ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set298));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "functionArgument"

    public static class columnOrSuperColumn_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "columnOrSuperColumn"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:535:1: columnOrSuperColumn : ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall ) ;
    public final CliParser.columnOrSuperColumn_return columnOrSuperColumn() throws RecognitionException {
        CliParser.columnOrSuperColumn_return retval = new CliParser.columnOrSuperColumn_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier299=null;
        Token IntegerPositiveLiteral300=null;
        Token IntegerNegativeLiteral301=null;
        Token StringLiteral302=null;
        CliParser.functionCall_return functionCall303 = null;


        CommonTree Identifier299_tree=null;
        CommonTree IntegerPositiveLiteral300_tree=null;
        CommonTree IntegerNegativeLiteral301_tree=null;
        CommonTree StringLiteral302_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:536:5: ( ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:536:7: ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall )
            {
            root_0 = (CommonTree)adaptor.nil();

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:536:7: ( Identifier | IntegerPositiveLiteral | IntegerNegativeLiteral | StringLiteral | functionCall )
            int alt41=5;
            switch ( input.LA(1) ) {
            case Identifier:
                {
                int LA41_1 = input.LA(2);

                if ( (LA41_1==131) ) {
                    alt41=5;
                }
                else if ( ((LA41_1>=117 && LA41_1<=121)||LA41_1==125) ) {
                    alt41=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return retval;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 41, 1, input);

                    throw nvae;
                }
                }
                break;
            case IntegerPositiveLiteral:
                {
                alt41=2;
                }
                break;
            case IntegerNegativeLiteral:
                {
                alt41=3;
                }
                break;
            case StringLiteral:
                {
                alt41=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return retval;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }

            switch (alt41) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:536:8: Identifier
                    {
                    Identifier299=(Token)match(input,Identifier,FOLLOW_Identifier_in_columnOrSuperColumn4058); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    Identifier299_tree = (CommonTree)adaptor.create(Identifier299);
                    adaptor.addChild(root_0, Identifier299_tree);
                    }

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:536:21: IntegerPositiveLiteral
                    {
                    IntegerPositiveLiteral300=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_columnOrSuperColumn4062); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerPositiveLiteral300_tree = (CommonTree)adaptor.create(IntegerPositiveLiteral300);
                    adaptor.addChild(root_0, IntegerPositiveLiteral300_tree);
                    }

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:536:46: IntegerNegativeLiteral
                    {
                    IntegerNegativeLiteral301=(Token)match(input,IntegerNegativeLiteral,FOLLOW_IntegerNegativeLiteral_in_columnOrSuperColumn4066); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    IntegerNegativeLiteral301_tree = (CommonTree)adaptor.create(IntegerNegativeLiteral301);
                    adaptor.addChild(root_0, IntegerNegativeLiteral301_tree);
                    }

                    }
                    break;
                case 4 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:536:71: StringLiteral
                    {
                    StringLiteral302=(Token)match(input,StringLiteral,FOLLOW_StringLiteral_in_columnOrSuperColumn4070); if (state.failed) return retval;
                    if ( state.backtracking==0 ) {
                    StringLiteral302_tree = (CommonTree)adaptor.create(StringLiteral302);
                    adaptor.addChild(root_0, StringLiteral302_tree);
                    }

                    }
                    break;
                case 5 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:536:87: functionCall
                    {
                    pushFollow(FOLLOW_functionCall_in_columnOrSuperColumn4074);
                    functionCall303=functionCall();

                    state._fsp--;
                    if (state.failed) return retval;
                    if ( state.backtracking==0 ) adaptor.addChild(root_0, functionCall303.getTree());

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "columnOrSuperColumn"

    public static class host_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "host"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:539:1: host : host_name -> ^( NODE_ID_LIST host_name ) ;
    public final CliParser.host_return host() throws RecognitionException {
        CliParser.host_return retval = new CliParser.host_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        CliParser.host_name_return host_name304 = null;


        RewriteRuleSubtreeStream stream_host_name=new RewriteRuleSubtreeStream(adaptor,"rule host_name");
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:540:5: ( host_name -> ^( NODE_ID_LIST host_name ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:540:7: host_name
            {
            pushFollow(FOLLOW_host_name_in_host4096);
            host_name304=host_name();

            state._fsp--;
            if (state.failed) return retval;
            if ( state.backtracking==0 ) stream_host_name.add(host_name304.getTree());


            // AST REWRITE
            // elements: host_name
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 541:9: -> ^( NODE_ID_LIST host_name )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:541:12: ^( NODE_ID_LIST host_name )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_ID_LIST, "NODE_ID_LIST"), root_1);

                adaptor.addChild(root_1, stream_host_name.nextTree());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "host"

    public static class host_name_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "host_name"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:544:1: host_name : Identifier ( '.' Identifier )* ;
    public final CliParser.host_name_return host_name() throws RecognitionException {
        CliParser.host_name_return retval = new CliParser.host_name_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier305=null;
        Token char_literal306=null;
        Token Identifier307=null;

        CommonTree Identifier305_tree=null;
        CommonTree char_literal306_tree=null;
        CommonTree Identifier307_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:545:5: ( Identifier ( '.' Identifier )* )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:545:7: Identifier ( '.' Identifier )*
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier305=(Token)match(input,Identifier,FOLLOW_Identifier_in_host_name4129); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier305_tree = (CommonTree)adaptor.create(Identifier305);
            adaptor.addChild(root_0, Identifier305_tree);
            }
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:545:18: ( '.' Identifier )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==122) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:545:19: '.' Identifier
            	    {
            	    char_literal306=(Token)match(input,122,FOLLOW_122_in_host_name4132); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    char_literal306_tree = (CommonTree)adaptor.create(char_literal306);
            	    adaptor.addChild(root_0, char_literal306_tree);
            	    }
            	    Identifier307=(Token)match(input,Identifier,FOLLOW_Identifier_in_host_name4134); if (state.failed) return retval;
            	    if ( state.backtracking==0 ) {
            	    Identifier307_tree = (CommonTree)adaptor.create(Identifier307);
            	    adaptor.addChild(root_0, Identifier307_tree);
            	    }

            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "host_name"

    public static class ip_address_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "ip_address"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:548:1: ip_address : IP_ADDRESS -> ^( NODE_ID_LIST IP_ADDRESS ) ;
    public final CliParser.ip_address_return ip_address() throws RecognitionException {
        CliParser.ip_address_return retval = new CliParser.ip_address_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IP_ADDRESS308=null;

        CommonTree IP_ADDRESS308_tree=null;
        RewriteRuleTokenStream stream_IP_ADDRESS=new RewriteRuleTokenStream(adaptor,"token IP_ADDRESS");

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:549:5: ( IP_ADDRESS -> ^( NODE_ID_LIST IP_ADDRESS ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:549:7: IP_ADDRESS
            {
            IP_ADDRESS308=(Token)match(input,IP_ADDRESS,FOLLOW_IP_ADDRESS_in_ip_address4157); if (state.failed) return retval; 
            if ( state.backtracking==0 ) stream_IP_ADDRESS.add(IP_ADDRESS308);



            // AST REWRITE
            // elements: IP_ADDRESS
            // token labels: 
            // rule labels: retval
            // token list labels: 
            // rule list labels: 
            // wildcard labels: 
            if ( state.backtracking==0 ) {
            retval.tree = root_0;
            RewriteRuleSubtreeStream stream_retval=new RewriteRuleSubtreeStream(adaptor,"rule retval",retval!=null?retval.tree:null);

            root_0 = (CommonTree)adaptor.nil();
            // 550:9: -> ^( NODE_ID_LIST IP_ADDRESS )
            {
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:550:12: ^( NODE_ID_LIST IP_ADDRESS )
                {
                CommonTree root_1 = (CommonTree)adaptor.nil();
                root_1 = (CommonTree)adaptor.becomeRoot((CommonTree)adaptor.create(NODE_ID_LIST, "NODE_ID_LIST"), root_1);

                adaptor.addChild(root_1, stream_IP_ADDRESS.nextNode());

                adaptor.addChild(root_0, root_1);
                }

            }

            retval.tree = root_0;}
            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "ip_address"

    public static class port_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "port"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:553:1: port : IntegerPositiveLiteral ;
    public final CliParser.port_return port() throws RecognitionException {
        CliParser.port_return retval = new CliParser.port_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token IntegerPositiveLiteral309=null;

        CommonTree IntegerPositiveLiteral309_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:554:5: ( IntegerPositiveLiteral )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:554:7: IntegerPositiveLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            IntegerPositiveLiteral309=(Token)match(input,IntegerPositiveLiteral,FOLLOW_IntegerPositiveLiteral_in_port4195); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            IntegerPositiveLiteral309_tree = (CommonTree)adaptor.create(IntegerPositiveLiteral309);
            adaptor.addChild(root_0, IntegerPositiveLiteral309_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "port"

    public static class incrementValue_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "incrementValue"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:557:1: incrementValue : ( IntegerPositiveLiteral | IntegerNegativeLiteral );
    public final CliParser.incrementValue_return incrementValue() throws RecognitionException {
        CliParser.incrementValue_return retval = new CliParser.incrementValue_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token set310=null;

        CommonTree set310_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:558:5: ( IntegerPositiveLiteral | IntegerNegativeLiteral )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:
            {
            root_0 = (CommonTree)adaptor.nil();

            set310=(Token)input.LT(1);
            if ( input.LA(1)==IntegerPositiveLiteral||input.LA(1)==IntegerNegativeLiteral ) {
                input.consume();
                if ( state.backtracking==0 ) adaptor.addChild(root_0, (CommonTree)adaptor.create(set310));
                state.errorRecovery=false;state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return retval;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "incrementValue"

    public static class traceSessionId_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "traceSessionId"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:562:1: traceSessionId : Identifier ;
    public final CliParser.traceSessionId_return traceSessionId() throws RecognitionException {
        CliParser.traceSessionId_return retval = new CliParser.traceSessionId_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token Identifier311=null;

        CommonTree Identifier311_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:563:5: ( Identifier )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:563:7: Identifier
            {
            root_0 = (CommonTree)adaptor.nil();

            Identifier311=(Token)match(input,Identifier,FOLLOW_Identifier_in_traceSessionId4237); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            Identifier311_tree = (CommonTree)adaptor.create(Identifier311);
            adaptor.addChild(root_0, Identifier311_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "traceSessionId"

    public static class tracingProbability_return extends ParserRuleReturnScope {
        CommonTree tree;
        public Object getTree() { return tree; }
    };

    // $ANTLR start "tracingProbability"
    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:566:1: tracingProbability : DoubleLiteral ;
    public final CliParser.tracingProbability_return tracingProbability() throws RecognitionException {
        CliParser.tracingProbability_return retval = new CliParser.tracingProbability_return();
        retval.start = input.LT(1);

        CommonTree root_0 = null;

        Token DoubleLiteral312=null;

        CommonTree DoubleLiteral312_tree=null;

        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:567:5: ( DoubleLiteral )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cli/Cli.g:567:7: DoubleLiteral
            {
            root_0 = (CommonTree)adaptor.nil();

            DoubleLiteral312=(Token)match(input,DoubleLiteral,FOLLOW_DoubleLiteral_in_tracingProbability4254); if (state.failed) return retval;
            if ( state.backtracking==0 ) {
            DoubleLiteral312_tree = (CommonTree)adaptor.create(DoubleLiteral312);
            adaptor.addChild(root_0, DoubleLiteral312_tree);
            }

            }

            retval.stop = input.LT(-1);

            if ( state.backtracking==0 ) {

            retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
            adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);
            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
    	retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);

        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "tracingProbability"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA6 dfa6 = new DFA6(this);
    static final String DFA2_eotS =
        "\40\uffff";
    static final String DFA2_eofS =
        "\1\24\3\uffff\1\26\33\uffff";
    static final String DFA2_minS =
        "\1\62\3\uffff\1\62\3\103\2\uffff\1\66\25\uffff";
    static final String DFA2_maxS =
        "\1\162\3\uffff\1\160\2\105\1\110\2\uffff\1\132\25\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\2\1\3\4\uffff\1\14\1\15\1\uffff\1\17\1\20\1\21\1"+
        "\23\1\24\1\25\1\26\1\27\1\30\1\32\1\5\1\4\1\6\1\7\1\10\1\11\1\12"+
        "\1\13\1\31\1\16\1\22";
    static final String DFA2_specialS =
        "\40\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\24\1\1\1\15\1\10\1\11\2\uffff\1\12\1\uffff\1\4\2\2\1\17"+
            "\3\uffff\1\5\1\uffff\1\6\2\uffff\1\7\1\uffff\1\14\2\16\1\13"+
            "\1\3\1\20\1\21\1\22\1\23\40\uffff\1\15",
            "",
            "",
            "",
            "\1\26\37\uffff\3\26\5\uffff\1\26\25\uffff\1\25",
            "\1\27\1\uffff\1\30",
            "\1\31\1\uffff\1\32",
            "\1\34\1\uffff\1\33\2\uffff\1\35",
            "",
            "",
            "\1\36\33\uffff\3\37\5\uffff\1\37",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA2_eot = DFA.unpackEncodedString(DFA2_eotS);
    static final short[] DFA2_eof = DFA.unpackEncodedString(DFA2_eofS);
    static final char[] DFA2_min = DFA.unpackEncodedStringToUnsignedChars(DFA2_minS);
    static final char[] DFA2_max = DFA.unpackEncodedStringToUnsignedChars(DFA2_maxS);
    static final short[] DFA2_accept = DFA.unpackEncodedString(DFA2_acceptS);
    static final short[] DFA2_special = DFA.unpackEncodedString(DFA2_specialS);
    static final short[][] DFA2_transition;

    static {
        int numStates = DFA2_transitionS.length;
        DFA2_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA2_transition[i] = DFA.unpackEncodedString(DFA2_transitionS[i]);
        }
    }

    class DFA2 extends DFA {

        public DFA2(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 2;
            this.eot = DFA2_eot;
            this.eof = DFA2_eof;
            this.min = DFA2_min;
            this.max = DFA2_max;
            this.accept = DFA2_accept;
            this.special = DFA2_special;
            this.transition = DFA2_transition;
        }
        public String getDescription() {
            return "137:1: statement : ( connectStatement | exitStatement | countStatement | describeTable | describeCluster | addKeyspace | addColumnFamily | updateKeyspace | updateColumnFamily | delColumnFamily | delKeyspace | useKeyspace | traceNextQuery | setTraceProbability | delStatement | getStatement | helpStatement | setStatement | incrStatement | showStatement | listStatement | truncateStatement | assumeStatement | consistencyLevelStatement | dropIndex | -> ^( NODE_NO_OP ) );";
        }
    }
    static final String DFA6_eotS =
        "\50\uffff";
    static final String DFA6_eofS =
        "\1\uffff\1\30\5\uffff\1\32\1\34\37\uffff";
    static final String DFA6_minS =
        "\1\64\1\62\5\uffff\2\62\2\uffff\1\77\3\103\31\uffff";
    static final String DFA6_maxS =
        "\1\162\1\121\5\uffff\1\66\1\160\2\uffff\1\161\2\105\1\110\31\uffff";
    static final String DFA6_acceptS =
        "\2\uffff\1\40\1\1\1\2\1\3\1\4\2\uffff\1\10\1\11\4\uffff\1\25\1"+
        "\27\1\30\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\5\1\26\1\7\1\6\1\12"+
        "\1\13\1\14\1\15\1\16\1\20\1\17\1\21\1\22\1\23\1\24";
    static final String DFA6_specialS =
        "\50\uffff}>";
    static final String[] DFA6_transitionS = {
            "\1\1\75\uffff\1\2",
            "\1\30\1\4\1\3\1\5\1\6\2\uffff\1\7\1\uffff\1\10\1\11\1\12\1"+
            "\13\3\uffff\1\14\1\uffff\1\15\2\uffff\1\16\1\uffff\1\17\1\20"+
            "\1\21\1\22\1\23\1\24\1\25\1\26\1\27",
            "",
            "",
            "",
            "",
            "",
            "\1\32\3\uffff\1\31",
            "\1\34\75\uffff\1\33",
            "",
            "",
            "\1\36\1\37\1\40\57\uffff\1\35",
            "\1\41\1\uffff\1\42",
            "\1\43\1\uffff\1\44",
            "\1\45\1\uffff\1\46\2\uffff\1\47",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA6_eot = DFA.unpackEncodedString(DFA6_eotS);
    static final short[] DFA6_eof = DFA.unpackEncodedString(DFA6_eofS);
    static final char[] DFA6_min = DFA.unpackEncodedStringToUnsignedChars(DFA6_minS);
    static final char[] DFA6_max = DFA.unpackEncodedStringToUnsignedChars(DFA6_maxS);
    static final short[] DFA6_accept = DFA.unpackEncodedString(DFA6_acceptS);
    static final short[] DFA6_special = DFA.unpackEncodedString(DFA6_specialS);
    static final short[][] DFA6_transition;

    static {
        int numStates = DFA6_transitionS.length;
        DFA6_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA6_transition[i] = DFA.unpackEncodedString(DFA6_transitionS[i]);
        }
    }

    class DFA6 extends DFA {

        public DFA6(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 6;
            this.eot = DFA6_eot;
            this.eof = DFA6_eof;
            this.min = DFA6_min;
            this.max = DFA6_max;
            this.accept = DFA6_accept;
            this.special = DFA6_special;
            this.transition = DFA6_transition;
        }
        public String getDescription() {
            return "173:1: helpStatement : ( HELP HELP -> ^( NODE_HELP NODE_HELP ) | HELP CONNECT -> ^( NODE_HELP NODE_CONNECT ) | HELP USE -> ^( NODE_HELP NODE_USE_TABLE ) | HELP TRACE NEXT QUERY -> ^( NODE_HELP NODE_TRACE_NEXT_QUERY ) | HELP SET TRACE PROBABILITY -> ^( NODE_HELP NODE_SET_TRACE_PROBABILITY ) | HELP DESCRIBE -> ^( NODE_HELP NODE_DESCRIBE ) | HELP DESCRIBE 'CLUSTER' -> ^( NODE_HELP NODE_DESCRIBE_CLUSTER ) | HELP EXIT -> ^( NODE_HELP NODE_EXIT ) | HELP QUIT -> ^( NODE_HELP NODE_EXIT ) | HELP SHOW 'CLUSTER NAME' -> ^( NODE_HELP NODE_SHOW_CLUSTER_NAME ) | HELP SHOW KEYSPACES -> ^( NODE_HELP NODE_SHOW_KEYSPACES ) | HELP SHOW SCHEMA -> ^( NODE_HELP NODE_SHOW_SCHEMA ) | HELP SHOW API_VERSION -> ^( NODE_HELP NODE_SHOW_VERSION ) | HELP CREATE KEYSPACE -> ^( NODE_HELP NODE_ADD_KEYSPACE ) | HELP UPDATE KEYSPACE -> ^( NODE_HELP NODE_UPDATE_KEYSPACE ) | HELP CREATE COLUMN FAMILY -> ^( NODE_HELP NODE_ADD_COLUMN_FAMILY ) | HELP UPDATE COLUMN FAMILY -> ^( NODE_HELP NODE_UPDATE_COLUMN_FAMILY ) | HELP DROP KEYSPACE -> ^( NODE_HELP NODE_DEL_KEYSPACE ) | HELP DROP COLUMN FAMILY -> ^( NODE_HELP NODE_DEL_COLUMN_FAMILY ) | HELP DROP INDEX -> ^( NODE_HELP NODE_DROP_INDEX ) | HELP GET -> ^( NODE_HELP NODE_THRIFT_GET ) | HELP SET -> ^( NODE_HELP NODE_THRIFT_SET ) | HELP INCR -> ^( NODE_HELP NODE_THRIFT_INCR ) | HELP DECR -> ^( NODE_HELP NODE_THRIFT_DECR ) | HELP DEL -> ^( NODE_HELP NODE_THRIFT_DEL ) | HELP COUNT -> ^( NODE_HELP NODE_THRIFT_COUNT ) | HELP LIST -> ^( NODE_HELP NODE_LIST ) | HELP TRUNCATE -> ^( NODE_HELP NODE_TRUNCATE ) | HELP ASSUME -> ^( NODE_HELP NODE_ASSUME ) | HELP CONSISTENCYLEVEL -> ^( NODE_HELP NODE_CONSISTENCY_LEVEL ) | HELP -> ^( NODE_HELP ) | '?' -> ^( NODE_HELP ) );";
        }
    }
 

    public static final BitSet FOLLOW_statement_in_root449 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_SEMICOLON_in_root451 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_root454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_connectStatement_in_statement470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_exitStatement_in_statement478 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_countStatement_in_statement486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_describeTable_in_statement494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_describeCluster_in_statement502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_addKeyspace_in_statement510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_addColumnFamily_in_statement518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateKeyspace_in_statement526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateColumnFamily_in_statement534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delColumnFamily_in_statement542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delKeyspace_in_statement550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_useKeyspace_in_statement558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_traceNextQuery_in_statement566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setTraceProbability_in_statement574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_delStatement_in_statement582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_getStatement_in_statement590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_helpStatement_in_statement598 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_setStatement_in_statement606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_incrStatement_in_statement614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_showStatement_in_statement622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listStatement_in_statement630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_truncateStatement_in_statement638 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assumeStatement_in_statement646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_consistencyLevelStatement_in_statement654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropIndex_in_statement662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONNECT_in_connectStatement691 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_host_in_connectStatement693 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_connectStatement695 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_port_in_connectStatement697 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_username_in_connectStatement700 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_password_in_connectStatement702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONNECT_in_connectStatement737 = new BitSet(new long[]{0x0000000000000000L,0x0000000010000000L});
    public static final BitSet FOLLOW_ip_address_in_connectStatement739 = new BitSet(new long[]{0x0000000000000000L,0x0000800000000000L});
    public static final BitSet FOLLOW_111_in_connectStatement741 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_port_in_connectStatement743 = new BitSet(new long[]{0x0000000000000002L,0x0000000000080000L});
    public static final BitSet FOLLOW_username_in_connectStatement746 = new BitSet(new long[]{0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_password_in_connectStatement748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement792 = new BitSet(new long[]{0x0010000000000000L});
    public static final BitSet FOLLOW_HELP_in_helpStatement794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement819 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_CONNECT_in_helpStatement821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement846 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_USE_in_helpStatement848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement873 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_TRACE_in_helpStatement875 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_NEXT_in_helpStatement877 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_QUERY_in_helpStatement879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement903 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_SET_in_helpStatement905 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_TRACE_in_helpStatement907 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_PROBABILITY_in_helpStatement909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement933 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_DESCRIBE_in_helpStatement935 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement959 = new BitSet(new long[]{0x0800000000000000L});
    public static final BitSet FOLLOW_DESCRIBE_in_helpStatement961 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_112_in_helpStatement963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement987 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_EXIT_in_helpStatement989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1014 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_QUIT_in_helpStatement1016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1041 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_SHOW_in_helpStatement1043 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_helpStatement1045 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1069 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_SHOW_in_helpStatement1071 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_KEYSPACES_in_helpStatement1073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1098 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_SHOW_in_helpStatement1100 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_SCHEMA_in_helpStatement1102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1130 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_SHOW_in_helpStatement1132 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_API_VERSION_in_helpStatement1134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1158 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_CREATE_in_helpStatement1160 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYSPACE_in_helpStatement1162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1187 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_UPDATE_in_helpStatement1189 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYSPACE_in_helpStatement1191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1215 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_CREATE_in_helpStatement1217 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_COLUMN_in_helpStatement1219 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_FAMILY_in_helpStatement1221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1246 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_UPDATE_in_helpStatement1248 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_COLUMN_in_helpStatement1250 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_FAMILY_in_helpStatement1252 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1276 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_DROP_in_helpStatement1278 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYSPACE_in_helpStatement1280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1305 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_DROP_in_helpStatement1307 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_COLUMN_in_helpStatement1309 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_FAMILY_in_helpStatement1311 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1336 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_DROP_in_helpStatement1338 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_INDEX_in_helpStatement1340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1364 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_GET_in_helpStatement1366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1391 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_SET_in_helpStatement1393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1418 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_INCR_in_helpStatement1420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1444 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_DECR_in_helpStatement1446 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1470 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_DEL_in_helpStatement1472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1497 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_COUNT_in_helpStatement1499 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1524 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_LIST_in_helpStatement1526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1551 = new BitSet(new long[]{0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_TRUNCATE_in_helpStatement1553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1577 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_ASSUME_in_helpStatement1579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1603 = new BitSet(new long[]{0x0000000000000000L,0x0000000000020000L});
    public static final BitSet FOLLOW_CONSISTENCYLEVEL_in_helpStatement1605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HELP_in_helpStatement1629 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_114_in_helpStatement1652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUIT_in_exitStatement1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_EXIT_in_exitStatement1701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_in_getStatement1724 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_columnFamilyExpr_in_getStatement1726 = new BitSet(new long[]{0x0000000000000002L,0x0008000080000000L});
    public static final BitSet FOLLOW_115_in_getStatement1729 = new BitSet(new long[]{0x0000000000000000L,0x00000000001C0000L});
    public static final BitSet FOLLOW_typeIdentifier_in_getStatement1731 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L});
    public static final BitSet FOLLOW_LIMIT_in_getStatement1736 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_getStatement1740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_GET_in_getStatement1785 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_columnFamily_in_getStatement1787 = new BitSet(new long[]{0x0000000000000000L,0x0010000000000000L});
    public static final BitSet FOLLOW_116_in_getStatement1789 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_getCondition_in_getStatement1791 = new BitSet(new long[]{0x0000000000000002L,0x0000000082000000L});
    public static final BitSet FOLLOW_AND_in_getStatement1794 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_getCondition_in_getStatement1796 = new BitSet(new long[]{0x0000000000000002L,0x0000000082000000L});
    public static final BitSet FOLLOW_LIMIT_in_getStatement1801 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_getStatement1805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_columnOrSuperColumn_in_getCondition1856 = new BitSet(new long[]{0x0000000000000000L,0x03E0000000000000L});
    public static final BitSet FOLLOW_operator_in_getCondition1858 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_value_in_getCondition1860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_operator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_typeIdentifier0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_setStatement1956 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_columnFamilyExpr_in_setStatement1958 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_setStatement1960 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_value_in_setStatement1964 = new BitSet(new long[]{0x0000000000000002L,0x0000000000200000L});
    public static final BitSet FOLLOW_WITH_in_setStatement1967 = new BitSet(new long[]{0x0000000000000000L,0x0000000000400000L});
    public static final BitSet FOLLOW_TTL_in_setStatement1969 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_setStatement1971 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_setStatement1975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INCR_in_incrStatement2021 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_columnFamilyExpr_in_incrStatement2023 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_BY_in_incrStatement2026 = new BitSet(new long[]{0x0000000000000000L,0x0000000004040000L});
    public static final BitSet FOLLOW_incrementValue_in_incrStatement2030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DECR_in_incrStatement2064 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_columnFamilyExpr_in_incrStatement2066 = new BitSet(new long[]{0x0000000000000002L,0x0000000000800000L});
    public static final BitSet FOLLOW_BY_in_incrStatement2069 = new BitSet(new long[]{0x0000000000000000L,0x0000000004040000L});
    public static final BitSet FOLLOW_incrementValue_in_incrStatement2073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_COUNT_in_countStatement2116 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_columnFamilyExpr_in_countStatement2118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEL_in_delStatement2152 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_columnFamilyExpr_in_delStatement2154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_showClusterName_in_showStatement2188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_showVersion_in_showStatement2196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_showKeyspaces_in_showStatement2204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_showSchema_in_showStatement2212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIST_in_listStatement2229 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_columnFamily_in_listStatement2231 = new BitSet(new long[]{0x0000000000000002L,0x0800000080000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_keyRangeExpr_in_listStatement2233 = new BitSet(new long[]{0x0000000000000002L,0x0000000080000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_rowLimitExpr_in_listStatement2236 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_columnLimitExpr_in_listStatement2239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRUNCATE_in_truncateStatement2282 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_columnFamily_in_truncateStatement2284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ASSUME_in_assumeStatement2317 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_columnFamily_in_assumeStatement2319 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_Identifier_in_assumeStatement2323 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_assumeStatement2325 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_entityName_in_assumeStatement2327 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CONSISTENCYLEVEL_in_consistencyLevelStatement2365 = new BitSet(new long[]{0x0000000000000000L,0x0008000000000000L});
    public static final BitSet FOLLOW_115_in_consistencyLevelStatement2367 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_Identifier_in_consistencyLevelStatement2371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_showClusterName2405 = new BitSet(new long[]{0x0000000000000000L,0x0002000000000000L});
    public static final BitSet FOLLOW_113_in_showClusterName2407 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_addKeyspace2438 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYSPACE_in_addKeyspace2440 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_keyValuePairExpr_in_addKeyspace2442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_CREATE_in_addColumnFamily2476 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_COLUMN_in_addColumnFamily2478 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_FAMILY_in_addColumnFamily2480 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_keyValuePairExpr_in_addColumnFamily2482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_in_updateKeyspace2516 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYSPACE_in_updateKeyspace2518 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_keyValuePairExpr_in_updateKeyspace2520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UPDATE_in_updateColumnFamily2553 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_COLUMN_in_updateColumnFamily2555 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_FAMILY_in_updateColumnFamily2557 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_keyValuePairExpr_in_updateColumnFamily2559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_delKeyspace2592 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_KEYSPACE_in_delKeyspace2594 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_keyspace_in_delKeyspace2596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_delColumnFamily2630 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_COLUMN_in_delColumnFamily2632 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_FAMILY_in_delColumnFamily2634 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_columnFamily_in_delColumnFamily2636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DROP_in_dropIndex2670 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_INDEX_in_dropIndex2672 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_ON_in_dropIndex2674 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_columnFamily_in_dropIndex2676 = new BitSet(new long[]{0x0000000000000000L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_dropIndex2678 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_columnName_in_dropIndex2680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_showVersion2715 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_API_VERSION_in_showVersion2717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_showKeyspaces2748 = new BitSet(new long[]{0x8000000000000000L});
    public static final BitSet FOLLOW_KEYSPACES_in_showKeyspaces2750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SHOW_in_showSchema2782 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_SCHEMA_in_showSchema2784 = new BitSet(new long[]{0x0000000000000002L,0x00000000041C0000L});
    public static final BitSet FOLLOW_keyspace_in_showSchema2787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESCRIBE_in_describeTable2825 = new BitSet(new long[]{0x0000000000000002L,0x00000000041C0000L});
    public static final BitSet FOLLOW_keyspace_in_describeTable2828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DESCRIBE_in_describeCluster2870 = new BitSet(new long[]{0x0000000000000000L,0x0001000000000000L});
    public static final BitSet FOLLOW_112_in_describeCluster2872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_USE_in_useKeyspace2903 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_keyspace_in_useKeyspace2905 = new BitSet(new long[]{0x0000000000000002L,0x0000000000180000L});
    public static final BitSet FOLLOW_username_in_useKeyspace2909 = new BitSet(new long[]{0x0000000000000002L,0x0000000000100000L});
    public static final BitSet FOLLOW_password_in_useKeyspace2916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_TRACE_in_traceNextQuery2971 = new BitSet(new long[]{0x0080000000000000L});
    public static final BitSet FOLLOW_NEXT_in_traceNextQuery2973 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_QUERY_in_traceNextQuery2975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SET_in_setTraceProbability3006 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_TRACE_in_setTraceProbability3008 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_PROBABILITY_in_setTraceProbability3010 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_tracingProbability_in_setTraceProbability3012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entityName_in_keyValuePairExpr3045 = new BitSet(new long[]{0x0000000000000002L,0x0000000002200000L});
    public static final BitSet FOLLOW_AND_in_keyValuePairExpr3050 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_WITH_in_keyValuePairExpr3054 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_keyValuePair_in_keyValuePairExpr3057 = new BitSet(new long[]{0x0000000000000002L,0x0000000002200000L});
    public static final BitSet FOLLOW_attr_name_in_keyValuePair3114 = new BitSet(new long[]{0x0000000000000000L,0x0020000000000000L});
    public static final BitSet FOLLOW_117_in_keyValuePair3116 = new BitSet(new long[]{0x0000000000000000L,0x480000000C1C0000L});
    public static final BitSet FOLLOW_attrValue_in_keyValuePair3118 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_arrayConstruct_in_attrValue3150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hashConstruct_in_attrValue3158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attrValueString_in_attrValue3166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attrValueInt_in_attrValue3174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attrValueDouble_in_attrValue3182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_arrayConstruct3201 = new BitSet(new long[]{0x0000000000000000L,0x6000000000000000L});
    public static final BitSet FOLLOW_hashConstruct_in_arrayConstruct3204 = new BitSet(new long[]{0x0000000000000000L,0x7000000000000000L});
    public static final BitSet FOLLOW_124_in_arrayConstruct3206 = new BitSet(new long[]{0x0000000000000000L,0x6000000000000000L});
    public static final BitSet FOLLOW_125_in_arrayConstruct3211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_126_in_hashConstruct3249 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_hashElementPair_in_hashConstruct3251 = new BitSet(new long[]{0x0000000000000000L,0x9000000000000000L});
    public static final BitSet FOLLOW_124_in_hashConstruct3254 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_hashElementPair_in_hashConstruct3256 = new BitSet(new long[]{0x0000000000000000L,0x9000000000000000L});
    public static final BitSet FOLLOW_127_in_hashConstruct3260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rowKey_in_hashElementPair3296 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_128_in_hashElementPair3298 = new BitSet(new long[]{0x0000000000000000L,0x40000000041C0000L});
    public static final BitSet FOLLOW_rowValue_in_hashElementPair3300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_columnFamily_in_columnFamilyExpr3335 = new BitSet(new long[]{0x0000000000000000L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_columnFamilyExpr3337 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_rowKey_in_columnFamilyExpr3339 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_125_in_columnFamilyExpr3341 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_columnFamilyExpr3354 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_columnOrSuperColumn_in_columnFamilyExpr3358 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_125_in_columnFamilyExpr3360 = new BitSet(new long[]{0x0000000000000002L,0x0800000000000000L});
    public static final BitSet FOLLOW_123_in_columnFamilyExpr3376 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L});
    public static final BitSet FOLLOW_columnOrSuperColumn_in_columnFamilyExpr3380 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_125_in_columnFamilyExpr3382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_123_in_keyRangeExpr3445 = new BitSet(new long[]{0x0000000000000000L,0x20000000041C0000L,0x0000000000000001L});
    public static final BitSet FOLLOW_entityName_in_keyRangeExpr3451 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_128_in_keyRangeExpr3454 = new BitSet(new long[]{0x0000000000000000L,0x20000000041C0000L});
    public static final BitSet FOLLOW_entityName_in_keyRangeExpr3458 = new BitSet(new long[]{0x0000000000000000L,0x2000000000000000L});
    public static final BitSet FOLLOW_125_in_keyRangeExpr3464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_LIMIT_in_rowLimitExpr3501 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_rowLimitExpr3505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_129_in_columnLimitExpr3539 = new BitSet(new long[]{0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_columnLimitExpr3543 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_reversedExpr_in_columnLimitExpr3545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_130_in_reversedExpr3583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entityName_in_columnName3611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_attr_name3625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_attrValueString3642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_attrValueInt0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DoubleLiteral_in_attrValueDouble3694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entityName_in_keyspace3710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_replica_placement_strategy3724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entityName_in_keyspaceNewName3738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_comparator3752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_command3771 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entityName_in_newColumnFamily3785 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_username3794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_password3806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_entityName_in_columnFamily3821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_entityName3834 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_rowKey3866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_rowKey3870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_rowKey3874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerNegativeLiteral_in_rowKey3878 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_rowKey3882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_rowValue3904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_rowValue3908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_rowValue3912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerNegativeLiteral_in_rowValue3916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_rowValue3920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_hashConstruct_in_rowValue3924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_value3946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_value3950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerNegativeLiteral_in_value3954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_value3958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_value3962 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_functionCall3983 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000008L});
    public static final BitSet FOLLOW_131_in_functionCall3985 = new BitSet(new long[]{0x0000000000000000L,0x00000000041C0000L,0x0000000000000010L});
    public static final BitSet FOLLOW_functionArgument_in_functionCall3987 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_132_in_functionCall3990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_functionArgument0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_columnOrSuperColumn4058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_columnOrSuperColumn4062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerNegativeLiteral_in_columnOrSuperColumn4066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_StringLiteral_in_columnOrSuperColumn4070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionCall_in_columnOrSuperColumn4074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_host_name_in_host4096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_host_name4129 = new BitSet(new long[]{0x0000000000000002L,0x0400000000000000L});
    public static final BitSet FOLLOW_122_in_host_name4132 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_Identifier_in_host_name4134 = new BitSet(new long[]{0x0000000000000002L,0x0400000000000000L});
    public static final BitSet FOLLOW_IP_ADDRESS_in_ip_address4157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IntegerPositiveLiteral_in_port4195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_incrementValue0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_Identifier_in_traceSessionId4237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DoubleLiteral_in_tracingProbability4254 = new BitSet(new long[]{0x0000000000000002L});

}