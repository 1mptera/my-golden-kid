package repositories;

import models.Posting;

import java.util.ArrayList;
import java.util.List;

public class PostingRepository {
  private final List<Posting> postings;

  public PostingRepository() {
    postings = new ArrayList<>();
    List.of(
        new Posting("봄이엄마", "1234", "오늘 메뉴 짱이예요", "봄이랑 정말 맛있게 먹은 메뉴!! 부럽죠? ㅎㅎ", "2022-05-20T00:03:53.332"),
        new Posting("봄이아빠", "2345", "봄이네 식구 행복한 한끼얌얌!", "아이 생일상을 한끼얌얌으로 챙겨줬어요", "2022-06-20T09:12:15.221")
    );
  }

  public void addPosting(String identifier, String password, String title, String text, String time) {
    postings.add(
        new Posting(identifier, password, title, text, time)
    );
  }

  public int postingsSize() {
    return postings.size();
  }

  public Posting showPost(int index) {
    return postings.get(index);
  }

  public String showIdentifier(int index) {
    return postings.get(index).identifier();
  }

  public String showPassword(int index) {
    return postings.get(index).password();
  }

  public String showTitle(int index) {
    return postings.get(index).title();
  }

  public String showText(int index) {
    return postings.get(index).text();
  }

  public String time(int index) {
    return postings.get(index).time();
  }

  public void deletePosting(Posting posting) {
    postings.remove(posting);
  }

  // TODO: 수정버튼 구현
  public void modifyPosting(Posting posting) {
    postings.remove(posting);
  }


}
