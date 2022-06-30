package panels;

import popups.DetailsPopUp;
import repositories.PostRepository;

import javax.swing.*;
import java.awt.*;

public class BulletinBoardPanel extends JPanel {
  private PostRepository postRepository;

  public BulletinBoardPanel(PostRepository postRepository) {
    this.postRepository = postRepository;

    this.setLayout(new GridLayout(postRepository.postsSize() + 1, 1));

    initHeadline();

    initPostListsSection();
  }

  public void initHeadline() {
    JLabel headline = new JLabel("오늘의 식단 자랑하기");
    this.add(headline);
  }

  public void initPostListsSection() {
    for (int i = postRepository.postsSize() - 1; i >= 0; i -= 1) {
      if (postRepository.showIdentifier(i).isBlank() ||
          postRepository.showPassword(i).isBlank() ||
          postRepository.showTitle(i).isBlank() ||
          postRepository.showText(i).isBlank()) {
        continue;
      }

      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout());
      JLabel identifierLabel = new JLabel("작성자: " + postRepository.showIdentifier(i));
      JButton titleButton = new JButton(postRepository.showTitle(i));
      int finalI = i;
      titleButton.addActionListener(event -> {
        DetailsPopUp detailsPopUp = new DetailsPopUp(postRepository.showPost(finalI), postRepository, this);
      });

      panel.add(identifierLabel);
      panel.add(titleButton);

      this.add(panel);
    }
  }
}
