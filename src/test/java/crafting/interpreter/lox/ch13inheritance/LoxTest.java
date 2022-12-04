package crafting.interpreter.lox.ch13inheritance;


import org.junit.Test;

public class LoxTest {

  @Test
  public void testInheritedMethod() {
    //bind to the right scope
    String prog = "class Doughnut {\n" +
        "  cook() {\n" +
        "    print \"Fry until golden brown.\";\n" +
        "  }\n" +
        "}\n" +
        "\n" +
        "class BostonCream < Doughnut {}\n" +
        "\n" +
        "BostonCream().cook();";
    Lox.run(prog);
  }

  @Test
  public void testCallSuper() {
    //bind to the right scope
    String prog = "class Doughnut {\n" +
        "  cook() {\n" +
        "    print \"Fry until golden brown.\";\n" +
        "  }\n" +
        "}\n" +
        "\n" +
        "class BostonCream < Doughnut {\n" +
        "  cook() {\n" +
        "    super.cook();\n" +
        "    print \"Pipe full of custard and coat with chocolate.\";\n" +
        "  }\n" +
        "}\n" +
        "\n" +
        "BostonCream().cook();";
    Lox.run(prog);
  }

  @Test
  public void testCallSuper2() {
    //bind to the right scope
    String prog = "class A {\n" +
        "    method() {\n" +
        "      print \"A method\";\n" +
        "    }\n" +
        "  }\n" +
        "\n" +
        "  class B < A {\n" +
        "    method() {\n" +
        "      print \"B method\";\n" +
        "    }\n" +
        "\n" +
        "    test() {\n" +
        "      super.method();\n" +
        "    }\n" +
        "  }\n" +
        "\n" +
        "  class C < B {}\n" +
        "\n" +
        "  C().test();";
    Lox.run(prog);
  }

  @Test
  public void testInvalidSuper() {
    String prog = "class Eclair {\n" +
        "  cook() {\n" +
        "    super.cook();\n" +
        "    print \"Pipe full of crème pâtissière.\";\n" +
        "  }\n" +
        "}";
    Lox.run(prog);
  }

  @Test
  public void testInvalidSuper2() {
    String prog = "super.notEvenInAClass();";
    Lox.run(prog);
  }
}
