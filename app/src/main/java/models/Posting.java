package models;

public class Posting {
  private String identifier;
  private int password;
  private String title;
  private String text;

  public Posting(String identifier, int password, String title, String text) {
    this.identifier = identifier;
    this.password = password;
    this.title = title;
    this.text = text;
  }

  public String identifier() {
    return identifier;
  }

  public int password() {
    return password;
  }

  public String title() {
    return title;
  }

  public String text() {
    return text;
  }
}
