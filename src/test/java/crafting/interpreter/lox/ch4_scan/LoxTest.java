package crafting.interpreter.lox.ch4_scan;

import org.junit.Assert;
import org.junit.Test;

public class LoxTest {

  @Test
  public void testSingleChar() {
    String a = " (){},.-+*;";
    boolean hasError = Lox.runString(a);
    Assert.assertFalse(hasError);
  }

  @Test
  public void testError() {
    String a = "1\n b\n & ";
    boolean hasError = Lox.runString(a);
    Assert.assertTrue(hasError);
  }

  @Test
  public void test2CharOp() {
    String a = "! != = == < <= > >=  ";
    boolean hasError = Lox.runString(a);
    Assert.assertFalse(hasError);
  }

  @Test
  public void testLonger() {
    String a = "/ //asasasasas\n";
    boolean hasError = Lox.runString(a);
    Assert.assertFalse(hasError);
  }

  @Test
  public void testStringLiterals() {
    String a = "\"aaaa\nbvvvvv\"";
    boolean hasError = Lox.runString(a);
    Assert.assertFalse(hasError);
  }

  @Test
  public void testNumberLiterals() {
    String a = "1.1 1";
    boolean hasError = Lox.runString(a);
    Assert.assertFalse(hasError);
  }

  @Test
  public void testIdentifier() {
    String a = "a or b";
    boolean hasError = Lox.runString(a);
    Assert.assertFalse(hasError);
  }
}