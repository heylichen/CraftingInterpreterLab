package crafting.interpreter.lox.ch10function;


import org.junit.Test;

public class LoxTest {

  @Test
  public void testVoidFunction() {
    String prog = "fun sayHi(first, last) {\n" +
        "  print \"Hi, \" + first + \" \" + last + \"!\";\n" +
        "}\n" +
        "\n" +
        "sayHi(\"Dear\", \"Reader\");";
    Lox.run(prog);
  }

  @Test
  public void testReturn() {
    String prog = "fun fib(n) {\n" +
        "  if (n <= 1) return n;\n" +
        "  return fib(n - 2) + fib(n - 1);\n" +
        "}\n" +
        "\n" +
        "for (var i = 0; i < 20; i = i + 1) {\n" +
        "  print fib(i);\n" +
        "}";
    Lox.run(prog);
  }

  @Test
  public void testClosure() {
    String prog = "fun makeCounter() {\n" +
        "  var i = 0;\n" +
        "  fun count() {\n" +
        "    i = i + 1;\n" +
        "    print i;\n" +
        "  }\n" +
        "\n" +
        "  return count;\n" +
        "}\n" +
        "\n" +
        "var counter = makeCounter();\n" +
        "counter(); // \"1\".\n" +
        "counter(); // \"2\".";
    Lox.run(prog);
  }
}