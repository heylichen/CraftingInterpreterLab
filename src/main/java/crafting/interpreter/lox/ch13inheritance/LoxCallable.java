package crafting.interpreter.lox.ch13inheritance;

import java.util.List;

interface LoxCallable {
  int arity();

  Object call(Interpreter interpreter, List<Object> arguments);
}