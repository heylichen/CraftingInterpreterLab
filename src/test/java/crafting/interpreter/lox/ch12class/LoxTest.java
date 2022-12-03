package crafting.interpreter.lox.ch12class;


import org.junit.Test;

public class LoxTest {

  @Test
  public void testSimpleClass() {
    //bind to the right scope
    String prog = "class Bagel {}\n" +
        "var bagel = Bagel();\n" +
        "print bagel; // Prints \"Bagel instance\".";
    Lox.run(prog);
  }

  @Test
  public void testGetSet() {
    //bind to the right scope
    String prog = "class Bagel {}\n" +
        "var bagel = Bagel();\n" +
        "bagel.name=\"hello\";\n" +
        "print bagel.name;";
    Lox.run(prog);
  }

  @Test
  public void testMethod() {
    String prog = "class Bacon {\n" +
        "  eat() {\n" +
        "    print \"Crunch crunch crunch!\";\n" +
        "  }\n" +
        "}\n" +
        "\n" +
        "Bacon().eat(); // Prints \"Crunch crunch crunch!\".";
    Lox.run(prog);
  }

  @Test
  public void testThis() {
    String prog = "class Cake {\n" +
        "  taste() {\n" +
        "    var adjective = \"delicious\";\n" +
        "    print \"The \" + this.flavor + \" cake is \" + adjective + \"!\";\n" +
        "  }\n" +
        "}\n" +
        "\n" +
        "var cake = Cake();\n" +
        "cake.flavor = \"German chocolate\";\n" +
        "cake.taste(); // Prints \"The German chocolate cake is delicious!\".";
    Lox.run(prog);
  }

  @Test
  public void testInit() {
    String prog = "class Cake {\n" +
        "  init() {\n" +
        "    print \"initializing!\";\n" +
        "  }\n" +
        "\n" +
        "  taste() {\n" +
        "    var adjective = \"delicious\";\n" +
        "    print \"The \" + this.flavor + \" cake is \" + adjective + \"!\";\n" +
        "  }\n" +
        "}\n" +
        "\n" +
        "var cake = Cake();\n" +
        "cake.flavor = \"German chocolate\";\n" +
        "cake.taste(); // Prints \"The German chocolate cake is delicious!\".";
    Lox.run(prog);
  }
}
