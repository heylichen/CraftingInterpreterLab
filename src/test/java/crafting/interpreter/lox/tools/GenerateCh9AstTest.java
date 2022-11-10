package crafting.interpreter.lox.tools;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class GenerateCh9AstTest {
  public static final String DIR_BASE = "C:\\work\\git\\heylichen\\CraftingInterpreterLab\\src\\main\\java\\crafting\\interpreter\\lox";


  @Test
  public void defineAst() throws IOException {
    String outputDir = getSubDir("ch9controlflow");
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
     * unary          → ( "!" | "-" ) unary
     *                  | primary ;
     * primary        → NUMBER | STRING
     *                  | "true" | "false" | "nil"
     *                  | "(" expression ")"
     *                  | IDENTIFIER ;
     */
    GenerateAst.defineAst(outputDir, "Expr",
        Arrays.asList(
            "Assign   : Token name, Expr value",
            "Binary   : Expr left, Token operator, Expr right",
            "Grouping : Expr expression",
            "Literal  : Object value",
            "Logical  : Expr left, Token operator, Expr right",
            "Unary    : Token operator, Expr right",
            "Variable : Token name"
        ));

    // add program
    /**
     * program        → declaration* EOF ;
     *
     * declaration    → varDecl
     *                | statement ;
     *
     * varDecl        → "var" IDENTIFIER ( "=" expression )? ";" ;
     *
     * statement      → exprStmt
     *                | ifStmt
     *                | printStmt
     *                | whileStmt
     *                | block
     *                | forStmt;
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
            "Print      : Expr expression",
            "Var        : Token name, Expr initializer",
            "If         : Expr condition, Stmt thenBranch," +
                        " Stmt elseBranch",
            "While      : Expr condition, Stmt body"
        ));

  }

  private String getSubDir(String dir) {
    return DIR_BASE + File.separator + dir;
  }
}