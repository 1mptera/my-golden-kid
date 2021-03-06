package repositories;

import models.Post;

import java.util.ArrayList;
import java.util.List;

public class PostRepository {
  private final List<Post> posts;

  public PostRepository() {
    posts = new ArrayList<>();
    List.of(
        new Post("봄이엄마", "1234", "오늘 메뉴 짱이예요", "봄이랑 정말 맛있게 먹은 메뉴!! 부럽죠? ㅎㅎ", "2022-05-20T00:03:53.332"),
        new Post("봄이아빠", "2345", "봄이네 식구 행복한 한끼얌얌!", "아이 생일상을 한끼얌얌으로 챙겨줬어요", "2022-06-20T09:12:15.221")
    );
  }

  public void addPost(String identifier, String password, String title, String text, String time) {
    posts.add(
        new Post(identifier, password, title, text, time)
    );
  }

  public int postsSize() {
    return posts.size();
  }

  public Post showPost(int index) {
    return posts.get(index);
  }

  public String showIdentifier(int index) {
    return posts.get(index).identifier();
  }

  public String showPassword(int index) {
    return posts.get(index).password();
  }

  public String showTitle(int index) {
    return posts.get(index).title();
  }

  public String showText(int index) {
    return posts.get(index).text();
  }

  public String time(int index) {
    return posts.get(index).time();
  }

  public void deletePost(Post post) {
    posts.remove(post);
  }

  // TODO: 수정버튼 구현
  public void modifyPost(Post post) {
    // 선택의 시간
    // 1. 받은 포스팅 원래 리스트를 삭제하고, 입력한 값을 새로운 리스트로 해서 추가한다. posts.remove(post);
    // 2. 수정한 내용을, 내 원래 포스팅 1개의 고유값을 통해 찾아서 내용을 치환해준다.

    //두번째 선택
    // 1. 얘를 찾는 작업이 먼저
    // 2. 찾은 post에서 변한 값을 치환(또는 그게 귀찮으면 모든 항목을 다 치환해버림)

    for (int i = 0; i < posts.size(); i += 1) {
      if (posts.get(i).time().equals(post.time())) {
        posts.set(i, post);
      }
    }
  }
}
