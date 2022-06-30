package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostTest {
  @Test
  void creation() {
    // 게시글(포스팅) 모델은 무엇을 포함해야 할까?
    // 작성자(id), 패스워드(이름과 결합하여 고유키값으로 활용 가능), 게시글 제목, 내용
    // 게시글 내용은 굉장히 길텐데.. 글 내용이 포함되는 것이 맞을까?
    // 이 포스팅 모델이 가장 핵심이 되는 내용. 누구에게도 방해받지 않는.

    Post post = new Post("봄이엄마", "1234", "오늘메뉴", "아이고 어려워라~", "2022-06-20T09:12:15.221");

    assertEquals("봄이엄마", post.identifier());
    assertEquals("1234", post.password());
    assertEquals("오늘메뉴", post.title());
    assertEquals("아이고 어려워라~", post.text());
  }
}
