package crafting.interpreter.lox.ch9controlflow;

import org.junit.Test;

public class LoxTest {
  @Test
  public void testStatements() {
    String prog = "print \"hi\" or 2; // \"hi\".\n" +
        "print nil or \"yes\"; // \"yes\"." ;
    Lox.run(prog);
  }

  @Test
  public void testWhile() {
    String prog = "var a = 1;\n" +
        "while(a<10){\n" +
        "  a=a+1;\n" +
        "}\n" +
        "print a;" ;
    Lox.run(prog);
  }

  @Test
  public void testFor() {
    String prog = "var a = 0;\n" +
        "var temp;\n" +
        "\n" +
        "for (var b = 1; a < 10000; b = temp + b) {\n" +
        "  print a;\n" +
        "  temp = a;\n" +
        "  a = b;\n" +
        "}" ;
    Lox.run(prog);
  }
}