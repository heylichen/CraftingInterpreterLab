package crafting.interpreter.lox.ch8Statement;

import org.junit.Test;

public class LoxTest {

  @Test
  public void testStatements() {
    String prog = "print \"one\";\n" +
        "print true;\n" +
        "print 2 + 1;";
    Lox.run(prog);
  }

  @Test
  public void testGlobalVariable() {
    String prog = "var a = 1;\n" +
        "var b = 2;\n" +
        "print a + b;";
    Lox.run(prog);
  }

  @Test
  public void testScope() {
    String prog = "var a = \"global a\";\n" +
        "var b = \"global b\";\n" +
        "var c = \"global c\";\n" +
        "{\n" +
        "  var a = \"outer a\";\n" +
        "  var b = \"outer b\";\n" +
        "  {\n" +
        "    var a = \"inner a\";\n" +
        "    print a;\n" +
        "    print b;\n" +
        "    print c;\n" +
        "  }\n" +
        "  print a;\n" +
        "  print b;\n" +
        "  print c;\n" +
        "}\n" +
        "print a;\n" +
        "print b;\n" +
        "print c;";
    Lox.run(prog);
  }
}