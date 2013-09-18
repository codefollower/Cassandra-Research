// $ANTLR 3.2 Sep 23, 2009 12:02:23 E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g 2013-09-08 20:26:12

    package org.apache.cassandra.cql;
    import org.apache.cassandra.exceptions.SyntaxException;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class CqlLexer extends Lexer {
    public static final int LETTER=76;
    public static final int K_CREATE=32;
    public static final int EOF=-1;
    public static final int K_PRIMARY=37;
    public static final int T__93=93;
    public static final int T__94=94;
    public static final int T__91=91;
    public static final int K_USE=4;
    public static final int T__92=92;
    public static final int K_VALUES=23;
    public static final int STRING_LITERAL=7;
    public static final int T__90=90;
    public static final int K_ON=41;
    public static final int K_USING=11;
    public static final int K_ADD=45;
    public static final int K_KEY=38;
    public static final int K_TRUNCATE=48;
    public static final int COMMENT=79;
    public static final int T__99=99;
    public static final int T__98=98;
    public static final int T__97=97;
    public static final int T__96=96;
    public static final int T__95=95;
    public static final int D=62;
    public static final int E=50;
    public static final int F=54;
    public static final int G=68;
    public static final int K_TYPE=44;
    public static final int K_KEYSPACE=33;
    public static final int K_COUNT=9;
    public static final int A=60;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int B=71;
    public static final int C=52;
    public static final int T__83=83;
    public static final int L=51;
    public static final int M=57;
    public static final int N=61;
    public static final int O=56;
    public static final int H=59;
    public static final int I=65;
    public static final int J=73;
    public static final int K_UPDATE=29;
    public static final int K=63;
    public static final int U=66;
    public static final int T=53;
    public static final int W=58;
    public static final int V=70;
    public static final int Q=69;
    public static final int P=67;
    public static final int S=49;
    public static final int R=55;
    public static final int T__85=85;
    public static final int T__84=84;
    public static final int T__87=87;
    public static final int T__86=86;
    public static final int K_TTL=25;
    public static final int T__89=89;
    public static final int Y=64;
    public static final int X=72;
    public static final int T__88=88;
    public static final int Z=74;
    public static final int K_INDEX=40;
    public static final int K_REVERSED=17;
    public static final int K_INSERT=21;
    public static final int WS=78;
    public static final int K_APPLY=28;
    public static final int K_TIMESTAMP=24;
    public static final int K_AND=19;
    public static final int QMARK=47;
    public static final int K_LEVEL=13;
    public static final int K_BATCH=27;
    public static final int UUID=46;
    public static final int K_DELETE=31;
    public static final int FLOAT=39;
    public static final int K_SELECT=8;
    public static final int K_LIMIT=15;
    public static final int K_ALTER=43;
    public static final int K_SET=30;
    public static final int K_WHERE=14;
    public static final int MULTILINE_COMMENT=80;
    public static final int T__107=107;
    public static final int HEX=77;
    public static final int K_INTO=22;
    public static final int T__103=103;
    public static final int T__104=104;
    public static final int T__105=105;
    public static final int T__106=106;
    public static final int IDENT=5;
    public static final int DIGIT=75;
    public static final int K_FIRST=16;
    public static final int K_BEGIN=26;
    public static final int INTEGER=6;
    public static final int RANGEOP=18;
    public static final int K_CONSISTENCY=12;
    public static final int COMPIDENT=35;
    public static final int K_WITH=34;
    public static final int T__102=102;
    public static final int T__101=101;
    public static final int K_IN=20;
    public static final int T__100=100;
    public static final int K_FROM=10;
    public static final int K_COLUMNFAMILY=36;
    public static final int K_DROP=42;

        List<Token> tokens = new ArrayList<Token>();
        
        public void emit(Token token) {
            state.token = token;
            tokens.add(token);
        }
        
        public Token nextToken() {
            super.nextToken();
            if (tokens.size() == 0)
                return Token.EOF_TOKEN;
            return tokens.remove(0);
        }
        
        private List<String> recognitionErrors = new ArrayList<String>();
        
        public void displayRecognitionError(String[] tokenNames, RecognitionException e)
        {
            String hdr = getErrorHeader(e);
            String msg = getErrorMessage(e, tokenNames);
            recognitionErrors.add(hdr + " " + msg);
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


    // delegates
    // delegators

    public CqlLexer() {;} 
    public CqlLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public CqlLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g"; }

    // $ANTLR start "T__81"
    public final void mT__81() throws RecognitionException {
        try {
            int _type = T__81;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:47:7: ( '(' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:47:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__81"

    // $ANTLR start "T__82"
    public final void mT__82() throws RecognitionException {
        try {
            int _type = T__82;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:48:7: ( ')' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:48:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__82"

    // $ANTLR start "T__83"
    public final void mT__83() throws RecognitionException {
        try {
            int _type = T__83;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:49:7: ( '.' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:49:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__83"

    // $ANTLR start "T__84"
    public final void mT__84() throws RecognitionException {
        try {
            int _type = T__84;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:50:7: ( ',' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:50:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__84"

    // $ANTLR start "T__85"
    public final void mT__85() throws RecognitionException {
        try {
            int _type = T__85;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:51:7: ( '\\*' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:51:9: '\\*'
            {
            match('*'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__85"

    // $ANTLR start "T__86"
    public final void mT__86() throws RecognitionException {
        try {
            int _type = T__86;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:52:7: ( ';' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:52:9: ';'
            {
            match(';'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__86"

    // $ANTLR start "T__87"
    public final void mT__87() throws RecognitionException {
        try {
            int _type = T__87;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:53:7: ( '=' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:53:9: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__87"

    // $ANTLR start "T__88"
    public final void mT__88() throws RecognitionException {
        try {
            int _type = T__88;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:54:7: ( 'blob' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:54:9: 'blob'
            {
            match("blob"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__88"

    // $ANTLR start "T__89"
    public final void mT__89() throws RecognitionException {
        try {
            int _type = T__89;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:55:7: ( 'ascii' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:55:9: 'ascii'
            {
            match("ascii"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__89"

    // $ANTLR start "T__90"
    public final void mT__90() throws RecognitionException {
        try {
            int _type = T__90;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:56:7: ( 'text' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:56:9: 'text'
            {
            match("text"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__90"

    // $ANTLR start "T__91"
    public final void mT__91() throws RecognitionException {
        try {
            int _type = T__91;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:57:7: ( 'varchar' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:57:9: 'varchar'
            {
            match("varchar"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__91"

    // $ANTLR start "T__92"
    public final void mT__92() throws RecognitionException {
        try {
            int _type = T__92;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:58:7: ( 'int' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:58:9: 'int'
            {
            match("int"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__92"

    // $ANTLR start "T__93"
    public final void mT__93() throws RecognitionException {
        try {
            int _type = T__93;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:59:7: ( 'varint' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:59:9: 'varint'
            {
            match("varint"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__93"

    // $ANTLR start "T__94"
    public final void mT__94() throws RecognitionException {
        try {
            int _type = T__94;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:60:7: ( 'bigint' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:60:9: 'bigint'
            {
            match("bigint"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__94"

    // $ANTLR start "T__95"
    public final void mT__95() throws RecognitionException {
        try {
            int _type = T__95;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:61:7: ( 'uuid' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:61:9: 'uuid'
            {
            match("uuid"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__95"

    // $ANTLR start "T__96"
    public final void mT__96() throws RecognitionException {
        try {
            int _type = T__96;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:62:7: ( 'counter' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:62:9: 'counter'
            {
            match("counter"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__96"

    // $ANTLR start "T__97"
    public final void mT__97() throws RecognitionException {
        try {
            int _type = T__97;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:63:7: ( 'boolean' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:63:9: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__97"

    // $ANTLR start "T__98"
    public final void mT__98() throws RecognitionException {
        try {
            int _type = T__98;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:64:7: ( 'timestamp' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:64:9: 'timestamp'
            {
            match("timestamp"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__98"

    // $ANTLR start "T__99"
    public final void mT__99() throws RecognitionException {
        try {
            int _type = T__99;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:65:7: ( 'float' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:65:9: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__99"

    // $ANTLR start "T__100"
    public final void mT__100() throws RecognitionException {
        try {
            int _type = T__100;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:66:8: ( 'double' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:66:10: 'double'
            {
            match("double"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__100"

    // $ANTLR start "T__101"
    public final void mT__101() throws RecognitionException {
        try {
            int _type = T__101;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:67:8: ( 'decimal' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:67:10: 'decimal'
            {
            match("decimal"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__101"

    // $ANTLR start "T__102"
    public final void mT__102() throws RecognitionException {
        try {
            int _type = T__102;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:68:8: ( '+' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:68:10: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__102"

    // $ANTLR start "T__103"
    public final void mT__103() throws RecognitionException {
        try {
            int _type = T__103;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:69:8: ( '-' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:69:10: '-'
            {
            match('-'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__103"

    // $ANTLR start "T__104"
    public final void mT__104() throws RecognitionException {
        try {
            int _type = T__104;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:70:8: ( '<' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:70:10: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__104"

    // $ANTLR start "T__105"
    public final void mT__105() throws RecognitionException {
        try {
            int _type = T__105;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:71:8: ( '<=' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:71:10: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__105"

    // $ANTLR start "T__106"
    public final void mT__106() throws RecognitionException {
        try {
            int _type = T__106;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:72:8: ( '>=' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:72:10: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__106"

    // $ANTLR start "T__107"
    public final void mT__107() throws RecognitionException {
        try {
            int _type = T__107;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:73:8: ( '>' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:73:10: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__107"

    // $ANTLR start "K_SELECT"
    public final void mK_SELECT() throws RecognitionException {
        try {
            int _type = K_SELECT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:504:9: ( S E L E C T )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:504:16: S E L E C T
            {
            mS(); 
            mE(); 
            mL(); 
            mE(); 
            mC(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_SELECT"

    // $ANTLR start "K_FROM"
    public final void mK_FROM() throws RecognitionException {
        try {
            int _type = K_FROM;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:505:7: ( F R O M )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:505:16: F R O M
            {
            mF(); 
            mR(); 
            mO(); 
            mM(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_FROM"

    // $ANTLR start "K_WHERE"
    public final void mK_WHERE() throws RecognitionException {
        try {
            int _type = K_WHERE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:506:8: ( W H E R E )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:506:16: W H E R E
            {
            mW(); 
            mH(); 
            mE(); 
            mR(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_WHERE"

    // $ANTLR start "K_AND"
    public final void mK_AND() throws RecognitionException {
        try {
            int _type = K_AND;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:507:6: ( A N D )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:507:16: A N D
            {
            mA(); 
            mN(); 
            mD(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_AND"

    // $ANTLR start "K_KEY"
    public final void mK_KEY() throws RecognitionException {
        try {
            int _type = K_KEY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:508:6: ( K E Y )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:508:16: K E Y
            {
            mK(); 
            mE(); 
            mY(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_KEY"

    // $ANTLR start "K_INSERT"
    public final void mK_INSERT() throws RecognitionException {
        try {
            int _type = K_INSERT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:509:9: ( I N S E R T )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:509:16: I N S E R T
            {
            mI(); 
            mN(); 
            mS(); 
            mE(); 
            mR(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_INSERT"

    // $ANTLR start "K_UPDATE"
    public final void mK_UPDATE() throws RecognitionException {
        try {
            int _type = K_UPDATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:510:9: ( U P D A T E )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:510:16: U P D A T E
            {
            mU(); 
            mP(); 
            mD(); 
            mA(); 
            mT(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_UPDATE"

    // $ANTLR start "K_WITH"
    public final void mK_WITH() throws RecognitionException {
        try {
            int _type = K_WITH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:511:7: ( W I T H )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:511:16: W I T H
            {
            mW(); 
            mI(); 
            mT(); 
            mH(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_WITH"

    // $ANTLR start "K_LIMIT"
    public final void mK_LIMIT() throws RecognitionException {
        try {
            int _type = K_LIMIT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:512:8: ( L I M I T )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:512:16: L I M I T
            {
            mL(); 
            mI(); 
            mM(); 
            mI(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_LIMIT"

    // $ANTLR start "K_USING"
    public final void mK_USING() throws RecognitionException {
        try {
            int _type = K_USING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:513:8: ( U S I N G )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:513:16: U S I N G
            {
            mU(); 
            mS(); 
            mI(); 
            mN(); 
            mG(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_USING"

    // $ANTLR start "K_CONSISTENCY"
    public final void mK_CONSISTENCY() throws RecognitionException {
        try {
            int _type = K_CONSISTENCY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:514:14: ( C O N S I S T E N C Y )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:514:16: C O N S I S T E N C Y
            {
            mC(); 
            mO(); 
            mN(); 
            mS(); 
            mI(); 
            mS(); 
            mT(); 
            mE(); 
            mN(); 
            mC(); 
            mY(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_CONSISTENCY"

    // $ANTLR start "K_LEVEL"
    public final void mK_LEVEL() throws RecognitionException {
        try {
            int _type = K_LEVEL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:515:8: ( ( O N E | Q U O R U M | A L L | A N Y | L O C A L '_' Q U O R U M | E A C H '_' Q U O R U M | T W O | T H R E E ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:515:16: ( O N E | Q U O R U M | A L L | A N Y | L O C A L '_' Q U O R U M | E A C H '_' Q U O R U M | T W O | T H R E E )
            {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:515:16: ( O N E | Q U O R U M | A L L | A N Y | L O C A L '_' Q U O R U M | E A C H '_' Q U O R U M | T W O | T H R E E )
            int alt1=8;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:515:18: O N E
                    {
                    mO(); 
                    mN(); 
                    mE(); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:516:18: Q U O R U M
                    {
                    mQ(); 
                    mU(); 
                    mO(); 
                    mR(); 
                    mU(); 
                    mM(); 

                    }
                    break;
                case 3 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:517:18: A L L
                    {
                    mA(); 
                    mL(); 
                    mL(); 

                    }
                    break;
                case 4 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:518:18: A N Y
                    {
                    mA(); 
                    mN(); 
                    mY(); 

                    }
                    break;
                case 5 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:519:18: L O C A L '_' Q U O R U M
                    {
                    mL(); 
                    mO(); 
                    mC(); 
                    mA(); 
                    mL(); 
                    match('_'); 
                    mQ(); 
                    mU(); 
                    mO(); 
                    mR(); 
                    mU(); 
                    mM(); 

                    }
                    break;
                case 6 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:520:18: E A C H '_' Q U O R U M
                    {
                    mE(); 
                    mA(); 
                    mC(); 
                    mH(); 
                    match('_'); 
                    mQ(); 
                    mU(); 
                    mO(); 
                    mR(); 
                    mU(); 
                    mM(); 

                    }
                    break;
                case 7 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:521:18: T W O
                    {
                    mT(); 
                    mW(); 
                    mO(); 

                    }
                    break;
                case 8 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:522:18: T H R E E
                    {
                    mT(); 
                    mH(); 
                    mR(); 
                    mE(); 
                    mE(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_LEVEL"

    // $ANTLR start "K_USE"
    public final void mK_USE() throws RecognitionException {
        try {
            int _type = K_USE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:525:6: ( U S E )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:525:16: U S E
            {
            mU(); 
            mS(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_USE"

    // $ANTLR start "K_FIRST"
    public final void mK_FIRST() throws RecognitionException {
        try {
            int _type = K_FIRST;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:526:8: ( F I R S T )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:526:16: F I R S T
            {
            mF(); 
            mI(); 
            mR(); 
            mS(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_FIRST"

    // $ANTLR start "K_REVERSED"
    public final void mK_REVERSED() throws RecognitionException {
        try {
            int _type = K_REVERSED;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:527:11: ( R E V E R S E D )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:527:16: R E V E R S E D
            {
            mR(); 
            mE(); 
            mV(); 
            mE(); 
            mR(); 
            mS(); 
            mE(); 
            mD(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_REVERSED"

    // $ANTLR start "K_COUNT"
    public final void mK_COUNT() throws RecognitionException {
        try {
            int _type = K_COUNT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:528:8: ( C O U N T )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:528:16: C O U N T
            {
            mC(); 
            mO(); 
            mU(); 
            mN(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_COUNT"

    // $ANTLR start "K_SET"
    public final void mK_SET() throws RecognitionException {
        try {
            int _type = K_SET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:529:6: ( S E T )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:529:16: S E T
            {
            mS(); 
            mE(); 
            mT(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_SET"

    // $ANTLR start "K_BEGIN"
    public final void mK_BEGIN() throws RecognitionException {
        try {
            int _type = K_BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:530:8: ( B E G I N )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:530:16: B E G I N
            {
            mB(); 
            mE(); 
            mG(); 
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_BEGIN"

    // $ANTLR start "K_APPLY"
    public final void mK_APPLY() throws RecognitionException {
        try {
            int _type = K_APPLY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:531:8: ( A P P L Y )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:531:16: A P P L Y
            {
            mA(); 
            mP(); 
            mP(); 
            mL(); 
            mY(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_APPLY"

    // $ANTLR start "K_BATCH"
    public final void mK_BATCH() throws RecognitionException {
        try {
            int _type = K_BATCH;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:532:8: ( B A T C H )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:532:16: B A T C H
            {
            mB(); 
            mA(); 
            mT(); 
            mC(); 
            mH(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_BATCH"

    // $ANTLR start "K_TRUNCATE"
    public final void mK_TRUNCATE() throws RecognitionException {
        try {
            int _type = K_TRUNCATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:533:11: ( T R U N C A T E )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:533:16: T R U N C A T E
            {
            mT(); 
            mR(); 
            mU(); 
            mN(); 
            mC(); 
            mA(); 
            mT(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_TRUNCATE"

    // $ANTLR start "K_DELETE"
    public final void mK_DELETE() throws RecognitionException {
        try {
            int _type = K_DELETE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:534:9: ( D E L E T E )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:534:16: D E L E T E
            {
            mD(); 
            mE(); 
            mL(); 
            mE(); 
            mT(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_DELETE"

    // $ANTLR start "K_IN"
    public final void mK_IN() throws RecognitionException {
        try {
            int _type = K_IN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:535:5: ( I N )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:535:16: I N
            {
            mI(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_IN"

    // $ANTLR start "K_CREATE"
    public final void mK_CREATE() throws RecognitionException {
        try {
            int _type = K_CREATE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:536:9: ( C R E A T E )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:536:16: C R E A T E
            {
            mC(); 
            mR(); 
            mE(); 
            mA(); 
            mT(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_CREATE"

    // $ANTLR start "K_KEYSPACE"
    public final void mK_KEYSPACE() throws RecognitionException {
        try {
            int _type = K_KEYSPACE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:537:11: ( ( K E Y S P A C E | S C H E M A ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:537:16: ( K E Y S P A C E | S C H E M A )
            {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:537:16: ( K E Y S P A C E | S C H E M A )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0=='K'||LA2_0=='k') ) {
                alt2=1;
            }
            else if ( (LA2_0=='S'||LA2_0=='s') ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:537:18: K E Y S P A C E
                    {
                    mK(); 
                    mE(); 
                    mY(); 
                    mS(); 
                    mP(); 
                    mA(); 
                    mC(); 
                    mE(); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:538:20: S C H E M A
                    {
                    mS(); 
                    mC(); 
                    mH(); 
                    mE(); 
                    mM(); 
                    mA(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_KEYSPACE"

    // $ANTLR start "K_COLUMNFAMILY"
    public final void mK_COLUMNFAMILY() throws RecognitionException {
        try {
            int _type = K_COLUMNFAMILY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:539:15: ( ( C O L U M N F A M I L Y | T A B L E ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:539:16: ( C O L U M N F A M I L Y | T A B L E )
            {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:539:16: ( C O L U M N F A M I L Y | T A B L E )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0=='C'||LA3_0=='c') ) {
                alt3=1;
            }
            else if ( (LA3_0=='T'||LA3_0=='t') ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:539:18: C O L U M N F A M I L Y
                    {
                    mC(); 
                    mO(); 
                    mL(); 
                    mU(); 
                    mM(); 
                    mN(); 
                    mF(); 
                    mA(); 
                    mM(); 
                    mI(); 
                    mL(); 
                    mY(); 

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:540:20: T A B L E
                    {
                    mT(); 
                    mA(); 
                    mB(); 
                    mL(); 
                    mE(); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_COLUMNFAMILY"

    // $ANTLR start "K_INDEX"
    public final void mK_INDEX() throws RecognitionException {
        try {
            int _type = K_INDEX;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:541:8: ( I N D E X )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:541:16: I N D E X
            {
            mI(); 
            mN(); 
            mD(); 
            mE(); 
            mX(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_INDEX"

    // $ANTLR start "K_ON"
    public final void mK_ON() throws RecognitionException {
        try {
            int _type = K_ON;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:542:5: ( O N )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:542:16: O N
            {
            mO(); 
            mN(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_ON"

    // $ANTLR start "K_DROP"
    public final void mK_DROP() throws RecognitionException {
        try {
            int _type = K_DROP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:543:7: ( D R O P )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:543:16: D R O P
            {
            mD(); 
            mR(); 
            mO(); 
            mP(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_DROP"

    // $ANTLR start "K_PRIMARY"
    public final void mK_PRIMARY() throws RecognitionException {
        try {
            int _type = K_PRIMARY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:544:10: ( P R I M A R Y )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:544:16: P R I M A R Y
            {
            mP(); 
            mR(); 
            mI(); 
            mM(); 
            mA(); 
            mR(); 
            mY(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_PRIMARY"

    // $ANTLR start "K_INTO"
    public final void mK_INTO() throws RecognitionException {
        try {
            int _type = K_INTO;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:545:7: ( I N T O )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:545:16: I N T O
            {
            mI(); 
            mN(); 
            mT(); 
            mO(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_INTO"

    // $ANTLR start "K_VALUES"
    public final void mK_VALUES() throws RecognitionException {
        try {
            int _type = K_VALUES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:546:9: ( V A L U E S )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:546:16: V A L U E S
            {
            mV(); 
            mA(); 
            mL(); 
            mU(); 
            mE(); 
            mS(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_VALUES"

    // $ANTLR start "K_TIMESTAMP"
    public final void mK_TIMESTAMP() throws RecognitionException {
        try {
            int _type = K_TIMESTAMP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:547:12: ( T I M E S T A M P )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:547:16: T I M E S T A M P
            {
            mT(); 
            mI(); 
            mM(); 
            mE(); 
            mS(); 
            mT(); 
            mA(); 
            mM(); 
            mP(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_TIMESTAMP"

    // $ANTLR start "K_TTL"
    public final void mK_TTL() throws RecognitionException {
        try {
            int _type = K_TTL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:548:6: ( T T L )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:548:16: T T L
            {
            mT(); 
            mT(); 
            mL(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_TTL"

    // $ANTLR start "K_ALTER"
    public final void mK_ALTER() throws RecognitionException {
        try {
            int _type = K_ALTER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:549:8: ( A L T E R )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:549:16: A L T E R
            {
            mA(); 
            mL(); 
            mT(); 
            mE(); 
            mR(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_ALTER"

    // $ANTLR start "K_ADD"
    public final void mK_ADD() throws RecognitionException {
        try {
            int _type = K_ADD;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:550:6: ( A D D )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:550:16: A D D
            {
            mA(); 
            mD(); 
            mD(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_ADD"

    // $ANTLR start "K_TYPE"
    public final void mK_TYPE() throws RecognitionException {
        try {
            int _type = K_TYPE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:551:7: ( T Y P E )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:551:16: T Y P E
            {
            mT(); 
            mY(); 
            mP(); 
            mE(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "K_TYPE"

    // $ANTLR start "A"
    public final void mA() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:554:11: ( ( 'a' | 'A' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:554:13: ( 'a' | 'A' )
            {
            if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "A"

    // $ANTLR start "B"
    public final void mB() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:555:11: ( ( 'b' | 'B' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:555:13: ( 'b' | 'B' )
            {
            if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "B"

    // $ANTLR start "C"
    public final void mC() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:556:11: ( ( 'c' | 'C' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:556:13: ( 'c' | 'C' )
            {
            if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "C"

    // $ANTLR start "D"
    public final void mD() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:557:11: ( ( 'd' | 'D' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:557:13: ( 'd' | 'D' )
            {
            if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "D"

    // $ANTLR start "E"
    public final void mE() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:558:11: ( ( 'e' | 'E' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:558:13: ( 'e' | 'E' )
            {
            if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "E"

    // $ANTLR start "F"
    public final void mF() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:559:11: ( ( 'f' | 'F' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:559:13: ( 'f' | 'F' )
            {
            if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "F"

    // $ANTLR start "G"
    public final void mG() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:560:11: ( ( 'g' | 'G' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:560:13: ( 'g' | 'G' )
            {
            if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "G"

    // $ANTLR start "H"
    public final void mH() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:561:11: ( ( 'h' | 'H' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:561:13: ( 'h' | 'H' )
            {
            if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "H"

    // $ANTLR start "I"
    public final void mI() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:562:11: ( ( 'i' | 'I' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:562:13: ( 'i' | 'I' )
            {
            if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "I"

    // $ANTLR start "J"
    public final void mJ() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:563:11: ( ( 'j' | 'J' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:563:13: ( 'j' | 'J' )
            {
            if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "J"

    // $ANTLR start "K"
    public final void mK() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:564:11: ( ( 'k' | 'K' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:564:13: ( 'k' | 'K' )
            {
            if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "K"

    // $ANTLR start "L"
    public final void mL() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:565:11: ( ( 'l' | 'L' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:565:13: ( 'l' | 'L' )
            {
            if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "L"

    // $ANTLR start "M"
    public final void mM() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:566:11: ( ( 'm' | 'M' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:566:13: ( 'm' | 'M' )
            {
            if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "M"

    // $ANTLR start "N"
    public final void mN() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:567:11: ( ( 'n' | 'N' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:567:13: ( 'n' | 'N' )
            {
            if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "N"

    // $ANTLR start "O"
    public final void mO() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:568:11: ( ( 'o' | 'O' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:568:13: ( 'o' | 'O' )
            {
            if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "O"

    // $ANTLR start "P"
    public final void mP() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:569:11: ( ( 'p' | 'P' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:569:13: ( 'p' | 'P' )
            {
            if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "P"

    // $ANTLR start "Q"
    public final void mQ() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:570:11: ( ( 'q' | 'Q' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:570:13: ( 'q' | 'Q' )
            {
            if ( input.LA(1)=='Q'||input.LA(1)=='q' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Q"

    // $ANTLR start "R"
    public final void mR() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:571:11: ( ( 'r' | 'R' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:571:13: ( 'r' | 'R' )
            {
            if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "R"

    // $ANTLR start "S"
    public final void mS() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:572:11: ( ( 's' | 'S' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:572:13: ( 's' | 'S' )
            {
            if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "S"

    // $ANTLR start "T"
    public final void mT() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:573:11: ( ( 't' | 'T' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:573:13: ( 't' | 'T' )
            {
            if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "T"

    // $ANTLR start "U"
    public final void mU() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:574:11: ( ( 'u' | 'U' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:574:13: ( 'u' | 'U' )
            {
            if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "U"

    // $ANTLR start "V"
    public final void mV() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:575:11: ( ( 'v' | 'V' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:575:13: ( 'v' | 'V' )
            {
            if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "V"

    // $ANTLR start "W"
    public final void mW() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:576:11: ( ( 'w' | 'W' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:576:13: ( 'w' | 'W' )
            {
            if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "W"

    // $ANTLR start "X"
    public final void mX() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:577:11: ( ( 'x' | 'X' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:577:13: ( 'x' | 'X' )
            {
            if ( input.LA(1)=='X'||input.LA(1)=='x' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "X"

    // $ANTLR start "Y"
    public final void mY() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:578:11: ( ( 'y' | 'Y' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:578:13: ( 'y' | 'Y' )
            {
            if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Y"

    // $ANTLR start "Z"
    public final void mZ() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:579:11: ( ( 'z' | 'Z' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:579:13: ( 'z' | 'Z' )
            {
            if ( input.LA(1)=='Z'||input.LA(1)=='z' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "Z"

    // $ANTLR start "STRING_LITERAL"
    public final void mSTRING_LITERAL() throws RecognitionException {
        try {
            int _type = STRING_LITERAL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            int c;

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:582:5: ( '\\'' (c=~ ( '\\'' ) | '\\'' '\\'' )* '\\'' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:582:7: '\\'' (c=~ ( '\\'' ) | '\\'' '\\'' )* '\\''
            {
            match('\''); 
             StringBuilder b = new StringBuilder(); 
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:584:7: (c=~ ( '\\'' ) | '\\'' '\\'' )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\'') ) {
                    int LA4_1 = input.LA(2);

                    if ( (LA4_1=='\'') ) {
                        alt4=2;
                    }


                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='\uFFFF')) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:584:9: c=~ ( '\\'' )
            	    {
            	    c= input.LA(1);
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}

            	     b.appendCodePoint(c);

            	    }
            	    break;
            	case 2 :
            	    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:585:9: '\\'' '\\''
            	    {
            	    match('\''); 
            	    match('\''); 
            	     b.appendCodePoint('\'');

            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match('\''); 
             setText(b.toString()); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING_LITERAL"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:592:5: ( '0' .. '9' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:592:7: '0' .. '9'
            {
            matchRange('0','9'); 

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:596:5: ( ( 'A' .. 'Z' | 'a' .. 'z' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:596:7: ( 'A' .. 'Z' | 'a' .. 'z' )
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "HEX"
    public final void mHEX() throws RecognitionException {
        try {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:600:5: ( ( 'A' .. 'F' | 'a' .. 'f' | '0' .. '9' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:600:7: ( 'A' .. 'F' | 'a' .. 'f' | '0' .. '9' )
            {
            if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='F')||(input.LA(1)>='a' && input.LA(1)<='f') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "HEX"

    // $ANTLR start "RANGEOP"
    public final void mRANGEOP() throws RecognitionException {
        try {
            int _type = RANGEOP;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:604:5: ( '..' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:604:7: '..'
            {
            match(".."); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RANGEOP"

    // $ANTLR start "INTEGER"
    public final void mINTEGER() throws RecognitionException {
        try {
            int _type = INTEGER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:608:5: ( ( '-' )? ( DIGIT )+ )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:608:7: ( '-' )? ( DIGIT )+
            {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:608:7: ( '-' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='-') ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:608:7: '-'
                    {
                    match('-'); 

                    }
                    break;

            }

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:608:12: ( DIGIT )+
            int cnt6=0;
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:608:12: DIGIT
            	    {
            	    mDIGIT(); 

            	    }
            	    break;

            	default :
            	    if ( cnt6 >= 1 ) break loop6;
                        EarlyExitException eee =
                            new EarlyExitException(6, input);
                        throw eee;
                }
                cnt6++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "INTEGER"

    // $ANTLR start "QMARK"
    public final void mQMARK() throws RecognitionException {
        try {
            int _type = QMARK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:612:5: ( '?' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:612:7: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "QMARK"

    // $ANTLR start "FLOAT"
    public final void mFLOAT() throws RecognitionException {
        try {
            int _type = FLOAT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            CommonToken d=null;
            CommonToken r=null;

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:620:5: (d= INTEGER r= RANGEOP | INTEGER '.' INTEGER )
            int alt7=2;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:620:7: d= INTEGER r= RANGEOP
                    {
                    int dStart1948 = getCharIndex();
                    mINTEGER(); 
                    d = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, dStart1948, getCharIndex()-1);
                    int rStart1952 = getCharIndex();
                    mRANGEOP(); 
                    r = new CommonToken(input, Token.INVALID_TOKEN_TYPE, Token.DEFAULT_CHANNEL, rStart1952, getCharIndex()-1);

                              d.setType(INTEGER);
                              emit(d);
                              r.setType(RANGEOP);
                              emit(r);
                          

                    }
                    break;
                case 2 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:627:9: INTEGER '.' INTEGER
                    {
                    mINTEGER(); 
                    match('.'); 
                    mINTEGER(); 

                    }
                    break;

            }
            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FLOAT"

    // $ANTLR start "IDENT"
    public final void mIDENT() throws RecognitionException {
        try {
            int _type = IDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:631:5: ( LETTER ( LETTER | DIGIT | '_' )* )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:631:7: LETTER ( LETTER | DIGIT | '_' )*
            {
            mLETTER(); 
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:631:14: ( LETTER | DIGIT | '_' )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='0' && LA8_0<='9')||(LA8_0>='A' && LA8_0<='Z')||LA8_0=='_'||(LA8_0>='a' && LA8_0<='z')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENT"

    // $ANTLR start "COMPIDENT"
    public final void mCOMPIDENT() throws RecognitionException {
        try {
            int _type = COMPIDENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:635:5: ( IDENT ( ':' ( IDENT | INTEGER ) )* )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:635:7: IDENT ( ':' ( IDENT | INTEGER ) )*
            {
            mIDENT(); 
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:635:13: ( ':' ( IDENT | INTEGER ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==':') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:635:15: ':' ( IDENT | INTEGER )
            	    {
            	    match(':'); 
            	    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:635:19: ( IDENT | INTEGER )
            	    int alt9=2;
            	    int LA9_0 = input.LA(1);

            	    if ( ((LA9_0>='A' && LA9_0<='Z')||(LA9_0>='a' && LA9_0<='z')) ) {
            	        alt9=1;
            	    }
            	    else if ( (LA9_0=='-'||(LA9_0>='0' && LA9_0<='9')) ) {
            	        alt9=2;
            	    }
            	    else {
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 9, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt9) {
            	        case 1 :
            	            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:635:20: IDENT
            	            {
            	            mIDENT(); 

            	            }
            	            break;
            	        case 2 :
            	            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:635:28: INTEGER
            	            {
            	            mINTEGER(); 

            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMPIDENT"

    // $ANTLR start "UUID"
    public final void mUUID() throws RecognitionException {
        try {
            int _type = UUID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:639:5: ( HEX HEX HEX HEX HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:639:7: HEX HEX HEX HEX HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX '-' HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX HEX
            {
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            match('-'); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            match('-'); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            match('-'); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            match('-'); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 
            mHEX(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "UUID"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:647:5: ( ( ' ' | '\\t' | '\\n' | '\\r' )+ )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:647:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
            {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:647:7: ( ' ' | '\\t' | '\\n' | '\\r' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:651:5: ( ( '--' | '//' ) ( . )* ( '\\n' | '\\r' ) )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:651:7: ( '--' | '//' ) ( . )* ( '\\n' | '\\r' )
            {
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:651:7: ( '--' | '//' )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0=='-') ) {
                alt12=1;
            }
            else if ( (LA12_0=='/') ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:651:8: '--'
                    {
                    match("--"); 


                    }
                    break;
                case 2 :
                    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:651:15: '//'
                    {
                    match("//"); 


                    }
                    break;

            }

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:651:21: ( . )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='\n'||LA13_0=='\r') ) {
                    alt13=2;
                }
                else if ( ((LA13_0>='\u0000' && LA13_0<='\t')||(LA13_0>='\u000B' && LA13_0<='\f')||(LA13_0>='\u000E' && LA13_0<='\uFFFF')) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:651:21: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "MULTILINE_COMMENT"
    public final void mMULTILINE_COMMENT() throws RecognitionException {
        try {
            int _type = MULTILINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:655:5: ( '/*' ( . )* '*/' )
            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:655:7: '/*' ( . )* '*/'
            {
            match("/*"); 

            // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:655:12: ( . )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='*') ) {
                    int LA14_1 = input.LA(2);

                    if ( (LA14_1=='/') ) {
                        alt14=2;
                    }
                    else if ( ((LA14_1>='\u0000' && LA14_1<='.')||(LA14_1>='0' && LA14_1<='\uFFFF')) ) {
                        alt14=1;
                    }


                }
                else if ( ((LA14_0>='\u0000' && LA14_0<=')')||(LA14_0>='+' && LA14_0<='\uFFFF')) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:655:12: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            match("*/"); 

             _channel = HIDDEN; 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "MULTILINE_COMMENT"

    public void mTokens() throws RecognitionException {
        // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:8: ( T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | K_SELECT | K_FROM | K_WHERE | K_AND | K_KEY | K_INSERT | K_UPDATE | K_WITH | K_LIMIT | K_USING | K_CONSISTENCY | K_LEVEL | K_USE | K_FIRST | K_REVERSED | K_COUNT | K_SET | K_BEGIN | K_APPLY | K_BATCH | K_TRUNCATE | K_DELETE | K_IN | K_CREATE | K_KEYSPACE | K_COLUMNFAMILY | K_INDEX | K_ON | K_DROP | K_PRIMARY | K_INTO | K_VALUES | K_TIMESTAMP | K_TTL | K_ALTER | K_ADD | K_TYPE | STRING_LITERAL | RANGEOP | INTEGER | QMARK | FLOAT | IDENT | COMPIDENT | UUID | WS | COMMENT | MULTILINE_COMMENT )
        int alt15=75;
        alt15 = dfa15.predict(input);
        switch (alt15) {
            case 1 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:10: T__81
                {
                mT__81(); 

                }
                break;
            case 2 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:16: T__82
                {
                mT__82(); 

                }
                break;
            case 3 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:22: T__83
                {
                mT__83(); 

                }
                break;
            case 4 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:28: T__84
                {
                mT__84(); 

                }
                break;
            case 5 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:34: T__85
                {
                mT__85(); 

                }
                break;
            case 6 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:40: T__86
                {
                mT__86(); 

                }
                break;
            case 7 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:46: T__87
                {
                mT__87(); 

                }
                break;
            case 8 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:52: T__88
                {
                mT__88(); 

                }
                break;
            case 9 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:58: T__89
                {
                mT__89(); 

                }
                break;
            case 10 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:64: T__90
                {
                mT__90(); 

                }
                break;
            case 11 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:70: T__91
                {
                mT__91(); 

                }
                break;
            case 12 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:76: T__92
                {
                mT__92(); 

                }
                break;
            case 13 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:82: T__93
                {
                mT__93(); 

                }
                break;
            case 14 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:88: T__94
                {
                mT__94(); 

                }
                break;
            case 15 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:94: T__95
                {
                mT__95(); 

                }
                break;
            case 16 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:100: T__96
                {
                mT__96(); 

                }
                break;
            case 17 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:106: T__97
                {
                mT__97(); 

                }
                break;
            case 18 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:112: T__98
                {
                mT__98(); 

                }
                break;
            case 19 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:118: T__99
                {
                mT__99(); 

                }
                break;
            case 20 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:124: T__100
                {
                mT__100(); 

                }
                break;
            case 21 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:131: T__101
                {
                mT__101(); 

                }
                break;
            case 22 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:138: T__102
                {
                mT__102(); 

                }
                break;
            case 23 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:145: T__103
                {
                mT__103(); 

                }
                break;
            case 24 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:152: T__104
                {
                mT__104(); 

                }
                break;
            case 25 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:159: T__105
                {
                mT__105(); 

                }
                break;
            case 26 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:166: T__106
                {
                mT__106(); 

                }
                break;
            case 27 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:173: T__107
                {
                mT__107(); 

                }
                break;
            case 28 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:180: K_SELECT
                {
                mK_SELECT(); 

                }
                break;
            case 29 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:189: K_FROM
                {
                mK_FROM(); 

                }
                break;
            case 30 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:196: K_WHERE
                {
                mK_WHERE(); 

                }
                break;
            case 31 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:204: K_AND
                {
                mK_AND(); 

                }
                break;
            case 32 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:210: K_KEY
                {
                mK_KEY(); 

                }
                break;
            case 33 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:216: K_INSERT
                {
                mK_INSERT(); 

                }
                break;
            case 34 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:225: K_UPDATE
                {
                mK_UPDATE(); 

                }
                break;
            case 35 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:234: K_WITH
                {
                mK_WITH(); 

                }
                break;
            case 36 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:241: K_LIMIT
                {
                mK_LIMIT(); 

                }
                break;
            case 37 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:249: K_USING
                {
                mK_USING(); 

                }
                break;
            case 38 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:257: K_CONSISTENCY
                {
                mK_CONSISTENCY(); 

                }
                break;
            case 39 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:271: K_LEVEL
                {
                mK_LEVEL(); 

                }
                break;
            case 40 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:279: K_USE
                {
                mK_USE(); 

                }
                break;
            case 41 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:285: K_FIRST
                {
                mK_FIRST(); 

                }
                break;
            case 42 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:293: K_REVERSED
                {
                mK_REVERSED(); 

                }
                break;
            case 43 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:304: K_COUNT
                {
                mK_COUNT(); 

                }
                break;
            case 44 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:312: K_SET
                {
                mK_SET(); 

                }
                break;
            case 45 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:318: K_BEGIN
                {
                mK_BEGIN(); 

                }
                break;
            case 46 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:326: K_APPLY
                {
                mK_APPLY(); 

                }
                break;
            case 47 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:334: K_BATCH
                {
                mK_BATCH(); 

                }
                break;
            case 48 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:342: K_TRUNCATE
                {
                mK_TRUNCATE(); 

                }
                break;
            case 49 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:353: K_DELETE
                {
                mK_DELETE(); 

                }
                break;
            case 50 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:362: K_IN
                {
                mK_IN(); 

                }
                break;
            case 51 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:367: K_CREATE
                {
                mK_CREATE(); 

                }
                break;
            case 52 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:376: K_KEYSPACE
                {
                mK_KEYSPACE(); 

                }
                break;
            case 53 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:387: K_COLUMNFAMILY
                {
                mK_COLUMNFAMILY(); 

                }
                break;
            case 54 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:402: K_INDEX
                {
                mK_INDEX(); 

                }
                break;
            case 55 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:410: K_ON
                {
                mK_ON(); 

                }
                break;
            case 56 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:415: K_DROP
                {
                mK_DROP(); 

                }
                break;
            case 57 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:422: K_PRIMARY
                {
                mK_PRIMARY(); 

                }
                break;
            case 58 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:432: K_INTO
                {
                mK_INTO(); 

                }
                break;
            case 59 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:439: K_VALUES
                {
                mK_VALUES(); 

                }
                break;
            case 60 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:448: K_TIMESTAMP
                {
                mK_TIMESTAMP(); 

                }
                break;
            case 61 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:460: K_TTL
                {
                mK_TTL(); 

                }
                break;
            case 62 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:466: K_ALTER
                {
                mK_ALTER(); 

                }
                break;
            case 63 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:474: K_ADD
                {
                mK_ADD(); 

                }
                break;
            case 64 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:480: K_TYPE
                {
                mK_TYPE(); 

                }
                break;
            case 65 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:487: STRING_LITERAL
                {
                mSTRING_LITERAL(); 

                }
                break;
            case 66 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:502: RANGEOP
                {
                mRANGEOP(); 

                }
                break;
            case 67 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:510: INTEGER
                {
                mINTEGER(); 

                }
                break;
            case 68 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:518: QMARK
                {
                mQMARK(); 

                }
                break;
            case 69 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:524: FLOAT
                {
                mFLOAT(); 

                }
                break;
            case 70 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:530: IDENT
                {
                mIDENT(); 

                }
                break;
            case 71 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:536: COMPIDENT
                {
                mCOMPIDENT(); 

                }
                break;
            case 72 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:546: UUID
                {
                mUUID(); 

                }
                break;
            case 73 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:551: WS
                {
                mWS(); 

                }
                break;
            case 74 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:554: COMMENT
                {
                mCOMMENT(); 

                }
                break;
            case 75 :
                // E:\\cassandra\\apache-cassandra-2.0.0-src/src/java/org/apache/cassandra/cql/Cql.g:1:562: MULTILINE_COMMENT
                {
                mMULTILINE_COMMENT(); 

                }
                break;

        }

    }


    protected DFA1 dfa1 = new DFA1(this);
    protected DFA7 dfa7 = new DFA7(this);
    protected DFA15 dfa15 = new DFA15(this);
    static final String DFA1_eotS =
        "\13\uffff";
    static final String DFA1_eofS =
        "\13\uffff";
    static final String DFA1_minS =
        "\1\101\2\uffff\1\114\2\uffff\1\110\4\uffff";
    static final String DFA1_maxS =
        "\1\164\2\uffff\1\156\2\uffff\1\167\4\uffff";
    static final String DFA1_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\5\1\6\1\uffff\1\3\1\4\1\10\1\7";
    static final String DFA1_specialS =
        "\13\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\3\3\uffff\1\5\6\uffff\1\4\2\uffff\1\1\1\uffff\1\2\2\uffff"+
            "\1\6\14\uffff\1\3\3\uffff\1\5\6\uffff\1\4\2\uffff\1\1\1\uffff"+
            "\1\2\2\uffff\1\6",
            "",
            "",
            "\1\7\1\uffff\1\10\35\uffff\1\7\1\uffff\1\10",
            "",
            "",
            "\1\11\16\uffff\1\12\20\uffff\1\11\16\uffff\1\12",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "515:16: ( O N E | Q U O R U M | A L L | A N Y | L O C A L '_' Q U O R U M | E A C H '_' Q U O R U M | T W O | T H R E E )";
        }
    }
    static final String DFA7_eotS =
        "\6\uffff";
    static final String DFA7_eofS =
        "\6\uffff";
    static final String DFA7_minS =
        "\1\55\1\60\1\56\1\55\2\uffff";
    static final String DFA7_maxS =
        "\4\71\2\uffff";
    static final String DFA7_acceptS =
        "\4\uffff\1\1\1\2";
    static final String DFA7_specialS =
        "\6\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1\2\uffff\12\2",
            "\12\2",
            "\1\3\1\uffff\12\2",
            "\1\5\1\4\1\uffff\12\5",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "619:1: FLOAT : (d= INTEGER r= RANGEOP | INTEGER '.' INTEGER );";
        }
    }
    static final String DFA15_eotS =
        "\3\uffff\1\56\4\uffff\11\62\1\uffff\1\131\1\133\1\135\22\62\1\uffff"+
        "\1\152\1\uffff\1\62\4\uffff\3\62\1\uffff\2\62\1\uffff\22\62\2\u0088"+
        "\15\62\1\uffff\1\152\5\uffff\7\62\1\u00a4\4\62\2\uffff\1\152\2\uffff"+
        "\7\62\1\u00b2\1\u00b3\1\u00b4\1\62\1\u00b4\5\62\1\u00bb\1\62\1\u00b4"+
        "\4\62\1\u00c2\1\uffff\4\62\1\u00c7\17\62\1\u00d7\3\62\1\u00db\2"+
        "\62\1\uffff\1\u00b4\4\62\1\152\1\u00e4\6\62\3\uffff\2\62\1\u00ed"+
        "\2\62\1\u00f0\1\uffff\6\62\1\uffff\1\u00f7\2\62\1\u00fa\1\uffff"+
        "\11\62\1\u0104\3\62\1\u0108\1\62\1\uffff\2\62\1\u010c\1\uffff\7"+
        "\62\1\152\1\uffff\3\62\1\u0118\1\u0119\1\u011a\1\u011b\1\u011c\1"+
        "\uffff\2\62\1\uffff\1\u011f\1\u00b4\4\62\1\uffff\1\u0124\1\62\1"+
        "\uffff\1\u0126\1\62\2\u0129\3\62\1\u012d\1\u012e\1\uffff\3\62\1"+
        "\uffff\2\62\1\u0134\1\uffff\2\62\1\u0137\4\62\1\152\1\u013d\2\62"+
        "\5\uffff\2\62\1\uffff\2\62\1\u0144\1\u0145\1\uffff\1\u0146\1\uffff"+
        "\1\u0147\1\62\1\uffff\2\62\1\u014b\2\uffff\1\u014c\1\62\1\u014e"+
        "\1\u014f\1\u0150\1\uffff\2\62\1\uffff\1\u00b4\3\62\1\152\1\uffff"+
        "\1\u0157\4\62\1\u015c\4\uffff\1\u015d\2\62\2\uffff\1\u0160\3\uffff"+
        "\4\62\1\u0165\1\152\1\uffff\3\62\1\u0169\2\uffff\2\62\1\uffff\1"+
        "\u014f\2\62\1\u016e\1\uffff\1\152\1\u016f\1\u0170\1\uffff\4\62\3"+
        "\uffff\5\62\1\u017a\1\62\1\u00b4\1\u011f\1\uffff\1\u00b4";
    static final String DFA15_eofS =
        "\u017c\uffff";
    static final String DFA15_minS =
        "\1\11\2\uffff\1\56\4\uffff\11\60\1\uffff\1\55\2\75\22\60\1\uffff"+
        "\1\56\1\uffff\1\60\1\uffff\1\52\2\uffff\3\60\1\uffff\2\60\1\uffff"+
        "\41\60\1\uffff\1\56\5\uffff\14\60\2\uffff\1\56\2\uffff\31\60\1\uffff"+
        "\33\60\1\uffff\5\60\1\56\7\60\3\uffff\6\60\1\uffff\6\60\1\uffff"+
        "\4\60\1\uffff\17\60\1\uffff\3\60\1\uffff\7\60\1\56\1\uffff\10\60"+
        "\1\uffff\2\60\1\uffff\6\60\1\uffff\2\60\1\uffff\11\60\1\uffff\3"+
        "\60\1\uffff\3\60\1\uffff\7\60\1\56\3\60\5\uffff\2\60\1\uffff\4\60"+
        "\1\uffff\1\60\1\uffff\2\60\1\uffff\3\60\2\uffff\5\60\1\uffff\2\60"+
        "\1\uffff\4\60\1\56\1\uffff\6\60\4\uffff\3\60\2\uffff\1\60\3\uffff"+
        "\5\60\1\56\1\uffff\1\55\3\60\2\uffff\2\60\1\uffff\4\60\1\uffff\1"+
        "\55\2\60\1\uffff\4\60\3\uffff\11\60\1\uffff\1\60";
    static final String DFA15_maxS =
        "\1\172\2\uffff\1\56\4\uffff\11\172\1\uffff\1\71\2\75\22\172\1\uffff"+
        "\1\146\1\uffff\1\172\1\uffff\1\57\2\uffff\3\172\1\uffff\2\172\1"+
        "\uffff\41\172\1\uffff\1\71\5\uffff\14\172\2\uffff\1\146\2\uffff"+
        "\31\172\1\uffff\33\172\1\uffff\5\172\1\146\7\172\3\uffff\6\172\1"+
        "\uffff\6\172\1\uffff\4\172\1\uffff\17\172\1\uffff\3\172\1\uffff"+
        "\7\172\1\146\1\uffff\10\172\1\uffff\2\172\1\uffff\6\172\1\uffff"+
        "\2\172\1\uffff\11\172\1\uffff\3\172\1\uffff\3\172\1\uffff\7\172"+
        "\1\146\3\172\5\uffff\2\172\1\uffff\4\172\1\uffff\1\172\1\uffff\2"+
        "\172\1\uffff\3\172\2\uffff\5\172\1\uffff\2\172\1\uffff\4\172\1\146"+
        "\1\uffff\6\172\4\uffff\3\172\2\uffff\1\172\3\uffff\5\172\1\146\1"+
        "\uffff\4\172\2\uffff\2\172\1\uffff\4\172\1\uffff\1\71\2\172\1\uffff"+
        "\4\172\3\uffff\11\172\1\uffff\1\172";
    static final String DFA15_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\6\1\7\11\uffff\1\26\25\uffff"+
        "\1\101\1\uffff\1\104\1\uffff\1\111\1\uffff\1\102\1\3\3\uffff\1\106"+
        "\2\uffff\1\107\41\uffff\1\112\1\uffff\1\27\1\31\1\30\1\32\1\33\14"+
        "\uffff\1\103\1\105\1\uffff\1\110\1\113\31\uffff\1\62\33\uffff\1"+
        "\67\15\uffff\1\77\1\37\1\47\6\uffff\1\75\6\uffff\1\14\4\uffff\1"+
        "\50\17\uffff\1\54\3\uffff\1\40\10\uffff\1\10\10\uffff\1\12\2\uffff"+
        "\1\100\6\uffff\1\72\2\uffff\1\17\11\uffff\1\35\3\uffff\1\70\3\uffff"+
        "\1\43\13\uffff\1\55\1\57\1\11\1\76\1\56\2\uffff\1\65\4\uffff\1\66"+
        "\1\uffff\1\45\2\uffff\1\53\3\uffff\1\23\1\51\5\uffff\1\36\2\uffff"+
        "\1\44\5\uffff\1\16\6\uffff\1\15\1\73\1\41\1\42\3\uffff\1\63\1\24"+
        "\1\uffff\1\61\1\64\1\34\6\uffff\1\21\4\uffff\1\13\1\20\2\uffff\1"+
        "\25\4\uffff\1\71\3\uffff\1\60\4\uffff\1\52\1\22\1\74\11\uffff\1"+
        "\46\1\uffff";
    static final String DFA15_specialS =
        "\u017c\uffff}>";
    static final String[] DFA15_transitionS = {
            "\2\53\2\uffff\1\53\22\uffff\1\53\6\uffff\1\47\1\1\1\2\1\5\1"+
            "\21\1\4\1\22\1\3\1\54\12\50\1\uffff\1\6\1\23\1\7\1\24\1\51\1"+
            "\uffff\1\30\1\43\1\35\1\44\1\40\1\26\2\52\1\32\1\52\1\31\1\34"+
            "\2\52\1\36\1\45\1\37\1\42\1\25\1\41\1\33\1\46\1\27\3\52\6\uffff"+
            "\1\11\1\10\1\16\1\20\1\40\1\17\2\52\1\14\1\52\1\31\1\34\2\52"+
            "\1\36\1\45\1\37\1\42\1\25\1\12\1\15\1\13\1\27\3\52",
            "",
            "",
            "\1\55",
            "",
            "",
            "",
            "",
            "\12\67\1\65\6\uffff\1\64\3\67\1\63\1\67\24\66\4\uffff\1\66"+
            "\1\uffff\1\64\3\67\1\63\1\67\2\66\1\60\2\66\1\57\2\66\1\61\13"+
            "\66",
            "\12\67\1\65\6\uffff\3\67\1\71\2\67\5\66\1\73\1\66\1\72\1\66"+
            "\1\74\12\66\4\uffff\1\66\1\uffff\3\67\1\71\2\67\5\66\1\73\1"+
            "\66\1\72\1\66\1\74\2\66\1\70\7\66",
            "\12\66\1\65\6\uffff\1\101\6\66\1\104\1\103\10\66\1\105\1\66"+
            "\1\100\2\66\1\102\1\66\1\77\1\66\4\uffff\1\66\1\uffff\1\101"+
            "\3\66\1\75\2\66\1\104\1\76\10\66\1\105\1\66\1\100\2\66\1\102"+
            "\1\66\1\77\1\66",
            "\12\66\1\65\6\uffff\1\107\31\66\4\uffff\1\66\1\uffff\1\106"+
            "\31\66",
            "\12\66\1\65\6\uffff\15\66\1\111\14\66\4\uffff\1\66\1\uffff"+
            "\15\66\1\110\14\66",
            "\12\66\1\65\6\uffff\17\66\1\114\2\66\1\113\7\66\4\uffff\1"+
            "\66\1\uffff\17\66\1\114\2\66\1\113\1\66\1\112\5\66",
            "\12\67\1\65\6\uffff\6\67\10\66\1\116\2\66\1\117\10\66\4\uffff"+
            "\1\66\1\uffff\6\67\10\66\1\115\2\66\1\117\10\66",
            "\12\67\1\65\6\uffff\6\67\2\66\1\121\10\66\1\122\10\66\4\uffff"+
            "\1\66\1\uffff\6\67\2\66\1\121\2\66\1\120\5\66\1\122\10\66",
            "\12\67\1\65\6\uffff\4\67\1\125\1\67\13\66\1\126\10\66\4\uffff"+
            "\1\66\1\uffff\4\67\1\124\1\67\10\66\1\123\2\66\1\126\10\66",
            "",
            "\1\127\2\uffff\12\130",
            "\1\132",
            "\1\134",
            "\12\66\1\65\6\uffff\2\66\1\136\1\66\1\137\25\66\4\uffff\1"+
            "\66\1\uffff\2\66\1\136\1\66\1\137\25\66",
            "\12\67\1\65\6\uffff\6\67\2\66\1\121\10\66\1\122\10\66\4\uffff"+
            "\1\66\1\uffff\6\67\2\66\1\121\10\66\1\122\10\66",
            "\12\66\1\65\6\uffff\7\66\1\140\1\141\21\66\4\uffff\1\66\1"+
            "\uffff\7\66\1\140\1\141\21\66",
            "\12\67\1\65\6\uffff\3\67\1\71\2\67\5\66\1\73\1\66\1\72\1\66"+
            "\1\74\12\66\4\uffff\1\66\1\uffff\3\67\1\71\2\67\5\66\1\73\1"+
            "\66\1\72\1\66\1\74\12\66",
            "\12\66\1\65\6\uffff\4\66\1\142\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\142\25\66",
            "\12\66\1\65\6\uffff\15\66\1\111\14\66\4\uffff\1\66\1\uffff"+
            "\15\66\1\111\14\66",
            "\12\66\1\65\6\uffff\17\66\1\114\2\66\1\113\7\66\4\uffff\1"+
            "\66\1\uffff\17\66\1\114\2\66\1\113\7\66",
            "\12\66\1\65\6\uffff\10\66\1\144\5\66\1\143\13\66\4\uffff\1"+
            "\66\1\uffff\10\66\1\144\5\66\1\143\13\66",
            "\12\67\1\65\6\uffff\6\67\10\66\1\116\2\66\1\117\10\66\4\uffff"+
            "\1\66\1\uffff\6\67\10\66\1\116\2\66\1\117\10\66",
            "\12\66\1\65\6\uffff\15\66\1\145\14\66\4\uffff\1\66\1\uffff"+
            "\15\66\1\145\14\66",
            "\12\66\1\65\6\uffff\24\66\1\146\5\66\4\uffff\1\66\1\uffff"+
            "\24\66\1\146\5\66",
            "\12\67\1\65\6\uffff\1\147\5\67\24\66\4\uffff\1\66\1\uffff"+
            "\1\147\5\67\24\66",
            "\12\66\1\65\6\uffff\1\101\6\66\1\104\1\103\10\66\1\105\1\66"+
            "\1\100\2\66\1\102\1\66\1\77\1\66\4\uffff\1\66\1\uffff\1\101"+
            "\6\66\1\104\1\103\10\66\1\105\1\66\1\100\2\66\1\102\1\66\1\77"+
            "\1\66",
            "\12\66\1\65\6\uffff\4\66\1\150\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\150\25\66",
            "\12\67\1\65\6\uffff\1\64\3\67\1\63\1\67\24\66\4\uffff\1\66"+
            "\1\uffff\1\64\3\67\1\63\1\67\24\66",
            "\12\67\1\65\6\uffff\4\67\1\125\1\67\13\66\1\126\10\66\4\uffff"+
            "\1\66\1\uffff\4\67\1\125\1\67\13\66\1\126\10\66",
            "\12\66\1\65\6\uffff\21\66\1\151\10\66\4\uffff\1\66\1\uffff"+
            "\21\66\1\151\10\66",
            "\12\66\1\65\6\uffff\1\107\31\66\4\uffff\1\66\1\uffff\1\107"+
            "\31\66",
            "",
            "\1\153\1\uffff\12\154\7\uffff\6\155\32\uffff\6\155",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\156\4\uffff\1\127",
            "",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\157"+
            "\13\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\6\66\1\160"+
            "\23\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\161"+
            "\13\66",
            "",
            "\12\162\1\65\6\uffff\6\162\1\163\23\66\4\uffff\1\66\1\uffff"+
            "\6\162\1\163\23\66",
            "\12\162\1\65\6\uffff\6\162\15\66\1\164\6\66\4\uffff\1\66\1"+
            "\uffff\6\162\15\66\1\164\6\66",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\162\1\65\6\uffff\6\162\24\66\4\uffff\1\66\1\uffff\6\162"+
            "\24\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\165"+
            "\27\66",
            "\12\162\1\65\6\uffff\3\162\1\166\2\162\24\66\4\uffff\1\66"+
            "\1\uffff\3\162\1\166\2\162\24\66",
            "\12\66\1\65\6\uffff\3\66\1\167\24\66\1\170\1\66\4\uffff\1"+
            "\66\1\uffff\3\66\1\167\24\66\1\170\1\66",
            "\12\66\1\65\6\uffff\13\66\1\172\7\66\1\171\6\66\4\uffff\1"+
            "\66\1\uffff\13\66\1\172\7\66\1\171\6\66",
            "\12\66\1\65\6\uffff\17\66\1\173\12\66\4\uffff\1\66\1\uffff"+
            "\17\66\1\173\12\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\27\66\1\174"+
            "\2\66",
            "\12\66\1\65\6\uffff\14\66\1\176\15\66\4\uffff\1\66\1\uffff"+
            "\14\66\1\175\15\66",
            "\12\66\1\65\6\uffff\17\66\1\177\12\66\4\uffff\1\66\1\uffff"+
            "\17\66\1\177\12\66",
            "\12\66\1\65\6\uffff\13\66\1\u0080\16\66\4\uffff\1\66\1\uffff"+
            "\13\66\1\u0080\16\66",
            "\12\66\1\65\6\uffff\1\66\1\u0081\30\66\4\uffff\1\66\1\uffff"+
            "\1\66\1\u0081\30\66",
            "\12\66\1\65\6\uffff\16\66\1\u0082\13\66\4\uffff\1\66\1\uffff"+
            "\16\66\1\u0082\13\66",
            "\12\66\1\65\6\uffff\14\66\1\176\15\66\4\uffff\1\66\1\uffff"+
            "\14\66\1\176\15\66",
            "\12\66\1\65\6\uffff\21\66\1\u0083\10\66\4\uffff\1\66\1\uffff"+
            "\21\66\1\u0083\10\66",
            "\12\66\1\65\6\uffff\24\66\1\u0084\5\66\4\uffff\1\66\1\uffff"+
            "\24\66\1\u0084\5\66",
            "\12\66\1\65\6\uffff\13\66\1\u0086\16\66\4\uffff\1\66\1\uffff"+
            "\13\66\1\u0086\5\66\1\u0085\10\66",
            "\12\66\1\65\6\uffff\13\66\1\u0086\16\66\4\uffff\1\66\1\uffff"+
            "\13\66\1\u0086\16\66",
            "\12\66\1\65\6\uffff\3\66\1\u0089\16\66\1\u008b\1\u008a\6\66"+
            "\4\uffff\1\66\1\uffff\3\66\1\u0089\16\66\1\u008b\1\u0087\6\66",
            "\12\66\1\65\6\uffff\3\66\1\u0089\16\66\1\u008b\1\u008a\6\66"+
            "\4\uffff\1\66\1\uffff\3\66\1\u0089\16\66\1\u008b\1\u008a\6\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u008c"+
            "\21\66",
            "\12\66\1\65\6\uffff\4\66\1\u008d\3\66\1\u008e\21\66\4\uffff"+
            "\1\66\1\uffff\4\66\1\u008d\3\66\1\u008e\21\66",
            "\12\66\1\65\6\uffff\3\66\1\u008f\26\66\4\uffff\1\66\1\uffff"+
            "\3\66\1\u008f\26\66",
            "\12\66\1\65\6\uffff\13\66\1\u0092\1\66\1\u0093\6\66\1\u0091"+
            "\5\66\4\uffff\1\66\1\uffff\13\66\1\u0092\1\66\1\u0093\6\66\1"+
            "\u0090\5\66",
            "\12\66\1\65\6\uffff\13\66\1\u0092\1\66\1\u0093\6\66\1\u0091"+
            "\5\66\4\uffff\1\66\1\uffff\13\66\1\u0092\1\66\1\u0093\6\66\1"+
            "\u0091\5\66",
            "\12\66\1\65\6\uffff\4\66\1\u0094\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u0094\25\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\16\66\1\u0095"+
            "\13\66",
            "\12\66\1\65\6\uffff\21\66\1\u0096\10\66\4\uffff\1\66\1\uffff"+
            "\21\66\1\u0096\10\66",
            "\12\66\1\65\6\uffff\16\66\1\u0097\13\66\4\uffff\1\66\1\uffff"+
            "\16\66\1\u0097\13\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\24\66\1\u0098"+
            "\5\66",
            "\12\162\1\65\6\uffff\6\162\5\66\1\u009a\16\66\4\uffff\1\66"+
            "\1\uffff\2\162\1\u0099\3\162\5\66\1\u009a\16\66",
            "\12\162\1\65\6\uffff\6\162\5\66\1\u009a\16\66\4\uffff\1\66"+
            "\1\uffff\6\162\5\66\1\u009a\16\66",
            "\12\66\1\65\6\uffff\16\66\1\u009b\13\66\4\uffff\1\66\1\uffff"+
            "\16\66\1\u009b\13\66",
            "",
            "\1\153\1\uffff\12\130",
            "",
            "",
            "",
            "",
            "",
            "\12\66\1\65\6\uffff\7\66\1\u009c\22\66\4\uffff\1\66\1\uffff"+
            "\7\66\1\u009c\22\66",
            "\12\66\1\65\6\uffff\13\66\1\u009e\7\66\1\u009d\6\66\4\uffff"+
            "\1\66\1\uffff\13\66\1\u009e\7\66\1\u009d\6\66",
            "\12\66\1\65\6\uffff\4\66\1\u009f\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u009f\25\66",
            "\12\66\1\65\6\uffff\23\66\1\u00a0\6\66\4\uffff\1\66\1\uffff"+
            "\23\66\1\u00a0\6\66",
            "\12\66\1\65\6\uffff\30\66\1\u00a1\1\66\4\uffff\1\66\1\uffff"+
            "\30\66\1\u00a1\1\66",
            "\12\66\1\65\6\uffff\2\66\1\u00a2\27\66\4\uffff\1\66\1\uffff"+
            "\2\66\1\u00a2\27\66",
            "\12\66\1\65\6\uffff\14\66\1\u00a3\15\66\4\uffff\1\66\1\uffff"+
            "\14\66\1\u00a3\15\66",
            "\12\66\1\65\6\uffff\4\66\1\u00a5\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u00a5\25\66",
            "\12\66\1\65\6\uffff\16\66\1\u00a6\13\66\4\uffff\1\66\1\uffff"+
            "\16\66\1\u00a6\13\66",
            "\12\162\1\65\6\uffff\2\162\1\u00a7\3\162\24\66\4\uffff\1\66"+
            "\1\uffff\2\162\1\u00a7\3\162\24\66",
            "\12\66\1\65\6\uffff\25\66\1\u00a8\4\66\4\uffff\1\66\1\uffff"+
            "\25\66\1\u00a8\4\66",
            "\12\66\1\65\6\uffff\10\66\1\u00a9\21\66\4\uffff\1\66\1\uffff"+
            "\10\66\1\u00a9\21\66",
            "",
            "",
            "\1\153\1\uffff\12\u00aa\7\uffff\6\155\32\uffff\6\155",
            "",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\1\66\1\u00ab"+
            "\30\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u00ac"+
            "\21\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u00ad"+
            "\16\66",
            "\12\u00ae\1\65\6\uffff\6\u00ae\24\66\4\uffff\1\66\1\uffff"+
            "\6\u00ae\24\66",
            "\12\66\1\65\6\uffff\10\66\1\u00af\21\66\4\uffff\1\66\1\uffff"+
            "\10\66\1\u00af\21\66",
            "\12\66\1\65\6\uffff\2\66\1\u00b0\27\66\4\uffff\1\66\1\uffff"+
            "\2\66\1\u00b0\27\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u00b1"+
            "\21\66",
            "\12\u00ae\1\65\6\uffff\6\u00ae\24\66\4\uffff\1\66\1\uffff"+
            "\6\u00ae\24\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\4\66\1\u00b5\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u00b5\25\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\13\66\1\u00b6\16\66\4\uffff\1\66\1\uffff"+
            "\13\66\1\u00b6\16\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u00b7"+
            "\6\66",
            "\12\66\1\65\6\uffff\4\66\1\u00b9\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u00b8\25\66",
            "\12\66\1\65\6\uffff\4\66\1\u00b9\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u00b9\25\66",
            "\12\66\1\65\6\uffff\4\66\1\u00ba\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u00ba\25\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\13\66\1\u00bc\16\66\4\uffff\1\66\1\uffff"+
            "\13\66\1\u00bc\16\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\4\66\1\u00bd\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u00bd\25\66",
            "\12\66\1\65\6\uffff\15\66\1\u00be\14\66\4\uffff\1\66\1\uffff"+
            "\15\66\1\u00be\14\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\2\66\1\u00bf"+
            "\5\66\1\u00c0\21\66",
            "\12\66\1\65\6\uffff\24\66\1\u00c1\5\66\4\uffff\1\66\1\uffff"+
            "\24\66\1\u00c1\5\66",
            "\12\66\1\65\6\uffff\16\66\1\u00c3\13\66\4\uffff\1\66\1\uffff"+
            "\16\66\1\u00c3\13\66",
            "",
            "\12\66\1\65\6\uffff\4\66\1\u00c4\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u00c4\25\66",
            "\12\66\1\65\6\uffff\16\66\1\u00c3\13\66\4\uffff\1\66\1\uffff"+
            "\16\66\1\u00c3\13\66",
            "\12\66\1\65\6\uffff\4\66\1\u00c5\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u00c5\25\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\3\66\1\u00c6"+
            "\26\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\15\66\1\u00c8\14\66\4\uffff\1\66\1\uffff"+
            "\15\66\1\u00c8\14\66",
            "\12\66\1\65\6\uffff\1\u00c9\31\66\4\uffff\1\66\1\uffff\1\u00c9"+
            "\31\66",
            "\12\66\1\65\6\uffff\15\66\1\u00cb\14\66\4\uffff\1\66\1\uffff"+
            "\15\66\1\u00ca\14\66",
            "\12\66\1\65\6\uffff\15\66\1\u00cb\14\66\4\uffff\1\66\1\uffff"+
            "\15\66\1\u00cb\14\66",
            "\12\66\1\65\6\uffff\24\66\1\u00cc\5\66\4\uffff\1\66\1\uffff"+
            "\24\66\1\u00cc\5\66",
            "\12\66\1\65\6\uffff\22\66\1\u00cd\7\66\4\uffff\1\66\1\uffff"+
            "\22\66\1\u00cd\7\66",
            "\12\66\1\65\6\uffff\1\u00ce\31\66\4\uffff\1\66\1\uffff\1\u00ce"+
            "\31\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\1\u00cf\31"+
            "\66",
            "\12\66\1\65\6\uffff\22\66\1\u00d0\7\66\4\uffff\1\66\1\uffff"+
            "\22\66\1\u00d0\7\66",
            "\12\66\1\65\6\uffff\14\66\1\u00d1\15\66\4\uffff\1\66\1\uffff"+
            "\14\66\1\u00d1\15\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\1\66\1\u00d2"+
            "\30\66",
            "\12\u00ae\1\65\6\uffff\6\u00ae\24\66\4\uffff\1\66\1\uffff"+
            "\6\u00ae\2\66\1\u00d3\21\66",
            "\12\66\1\65\6\uffff\4\66\1\u00d4\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u00d4\25\66",
            "\12\66\1\65\6\uffff\17\66\1\u00d5\12\66\4\uffff\1\66\1\uffff"+
            "\17\66\1\u00d5\12\66",
            "\12\66\1\65\6\uffff\4\66\1\u00d6\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u00d6\25\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\4\66\1\u00d8\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u00d8\25\66",
            "\12\66\1\65\6\uffff\21\66\1\u00d9\10\66\4\uffff\1\66\1\uffff"+
            "\21\66\1\u00d9\10\66",
            "\12\66\1\65\6\uffff\7\66\1\u00da\22\66\4\uffff\1\66\1\uffff"+
            "\7\66\1\u00da\22\66",
            "\12\66\1\65\6\uffff\22\66\1\u00dc\7\66\4\uffff\1\66\1\uffff"+
            "\22\66\1\u00dc\7\66",
            "\12\66\1\65\6\uffff\1\u00dd\31\66\4\uffff\1\66\1\uffff\1\u00dd"+
            "\31\66",
            "\12\66\1\65\6\uffff\10\66\1\u00de\21\66\4\uffff\1\66\1\uffff"+
            "\10\66\1\u00de\21\66",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\21\66\1\u00df\10\66\4\uffff\1\66\1\uffff"+
            "\21\66\1\u00df\10\66",
            "\12\u00ae\1\65\6\uffff\6\u00ae\1\66\1\u00e0\22\66\4\uffff"+
            "\1\66\1\uffff\6\u00ae\1\66\1\u00e0\22\66",
            "\12\66\1\65\6\uffff\4\66\1\u00e1\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u00e1\25\66",
            "\12\66\1\65\6\uffff\14\66\1\u00e2\15\66\4\uffff\1\66\1\uffff"+
            "\14\66\1\u00e2\15\66",
            "\1\153\1\uffff\12\u00e3\7\uffff\6\155\32\uffff\6\155",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u00e5"+
            "\14\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u00e6"+
            "\25\66",
            "\12\u00e7\1\65\6\uffff\6\u00e7\24\66\4\uffff\1\66\1\uffff"+
            "\6\u00e7\24\66",
            "\12\66\1\65\6\uffff\15\66\1\u00e8\14\66\4\uffff\1\66\1\uffff"+
            "\15\66\1\u00e8\14\66",
            "\12\66\1\65\6\uffff\7\66\1\u00e9\22\66\4\uffff\1\66\1\uffff"+
            "\7\66\1\u00e9\22\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\10\66\1\u00ea"+
            "\21\66",
            "",
            "",
            "",
            "\12\66\1\65\6\uffff\21\66\1\u00eb\10\66\4\uffff\1\66\1\uffff"+
            "\21\66\1\u00eb\10\66",
            "\12\66\1\65\6\uffff\30\66\1\u00ec\1\66\4\uffff\1\66\1\uffff"+
            "\30\66\1\u00ec\1\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\22\66\1\u00ef\7\66\4\uffff\1\66\1\uffff"+
            "\22\66\1\u00ee\7\66",
            "\12\66\1\65\6\uffff\22\66\1\u00ef\7\66\4\uffff\1\66\1\uffff"+
            "\22\66\1\u00ef\7\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\1\65\6\uffff\4\66\1\u00f1\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u00f1\25\66",
            "\12\66\1\65\6\uffff\4\66\1\u00f2\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u00f2\25\66",
            "\12\66\1\65\6\uffff\2\66\1\u00f3\27\66\4\uffff\1\66\1\uffff"+
            "\2\66\1\u00f3\27\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\7\66\1\u00f4"+
            "\22\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u00f5"+
            "\14\66",
            "\12\66\1\65\6\uffff\4\66\1\u00f6\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u00f6\25\66",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\27\66\1\u00f8\2\66\4\uffff\1\66\1\uffff"+
            "\27\66\1\u00f8\2\66",
            "\12\66\1\65\6\uffff\21\66\1\u00f9\10\66\4\uffff\1\66\1\uffff"+
            "\21\66\1\u00f9\10\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\1\65\6\uffff\6\66\1\u00fb\23\66\4\uffff\1\66\1\uffff"+
            "\6\66\1\u00fb\23\66",
            "\12\66\1\65\6\uffff\23\66\1\u00fc\6\66\4\uffff\1\66\1\uffff"+
            "\23\66\1\u00fc\6\66",
            "\12\66\1\65\6\uffff\23\66\1\u00fe\6\66\4\uffff\1\66\1\uffff"+
            "\23\66\1\u00fd\6\66",
            "\12\66\1\65\6\uffff\23\66\1\u00fe\6\66\4\uffff\1\66\1\uffff"+
            "\23\66\1\u00fe\6\66",
            "\12\66\1\65\6\uffff\14\66\1\u00ff\15\66\4\uffff\1\66\1\uffff"+
            "\14\66\1\u00ff\15\66",
            "\12\66\1\65\6\uffff\10\66\1\u0100\21\66\4\uffff\1\66\1\uffff"+
            "\10\66\1\u0100\21\66",
            "\12\66\1\65\6\uffff\23\66\1\u0101\6\66\4\uffff\1\66\1\uffff"+
            "\23\66\1\u0101\6\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u0102"+
            "\6\66",
            "\12\66\1\65\6\uffff\23\66\1\u0103\6\66\4\uffff\1\66\1\uffff"+
            "\23\66\1\u0103\6\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u0105"+
            "\16\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\14\66\1\u0106"+
            "\15\66",
            "\12\66\1\65\6\uffff\23\66\1\u0107\6\66\4\uffff\1\66\1\uffff"+
            "\23\66\1\u0107\6\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\14\66\1\u0109\15\66\4\uffff\1\66\1\uffff"+
            "\14\66\1\u0109\15\66",
            "",
            "\12\66\1\65\6\uffff\2\66\1\u010a\27\66\4\uffff\1\66\1\uffff"+
            "\2\66\1\u010a\27\66",
            "\12\66\1\65\6\uffff\4\66\1\u010b\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u010b\25\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\1\65\6\uffff\17\66\1\u010d\12\66\4\uffff\1\66\1\uffff"+
            "\17\66\1\u010d\12\66",
            "\12\66\1\65\6\uffff\13\66\1\u010e\16\66\4\uffff\1\66\1\uffff"+
            "\13\66\1\u010e\16\66",
            "\12\66\1\65\6\uffff\23\66\1\u010f\6\66\4\uffff\1\66\1\uffff"+
            "\23\66\1\u010f\6\66",
            "\12\66\1\65\6\uffff\24\66\1\u0110\5\66\4\uffff\1\66\1\uffff"+
            "\24\66\1\u0110\5\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\u0111\1\uffff\32\66",
            "\12\66\1\65\6\uffff\21\66\1\u0112\10\66\4\uffff\1\66\1\uffff"+
            "\21\66\1\u0112\10\66",
            "\12\66\1\65\6\uffff\1\u0113\31\66\4\uffff\1\66\1\uffff\1\u0113"+
            "\31\66",
            "\1\153\1\uffff\12\u0114\7\uffff\6\155\32\uffff\6\155",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u0115"+
            "\6\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\1\u0116\31"+
            "\66",
            "\12\u0117\1\65\6\uffff\6\u0117\24\66\4\uffff\1\66\1\uffff"+
            "\6\u0117\24\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\1\65\6\uffff\23\66\1\u011e\6\66\4\uffff\1\66\1\uffff"+
            "\23\66\1\u011d\6\66",
            "\12\66\1\65\6\uffff\23\66\1\u011e\6\66\4\uffff\1\66\1\uffff"+
            "\23\66\1\u011e\6\66",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\1\u0120\31\66\4\uffff\1\66\1\uffff\1\u0120"+
            "\31\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\1\u0121\31"+
            "\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\23\66\1\u0122"+
            "\6\66",
            "\12\66\1\65\6\uffff\22\66\1\u0123\7\66\4\uffff\1\66\1\uffff"+
            "\22\66\1\u0123\7\66",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\23\66\1\u0125\6\66\4\uffff\1\66\1\uffff"+
            "\23\66\1\u0125\6\66",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\4\66\1\u0127\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u0127\25\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u0128"+
            "\25\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\15\66\1\u012a\14\66\4\uffff\1\66\1\uffff"+
            "\15\66\1\u012a\14\66",
            "\12\66\1\65\6\uffff\22\66\1\u012b\7\66\4\uffff\1\66\1\uffff"+
            "\22\66\1\u012b\7\66",
            "\12\66\1\65\6\uffff\4\66\1\u012c\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u012c\25\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\4\66\1\u012f"+
            "\25\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\1\u0130\31"+
            "\66",
            "\12\66\1\65\6\uffff\4\66\1\u0131\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u0131\25\66",
            "",
            "\12\66\1\65\6\uffff\1\u0132\31\66\4\uffff\1\66\1\uffff\1\u0132"+
            "\31\66",
            "\12\66\1\65\6\uffff\23\66\1\u0133\6\66\4\uffff\1\66\1\uffff"+
            "\23\66\1\u0133\6\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\1\65\6\uffff\1\u0135\31\66\4\uffff\1\66\1\uffff\1\u0135"+
            "\31\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\u0136\1\uffff\32\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\14\66\1\u0138\15\66\4\uffff\1\66\1\uffff"+
            "\14\66\1\u0138\15\66",
            "\12\66\1\65\6\uffff\20\66\1\u0139\11\66\4\uffff\1\66\1\uffff"+
            "\20\66\1\u0139\11\66",
            "\12\66\1\65\6\uffff\22\66\1\u013a\7\66\4\uffff\1\66\1\uffff"+
            "\22\66\1\u013a\7\66",
            "\12\66\1\65\6\uffff\21\66\1\u013b\10\66\4\uffff\1\66\1\uffff"+
            "\21\66\1\u013b\10\66",
            "\1\153\1\uffff\12\u013c\7\uffff\6\155\32\uffff\6\155",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\15\66\1\u013e"+
            "\14\66",
            "\12\u013f\1\65\6\uffff\6\u013f\24\66\4\uffff\1\66\1\uffff"+
            "\6\u013f\24\66",
            "",
            "",
            "",
            "",
            "",
            "\12\66\1\65\6\uffff\1\u0141\31\66\4\uffff\1\66\1\uffff\1\u0140"+
            "\31\66",
            "\12\66\1\65\6\uffff\1\u0141\31\66\4\uffff\1\66\1\uffff\1\u0141"+
            "\31\66",
            "",
            "\12\66\1\65\6\uffff\23\66\1\u0142\6\66\4\uffff\1\66\1\uffff"+
            "\23\66\1\u0142\6\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u0143"+
            "\10\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\21\66\1\u0148"+
            "\10\66",
            "",
            "\12\66\1\65\6\uffff\5\66\1\u0149\24\66\4\uffff\1\66\1\uffff"+
            "\5\66\1\u0149\24\66",
            "\12\66\1\65\6\uffff\23\66\1\u014a\6\66\4\uffff\1\66\1\uffff"+
            "\23\66\1\u014a\6\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\13\66\1\u014d"+
            "\16\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\1\65\6\uffff\2\66\1\u0151\27\66\4\uffff\1\66\1\uffff"+
            "\2\66\1\u0151\27\66",
            "\12\66\1\65\6\uffff\20\66\1\u0152\11\66\4\uffff\1\66\1\uffff"+
            "\20\66\1\u0152\11\66",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\24\66\1\u0153\5\66\4\uffff\1\66\1\uffff"+
            "\24\66\1\u0153\5\66",
            "\12\66\1\65\6\uffff\4\66\1\u0154\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u0154\25\66",
            "\12\66\1\65\6\uffff\30\66\1\u0155\1\66\4\uffff\1\66\1\uffff"+
            "\30\66\1\u0155\1\66",
            "\1\153\1\uffff\12\u0156\7\uffff\6\155\32\uffff\6\155",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\u0158\1\65\6\uffff\6\u0158\24\66\4\uffff\1\66\1\uffff"+
            "\6\u0158\24\66",
            "\12\66\1\65\6\uffff\14\66\1\u015a\15\66\4\uffff\1\66\1\uffff"+
            "\14\66\1\u0159\15\66",
            "\12\66\1\65\6\uffff\14\66\1\u015a\15\66\4\uffff\1\66\1\uffff"+
            "\14\66\1\u015a\15\66",
            "\12\66\1\65\6\uffff\4\66\1\u015b\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u015b\25\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\1\u015e\31\66\4\uffff\1\66\1\uffff\1\u015e"+
            "\31\66",
            "\12\66\1\65\6\uffff\4\66\1\u015f\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u015f\25\66",
            "",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "",
            "\12\66\1\65\6\uffff\4\66\1\u0161\25\66\4\uffff\1\66\1\uffff"+
            "\4\66\1\u0161\25\66",
            "\12\66\1\65\6\uffff\24\66\1\u0162\5\66\4\uffff\1\66\1\uffff"+
            "\24\66\1\u0162\5\66",
            "\12\66\1\65\6\uffff\16\66\1\u0163\13\66\4\uffff\1\66\1\uffff"+
            "\16\66\1\u0163\13\66",
            "\12\66\1\65\6\uffff\3\66\1\u0164\26\66\4\uffff\1\66\1\uffff"+
            "\3\66\1\u0164\26\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\1\153\1\uffff\12\u0166\7\uffff\6\155\32\uffff\6\155",
            "",
            "\1\155\2\uffff\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff"+
            "\32\66",
            "\12\66\1\65\6\uffff\17\66\1\u0168\12\66\4\uffff\1\66\1\uffff"+
            "\17\66\1\u0167\12\66",
            "\12\66\1\65\6\uffff\17\66\1\u0168\12\66\4\uffff\1\66\1\uffff"+
            "\17\66\1\u0168\12\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "",
            "\12\66\1\65\6\uffff\14\66\1\u016a\15\66\4\uffff\1\66\1\uffff"+
            "\14\66\1\u016a\15\66",
            "\12\66\1\65\6\uffff\15\66\1\u016b\14\66\4\uffff\1\66\1\uffff"+
            "\15\66\1\u016b\14\66",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\16\66\1\u016c\13\66\4\uffff\1\66\1\uffff"+
            "\16\66\1\u016c\13\66",
            "\12\66\1\65\6\uffff\21\66\1\u016d\10\66\4\uffff\1\66\1\uffff"+
            "\21\66\1\u016d\10\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\1\155\1\153\1\uffff\12\130",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\1\65\6\uffff\10\66\1\u0171\21\66\4\uffff\1\66\1\uffff"+
            "\10\66\1\u0171\21\66",
            "\12\66\1\65\6\uffff\2\66\1\u0172\27\66\4\uffff\1\66\1\uffff"+
            "\2\66\1\u0172\27\66",
            "\12\66\1\65\6\uffff\21\66\1\u0173\10\66\4\uffff\1\66\1\uffff"+
            "\21\66\1\u0173\10\66",
            "\12\66\1\65\6\uffff\24\66\1\u0174\5\66\4\uffff\1\66\1\uffff"+
            "\24\66\1\u0174\5\66",
            "",
            "",
            "",
            "\12\66\1\65\6\uffff\13\66\1\u0175\16\66\4\uffff\1\66\1\uffff"+
            "\13\66\1\u0175\16\66",
            "\12\66\1\65\6\uffff\30\66\1\u0176\1\66\4\uffff\1\66\1\uffff"+
            "\30\66\1\u0176\1\66",
            "\12\66\1\65\6\uffff\24\66\1\u0177\5\66\4\uffff\1\66\1\uffff"+
            "\24\66\1\u0177\5\66",
            "\12\66\1\65\6\uffff\14\66\1\u0178\15\66\4\uffff\1\66\1\uffff"+
            "\14\66\1\u0178\15\66",
            "\12\66\1\65\6\uffff\30\66\1\u0179\1\66\4\uffff\1\66\1\uffff"+
            "\30\66\1\u0179\1\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\14\66\1\u017b\15\66\4\uffff\1\66\1\uffff"+
            "\14\66\1\u017b\15\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66",
            "",
            "\12\66\1\65\6\uffff\32\66\4\uffff\1\66\1\uffff\32\66"
    };

    static final short[] DFA15_eot = DFA.unpackEncodedString(DFA15_eotS);
    static final short[] DFA15_eof = DFA.unpackEncodedString(DFA15_eofS);
    static final char[] DFA15_min = DFA.unpackEncodedStringToUnsignedChars(DFA15_minS);
    static final char[] DFA15_max = DFA.unpackEncodedStringToUnsignedChars(DFA15_maxS);
    static final short[] DFA15_accept = DFA.unpackEncodedString(DFA15_acceptS);
    static final short[] DFA15_special = DFA.unpackEncodedString(DFA15_specialS);
    static final short[][] DFA15_transition;

    static {
        int numStates = DFA15_transitionS.length;
        DFA15_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA15_transition[i] = DFA.unpackEncodedString(DFA15_transitionS[i]);
        }
    }

    class DFA15 extends DFA {

        public DFA15(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 15;
            this.eot = DFA15_eot;
            this.eof = DFA15_eof;
            this.min = DFA15_min;
            this.max = DFA15_max;
            this.accept = DFA15_accept;
            this.special = DFA15_special;
            this.transition = DFA15_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__81 | T__82 | T__83 | T__84 | T__85 | T__86 | T__87 | T__88 | T__89 | T__90 | T__91 | T__92 | T__93 | T__94 | T__95 | T__96 | T__97 | T__98 | T__99 | T__100 | T__101 | T__102 | T__103 | T__104 | T__105 | T__106 | T__107 | K_SELECT | K_FROM | K_WHERE | K_AND | K_KEY | K_INSERT | K_UPDATE | K_WITH | K_LIMIT | K_USING | K_CONSISTENCY | K_LEVEL | K_USE | K_FIRST | K_REVERSED | K_COUNT | K_SET | K_BEGIN | K_APPLY | K_BATCH | K_TRUNCATE | K_DELETE | K_IN | K_CREATE | K_KEYSPACE | K_COLUMNFAMILY | K_INDEX | K_ON | K_DROP | K_PRIMARY | K_INTO | K_VALUES | K_TIMESTAMP | K_TTL | K_ALTER | K_ADD | K_TYPE | STRING_LITERAL | RANGEOP | INTEGER | QMARK | FLOAT | IDENT | COMPIDENT | UUID | WS | COMMENT | MULTILINE_COMMENT );";
        }
    }
 

}