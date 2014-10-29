/* Generated By:JavaCC: Do not edit this line. mjRawGrammar.java */
import java.io.*;

public class mjRawGrammar implements mjRawGrammarConstants {
  public static void main(String [] args) {
    try {
      if (args.length == 1) {
        FileInputStream stream = new FileInputStream(args[0]);
        new mjRawGrammar(stream).Program();
        stream.close();
        System.out.println("Program's syntax is valid.");
      } else {
        System.out.println("Need a file name as command-line argument.");
      }
    } catch (TokenMgrError e) {
      System.err.println(e);
    } catch (Exception e) {
      System.err.println(e);
    }
  }

//
// PARSER SECTION ---------------------------------------------------------------
//

// Program -> {ClassDecl}
//
  static final public void Program() throws ParseException {
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 7:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      ClassDecl();
    }
    jj_consume_token(0);
  }

// ClassDecl -> "class" <ID> ["extends" <ID>] "{" {VarDecl} {MethodDecl} "}"
//
  static final public void ClassDecl() throws ParseException {
    jj_consume_token(7);
    jj_consume_token(ID);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 8:
      jj_consume_token(8);
      jj_consume_token(ID);
      break;
    default:
      jj_la1[1] = jj_gen;
      ;
    }
    jj_consume_token(53);
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 12:
      case 13:
      case ID:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_2;
      }
      VarDecl();
    }
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 10:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      MethodDecl();
    }
    jj_consume_token(54);
  }

// MethodDecl -> "public" ExtType <ID> "(" [Param {"," Param}] ")" 
//                 "{" {VarDecl} {Stmt} "}"
//            |  "public" "static" "void" "main" "(" "String" "[" "]" <ID> ")"
//                 "{" {VarDecl} {Stmt} "}" 
// 
  static final public void MethodDecl() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 10:
      jj_consume_token(10);
      ExtType();
      jj_consume_token(ID);
      jj_consume_token(49);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 12:
      case 13:
      case ID:
        Param();
        label_4:
        while (true) {
          switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
          case 47:
            ;
            break;
          default:
            jj_la1[4] = jj_gen;
            break label_4;
          }
          jj_consume_token(47);
          Param();
        }
        break;
      default:
        jj_la1[5] = jj_gen;
        ;
      }
      jj_consume_token(50);
      jj_consume_token(53);
      label_5:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 12:
        case 13:
        case ID:
          ;
          break;
        default:
          jj_la1[6] = jj_gen;
          break label_5;
        }
        VarDecl();
      }
      label_6:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 15:
        case 16:
        case 18:
        case 19:
        case 24:
        case ID:
        case 53:
          ;
          break;
        default:
          jj_la1[7] = jj_gen;
          break label_6;
        }
        Stmt();
      }
      jj_consume_token(54);
      break;
      jj_consume_token(10);
      jj_consume_token(9);
      jj_consume_token(11);
      jj_consume_token(20);
      jj_consume_token(49);
      jj_consume_token(21);
      jj_consume_token(51);
      jj_consume_token(52);
      jj_consume_token(ID);
      jj_consume_token(50);
      jj_consume_token(53);
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 12:
        case 13:
        case ID:
          ;
          break;
        default:
          jj_la1[8] = jj_gen;
          break label_7;
        }
        VarDecl();
      }
      label_8:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 15:
        case 16:
        case 18:
        case 19:
        case 24:
        case ID:
        case 53:
          ;
          break;
        default:
          jj_la1[9] = jj_gen;
          break label_8;
        }
        Stmt();
      }
      jj_consume_token(54);
      break;
    default:
      jj_la1[10] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// Param -> Type <ID> 
//
  static final public void Param() throws ParseException {
    Type();
    jj_consume_token(ID);
  }

// VarDecl -> Type <ID> ["=" InitExpr] ";"
//  
  static final public void VarDecl() throws ParseException {
    Type();
    jj_consume_token(ID);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 45:
      jj_consume_token(45);
      InitExpr();
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
    jj_consume_token(46);
  }

// ExtType -> Type | "void"
//
  static final public void ExtType() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 12:
    case 13:
    case ID:
      Type();
      break;
    case 11:
      jj_consume_token(11);
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// Type -> BasicType 
//      |  BasicType "[" "]" 
//      |  <ID>
//
  static final public void Type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 12:
    case 13:
      BasicType();
      break;
      BasicType();
      jj_consume_token(51);
      jj_consume_token(52);
      break;
    case ID:
      jj_consume_token(ID);
      break;
    default:
      jj_la1[13] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// BasicType -> "int" | "boolean"
//
  static final public void BasicType() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 12:
      jj_consume_token(12);
      break;
    case 13:
      jj_consume_token(13);
      break;
    default:
      jj_la1[14] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// Stmt -> "{" {Stmt} "}"
//      |  ExtId "(" [Args] ")" ";"
//      |  Lvalue "=" InitExpr ";"
//      |  "if" "(" Expr ")" Stmt ["else" Stmt]
//      |  "while" "(" Expr ")" Stmt
//      |  "System" "." "out" "." "println" "(" [PrintArg] ")" ";"
//      |  "return" [Expr] ";"
//
  static final public void Stmt() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 53:
      jj_consume_token(53);
      label_9:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 15:
        case 16:
        case 18:
        case 19:
        case 24:
        case ID:
        case 53:
          ;
          break;
        default:
          jj_la1[15] = jj_gen;
          break label_9;
        }
        Stmt();
      }
      jj_consume_token(54);
      break;
    case 15:
    case ID:
      ExtId();
      jj_consume_token(49);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 15:
      case 22:
      case 23:
      case INTLIT:
      case ID:
      case 33:
      case 38:
      case 49:
        Args();
        break;
      default:
        jj_la1[16] = jj_gen;
        ;
      }
      jj_consume_token(50);
      jj_consume_token(46);
      break;
      Lvalue();
      jj_consume_token(45);
      InitExpr();
      jj_consume_token(46);
      break;
    case 16:
      jj_consume_token(16);
      jj_consume_token(49);
      Expr();
      jj_consume_token(50);
      Stmt();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 17:
        jj_consume_token(17);
        Stmt();
        break;
      default:
        jj_la1[17] = jj_gen;
        ;
      }
      break;
    case 18:
      jj_consume_token(18);
      jj_consume_token(49);
      Expr();
      jj_consume_token(50);
      Stmt();
      break;
    case 24:
      jj_consume_token(24);
      jj_consume_token(48);
      jj_consume_token(25);
      jj_consume_token(48);
      jj_consume_token(26);
      jj_consume_token(49);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 15:
      case 22:
      case 23:
      case INTLIT:
      case STRLIT:
      case ID:
      case 33:
      case 38:
      case 49:
        PrintArg();
        break;
      default:
        jj_la1[18] = jj_gen;
        ;
      }
      jj_consume_token(50);
      jj_consume_token(46);
      break;
    case 19:
      jj_consume_token(19);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 15:
      case 22:
      case 23:
      case INTLIT:
      case ID:
      case 33:
      case 38:
      case 49:
        Expr();
        break;
      default:
        jj_la1[19] = jj_gen;
        ;
      }
      jj_consume_token(46);
      break;
    default:
      jj_la1[20] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// Args -> Expr {"," Expr}
//
  static final public void Args() throws ParseException {
    Expr();
    label_10:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 47:
        ;
        break;
      default:
        jj_la1[21] = jj_gen;
        break label_10;
      }
      jj_consume_token(47);
      Expr();
    }
  }

// PrintArg -> Expr | <STRLIT>
//
  static final public void PrintArg() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 15:
    case 22:
    case 23:
    case INTLIT:
    case ID:
    case 33:
    case 38:
    case 49:
      Expr();
      break;
    case STRLIT:
      jj_consume_token(STRLIT);
      break;
    default:
      jj_la1[22] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// InitExpr -> "new" BasicType "[" <INTLIT> "]" 
//          |  "new" <ID> "(" ")"
//          |  Expr 
//
  static final public void InitExpr() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 14:
      jj_consume_token(14);
      BasicType();
      jj_consume_token(51);
      jj_consume_token(INTLIT);
      jj_consume_token(52);
      break;
      jj_consume_token(14);
      jj_consume_token(ID);
      jj_consume_token(49);
      jj_consume_token(50);
      break;
    case 15:
    case 22:
    case 23:
    case INTLIT:
    case ID:
    case 33:
    case 38:
    case 49:
      Expr();
      break;
    default:
      jj_la1[23] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// Expr -> Expr BinOp Expr 
//      |  UnOp Expr
//      |  "(" Expr ")" 
//      |  ExtId "(" [Args] ")"
//      |  Lvalue
//      |  Literal
//
  static final public void Expr() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 33:
    case 38:
      UnOp();
      Expr();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 55:
        jj_consume_token(55);
        Expr();
        break;
      default:
        jj_la1[24] = jj_gen;
        ;
      }
      break;
    case 49:
      jj_consume_token(49);
      Expr();
      jj_consume_token(50);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 55:
        jj_consume_token(55);
        Expr();
        break;
      default:
        jj_la1[25] = jj_gen;
        ;
      }
      break;
    case 15:
    case ID:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 15:
        jj_consume_token(15);
        jj_consume_token(48);
        break;
      default:
        jj_la1[26] = jj_gen;
        ;
      }
      jj_consume_token(ID);
      label_11:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 48:
          ;
          break;
        default:
          jj_la1[27] = jj_gen;
          break label_11;
        }
        jj_consume_token(48);
        jj_consume_token(ID);
      }
      ending();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 55:
        jj_consume_token(55);
        Expr();
        break;
      default:
        jj_la1[28] = jj_gen;
        ;
      }
      break;
    case 22:
    case 23:
    case INTLIT:
      Literal();
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 55:
        jj_consume_token(55);
        Expr();
        break;
      default:
        jj_la1[29] = jj_gen;
        ;
      }
      break;
    default:
      jj_la1[30] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void ending() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 49:
    case 51:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 49:
        jj_consume_token(49);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 15:
        case 22:
        case 23:
        case INTLIT:
        case ID:
        case 33:
        case 38:
        case 49:
          Args();
          break;
        default:
          jj_la1[31] = jj_gen;
          ;
        }
        jj_consume_token(50);
        break;
      case 51:
        jj_consume_token(51);
        Expr();
        jj_consume_token(52);
        break;
      default:
        jj_la1[32] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[33] = jj_gen;
      ;
    }
  }

// Lvalue -> ExtId "[" Expr "]"
//        |  ExtId 
  static final public void Lvalue() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 15:
      jj_consume_token(15);
      jj_consume_token(48);
      break;
    default:
      jj_la1[34] = jj_gen;
      ;
    }
    jj_consume_token(ID);
    label_12:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 48:
        ;
        break;
      default:
        jj_la1[35] = jj_gen;
        break label_12;
      }
      jj_consume_token(48);
      jj_consume_token(ID);
    }
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 51:
      jj_consume_token(51);
      Expr();
      jj_consume_token(52);
      break;
    default:
      jj_la1[36] = jj_gen;
      ;
    }
  }

// ExtId -> ["this" "."] <ID> {"." <ID>} 
//
  static final public void ExtId() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 15:
      jj_consume_token(15);
      jj_consume_token(48);
      break;
    default:
      jj_la1[37] = jj_gen;
      ;
    }
    jj_consume_token(ID);
    label_13:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 48:
        ;
        break;
      default:
        jj_la1[38] = jj_gen;
        break label_13;
      }
      jj_consume_token(48);
      jj_consume_token(ID);
    }
  }

// Literal -> <INTLIT> | "true" | "false"
//
  static final public void Literal() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTLIT:
      jj_consume_token(INTLIT);
      break;
    case 22:
      jj_consume_token(22);
      break;
    case 23:
      jj_consume_token(23);
      break;
    default:
      jj_la1[39] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// BinOp -> "+" | "-" | "*" | "/" | "&&" | "||" 
//       |  "==" | "!=" | "<" | "<=" | ">" | ">=" 
//
  static final public void BinOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 32:
      jj_consume_token(32);
      break;
    case 33:
      jj_consume_token(33);
      break;
    case 34:
      jj_consume_token(34);
      break;
    case 35:
      jj_consume_token(35);
      break;
    case 36:
      jj_consume_token(36);
      break;
    case 37:
      jj_consume_token(37);
      break;
    case 39:
      jj_consume_token(39);
      break;
    case 40:
      jj_consume_token(40);
      break;
    case 41:
      jj_consume_token(41);
      break;
    case 42:
      jj_consume_token(42);
      break;
    case 43:
      jj_consume_token(43);
      break;
    case 44:
      jj_consume_token(44);
      break;
    default:
      jj_la1[40] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

// UnOp -> "-" | "!"
//
  static final public void UnOp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 33:
      jj_consume_token(33);
      break;
    case 38:
      jj_consume_token(38);
      break;
    default:
      jj_la1[41] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public mjRawGrammarTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[42];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x80,0x100,0x80003000,0x400,0x0,0x80003000,0x80003000,0x810d8000,0x80003000,0x810d8000,0x400,0x0,0x80003800,0x80003000,0x3000,0x810d8000,0xa0c08000,0x20000,0xe0c08000,0xa0c08000,0x810d8000,0x0,0xe0c08000,0xa0c0c000,0x0,0x0,0x8000,0x0,0x0,0x0,0xa0c08000,0xa0c08000,0x0,0x0,0x8000,0x0,0x0,0x8000,0x0,0x20c00000,0x0,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0x0,0x8000,0x0,0x0,0x200000,0x0,0x200000,0x0,0x2000,0x0,0x0,0x0,0x200000,0x20042,0x0,0x20042,0x20042,0x200000,0x8000,0x20042,0x20042,0x800000,0x800000,0x0,0x10000,0x800000,0x800000,0x20042,0x20042,0xa0000,0xa0000,0x0,0x10000,0x80000,0x0,0x10000,0x0,0x1fbf,0x42,};
   }

  /** Constructor with InputStream. */
  public mjRawGrammar(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public mjRawGrammar(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new mjRawGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 42; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 42; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public mjRawGrammar(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new mjRawGrammarTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 42; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 42; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public mjRawGrammar(mjRawGrammarTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 42; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(mjRawGrammarTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 42; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[56];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 42; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 56; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
