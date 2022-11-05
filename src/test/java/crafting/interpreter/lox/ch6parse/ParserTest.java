package crafting.interpreter.lox.ch6parse;

import org.junit.Test;

public class ParserTest {
  private AstDotPrintVisitor dotPrinter = new AstDotPrintVisitor();

  @Test
  public void testParse1() {
    printAst("6/3-1");
    printAst("(6/3-1 + 2)");
  }

  private void printAst(String program) {
    Expr expr = Lox.parse(program);
    System.out.println(dotPrinter.toDot(expr));
  }
}