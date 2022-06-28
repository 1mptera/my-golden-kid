package repositories;

import models.Posting;

import java.util.ArrayList;
import java.util.List;

public class PostingRepository {
  private List<Posting> postings = new ArrayList<>();
  private List<String> identifiers = new ArrayList<>();
  private List<String> passwords = new ArrayList<>();
  private List<String> titles = new ArrayList<>();
  private List<String> contents = new ArrayList<>();

  public PostingRepository() {
    List.of(
      new Posting("봄이엄마", "1234", "오늘 메뉴 짱이예요", "봄이랑 정말 맛있게 먹은 메뉴!! 부럽죠? ㅎㅎ"),
      new Posting("봄이아빠", "2345", "봄이네 식구 행복한 한끼얌얌!", "아이 생일상을 한끼얌얌으로 챙겨줬어요")
    ).stream().forEach(post -> {
      postings.add(post);
    });
  }

//
//  public Posting find(String identifier) {
//    return postings.stream()
//        .filter(id -> id.identifier().equals(identifier))
//        .findFirst()
//        .get();
//  }

  public void getIdentifier(String identifier) {
    identifiers.add(identifier);
  }

  public void getPassword(String password) {
    passwords.add(password);
  }

  public void getTitle(String title) {
    titles.add(title);
  }

  public void getContent(String content) {
    contents.add(content);
  }
}
