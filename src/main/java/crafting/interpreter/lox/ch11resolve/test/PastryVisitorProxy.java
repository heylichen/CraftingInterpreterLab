package crafting.interpreter.lox.ch11resolve.test;

import java.util.Map;

public class PastryVisitorProxy implements PastryVisitor {
  //Class, PastryVisitor configured, injected
  private Map<Class, PastryVisitor> instanceMap;

  @Override
  public void visit(Pastry p) {
    PastryVisitor visitor = instanceMap.get(p.getClass());
    visitor.visit(p);
  }
}
