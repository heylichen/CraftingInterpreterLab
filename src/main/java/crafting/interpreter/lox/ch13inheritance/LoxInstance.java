package crafting.interpreter.lox.ch13inheritance;

import crafting.interpreter.lox.common.Token;

import java.util.HashMap;
import java.util.Map;

class LoxInstance {
  private LoxClass klass;
  private final Map<String, Object> fields = new HashMap<>();

  LoxInstance(LoxClass klass) {
    this.klass = klass;
  }

  Object get(Token name) {
    if (fields.containsKey(name.getLexeme())) {
      return fields.get(name.getLexeme());
    }

    LoxFunction method = klass.findMethod(name.getLexeme());
    if (method != null) return method.bind(this);

    throw new Interpreter.RuntimeError(name, "Undefined property '" + name.getLexeme() + "'.");
  }

  void set(Token name, Object value) {
    fields.put(name.getLexeme(), value);
  }

  @Override
  public String toString() {
    return klass.name + " instance";
  }
}