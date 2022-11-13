package crafting.interpreter.lox.ch11resolve;

import crafting.interpreter.lox.common.Token;

import java.util.HashMap;
import java.util.Map;

public class Environment {
  private final Map<String, Object> values = new HashMap<>();
  private final Environment enclosing;

  public Environment() {
    enclosing = null;
  }

  public Environment(Environment enclosing) {
    this.enclosing = enclosing;
  }

  void define(String name, Object value) {
    values.put(name, value);
  }

  Object get(Token name) {
    if (values.containsKey(name.getLexeme())) {
      return values.get(name.getLexeme());
    }

    if (enclosing != null) return enclosing.get(name);

    throw new Interpreter.RuntimeError(name,
        "Undefined variable '" + name.getLexeme() + "'.");
  }

  void assign(Token name, Object value) {
    if (values.containsKey(name.getLexeme())) {
      values.put(name.getLexeme(), value);
      return;
    }

    if (enclosing != null) {
      enclosing.assign(name, value);
      return;
    }

    throw new Interpreter.RuntimeError(name,
        "Undefined variable '" + name.getLexeme() + "'.");
  }

  Object getAt(int distance, String name) {
    return ancestor(distance).values.get(name);
  }

  Environment ancestor(int distance) {
    Environment environment = this;
    for (int i = 0; i < distance; i++) {
      environment = environment.enclosing;
    }

    return environment;
  }

  void assignAt(int distance, Token name, Object value) {
    ancestor(distance).values.put(name.getLexeme(), value);
  }
}
