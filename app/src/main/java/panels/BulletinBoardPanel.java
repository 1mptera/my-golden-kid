package panels;

import repositories.PostingRepository;

import javax.swing.*;
import java.awt.*;

public class BulletinBoardPanel extends JPanel {
  private PostingRepository postingRepository;

  public BulletinBoardPanel(PostingRepository postingRepository) {
    this.postingRepository = postingRepository;

    this.setLayout(new GridLayout(postingRepository.postingsSize() + 1, 1));

     // 헤드라인
    initHeadline();

    // 게시판 글 누적 섹션
    initPostingListsSection();
  }

  public void initHeadline() {
    JLabel headline = new JLabel("오늘의 식단 자랑하기");
    this.add(headline);
  }

  // TODO: 게시판 글 누적하여 여기에 보여주기
  public void initPostingListsSection() {
    for (int i = postingRepository.postingsSize() - 1; i >= 0; i -= 1) {
      JLabel post1 = new JLabel(postingRepository.showTitle(i));
      this.add(post1);
    }
  }
}
