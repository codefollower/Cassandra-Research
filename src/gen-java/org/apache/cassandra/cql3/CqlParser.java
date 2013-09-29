// $ANTLR 3.2 Sep 23, 2009 12:02:23 E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g 2013-09-26 00:22:20

    package org.apache.cassandra.cql3;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Collections;
    import java.util.EnumSet;
    import java.util.HashMap;
    import java.util.LinkedHashMap;
    import java.util.List;
    import java.util.Map;
    import java.util.Set;

    import org.apache.cassandra.auth.Permission;
    import org.apache.cassandra.auth.DataResource;
    import org.apache.cassandra.auth.IResource;
    import org.apache.cassandra.cql3.*;
    import org.apache.cassandra.cql3.statements.*;
    import org.apache.cassandra.cql3.functions.FunctionCall;
    import org.apache.cassandra.db.marshal.CollectionType;
    import org.apache.cassandra.exceptions.ConfigurationException;
    import org.apache.cassandra.exceptions.InvalidRequestException;
    import org.apache.cassandra.exceptions.SyntaxException;
    import org.apache.cassandra.utils.Pair;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CqlParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "K_USE", "K_SELECT", "K_COUNT", "K_AS", "K_FROM", "K_WHERE", "K_ORDER", "K_BY", "K_LIMIT", "K_ALLOW", "K_FILTERING", "K_WRITETIME", "K_TTL", "INTEGER", "K_AND", "K_ASC", "K_DESC", "K_INSERT", "K_INTO", "K_VALUES", "K_IF", "K_NOT", "K_EXISTS", "K_USING", "K_TIMESTAMP", "K_UPDATE", "K_SET", "K_DELETE", "K_BEGIN", "K_UNLOGGED", "K_COUNTER", "K_BATCH", "K_APPLY", "K_CREATE", "K_KEYSPACE", "K_WITH", "K_COLUMNFAMILY", "K_PRIMARY", "K_KEY", "K_COMPACT", "K_STORAGE", "K_CLUSTERING", "K_CUSTOM", "K_INDEX", "IDENT", "K_ON", "STRING_LITERAL", "K_TRIGGER", "K_DROP", "K_ALTER", "K_TYPE", "K_ADD", "K_RENAME", "K_TO", "K_TRUNCATE", "K_GRANT", "K_REVOKE", "K_LIST", "K_OF", "K_NORECURSIVE", "K_MODIFY", "K_AUTHORIZE", "K_ALL", "K_PERMISSIONS", "K_PERMISSION", "K_KEYSPACES", "K_USER", "K_SUPERUSER", "K_NOSUPERUSER", "K_USERS", "K_PASSWORD", "QUOTED_NAME", "FLOAT", "BOOLEAN", "UUID", "HEXNUMBER", "K_NULL", "QMARK", "K_TOKEN", "K_IN", "K_ASCII", "K_BIGINT", "K_BLOB", "K_BOOLEAN", "K_DECIMAL", "K_DOUBLE", "K_FLOAT", "K_INET", "K_INT", "K_TEXT", "K_UUID", "K_VARCHAR", "K_VARINT", "K_TIMEUUID", "K_MAP", "S", "E", "L", "C", "T", "F", "R", "O", "M", "A", "W", "H", "N", "D", "K", "Y", "I", "U", "P", "G", "B", "X", "V", "Z", "J", "Q", "DIGIT", "LETTER", "HEX", "EXPONENT", "WS", "COMMENT", "MULTILINE_COMMENT", "';'", "'('", "')'", "','", "'\\*'", "'['", "']'", "'.'", "'{'", "':'", "'}'", "'='", "'+'", "'-'", "'<'", "'<='", "'>'", "'>='"
    };
    public static final int EXPONENT=128;
    public static final int K_PERMISSIONS=67;
    public static final int LETTER=126;
    public static final int K_INT=92;
    public static final int K_PERMISSION=68;
    public static final int K_CREATE=37;
    public static final int K_CLUSTERING=45;
    public static final int K_WRITETIME=15;
    public static final int K_EXISTS=26;
    public static final int EOF=-1;
    public static final int K_PRIMARY=41;
    public static final int K_AUTHORIZE=65;
    public static final int K_VALUES=23;
    public static final int K_USE=4;
    public static final int T__148=148;
    public static final int STRING_LITERAL=50;
    public static final int T__147=147;
    public static final int K_GRANT=59;
    public static final int T__149=149;
    public static final int K_ON=49;
    public static final int K_USING=27;
    public static final int K_ADD=55;
    public static final int K_ASC=19;
    public static final int K_CUSTOM=46;
    public static final int K_KEY=42;
    public static final int COMMENT=130;
    public static final int K_TRUNCATE=58;
    public static final int K_ORDER=10;
    public static final int HEXNUMBER=79;
    public static final int K_OF=62;
    public static final int K_ALL=66;
    public static final int D=112;
    public static final int T__139=139;
    public static final int E=100;
    public static final int T__138=138;
    public static final int F=104;
    public static final int T__137=137;
    public static final int G=118;
    public static final int T__136=136;
    public static final int K_COUNT=6;
    public static final int K_KEYSPACE=38;
    public static final int K_TYPE=54;
    public static final int A=108;
    public static final int B=119;
    public static final int C=102;
    public static final int L=101;
    public static final int M=107;
    public static final int N=111;
    public static final int O=106;
    public static final int H=110;
    public static final int I=115;
    public static final int J=123;
    public static final int K_UPDATE=29;
    public static final int K=113;
    public static final int K_FILTERING=14;
    public static final int U=116;
    public static final int T=103;
    public static final int W=109;
    public static final int K_TEXT=93;
    public static final int V=121;
    public static final int Q=124;
    public static final int P=117;
    public static final int K_COMPACT=43;
    public static final int S=99;
    public static final int R=105;
    public static final int T__141=141;
    public static final int T__142=142;
    public static final int K_TTL=16;
    public static final int T__140=140;
    public static final int Y=114;
    public static final int T__145=145;
    public static final int X=120;
    public static final int T__146=146;
    public static final int T__143=143;
    public static final int Z=122;
    public static final int T__144=144;
    public static final int K_INDEX=47;
    public static final int K_INSERT=21;
    public static final int WS=129;
    public static final int K_NOT=25;
    public static final int K_RENAME=56;
    public static final int K_APPLY=36;
    public static final int K_INET=91;
    public static final int K_STORAGE=44;
    public static final int K_TIMESTAMP=28;
    public static final int K_NULL=80;
    public static final int K_AND=18;
    public static final int K_DESC=20;
    public static final int K_TOKEN=82;
    public static final int QMARK=81;
    public static final int T__132=132;
    public static final int T__133=133;
    public static final int T__134=134;
    public static final int K_UUID=94;
    public static final int T__135=135;
    public static final int K_BATCH=35;
    public static final int K_ASCII=84;
    public static final int UUID=78;
    public static final int K_LIST=61;
    public static final int K_DELETE=31;
    public static final int K_TO=57;
    public static final int K_BY=11;
    public static final int FLOAT=76;
    public static final int K_VARINT=96;
    public static final int K_FLOAT=90;
    public static final int K_SUPERUSER=71;
    public static final int K_DOUBLE=89;
    public static final int K_SELECT=5;
    public static final int K_LIMIT=12;
    public static final int K_BOOLEAN=87;
    public static final int K_ALTER=53;
    public static final int K_SET=30;
    public static final int K_TRIGGER=51;
    public static final int K_WHERE=9;
    public static final int QUOTED_NAME=75;
    public static final int MULTILINE_COMMENT=131;
    public static final int K_BLOB=86;
    public static final int BOOLEAN=77;
    public static final int K_UNLOGGED=33;
    public static final int HEX=127;
    public static final int K_INTO=22;
    public static final int K_PASSWORD=74;
    public static final int K_REVOKE=60;
    public static final int K_ALLOW=13;
    public static final int K_VARCHAR=95;
    public static final int IDENT=48;
    public static final int DIGIT=125;
    public static final int K_USERS=73;
    public static final int K_BEGIN=32;
    public static final int INTEGER=17;
    public static final int K_KEYSPACES=69;
    public static final int K_COUNTER=34;
    public static final int K_DECIMAL=88;
    public static final int K_WITH=39;
    public static final int K_IN=83;
    public static final int K_NORECURSIVE=63;
    public static final int K_MAP=98;
    public static final int K_IF=24;
    public static final int K_FROM=8;
    public static final int K_COLUMNFAMILY=40;
    public static final int K_MODIFY=64;
    public static final int K_DROP=52;
    public static final int K_NOSUPERUSER=72;
    public static final int K_AS=7;
    public static final int K_BIGINT=85;
    public static final int K_TIMEUUID=97;
    public static final int K_USER=70;

    // delegates
    // delegators


        public CqlParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public CqlParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return CqlParser.tokenNames; }
    public String getGrammarFileName() { return "E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g"; }


        private List<String> recognitionErrors = new ArrayList<String>();
        private int currentBindMarkerIdx = -1;

        public void displayRecognitionError(String[] tokenNames, RecognitionException e)
        {
            String hdr = getErrorHeader(e);
            String msg = getErrorMessage(e, tokenNames);
            recognitionErrors.add(hdr + " " + msg);
        }

        public void addRecognitionError(String msg)
        {
            recognitionErrors.add(msg);
        }

        public List<String> getRecognitionErrors()
        {
            return recognitionErrors;
        }

        public void throwLastRecognitionError() throws SyntaxException
        {
            if (recognitionErrors.size() > 0)
                throw new SyntaxException(recognitionErrors.get((recognitionErrors.size()-1)));
        }

        public Map<String, String> convertPropertyMap(Maps.Literal map)
        {
            if (map == null || map.entries == null || map.entries.isEmpty())
                return Collections.<String, String>emptyMap();

            Map<String, String> res = new HashMap<String, String>(map.entries.size());

            for (Pair<Term.Raw, Term.Raw> entry : map.entries)
            {
                // Because the parser tries to be smart and recover on error (to
                // allow displaying more than one error I suppose), we have null
                // entries in there. Just skip those, a proper error will be thrown in the end.
                if (entry.left == null || entry.right == null)
                    break;

                if (!(entry.left instanceof Constants.Literal))
                {
                    addRecognitionError("Invalid property name: " + entry.left);
                    break;
                }
                if (!(entry.right instanceof Constants.Literal))
                {
                    addRecognitionError("Invalid property value: " + entry.right);
                    break;
                }

                res.put(((Constants.Literal)entry.left).getRawText(), ((Constants.Literal)entry.right).getRawText());
            }

            return res;
        }

        public void addRawUpdate(List<Pair<ColumnIdentifier, Operation.RawUpdate>> operations, ColumnIdentifier key, Operation.RawUpdate update)
        {
            for (Pair<ColumnIdentifier, Operation.RawUpdate> p : operations)
            {
                if (p.left.equals(key) && !p.right.isCompatibleWith(update))
                    addRecognitionError("Multiple incompatible setting of column " + key);
            }
            operations.add(Pair.create(key, update));
        }



    // $ANTLR start "query"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:166:1: query returns [ParsedStatement stmnt] : st= cqlStatement ( ';' )* EOF ;
    public final ParsedStatement query() throws RecognitionException {
        ParsedStatement stmnt = null;

        ParsedStatement st = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:169:5: (st= cqlStatement ( ';' )* EOF )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:169:7: st= cqlStatement ( ';' )* EOF
            {
            pushFollow(FOLLOW_cqlStatement_in_query72);
            st=cqlStatement();

            state._fsp--;

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:169:23: ( ';' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==132) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:169:24: ';'
            	    {
            	    match(input,132,FOLLOW_132_in_query75); 

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,EOF,FOLLOW_EOF_in_query79); 
             stmnt = st; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmnt;
    }
    // $ANTLR end "query"


    // $ANTLR start "cqlStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:172:1: cqlStatement returns [ParsedStatement stmt] : (st1= selectStatement | st2= insertStatement | st3= updateStatement | st4= batchStatement | st5= deleteStatement | st6= useStatement | st7= truncateStatement | st8= createKeyspaceStatement | st9= createTableStatement | st10= createIndexStatement | st11= dropKeyspaceStatement | st12= dropTableStatement | st13= dropIndexStatement | st14= alterTableStatement | st15= alterKeyspaceStatement | st16= grantStatement | st17= revokeStatement | st18= listPermissionsStatement | st19= createUserStatement | st20= alterUserStatement | st21= dropUserStatement | st22= listUsersStatement | st23= createTriggerStatement | st24= dropTriggerStatement );
    public final ParsedStatement cqlStatement() throws RecognitionException {
        ParsedStatement stmt = null;

        SelectStatement.RawStatement st1 = null;

        UpdateStatement.ParsedInsert st2 = null;

        UpdateStatement.ParsedUpdate st3 = null;

        BatchStatement.Parsed st4 = null;

        DeleteStatement.Parsed st5 = null;

        UseStatement st6 = null;

        TruncateStatement st7 = null;

        CreateKeyspaceStatement st8 = null;

        CreateTableStatement.RawStatement st9 = null;

        CreateIndexStatement st10 = null;

        DropKeyspaceStatement st11 = null;

        DropTableStatement st12 = null;

        DropIndexStatement st13 = null;

        AlterTableStatement st14 = null;

        AlterKeyspaceStatement st15 = null;

        GrantStatement st16 = null;

        RevokeStatement st17 = null;

        ListPermissionsStatement st18 = null;

        CreateUserStatement st19 = null;

        AlterUserStatement st20 = null;

        DropUserStatement st21 = null;

        ListUsersStatement st22 = null;

        CreateTriggerStatement st23 = null;

        DropTriggerStatement st24 = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:174:5: (st1= selectStatement | st2= insertStatement | st3= updateStatement | st4= batchStatement | st5= deleteStatement | st6= useStatement | st7= truncateStatement | st8= createKeyspaceStatement | st9= createTableStatement | st10= createIndexStatement | st11= dropKeyspaceStatement | st12= dropTableStatement | st13= dropIndexStatement | st14= alterTableStatement | st15= alterKeyspaceStatement | st16= grantStatement | st17= revokeStatement | st18= listPermissionsStatement | st19= createUserStatement | st20= alterUserStatement | st21= dropUserStatement | st22= listUsersStatement | st23= createTriggerStatement | st24= dropTriggerStatement )
            int alt2=24;
            alt2 = dfa2.predict(input);
            switch (alt2) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:174:7: st1= selectStatement
                    {
                    pushFollow(FOLLOW_selectStatement_in_cqlStatement113);
                    st1=selectStatement();

                    state._fsp--;

                     stmt = st1; 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:175:7: st2= insertStatement
                    {
                    pushFollow(FOLLOW_insertStatement_in_cqlStatement138);
                    st2=insertStatement();

                    state._fsp--;

                     stmt = st2; 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:176:7: st3= updateStatement
                    {
                    pushFollow(FOLLOW_updateStatement_in_cqlStatement163);
                    st3=updateStatement();

                    state._fsp--;

                     stmt = st3; 

                    }
                    break;
                case 4 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:177:7: st4= batchStatement
                    {
                    pushFollow(FOLLOW_batchStatement_in_cqlStatement188);
                    st4=batchStatement();

                    state._fsp--;

                     stmt = st4; 

                    }
                    break;
                case 5 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:178:7: st5= deleteStatement
                    {
                    pushFollow(FOLLOW_deleteStatement_in_cqlStatement214);
                    st5=deleteStatement();

                    state._fsp--;

                     stmt = st5; 

                    }
                    break;
                case 6 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:179:7: st6= useStatement
                    {
                    pushFollow(FOLLOW_useStatement_in_cqlStatement239);
                    st6=useStatement();

                    state._fsp--;

                     stmt = st6; 

                    }
                    break;
                case 7 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:180:7: st7= truncateStatement
                    {
                    pushFollow(FOLLOW_truncateStatement_in_cqlStatement267);
                    st7=truncateStatement();

                    state._fsp--;

                     stmt = st7; 

                    }
                    break;
                case 8 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:181:7: st8= createKeyspaceStatement
                    {
                    pushFollow(FOLLOW_createKeyspaceStatement_in_cqlStatement290);
                    st8=createKeyspaceStatement();

                    state._fsp--;

                     stmt = st8; 

                    }
                    break;
                case 9 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:182:7: st9= createTableStatement
                    {
                    pushFollow(FOLLOW_createTableStatement_in_cqlStatement307);
                    st9=createTableStatement();

                    state._fsp--;

                     stmt = st9; 

                    }
                    break;
                case 10 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:183:7: st10= createIndexStatement
                    {
                    pushFollow(FOLLOW_createIndexStatement_in_cqlStatement326);
                    st10=createIndexStatement();

                    state._fsp--;

                     stmt = st10; 

                    }
                    break;
                case 11 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:184:7: st11= dropKeyspaceStatement
                    {
                    pushFollow(FOLLOW_dropKeyspaceStatement_in_cqlStatement345);
                    st11=dropKeyspaceStatement();

                    state._fsp--;

                     stmt = st11; 

                    }
                    break;
                case 12 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:185:7: st12= dropTableStatement
                    {
                    pushFollow(FOLLOW_dropTableStatement_in_cqlStatement363);
                    st12=dropTableStatement();

                    state._fsp--;

                     stmt = st12; 

                    }
                    break;
                case 13 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:186:7: st13= dropIndexStatement
                    {
                    pushFollow(FOLLOW_dropIndexStatement_in_cqlStatement384);
                    st13=dropIndexStatement();

                    state._fsp--;

                     stmt = st13; 

                    }
                    break;
                case 14 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:187:7: st14= alterTableStatement
                    {
                    pushFollow(FOLLOW_alterTableStatement_in_cqlStatement405);
                    st14=alterTableStatement();

                    state._fsp--;

                     stmt = st14; 

                    }
                    break;
                case 15 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:188:7: st15= alterKeyspaceStatement
                    {
                    pushFollow(FOLLOW_alterKeyspaceStatement_in_cqlStatement425);
                    st15=alterKeyspaceStatement();

                    state._fsp--;

                     stmt = st15; 

                    }
                    break;
                case 16 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:189:7: st16= grantStatement
                    {
                    pushFollow(FOLLOW_grantStatement_in_cqlStatement442);
                    st16=grantStatement();

                    state._fsp--;

                     stmt = st16; 

                    }
                    break;
                case 17 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:190:7: st17= revokeStatement
                    {
                    pushFollow(FOLLOW_revokeStatement_in_cqlStatement467);
                    st17=revokeStatement();

                    state._fsp--;

                     stmt = st17; 

                    }
                    break;
                case 18 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:191:7: st18= listPermissionsStatement
                    {
                    pushFollow(FOLLOW_listPermissionsStatement_in_cqlStatement491);
                    st18=listPermissionsStatement();

                    state._fsp--;

                     stmt = st18; 

                    }
                    break;
                case 19 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:192:7: st19= createUserStatement
                    {
                    pushFollow(FOLLOW_createUserStatement_in_cqlStatement506);
                    st19=createUserStatement();

                    state._fsp--;

                     stmt = st19; 

                    }
                    break;
                case 20 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:193:7: st20= alterUserStatement
                    {
                    pushFollow(FOLLOW_alterUserStatement_in_cqlStatement526);
                    st20=alterUserStatement();

                    state._fsp--;

                     stmt = st20; 

                    }
                    break;
                case 21 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:194:7: st21= dropUserStatement
                    {
                    pushFollow(FOLLOW_dropUserStatement_in_cqlStatement547);
                    st21=dropUserStatement();

                    state._fsp--;

                     stmt = st21; 

                    }
                    break;
                case 22 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:195:7: st22= listUsersStatement
                    {
                    pushFollow(FOLLOW_listUsersStatement_in_cqlStatement569);
                    st22=listUsersStatement();

                    state._fsp--;

                     stmt = st22; 

                    }
                    break;
                case 23 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:196:7: st23= createTriggerStatement
                    {
                    pushFollow(FOLLOW_createTriggerStatement_in_cqlStatement590);
                    st23=createTriggerStatement();

                    state._fsp--;

                     stmt = st23; 

                    }
                    break;
                case 24 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:197:7: st24= dropTriggerStatement
                    {
                    pushFollow(FOLLOW_dropTriggerStatement_in_cqlStatement607);
                    st24=dropTriggerStatement();

                    state._fsp--;

                     stmt = st24; 

                    }
                    break;

            }
             if (stmt != null) stmt.setBoundTerms(currentBindMarkerIdx + 1); 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "cqlStatement"


    // $ANTLR start "useStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:203:1: useStatement returns [UseStatement stmt] : K_USE ks= keyspaceName ;
    public final UseStatement useStatement() throws RecognitionException {
        UseStatement stmt = null;

        String ks = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:204:5: ( K_USE ks= keyspaceName )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:204:7: K_USE ks= keyspaceName
            {
            match(input,K_USE,FOLLOW_K_USE_in_useStatement639); 
            pushFollow(FOLLOW_keyspaceName_in_useStatement643);
            ks=keyspaceName();

            state._fsp--;

             stmt = new UseStatement(ks); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "useStatement"


    // $ANTLR start "selectStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:207:1: selectStatement returns [SelectStatement.RawStatement expr] : K_SELECT (sclause= selectClause | ( K_COUNT '(' sclause= selectCountClause ')' ( K_AS c= cident )? ) ) K_FROM cf= columnFamilyName ( K_WHERE wclause= whereClause )? ( K_ORDER K_BY orderByClause[orderings] ( ',' orderByClause[orderings] )* )? ( K_LIMIT rows= intValue )? ( K_ALLOW K_FILTERING )? ;
    public final SelectStatement.RawStatement selectStatement() throws RecognitionException {
        SelectStatement.RawStatement expr = null;

        List<RawSelector> sclause = null;

        ColumnIdentifier c = null;

        CFName cf = null;

        List<Relation> wclause = null;

        Term.Raw rows = null;



                boolean isCount = false;
                ColumnIdentifier countAlias = null;
                Term.Raw limit = null;
                Map<ColumnIdentifier, Boolean> orderings = new LinkedHashMap<ColumnIdentifier, Boolean>();
                boolean allowFiltering = false;
            
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:221:5: ( K_SELECT (sclause= selectClause | ( K_COUNT '(' sclause= selectCountClause ')' ( K_AS c= cident )? ) ) K_FROM cf= columnFamilyName ( K_WHERE wclause= whereClause )? ( K_ORDER K_BY orderByClause[orderings] ( ',' orderByClause[orderings] )* )? ( K_LIMIT rows= intValue )? ( K_ALLOW K_FILTERING )? )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:221:7: K_SELECT (sclause= selectClause | ( K_COUNT '(' sclause= selectCountClause ')' ( K_AS c= cident )? ) ) K_FROM cf= columnFamilyName ( K_WHERE wclause= whereClause )? ( K_ORDER K_BY orderByClause[orderings] ( ',' orderByClause[orderings] )* )? ( K_LIMIT rows= intValue )? ( K_ALLOW K_FILTERING )?
            {
            match(input,K_SELECT,FOLLOW_K_SELECT_in_selectStatement677); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:221:16: (sclause= selectClause | ( K_COUNT '(' sclause= selectCountClause ')' ( K_AS c= cident )? ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==K_AS||(LA4_0>=K_FILTERING && LA4_0<=K_TTL)||LA4_0==K_VALUES||LA4_0==K_EXISTS||LA4_0==K_TIMESTAMP||LA4_0==K_COUNTER||(LA4_0>=K_KEY && LA4_0<=K_CUSTOM)||LA4_0==IDENT||LA4_0==K_TRIGGER||LA4_0==K_TYPE||LA4_0==K_LIST||(LA4_0>=K_ALL && LA4_0<=QUOTED_NAME)||LA4_0==K_TOKEN||(LA4_0>=K_ASCII && LA4_0<=K_MAP)||LA4_0==136) ) {
                alt4=1;
            }
            else if ( (LA4_0==K_COUNT) ) {
                int LA4_2 = input.LA(2);

                if ( (LA4_2==133) ) {
                    alt4=2;
                }
                else if ( ((LA4_2>=K_AS && LA4_2<=K_FROM)||LA4_2==135) ) {
                    alt4=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 4, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:221:18: sclause= selectClause
                    {
                    pushFollow(FOLLOW_selectClause_in_selectStatement683);
                    sclause=selectClause();

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:222:18: ( K_COUNT '(' sclause= selectCountClause ')' ( K_AS c= cident )? )
                    {
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:222:18: ( K_COUNT '(' sclause= selectCountClause ')' ( K_AS c= cident )? )
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:222:19: K_COUNT '(' sclause= selectCountClause ')' ( K_AS c= cident )?
                    {
                    match(input,K_COUNT,FOLLOW_K_COUNT_in_selectStatement703); 
                    match(input,133,FOLLOW_133_in_selectStatement705); 
                    pushFollow(FOLLOW_selectCountClause_in_selectStatement709);
                    sclause=selectCountClause();

                    state._fsp--;

                    match(input,134,FOLLOW_134_in_selectStatement711); 
                     isCount = true; 
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:222:81: ( K_AS c= cident )?
                    int alt3=2;
                    int LA3_0 = input.LA(1);

                    if ( (LA3_0==K_AS) ) {
                        alt3=1;
                    }
                    switch (alt3) {
                        case 1 :
                            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:222:82: K_AS c= cident
                            {
                            match(input,K_AS,FOLLOW_K_AS_in_selectStatement716); 
                            pushFollow(FOLLOW_cident_in_selectStatement720);
                            c=cident();

                            state._fsp--;

                             countAlias = c; 

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            match(input,K_FROM,FOLLOW_K_FROM_in_selectStatement735); 
            pushFollow(FOLLOW_columnFamilyName_in_selectStatement739);
            cf=columnFamilyName();

            state._fsp--;

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:224:7: ( K_WHERE wclause= whereClause )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==K_WHERE) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:224:9: K_WHERE wclause= whereClause
                    {
                    match(input,K_WHERE,FOLLOW_K_WHERE_in_selectStatement749); 
                    pushFollow(FOLLOW_whereClause_in_selectStatement753);
                    wclause=whereClause();

                    state._fsp--;


                    }
                    break;

            }

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:225:7: ( K_ORDER K_BY orderByClause[orderings] ( ',' orderByClause[orderings] )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==K_ORDER) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:225:9: K_ORDER K_BY orderByClause[orderings] ( ',' orderByClause[orderings] )*
                    {
                    match(input,K_ORDER,FOLLOW_K_ORDER_in_selectStatement766); 
                    match(input,K_BY,FOLLOW_K_BY_in_selectStatement768); 
                    pushFollow(FOLLOW_orderByClause_in_selectStatement770);
                    orderByClause(orderings);

                    state._fsp--;

                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:225:47: ( ',' orderByClause[orderings] )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==135) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:225:49: ',' orderByClause[orderings]
                    	    {
                    	    match(input,135,FOLLOW_135_in_selectStatement775); 
                    	    pushFollow(FOLLOW_orderByClause_in_selectStatement777);
                    	    orderByClause(orderings);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:226:7: ( K_LIMIT rows= intValue )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==K_LIMIT) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:226:9: K_LIMIT rows= intValue
                    {
                    match(input,K_LIMIT,FOLLOW_K_LIMIT_in_selectStatement794); 
                    pushFollow(FOLLOW_intValue_in_selectStatement798);
                    rows=intValue();

                    state._fsp--;

                     limit = rows; 

                    }
                    break;

            }

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:227:7: ( K_ALLOW K_FILTERING )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==K_ALLOW) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:227:9: K_ALLOW K_FILTERING
                    {
                    match(input,K_ALLOW,FOLLOW_K_ALLOW_in_selectStatement813); 
                    match(input,K_FILTERING,FOLLOW_K_FILTERING_in_selectStatement815); 
                     allowFiltering = true; 

                    }
                    break;

            }


                      SelectStatement.Parameters params = new SelectStatement.Parameters(orderings,
                                                                                         isCount,
                                                                                         countAlias,
                                                                                         allowFiltering);
                      expr = new SelectStatement.RawStatement(cf, params, sclause, wclause, limit);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "selectStatement"


    // $ANTLR start "selectClause"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:237:1: selectClause returns [List<RawSelector> expr] : (t1= selector ( ',' tN= selector )* | '\\*' );
    public final List<RawSelector> selectClause() throws RecognitionException {
        List<RawSelector> expr = null;

        RawSelector t1 = null;

        RawSelector tN = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:238:5: (t1= selector ( ',' tN= selector )* | '\\*' )
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( ((LA11_0>=K_COUNT && LA11_0<=K_AS)||(LA11_0>=K_FILTERING && LA11_0<=K_TTL)||LA11_0==K_VALUES||LA11_0==K_EXISTS||LA11_0==K_TIMESTAMP||LA11_0==K_COUNTER||(LA11_0>=K_KEY && LA11_0<=K_CUSTOM)||LA11_0==IDENT||LA11_0==K_TRIGGER||LA11_0==K_TYPE||LA11_0==K_LIST||(LA11_0>=K_ALL && LA11_0<=QUOTED_NAME)||LA11_0==K_TOKEN||(LA11_0>=K_ASCII && LA11_0<=K_MAP)) ) {
                alt11=1;
            }
            else if ( (LA11_0==136) ) {
                alt11=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }
            switch (alt11) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:238:7: t1= selector ( ',' tN= selector )*
                    {
                    pushFollow(FOLLOW_selector_in_selectClause852);
                    t1=selector();

                    state._fsp--;

                     expr = new ArrayList<RawSelector>(); expr.add(t1); 
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:238:76: ( ',' tN= selector )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==135) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:238:77: ',' tN= selector
                    	    {
                    	    match(input,135,FOLLOW_135_in_selectClause857); 
                    	    pushFollow(FOLLOW_selector_in_selectClause861);
                    	    tN=selector();

                    	    state._fsp--;

                    	     expr.add(tN); 

                    	    }
                    	    break;

                    	default :
                    	    break loop10;
                        }
                    } while (true);


                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:239:7: '\\*'
                    {
                    match(input,136,FOLLOW_136_in_selectClause873); 
                     expr = Collections.<RawSelector>emptyList();

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "selectClause"


    // $ANTLR start "selector"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:242:1: selector returns [RawSelector s] : us= unaliasedSelector ( K_AS c= cident )? ;
    public final RawSelector selector() throws RecognitionException {
        RawSelector s = null;

        Selectable us = null;

        ColumnIdentifier c = null;


         ColumnIdentifier alias = null; 
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:244:5: (us= unaliasedSelector ( K_AS c= cident )? )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:244:7: us= unaliasedSelector ( K_AS c= cident )?
            {
            pushFollow(FOLLOW_unaliasedSelector_in_selector906);
            us=unaliasedSelector();

            state._fsp--;

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:244:28: ( K_AS c= cident )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==K_AS) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:244:29: K_AS c= cident
                    {
                    match(input,K_AS,FOLLOW_K_AS_in_selector909); 
                    pushFollow(FOLLOW_cident_in_selector913);
                    c=cident();

                    state._fsp--;

                     alias = c; 

                    }
                    break;

            }

             s = new RawSelector(us, alias); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "selector"


    // $ANTLR start "unaliasedSelector"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:247:1: unaliasedSelector returns [Selectable s] : (c= cident | K_WRITETIME '(' c= cident ')' | K_TTL '(' c= cident ')' | f= functionName args= selectionFunctionArgs );
    public final Selectable unaliasedSelector() throws RecognitionException {
        Selectable s = null;

        ColumnIdentifier c = null;

        String f = null;

        List<Selectable> args = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:248:5: (c= cident | K_WRITETIME '(' c= cident ')' | K_TTL '(' c= cident ')' | f= functionName args= selectionFunctionArgs )
            int alt13=4;
            alt13 = dfa13.predict(input);
            switch (alt13) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:248:7: c= cident
                    {
                    pushFollow(FOLLOW_cident_in_unaliasedSelector942);
                    c=cident();

                    state._fsp--;

                     s = c; 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:249:7: K_WRITETIME '(' c= cident ')'
                    {
                    match(input,K_WRITETIME,FOLLOW_K_WRITETIME_in_unaliasedSelector985); 
                    match(input,133,FOLLOW_133_in_unaliasedSelector987); 
                    pushFollow(FOLLOW_cident_in_unaliasedSelector991);
                    c=cident();

                    state._fsp--;

                    match(input,134,FOLLOW_134_in_unaliasedSelector993); 
                     s = new Selectable.WritetimeOrTTL(c, true); 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:250:7: K_TTL '(' c= cident ')'
                    {
                    match(input,K_TTL,FOLLOW_K_TTL_in_unaliasedSelector1016); 
                    match(input,133,FOLLOW_133_in_unaliasedSelector1024); 
                    pushFollow(FOLLOW_cident_in_unaliasedSelector1028);
                    c=cident();

                    state._fsp--;

                    match(input,134,FOLLOW_134_in_unaliasedSelector1030); 
                     s = new Selectable.WritetimeOrTTL(c, false); 

                    }
                    break;
                case 4 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:251:7: f= functionName args= selectionFunctionArgs
                    {
                    pushFollow(FOLLOW_functionName_in_unaliasedSelector1055);
                    f=functionName();

                    state._fsp--;

                    pushFollow(FOLLOW_selectionFunctionArgs_in_unaliasedSelector1059);
                    args=selectionFunctionArgs();

                    state._fsp--;

                     s = new Selectable.WithFunction(f, args); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "unaliasedSelector"


    // $ANTLR start "selectionFunctionArgs"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:254:1: selectionFunctionArgs returns [List<Selectable> a] : ( '(' ')' | '(' s1= unaliasedSelector ( ',' sn= unaliasedSelector )* ')' );
    public final List<Selectable> selectionFunctionArgs() throws RecognitionException {
        List<Selectable> a = null;

        Selectable s1 = null;

        Selectable sn = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:255:5: ( '(' ')' | '(' s1= unaliasedSelector ( ',' sn= unaliasedSelector )* ')' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==133) ) {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==134) ) {
                    alt15=1;
                }
                else if ( ((LA15_1>=K_COUNT && LA15_1<=K_AS)||(LA15_1>=K_FILTERING && LA15_1<=K_TTL)||LA15_1==K_VALUES||LA15_1==K_EXISTS||LA15_1==K_TIMESTAMP||LA15_1==K_COUNTER||(LA15_1>=K_KEY && LA15_1<=K_CUSTOM)||LA15_1==IDENT||LA15_1==K_TRIGGER||LA15_1==K_TYPE||LA15_1==K_LIST||(LA15_1>=K_ALL && LA15_1<=QUOTED_NAME)||LA15_1==K_TOKEN||(LA15_1>=K_ASCII && LA15_1<=K_MAP)) ) {
                    alt15=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:255:7: '(' ')'
                    {
                    match(input,133,FOLLOW_133_in_selectionFunctionArgs1082); 
                    match(input,134,FOLLOW_134_in_selectionFunctionArgs1084); 
                     a = Collections.emptyList(); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:256:7: '(' s1= unaliasedSelector ( ',' sn= unaliasedSelector )* ')'
                    {
                    match(input,133,FOLLOW_133_in_selectionFunctionArgs1094); 
                    pushFollow(FOLLOW_unaliasedSelector_in_selectionFunctionArgs1098);
                    s1=unaliasedSelector();

                    state._fsp--;

                     List<Selectable> args = new ArrayList<Selectable>(); args.add(s1); 
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:257:11: ( ',' sn= unaliasedSelector )*
                    loop14:
                    do {
                        int alt14=2;
                        int LA14_0 = input.LA(1);

                        if ( (LA14_0==135) ) {
                            alt14=1;
                        }


                        switch (alt14) {
                    	case 1 :
                    	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:257:13: ',' sn= unaliasedSelector
                    	    {
                    	    match(input,135,FOLLOW_135_in_selectionFunctionArgs1114); 
                    	    pushFollow(FOLLOW_unaliasedSelector_in_selectionFunctionArgs1118);
                    	    sn=unaliasedSelector();

                    	    state._fsp--;

                    	     args.add(sn); 

                    	    }
                    	    break;

                    	default :
                    	    break loop14;
                        }
                    } while (true);

                    match(input,134,FOLLOW_134_in_selectionFunctionArgs1132); 
                     a = args; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return a;
    }
    // $ANTLR end "selectionFunctionArgs"


    // $ANTLR start "selectCountClause"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:261:1: selectCountClause returns [List<RawSelector> expr] : ( '\\*' | i= INTEGER );
    public final List<RawSelector> selectCountClause() throws RecognitionException {
        List<RawSelector> expr = null;

        Token i=null;

        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:262:5: ( '\\*' | i= INTEGER )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==136) ) {
                alt16=1;
            }
            else if ( (LA16_0==INTEGER) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:262:7: '\\*'
                    {
                    match(input,136,FOLLOW_136_in_selectCountClause1155); 
                     expr = Collections.<RawSelector>emptyList();

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:263:7: i= INTEGER
                    {
                    i=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_selectCountClause1177); 
                     if (!i.getText().equals("1")) addRecognitionError("Only COUNT(1) is supported, got COUNT(" + i.getText() + ")"); expr = Collections.<RawSelector>emptyList();

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "selectCountClause"


    // $ANTLR start "whereClause"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:266:1: whereClause returns [List<Relation> clause] : relation[$clause] ( K_AND relation[$clause] )* ;
    public final List<Relation> whereClause() throws RecognitionException {
        List<Relation> clause = null;

         clause = new ArrayList<Relation>(); 
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:268:5: ( relation[$clause] ( K_AND relation[$clause] )* )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:268:7: relation[$clause] ( K_AND relation[$clause] )*
            {
            pushFollow(FOLLOW_relation_in_whereClause1213);
            relation(clause);

            state._fsp--;

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:268:25: ( K_AND relation[$clause] )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==K_AND) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:268:26: K_AND relation[$clause]
            	    {
            	    match(input,K_AND,FOLLOW_K_AND_in_whereClause1217); 
            	    pushFollow(FOLLOW_relation_in_whereClause1219);
            	    relation(clause);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return clause;
    }
    // $ANTLR end "whereClause"


    // $ANTLR start "orderByClause"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:271:1: orderByClause[Map<ColumnIdentifier, Boolean> orderings] : c= cident ( K_ASC | K_DESC )? ;
    public final void orderByClause(Map<ColumnIdentifier, Boolean> orderings) throws RecognitionException {
        ColumnIdentifier c = null;



                ColumnIdentifier orderBy = null;
                boolean reversed = false;
            
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:276:5: (c= cident ( K_ASC | K_DESC )? )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:276:7: c= cident ( K_ASC | K_DESC )?
            {
            pushFollow(FOLLOW_cident_in_orderByClause1250);
            c=cident();

            state._fsp--;

             orderBy = c; 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:276:33: ( K_ASC | K_DESC )?
            int alt18=3;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==K_ASC) ) {
                alt18=1;
            }
            else if ( (LA18_0==K_DESC) ) {
                alt18=2;
            }
            switch (alt18) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:276:34: K_ASC
                    {
                    match(input,K_ASC,FOLLOW_K_ASC_in_orderByClause1255); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:276:42: K_DESC
                    {
                    match(input,K_DESC,FOLLOW_K_DESC_in_orderByClause1259); 
                     reversed = true; 

                    }
                    break;

            }

             orderings.put(c, reversed); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "orderByClause"


    // $ANTLR start "insertStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:279:1: insertStatement returns [UpdateStatement.ParsedInsert expr] : K_INSERT K_INTO cf= columnFamilyName '(' c1= cident ( ',' cn= cident )* ')' K_VALUES '(' v1= term ( ',' vn= term )* ')' ( K_IF K_NOT K_EXISTS )? ( usingClause[attrs] )? ;
    public final UpdateStatement.ParsedInsert insertStatement() throws RecognitionException {
        UpdateStatement.ParsedInsert expr = null;

        CFName cf = null;

        ColumnIdentifier c1 = null;

        ColumnIdentifier cn = null;

        Term.Raw v1 = null;

        Term.Raw vn = null;



                Attributes.Raw attrs = new Attributes.Raw();
                List<ColumnIdentifier> columnNames  = new ArrayList<ColumnIdentifier>();
                List<Term.Raw> values = new ArrayList<Term.Raw>();
                boolean ifNotExists = false;
            
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:292:5: ( K_INSERT K_INTO cf= columnFamilyName '(' c1= cident ( ',' cn= cident )* ')' K_VALUES '(' v1= term ( ',' vn= term )* ')' ( K_IF K_NOT K_EXISTS )? ( usingClause[attrs] )? )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:292:7: K_INSERT K_INTO cf= columnFamilyName '(' c1= cident ( ',' cn= cident )* ')' K_VALUES '(' v1= term ( ',' vn= term )* ')' ( K_IF K_NOT K_EXISTS )? ( usingClause[attrs] )?
            {
            match(input,K_INSERT,FOLLOW_K_INSERT_in_insertStatement1297); 
            match(input,K_INTO,FOLLOW_K_INTO_in_insertStatement1299); 
            pushFollow(FOLLOW_columnFamilyName_in_insertStatement1303);
            cf=columnFamilyName();

            state._fsp--;

            match(input,133,FOLLOW_133_in_insertStatement1315); 
            pushFollow(FOLLOW_cident_in_insertStatement1319);
            c1=cident();

            state._fsp--;

             columnNames.add(c1); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:293:51: ( ',' cn= cident )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==135) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:293:53: ',' cn= cident
            	    {
            	    match(input,135,FOLLOW_135_in_insertStatement1326); 
            	    pushFollow(FOLLOW_cident_in_insertStatement1330);
            	    cn=cident();

            	    state._fsp--;

            	     columnNames.add(cn); 

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            match(input,134,FOLLOW_134_in_insertStatement1337); 
            match(input,K_VALUES,FOLLOW_K_VALUES_in_insertStatement1347); 
            match(input,133,FOLLOW_133_in_insertStatement1359); 
            pushFollow(FOLLOW_term_in_insertStatement1363);
            v1=term();

            state._fsp--;

             values.add(v1); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:295:43: ( ',' vn= term )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==135) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:295:45: ',' vn= term
            	    {
            	    match(input,135,FOLLOW_135_in_insertStatement1369); 
            	    pushFollow(FOLLOW_term_in_insertStatement1373);
            	    vn=term();

            	    state._fsp--;

            	     values.add(vn); 

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            match(input,134,FOLLOW_134_in_insertStatement1380); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:297:9: ( K_IF K_NOT K_EXISTS )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==K_IF) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:297:11: K_IF K_NOT K_EXISTS
                    {
                    match(input,K_IF,FOLLOW_K_IF_in_insertStatement1393); 
                    match(input,K_NOT,FOLLOW_K_NOT_in_insertStatement1395); 
                    match(input,K_EXISTS,FOLLOW_K_EXISTS_in_insertStatement1397); 
                     ifNotExists = true; 

                    }
                    break;

            }

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:298:9: ( usingClause[attrs] )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==K_USING) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:298:11: usingClause[attrs]
                    {
                    pushFollow(FOLLOW_usingClause_in_insertStatement1414);
                    usingClause(attrs);

                    state._fsp--;


                    }
                    break;

            }


                      expr = new UpdateStatement.ParsedInsert(cf,
                                                               attrs,
                                                               columnNames,
                                                               values,
                                                               ifNotExists);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "insertStatement"


    // $ANTLR start "usingClause"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:308:1: usingClause[Attributes.Raw attrs] : K_USING usingClauseObjective[attrs] ( K_AND usingClauseObjective[attrs] )* ;
    public final void usingClause(Attributes.Raw attrs) throws RecognitionException {
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:309:5: ( K_USING usingClauseObjective[attrs] ( K_AND usingClauseObjective[attrs] )* )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:309:7: K_USING usingClauseObjective[attrs] ( K_AND usingClauseObjective[attrs] )*
            {
            match(input,K_USING,FOLLOW_K_USING_in_usingClause1444); 
            pushFollow(FOLLOW_usingClauseObjective_in_usingClause1446);
            usingClauseObjective(attrs);

            state._fsp--;

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:309:43: ( K_AND usingClauseObjective[attrs] )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==K_AND) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:309:45: K_AND usingClauseObjective[attrs]
            	    {
            	    match(input,K_AND,FOLLOW_K_AND_in_usingClause1451); 
            	    pushFollow(FOLLOW_usingClauseObjective_in_usingClause1453);
            	    usingClauseObjective(attrs);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "usingClause"


    // $ANTLR start "usingClauseObjective"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:312:1: usingClauseObjective[Attributes.Raw attrs] : ( K_TIMESTAMP ts= intValue | K_TTL t= intValue );
    public final void usingClauseObjective(Attributes.Raw attrs) throws RecognitionException {
        Term.Raw ts = null;

        Term.Raw t = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:313:5: ( K_TIMESTAMP ts= intValue | K_TTL t= intValue )
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==K_TIMESTAMP) ) {
                alt24=1;
            }
            else if ( (LA24_0==K_TTL) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:313:7: K_TIMESTAMP ts= intValue
                    {
                    match(input,K_TIMESTAMP,FOLLOW_K_TIMESTAMP_in_usingClauseObjective1475); 
                    pushFollow(FOLLOW_intValue_in_usingClauseObjective1479);
                    ts=intValue();

                    state._fsp--;

                     attrs.timestamp = ts; 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:314:7: K_TTL t= intValue
                    {
                    match(input,K_TTL,FOLLOW_K_TTL_in_usingClauseObjective1489); 
                    pushFollow(FOLLOW_intValue_in_usingClauseObjective1493);
                    t=intValue();

                    state._fsp--;

                     attrs.timeToLive = t; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "usingClauseObjective"


    // $ANTLR start "updateStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:317:1: updateStatement returns [UpdateStatement.ParsedUpdate expr] : K_UPDATE cf= columnFamilyName ( usingClause[attrs] )? K_SET columnOperation[operations] ( ',' columnOperation[operations] )* K_WHERE wclause= whereClause ( K_IF conditions= updateCondition )? ;
    public final UpdateStatement.ParsedUpdate updateStatement() throws RecognitionException {
        UpdateStatement.ParsedUpdate expr = null;

        CFName cf = null;

        List<Relation> wclause = null;

        List<Pair<ColumnIdentifier, Operation.RawUpdate>> conditions = null;



                Attributes.Raw attrs = new Attributes.Raw();
                List<Pair<ColumnIdentifier, Operation.RawUpdate>> operations = new ArrayList<Pair<ColumnIdentifier, Operation.RawUpdate>>();
            
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:328:5: ( K_UPDATE cf= columnFamilyName ( usingClause[attrs] )? K_SET columnOperation[operations] ( ',' columnOperation[operations] )* K_WHERE wclause= whereClause ( K_IF conditions= updateCondition )? )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:328:7: K_UPDATE cf= columnFamilyName ( usingClause[attrs] )? K_SET columnOperation[operations] ( ',' columnOperation[operations] )* K_WHERE wclause= whereClause ( K_IF conditions= updateCondition )?
            {
            match(input,K_UPDATE,FOLLOW_K_UPDATE_in_updateStatement1527); 
            pushFollow(FOLLOW_columnFamilyName_in_updateStatement1531);
            cf=columnFamilyName();

            state._fsp--;

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:329:7: ( usingClause[attrs] )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==K_USING) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:329:9: usingClause[attrs]
                    {
                    pushFollow(FOLLOW_usingClause_in_updateStatement1541);
                    usingClause(attrs);

                    state._fsp--;


                    }
                    break;

            }

            match(input,K_SET,FOLLOW_K_SET_in_updateStatement1553); 
            pushFollow(FOLLOW_columnOperation_in_updateStatement1555);
            columnOperation(operations);

            state._fsp--;

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:330:41: ( ',' columnOperation[operations] )*
            loop26:
            do {
                int alt26=2;
                int LA26_0 = input.LA(1);

                if ( (LA26_0==135) ) {
                    alt26=1;
                }


                switch (alt26) {
            	case 1 :
            	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:330:42: ',' columnOperation[operations]
            	    {
            	    match(input,135,FOLLOW_135_in_updateStatement1559); 
            	    pushFollow(FOLLOW_columnOperation_in_updateStatement1561);
            	    columnOperation(operations);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            match(input,K_WHERE,FOLLOW_K_WHERE_in_updateStatement1572); 
            pushFollow(FOLLOW_whereClause_in_updateStatement1576);
            wclause=whereClause();

            state._fsp--;

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:332:7: ( K_IF conditions= updateCondition )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==K_IF) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:332:9: K_IF conditions= updateCondition
                    {
                    match(input,K_IF,FOLLOW_K_IF_in_updateStatement1586); 
                    pushFollow(FOLLOW_updateCondition_in_updateStatement1590);
                    conditions=updateCondition();

                    state._fsp--;


                    }
                    break;

            }


                      return new UpdateStatement.ParsedUpdate(cf,
                                                              attrs,
                                                              operations,
                                                              wclause,
                                                              conditions == null ? Collections.<Pair<ColumnIdentifier, Operation.RawUpdate>>emptyList() : conditions);
                 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "updateStatement"


    // $ANTLR start "updateCondition"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:342:1: updateCondition returns [List<Pair<ColumnIdentifier, Operation.RawUpdate>> conditions] : columnOperation[conditions] ( K_AND columnOperation[conditions] )* ;
    public final List<Pair<ColumnIdentifier, Operation.RawUpdate>> updateCondition() throws RecognitionException {
        List<Pair<ColumnIdentifier, Operation.RawUpdate>> conditions = null;

         conditions = new ArrayList<Pair<ColumnIdentifier, Operation.RawUpdate>>(); 
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:344:5: ( columnOperation[conditions] ( K_AND columnOperation[conditions] )* )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:344:7: columnOperation[conditions] ( K_AND columnOperation[conditions] )*
            {
            pushFollow(FOLLOW_columnOperation_in_updateCondition1631);
            columnOperation(conditions);

            state._fsp--;

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:344:35: ( K_AND columnOperation[conditions] )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==K_AND) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:344:37: K_AND columnOperation[conditions]
            	    {
            	    match(input,K_AND,FOLLOW_K_AND_in_updateCondition1636); 
            	    pushFollow(FOLLOW_columnOperation_in_updateCondition1638);
            	    columnOperation(conditions);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return conditions;
    }
    // $ANTLR end "updateCondition"


    // $ANTLR start "deleteStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:347:1: deleteStatement returns [DeleteStatement.Parsed expr] : K_DELETE (dels= deleteSelection )? K_FROM cf= columnFamilyName ( usingClauseDelete[attrs] )? K_WHERE wclause= whereClause ( K_IF conditions= updateCondition )? ;
    public final DeleteStatement.Parsed deleteStatement() throws RecognitionException {
        DeleteStatement.Parsed expr = null;

        List<Operation.RawDeletion> dels = null;

        CFName cf = null;

        List<Relation> wclause = null;

        List<Pair<ColumnIdentifier, Operation.RawUpdate>> conditions = null;



                Attributes.Raw attrs = new Attributes.Raw();
                List<Operation.RawDeletion> columnDeletions = Collections.emptyList();
            
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:358:5: ( K_DELETE (dels= deleteSelection )? K_FROM cf= columnFamilyName ( usingClauseDelete[attrs] )? K_WHERE wclause= whereClause ( K_IF conditions= updateCondition )? )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:358:7: K_DELETE (dels= deleteSelection )? K_FROM cf= columnFamilyName ( usingClauseDelete[attrs] )? K_WHERE wclause= whereClause ( K_IF conditions= updateCondition )?
            {
            match(input,K_DELETE,FOLLOW_K_DELETE_in_deleteStatement1674); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:358:16: (dels= deleteSelection )?
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( ((LA29_0>=K_COUNT && LA29_0<=K_AS)||(LA29_0>=K_FILTERING && LA29_0<=K_TTL)||LA29_0==K_VALUES||LA29_0==K_EXISTS||LA29_0==K_TIMESTAMP||LA29_0==K_COUNTER||(LA29_0>=K_KEY && LA29_0<=K_CUSTOM)||LA29_0==IDENT||LA29_0==K_TRIGGER||LA29_0==K_TYPE||LA29_0==K_LIST||(LA29_0>=K_ALL && LA29_0<=QUOTED_NAME)||(LA29_0>=K_ASCII && LA29_0<=K_MAP)) ) {
                alt29=1;
            }
            switch (alt29) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:358:18: dels= deleteSelection
                    {
                    pushFollow(FOLLOW_deleteSelection_in_deleteStatement1680);
                    dels=deleteSelection();

                    state._fsp--;

                     columnDeletions = dels; 

                    }
                    break;

            }

            match(input,K_FROM,FOLLOW_K_FROM_in_deleteStatement1693); 
            pushFollow(FOLLOW_columnFamilyName_in_deleteStatement1697);
            cf=columnFamilyName();

            state._fsp--;

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:360:7: ( usingClauseDelete[attrs] )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==K_USING) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:360:9: usingClauseDelete[attrs]
                    {
                    pushFollow(FOLLOW_usingClauseDelete_in_deleteStatement1707);
                    usingClauseDelete(attrs);

                    state._fsp--;


                    }
                    break;

            }

            match(input,K_WHERE,FOLLOW_K_WHERE_in_deleteStatement1719); 
            pushFollow(FOLLOW_whereClause_in_deleteStatement1723);
            wclause=whereClause();

            state._fsp--;

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:362:7: ( K_IF conditions= updateCondition )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==K_IF) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:362:9: K_IF conditions= updateCondition
                    {
                    match(input,K_IF,FOLLOW_K_IF_in_deleteStatement1733); 
                    pushFollow(FOLLOW_updateCondition_in_deleteStatement1737);
                    conditions=updateCondition();

                    state._fsp--;


                    }
                    break;

            }


                      return new DeleteStatement.Parsed(cf,
                                                        attrs,
                                                        columnDeletions,
                                                        wclause,
                                                        conditions == null ? Collections.<Pair<ColumnIdentifier, Operation.RawUpdate>>emptyList() : conditions);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "deleteStatement"


    // $ANTLR start "deleteSelection"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:372:1: deleteSelection returns [List<Operation.RawDeletion> operations] : t1= deleteOp ( ',' tN= deleteOp )* ;
    public final List<Operation.RawDeletion> deleteSelection() throws RecognitionException {
        List<Operation.RawDeletion> operations = null;

        Operation.RawDeletion t1 = null;

        Operation.RawDeletion tN = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:373:5: (t1= deleteOp ( ',' tN= deleteOp )* )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:373:7: t1= deleteOp ( ',' tN= deleteOp )*
            {
             operations = new ArrayList<Operation.RawDeletion>(); 
            pushFollow(FOLLOW_deleteOp_in_deleteSelection1783);
            t1=deleteOp();

            state._fsp--;

             operations.add(t1); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:375:11: ( ',' tN= deleteOp )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==135) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:375:12: ',' tN= deleteOp
            	    {
            	    match(input,135,FOLLOW_135_in_deleteSelection1798); 
            	    pushFollow(FOLLOW_deleteOp_in_deleteSelection1802);
            	    tN=deleteOp();

            	    state._fsp--;

            	     operations.add(tN); 

            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return operations;
    }
    // $ANTLR end "deleteSelection"


    // $ANTLR start "deleteOp"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:378:1: deleteOp returns [Operation.RawDeletion op] : (c= cident | c= cident '[' t= term ']' );
    public final Operation.RawDeletion deleteOp() throws RecognitionException {
        Operation.RawDeletion op = null;

        ColumnIdentifier c = null;

        Term.Raw t = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:379:5: (c= cident | c= cident '[' t= term ']' )
            int alt33=2;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:379:7: c= cident
                    {
                    pushFollow(FOLLOW_cident_in_deleteOp1829);
                    c=cident();

                    state._fsp--;

                     op = new Operation.ColumnDeletion(c); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:380:7: c= cident '[' t= term ']'
                    {
                    pushFollow(FOLLOW_cident_in_deleteOp1856);
                    c=cident();

                    state._fsp--;

                    match(input,137,FOLLOW_137_in_deleteOp1858); 
                    pushFollow(FOLLOW_term_in_deleteOp1862);
                    t=term();

                    state._fsp--;

                    match(input,138,FOLLOW_138_in_deleteOp1864); 
                     op = new Operation.ElementDeletion(c, t); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return op;
    }
    // $ANTLR end "deleteOp"


    // $ANTLR start "usingClauseDelete"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:383:1: usingClauseDelete[Attributes.Raw attrs] : K_USING K_TIMESTAMP ts= intValue ;
    public final void usingClauseDelete(Attributes.Raw attrs) throws RecognitionException {
        Term.Raw ts = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:384:5: ( K_USING K_TIMESTAMP ts= intValue )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:384:7: K_USING K_TIMESTAMP ts= intValue
            {
            match(input,K_USING,FOLLOW_K_USING_in_usingClauseDelete1884); 
            match(input,K_TIMESTAMP,FOLLOW_K_TIMESTAMP_in_usingClauseDelete1886); 
            pushFollow(FOLLOW_intValue_in_usingClauseDelete1890);
            ts=intValue();

            state._fsp--;

             attrs.timestamp = ts; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "usingClauseDelete"


    // $ANTLR start "batchStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:387:1: batchStatement returns [BatchStatement.Parsed expr] : K_BEGIN ( K_UNLOGGED | K_COUNTER )? K_BATCH ( usingClause[attrs] )? (s= batchStatementObjective ( ';' )? )+ K_APPLY K_BATCH ;
    public final BatchStatement.Parsed batchStatement() throws RecognitionException {
        BatchStatement.Parsed expr = null;

        ModificationStatement.Parsed s = null;



                BatchStatement.Type type = BatchStatement.Type.LOGGED;
                List<ModificationStatement.Parsed> statements = new ArrayList<ModificationStatement.Parsed>();
                Attributes.Raw attrs = new Attributes.Raw();
            
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:417:5: ( K_BEGIN ( K_UNLOGGED | K_COUNTER )? K_BATCH ( usingClause[attrs] )? (s= batchStatementObjective ( ';' )? )+ K_APPLY K_BATCH )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:417:7: K_BEGIN ( K_UNLOGGED | K_COUNTER )? K_BATCH ( usingClause[attrs] )? (s= batchStatementObjective ( ';' )? )+ K_APPLY K_BATCH
            {
            match(input,K_BEGIN,FOLLOW_K_BEGIN_in_batchStatement1924); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:418:7: ( K_UNLOGGED | K_COUNTER )?
            int alt34=3;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==K_UNLOGGED) ) {
                alt34=1;
            }
            else if ( (LA34_0==K_COUNTER) ) {
                alt34=2;
            }
            switch (alt34) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:418:9: K_UNLOGGED
                    {
                    match(input,K_UNLOGGED,FOLLOW_K_UNLOGGED_in_batchStatement1934); 
                     type = BatchStatement.Type.UNLOGGED; 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:418:63: K_COUNTER
                    {
                    match(input,K_COUNTER,FOLLOW_K_COUNTER_in_batchStatement1940); 
                     type = BatchStatement.Type.COUNTER; 

                    }
                    break;

            }

            match(input,K_BATCH,FOLLOW_K_BATCH_in_batchStatement1953); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:419:15: ( usingClause[attrs] )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==K_USING) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:419:17: usingClause[attrs]
                    {
                    pushFollow(FOLLOW_usingClause_in_batchStatement1957);
                    usingClause(attrs);

                    state._fsp--;


                    }
                    break;

            }

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:420:11: (s= batchStatementObjective ( ';' )? )+
            int cnt37=0;
            loop37:
            do {
                int alt37=2;
                int LA37_0 = input.LA(1);

                if ( (LA37_0==K_INSERT||LA37_0==K_UPDATE||LA37_0==K_DELETE) ) {
                    alt37=1;
                }


                switch (alt37) {
            	case 1 :
            	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:420:13: s= batchStatementObjective ( ';' )?
            	    {
            	    pushFollow(FOLLOW_batchStatementObjective_in_batchStatement1977);
            	    s=batchStatementObjective();

            	    state._fsp--;

            	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:420:39: ( ';' )?
            	    int alt36=2;
            	    int LA36_0 = input.LA(1);

            	    if ( (LA36_0==132) ) {
            	        alt36=1;
            	    }
            	    switch (alt36) {
            	        case 1 :
            	            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:420:39: ';'
            	            {
            	            match(input,132,FOLLOW_132_in_batchStatement1979); 

            	            }
            	            break;

            	    }

            	     statements.add(s); 

            	    }
            	    break;

            	default :
            	    if ( cnt37 >= 1 ) break loop37;
                        EarlyExitException eee =
                            new EarlyExitException(37, input);
                        throw eee;
                }
                cnt37++;
            } while (true);

            match(input,K_APPLY,FOLLOW_K_APPLY_in_batchStatement1993); 
            match(input,K_BATCH,FOLLOW_K_BATCH_in_batchStatement1995); 

                      return new BatchStatement.Parsed(type, attrs, statements);
                  

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "batchStatement"


    // $ANTLR start "batchStatementObjective"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:427:1: batchStatementObjective returns [ModificationStatement.Parsed statement] : (i= insertStatement | u= updateStatement | d= deleteStatement );
    public final ModificationStatement.Parsed batchStatementObjective() throws RecognitionException {
        ModificationStatement.Parsed statement = null;

        UpdateStatement.ParsedInsert i = null;

        UpdateStatement.ParsedUpdate u = null;

        DeleteStatement.Parsed d = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:428:5: (i= insertStatement | u= updateStatement | d= deleteStatement )
            int alt38=3;
            switch ( input.LA(1) ) {
            case K_INSERT:
                {
                alt38=1;
                }
                break;
            case K_UPDATE:
                {
                alt38=2;
                }
                break;
            case K_DELETE:
                {
                alt38=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:428:7: i= insertStatement
                    {
                    pushFollow(FOLLOW_insertStatement_in_batchStatementObjective2026);
                    i=insertStatement();

                    state._fsp--;

                     statement = i; 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:429:7: u= updateStatement
                    {
                    pushFollow(FOLLOW_updateStatement_in_batchStatementObjective2039);
                    u=updateStatement();

                    state._fsp--;

                     statement = u; 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:430:7: d= deleteStatement
                    {
                    pushFollow(FOLLOW_deleteStatement_in_batchStatementObjective2052);
                    d=deleteStatement();

                    state._fsp--;

                     statement = d; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return statement;
    }
    // $ANTLR end "batchStatementObjective"


    // $ANTLR start "createKeyspaceStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:433:1: createKeyspaceStatement returns [CreateKeyspaceStatement expr] : K_CREATE K_KEYSPACE ( K_IF K_NOT K_EXISTS )? ks= keyspaceName K_WITH properties[attrs] ;
    public final CreateKeyspaceStatement createKeyspaceStatement() throws RecognitionException {
        CreateKeyspaceStatement expr = null;

        String ks = null;



                KSPropDefs attrs = new KSPropDefs();
                boolean ifNotExists = false;
            
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:441:5: ( K_CREATE K_KEYSPACE ( K_IF K_NOT K_EXISTS )? ks= keyspaceName K_WITH properties[attrs] )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:441:7: K_CREATE K_KEYSPACE ( K_IF K_NOT K_EXISTS )? ks= keyspaceName K_WITH properties[attrs]
            {
            match(input,K_CREATE,FOLLOW_K_CREATE_in_createKeyspaceStatement2087); 
            match(input,K_KEYSPACE,FOLLOW_K_KEYSPACE_in_createKeyspaceStatement2089); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:441:27: ( K_IF K_NOT K_EXISTS )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==K_IF) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:441:28: K_IF K_NOT K_EXISTS
                    {
                    match(input,K_IF,FOLLOW_K_IF_in_createKeyspaceStatement2092); 
                    match(input,K_NOT,FOLLOW_K_NOT_in_createKeyspaceStatement2094); 
                    match(input,K_EXISTS,FOLLOW_K_EXISTS_in_createKeyspaceStatement2096); 
                     ifNotExists = true; 

                    }
                    break;

            }

            pushFollow(FOLLOW_keyspaceName_in_createKeyspaceStatement2105);
            ks=keyspaceName();

            state._fsp--;

            match(input,K_WITH,FOLLOW_K_WITH_in_createKeyspaceStatement2113); 
            pushFollow(FOLLOW_properties_in_createKeyspaceStatement2115);
            properties(attrs);

            state._fsp--;

             expr = new CreateKeyspaceStatement(ks, attrs, ifNotExists); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "createKeyspaceStatement"


    // $ANTLR start "createTableStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:445:1: createTableStatement returns [CreateTableStatement.RawStatement expr] : K_CREATE K_COLUMNFAMILY ( K_IF K_NOT K_EXISTS )? cf= columnFamilyName cfamDefinition[expr] ;
    public final CreateTableStatement.RawStatement createTableStatement() throws RecognitionException {
        CreateTableStatement.RawStatement expr = null;

        CFName cf = null;


         boolean ifNotExists = false; 
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:454:5: ( K_CREATE K_COLUMNFAMILY ( K_IF K_NOT K_EXISTS )? cf= columnFamilyName cfamDefinition[expr] )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:454:7: K_CREATE K_COLUMNFAMILY ( K_IF K_NOT K_EXISTS )? cf= columnFamilyName cfamDefinition[expr]
            {
            match(input,K_CREATE,FOLLOW_K_CREATE_in_createTableStatement2150); 
            match(input,K_COLUMNFAMILY,FOLLOW_K_COLUMNFAMILY_in_createTableStatement2152); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:454:31: ( K_IF K_NOT K_EXISTS )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==K_IF) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:454:32: K_IF K_NOT K_EXISTS
                    {
                    match(input,K_IF,FOLLOW_K_IF_in_createTableStatement2155); 
                    match(input,K_NOT,FOLLOW_K_NOT_in_createTableStatement2157); 
                    match(input,K_EXISTS,FOLLOW_K_EXISTS_in_createTableStatement2159); 
                     ifNotExists = true; 

                    }
                    break;

            }

            pushFollow(FOLLOW_columnFamilyName_in_createTableStatement2174);
            cf=columnFamilyName();

            state._fsp--;

             expr = new CreateTableStatement.RawStatement(cf, ifNotExists); 
            pushFollow(FOLLOW_cfamDefinition_in_createTableStatement2184);
            cfamDefinition(expr);

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "createTableStatement"


    // $ANTLR start "cfamDefinition"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:459:1: cfamDefinition[CreateTableStatement.RawStatement expr] : '(' cfamColumns[expr] ( ',' ( cfamColumns[expr] )? )* ')' ( K_WITH cfamProperty[expr] ( K_AND cfamProperty[expr] )* )? ;
    public final void cfamDefinition(CreateTableStatement.RawStatement expr) throws RecognitionException {
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:460:5: ( '(' cfamColumns[expr] ( ',' ( cfamColumns[expr] )? )* ')' ( K_WITH cfamProperty[expr] ( K_AND cfamProperty[expr] )* )? )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:460:7: '(' cfamColumns[expr] ( ',' ( cfamColumns[expr] )? )* ')' ( K_WITH cfamProperty[expr] ( K_AND cfamProperty[expr] )* )?
            {
            match(input,133,FOLLOW_133_in_cfamDefinition2203); 
            pushFollow(FOLLOW_cfamColumns_in_cfamDefinition2205);
            cfamColumns(expr);

            state._fsp--;

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:460:29: ( ',' ( cfamColumns[expr] )? )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==135) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:460:31: ',' ( cfamColumns[expr] )?
            	    {
            	    match(input,135,FOLLOW_135_in_cfamDefinition2210); 
            	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:460:35: ( cfamColumns[expr] )?
            	    int alt41=2;
            	    int LA41_0 = input.LA(1);

            	    if ( ((LA41_0>=K_COUNT && LA41_0<=K_AS)||(LA41_0>=K_FILTERING && LA41_0<=K_TTL)||LA41_0==K_VALUES||LA41_0==K_EXISTS||LA41_0==K_TIMESTAMP||LA41_0==K_COUNTER||(LA41_0>=K_PRIMARY && LA41_0<=K_CUSTOM)||LA41_0==IDENT||LA41_0==K_TRIGGER||LA41_0==K_TYPE||LA41_0==K_LIST||(LA41_0>=K_ALL && LA41_0<=QUOTED_NAME)||(LA41_0>=K_ASCII && LA41_0<=K_MAP)) ) {
            	        alt41=1;
            	    }
            	    switch (alt41) {
            	        case 1 :
            	            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:460:35: cfamColumns[expr]
            	            {
            	            pushFollow(FOLLOW_cfamColumns_in_cfamDefinition2212);
            	            cfamColumns(expr);

            	            state._fsp--;


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            match(input,134,FOLLOW_134_in_cfamDefinition2219); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:461:7: ( K_WITH cfamProperty[expr] ( K_AND cfamProperty[expr] )* )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==K_WITH) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:461:9: K_WITH cfamProperty[expr] ( K_AND cfamProperty[expr] )*
                    {
                    match(input,K_WITH,FOLLOW_K_WITH_in_cfamDefinition2229); 
                    pushFollow(FOLLOW_cfamProperty_in_cfamDefinition2231);
                    cfamProperty(expr);

                    state._fsp--;

                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:461:35: ( K_AND cfamProperty[expr] )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==K_AND) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:461:37: K_AND cfamProperty[expr]
                    	    {
                    	    match(input,K_AND,FOLLOW_K_AND_in_cfamDefinition2236); 
                    	    pushFollow(FOLLOW_cfamProperty_in_cfamDefinition2238);
                    	    cfamProperty(expr);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "cfamDefinition"


    // $ANTLR start "cfamColumns"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:464:1: cfamColumns[CreateTableStatement.RawStatement expr] : (k= cident v= comparatorType ( K_PRIMARY K_KEY )? | K_PRIMARY K_KEY '(' pkDef[expr] ( ',' c= cident )* ')' );
    public final void cfamColumns(CreateTableStatement.RawStatement expr) throws RecognitionException {
        ColumnIdentifier k = null;

        CQL3Type v = null;

        ColumnIdentifier c = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:465:5: (k= cident v= comparatorType ( K_PRIMARY K_KEY )? | K_PRIMARY K_KEY '(' pkDef[expr] ( ',' c= cident )* ')' )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( ((LA47_0>=K_COUNT && LA47_0<=K_AS)||(LA47_0>=K_FILTERING && LA47_0<=K_TTL)||LA47_0==K_VALUES||LA47_0==K_EXISTS||LA47_0==K_TIMESTAMP||LA47_0==K_COUNTER||(LA47_0>=K_KEY && LA47_0<=K_CUSTOM)||LA47_0==IDENT||LA47_0==K_TRIGGER||LA47_0==K_TYPE||LA47_0==K_LIST||(LA47_0>=K_ALL && LA47_0<=QUOTED_NAME)||(LA47_0>=K_ASCII && LA47_0<=K_MAP)) ) {
                alt47=1;
            }
            else if ( (LA47_0==K_PRIMARY) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:465:7: k= cident v= comparatorType ( K_PRIMARY K_KEY )?
                    {
                    pushFollow(FOLLOW_cident_in_cfamColumns2264);
                    k=cident();

                    state._fsp--;

                    pushFollow(FOLLOW_comparatorType_in_cfamColumns2268);
                    v=comparatorType();

                    state._fsp--;

                     expr.addDefinition(k, v); 
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:465:64: ( K_PRIMARY K_KEY )?
                    int alt45=2;
                    int LA45_0 = input.LA(1);

                    if ( (LA45_0==K_PRIMARY) ) {
                        alt45=1;
                    }
                    switch (alt45) {
                        case 1 :
                            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:465:65: K_PRIMARY K_KEY
                            {
                            match(input,K_PRIMARY,FOLLOW_K_PRIMARY_in_cfamColumns2273); 
                            match(input,K_KEY,FOLLOW_K_KEY_in_cfamColumns2275); 
                             expr.addKeyAliases(Collections.singletonList(k)); 

                            }
                            break;

                    }


                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:466:7: K_PRIMARY K_KEY '(' pkDef[expr] ( ',' c= cident )* ')'
                    {
                    match(input,K_PRIMARY,FOLLOW_K_PRIMARY_in_cfamColumns2287); 
                    match(input,K_KEY,FOLLOW_K_KEY_in_cfamColumns2289); 
                    match(input,133,FOLLOW_133_in_cfamColumns2291); 
                    pushFollow(FOLLOW_pkDef_in_cfamColumns2293);
                    pkDef(expr);

                    state._fsp--;

                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:466:39: ( ',' c= cident )*
                    loop46:
                    do {
                        int alt46=2;
                        int LA46_0 = input.LA(1);

                        if ( (LA46_0==135) ) {
                            alt46=1;
                        }


                        switch (alt46) {
                    	case 1 :
                    	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:466:40: ',' c= cident
                    	    {
                    	    match(input,135,FOLLOW_135_in_cfamColumns2297); 
                    	    pushFollow(FOLLOW_cident_in_cfamColumns2301);
                    	    c=cident();

                    	    state._fsp--;

                    	     expr.addColumnAlias(c); 

                    	    }
                    	    break;

                    	default :
                    	    break loop46;
                        }
                    } while (true);

                    match(input,134,FOLLOW_134_in_cfamColumns2308); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "cfamColumns"


    // $ANTLR start "pkDef"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:469:1: pkDef[CreateTableStatement.RawStatement expr] : (k= cident | '(' k1= cident ( ',' kn= cident )* ')' );
    public final void pkDef(CreateTableStatement.RawStatement expr) throws RecognitionException {
        ColumnIdentifier k = null;

        ColumnIdentifier k1 = null;

        ColumnIdentifier kn = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:470:5: (k= cident | '(' k1= cident ( ',' kn= cident )* ')' )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( ((LA49_0>=K_COUNT && LA49_0<=K_AS)||(LA49_0>=K_FILTERING && LA49_0<=K_TTL)||LA49_0==K_VALUES||LA49_0==K_EXISTS||LA49_0==K_TIMESTAMP||LA49_0==K_COUNTER||(LA49_0>=K_KEY && LA49_0<=K_CUSTOM)||LA49_0==IDENT||LA49_0==K_TRIGGER||LA49_0==K_TYPE||LA49_0==K_LIST||(LA49_0>=K_ALL && LA49_0<=QUOTED_NAME)||(LA49_0>=K_ASCII && LA49_0<=K_MAP)) ) {
                alt49=1;
            }
            else if ( (LA49_0==133) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:470:7: k= cident
                    {
                    pushFollow(FOLLOW_cident_in_pkDef2328);
                    k=cident();

                    state._fsp--;

                     expr.addKeyAliases(Collections.singletonList(k)); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:471:7: '(' k1= cident ( ',' kn= cident )* ')'
                    {
                    match(input,133,FOLLOW_133_in_pkDef2338); 
                     List<ColumnIdentifier> l = new ArrayList<ColumnIdentifier>(); 
                    pushFollow(FOLLOW_cident_in_pkDef2344);
                    k1=cident();

                    state._fsp--;

                     l.add(k1); 
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:471:102: ( ',' kn= cident )*
                    loop48:
                    do {
                        int alt48=2;
                        int LA48_0 = input.LA(1);

                        if ( (LA48_0==135) ) {
                            alt48=1;
                        }


                        switch (alt48) {
                    	case 1 :
                    	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:471:104: ',' kn= cident
                    	    {
                    	    match(input,135,FOLLOW_135_in_pkDef2350); 
                    	    pushFollow(FOLLOW_cident_in_pkDef2354);
                    	    kn=cident();

                    	    state._fsp--;

                    	     l.add(kn); 

                    	    }
                    	    break;

                    	default :
                    	    break loop48;
                        }
                    } while (true);

                    match(input,134,FOLLOW_134_in_pkDef2361); 
                     expr.addKeyAliases(l); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "pkDef"


    // $ANTLR start "cfamProperty"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:474:1: cfamProperty[CreateTableStatement.RawStatement expr] : ( property[expr.properties] | K_COMPACT K_STORAGE | K_CLUSTERING K_ORDER K_BY '(' cfamOrdering[expr] ( ',' cfamOrdering[expr] )* ')' );
    public final void cfamProperty(CreateTableStatement.RawStatement expr) throws RecognitionException {
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:475:5: ( property[expr.properties] | K_COMPACT K_STORAGE | K_CLUSTERING K_ORDER K_BY '(' cfamOrdering[expr] ( ',' cfamOrdering[expr] )* ')' )
            int alt51=3;
            switch ( input.LA(1) ) {
            case K_COUNT:
            case K_AS:
            case K_FILTERING:
            case K_WRITETIME:
            case K_TTL:
            case K_VALUES:
            case K_EXISTS:
            case K_TIMESTAMP:
            case K_COUNTER:
            case K_KEY:
            case K_STORAGE:
            case K_CUSTOM:
            case IDENT:
            case K_TRIGGER:
            case K_TYPE:
            case K_LIST:
            case K_ALL:
            case K_PERMISSIONS:
            case K_PERMISSION:
            case K_KEYSPACES:
            case K_USER:
            case K_SUPERUSER:
            case K_NOSUPERUSER:
            case K_USERS:
            case K_PASSWORD:
            case QUOTED_NAME:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
            case K_MAP:
                {
                alt51=1;
                }
                break;
            case K_COMPACT:
                {
                int LA51_2 = input.LA(2);

                if ( (LA51_2==K_STORAGE) ) {
                    alt51=2;
                }
                else if ( (LA51_2==143) ) {
                    alt51=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 2, input);

                    throw nvae;
                }
                }
                break;
            case K_CLUSTERING:
                {
                int LA51_3 = input.LA(2);

                if ( (LA51_3==K_ORDER) ) {
                    alt51=3;
                }
                else if ( (LA51_3==143) ) {
                    alt51=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 51, 3, input);

                    throw nvae;
                }
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 51, 0, input);

                throw nvae;
            }

            switch (alt51) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:475:7: property[expr.properties]
                    {
                    pushFollow(FOLLOW_property_in_cfamProperty2381);
                    property(expr.properties);

                    state._fsp--;


                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:476:7: K_COMPACT K_STORAGE
                    {
                    match(input,K_COMPACT,FOLLOW_K_COMPACT_in_cfamProperty2390); 
                    match(input,K_STORAGE,FOLLOW_K_STORAGE_in_cfamProperty2392); 
                     expr.setCompactStorage(); 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:477:7: K_CLUSTERING K_ORDER K_BY '(' cfamOrdering[expr] ( ',' cfamOrdering[expr] )* ')'
                    {
                    match(input,K_CLUSTERING,FOLLOW_K_CLUSTERING_in_cfamProperty2402); 
                    match(input,K_ORDER,FOLLOW_K_ORDER_in_cfamProperty2404); 
                    match(input,K_BY,FOLLOW_K_BY_in_cfamProperty2406); 
                    match(input,133,FOLLOW_133_in_cfamProperty2408); 
                    pushFollow(FOLLOW_cfamOrdering_in_cfamProperty2410);
                    cfamOrdering(expr);

                    state._fsp--;

                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:477:56: ( ',' cfamOrdering[expr] )*
                    loop50:
                    do {
                        int alt50=2;
                        int LA50_0 = input.LA(1);

                        if ( (LA50_0==135) ) {
                            alt50=1;
                        }


                        switch (alt50) {
                    	case 1 :
                    	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:477:57: ',' cfamOrdering[expr]
                    	    {
                    	    match(input,135,FOLLOW_135_in_cfamProperty2414); 
                    	    pushFollow(FOLLOW_cfamOrdering_in_cfamProperty2416);
                    	    cfamOrdering(expr);

                    	    state._fsp--;


                    	    }
                    	    break;

                    	default :
                    	    break loop50;
                        }
                    } while (true);

                    match(input,134,FOLLOW_134_in_cfamProperty2421); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "cfamProperty"


    // $ANTLR start "cfamOrdering"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:480:1: cfamOrdering[CreateTableStatement.RawStatement expr] : k= cident ( K_ASC | K_DESC ) ;
    public final void cfamOrdering(CreateTableStatement.RawStatement expr) throws RecognitionException {
        ColumnIdentifier k = null;


         boolean reversed=false; 
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:482:5: (k= cident ( K_ASC | K_DESC ) )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:482:7: k= cident ( K_ASC | K_DESC )
            {
            pushFollow(FOLLOW_cident_in_cfamOrdering2449);
            k=cident();

            state._fsp--;

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:482:16: ( K_ASC | K_DESC )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==K_ASC) ) {
                alt52=1;
            }
            else if ( (LA52_0==K_DESC) ) {
                alt52=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:482:17: K_ASC
                    {
                    match(input,K_ASC,FOLLOW_K_ASC_in_cfamOrdering2452); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:482:25: K_DESC
                    {
                    match(input,K_DESC,FOLLOW_K_DESC_in_cfamOrdering2456); 
                     reversed=true;

                    }
                    break;

            }

             expr.setOrdering(k, reversed); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "cfamOrdering"


    // $ANTLR start "createIndexStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:485:1: createIndexStatement returns [CreateIndexStatement expr] : K_CREATE ( K_CUSTOM )? K_INDEX ( K_IF K_NOT K_EXISTS )? (idxName= IDENT )? K_ON cf= columnFamilyName '(' id= cident ')' ( K_USING cls= STRING_LITERAL )? ;
    public final CreateIndexStatement createIndexStatement() throws RecognitionException {
        CreateIndexStatement expr = null;

        Token idxName=null;
        Token cls=null;
        CFName cf = null;

        ColumnIdentifier id = null;



                boolean isCustom = false;
                boolean ifNotExists = false;
            
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:494:5: ( K_CREATE ( K_CUSTOM )? K_INDEX ( K_IF K_NOT K_EXISTS )? (idxName= IDENT )? K_ON cf= columnFamilyName '(' id= cident ')' ( K_USING cls= STRING_LITERAL )? )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:494:7: K_CREATE ( K_CUSTOM )? K_INDEX ( K_IF K_NOT K_EXISTS )? (idxName= IDENT )? K_ON cf= columnFamilyName '(' id= cident ')' ( K_USING cls= STRING_LITERAL )?
            {
            match(input,K_CREATE,FOLLOW_K_CREATE_in_createIndexStatement2494); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:494:16: ( K_CUSTOM )?
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==K_CUSTOM) ) {
                alt53=1;
            }
            switch (alt53) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:494:17: K_CUSTOM
                    {
                    match(input,K_CUSTOM,FOLLOW_K_CUSTOM_in_createIndexStatement2497); 
                     isCustom = true; 

                    }
                    break;

            }

            match(input,K_INDEX,FOLLOW_K_INDEX_in_createIndexStatement2503); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:494:57: ( K_IF K_NOT K_EXISTS )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==K_IF) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:494:58: K_IF K_NOT K_EXISTS
                    {
                    match(input,K_IF,FOLLOW_K_IF_in_createIndexStatement2506); 
                    match(input,K_NOT,FOLLOW_K_NOT_in_createIndexStatement2508); 
                    match(input,K_EXISTS,FOLLOW_K_EXISTS_in_createIndexStatement2510); 
                     ifNotExists = true; 

                    }
                    break;

            }

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:495:9: (idxName= IDENT )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==IDENT) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:495:10: idxName= IDENT
                    {
                    idxName=(Token)match(input,IDENT,FOLLOW_IDENT_in_createIndexStatement2528); 

                    }
                    break;

            }

            match(input,K_ON,FOLLOW_K_ON_in_createIndexStatement2532); 
            pushFollow(FOLLOW_columnFamilyName_in_createIndexStatement2536);
            cf=columnFamilyName();

            state._fsp--;

            match(input,133,FOLLOW_133_in_createIndexStatement2538); 
            pushFollow(FOLLOW_cident_in_createIndexStatement2542);
            id=cident();

            state._fsp--;

            match(input,134,FOLLOW_134_in_createIndexStatement2544); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:496:9: ( K_USING cls= STRING_LITERAL )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==K_USING) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:496:11: K_USING cls= STRING_LITERAL
                    {
                    match(input,K_USING,FOLLOW_K_USING_in_createIndexStatement2556); 
                    cls=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_createIndexStatement2560); 

                    }
                    break;

            }

             expr = new CreateIndexStatement(cf, (idxName!=null?idxName.getText():null), id, ifNotExists, isCustom, (cls!=null?cls.getText():null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "createIndexStatement"


    // $ANTLR start "createTriggerStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:500:1: createTriggerStatement returns [CreateTriggerStatement expr] : K_CREATE K_TRIGGER (name= IDENT ) K_ON cf= columnFamilyName K_USING cls= STRING_LITERAL ;
    public final CreateTriggerStatement createTriggerStatement() throws RecognitionException {
        CreateTriggerStatement expr = null;

        Token name=null;
        Token cls=null;
        CFName cf = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:504:5: ( K_CREATE K_TRIGGER (name= IDENT ) K_ON cf= columnFamilyName K_USING cls= STRING_LITERAL )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:504:7: K_CREATE K_TRIGGER (name= IDENT ) K_ON cf= columnFamilyName K_USING cls= STRING_LITERAL
            {
            match(input,K_CREATE,FOLLOW_K_CREATE_in_createTriggerStatement2594); 
            match(input,K_TRIGGER,FOLLOW_K_TRIGGER_in_createTriggerStatement2596); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:504:26: (name= IDENT )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:504:27: name= IDENT
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_createTriggerStatement2601); 

            }

            match(input,K_ON,FOLLOW_K_ON_in_createTriggerStatement2604); 
            pushFollow(FOLLOW_columnFamilyName_in_createTriggerStatement2608);
            cf=columnFamilyName();

            state._fsp--;

            match(input,K_USING,FOLLOW_K_USING_in_createTriggerStatement2610); 
            cls=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_createTriggerStatement2614); 
             expr = new CreateTriggerStatement(cf, (name!=null?name.getText():null), (cls!=null?cls.getText():null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "createTriggerStatement"


    // $ANTLR start "dropTriggerStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:508:1: dropTriggerStatement returns [DropTriggerStatement expr] : K_DROP K_TRIGGER (name= IDENT ) K_ON cf= columnFamilyName ;
    public final DropTriggerStatement dropTriggerStatement() throws RecognitionException {
        DropTriggerStatement expr = null;

        Token name=null;
        CFName cf = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:512:5: ( K_DROP K_TRIGGER (name= IDENT ) K_ON cf= columnFamilyName )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:512:7: K_DROP K_TRIGGER (name= IDENT ) K_ON cf= columnFamilyName
            {
            match(input,K_DROP,FOLLOW_K_DROP_in_dropTriggerStatement2645); 
            match(input,K_TRIGGER,FOLLOW_K_TRIGGER_in_dropTriggerStatement2647); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:512:24: (name= IDENT )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:512:25: name= IDENT
            {
            name=(Token)match(input,IDENT,FOLLOW_IDENT_in_dropTriggerStatement2652); 

            }

            match(input,K_ON,FOLLOW_K_ON_in_dropTriggerStatement2655); 
            pushFollow(FOLLOW_columnFamilyName_in_dropTriggerStatement2659);
            cf=columnFamilyName();

            state._fsp--;

             expr = new DropTriggerStatement(cf, (name!=null?name.getText():null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "dropTriggerStatement"


    // $ANTLR start "alterKeyspaceStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:516:1: alterKeyspaceStatement returns [AlterKeyspaceStatement expr] : K_ALTER K_KEYSPACE ks= keyspaceName K_WITH properties[attrs] ;
    public final AlterKeyspaceStatement alterKeyspaceStatement() throws RecognitionException {
        AlterKeyspaceStatement expr = null;

        String ks = null;


         KSPropDefs attrs = new KSPropDefs(); 
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:521:5: ( K_ALTER K_KEYSPACE ks= keyspaceName K_WITH properties[attrs] )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:521:7: K_ALTER K_KEYSPACE ks= keyspaceName K_WITH properties[attrs]
            {
            match(input,K_ALTER,FOLLOW_K_ALTER_in_alterKeyspaceStatement2699); 
            match(input,K_KEYSPACE,FOLLOW_K_KEYSPACE_in_alterKeyspaceStatement2701); 
            pushFollow(FOLLOW_keyspaceName_in_alterKeyspaceStatement2705);
            ks=keyspaceName();

            state._fsp--;

            match(input,K_WITH,FOLLOW_K_WITH_in_alterKeyspaceStatement2715); 
            pushFollow(FOLLOW_properties_in_alterKeyspaceStatement2717);
            properties(attrs);

            state._fsp--;

             expr = new AlterKeyspaceStatement(ks, attrs); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "alterKeyspaceStatement"


    // $ANTLR start "alterTableStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:526:1: alterTableStatement returns [AlterTableStatement expr] : K_ALTER K_COLUMNFAMILY cf= columnFamilyName ( K_ALTER id= cident K_TYPE v= comparatorType | K_ADD id= cident v= comparatorType | K_DROP id= cident | K_WITH properties[props] | K_RENAME id1= cident K_TO toId1= cident ( K_AND idn= cident K_TO toIdn= cident )* ) ;
    public final AlterTableStatement alterTableStatement() throws RecognitionException {
        AlterTableStatement expr = null;

        CFName cf = null;

        ColumnIdentifier id = null;

        CQL3Type v = null;

        ColumnIdentifier id1 = null;

        ColumnIdentifier toId1 = null;

        ColumnIdentifier idn = null;

        ColumnIdentifier toIdn = null;



                AlterTableStatement.Type type = null;
                CFPropDefs props = new CFPropDefs();
                Map<ColumnIdentifier, ColumnIdentifier> renames = new HashMap<ColumnIdentifier, ColumnIdentifier>();
            
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:539:5: ( K_ALTER K_COLUMNFAMILY cf= columnFamilyName ( K_ALTER id= cident K_TYPE v= comparatorType | K_ADD id= cident v= comparatorType | K_DROP id= cident | K_WITH properties[props] | K_RENAME id1= cident K_TO toId1= cident ( K_AND idn= cident K_TO toIdn= cident )* ) )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:539:7: K_ALTER K_COLUMNFAMILY cf= columnFamilyName ( K_ALTER id= cident K_TYPE v= comparatorType | K_ADD id= cident v= comparatorType | K_DROP id= cident | K_WITH properties[props] | K_RENAME id1= cident K_TO toId1= cident ( K_AND idn= cident K_TO toIdn= cident )* )
            {
            match(input,K_ALTER,FOLLOW_K_ALTER_in_alterTableStatement2753); 
            match(input,K_COLUMNFAMILY,FOLLOW_K_COLUMNFAMILY_in_alterTableStatement2755); 
            pushFollow(FOLLOW_columnFamilyName_in_alterTableStatement2759);
            cf=columnFamilyName();

            state._fsp--;

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:540:11: ( K_ALTER id= cident K_TYPE v= comparatorType | K_ADD id= cident v= comparatorType | K_DROP id= cident | K_WITH properties[props] | K_RENAME id1= cident K_TO toId1= cident ( K_AND idn= cident K_TO toIdn= cident )* )
            int alt58=5;
            switch ( input.LA(1) ) {
            case K_ALTER:
                {
                alt58=1;
                }
                break;
            case K_ADD:
                {
                alt58=2;
                }
                break;
            case K_DROP:
                {
                alt58=3;
                }
                break;
            case K_WITH:
                {
                alt58=4;
                }
                break;
            case K_RENAME:
                {
                alt58=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 58, 0, input);

                throw nvae;
            }

            switch (alt58) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:540:13: K_ALTER id= cident K_TYPE v= comparatorType
                    {
                    match(input,K_ALTER,FOLLOW_K_ALTER_in_alterTableStatement2773); 
                    pushFollow(FOLLOW_cident_in_alterTableStatement2777);
                    id=cident();

                    state._fsp--;

                    match(input,K_TYPE,FOLLOW_K_TYPE_in_alterTableStatement2779); 
                    pushFollow(FOLLOW_comparatorType_in_alterTableStatement2783);
                    v=comparatorType();

                    state._fsp--;

                     type = AlterTableStatement.Type.ALTER; 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:541:13: K_ADD id= cident v= comparatorType
                    {
                    match(input,K_ADD,FOLLOW_K_ADD_in_alterTableStatement2799); 
                    pushFollow(FOLLOW_cident_in_alterTableStatement2805);
                    id=cident();

                    state._fsp--;

                    pushFollow(FOLLOW_comparatorType_in_alterTableStatement2809);
                    v=comparatorType();

                    state._fsp--;

                     type = AlterTableStatement.Type.ADD; 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:542:13: K_DROP id= cident
                    {
                    match(input,K_DROP,FOLLOW_K_DROP_in_alterTableStatement2832); 
                    pushFollow(FOLLOW_cident_in_alterTableStatement2837);
                    id=cident();

                    state._fsp--;

                     type = AlterTableStatement.Type.DROP; 

                    }
                    break;
                case 4 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:543:13: K_WITH properties[props]
                    {
                    match(input,K_WITH,FOLLOW_K_WITH_in_alterTableStatement2877); 
                    pushFollow(FOLLOW_properties_in_alterTableStatement2880);
                    properties(props);

                    state._fsp--;

                     type = AlterTableStatement.Type.OPTS; 

                    }
                    break;
                case 5 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:544:13: K_RENAME id1= cident K_TO toId1= cident ( K_AND idn= cident K_TO toIdn= cident )*
                    {
                    match(input,K_RENAME,FOLLOW_K_RENAME_in_alterTableStatement2913); 
                     type = AlterTableStatement.Type.RENAME; 
                    pushFollow(FOLLOW_cident_in_alterTableStatement2967);
                    id1=cident();

                    state._fsp--;

                    match(input,K_TO,FOLLOW_K_TO_in_alterTableStatement2969); 
                    pushFollow(FOLLOW_cident_in_alterTableStatement2973);
                    toId1=cident();

                    state._fsp--;

                     renames.put(id1, toId1); 
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:546:16: ( K_AND idn= cident K_TO toIdn= cident )*
                    loop57:
                    do {
                        int alt57=2;
                        int LA57_0 = input.LA(1);

                        if ( (LA57_0==K_AND) ) {
                            alt57=1;
                        }


                        switch (alt57) {
                    	case 1 :
                    	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:546:18: K_AND idn= cident K_TO toIdn= cident
                    	    {
                    	    match(input,K_AND,FOLLOW_K_AND_in_alterTableStatement2994); 
                    	    pushFollow(FOLLOW_cident_in_alterTableStatement2998);
                    	    idn=cident();

                    	    state._fsp--;

                    	    match(input,K_TO,FOLLOW_K_TO_in_alterTableStatement3000); 
                    	    pushFollow(FOLLOW_cident_in_alterTableStatement3004);
                    	    toIdn=cident();

                    	    state._fsp--;

                    	     renames.put(idn, toIdn); 

                    	    }
                    	    break;

                    	default :
                    	    break loop57;
                        }
                    } while (true);


                    }
                    break;

            }


                    expr = new AlterTableStatement(cf, type, id, v, props, renames);
                

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "alterTableStatement"


    // $ANTLR start "dropKeyspaceStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:553:1: dropKeyspaceStatement returns [DropKeyspaceStatement ksp] : K_DROP K_KEYSPACE ( K_IF K_EXISTS )? ks= keyspaceName ;
    public final DropKeyspaceStatement dropKeyspaceStatement() throws RecognitionException {
        DropKeyspaceStatement ksp = null;

        String ks = null;


         boolean ifExists = false; 
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:558:5: ( K_DROP K_KEYSPACE ( K_IF K_EXISTS )? ks= keyspaceName )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:558:7: K_DROP K_KEYSPACE ( K_IF K_EXISTS )? ks= keyspaceName
            {
            match(input,K_DROP,FOLLOW_K_DROP_in_dropKeyspaceStatement3059); 
            match(input,K_KEYSPACE,FOLLOW_K_KEYSPACE_in_dropKeyspaceStatement3061); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:558:25: ( K_IF K_EXISTS )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==K_IF) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:558:26: K_IF K_EXISTS
                    {
                    match(input,K_IF,FOLLOW_K_IF_in_dropKeyspaceStatement3064); 
                    match(input,K_EXISTS,FOLLOW_K_EXISTS_in_dropKeyspaceStatement3066); 
                     ifExists = true; 

                    }
                    break;

            }

            pushFollow(FOLLOW_keyspaceName_in_dropKeyspaceStatement3075);
            ks=keyspaceName();

            state._fsp--;

             ksp = new DropKeyspaceStatement(ks, ifExists); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ksp;
    }
    // $ANTLR end "dropKeyspaceStatement"


    // $ANTLR start "dropTableStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:561:1: dropTableStatement returns [DropTableStatement stmt] : K_DROP K_COLUMNFAMILY ( K_IF K_EXISTS )? cf= columnFamilyName ;
    public final DropTableStatement dropTableStatement() throws RecognitionException {
        DropTableStatement stmt = null;

        CFName cf = null;


         boolean ifExists = false; 
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:566:5: ( K_DROP K_COLUMNFAMILY ( K_IF K_EXISTS )? cf= columnFamilyName )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:566:7: K_DROP K_COLUMNFAMILY ( K_IF K_EXISTS )? cf= columnFamilyName
            {
            match(input,K_DROP,FOLLOW_K_DROP_in_dropTableStatement3109); 
            match(input,K_COLUMNFAMILY,FOLLOW_K_COLUMNFAMILY_in_dropTableStatement3111); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:566:29: ( K_IF K_EXISTS )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==K_IF) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:566:30: K_IF K_EXISTS
                    {
                    match(input,K_IF,FOLLOW_K_IF_in_dropTableStatement3114); 
                    match(input,K_EXISTS,FOLLOW_K_EXISTS_in_dropTableStatement3116); 
                     ifExists = true; 

                    }
                    break;

            }

            pushFollow(FOLLOW_columnFamilyName_in_dropTableStatement3125);
            cf=columnFamilyName();

            state._fsp--;

             stmt = new DropTableStatement(cf, ifExists); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "dropTableStatement"


    // $ANTLR start "dropIndexStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:569:1: dropIndexStatement returns [DropIndexStatement expr] : K_DROP K_INDEX ( K_IF K_EXISTS )? index= IDENT ;
    public final DropIndexStatement dropIndexStatement() throws RecognitionException {
        DropIndexStatement expr = null;

        Token index=null;

         boolean ifExists = false; 
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:574:5: ( K_DROP K_INDEX ( K_IF K_EXISTS )? index= IDENT )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:574:7: K_DROP K_INDEX ( K_IF K_EXISTS )? index= IDENT
            {
            match(input,K_DROP,FOLLOW_K_DROP_in_dropIndexStatement3159); 
            match(input,K_INDEX,FOLLOW_K_INDEX_in_dropIndexStatement3161); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:574:22: ( K_IF K_EXISTS )?
            int alt61=2;
            int LA61_0 = input.LA(1);

            if ( (LA61_0==K_IF) ) {
                alt61=1;
            }
            switch (alt61) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:574:23: K_IF K_EXISTS
                    {
                    match(input,K_IF,FOLLOW_K_IF_in_dropIndexStatement3164); 
                    match(input,K_EXISTS,FOLLOW_K_EXISTS_in_dropIndexStatement3166); 
                     ifExists = true; 

                    }
                    break;

            }

            index=(Token)match(input,IDENT,FOLLOW_IDENT_in_dropIndexStatement3175); 
             expr = new DropIndexStatement((index!=null?index.getText():null), ifExists); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return expr;
    }
    // $ANTLR end "dropIndexStatement"


    // $ANTLR start "truncateStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:578:1: truncateStatement returns [TruncateStatement stmt] : K_TRUNCATE cf= columnFamilyName ;
    public final TruncateStatement truncateStatement() throws RecognitionException {
        TruncateStatement stmt = null;

        CFName cf = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:582:5: ( K_TRUNCATE cf= columnFamilyName )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:582:7: K_TRUNCATE cf= columnFamilyName
            {
            match(input,K_TRUNCATE,FOLLOW_K_TRUNCATE_in_truncateStatement3206); 
            pushFollow(FOLLOW_columnFamilyName_in_truncateStatement3210);
            cf=columnFamilyName();

            state._fsp--;

             stmt = new TruncateStatement(cf); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "truncateStatement"


    // $ANTLR start "grantStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:585:1: grantStatement returns [GrantStatement stmt] : K_GRANT permissionOrAll K_ON resource K_TO username ;
    public final GrantStatement grantStatement() throws RecognitionException {
        GrantStatement stmt = null;

        Set<Permission> permissionOrAll1 = null;

        IResource resource2 = null;

        CqlParser.username_return username3 = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:589:5: ( K_GRANT permissionOrAll K_ON resource K_TO username )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:589:7: K_GRANT permissionOrAll K_ON resource K_TO username
            {
            match(input,K_GRANT,FOLLOW_K_GRANT_in_grantStatement3235); 
            pushFollow(FOLLOW_permissionOrAll_in_grantStatement3247);
            permissionOrAll1=permissionOrAll();

            state._fsp--;

            match(input,K_ON,FOLLOW_K_ON_in_grantStatement3255); 
            pushFollow(FOLLOW_resource_in_grantStatement3267);
            resource2=resource();

            state._fsp--;

            match(input,K_TO,FOLLOW_K_TO_in_grantStatement3275); 
            pushFollow(FOLLOW_username_in_grantStatement3287);
            username3=username();

            state._fsp--;

             stmt = new GrantStatement(permissionOrAll1, resource2, (username3!=null?input.toString(username3.start,username3.stop):null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "grantStatement"


    // $ANTLR start "revokeStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:598:1: revokeStatement returns [RevokeStatement stmt] : K_REVOKE permissionOrAll K_ON resource K_FROM username ;
    public final RevokeStatement revokeStatement() throws RecognitionException {
        RevokeStatement stmt = null;

        Set<Permission> permissionOrAll4 = null;

        IResource resource5 = null;

        CqlParser.username_return username6 = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:602:5: ( K_REVOKE permissionOrAll K_ON resource K_FROM username )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:602:7: K_REVOKE permissionOrAll K_ON resource K_FROM username
            {
            match(input,K_REVOKE,FOLLOW_K_REVOKE_in_revokeStatement3318); 
            pushFollow(FOLLOW_permissionOrAll_in_revokeStatement3330);
            permissionOrAll4=permissionOrAll();

            state._fsp--;

            match(input,K_ON,FOLLOW_K_ON_in_revokeStatement3338); 
            pushFollow(FOLLOW_resource_in_revokeStatement3350);
            resource5=resource();

            state._fsp--;

            match(input,K_FROM,FOLLOW_K_FROM_in_revokeStatement3358); 
            pushFollow(FOLLOW_username_in_revokeStatement3370);
            username6=username();

            state._fsp--;

             stmt = new RevokeStatement(permissionOrAll4, resource5, (username6!=null?input.toString(username6.start,username6.stop):null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "revokeStatement"


    // $ANTLR start "listPermissionsStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:611:1: listPermissionsStatement returns [ListPermissionsStatement stmt] : K_LIST permissionOrAll ( K_ON resource )? ( K_OF username )? ( K_NORECURSIVE )? ;
    public final ListPermissionsStatement listPermissionsStatement() throws RecognitionException {
        ListPermissionsStatement stmt = null;

        IResource resource7 = null;

        CqlParser.username_return username8 = null;

        Set<Permission> permissionOrAll9 = null;



                IResource resource = null;
                String username = null;
                boolean recursive = true;
            
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:617:5: ( K_LIST permissionOrAll ( K_ON resource )? ( K_OF username )? ( K_NORECURSIVE )? )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:617:7: K_LIST permissionOrAll ( K_ON resource )? ( K_OF username )? ( K_NORECURSIVE )?
            {
            match(input,K_LIST,FOLLOW_K_LIST_in_listPermissionsStatement3408); 
            pushFollow(FOLLOW_permissionOrAll_in_listPermissionsStatement3420);
            permissionOrAll9=permissionOrAll();

            state._fsp--;

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:619:7: ( K_ON resource )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==K_ON) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:619:9: K_ON resource
                    {
                    match(input,K_ON,FOLLOW_K_ON_in_listPermissionsStatement3430); 
                    pushFollow(FOLLOW_resource_in_listPermissionsStatement3432);
                    resource7=resource();

                    state._fsp--;

                     resource = resource7; 

                    }
                    break;

            }

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:620:7: ( K_OF username )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==K_OF) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:620:9: K_OF username
                    {
                    match(input,K_OF,FOLLOW_K_OF_in_listPermissionsStatement3447); 
                    pushFollow(FOLLOW_username_in_listPermissionsStatement3449);
                    username8=username();

                    state._fsp--;

                     username = (username8!=null?input.toString(username8.start,username8.stop):null); 

                    }
                    break;

            }

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:621:7: ( K_NORECURSIVE )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==K_NORECURSIVE) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:621:9: K_NORECURSIVE
                    {
                    match(input,K_NORECURSIVE,FOLLOW_K_NORECURSIVE_in_listPermissionsStatement3464); 
                     recursive = false; 

                    }
                    break;

            }

             stmt = new ListPermissionsStatement(permissionOrAll9, resource, username, recursive); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "listPermissionsStatement"


    // $ANTLR start "permission"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:625:1: permission returns [Permission perm] : p= ( K_CREATE | K_ALTER | K_DROP | K_SELECT | K_MODIFY | K_AUTHORIZE ) ;
    public final Permission permission() throws RecognitionException {
        Permission perm = null;

        Token p=null;

        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:626:5: (p= ( K_CREATE | K_ALTER | K_DROP | K_SELECT | K_MODIFY | K_AUTHORIZE ) )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:626:7: p= ( K_CREATE | K_ALTER | K_DROP | K_SELECT | K_MODIFY | K_AUTHORIZE )
            {
            p=(Token)input.LT(1);
            if ( input.LA(1)==K_SELECT||input.LA(1)==K_CREATE||(input.LA(1)>=K_DROP && input.LA(1)<=K_ALTER)||(input.LA(1)>=K_MODIFY && input.LA(1)<=K_AUTHORIZE) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }

             perm = Permission.valueOf((p!=null?p.getText():null).toUpperCase()); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return perm;
    }
    // $ANTLR end "permission"


    // $ANTLR start "permissionOrAll"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:630:1: permissionOrAll returns [Set<Permission> perms] : ( K_ALL ( K_PERMISSIONS )? | p= permission ( K_PERMISSION )? );
    public final Set<Permission> permissionOrAll() throws RecognitionException {
        Set<Permission> perms = null;

        Permission p = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:631:5: ( K_ALL ( K_PERMISSIONS )? | p= permission ( K_PERMISSION )? )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==K_ALL) ) {
                alt67=1;
            }
            else if ( (LA67_0==K_SELECT||LA67_0==K_CREATE||(LA67_0>=K_DROP && LA67_0<=K_ALTER)||(LA67_0>=K_MODIFY && LA67_0<=K_AUTHORIZE)) ) {
                alt67=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:631:7: K_ALL ( K_PERMISSIONS )?
                    {
                    match(input,K_ALL,FOLLOW_K_ALL_in_permissionOrAll3549); 
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:631:13: ( K_PERMISSIONS )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==K_PERMISSIONS) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:631:15: K_PERMISSIONS
                            {
                            match(input,K_PERMISSIONS,FOLLOW_K_PERMISSIONS_in_permissionOrAll3553); 

                            }
                            break;

                    }

                     perms = Permission.ALL_DATA; 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:632:7: p= permission ( K_PERMISSION )?
                    {
                    pushFollow(FOLLOW_permission_in_permissionOrAll3574);
                    p=permission();

                    state._fsp--;

                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:632:20: ( K_PERMISSION )?
                    int alt66=2;
                    int LA66_0 = input.LA(1);

                    if ( (LA66_0==K_PERMISSION) ) {
                        alt66=1;
                    }
                    switch (alt66) {
                        case 1 :
                            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:632:22: K_PERMISSION
                            {
                            match(input,K_PERMISSION,FOLLOW_K_PERMISSION_in_permissionOrAll3578); 

                            }
                            break;

                    }

                     perms = EnumSet.of(p); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return perms;
    }
    // $ANTLR end "permissionOrAll"


    // $ANTLR start "resource"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:635:1: resource returns [IResource res] : r= dataResource ;
    public final IResource resource() throws RecognitionException {
        IResource res = null;

        DataResource r = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:636:5: (r= dataResource )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:636:7: r= dataResource
            {
            pushFollow(FOLLOW_dataResource_in_resource3606);
            r=dataResource();

            state._fsp--;

             res = r; 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return res;
    }
    // $ANTLR end "resource"


    // $ANTLR start "dataResource"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:639:1: dataResource returns [DataResource res] : ( K_ALL K_KEYSPACES | K_KEYSPACE ks= keyspaceName | ( K_COLUMNFAMILY )? cf= columnFamilyName );
    public final DataResource dataResource() throws RecognitionException {
        DataResource res = null;

        String ks = null;

        CFName cf = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:640:5: ( K_ALL K_KEYSPACES | K_KEYSPACE ks= keyspaceName | ( K_COLUMNFAMILY )? cf= columnFamilyName )
            int alt69=3;
            switch ( input.LA(1) ) {
            case K_ALL:
                {
                int LA69_1 = input.LA(2);

                if ( (LA69_1==K_KEYSPACES) ) {
                    alt69=1;
                }
                else if ( (LA69_1==EOF||LA69_1==K_FROM||LA69_1==K_TO||(LA69_1>=K_OF && LA69_1<=K_NORECURSIVE)||LA69_1==132||LA69_1==139) ) {
                    alt69=3;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 69, 1, input);

                    throw nvae;
                }
                }
                break;
            case K_KEYSPACE:
                {
                alt69=2;
                }
                break;
            case K_COUNT:
            case K_AS:
            case K_FILTERING:
            case K_WRITETIME:
            case K_TTL:
            case K_VALUES:
            case K_EXISTS:
            case K_TIMESTAMP:
            case K_COUNTER:
            case K_COLUMNFAMILY:
            case K_KEY:
            case K_COMPACT:
            case K_STORAGE:
            case K_CLUSTERING:
            case K_CUSTOM:
            case IDENT:
            case K_TRIGGER:
            case K_TYPE:
            case K_LIST:
            case K_PERMISSIONS:
            case K_PERMISSION:
            case K_KEYSPACES:
            case K_USER:
            case K_SUPERUSER:
            case K_NOSUPERUSER:
            case K_USERS:
            case K_PASSWORD:
            case QUOTED_NAME:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
            case K_MAP:
                {
                alt69=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:640:7: K_ALL K_KEYSPACES
                    {
                    match(input,K_ALL,FOLLOW_K_ALL_in_dataResource3629); 
                    match(input,K_KEYSPACES,FOLLOW_K_KEYSPACES_in_dataResource3631); 
                     res = DataResource.root(); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:641:7: K_KEYSPACE ks= keyspaceName
                    {
                    match(input,K_KEYSPACE,FOLLOW_K_KEYSPACE_in_dataResource3641); 
                    pushFollow(FOLLOW_keyspaceName_in_dataResource3647);
                    ks=keyspaceName();

                    state._fsp--;

                     res = DataResource.keyspace(ks); 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:642:7: ( K_COLUMNFAMILY )? cf= columnFamilyName
                    {
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:642:7: ( K_COLUMNFAMILY )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( (LA68_0==K_COLUMNFAMILY) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:642:9: K_COLUMNFAMILY
                            {
                            match(input,K_COLUMNFAMILY,FOLLOW_K_COLUMNFAMILY_in_dataResource3659); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_columnFamilyName_in_dataResource3668);
                    cf=columnFamilyName();

                    state._fsp--;

                     res = DataResource.columnFamily(cf.getKeyspace(), cf.getColumnFamily()); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return res;
    }
    // $ANTLR end "dataResource"


    // $ANTLR start "createUserStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:646:1: createUserStatement returns [CreateUserStatement stmt] : K_CREATE K_USER username ( K_WITH userOptions[opts] )? ( K_SUPERUSER | K_NOSUPERUSER )? ;
    public final CreateUserStatement createUserStatement() throws RecognitionException {
        CreateUserStatement stmt = null;

        CqlParser.username_return username10 = null;



                UserOptions opts = new UserOptions();
                boolean superuser = false;
            
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:654:5: ( K_CREATE K_USER username ( K_WITH userOptions[opts] )? ( K_SUPERUSER | K_NOSUPERUSER )? )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:654:7: K_CREATE K_USER username ( K_WITH userOptions[opts] )? ( K_SUPERUSER | K_NOSUPERUSER )?
            {
            match(input,K_CREATE,FOLLOW_K_CREATE_in_createUserStatement3708); 
            match(input,K_USER,FOLLOW_K_USER_in_createUserStatement3710); 
            pushFollow(FOLLOW_username_in_createUserStatement3712);
            username10=username();

            state._fsp--;

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:655:7: ( K_WITH userOptions[opts] )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==K_WITH) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:655:9: K_WITH userOptions[opts]
                    {
                    match(input,K_WITH,FOLLOW_K_WITH_in_createUserStatement3722); 
                    pushFollow(FOLLOW_userOptions_in_createUserStatement3724);
                    userOptions(opts);

                    state._fsp--;


                    }
                    break;

            }

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:656:7: ( K_SUPERUSER | K_NOSUPERUSER )?
            int alt71=3;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==K_SUPERUSER) ) {
                alt71=1;
            }
            else if ( (LA71_0==K_NOSUPERUSER) ) {
                alt71=2;
            }
            switch (alt71) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:656:9: K_SUPERUSER
                    {
                    match(input,K_SUPERUSER,FOLLOW_K_SUPERUSER_in_createUserStatement3738); 
                     superuser = true; 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:656:45: K_NOSUPERUSER
                    {
                    match(input,K_NOSUPERUSER,FOLLOW_K_NOSUPERUSER_in_createUserStatement3744); 
                     superuser = false; 

                    }
                    break;

            }

             stmt = new CreateUserStatement((username10!=null?input.toString(username10.start,username10.stop):null), opts, superuser); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "createUserStatement"


    // $ANTLR start "alterUserStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:660:1: alterUserStatement returns [AlterUserStatement stmt] : K_ALTER K_USER username ( K_WITH userOptions[opts] )? ( K_SUPERUSER | K_NOSUPERUSER )? ;
    public final AlterUserStatement alterUserStatement() throws RecognitionException {
        AlterUserStatement stmt = null;

        CqlParser.username_return username11 = null;



                UserOptions opts = new UserOptions();
                Boolean superuser = null;
            
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:668:5: ( K_ALTER K_USER username ( K_WITH userOptions[opts] )? ( K_SUPERUSER | K_NOSUPERUSER )? )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:668:7: K_ALTER K_USER username ( K_WITH userOptions[opts] )? ( K_SUPERUSER | K_NOSUPERUSER )?
            {
            match(input,K_ALTER,FOLLOW_K_ALTER_in_alterUserStatement3789); 
            match(input,K_USER,FOLLOW_K_USER_in_alterUserStatement3791); 
            pushFollow(FOLLOW_username_in_alterUserStatement3793);
            username11=username();

            state._fsp--;

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:669:7: ( K_WITH userOptions[opts] )?
            int alt72=2;
            int LA72_0 = input.LA(1);

            if ( (LA72_0==K_WITH) ) {
                alt72=1;
            }
            switch (alt72) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:669:9: K_WITH userOptions[opts]
                    {
                    match(input,K_WITH,FOLLOW_K_WITH_in_alterUserStatement3803); 
                    pushFollow(FOLLOW_userOptions_in_alterUserStatement3805);
                    userOptions(opts);

                    state._fsp--;


                    }
                    break;

            }

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:670:7: ( K_SUPERUSER | K_NOSUPERUSER )?
            int alt73=3;
            int LA73_0 = input.LA(1);

            if ( (LA73_0==K_SUPERUSER) ) {
                alt73=1;
            }
            else if ( (LA73_0==K_NOSUPERUSER) ) {
                alt73=2;
            }
            switch (alt73) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:670:9: K_SUPERUSER
                    {
                    match(input,K_SUPERUSER,FOLLOW_K_SUPERUSER_in_alterUserStatement3819); 
                     superuser = true; 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:670:45: K_NOSUPERUSER
                    {
                    match(input,K_NOSUPERUSER,FOLLOW_K_NOSUPERUSER_in_alterUserStatement3825); 
                     superuser = false; 

                    }
                    break;

            }

             stmt = new AlterUserStatement((username11!=null?input.toString(username11.start,username11.stop):null), opts, superuser); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "alterUserStatement"


    // $ANTLR start "dropUserStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:674:1: dropUserStatement returns [DropUserStatement stmt] : K_DROP K_USER username ;
    public final DropUserStatement dropUserStatement() throws RecognitionException {
        DropUserStatement stmt = null;

        CqlParser.username_return username12 = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:678:5: ( K_DROP K_USER username )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:678:7: K_DROP K_USER username
            {
            match(input,K_DROP,FOLLOW_K_DROP_in_dropUserStatement3861); 
            match(input,K_USER,FOLLOW_K_USER_in_dropUserStatement3863); 
            pushFollow(FOLLOW_username_in_dropUserStatement3865);
            username12=username();

            state._fsp--;

             stmt = new DropUserStatement((username12!=null?input.toString(username12.start,username12.stop):null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "dropUserStatement"


    // $ANTLR start "listUsersStatement"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:681:1: listUsersStatement returns [ListUsersStatement stmt] : K_LIST K_USERS ;
    public final ListUsersStatement listUsersStatement() throws RecognitionException {
        ListUsersStatement stmt = null;

        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:685:5: ( K_LIST K_USERS )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:685:7: K_LIST K_USERS
            {
            match(input,K_LIST,FOLLOW_K_LIST_in_listUsersStatement3890); 
            match(input,K_USERS,FOLLOW_K_USERS_in_listUsersStatement3892); 
             stmt = new ListUsersStatement(); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stmt;
    }
    // $ANTLR end "listUsersStatement"


    // $ANTLR start "userOptions"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:688:1: userOptions[UserOptions opts] : userOption[opts] ;
    public final void userOptions(UserOptions opts) throws RecognitionException {
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:689:5: ( userOption[opts] )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:689:7: userOption[opts]
            {
            pushFollow(FOLLOW_userOption_in_userOptions3912);
            userOption(opts);

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "userOptions"


    // $ANTLR start "userOption"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:692:1: userOption[UserOptions opts] : k= K_PASSWORD v= STRING_LITERAL ;
    public final void userOption(UserOptions opts) throws RecognitionException {
        Token k=null;
        Token v=null;

        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:693:5: (k= K_PASSWORD v= STRING_LITERAL )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:693:7: k= K_PASSWORD v= STRING_LITERAL
            {
            k=(Token)match(input,K_PASSWORD,FOLLOW_K_PASSWORD_in_userOption3933); 
            v=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_userOption3937); 
             opts.put((k!=null?k.getText():null), (v!=null?v.getText():null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "userOption"


    // $ANTLR start "cident"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:696:1: cident returns [ColumnIdentifier id] : (t= IDENT | t= QUOTED_NAME | k= unreserved_keyword );
    public final ColumnIdentifier cident() throws RecognitionException {
        ColumnIdentifier id = null;

        Token t=null;
        String k = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:700:5: (t= IDENT | t= QUOTED_NAME | k= unreserved_keyword )
            int alt74=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt74=1;
                }
                break;
            case QUOTED_NAME:
                {
                alt74=2;
                }
                break;
            case K_COUNT:
            case K_AS:
            case K_FILTERING:
            case K_WRITETIME:
            case K_TTL:
            case K_VALUES:
            case K_EXISTS:
            case K_TIMESTAMP:
            case K_COUNTER:
            case K_KEY:
            case K_COMPACT:
            case K_STORAGE:
            case K_CLUSTERING:
            case K_CUSTOM:
            case K_TRIGGER:
            case K_TYPE:
            case K_LIST:
            case K_ALL:
            case K_PERMISSIONS:
            case K_PERMISSION:
            case K_KEYSPACES:
            case K_USER:
            case K_SUPERUSER:
            case K_NOSUPERUSER:
            case K_USERS:
            case K_PASSWORD:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
            case K_MAP:
                {
                alt74=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:700:7: t= IDENT
                    {
                    t=(Token)match(input,IDENT,FOLLOW_IDENT_in_cident3966); 
                     id = new ColumnIdentifier((t!=null?t.getText():null), false); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:701:7: t= QUOTED_NAME
                    {
                    t=(Token)match(input,QUOTED_NAME,FOLLOW_QUOTED_NAME_in_cident3991); 
                     id = new ColumnIdentifier((t!=null?t.getText():null), true); 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:702:7: k= unreserved_keyword
                    {
                    pushFollow(FOLLOW_unreserved_keyword_in_cident4010);
                    k=unreserved_keyword();

                    state._fsp--;

                     id = new ColumnIdentifier(k, false); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return id;
    }
    // $ANTLR end "cident"


    // $ANTLR start "keyspaceName"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:706:1: keyspaceName returns [String id] : cfOrKsName[name, true] ;
    public final String keyspaceName() throws RecognitionException {
        String id = null;

         CFName name = new CFName(); 
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:708:5: ( cfOrKsName[name, true] )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:708:7: cfOrKsName[name, true]
            {
            pushFollow(FOLLOW_cfOrKsName_in_keyspaceName4043);
            cfOrKsName(name, true);

            state._fsp--;

             id = name.getKeyspace(); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return id;
    }
    // $ANTLR end "keyspaceName"


    // $ANTLR start "columnFamilyName"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:711:1: columnFamilyName returns [CFName name] : ( cfOrKsName[name, true] '.' )? cfOrKsName[name, false] ;
    public final CFName columnFamilyName() throws RecognitionException {
        CFName name = null;

         name = new CFName(); 
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:713:5: ( ( cfOrKsName[name, true] '.' )? cfOrKsName[name, false] )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:713:7: ( cfOrKsName[name, true] '.' )? cfOrKsName[name, false]
            {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:713:7: ( cfOrKsName[name, true] '.' )?
            int alt75=2;
            alt75 = dfa75.predict(input);
            switch (alt75) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:713:8: cfOrKsName[name, true] '.'
                    {
                    pushFollow(FOLLOW_cfOrKsName_in_columnFamilyName4077);
                    cfOrKsName(name, true);

                    state._fsp--;

                    match(input,139,FOLLOW_139_in_columnFamilyName4080); 

                    }
                    break;

            }

            pushFollow(FOLLOW_cfOrKsName_in_columnFamilyName4084);
            cfOrKsName(name, false);

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return name;
    }
    // $ANTLR end "columnFamilyName"


    // $ANTLR start "cfOrKsName"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:716:1: cfOrKsName[CFName name, boolean isKs] : (t= IDENT | t= QUOTED_NAME | k= unreserved_keyword );
    public final void cfOrKsName(CFName name, boolean isKs) throws RecognitionException {
        Token t=null;
        String k = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:717:5: (t= IDENT | t= QUOTED_NAME | k= unreserved_keyword )
            int alt76=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt76=1;
                }
                break;
            case QUOTED_NAME:
                {
                alt76=2;
                }
                break;
            case K_COUNT:
            case K_AS:
            case K_FILTERING:
            case K_WRITETIME:
            case K_TTL:
            case K_VALUES:
            case K_EXISTS:
            case K_TIMESTAMP:
            case K_COUNTER:
            case K_KEY:
            case K_COMPACT:
            case K_STORAGE:
            case K_CLUSTERING:
            case K_CUSTOM:
            case K_TRIGGER:
            case K_TYPE:
            case K_LIST:
            case K_ALL:
            case K_PERMISSIONS:
            case K_PERMISSION:
            case K_KEYSPACES:
            case K_USER:
            case K_SUPERUSER:
            case K_NOSUPERUSER:
            case K_USERS:
            case K_PASSWORD:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
            case K_MAP:
                {
                alt76=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }

            switch (alt76) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:717:7: t= IDENT
                    {
                    t=(Token)match(input,IDENT,FOLLOW_IDENT_in_cfOrKsName4105); 
                     if (isKs) name.setKeyspace((t!=null?t.getText():null), false); else name.setColumnFamily((t!=null?t.getText():null), false); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:718:7: t= QUOTED_NAME
                    {
                    t=(Token)match(input,QUOTED_NAME,FOLLOW_QUOTED_NAME_in_cfOrKsName4130); 
                     if (isKs) name.setKeyspace((t!=null?t.getText():null), true); else name.setColumnFamily((t!=null?t.getText():null), true); 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:719:7: k= unreserved_keyword
                    {
                    pushFollow(FOLLOW_unreserved_keyword_in_cfOrKsName4149);
                    k=unreserved_keyword();

                    state._fsp--;

                     if (isKs) name.setKeyspace(k, false); else name.setColumnFamily(k, false); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "cfOrKsName"


    // $ANTLR start "constant"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:722:1: constant returns [Constants.Literal constant] : (t= STRING_LITERAL | t= INTEGER | t= FLOAT | t= BOOLEAN | t= UUID | t= HEXNUMBER );
    public final Constants.Literal constant() throws RecognitionException {
        Constants.Literal constant = null;

        Token t=null;

        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:723:5: (t= STRING_LITERAL | t= INTEGER | t= FLOAT | t= BOOLEAN | t= UUID | t= HEXNUMBER )
            int alt77=6;
            switch ( input.LA(1) ) {
            case STRING_LITERAL:
                {
                alt77=1;
                }
                break;
            case INTEGER:
                {
                alt77=2;
                }
                break;
            case FLOAT:
                {
                alt77=3;
                }
                break;
            case BOOLEAN:
                {
                alt77=4;
                }
                break;
            case UUID:
                {
                alt77=5;
                }
                break;
            case HEXNUMBER:
                {
                alt77=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }

            switch (alt77) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:723:7: t= STRING_LITERAL
                    {
                    t=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_constant4174); 
                     constant = Constants.Literal.string((t!=null?t.getText():null)); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:724:7: t= INTEGER
                    {
                    t=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_constant4186); 
                     constant = Constants.Literal.integer((t!=null?t.getText():null)); 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:725:7: t= FLOAT
                    {
                    t=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_constant4205); 
                     constant = Constants.Literal.floatingPoint((t!=null?t.getText():null)); 

                    }
                    break;
                case 4 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:726:7: t= BOOLEAN
                    {
                    t=(Token)match(input,BOOLEAN,FOLLOW_BOOLEAN_in_constant4226); 
                     constant = Constants.Literal.bool((t!=null?t.getText():null)); 

                    }
                    break;
                case 5 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:727:7: t= UUID
                    {
                    t=(Token)match(input,UUID,FOLLOW_UUID_in_constant4245); 
                     constant = Constants.Literal.uuid((t!=null?t.getText():null)); 

                    }
                    break;
                case 6 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:728:7: t= HEXNUMBER
                    {
                    t=(Token)match(input,HEXNUMBER,FOLLOW_HEXNUMBER_in_constant4267); 
                     constant = Constants.Literal.hex((t!=null?t.getText():null)); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return constant;
    }
    // $ANTLR end "constant"


    // $ANTLR start "map_literal"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:731:1: map_literal returns [Maps.Literal map] : '{' (k1= term ':' v1= term ( ',' kn= term ':' vn= term )* )? '}' ;
    public final Maps.Literal map_literal() throws RecognitionException {
        Maps.Literal map = null;

        Term.Raw k1 = null;

        Term.Raw v1 = null;

        Term.Raw kn = null;

        Term.Raw vn = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:732:5: ( '{' (k1= term ':' v1= term ( ',' kn= term ':' vn= term )* )? '}' )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:732:7: '{' (k1= term ':' v1= term ( ',' kn= term ':' vn= term )* )? '}'
            {
            match(input,140,FOLLOW_140_in_map_literal4295); 
             List<Pair<Term.Raw, Term.Raw>> m = new ArrayList<Pair<Term.Raw, Term.Raw>>(); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:733:11: (k1= term ':' v1= term ( ',' kn= term ':' vn= term )* )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==K_AS||LA79_0==K_FILTERING||LA79_0==INTEGER||LA79_0==K_VALUES||LA79_0==K_EXISTS||LA79_0==K_TIMESTAMP||LA79_0==K_COUNTER||(LA79_0>=K_KEY && LA79_0<=K_CUSTOM)||LA79_0==IDENT||(LA79_0>=STRING_LITERAL && LA79_0<=K_TRIGGER)||LA79_0==K_TYPE||LA79_0==K_LIST||(LA79_0>=K_ALL && LA79_0<=K_PASSWORD)||(LA79_0>=FLOAT && LA79_0<=K_TOKEN)||(LA79_0>=K_ASCII && LA79_0<=K_MAP)||LA79_0==133||LA79_0==137||LA79_0==140) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:733:13: k1= term ':' v1= term ( ',' kn= term ':' vn= term )*
                    {
                    pushFollow(FOLLOW_term_in_map_literal4313);
                    k1=term();

                    state._fsp--;

                    match(input,141,FOLLOW_141_in_map_literal4315); 
                    pushFollow(FOLLOW_term_in_map_literal4319);
                    v1=term();

                    state._fsp--;

                     m.add(Pair.create(k1, v1)); 
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:733:65: ( ',' kn= term ':' vn= term )*
                    loop78:
                    do {
                        int alt78=2;
                        int LA78_0 = input.LA(1);

                        if ( (LA78_0==135) ) {
                            alt78=1;
                        }


                        switch (alt78) {
                    	case 1 :
                    	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:733:67: ',' kn= term ':' vn= term
                    	    {
                    	    match(input,135,FOLLOW_135_in_map_literal4325); 
                    	    pushFollow(FOLLOW_term_in_map_literal4329);
                    	    kn=term();

                    	    state._fsp--;

                    	    match(input,141,FOLLOW_141_in_map_literal4331); 
                    	    pushFollow(FOLLOW_term_in_map_literal4335);
                    	    vn=term();

                    	    state._fsp--;

                    	     m.add(Pair.create(kn, vn)); 

                    	    }
                    	    break;

                    	default :
                    	    break loop78;
                        }
                    } while (true);


                    }
                    break;

            }

            match(input,142,FOLLOW_142_in_map_literal4351); 
             map = new Maps.Literal(m); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return map;
    }
    // $ANTLR end "map_literal"


    // $ANTLR start "set_or_map"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:737:1: set_or_map[Term.Raw t] returns [Term.Raw value] : ( ':' v= term ( ',' kn= term ':' vn= term )* | ( ',' tn= term )* );
    public final Term.Raw set_or_map(Term.Raw t) throws RecognitionException {
        Term.Raw value = null;

        Term.Raw v = null;

        Term.Raw kn = null;

        Term.Raw vn = null;

        Term.Raw tn = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:738:5: ( ':' v= term ( ',' kn= term ':' vn= term )* | ( ',' tn= term )* )
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==141) ) {
                alt82=1;
            }
            else if ( (LA82_0==135||LA82_0==142) ) {
                alt82=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 82, 0, input);

                throw nvae;
            }
            switch (alt82) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:738:7: ':' v= term ( ',' kn= term ':' vn= term )*
                    {
                    match(input,141,FOLLOW_141_in_set_or_map4375); 
                    pushFollow(FOLLOW_term_in_set_or_map4379);
                    v=term();

                    state._fsp--;

                     List<Pair<Term.Raw, Term.Raw>> m = new ArrayList<Pair<Term.Raw, Term.Raw>>(); m.add(Pair.create(t, v)); 
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:739:11: ( ',' kn= term ':' vn= term )*
                    loop80:
                    do {
                        int alt80=2;
                        int LA80_0 = input.LA(1);

                        if ( (LA80_0==135) ) {
                            alt80=1;
                        }


                        switch (alt80) {
                    	case 1 :
                    	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:739:13: ',' kn= term ':' vn= term
                    	    {
                    	    match(input,135,FOLLOW_135_in_set_or_map4395); 
                    	    pushFollow(FOLLOW_term_in_set_or_map4399);
                    	    kn=term();

                    	    state._fsp--;

                    	    match(input,141,FOLLOW_141_in_set_or_map4401); 
                    	    pushFollow(FOLLOW_term_in_set_or_map4405);
                    	    vn=term();

                    	    state._fsp--;

                    	     m.add(Pair.create(kn, vn)); 

                    	    }
                    	    break;

                    	default :
                    	    break loop80;
                        }
                    } while (true);

                     value = new Maps.Literal(m); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:741:7: ( ',' tn= term )*
                    {
                     List<Term.Raw> s = new ArrayList<Term.Raw>(); s.add(t); 
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:742:11: ( ',' tn= term )*
                    loop81:
                    do {
                        int alt81=2;
                        int LA81_0 = input.LA(1);

                        if ( (LA81_0==135) ) {
                            alt81=1;
                        }


                        switch (alt81) {
                    	case 1 :
                    	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:742:13: ',' tn= term
                    	    {
                    	    match(input,135,FOLLOW_135_in_set_or_map4440); 
                    	    pushFollow(FOLLOW_term_in_set_or_map4444);
                    	    tn=term();

                    	    state._fsp--;

                    	     s.add(tn); 

                    	    }
                    	    break;

                    	default :
                    	    break loop81;
                        }
                    } while (true);

                     value = new Sets.Literal(s); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "set_or_map"


    // $ANTLR start "collection_literal"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:746:1: collection_literal returns [Term.Raw value] : ( '[' (t1= term ( ',' tn= term )* )? ']' | '{' t= term v= set_or_map[t] '}' | '{' '}' );
    public final Term.Raw collection_literal() throws RecognitionException {
        Term.Raw value = null;

        Term.Raw t1 = null;

        Term.Raw tn = null;

        Term.Raw t = null;

        Term.Raw v = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:747:5: ( '[' (t1= term ( ',' tn= term )* )? ']' | '{' t= term v= set_or_map[t] '}' | '{' '}' )
            int alt85=3;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==137) ) {
                alt85=1;
            }
            else if ( (LA85_0==140) ) {
                int LA85_2 = input.LA(2);

                if ( (LA85_2==142) ) {
                    alt85=3;
                }
                else if ( (LA85_2==K_AS||LA85_2==K_FILTERING||LA85_2==INTEGER||LA85_2==K_VALUES||LA85_2==K_EXISTS||LA85_2==K_TIMESTAMP||LA85_2==K_COUNTER||(LA85_2>=K_KEY && LA85_2<=K_CUSTOM)||LA85_2==IDENT||(LA85_2>=STRING_LITERAL && LA85_2<=K_TRIGGER)||LA85_2==K_TYPE||LA85_2==K_LIST||(LA85_2>=K_ALL && LA85_2<=K_PASSWORD)||(LA85_2>=FLOAT && LA85_2<=K_TOKEN)||(LA85_2>=K_ASCII && LA85_2<=K_MAP)||LA85_2==133||LA85_2==137||LA85_2==140) ) {
                    alt85=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 85, 2, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 85, 0, input);

                throw nvae;
            }
            switch (alt85) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:747:7: '[' (t1= term ( ',' tn= term )* )? ']'
                    {
                    match(input,137,FOLLOW_137_in_collection_literal4478); 
                     List<Term.Raw> l = new ArrayList<Term.Raw>(); 
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:748:11: (t1= term ( ',' tn= term )* )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==K_AS||LA84_0==K_FILTERING||LA84_0==INTEGER||LA84_0==K_VALUES||LA84_0==K_EXISTS||LA84_0==K_TIMESTAMP||LA84_0==K_COUNTER||(LA84_0>=K_KEY && LA84_0<=K_CUSTOM)||LA84_0==IDENT||(LA84_0>=STRING_LITERAL && LA84_0<=K_TRIGGER)||LA84_0==K_TYPE||LA84_0==K_LIST||(LA84_0>=K_ALL && LA84_0<=K_PASSWORD)||(LA84_0>=FLOAT && LA84_0<=K_TOKEN)||(LA84_0>=K_ASCII && LA84_0<=K_MAP)||LA84_0==133||LA84_0==137||LA84_0==140) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:748:13: t1= term ( ',' tn= term )*
                            {
                            pushFollow(FOLLOW_term_in_collection_literal4496);
                            t1=term();

                            state._fsp--;

                             l.add(t1); 
                            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:748:36: ( ',' tn= term )*
                            loop83:
                            do {
                                int alt83=2;
                                int LA83_0 = input.LA(1);

                                if ( (LA83_0==135) ) {
                                    alt83=1;
                                }


                                switch (alt83) {
                            	case 1 :
                            	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:748:38: ',' tn= term
                            	    {
                            	    match(input,135,FOLLOW_135_in_collection_literal4502); 
                            	    pushFollow(FOLLOW_term_in_collection_literal4506);
                            	    tn=term();

                            	    state._fsp--;

                            	     l.add(tn); 

                            	    }
                            	    break;

                            	default :
                            	    break loop83;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,138,FOLLOW_138_in_collection_literal4522); 
                     value = new Lists.Literal(l); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:750:7: '{' t= term v= set_or_map[t] '}'
                    {
                    match(input,140,FOLLOW_140_in_collection_literal4532); 
                    pushFollow(FOLLOW_term_in_collection_literal4536);
                    t=term();

                    state._fsp--;

                    pushFollow(FOLLOW_set_or_map_in_collection_literal4540);
                    v=set_or_map(t);

                    state._fsp--;

                     value = v; 
                    match(input,142,FOLLOW_142_in_collection_literal4545); 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:753:7: '{' '}'
                    {
                    match(input,140,FOLLOW_140_in_collection_literal4563); 
                    match(input,142,FOLLOW_142_in_collection_literal4565); 
                     value = new Sets.Literal(Collections.<Term.Raw>emptyList()); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "collection_literal"


    // $ANTLR start "value"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:756:1: value returns [Term.Raw value] : (c= constant | l= collection_literal | K_NULL | QMARK );
    public final Term.Raw value() throws RecognitionException {
        Term.Raw value = null;

        Constants.Literal c = null;

        Term.Raw l = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:757:5: (c= constant | l= collection_literal | K_NULL | QMARK )
            int alt86=4;
            switch ( input.LA(1) ) {
            case INTEGER:
            case STRING_LITERAL:
            case FLOAT:
            case BOOLEAN:
            case UUID:
            case HEXNUMBER:
                {
                alt86=1;
                }
                break;
            case 137:
            case 140:
                {
                alt86=2;
                }
                break;
            case K_NULL:
                {
                alt86=3;
                }
                break;
            case QMARK:
                {
                alt86=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 86, 0, input);

                throw nvae;
            }

            switch (alt86) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:757:7: c= constant
                    {
                    pushFollow(FOLLOW_constant_in_value4590);
                    c=constant();

                    state._fsp--;

                     value = c; 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:758:7: l= collection_literal
                    {
                    pushFollow(FOLLOW_collection_literal_in_value4612);
                    l=collection_literal();

                    state._fsp--;

                     value = l; 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:759:7: K_NULL
                    {
                    match(input,K_NULL,FOLLOW_K_NULL_in_value4622); 
                     value = Constants.NULL_LITERAL; 

                    }
                    break;
                case 4 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:760:7: QMARK
                    {
                    match(input,QMARK,FOLLOW_QMARK_in_value4646); 
                     value = new AbstractMarker.Raw(++currentBindMarkerIdx); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "value"


    // $ANTLR start "intValue"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:763:1: intValue returns [Term.Raw value] : ( | t= INTEGER | QMARK );
    public final Term.Raw intValue() throws RecognitionException {
        Term.Raw value = null;

        Token t=null;

        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:764:5: ( | t= INTEGER | QMARK )
            int alt87=3;
            switch ( input.LA(1) ) {
            case EOF:
            case K_WHERE:
            case K_ALLOW:
            case K_AND:
            case K_INSERT:
            case K_UPDATE:
            case K_SET:
            case K_DELETE:
            case K_APPLY:
            case 132:
                {
                alt87=1;
                }
                break;
            case INTEGER:
                {
                alt87=2;
                }
                break;
            case QMARK:
                {
                alt87=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 87, 0, input);

                throw nvae;
            }

            switch (alt87) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:765:5: 
                    {
                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:765:7: t= INTEGER
                    {
                    t=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_intValue4692); 
                     value = Constants.Literal.integer((t!=null?t.getText():null)); 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:766:7: QMARK
                    {
                    match(input,QMARK,FOLLOW_QMARK_in_intValue4702); 
                     value = new AbstractMarker.Raw(++currentBindMarkerIdx); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return value;
    }
    // $ANTLR end "intValue"


    // $ANTLR start "functionName"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:769:1: functionName returns [String s] : (f= IDENT | u= unreserved_function_keyword | K_TOKEN );
    public final String functionName() throws RecognitionException {
        String s = null;

        Token f=null;
        String u = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:770:5: (f= IDENT | u= unreserved_function_keyword | K_TOKEN )
            int alt88=3;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt88=1;
                }
                break;
            case K_AS:
            case K_FILTERING:
            case K_VALUES:
            case K_EXISTS:
            case K_TIMESTAMP:
            case K_COUNTER:
            case K_KEY:
            case K_COMPACT:
            case K_STORAGE:
            case K_CLUSTERING:
            case K_CUSTOM:
            case K_TRIGGER:
            case K_TYPE:
            case K_LIST:
            case K_ALL:
            case K_PERMISSIONS:
            case K_PERMISSION:
            case K_KEYSPACES:
            case K_USER:
            case K_SUPERUSER:
            case K_NOSUPERUSER:
            case K_USERS:
            case K_PASSWORD:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
            case K_MAP:
                {
                alt88=2;
                }
                break;
            case K_TOKEN:
                {
                alt88=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }

            switch (alt88) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:770:7: f= IDENT
                    {
                    f=(Token)match(input,IDENT,FOLLOW_IDENT_in_functionName4731); 
                     s = (f!=null?f.getText():null); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:771:7: u= unreserved_function_keyword
                    {
                    pushFollow(FOLLOW_unreserved_function_keyword_in_functionName4765);
                    u=unreserved_function_keyword();

                    state._fsp--;

                     s = u; 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:772:7: K_TOKEN
                    {
                    match(input,K_TOKEN,FOLLOW_K_TOKEN_in_functionName4775); 
                     s = "token"; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return s;
    }
    // $ANTLR end "functionName"


    // $ANTLR start "functionArgs"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:775:1: functionArgs returns [List<Term.Raw> a] : ( '(' ')' | '(' t1= term ( ',' tn= term )* ')' );
    public final List<Term.Raw> functionArgs() throws RecognitionException {
        List<Term.Raw> a = null;

        Term.Raw t1 = null;

        Term.Raw tn = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:776:5: ( '(' ')' | '(' t1= term ( ',' tn= term )* ')' )
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==133) ) {
                int LA90_1 = input.LA(2);

                if ( (LA90_1==134) ) {
                    alt90=1;
                }
                else if ( (LA90_1==K_AS||LA90_1==K_FILTERING||LA90_1==INTEGER||LA90_1==K_VALUES||LA90_1==K_EXISTS||LA90_1==K_TIMESTAMP||LA90_1==K_COUNTER||(LA90_1>=K_KEY && LA90_1<=K_CUSTOM)||LA90_1==IDENT||(LA90_1>=STRING_LITERAL && LA90_1<=K_TRIGGER)||LA90_1==K_TYPE||LA90_1==K_LIST||(LA90_1>=K_ALL && LA90_1<=K_PASSWORD)||(LA90_1>=FLOAT && LA90_1<=K_TOKEN)||(LA90_1>=K_ASCII && LA90_1<=K_MAP)||LA90_1==133||LA90_1==137||LA90_1==140) ) {
                    alt90=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 90, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 90, 0, input);

                throw nvae;
            }
            switch (alt90) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:776:7: '(' ')'
                    {
                    match(input,133,FOLLOW_133_in_functionArgs4820); 
                    match(input,134,FOLLOW_134_in_functionArgs4822); 
                     a = Collections.emptyList(); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:777:7: '(' t1= term ( ',' tn= term )* ')'
                    {
                    match(input,133,FOLLOW_133_in_functionArgs4832); 
                    pushFollow(FOLLOW_term_in_functionArgs4836);
                    t1=term();

                    state._fsp--;

                     List<Term.Raw> args = new ArrayList<Term.Raw>(); args.add(t1); 
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:778:11: ( ',' tn= term )*
                    loop89:
                    do {
                        int alt89=2;
                        int LA89_0 = input.LA(1);

                        if ( (LA89_0==135) ) {
                            alt89=1;
                        }


                        switch (alt89) {
                    	case 1 :
                    	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:778:13: ',' tn= term
                    	    {
                    	    match(input,135,FOLLOW_135_in_functionArgs4852); 
                    	    pushFollow(FOLLOW_term_in_functionArgs4856);
                    	    tn=term();

                    	    state._fsp--;

                    	     args.add(tn); 

                    	    }
                    	    break;

                    	default :
                    	    break loop89;
                        }
                    } while (true);

                    match(input,134,FOLLOW_134_in_functionArgs4870); 
                     a = args; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return a;
    }
    // $ANTLR end "functionArgs"


    // $ANTLR start "term"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:782:1: term returns [Term.Raw term] : (v= value | f= functionName args= functionArgs | '(' c= comparatorType ')' t= term );
    public final Term.Raw term() throws RecognitionException {
        Term.Raw term = null;

        Term.Raw v = null;

        String f = null;

        List<Term.Raw> args = null;

        CQL3Type c = null;

        Term.Raw t = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:783:5: (v= value | f= functionName args= functionArgs | '(' c= comparatorType ')' t= term )
            int alt91=3;
            switch ( input.LA(1) ) {
            case INTEGER:
            case STRING_LITERAL:
            case FLOAT:
            case BOOLEAN:
            case UUID:
            case HEXNUMBER:
            case K_NULL:
            case QMARK:
            case 137:
            case 140:
                {
                alt91=1;
                }
                break;
            case K_AS:
            case K_FILTERING:
            case K_VALUES:
            case K_EXISTS:
            case K_TIMESTAMP:
            case K_COUNTER:
            case K_KEY:
            case K_COMPACT:
            case K_STORAGE:
            case K_CLUSTERING:
            case K_CUSTOM:
            case IDENT:
            case K_TRIGGER:
            case K_TYPE:
            case K_LIST:
            case K_ALL:
            case K_PERMISSIONS:
            case K_PERMISSION:
            case K_KEYSPACES:
            case K_USER:
            case K_SUPERUSER:
            case K_NOSUPERUSER:
            case K_USERS:
            case K_PASSWORD:
            case K_TOKEN:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
            case K_MAP:
                {
                alt91=2;
                }
                break;
            case 133:
                {
                alt91=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 91, 0, input);

                throw nvae;
            }

            switch (alt91) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:783:7: v= value
                    {
                    pushFollow(FOLLOW_value_in_term4895);
                    v=value();

                    state._fsp--;

                     term = v; 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:784:7: f= functionName args= functionArgs
                    {
                    pushFollow(FOLLOW_functionName_in_term4932);
                    f=functionName();

                    state._fsp--;

                    pushFollow(FOLLOW_functionArgs_in_term4936);
                    args=functionArgs();

                    state._fsp--;

                     term = new FunctionCall.Raw(f, args); 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:785:7: '(' c= comparatorType ')' t= term
                    {
                    match(input,133,FOLLOW_133_in_term4946); 
                    pushFollow(FOLLOW_comparatorType_in_term4950);
                    c=comparatorType();

                    state._fsp--;

                    match(input,134,FOLLOW_134_in_term4952); 
                    pushFollow(FOLLOW_term_in_term4956);
                    t=term();

                    state._fsp--;

                     term = new TypeCast(c, t); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return term;
    }
    // $ANTLR end "term"


    // $ANTLR start "columnOperation"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:788:1: columnOperation[List<Pair<ColumnIdentifier, Operation.RawUpdate>> operations] : (key= cident '=' t= term ( '+' c= cident )? | key= cident '=' c= cident sig= ( '+' | '-' ) t= term | key= cident '=' c= cident i= INTEGER | key= cident '[' k= term ']' '=' t= term );
    public final void columnOperation(List<Pair<ColumnIdentifier, Operation.RawUpdate>> operations) throws RecognitionException {
        Token sig=null;
        Token i=null;
        ColumnIdentifier key = null;

        Term.Raw t = null;

        ColumnIdentifier c = null;

        Term.Raw k = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:789:5: (key= cident '=' t= term ( '+' c= cident )? | key= cident '=' c= cident sig= ( '+' | '-' ) t= term | key= cident '=' c= cident i= INTEGER | key= cident '[' k= term ']' '=' t= term )
            int alt93=4;
            alt93 = dfa93.predict(input);
            switch (alt93) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:789:7: key= cident '=' t= term ( '+' c= cident )?
                    {
                    pushFollow(FOLLOW_cident_in_columnOperation4979);
                    key=cident();

                    state._fsp--;

                    match(input,143,FOLLOW_143_in_columnOperation4981); 
                    pushFollow(FOLLOW_term_in_columnOperation4985);
                    t=term();

                    state._fsp--;

                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:789:29: ( '+' c= cident )?
                    int alt92=2;
                    int LA92_0 = input.LA(1);

                    if ( (LA92_0==144) ) {
                        alt92=1;
                    }
                    switch (alt92) {
                        case 1 :
                            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:789:30: '+' c= cident
                            {
                            match(input,144,FOLLOW_144_in_columnOperation4988); 
                            pushFollow(FOLLOW_cident_in_columnOperation4992);
                            c=cident();

                            state._fsp--;


                            }
                            break;

                    }


                              if (c == null)
                              {
                                  addRawUpdate(operations, key, new Operation.SetValue(t));
                              }
                              else
                              {
                                  if (!key.equals(c))
                                      addRecognitionError("Only expressions of the form X = <value> + X are supported.");
                                  addRawUpdate(operations, key, new Operation.Prepend(t));
                              }
                          

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:802:7: key= cident '=' c= cident sig= ( '+' | '-' ) t= term
                    {
                    pushFollow(FOLLOW_cident_in_columnOperation5013);
                    key=cident();

                    state._fsp--;

                    match(input,143,FOLLOW_143_in_columnOperation5015); 
                    pushFollow(FOLLOW_cident_in_columnOperation5019);
                    c=cident();

                    state._fsp--;

                    sig=(Token)input.LT(1);
                    if ( (input.LA(1)>=144 && input.LA(1)<=145) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                    pushFollow(FOLLOW_term_in_columnOperation5033);
                    t=term();

                    state._fsp--;


                              if (!key.equals(c))
                                  addRecognitionError("Only expressions of the form X = X " + (sig!=null?sig.getText():null) + "<value> are supported.");
                              addRawUpdate(operations, key, (sig!=null?sig.getText():null).equals("+") ? new Operation.Addition(t) : new Operation.Substraction(t));
                          

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:808:7: key= cident '=' c= cident i= INTEGER
                    {
                    pushFollow(FOLLOW_cident_in_columnOperation5051);
                    key=cident();

                    state._fsp--;

                    match(input,143,FOLLOW_143_in_columnOperation5053); 
                    pushFollow(FOLLOW_cident_in_columnOperation5057);
                    c=cident();

                    state._fsp--;

                    i=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_columnOperation5061); 

                              // Note that this production *is* necessary because X = X - 3 will in fact be lexed as [ X, '=', X, INTEGER].
                              if (!key.equals(c))
                                  // We don't yet allow a '+' in front of an integer, but we could in the future really, so let's be future-proof in our error message
                                  addRecognitionError("Only expressions of the form X = X " + ((i!=null?i.getText():null).charAt(0) == '-' ? '-' : '+') + " <value> are supported.");
                              addRawUpdate(operations, key, new Operation.Addition(Constants.Literal.integer((i!=null?i.getText():null))));
                          

                    }
                    break;
                case 4 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:816:7: key= cident '[' k= term ']' '=' t= term
                    {
                    pushFollow(FOLLOW_cident_in_columnOperation5079);
                    key=cident();

                    state._fsp--;

                    match(input,137,FOLLOW_137_in_columnOperation5081); 
                    pushFollow(FOLLOW_term_in_columnOperation5085);
                    k=term();

                    state._fsp--;

                    match(input,138,FOLLOW_138_in_columnOperation5087); 
                    match(input,143,FOLLOW_143_in_columnOperation5089); 
                    pushFollow(FOLLOW_term_in_columnOperation5093);
                    t=term();

                    state._fsp--;


                              addRawUpdate(operations, key, new Operation.SetElement(k, t));
                          

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "columnOperation"


    // $ANTLR start "properties"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:822:1: properties[PropertyDefinitions props] : property[props] ( K_AND property[props] )* ;
    public final void properties(PropertyDefinitions props) throws RecognitionException {
        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:823:5: ( property[props] ( K_AND property[props] )* )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:823:7: property[props] ( K_AND property[props] )*
            {
            pushFollow(FOLLOW_property_in_properties5119);
            property(props);

            state._fsp--;

            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:823:23: ( K_AND property[props] )*
            loop94:
            do {
                int alt94=2;
                int LA94_0 = input.LA(1);

                if ( (LA94_0==K_AND) ) {
                    alt94=1;
                }


                switch (alt94) {
            	case 1 :
            	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:823:24: K_AND property[props]
            	    {
            	    match(input,K_AND,FOLLOW_K_AND_in_properties5123); 
            	    pushFollow(FOLLOW_property_in_properties5125);
            	    property(props);

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop94;
                }
            } while (true);


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "properties"


    // $ANTLR start "property"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:826:1: property[PropertyDefinitions props] : k= cident '=' (simple= propertyValue | map= map_literal ) ;
    public final void property(PropertyDefinitions props) throws RecognitionException {
        ColumnIdentifier k = null;

        String simple = null;

        Maps.Literal map = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:827:5: (k= cident '=' (simple= propertyValue | map= map_literal ) )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:827:7: k= cident '=' (simple= propertyValue | map= map_literal )
            {
            pushFollow(FOLLOW_cident_in_property5148);
            k=cident();

            state._fsp--;

            match(input,143,FOLLOW_143_in_property5150); 
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:827:20: (simple= propertyValue | map= map_literal )
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( ((LA95_0>=K_COUNT && LA95_0<=K_AS)||(LA95_0>=K_FILTERING && LA95_0<=INTEGER)||LA95_0==K_VALUES||LA95_0==K_EXISTS||LA95_0==K_TIMESTAMP||LA95_0==K_COUNTER||(LA95_0>=K_KEY && LA95_0<=K_CUSTOM)||(LA95_0>=STRING_LITERAL && LA95_0<=K_TRIGGER)||LA95_0==K_TYPE||LA95_0==K_LIST||(LA95_0>=K_ALL && LA95_0<=K_PASSWORD)||(LA95_0>=FLOAT && LA95_0<=HEXNUMBER)||(LA95_0>=K_ASCII && LA95_0<=K_MAP)) ) {
                alt95=1;
            }
            else if ( (LA95_0==140) ) {
                alt95=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 95, 0, input);

                throw nvae;
            }
            switch (alt95) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:827:21: simple= propertyValue
                    {
                    pushFollow(FOLLOW_propertyValue_in_property5155);
                    simple=propertyValue();

                    state._fsp--;

                     try { props.addProperty(k.toString(), simple); } catch (SyntaxException e) { addRecognitionError(e.getMessage()); } 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:828:24: map= map_literal
                    {
                    pushFollow(FOLLOW_map_literal_in_property5184);
                    map=map_literal();

                    state._fsp--;

                     try { props.addProperty(k.toString(), convertPropertyMap(map)); } catch (SyntaxException e) { addRecognitionError(e.getMessage()); } 

                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "property"


    // $ANTLR start "propertyValue"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:831:1: propertyValue returns [String str] : (c= constant | u= unreserved_keyword );
    public final String propertyValue() throws RecognitionException {
        String str = null;

        Constants.Literal c = null;

        String u = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:832:5: (c= constant | u= unreserved_keyword )
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==INTEGER||LA96_0==STRING_LITERAL||(LA96_0>=FLOAT && LA96_0<=HEXNUMBER)) ) {
                alt96=1;
            }
            else if ( ((LA96_0>=K_COUNT && LA96_0<=K_AS)||(LA96_0>=K_FILTERING && LA96_0<=K_TTL)||LA96_0==K_VALUES||LA96_0==K_EXISTS||LA96_0==K_TIMESTAMP||LA96_0==K_COUNTER||(LA96_0>=K_KEY && LA96_0<=K_CUSTOM)||LA96_0==K_TRIGGER||LA96_0==K_TYPE||LA96_0==K_LIST||(LA96_0>=K_ALL && LA96_0<=K_PASSWORD)||(LA96_0>=K_ASCII && LA96_0<=K_MAP)) ) {
                alt96=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 96, 0, input);

                throw nvae;
            }
            switch (alt96) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:832:7: c= constant
                    {
                    pushFollow(FOLLOW_constant_in_propertyValue5212);
                    c=constant();

                    state._fsp--;

                     str = c.getRawText(); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:833:7: u= unreserved_keyword
                    {
                    pushFollow(FOLLOW_unreserved_keyword_in_propertyValue5234);
                    u=unreserved_keyword();

                    state._fsp--;

                     str = u; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return str;
    }
    // $ANTLR end "propertyValue"


    // $ANTLR start "relationType"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:836:1: relationType returns [Relation.Type op] : ( '=' | '<' | '<=' | '>' | '>=' );
    public final Relation.Type relationType() throws RecognitionException {
        Relation.Type op = null;

        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:837:5: ( '=' | '<' | '<=' | '>' | '>=' )
            int alt97=5;
            switch ( input.LA(1) ) {
            case 143:
                {
                alt97=1;
                }
                break;
            case 146:
                {
                alt97=2;
                }
                break;
            case 147:
                {
                alt97=3;
                }
                break;
            case 148:
                {
                alt97=4;
                }
                break;
            case 149:
                {
                alt97=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 97, 0, input);

                throw nvae;
            }

            switch (alt97) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:837:7: '='
                    {
                    match(input,143,FOLLOW_143_in_relationType5257); 
                     op = Relation.Type.EQ; 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:838:7: '<'
                    {
                    match(input,146,FOLLOW_146_in_relationType5268); 
                     op = Relation.Type.LT; 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:839:7: '<='
                    {
                    match(input,147,FOLLOW_147_in_relationType5279); 
                     op = Relation.Type.LTE; 

                    }
                    break;
                case 4 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:840:7: '>'
                    {
                    match(input,148,FOLLOW_148_in_relationType5289); 
                     op = Relation.Type.GT; 

                    }
                    break;
                case 5 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:841:7: '>='
                    {
                    match(input,149,FOLLOW_149_in_relationType5300); 
                     op = Relation.Type.GTE; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return op;
    }
    // $ANTLR end "relationType"


    // $ANTLR start "relation"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:844:1: relation[List<Relation> clauses] : (name= cident type= relationType t= term | K_TOKEN '(' name1= cident ( ',' namen= cident )* ')' type= relationType t= term | name= cident K_IN '(' (f1= term ( ',' fN= term )* )? ')' );
    public final void relation(List<Relation> clauses) throws RecognitionException {
        ColumnIdentifier name = null;

        Relation.Type type = null;

        Term.Raw t = null;

        ColumnIdentifier name1 = null;

        ColumnIdentifier namen = null;

        Term.Raw f1 = null;

        Term.Raw fN = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:845:5: (name= cident type= relationType t= term | K_TOKEN '(' name1= cident ( ',' namen= cident )* ')' type= relationType t= term | name= cident K_IN '(' (f1= term ( ',' fN= term )* )? ')' )
            int alt101=3;
            alt101 = dfa101.predict(input);
            switch (alt101) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:845:7: name= cident type= relationType t= term
                    {
                    pushFollow(FOLLOW_cident_in_relation5322);
                    name=cident();

                    state._fsp--;

                    pushFollow(FOLLOW_relationType_in_relation5326);
                    type=relationType();

                    state._fsp--;

                    pushFollow(FOLLOW_term_in_relation5330);
                    t=term();

                    state._fsp--;

                     clauses.add(new Relation(name, type, t)); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:846:7: K_TOKEN '(' name1= cident ( ',' namen= cident )* ')' type= relationType t= term
                    {
                    match(input,K_TOKEN,FOLLOW_K_TOKEN_in_relation5340); 
                     List<ColumnIdentifier> l = new ArrayList<ColumnIdentifier>(); 
                    match(input,133,FOLLOW_133_in_relation5363); 
                    pushFollow(FOLLOW_cident_in_relation5367);
                    name1=cident();

                    state._fsp--;

                     l.add(name1); 
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:848:46: ( ',' namen= cident )*
                    loop98:
                    do {
                        int alt98=2;
                        int LA98_0 = input.LA(1);

                        if ( (LA98_0==135) ) {
                            alt98=1;
                        }


                        switch (alt98) {
                    	case 1 :
                    	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:848:48: ',' namen= cident
                    	    {
                    	    match(input,135,FOLLOW_135_in_relation5373); 
                    	    pushFollow(FOLLOW_cident_in_relation5377);
                    	    namen=cident();

                    	    state._fsp--;

                    	     l.add(namen); 

                    	    }
                    	    break;

                    	default :
                    	    break loop98;
                        }
                    } while (true);

                    match(input,134,FOLLOW_134_in_relation5383); 
                    pushFollow(FOLLOW_relationType_in_relation5395);
                    type=relationType();

                    state._fsp--;

                    pushFollow(FOLLOW_term_in_relation5399);
                    t=term();

                    state._fsp--;


                                for (ColumnIdentifier id : l)
                                    clauses.add(new Relation(id, type, t, true));
                            

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:854:7: name= cident K_IN '(' (f1= term ( ',' fN= term )* )? ')'
                    {
                    pushFollow(FOLLOW_cident_in_relation5419);
                    name=cident();

                    state._fsp--;

                    match(input,K_IN,FOLLOW_K_IN_in_relation5421); 
                     Relation rel = Relation.createInRelation(name); 
                    match(input,133,FOLLOW_133_in_relation5432); 
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:855:12: (f1= term ( ',' fN= term )* )?
                    int alt100=2;
                    int LA100_0 = input.LA(1);

                    if ( (LA100_0==K_AS||LA100_0==K_FILTERING||LA100_0==INTEGER||LA100_0==K_VALUES||LA100_0==K_EXISTS||LA100_0==K_TIMESTAMP||LA100_0==K_COUNTER||(LA100_0>=K_KEY && LA100_0<=K_CUSTOM)||LA100_0==IDENT||(LA100_0>=STRING_LITERAL && LA100_0<=K_TRIGGER)||LA100_0==K_TYPE||LA100_0==K_LIST||(LA100_0>=K_ALL && LA100_0<=K_PASSWORD)||(LA100_0>=FLOAT && LA100_0<=K_TOKEN)||(LA100_0>=K_ASCII && LA100_0<=K_MAP)||LA100_0==133||LA100_0==137||LA100_0==140) ) {
                        alt100=1;
                    }
                    switch (alt100) {
                        case 1 :
                            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:855:14: f1= term ( ',' fN= term )*
                            {
                            pushFollow(FOLLOW_term_in_relation5438);
                            f1=term();

                            state._fsp--;

                             rel.addInValue(f1); 
                            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:855:46: ( ',' fN= term )*
                            loop99:
                            do {
                                int alt99=2;
                                int LA99_0 = input.LA(1);

                                if ( (LA99_0==135) ) {
                                    alt99=1;
                                }


                                switch (alt99) {
                            	case 1 :
                            	    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:855:47: ',' fN= term
                            	    {
                            	    match(input,135,FOLLOW_135_in_relation5443); 
                            	    pushFollow(FOLLOW_term_in_relation5447);
                            	    fN=term();

                            	    state._fsp--;

                            	     rel.addInValue(fN); 

                            	    }
                            	    break;

                            	default :
                            	    break loop99;
                                }
                            } while (true);


                            }
                            break;

                    }

                    match(input,134,FOLLOW_134_in_relation5457); 
                     clauses.add(rel); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "relation"


    // $ANTLR start "comparatorType"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:858:1: comparatorType returns [CQL3Type t] : (c= native_type | c= collection_type | s= STRING_LITERAL );
    public final CQL3Type comparatorType() throws RecognitionException {
        CQL3Type t = null;

        Token s=null;
        CQL3Type c = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:859:5: (c= native_type | c= collection_type | s= STRING_LITERAL )
            int alt102=3;
            switch ( input.LA(1) ) {
            case K_TIMESTAMP:
            case K_COUNTER:
            case K_ASCII:
            case K_BIGINT:
            case K_BLOB:
            case K_BOOLEAN:
            case K_DECIMAL:
            case K_DOUBLE:
            case K_FLOAT:
            case K_INET:
            case K_INT:
            case K_TEXT:
            case K_UUID:
            case K_VARCHAR:
            case K_VARINT:
            case K_TIMEUUID:
                {
                alt102=1;
                }
                break;
            case K_SET:
            case K_LIST:
            case K_MAP:
                {
                alt102=2;
                }
                break;
            case STRING_LITERAL:
                {
                alt102=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }

            switch (alt102) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:859:7: c= native_type
                    {
                    pushFollow(FOLLOW_native_type_in_comparatorType5482);
                    c=native_type();

                    state._fsp--;

                     t = c; 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:860:7: c= collection_type
                    {
                    pushFollow(FOLLOW_collection_type_in_comparatorType5498);
                    c=collection_type();

                    state._fsp--;

                     t = c; 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:861:7: s= STRING_LITERAL
                    {
                    s=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_comparatorType5510); 

                            try {
                                t = new CQL3Type.Custom((s!=null?s.getText():null));
                            } catch (SyntaxException e) {
                                addRecognitionError("Cannot parse type " + (s!=null?s.getText():null) + ": " + e.getMessage());
                            } catch (ConfigurationException e) {
                                addRecognitionError("Error setting type " + (s!=null?s.getText():null) + ": " + e.getMessage());
                            }
                          

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return t;
    }
    // $ANTLR end "comparatorType"


    // $ANTLR start "native_type"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:873:1: native_type returns [CQL3Type t] : ( K_ASCII | K_BIGINT | K_BLOB | K_BOOLEAN | K_COUNTER | K_DECIMAL | K_DOUBLE | K_FLOAT | K_INET | K_INT | K_TEXT | K_TIMESTAMP | K_UUID | K_VARCHAR | K_VARINT | K_TIMEUUID );
    public final CQL3Type native_type() throws RecognitionException {
        CQL3Type t = null;

        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:874:5: ( K_ASCII | K_BIGINT | K_BLOB | K_BOOLEAN | K_COUNTER | K_DECIMAL | K_DOUBLE | K_FLOAT | K_INET | K_INT | K_TEXT | K_TIMESTAMP | K_UUID | K_VARCHAR | K_VARINT | K_TIMEUUID )
            int alt103=16;
            switch ( input.LA(1) ) {
            case K_ASCII:
                {
                alt103=1;
                }
                break;
            case K_BIGINT:
                {
                alt103=2;
                }
                break;
            case K_BLOB:
                {
                alt103=3;
                }
                break;
            case K_BOOLEAN:
                {
                alt103=4;
                }
                break;
            case K_COUNTER:
                {
                alt103=5;
                }
                break;
            case K_DECIMAL:
                {
                alt103=6;
                }
                break;
            case K_DOUBLE:
                {
                alt103=7;
                }
                break;
            case K_FLOAT:
                {
                alt103=8;
                }
                break;
            case K_INET:
                {
                alt103=9;
                }
                break;
            case K_INT:
                {
                alt103=10;
                }
                break;
            case K_TEXT:
                {
                alt103=11;
                }
                break;
            case K_TIMESTAMP:
                {
                alt103=12;
                }
                break;
            case K_UUID:
                {
                alt103=13;
                }
                break;
            case K_VARCHAR:
                {
                alt103=14;
                }
                break;
            case K_VARINT:
                {
                alt103=15;
                }
                break;
            case K_TIMEUUID:
                {
                alt103=16;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 103, 0, input);

                throw nvae;
            }

            switch (alt103) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:874:7: K_ASCII
                    {
                    match(input,K_ASCII,FOLLOW_K_ASCII_in_native_type5539); 
                     t = CQL3Type.Native.ASCII; 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:875:7: K_BIGINT
                    {
                    match(input,K_BIGINT,FOLLOW_K_BIGINT_in_native_type5553); 
                     t = CQL3Type.Native.BIGINT; 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:876:7: K_BLOB
                    {
                    match(input,K_BLOB,FOLLOW_K_BLOB_in_native_type5566); 
                     t = CQL3Type.Native.BLOB; 

                    }
                    break;
                case 4 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:877:7: K_BOOLEAN
                    {
                    match(input,K_BOOLEAN,FOLLOW_K_BOOLEAN_in_native_type5581); 
                     t = CQL3Type.Native.BOOLEAN; 

                    }
                    break;
                case 5 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:878:7: K_COUNTER
                    {
                    match(input,K_COUNTER,FOLLOW_K_COUNTER_in_native_type5593); 
                     t = CQL3Type.Native.COUNTER; 

                    }
                    break;
                case 6 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:879:7: K_DECIMAL
                    {
                    match(input,K_DECIMAL,FOLLOW_K_DECIMAL_in_native_type5605); 
                     t = CQL3Type.Native.DECIMAL; 

                    }
                    break;
                case 7 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:880:7: K_DOUBLE
                    {
                    match(input,K_DOUBLE,FOLLOW_K_DOUBLE_in_native_type5617); 
                     t = CQL3Type.Native.DOUBLE; 

                    }
                    break;
                case 8 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:881:7: K_FLOAT
                    {
                    match(input,K_FLOAT,FOLLOW_K_FLOAT_in_native_type5630); 
                     t = CQL3Type.Native.FLOAT; 

                    }
                    break;
                case 9 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:882:7: K_INET
                    {
                    match(input,K_INET,FOLLOW_K_INET_in_native_type5644); 
                     t = CQL3Type.Native.INET;

                    }
                    break;
                case 10 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:883:7: K_INT
                    {
                    match(input,K_INT,FOLLOW_K_INT_in_native_type5659); 
                     t = CQL3Type.Native.INT; 

                    }
                    break;
                case 11 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:884:7: K_TEXT
                    {
                    match(input,K_TEXT,FOLLOW_K_TEXT_in_native_type5675); 
                     t = CQL3Type.Native.TEXT; 

                    }
                    break;
                case 12 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:885:7: K_TIMESTAMP
                    {
                    match(input,K_TIMESTAMP,FOLLOW_K_TIMESTAMP_in_native_type5690); 
                     t = CQL3Type.Native.TIMESTAMP; 

                    }
                    break;
                case 13 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:886:7: K_UUID
                    {
                    match(input,K_UUID,FOLLOW_K_UUID_in_native_type5700); 
                     t = CQL3Type.Native.UUID; 

                    }
                    break;
                case 14 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:887:7: K_VARCHAR
                    {
                    match(input,K_VARCHAR,FOLLOW_K_VARCHAR_in_native_type5715); 
                     t = CQL3Type.Native.VARCHAR; 

                    }
                    break;
                case 15 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:888:7: K_VARINT
                    {
                    match(input,K_VARINT,FOLLOW_K_VARINT_in_native_type5727); 
                     t = CQL3Type.Native.VARINT; 

                    }
                    break;
                case 16 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:889:7: K_TIMEUUID
                    {
                    match(input,K_TIMEUUID,FOLLOW_K_TIMEUUID_in_native_type5740); 
                     t = CQL3Type.Native.TIMEUUID; 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return t;
    }
    // $ANTLR end "native_type"


    // $ANTLR start "collection_type"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:892:1: collection_type returns [CQL3Type pt] : ( K_MAP '<' t1= comparatorType ',' t2= comparatorType '>' | K_LIST '<' t= comparatorType '>' | K_SET '<' t= comparatorType '>' );
    public final CQL3Type collection_type() throws RecognitionException {
        CQL3Type pt = null;

        CQL3Type t1 = null;

        CQL3Type t2 = null;

        CQL3Type t = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:893:5: ( K_MAP '<' t1= comparatorType ',' t2= comparatorType '>' | K_LIST '<' t= comparatorType '>' | K_SET '<' t= comparatorType '>' )
            int alt104=3;
            switch ( input.LA(1) ) {
            case K_MAP:
                {
                alt104=1;
                }
                break;
            case K_LIST:
                {
                alt104=2;
                }
                break;
            case K_SET:
                {
                alt104=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 104, 0, input);

                throw nvae;
            }

            switch (alt104) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:893:7: K_MAP '<' t1= comparatorType ',' t2= comparatorType '>'
                    {
                    match(input,K_MAP,FOLLOW_K_MAP_in_collection_type5764); 
                    match(input,146,FOLLOW_146_in_collection_type5767); 
                    pushFollow(FOLLOW_comparatorType_in_collection_type5771);
                    t1=comparatorType();

                    state._fsp--;

                    match(input,135,FOLLOW_135_in_collection_type5773); 
                    pushFollow(FOLLOW_comparatorType_in_collection_type5777);
                    t2=comparatorType();

                    state._fsp--;

                    match(input,148,FOLLOW_148_in_collection_type5779); 
                     try {
                                // if we can't parse either t1 or t2, antlr will "recover" and we may have t1 or t2 null.
                                if (t1 != null && t2 != null)
                                    pt = CQL3Type.Collection.map(t1, t2);
                              } catch (InvalidRequestException e) { addRecognitionError(e.getMessage()); } 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:899:7: K_LIST '<' t= comparatorType '>'
                    {
                    match(input,K_LIST,FOLLOW_K_LIST_in_collection_type5797); 
                    match(input,146,FOLLOW_146_in_collection_type5799); 
                    pushFollow(FOLLOW_comparatorType_in_collection_type5803);
                    t=comparatorType();

                    state._fsp--;

                    match(input,148,FOLLOW_148_in_collection_type5805); 
                     try { if (t != null) pt = CQL3Type.Collection.list(t); } catch (InvalidRequestException e) { addRecognitionError(e.getMessage()); } 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:901:7: K_SET '<' t= comparatorType '>'
                    {
                    match(input,K_SET,FOLLOW_K_SET_in_collection_type5823); 
                    match(input,146,FOLLOW_146_in_collection_type5826); 
                    pushFollow(FOLLOW_comparatorType_in_collection_type5830);
                    t=comparatorType();

                    state._fsp--;

                    match(input,148,FOLLOW_148_in_collection_type5832); 
                     try { if (t != null) pt = CQL3Type.Collection.set(t); } catch (InvalidRequestException e) { addRecognitionError(e.getMessage()); } 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return pt;
    }
    // $ANTLR end "collection_type"

    public static class username_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "username"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:905:1: username : ( IDENT | STRING_LITERAL );
    public final CqlParser.username_return username() throws RecognitionException {
        CqlParser.username_return retval = new CqlParser.username_return();
        retval.start = input.LT(1);

        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:906:5: ( IDENT | STRING_LITERAL )
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:
            {
            if ( input.LA(1)==IDENT||input.LA(1)==STRING_LITERAL ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "username"


    // $ANTLR start "unreserved_keyword"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:910:1: unreserved_keyword returns [String str] : (u= unreserved_function_keyword | k= ( K_TTL | K_COUNT | K_WRITETIME ) );
    public final String unreserved_keyword() throws RecognitionException {
        String str = null;

        Token k=null;
        String u = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:911:5: (u= unreserved_function_keyword | k= ( K_TTL | K_COUNT | K_WRITETIME ) )
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==K_AS||LA105_0==K_FILTERING||LA105_0==K_VALUES||LA105_0==K_EXISTS||LA105_0==K_TIMESTAMP||LA105_0==K_COUNTER||(LA105_0>=K_KEY && LA105_0<=K_CUSTOM)||LA105_0==K_TRIGGER||LA105_0==K_TYPE||LA105_0==K_LIST||(LA105_0>=K_ALL && LA105_0<=K_PASSWORD)||(LA105_0>=K_ASCII && LA105_0<=K_MAP)) ) {
                alt105=1;
            }
            else if ( (LA105_0==K_COUNT||(LA105_0>=K_WRITETIME && LA105_0<=K_TTL)) ) {
                alt105=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 105, 0, input);

                throw nvae;
            }
            switch (alt105) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:911:7: u= unreserved_function_keyword
                    {
                    pushFollow(FOLLOW_unreserved_function_keyword_in_unreserved_keyword5890);
                    u=unreserved_function_keyword();

                    state._fsp--;

                     str = u; 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:912:7: k= ( K_TTL | K_COUNT | K_WRITETIME )
                    {
                    k=(Token)input.LT(1);
                    if ( input.LA(1)==K_COUNT||(input.LA(1)>=K_WRITETIME && input.LA(1)<=K_TTL) ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                     str = (k!=null?k.getText():null); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return str;
    }
    // $ANTLR end "unreserved_keyword"


    // $ANTLR start "unreserved_function_keyword"
    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:915:1: unreserved_function_keyword returns [String str] : (k= ( K_KEY | K_AS | K_CLUSTERING | K_COMPACT | K_STORAGE | K_TYPE | K_VALUES | K_MAP | K_LIST | K_FILTERING | K_PERMISSION | K_PERMISSIONS | K_KEYSPACES | K_ALL | K_USER | K_USERS | K_SUPERUSER | K_NOSUPERUSER | K_PASSWORD | K_EXISTS | K_CUSTOM | K_TRIGGER ) | t= native_type );
    public final String unreserved_function_keyword() throws RecognitionException {
        String str = null;

        Token k=null;
        CQL3Type t = null;


        try {
            // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:916:5: (k= ( K_KEY | K_AS | K_CLUSTERING | K_COMPACT | K_STORAGE | K_TYPE | K_VALUES | K_MAP | K_LIST | K_FILTERING | K_PERMISSION | K_PERMISSIONS | K_KEYSPACES | K_ALL | K_USER | K_USERS | K_SUPERUSER | K_NOSUPERUSER | K_PASSWORD | K_EXISTS | K_CUSTOM | K_TRIGGER ) | t= native_type )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==K_AS||LA106_0==K_FILTERING||LA106_0==K_VALUES||LA106_0==K_EXISTS||(LA106_0>=K_KEY && LA106_0<=K_CUSTOM)||LA106_0==K_TRIGGER||LA106_0==K_TYPE||LA106_0==K_LIST||(LA106_0>=K_ALL && LA106_0<=K_PASSWORD)||LA106_0==K_MAP) ) {
                alt106=1;
            }
            else if ( (LA106_0==K_TIMESTAMP||LA106_0==K_COUNTER||(LA106_0>=K_ASCII && LA106_0<=K_TIMEUUID)) ) {
                alt106=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }
            switch (alt106) {
                case 1 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:916:7: k= ( K_KEY | K_AS | K_CLUSTERING | K_COMPACT | K_STORAGE | K_TYPE | K_VALUES | K_MAP | K_LIST | K_FILTERING | K_PERMISSION | K_PERMISSIONS | K_KEYSPACES | K_ALL | K_USER | K_USERS | K_SUPERUSER | K_NOSUPERUSER | K_PASSWORD | K_EXISTS | K_CUSTOM | K_TRIGGER )
                    {
                    k=(Token)input.LT(1);
                    if ( input.LA(1)==K_AS||input.LA(1)==K_FILTERING||input.LA(1)==K_VALUES||input.LA(1)==K_EXISTS||(input.LA(1)>=K_KEY && input.LA(1)<=K_CUSTOM)||input.LA(1)==K_TRIGGER||input.LA(1)==K_TYPE||input.LA(1)==K_LIST||(input.LA(1)>=K_ALL && input.LA(1)<=K_PASSWORD)||input.LA(1)==K_MAP ) {
                        input.consume();
                        state.errorRecovery=false;
                    }
                    else {
                        MismatchedSetException mse = new MismatchedSetException(null,input);
                        throw mse;
                    }

                     str = (k!=null?k.getText():null); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\research/src/java/org/apache/cassandra/cql3/Cql.g:939:7: t= native_type
                    {
                    pushFollow(FOLLOW_native_type_in_unreserved_function_keyword6217);
                    t=native_type();

                    state._fsp--;

                     str = t.toString(); 

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return str;
    }
    // $ANTLR end "unreserved_function_keyword"

    // Delegated rules


    protected DFA2 dfa2 = new DFA2(this);
    protected DFA13 dfa13 = new DFA13(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA75 dfa75 = new DFA75(this);
    protected DFA93 dfa93 = new DFA93(this);
    protected DFA101 dfa101 = new DFA101(this);
    static final String DFA2_eotS =
        "\35\uffff";
    static final String DFA2_eofS =
        "\35\uffff";
    static final String DFA2_minS =
        "\1\4\7\uffff\3\46\2\uffff\1\5\17\uffff";
    static final String DFA2_maxS =
        "\1\75\7\uffff\3\106\2\uffff\1\111\17\uffff";
    static final String DFA2_acceptS =
        "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\7\3\uffff\1\20\1\21\1\uffff"+
        "\1\10\1\11\1\23\1\27\1\12\1\13\1\14\1\15\1\25\1\30\1\16\1\17\1\24"+
        "\1\26\1\22";
    static final String DFA2_specialS =
        "\35\uffff}>";
    static final String[] DFA2_transitionS = {
            "\1\6\1\1\17\uffff\1\2\7\uffff\1\3\1\uffff\1\5\1\4\4\uffff\1"+
            "\10\16\uffff\1\11\1\12\4\uffff\1\7\1\13\1\14\1\15",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\16\1\uffff\1\17\5\uffff\2\22\3\uffff\1\21\22\uffff\1\20",
            "\1\23\1\uffff\1\24\6\uffff\1\25\3\uffff\1\27\22\uffff\1\26",
            "\1\31\1\uffff\1\30\35\uffff\1\32",
            "",
            "",
            "\1\34\37\uffff\1\34\16\uffff\2\34\12\uffff\3\34\6\uffff\1"+
            "\33",
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
            return "172:1: cqlStatement returns [ParsedStatement stmt] : (st1= selectStatement | st2= insertStatement | st3= updateStatement | st4= batchStatement | st5= deleteStatement | st6= useStatement | st7= truncateStatement | st8= createKeyspaceStatement | st9= createTableStatement | st10= createIndexStatement | st11= dropKeyspaceStatement | st12= dropTableStatement | st13= dropIndexStatement | st14= alterTableStatement | st15= alterKeyspaceStatement | st16= grantStatement | st17= revokeStatement | st18= listPermissionsStatement | st19= createUserStatement | st20= alterUserStatement | st21= dropUserStatement | st22= listUsersStatement | st23= createTriggerStatement | st24= dropTriggerStatement );";
        }
    }
    static final String DFA13_eotS =
        "\31\uffff";
    static final String DFA13_eofS =
        "\31\uffff";
    static final String DFA13_minS =
        "\1\6\1\7\1\uffff\23\7\3\uffff";
    static final String DFA13_maxS =
        "\1\142\1\u0087\1\uffff\23\u0087\3\uffff";
    static final String DFA13_acceptS =
        "\2\uffff\1\1\23\uffff\1\4\1\2\1\3";
    static final String DFA13_specialS =
        "\31\uffff}>";
    static final String[] DFA13_transitionS = {
            "\1\2\1\3\6\uffff\1\3\1\24\1\25\6\uffff\1\3\2\uffff\1\3\1\uffff"+
            "\1\17\5\uffff\1\10\7\uffff\5\3\1\uffff\1\1\2\uffff\1\3\2\uffff"+
            "\1\3\6\uffff\1\3\4\uffff\11\3\1\2\6\uffff\1\26\1\uffff\1\4\1"+
            "\5\1\6\1\7\1\11\1\12\1\13\1\14\1\15\1\16\1\20\1\21\1\22\1\23"+
            "\1\3",
            "\2\2\174\uffff\1\26\2\2",
            "",
            "\2\2\174\uffff\1\26\2\2",
            "\2\2\174\uffff\1\26\2\2",
            "\2\2\174\uffff\1\26\2\2",
            "\2\2\174\uffff\1\26\2\2",
            "\2\2\174\uffff\1\26\2\2",
            "\2\2\174\uffff\1\26\2\2",
            "\2\2\174\uffff\1\26\2\2",
            "\2\2\174\uffff\1\26\2\2",
            "\2\2\174\uffff\1\26\2\2",
            "\2\2\174\uffff\1\26\2\2",
            "\2\2\174\uffff\1\26\2\2",
            "\2\2\174\uffff\1\26\2\2",
            "\2\2\174\uffff\1\26\2\2",
            "\2\2\174\uffff\1\26\2\2",
            "\2\2\174\uffff\1\26\2\2",
            "\2\2\174\uffff\1\26\2\2",
            "\2\2\174\uffff\1\26\2\2",
            "\2\2\174\uffff\1\27\2\2",
            "\2\2\174\uffff\1\30\2\2",
            "",
            "",
            ""
    };

    static final short[] DFA13_eot = DFA.unpackEncodedString(DFA13_eotS);
    static final short[] DFA13_eof = DFA.unpackEncodedString(DFA13_eofS);
    static final char[] DFA13_min = DFA.unpackEncodedStringToUnsignedChars(DFA13_minS);
    static final char[] DFA13_max = DFA.unpackEncodedStringToUnsignedChars(DFA13_maxS);
    static final short[] DFA13_accept = DFA.unpackEncodedString(DFA13_acceptS);
    static final short[] DFA13_special = DFA.unpackEncodedString(DFA13_specialS);
    static final short[][] DFA13_transition;

    static {
        int numStates = DFA13_transitionS.length;
        DFA13_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA13_transition[i] = DFA.unpackEncodedString(DFA13_transitionS[i]);
        }
    }

    class DFA13 extends DFA {

        public DFA13(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 13;
            this.eot = DFA13_eot;
            this.eof = DFA13_eof;
            this.min = DFA13_min;
            this.max = DFA13_max;
            this.accept = DFA13_accept;
            this.special = DFA13_special;
            this.transition = DFA13_transition;
        }
        public String getDescription() {
            return "247:1: unaliasedSelector returns [Selectable s] : (c= cident | K_WRITETIME '(' c= cident ')' | K_TTL '(' c= cident ')' | f= functionName args= selectionFunctionArgs );";
        }
    }
    static final String DFA33_eotS =
        "\27\uffff";
    static final String DFA33_eofS =
        "\27\uffff";
    static final String DFA33_minS =
        "\1\6\24\10\2\uffff";
    static final String DFA33_maxS =
        "\1\142\24\u0089\2\uffff";
    static final String DFA33_acceptS =
        "\25\uffff\1\1\1\2";
    static final String DFA33_specialS =
        "\27\uffff}>";
    static final String[] DFA33_transitionS = {
            "\1\24\1\3\6\uffff\1\3\2\24\6\uffff\1\3\2\uffff\1\3\1\uffff"+
            "\1\17\5\uffff\1\10\7\uffff\5\3\1\uffff\1\1\2\uffff\1\3\2\uffff"+
            "\1\3\6\uffff\1\3\4\uffff\11\3\1\2\10\uffff\1\4\1\5\1\6\1\7\1"+
            "\11\1\12\1\13\1\14\1\15\1\16\1\20\1\21\1\22\1\23\1\3",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "\1\25\176\uffff\1\25\1\uffff\1\26",
            "",
            ""
    };

    static final short[] DFA33_eot = DFA.unpackEncodedString(DFA33_eotS);
    static final short[] DFA33_eof = DFA.unpackEncodedString(DFA33_eofS);
    static final char[] DFA33_min = DFA.unpackEncodedStringToUnsignedChars(DFA33_minS);
    static final char[] DFA33_max = DFA.unpackEncodedStringToUnsignedChars(DFA33_maxS);
    static final short[] DFA33_accept = DFA.unpackEncodedString(DFA33_acceptS);
    static final short[] DFA33_special = DFA.unpackEncodedString(DFA33_specialS);
    static final short[][] DFA33_transition;

    static {
        int numStates = DFA33_transitionS.length;
        DFA33_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA33_transition[i] = DFA.unpackEncodedString(DFA33_transitionS[i]);
        }
    }

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = DFA33_eot;
            this.eof = DFA33_eof;
            this.min = DFA33_min;
            this.max = DFA33_max;
            this.accept = DFA33_accept;
            this.special = DFA33_special;
            this.transition = DFA33_transition;
        }
        public String getDescription() {
            return "378:1: deleteOp returns [Operation.RawDeletion op] : (c= cident | c= cident '[' t= term ']' );";
        }
    }
    static final String DFA75_eotS =
        "\27\uffff";
    static final String DFA75_eofS =
        "\1\uffff\24\25\2\uffff";
    static final String DFA75_minS =
        "\1\6\24\10\2\uffff";
    static final String DFA75_maxS =
        "\1\142\24\u008b\2\uffff";
    static final String DFA75_acceptS =
        "\25\uffff\1\2\1\1";
    static final String DFA75_specialS =
        "\27\uffff}>";
    static final String[] DFA75_transitionS = {
            "\1\24\1\3\6\uffff\1\3\2\24\6\uffff\1\3\2\uffff\1\3\1\uffff"+
            "\1\17\5\uffff\1\10\7\uffff\5\3\1\uffff\1\1\2\uffff\1\3\2\uffff"+
            "\1\3\6\uffff\1\3\4\uffff\11\3\1\2\10\uffff\1\4\1\5\1\6\1\7\1"+
            "\11\1\12\1\13\1\14\1\15\1\16\1\20\1\21\1\22\1\23\1\3",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "\3\25\1\uffff\2\25\15\uffff\1\25\2\uffff\1\25\10\uffff\1\25"+
            "\14\uffff\2\25\1\uffff\3\25\4\uffff\2\25\104\uffff\2\25\5\uffff"+
            "\1\26",
            "",
            ""
    };

    static final short[] DFA75_eot = DFA.unpackEncodedString(DFA75_eotS);
    static final short[] DFA75_eof = DFA.unpackEncodedString(DFA75_eofS);
    static final char[] DFA75_min = DFA.unpackEncodedStringToUnsignedChars(DFA75_minS);
    static final char[] DFA75_max = DFA.unpackEncodedStringToUnsignedChars(DFA75_maxS);
    static final short[] DFA75_accept = DFA.unpackEncodedString(DFA75_acceptS);
    static final short[] DFA75_special = DFA.unpackEncodedString(DFA75_specialS);
    static final short[][] DFA75_transition;

    static {
        int numStates = DFA75_transitionS.length;
        DFA75_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA75_transition[i] = DFA.unpackEncodedString(DFA75_transitionS[i]);
        }
    }

    class DFA75 extends DFA {

        public DFA75(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 75;
            this.eot = DFA75_eot;
            this.eof = DFA75_eof;
            this.min = DFA75_min;
            this.max = DFA75_max;
            this.accept = DFA75_accept;
            this.special = DFA75_special;
            this.transition = DFA75_transition;
        }
        public String getDescription() {
            return "713:7: ( cfOrKsName[name, true] '.' )?";
        }
    }
    static final String DFA93_eotS =
        "\56\uffff";
    static final String DFA93_eofS =
        "\56\uffff";
    static final String DFA93_minS =
        "\1\6\24\u0089\1\6\1\uffff\24\21\3\uffff";
    static final String DFA93_maxS =
        "\1\142\24\u008f\1\u008c\1\uffff\24\u0091\3\uffff";
    static final String DFA93_acceptS =
        "\26\uffff\1\4\24\uffff\1\1\1\2\1\3";
    static final String DFA93_specialS =
        "\56\uffff}>";
    static final String[] DFA93_transitionS = {
            "\1\24\1\3\6\uffff\1\3\2\24\6\uffff\1\3\2\uffff\1\3\1\uffff"+
            "\1\17\5\uffff\1\10\7\uffff\5\3\1\uffff\1\1\2\uffff\1\3\2\uffff"+
            "\1\3\6\uffff\1\3\4\uffff\11\3\1\2\10\uffff\1\4\1\5\1\6\1\7\1"+
            "\11\1\12\1\13\1\14\1\15\1\16\1\20\1\21\1\22\1\23\1\3",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\26\5\uffff\1\25",
            "\1\52\1\31\6\uffff\1\31\2\52\1\53\5\uffff\1\31\2\uffff\1\31"+
            "\1\uffff\1\45\5\uffff\1\36\7\uffff\5\31\1\uffff\1\27\1\uffff"+
            "\1\53\1\31\2\uffff\1\31\6\uffff\1\31\4\uffff\11\31\1\30\7\53"+
            "\1\uffff\1\32\1\33\1\34\1\35\1\37\1\40\1\41\1\42\1\43\1\44\1"+
            "\46\1\47\1\50\1\51\1\31\42\uffff\1\53\3\uffff\1\53\2\uffff\1"+
            "\53",
            "",
            "\1\55\163\uffff\1\53\12\uffff\2\54",
            "\1\55\176\uffff\2\54",
            "\1\55\163\uffff\1\53\12\uffff\2\54",
            "\1\55\163\uffff\1\53\12\uffff\2\54",
            "\1\55\163\uffff\1\53\12\uffff\2\54",
            "\1\55\163\uffff\1\53\12\uffff\2\54",
            "\1\55\163\uffff\1\53\12\uffff\2\54",
            "\1\55\163\uffff\1\53\12\uffff\2\54",
            "\1\55\163\uffff\1\53\12\uffff\2\54",
            "\1\55\163\uffff\1\53\12\uffff\2\54",
            "\1\55\163\uffff\1\53\12\uffff\2\54",
            "\1\55\163\uffff\1\53\12\uffff\2\54",
            "\1\55\163\uffff\1\53\12\uffff\2\54",
            "\1\55\163\uffff\1\53\12\uffff\2\54",
            "\1\55\163\uffff\1\53\12\uffff\2\54",
            "\1\55\163\uffff\1\53\12\uffff\2\54",
            "\1\55\163\uffff\1\53\12\uffff\2\54",
            "\1\55\163\uffff\1\53\12\uffff\2\54",
            "\1\55\163\uffff\1\53\12\uffff\2\54",
            "\1\55\176\uffff\2\54",
            "",
            "",
            ""
    };

    static final short[] DFA93_eot = DFA.unpackEncodedString(DFA93_eotS);
    static final short[] DFA93_eof = DFA.unpackEncodedString(DFA93_eofS);
    static final char[] DFA93_min = DFA.unpackEncodedStringToUnsignedChars(DFA93_minS);
    static final char[] DFA93_max = DFA.unpackEncodedStringToUnsignedChars(DFA93_maxS);
    static final short[] DFA93_accept = DFA.unpackEncodedString(DFA93_acceptS);
    static final short[] DFA93_special = DFA.unpackEncodedString(DFA93_specialS);
    static final short[][] DFA93_transition;

    static {
        int numStates = DFA93_transitionS.length;
        DFA93_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA93_transition[i] = DFA.unpackEncodedString(DFA93_transitionS[i]);
        }
    }

    class DFA93 extends DFA {

        public DFA93(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 93;
            this.eot = DFA93_eot;
            this.eof = DFA93_eof;
            this.min = DFA93_min;
            this.max = DFA93_max;
            this.accept = DFA93_accept;
            this.special = DFA93_special;
            this.transition = DFA93_transition;
        }
        public String getDescription() {
            return "788:1: columnOperation[List<Pair<ColumnIdentifier, Operation.RawUpdate>> operations] : (key= cident '=' t= term ( '+' c= cident )? | key= cident '=' c= cident sig= ( '+' | '-' ) t= term | key= cident '=' c= cident i= INTEGER | key= cident '[' k= term ']' '=' t= term );";
        }
    }
    static final String DFA101_eotS =
        "\30\uffff";
    static final String DFA101_eofS =
        "\30\uffff";
    static final String DFA101_minS =
        "\1\6\24\123\3\uffff";
    static final String DFA101_maxS =
        "\1\142\24\u0095\3\uffff";
    static final String DFA101_acceptS =
        "\25\uffff\1\2\1\1\1\3";
    static final String DFA101_specialS =
        "\30\uffff}>";
    static final String[] DFA101_transitionS = {
            "\1\24\1\3\6\uffff\1\3\2\24\6\uffff\1\3\2\uffff\1\3\1\uffff"+
            "\1\17\5\uffff\1\10\7\uffff\5\3\1\uffff\1\1\2\uffff\1\3\2\uffff"+
            "\1\3\6\uffff\1\3\4\uffff\11\3\1\2\6\uffff\1\25\1\uffff\1\4\1"+
            "\5\1\6\1\7\1\11\1\12\1\13\1\14\1\15\1\16\1\20\1\21\1\22\1\23"+
            "\1\3",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "\1\27\73\uffff\1\26\2\uffff\4\26",
            "",
            "",
            ""
    };

    static final short[] DFA101_eot = DFA.unpackEncodedString(DFA101_eotS);
    static final short[] DFA101_eof = DFA.unpackEncodedString(DFA101_eofS);
    static final char[] DFA101_min = DFA.unpackEncodedStringToUnsignedChars(DFA101_minS);
    static final char[] DFA101_max = DFA.unpackEncodedStringToUnsignedChars(DFA101_maxS);
    static final short[] DFA101_accept = DFA.unpackEncodedString(DFA101_acceptS);
    static final short[] DFA101_special = DFA.unpackEncodedString(DFA101_specialS);
    static final short[][] DFA101_transition;

    static {
        int numStates = DFA101_transitionS.length;
        DFA101_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA101_transition[i] = DFA.unpackEncodedString(DFA101_transitionS[i]);
        }
    }

    class DFA101 extends DFA {

        public DFA101(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 101;
            this.eot = DFA101_eot;
            this.eof = DFA101_eof;
            this.min = DFA101_min;
            this.max = DFA101_max;
            this.accept = DFA101_accept;
            this.special = DFA101_special;
            this.transition = DFA101_transition;
        }
        public String getDescription() {
            return "844:1: relation[List<Relation> clauses] : (name= cident type= relationType t= term | K_TOKEN '(' name1= cident ( ',' namen= cident )* ')' type= relationType t= term | name= cident K_IN '(' (f1= term ( ',' fN= term )* )? ')' );";
        }
    }
 

    public static final BitSet FOLLOW_cqlStatement_in_query72 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_132_in_query75 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_EOF_in_query79 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selectStatement_in_cqlStatement113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insertStatement_in_cqlStatement138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateStatement_in_cqlStatement163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_batchStatement_in_cqlStatement188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_cqlStatement214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_useStatement_in_cqlStatement239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_truncateStatement_in_cqlStatement267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createKeyspaceStatement_in_cqlStatement290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createTableStatement_in_cqlStatement307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createIndexStatement_in_cqlStatement326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropKeyspaceStatement_in_cqlStatement345 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropTableStatement_in_cqlStatement363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropIndexStatement_in_cqlStatement384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alterTableStatement_in_cqlStatement405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alterKeyspaceStatement_in_cqlStatement425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_grantStatement_in_cqlStatement442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_revokeStatement_in_cqlStatement467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listPermissionsStatement_in_cqlStatement491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createUserStatement_in_cqlStatement506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_alterUserStatement_in_cqlStatement526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropUserStatement_in_cqlStatement547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_listUsersStatement_in_cqlStatement569 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_createTriggerStatement_in_cqlStatement590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dropTriggerStatement_in_cqlStatement607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_USE_in_useStatement639 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_keyspaceName_in_useStatement643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_SELECT_in_selectStatement677 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF40FFCL,0x0000000000000100L});
    public static final BitSet FOLLOW_selectClause_in_selectStatement683 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_K_COUNT_in_selectStatement703 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_133_in_selectStatement705 = new BitSet(new long[]{0x0000000000020000L,0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_selectCountClause_in_selectStatement709 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_134_in_selectStatement711 = new BitSet(new long[]{0x0000000000000180L});
    public static final BitSet FOLLOW_K_AS_in_selectStatement716 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_selectStatement720 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_K_FROM_in_selectStatement735 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_columnFamilyName_in_selectStatement739 = new BitSet(new long[]{0x0000000000003602L});
    public static final BitSet FOLLOW_K_WHERE_in_selectStatement749 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF40FFCL});
    public static final BitSet FOLLOW_whereClause_in_selectStatement753 = new BitSet(new long[]{0x0000000000003402L});
    public static final BitSet FOLLOW_K_ORDER_in_selectStatement766 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_K_BY_in_selectStatement768 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_orderByClause_in_selectStatement770 = new BitSet(new long[]{0x0000000000003002L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_135_in_selectStatement775 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_orderByClause_in_selectStatement777 = new BitSet(new long[]{0x0000000000003002L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_K_LIMIT_in_selectStatement794 = new BitSet(new long[]{0x0000000000022000L,0x0000000000020000L});
    public static final BitSet FOLLOW_intValue_in_selectStatement798 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_K_ALLOW_in_selectStatement813 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_K_FILTERING_in_selectStatement815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_selector_in_selectClause852 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_135_in_selectClause857 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF40FFCL});
    public static final BitSet FOLLOW_selector_in_selectClause861 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_136_in_selectClause873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unaliasedSelector_in_selector906 = new BitSet(new long[]{0x0000000000000082L});
    public static final BitSet FOLLOW_K_AS_in_selector909 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_selector913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_unaliasedSelector942 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_WRITETIME_in_unaliasedSelector985 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_133_in_unaliasedSelector987 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_unaliasedSelector991 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_134_in_unaliasedSelector993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TTL_in_unaliasedSelector1016 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_133_in_unaliasedSelector1024 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_unaliasedSelector1028 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_134_in_unaliasedSelector1030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionName_in_unaliasedSelector1055 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_selectionFunctionArgs_in_unaliasedSelector1059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_selectionFunctionArgs1082 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_134_in_selectionFunctionArgs1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_selectionFunctionArgs1094 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF40FFCL});
    public static final BitSet FOLLOW_unaliasedSelector_in_selectionFunctionArgs1098 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_135_in_selectionFunctionArgs1114 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF40FFCL});
    public static final BitSet FOLLOW_unaliasedSelector_in_selectionFunctionArgs1118 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_134_in_selectionFunctionArgs1132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_136_in_selectCountClause1155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_selectCountClause1177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_relation_in_whereClause1213 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_K_AND_in_whereClause1217 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF40FFCL});
    public static final BitSet FOLLOW_relation_in_whereClause1219 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_cident_in_orderByClause1250 = new BitSet(new long[]{0x0000000000180002L});
    public static final BitSet FOLLOW_K_ASC_in_orderByClause1255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DESC_in_orderByClause1259 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_INSERT_in_insertStatement1297 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_K_INTO_in_insertStatement1299 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_columnFamilyName_in_insertStatement1303 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_133_in_insertStatement1315 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_insertStatement1319 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_135_in_insertStatement1326 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_insertStatement1330 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_134_in_insertStatement1337 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_K_VALUES_in_insertStatement1347 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_133_in_insertStatement1359 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_insertStatement1363 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_135_in_insertStatement1369 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_insertStatement1373 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_134_in_insertStatement1380 = new BitSet(new long[]{0x0000000009000002L});
    public static final BitSet FOLLOW_K_IF_in_insertStatement1393 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_K_NOT_in_insertStatement1395 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_K_EXISTS_in_insertStatement1397 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_usingClause_in_insertStatement1414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_USING_in_usingClause1444 = new BitSet(new long[]{0x0000000010010000L});
    public static final BitSet FOLLOW_usingClauseObjective_in_usingClause1446 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_K_AND_in_usingClause1451 = new BitSet(new long[]{0x0000000010010000L});
    public static final BitSet FOLLOW_usingClauseObjective_in_usingClause1453 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_K_TIMESTAMP_in_usingClauseObjective1475 = new BitSet(new long[]{0x0000000000020000L,0x0000000000020000L});
    public static final BitSet FOLLOW_intValue_in_usingClauseObjective1479 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TTL_in_usingClauseObjective1489 = new BitSet(new long[]{0x0000000000020000L,0x0000000000020000L});
    public static final BitSet FOLLOW_intValue_in_usingClauseObjective1493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_UPDATE_in_updateStatement1527 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_columnFamilyName_in_updateStatement1531 = new BitSet(new long[]{0x0000000048000000L});
    public static final BitSet FOLLOW_usingClause_in_updateStatement1541 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_K_SET_in_updateStatement1553 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_columnOperation_in_updateStatement1555 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_135_in_updateStatement1559 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_columnOperation_in_updateStatement1561 = new BitSet(new long[]{0x0000000000000200L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_K_WHERE_in_updateStatement1572 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF40FFCL});
    public static final BitSet FOLLOW_whereClause_in_updateStatement1576 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_K_IF_in_updateStatement1586 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_updateCondition_in_updateStatement1590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_columnOperation_in_updateCondition1631 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_K_AND_in_updateCondition1636 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_columnOperation_in_updateCondition1638 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_K_DELETE_in_deleteStatement1674 = new BitSet(new long[]{0x20497C041481C1C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_deleteSelection_in_deleteStatement1680 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_K_FROM_in_deleteStatement1693 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_columnFamilyName_in_deleteStatement1697 = new BitSet(new long[]{0x0000000008000200L});
    public static final BitSet FOLLOW_usingClauseDelete_in_deleteStatement1707 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_K_WHERE_in_deleteStatement1719 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF40FFCL});
    public static final BitSet FOLLOW_whereClause_in_deleteStatement1723 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_K_IF_in_deleteStatement1733 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_updateCondition_in_deleteStatement1737 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteOp_in_deleteSelection1783 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_135_in_deleteSelection1798 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_deleteOp_in_deleteSelection1802 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_cident_in_deleteOp1829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_deleteOp1856 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_137_in_deleteOp1858 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_deleteOp1862 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_138_in_deleteOp1864 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_USING_in_usingClauseDelete1884 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_K_TIMESTAMP_in_usingClauseDelete1886 = new BitSet(new long[]{0x0000000000020000L,0x0000000000020000L});
    public static final BitSet FOLLOW_intValue_in_usingClauseDelete1890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_BEGIN_in_batchStatement1924 = new BitSet(new long[]{0x0000000E00000000L});
    public static final BitSet FOLLOW_K_UNLOGGED_in_batchStatement1934 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_K_COUNTER_in_batchStatement1940 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_K_BATCH_in_batchStatement1953 = new BitSet(new long[]{0x00000000A8200000L});
    public static final BitSet FOLLOW_usingClause_in_batchStatement1957 = new BitSet(new long[]{0x00000000A8200000L});
    public static final BitSet FOLLOW_batchStatementObjective_in_batchStatement1977 = new BitSet(new long[]{0x00000010A8200000L,0x0000000000000000L,0x0000000000000010L});
    public static final BitSet FOLLOW_132_in_batchStatement1979 = new BitSet(new long[]{0x00000010A8200000L});
    public static final BitSet FOLLOW_K_APPLY_in_batchStatement1993 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_K_BATCH_in_batchStatement1995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_insertStatement_in_batchStatementObjective2026 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_updateStatement_in_batchStatementObjective2039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_deleteStatement_in_batchStatementObjective2052 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CREATE_in_createKeyspaceStatement2087 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_K_KEYSPACE_in_createKeyspaceStatement2089 = new BitSet(new long[]{0x20497C041581C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_K_IF_in_createKeyspaceStatement2092 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_K_NOT_in_createKeyspaceStatement2094 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_K_EXISTS_in_createKeyspaceStatement2096 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_keyspaceName_in_createKeyspaceStatement2105 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_K_WITH_in_createKeyspaceStatement2113 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_properties_in_createKeyspaceStatement2115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CREATE_in_createTableStatement2150 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_K_COLUMNFAMILY_in_createTableStatement2152 = new BitSet(new long[]{0x20497C041581C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_K_IF_in_createTableStatement2155 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_K_NOT_in_createTableStatement2157 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_K_EXISTS_in_createTableStatement2159 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_columnFamilyName_in_createTableStatement2174 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_cfamDefinition_in_createTableStatement2184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_cfamDefinition2203 = new BitSet(new long[]{0x20497E041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cfamColumns_in_cfamDefinition2205 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_135_in_cfamDefinition2210 = new BitSet(new long[]{0x20497E041481C0C0L,0x00000007FFF00FFCL,0x00000000000000C0L});
    public static final BitSet FOLLOW_cfamColumns_in_cfamDefinition2212 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_134_in_cfamDefinition2219 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_K_WITH_in_cfamDefinition2229 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cfamProperty_in_cfamDefinition2231 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_K_AND_in_cfamDefinition2236 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cfamProperty_in_cfamDefinition2238 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_cident_in_cfamColumns2264 = new BitSet(new long[]{0x204C7C0454804080L,0x00000007FFF007FCL});
    public static final BitSet FOLLOW_comparatorType_in_cfamColumns2268 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_K_PRIMARY_in_cfamColumns2273 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_K_KEY_in_cfamColumns2275 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_PRIMARY_in_cfamColumns2287 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_K_KEY_in_cfamColumns2289 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_133_in_cfamColumns2291 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL,0x0000000000000020L});
    public static final BitSet FOLLOW_pkDef_in_cfamColumns2293 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_135_in_cfamColumns2297 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_cfamColumns2301 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_134_in_cfamColumns2308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_pkDef2328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_pkDef2338 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_pkDef2344 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_135_in_pkDef2350 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_pkDef2354 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_134_in_pkDef2361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_property_in_cfamProperty2381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_COMPACT_in_cfamProperty2390 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_K_STORAGE_in_cfamProperty2392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CLUSTERING_in_cfamProperty2402 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_K_ORDER_in_cfamProperty2404 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_K_BY_in_cfamProperty2406 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_133_in_cfamProperty2408 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cfamOrdering_in_cfamProperty2410 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_135_in_cfamProperty2414 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cfamOrdering_in_cfamProperty2416 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_134_in_cfamProperty2421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_cfamOrdering2449 = new BitSet(new long[]{0x0000000000180000L});
    public static final BitSet FOLLOW_K_ASC_in_cfamOrdering2452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DESC_in_cfamOrdering2456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CREATE_in_createIndexStatement2494 = new BitSet(new long[]{0x0000C00000000000L});
    public static final BitSet FOLLOW_K_CUSTOM_in_createIndexStatement2497 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_K_INDEX_in_createIndexStatement2503 = new BitSet(new long[]{0x0003000001000000L});
    public static final BitSet FOLLOW_K_IF_in_createIndexStatement2506 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_K_NOT_in_createIndexStatement2508 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_K_EXISTS_in_createIndexStatement2510 = new BitSet(new long[]{0x0003000000000000L});
    public static final BitSet FOLLOW_IDENT_in_createIndexStatement2528 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_K_ON_in_createIndexStatement2532 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_columnFamilyName_in_createIndexStatement2536 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_133_in_createIndexStatement2538 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_createIndexStatement2542 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_134_in_createIndexStatement2544 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_K_USING_in_createIndexStatement2556 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_createIndexStatement2560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CREATE_in_createTriggerStatement2594 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_K_TRIGGER_in_createTriggerStatement2596 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_IDENT_in_createTriggerStatement2601 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_K_ON_in_createTriggerStatement2604 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_columnFamilyName_in_createTriggerStatement2608 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_K_USING_in_createTriggerStatement2610 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_createTriggerStatement2614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DROP_in_dropTriggerStatement2645 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_K_TRIGGER_in_dropTriggerStatement2647 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_IDENT_in_dropTriggerStatement2652 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_K_ON_in_dropTriggerStatement2655 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_columnFamilyName_in_dropTriggerStatement2659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ALTER_in_alterKeyspaceStatement2699 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_K_KEYSPACE_in_alterKeyspaceStatement2701 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_keyspaceName_in_alterKeyspaceStatement2705 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_K_WITH_in_alterKeyspaceStatement2715 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_properties_in_alterKeyspaceStatement2717 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ALTER_in_alterTableStatement2753 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_K_COLUMNFAMILY_in_alterTableStatement2755 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_columnFamilyName_in_alterTableStatement2759 = new BitSet(new long[]{0x01B0008000000000L});
    public static final BitSet FOLLOW_K_ALTER_in_alterTableStatement2773 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_alterTableStatement2777 = new BitSet(new long[]{0x0040000000000000L});
    public static final BitSet FOLLOW_K_TYPE_in_alterTableStatement2779 = new BitSet(new long[]{0x204C7C0454804080L,0x00000007FFF007FCL});
    public static final BitSet FOLLOW_comparatorType_in_alterTableStatement2783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ADD_in_alterTableStatement2799 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_alterTableStatement2805 = new BitSet(new long[]{0x204C7C0454804080L,0x00000007FFF007FCL});
    public static final BitSet FOLLOW_comparatorType_in_alterTableStatement2809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DROP_in_alterTableStatement2832 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_alterTableStatement2837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_WITH_in_alterTableStatement2877 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_properties_in_alterTableStatement2880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_RENAME_in_alterTableStatement2913 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_alterTableStatement2967 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_K_TO_in_alterTableStatement2969 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_alterTableStatement2973 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_K_AND_in_alterTableStatement2994 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_alterTableStatement2998 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_K_TO_in_alterTableStatement3000 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_alterTableStatement3004 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_K_DROP_in_dropKeyspaceStatement3059 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_K_KEYSPACE_in_dropKeyspaceStatement3061 = new BitSet(new long[]{0x20497C041581C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_K_IF_in_dropKeyspaceStatement3064 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_K_EXISTS_in_dropKeyspaceStatement3066 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_keyspaceName_in_dropKeyspaceStatement3075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DROP_in_dropTableStatement3109 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_K_COLUMNFAMILY_in_dropTableStatement3111 = new BitSet(new long[]{0x20497C041581C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_K_IF_in_dropTableStatement3114 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_K_EXISTS_in_dropTableStatement3116 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_columnFamilyName_in_dropTableStatement3125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DROP_in_dropIndexStatement3159 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_K_INDEX_in_dropIndexStatement3161 = new BitSet(new long[]{0x0001000001000000L});
    public static final BitSet FOLLOW_K_IF_in_dropIndexStatement3164 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_K_EXISTS_in_dropIndexStatement3166 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_IDENT_in_dropIndexStatement3175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TRUNCATE_in_truncateStatement3206 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_columnFamilyName_in_truncateStatement3210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_GRANT_in_grantStatement3235 = new BitSet(new long[]{0x0030002000000020L,0x0000000000000007L});
    public static final BitSet FOLLOW_permissionOrAll_in_grantStatement3247 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_K_ON_in_grantStatement3255 = new BitSet(new long[]{0x20497D441481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_resource_in_grantStatement3267 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_K_TO_in_grantStatement3275 = new BitSet(new long[]{0x0005000000000000L});
    public static final BitSet FOLLOW_username_in_grantStatement3287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_REVOKE_in_revokeStatement3318 = new BitSet(new long[]{0x0030002000000020L,0x0000000000000007L});
    public static final BitSet FOLLOW_permissionOrAll_in_revokeStatement3330 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_K_ON_in_revokeStatement3338 = new BitSet(new long[]{0x20497D441481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_resource_in_revokeStatement3350 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_K_FROM_in_revokeStatement3358 = new BitSet(new long[]{0x0005000000000000L});
    public static final BitSet FOLLOW_username_in_revokeStatement3370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_LIST_in_listPermissionsStatement3408 = new BitSet(new long[]{0x0030002000000020L,0x0000000000000007L});
    public static final BitSet FOLLOW_permissionOrAll_in_listPermissionsStatement3420 = new BitSet(new long[]{0xC002000000000002L});
    public static final BitSet FOLLOW_K_ON_in_listPermissionsStatement3430 = new BitSet(new long[]{0x20497D441481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_resource_in_listPermissionsStatement3432 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_K_OF_in_listPermissionsStatement3447 = new BitSet(new long[]{0x0005000000000000L});
    public static final BitSet FOLLOW_username_in_listPermissionsStatement3449 = new BitSet(new long[]{0x8000000000000002L});
    public static final BitSet FOLLOW_K_NORECURSIVE_in_listPermissionsStatement3464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_permission3500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ALL_in_permissionOrAll3549 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000008L});
    public static final BitSet FOLLOW_K_PERMISSIONS_in_permissionOrAll3553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_permission_in_permissionOrAll3574 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000010L});
    public static final BitSet FOLLOW_K_PERMISSION_in_permissionOrAll3578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_dataResource_in_resource3606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ALL_in_dataResource3629 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_K_KEYSPACES_in_dataResource3631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_KEYSPACE_in_dataResource3641 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_keyspaceName_in_dataResource3647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_COLUMNFAMILY_in_dataResource3659 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_columnFamilyName_in_dataResource3668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_CREATE_in_createUserStatement3708 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_K_USER_in_createUserStatement3710 = new BitSet(new long[]{0x0005000000000000L});
    public static final BitSet FOLLOW_username_in_createUserStatement3712 = new BitSet(new long[]{0x0000008000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_K_WITH_in_createUserStatement3722 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_userOptions_in_createUserStatement3724 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_K_SUPERUSER_in_createUserStatement3738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_NOSUPERUSER_in_createUserStatement3744 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ALTER_in_alterUserStatement3789 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_K_USER_in_alterUserStatement3791 = new BitSet(new long[]{0x0005000000000000L});
    public static final BitSet FOLLOW_username_in_alterUserStatement3793 = new BitSet(new long[]{0x0000008000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_K_WITH_in_alterUserStatement3803 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_userOptions_in_alterUserStatement3805 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000180L});
    public static final BitSet FOLLOW_K_SUPERUSER_in_alterUserStatement3819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_NOSUPERUSER_in_alterUserStatement3825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DROP_in_dropUserStatement3861 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_K_USER_in_dropUserStatement3863 = new BitSet(new long[]{0x0005000000000000L});
    public static final BitSet FOLLOW_username_in_dropUserStatement3865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_LIST_in_listUsersStatement3890 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_K_USERS_in_listUsersStatement3892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_userOption_in_userOptions3912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_PASSWORD_in_userOption3933 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_userOption3937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_cident3966 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_NAME_in_cident3991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unreserved_keyword_in_cident4010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cfOrKsName_in_keyspaceName4043 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cfOrKsName_in_columnFamilyName4077 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_139_in_columnFamilyName4080 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cfOrKsName_in_columnFamilyName4084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_cfOrKsName4105 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QUOTED_NAME_in_cfOrKsName4130 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unreserved_keyword_in_cfOrKsName4149 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_constant4174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_constant4186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_constant4205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BOOLEAN_in_constant4226 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_UUID_in_constant4245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEXNUMBER_in_constant4267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_140_in_map_literal4295 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000005220L});
    public static final BitSet FOLLOW_term_in_map_literal4313 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_141_in_map_literal4315 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_map_literal4319 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000004080L});
    public static final BitSet FOLLOW_135_in_map_literal4325 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_map_literal4329 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_141_in_map_literal4331 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_map_literal4335 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000004080L});
    public static final BitSet FOLLOW_142_in_map_literal4351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_141_in_set_or_map4375 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_set_or_map4379 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_135_in_set_or_map4395 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_set_or_map4399 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_141_in_set_or_map4401 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_set_or_map4405 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_135_in_set_or_map4440 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_set_or_map4444 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_137_in_collection_literal4478 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001620L});
    public static final BitSet FOLLOW_term_in_collection_literal4496 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000480L});
    public static final BitSet FOLLOW_135_in_collection_literal4502 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_collection_literal4506 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000480L});
    public static final BitSet FOLLOW_138_in_collection_literal4522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_140_in_collection_literal4532 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_collection_literal4536 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000006080L});
    public static final BitSet FOLLOW_set_or_map_in_collection_literal4540 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_142_in_collection_literal4545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_140_in_collection_literal4563 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_142_in_collection_literal4565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_value4590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collection_literal_in_value4612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_NULL_in_value4622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QMARK_in_value4646 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_intValue4692 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_QMARK_in_intValue4702 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_functionName4731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unreserved_function_keyword_in_functionName4765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TOKEN_in_functionName4775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_functionArgs4820 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_134_in_functionArgs4822 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_functionArgs4832 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_functionArgs4836 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_135_in_functionArgs4852 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_functionArgs4856 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_134_in_functionArgs4870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_value_in_term4895 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_functionName_in_term4932 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_functionArgs_in_term4936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_133_in_term4946 = new BitSet(new long[]{0x204C7C0454804080L,0x00000007FFF007FCL});
    public static final BitSet FOLLOW_comparatorType_in_term4950 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000040L});
    public static final BitSet FOLLOW_134_in_term4952 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_term4956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_columnOperation4979 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_143_in_columnOperation4981 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_columnOperation4985 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_144_in_columnOperation4988 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_columnOperation4992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_columnOperation5013 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_143_in_columnOperation5015 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_columnOperation5019 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000030000L});
    public static final BitSet FOLLOW_set_in_columnOperation5023 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_columnOperation5033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_columnOperation5051 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_143_in_columnOperation5053 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_columnOperation5057 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_INTEGER_in_columnOperation5061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_columnOperation5079 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_137_in_columnOperation5081 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_columnOperation5085 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000400L});
    public static final BitSet FOLLOW_138_in_columnOperation5087 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_143_in_columnOperation5089 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_columnOperation5093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_property_in_properties5119 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_K_AND_in_properties5123 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_property_in_properties5125 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_cident_in_property5148 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000008000L});
    public static final BitSet FOLLOW_143_in_property5150 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF0FFFCL,0x0000000000001000L});
    public static final BitSet FOLLOW_propertyValue_in_property5155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_map_literal_in_property5184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_constant_in_propertyValue5212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unreserved_keyword_in_propertyValue5234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_143_in_relationType5257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_146_in_relationType5268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_147_in_relationType5279 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_148_in_relationType5289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_149_in_relationType5300 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_relation5322 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000003C8000L});
    public static final BitSet FOLLOW_relationType_in_relation5326 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_relation5330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TOKEN_in_relation5340 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_133_in_relation5363 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_relation5367 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_135_in_relation5373 = new BitSet(new long[]{0x20497C041481C0C0L,0x00000007FFF00FFCL});
    public static final BitSet FOLLOW_cident_in_relation5377 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_134_in_relation5383 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000003C8000L});
    public static final BitSet FOLLOW_relationType_in_relation5395 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_relation5399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_cident_in_relation5419 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_K_IN_in_relation5421 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000020L});
    public static final BitSet FOLLOW_133_in_relation5432 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001260L});
    public static final BitSet FOLLOW_term_in_relation5438 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_135_in_relation5443 = new BitSet(new long[]{0x204D7C041483C0C0L,0x00000007FFF7FFFCL,0x0000000000001220L});
    public static final BitSet FOLLOW_term_in_relation5447 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x00000000000000C0L});
    public static final BitSet FOLLOW_134_in_relation5457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_native_type_in_comparatorType5482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_collection_type_in_comparatorType5498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_comparatorType5510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_ASCII_in_native_type5539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_BIGINT_in_native_type5553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_BLOB_in_native_type5566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_BOOLEAN_in_native_type5581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_COUNTER_in_native_type5593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DECIMAL_in_native_type5605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_DOUBLE_in_native_type5617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_FLOAT_in_native_type5630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_INET_in_native_type5644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_INT_in_native_type5659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TEXT_in_native_type5675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TIMESTAMP_in_native_type5690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_UUID_in_native_type5700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_VARCHAR_in_native_type5715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_VARINT_in_native_type5727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_TIMEUUID_in_native_type5740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_MAP_in_collection_type5764 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_146_in_collection_type5767 = new BitSet(new long[]{0x204C7C0454804080L,0x00000007FFF007FCL});
    public static final BitSet FOLLOW_comparatorType_in_collection_type5771 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000000080L});
    public static final BitSet FOLLOW_135_in_collection_type5773 = new BitSet(new long[]{0x204C7C0454804080L,0x00000007FFF007FCL});
    public static final BitSet FOLLOW_comparatorType_in_collection_type5777 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_148_in_collection_type5779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_LIST_in_collection_type5797 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_146_in_collection_type5799 = new BitSet(new long[]{0x204C7C0454804080L,0x00000007FFF007FCL});
    public static final BitSet FOLLOW_comparatorType_in_collection_type5803 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_148_in_collection_type5805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_K_SET_in_collection_type5823 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000040000L});
    public static final BitSet FOLLOW_146_in_collection_type5826 = new BitSet(new long[]{0x204C7C0454804080L,0x00000007FFF007FCL});
    public static final BitSet FOLLOW_comparatorType_in_collection_type5830 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000000L,0x0000000000100000L});
    public static final BitSet FOLLOW_148_in_collection_type5832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_username0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_unreserved_function_keyword_in_unreserved_keyword5890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_unreserved_keyword5906 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_unreserved_function_keyword5941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_native_type_in_unreserved_function_keyword6217 = new BitSet(new long[]{0x0000000000000002L});

}