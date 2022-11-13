package crafting.interpreter.lox.ch11resolve;

import java.util.List;

interface LoxCallable {
  int arity();

  Object call(Interpreter interpreter, List<Object> arguments);
}