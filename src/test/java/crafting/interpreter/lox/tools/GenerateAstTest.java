package crafting.interpreter.lox.tools;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class GenerateAstTest {
  public static final String DIR_BASE = "C:\\work\\git\\heylichen\\CraftingInterpreterLab\\src\\main\\java\\crafting\\interpreter\\lox";



  @Test
  public void defineAstForParser() throws IOException {
    String outputDir = getSubDir("ch6parse");

    GenerateAst.defineAst(outputDir, "Expr",
        Arrays.asList(
            "Binary   : Expr left, Token operator, Expr right",
            "Grouping : Expr expression",
            "Literal  : Object value",
            "Unary    : Token operator, Expr right"
        ));
  }

  private String getSubDir(String dir) {
    return DIR_BASE + File.separator + dir;
  }
}