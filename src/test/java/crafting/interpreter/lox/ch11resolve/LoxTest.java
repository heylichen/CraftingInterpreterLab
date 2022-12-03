package crafting.interpreter.lox.ch11resolve;

import org.junit.Test;

public class LoxTest {

  @Test
  public void testClosure() {
    //bind to the right scope
    String prog = "var a = \"global\";\n" +
        "{\n" +
        "  fun showA() {\n" +
        "    print a;\n" +
        "  }\n" +
        "\n" +
        "  showA();\n" +
        "  var a = \"block\";\n" +
        "  showA();\n" +
        "}";
    Lox.run(prog);
  }

  @Test
  public void testClosure2() {
    // if the variable changes, reflect immediately,
    // the same behavior as java, see the next test case
    String prog = "var a = \"global\";\n" +
        "{\n" +
        "  fun showA() {\n" +
        "    print a;\n" +
        "  }\n" +
        "\n" +
        "  showA();\n" +
        "  a = \"global changed\";\n" +
        "  showA();\n" +
        "}";
    Lox.run(prog);
  }

  private String a = "global";

  String f() {
    System.out.println(a);
    return a;
  }

  @Test
  public void testJavaBehavior() {
    f();
    {
      a = "changed";
    }
    f();
  }

  @Test
  public void testResolver1() {
    String prog = "var a = 1;\n" +
        "print a + 1;";
    Lox.run(prog);
  }
}