//----------------------------------------------------------------------
// CS321 Assignment 1 (Fall 2014)
//
// miniJava Lexer2 (Manual Implementation)
//----------------------------------------------------------------------

import java.io.FileInputStream;

public class Lexer2 {

    static class LexError extends Exception {
        int line;
        int column;
        public LexError(int line, int column, String msg) {
            super("at line " + line + " column " + column + ": " + msg);
            this.line = line; this.column = column;
        }
    }

    // Internal token code
    static final int EOF = 0; // not used
    static final int ID = 1;
    static final int DELIMITER= 2;
    static final int INTEGER=3;
    static final int OPERATOR = 4;
    static final int STRLIT = 5;
    static final int KEYWORD = 6;

    // Token object
    static class Token {
        int kind; 		// token code
        int line;	   	// line number of token's first char
        int column;    	// column number of token's first char
        String lexeme;      // lexeme string

        public Token(int k, int l, int c, String lex) {
            kind = k; line = l; column = c; lexeme = lex;
        }

        public String toString() {
            return lexeme;
        }
    }

    // File input handle
    static FileInputStream input = null;

    // Line and column numbers
    static int linNum = 1;
    static int colNum = 0;

    // Read chars from a file; print out all tokens.
    //
    public static void main(String [] args) {
        try {
            if (args.length == 1) {
                input = new FileInputStream(args[0]);
                Token tkn;
                int tknCnt = 0;
                while ((tkn = nextToken()) != null) {
                    // ID token
                    System.out.println("(" + tkn.line + "," + tkn.column + ") "
                            + "\t"+ (tokenType(tkn.kind)==""? "":tokenType(tkn.kind)+"(")
                            + tkn.lexeme+(tokenType(tkn.kind)==""? "":")"));
                    tknCnt++;
                }
                input.close();
                System.out.println("Total: " + tknCnt + " tokens");
            } else {
                System.err.println("Need a file name as command-line argument.");
            }
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    // Read next char from input; book-keep line and column numbers.
    //
    static int nextChar() throws Exception {
        int c = input.read();
        if (c == '\n') {
            linNum++;
            colNum = 0;
        } else {
            colNum++;
        }
        return c;
    }

    // Recognize the next token and return its code.
    //
    static Token nextToken() throws Exception {
        StringBuilder buffer = new StringBuilder();
        int c = nextChar();
        for (;;) {
            switch (c) {

                case -1:
                    return null;

                // Skip whitespace
                case ' ':
                case '\t':
                case '\n':
                case '\r':
                    c = nextChar();
                    continue;

                default:
                    if(c=='&' && nextChar()=='&'){
                        int beginLine = linNum;
                        int beginColumn = colNum-1;
                        return new Token(OPERATOR, beginLine, beginColumn, "&&");
                    }
                    else if(c=='!' && nextChar()=='='){
                        int beginLine = linNum;
                        int beginColumn = colNum-1;
                        return new Token(OPERATOR, beginLine, beginColumn, "!=");
                    }
                    else if(c=='|' && nextChar()=='|'){
                        int beginLine = linNum;
                        int beginColumn = colNum-1;
                        return new Token(OPERATOR, beginLine, beginColumn, "||");
                    }

                    else if(c=='<' && nextChar()=='='){
                        int beginLine = linNum;
                        int beginColumn = colNum-1;
                        return new Token(OPERATOR, beginLine, beginColumn, "<=");
                    }
                    else if(c=='>' && nextChar()=='='){
                        int beginLine = linNum;
                        int beginColumn = colNum-1;
                        return new Token(OPERATOR, beginLine, beginColumn, ">=");
                    }
                    else if (isLetter(c)) {
                        int beginLine = linNum;
                        int beginColumn = colNum;
                        buffer.setLength(0);
                        do {
                            buffer.append((char) c);
                            c = nextChar();
                        } while (isLetter(c)||isInt(c));
                        if(isKeyword(buffer.toString())){
                            return new Token(KEYWORD, beginLine,beginColumn, buffer.toString());
                        }
                        return new Token(ID, beginLine, beginColumn, buffer.toString());

                    }
                    else if (isInt(c)) {
                        int beginLine = linNum;
                        int beginColumn = colNum;
                        buffer.setLength(0);
                        do {
                            buffer.append((char) c);
                            c = nextChar();
                        } while (isInt(c));
                        return new Token(INTEGER, beginLine, beginColumn, parseInt(buffer.toString()));
                    }


                    else if(c == '+'||c=='-'||c=='*'||c=='/'||c=='!'||c=='<'||c=='>'){
                        int beginLine = linNum;
                        int beginColumn = colNum;
                        buffer.setLength(0);
                        buffer.append((char)c);
                        StringBuilder buffer2 = new StringBuilder();
                        if(c=='/'){
                            int next = nextChar();
                            if(next=='*'){
                                do {
                                    c=nextChar();
                                    buffer2.append((char)c);
                                    //System.out.println(lastTwo(buffer2.toString()));
                                    if(c==-1){
                                        throw new LexError(linNum,colNum,"Unterminated Comment: ");
                                    }
                                }while(!lastTwo(buffer2.toString()).equals("*/"));
                            }if(next=='/'){
                                do{
                                    c = nextChar();
                                }while(c!='\n');
                                continue;
                            }
                        }


                        if(c=='>'||c=='<'||c=='!'){
                            beginColumn--;
                        }
                        return new Token(OPERATOR, beginLine, beginColumn, buffer.toString());
                    }
                    else if(c == '=' || c == ';' || c == ',' || c =='.' ||c == '(' ||c ==')'||c=='['||c==']'||c=='{'||c=='}' ){
                        int beginLine = linNum;
                        int beginColumn = colNum;
                        buffer.setLength(0);
                        buffer.append((char)c);
                        if(nextChar() == '='){
                            return new Token(OPERATOR, beginLine, beginColumn, "==");
                        }
                        return new Token(DELIMITER, beginLine, beginColumn, buffer.toString());
                    }
                    else if(c =='"'){
                        int beginLine = linNum;
                        int beginColumn = colNum;
                        buffer.setLength(0);
                        do {
                            buffer.append((char) c);
                            c = nextChar();
                            if(c=='\n' || c ==-1){
                                throw new LexError(linNum,colNum,"Unterminated String: "+buffer.toString());
                            }
                        } while (c!='"');


                        String strLit = buffer.toString()+"\"";
                        return new Token(STRLIT, beginLine, beginColumn, strLit.replace('\t', ' '));
                    }
                    else {
                        throw new LexError(linNum, colNum, "Illegal char: " + (char)c);
                    }
            }
        }
    }

    private static String lastTwo(String str){
        return str.length() > 2 ? str.substring(str.length() - 2) : str;
    }
    // Return true if c is a letter.
    //
    private static boolean isLetter(int c) {
        return (('A' <= c) && (c <= 'Z') || ('a' <= c) && (c <= 'z'));
    }
    private static boolean isInt(int c) {
        return ((48)<= c) && (c <= 57);
    }


    private static String parseInt(String toParse) throws LexError {
        try{
            int value = Integer.parseInt(toParse);
            return String.valueOf(value);
        }catch (NumberFormatException ex){
            throw new LexError(linNum, colNum, "Integer Overflow: " + toParse);
        }
    }

    private static String tokenType(int num){
        switch (num){
            case 1: return "ID";
            case 2: return "";
            case 3: return "INTLIT";
            case 4: return "";
            case 5: return "STRLIT";
        }
        return "";
    }

    private static boolean isKeyword(String key){
        return (key.equals("class") || key.equals("extends") || key.equals("static") || key.equals("public")
                || key.equals("void") || key.equals("int") || key.equals("boolean") || key.equals("new")
                || key.equals("if") || key.equals("else") || key.equals("while") || key.equals("return")
                || key.equals("main") || key.equals("true") || key.equals("false") || key.equals("String")
                || key.equals("System") || key.equals("out") || key.equals("println") || key.equals("this") );
    }
}
