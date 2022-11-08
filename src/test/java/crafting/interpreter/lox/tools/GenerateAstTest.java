package crafting.interpreter.lox.tools;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class GenerateAstTest {
  public static final String DIR_BASE = "C:\\work\\git\\heylichen\\CraftingInterpreterLab\\src\\main\\java\\crafting\\interpreter\\lox";


  @Test
  public void defineAstForCh6Parser() throws IOException {
    String outputDir = getSubDir("ch6parse");

    GenerateAst.defineAst(outputDir, "Expr",
        Arrays.asList(
            "Binary   : Expr left, Token operator, Expr right",
            "Grouping : Expr expression",
            "Literal  : Object value",
            "Unary    : Token operator, Expr right"
        ));
  }

  @Test
  public void defineAstForCh8Statement() throws IOException {
    String outputDir = getSubDir("ch8Statement");
    //add IDENTIFIER in primary
    /**
     * expression     → assignment ;
     * assignment     → IDENTIFIER "=" assignment
     *                | equality ;
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
     *                | printStmt
     *                | block ;
     *
     * block          → "{" declaration* "}" ;
     */
    GenerateAst.defineAst(outputDir, "Stmt",
        Arrays.asList(
            "Block      : List<Stmt> statements",
            "Expression : Expr expression",
            "Print      : Expr expression",
            "Var        : Token name, Expr initializer"
        ));
  }

  private String getSubDir(String dir) {
    return DIR_BASE + File.separator + dir;
  }
}