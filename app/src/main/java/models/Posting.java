package models;

public class Posting {
  private String identifier;
  private String password;
  private String title;
  private String text;
  private String time;

  public Posting(String identifier, String password, String title, String text, String time) {
    this.identifier = identifier;
    this.password = password;
    this.title = title;
    this.text = text;
    this.time = time;
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

  public String time() {
    return this.time;
  }
}
