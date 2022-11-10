package crafting.interpreter.lox.ch9controlflow;

public class AstDotPrintVisitor implements Expr.Visitor<String> {
  private DotCache dotCache;
  private int nodeId = 0;

  public String toDot(Expr expr) {
    init();
    addToDot(expr);
    return dotCache.toString();
  }

  private void init() {
    this.dotCache = new DotCache();
    nodeId = 0;
  }

  @Override
  public String visitVariableExpr(Expr.Variable expr) {
    String nodeId = addNode("Identifier: " + expr.name.getLexeme(),true);
    return nodeId;
  }

  @Override
  public String visitAssignExpr(Expr.Assign expr) {
    String childNode = addToDot(expr.value);
    String nodeId = addNode("BinaryExpr\\nop: " + expr.name.getLexeme(),false);
    addEdge(nodeId, childNode);
    return nodeId;
  }

  @Override
  public String visitLogicalExpr(Expr.Logical expr) {
    String leftNodeId = addToDot(expr.left);
    String rightNodeId = addToDot(expr.right);

    String nodeId = addNode("LogicalExpr\\nop: " + expr.operator.getLexeme(),false);
    addEdge(nodeId, leftNodeId, rightNodeId);
    return nodeId;
  }

  /**
   * convert Expr and add to dot
   * @param expr
   * @return nodeId of the root node in Expr.
   */
  private String addToDot(Expr expr) {
    return expr.accept(this);
  }

  public String toString() {
    return dotCache.toString();
  }

  /**
   * get top node nodeId
   * @param expr
   * @return
   */
  @Override
  public String visitBinaryExpr(Expr.Binary expr) {
    String leftNodeId = addToDot(expr.left);
    String rightNodeId = addToDot(expr.right);

    String nodeId = addNode("BinaryExpr\\nop: " + expr.operator.getLexeme(),false);
    addEdge(nodeId, leftNodeId, rightNodeId);
    return nodeId;
  }

  private String addNode(String label,boolean terminal) {
    String localNodeId = "n" + String.valueOf(nodeId++);
    String exprName = newNode(localNodeId, label, terminal);
    dotCache.addNode(exprName);
    return localNodeId;
  }

  private void addEdge(String fromNode, String... toNodes) {
    String toNodeDecl = String.join(" ", toNodes);
    String addEdgeStr = String.format("%s -> {%s}", fromNode, toNodeDecl);
    dotCache.addEdge(addEdgeStr);
  }

  private String newNode(String nodeId, String exprName, boolean terminal) {
    String style = terminal ? "filled" : "none";
    return String.format("%s [label=\"%s\" style=%s]", nodeId, exprName, style);
  }

  @Override
  public String visitGroupingExpr(Expr.Grouping expr) {
    String nodeId = addNode("GroupExpr",false);
    String left = addNode("(",true);
    String inner = addToDot(expr.expression);
    String right = addNode(")",true);
    addEdge(nodeId, left, inner, right);
    return nodeId;
  }

  @Override
  public String visitLiteralExpr(Expr.Literal expr) {
    String nodeId = addNode(expr.value.toString(),true);
    return nodeId;
  }

  @Override
  public String visitUnaryExpr(Expr.Unary expr) {
    String nodeId = addNode("UnaryExpr \\nop: " + expr.operator.getLexeme(),false);
    String innerId = addToDot(expr.right);
    addEdge(nodeId, innerId);
    return nodeId;
  }

  private static class DotCache {
    private final StringBuilder nodes = new StringBuilder();
    private final StringBuilder edges = new StringBuilder();

    public void addNode(String node) {
      nodes.append(node).append('\n');
    }

    public void addEdge(String edge) {
      edges.append(edge).append('\n');
    }

    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      sb.append("digraph G {\n" +
          "  { \n" +
          "    node [margin=0 fontcolor=black shape=box]\n");
      sb.append(nodes).append("}\n");
      sb.append(edges);
      sb.append("}");
      return sb.toString();
    }
  }
}
