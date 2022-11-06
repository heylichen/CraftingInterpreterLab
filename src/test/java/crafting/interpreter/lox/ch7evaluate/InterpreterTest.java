package crafting.interpreter.lox.ch7evaluate;

import org.junit.Test;

public class InterpreterTest {
  private Interpreter interpreter = new Interpreter();

  @Test
  public void testInterpret() {
    interpret("-1 * 3 + 4");
    interpret("-1 * 3 + 4 >= 2");
    interpret("-1 * 3 + 4 >= 2 == false");

  }

  private void interpret(String program) {
    System.out.println("program : " + program);
    Expr expr = Lox.parse(program);
    interpreter.interpret(expr);
  }
}