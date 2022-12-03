package crafting.interpreter.lox.tools;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class GenerateCh12AstTest {
  public static final String DIR_BASE = "C:\\work\\git\\heylichen\\CraftingInterpreterLab\\src\\main\\java\\crafting\\interpreter\\lox";


  @Test
  public void defineAst() throws IOException {
    String outputDir = getSubDir("ch12class");
    //add IDENTIFIER in primary
    /**
     * expression     → assignment ;
     * assignment     → IDENTIFIER "=" assignment
     *                | logic_or ;
     * logic_or       → logic_and ( "or" logic_and )* ;
     * logic_and      → equality ( "and" equality )* ;
     * equality       → comparison ( ( "!=" | "==" ) comparison )* ;
     * comparison     → term ( ( ">" | ">=" | "<" | "<=" ) term )* ;
     * term           → factor ( ( "-" | "+" ) factor )* ;
     * factor         → unary ( ( "/" | "*" ) unary )* ;
     * unary          → ( "!" | "-" ) unary | call ;
     * call           → primary ( "(" arguments? ")" )* ;
     * arguments      → expression ( "," expression )* ;
     * primary        → NUMBER | STRING
     *                  | "true" | "false" | "nil"
     *                  | "(" expression ")"
     *                  | IDENTIFIER ;
     */
    GenerateAst.defineAst(outputDir, "Expr",
        Arrays.asList(
            "Assign   : Token name, Expr value",
            "Binary   : Expr left, Token operator, Expr right",
            "Call     : Expr callee, Token paren, List<Expr> arguments",
            "Get      : Expr object, Token name",
            "Grouping : Expr expression",
            "Literal  : Object value",
            "Logical  : Expr left, Token operator, Expr right",
            "Set      : Expr object, Token name, Expr value",
            "This     : Token keyword",
            "Unary    : Token operator, Expr right",
            "Variable : Token name"
        ));

    // add program
    /**
     * program        → declaration* EOF ;
     *
     * declaration    → classDecl
     *                | varDecl
     *                | statement
     *                | funDecl;
     * classDecl    → "class" IDENTIFIER "{" function* "}";
     *
     * funDecl        → "fun" function ;
     * function       → IDENTIFIER "(" parameters? ")" block ;
     * parameters     → IDENTIFIER ( "," IDENTIFIER )* ;
     *
     * varDecl        → "var" IDENTIFIER ( "=" expression )? ";" ;
     *
     * statement      → exprStmt
     *                | ifStmt
     *                | printStmt
     *                | whileStmt
     *                | block
     *                | forStmt;
     *                | returnStmt
     *
     * returnStmt     → "return" expression? ";" ;
     *
     * whileStmt      → "while" "(" expression ")" statement ;
     *
     * block          → "{" declaration* "}" ;
     *
     * ifStmt         → "if" "(" expression ")" statement
     *                ( "else" statement )? ;
     *
     * forStmt        → "for" "(" ( varDecl | exprStmt | ";" )
     *                  expression? ";"
     *                  expression? ")" statement ;
     */
    GenerateAst.defineAst(outputDir, "Stmt",
        Arrays.asList(
            "Block      : List<Stmt> statements",
            "Expression : Expr expression",
            "Function   : Token name, List<Token> params," +
                " List<Stmt> body",
            "Print      : Expr expression",
            "Var        : Token name, Expr initializer",
            "If         : Expr condition, Stmt thenBranch," +
                " Stmt elseBranch",
            "While      : Expr condition, Stmt body",
            "Return     : Token keyword, Expr value",
            "Class      : Token name, List<Stmt.Function> methods"
        ));

  }

  private String getSubDir(String dir) {
    return DIR_BASE + File.separator + dir;
  }
}