package crafting.interpreter.lox.ch11resolve.test;

class Cruller extends Pastry {
  @Override
  void accept(PastryVisitor visitor) {
    visitor.visit(this);
  }
}