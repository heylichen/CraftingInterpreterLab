package crafting.interpreter.lox.common;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Token {
  final TokenType type;
  //original lexeme text. eg, a string "Hello"
  final String lexeme;
  //parsed value. eg, Hello
  final Object literal;
  final int line;

  public Token(TokenType type, String lexeme, Object literal, int line) {
    this.type = type;
    this.lexeme = lexeme;
    this.literal = literal;
    this.line = line;
  }

  public String toString() {
    return type + " " + lexeme + " " + literal;
  }
}