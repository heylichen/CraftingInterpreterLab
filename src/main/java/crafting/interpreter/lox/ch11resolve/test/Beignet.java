package crafting.interpreter.lox.ch11resolve.test;

class Beignet extends Pastry {
  @Override
  void accept(PastryVisitor visitor) {
    visitor.visit(this);
  }
}