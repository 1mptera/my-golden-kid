package models;

public class Posting {
  private String identifier;
  private String password;
  private String title;
  private String text;

  public Posting(String identifier, String password, String title, String text) {
    this.identifier = identifier;
    this.password = password;
    this.title = title;
    this.text = text;
  }

  public String identifier() {
    return this.identifier;
  }

  public String password() {
    return this.password;
  }

  public String title() {
    return this.title;
  }

  public String text() {
    return this.text;
  }
}
