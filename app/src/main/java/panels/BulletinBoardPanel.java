package panels;

import models.Posting;
import popups.DetailsPopUp;
import repositories.PostingRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

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

      if (postingRepository.showIdentifier(i).isBlank() ||
          postingRepository.showPassword(i).isBlank() ||
          postingRepository.showTitle(i).isBlank() ||
          postingRepository.showText(i).isBlank()) {
        continue;
      }



      JPanel panel = new JPanel();
      panel.setLayout(new FlowLayout());
      JLabel identifierLabel = new JLabel(postingRepository.showIdentifier(i));
      JButton titleButton = new JButton(postingRepository.showTitle(i));
      int finalI = i;
      titleButton.addActionListener(event -> {
        DetailsPopUp detailsPopUp = new DetailsPopUp(postingRepository.showPost(finalI));
      });

      panel.add(identifierLabel);
      panel.add(titleButton);

      this.add(panel);
    }
  }
}
//      titleButton.addActionListener(event -> {
//
//      }

//      public void initWriterSection () {
//        JLabel identifier = new JLabel("작성자 id");
//        identifier.setBounds(50, 20, 50, 50);
//
//        JTextField identifierBox = new JTextField(20);
//        identifierBox.setText("안녕");
//        identifierBox.setEditable(false);
//        identifierBox.setBounds(110, 30, 150, 30);
//        panel.add(identifier);
//        panel.add(identifierBox);
//      }
//    }
//  }


//
//  public void initWriterSection() {
//    JLabel identifier = new JLabel("작성자 id");
//    identifier.setBounds(50, 20, 50, 50);
//
//    JTextField identifierBox = new JTextField(20);
//    identifierBox.setText("안녕");
//    identifierBox.setEditable(false);
//    identifierBox.setBounds(110, 30, 150, 30);
//    detailsPanel.add(identifier);
//    detailsPanel.add(identifierBox);
//  }
//}

