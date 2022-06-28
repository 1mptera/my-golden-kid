package models;

public class Posting {
  private String writer;
  private int password;
  private String text;

  public Posting(String writer, int password, String text) {
    this.writer = writer;
    this.password = password;
    this.text = text;
  }

  public String writer() {
    return writer;
  }

  public int password() {
    return password;
  }

  public String text() {
    return text;
  }
}
