package popups;

import panels.BulletinBoardPanel;
import repositories.PostingRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostingPopUp {
  private PostingRepository postingRepository;
  private BulletinBoardPanel bulletinBoardPanel;
  private JFrame writingFrame;
  private JPanel postingPanel;
  private JTextField identifierBox;
  private JTextField passwordBox;
  private JTextField titleBox;
  private JTextArea contentBox;

  public PostingPopUp(PostingRepository postingRepository, BulletinBoardPanel bulletinBoardPanel) {
    this.postingRepository = postingRepository;
    this.bulletinBoardPanel = bulletinBoardPanel;
  }

  public void initPopUp() {
    writingFrame = new JFrame("글쓰기");
    writingFrame.setSize(500, 500);
    writingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    writingFrame.setVisible(true);

    postingPanel = new JPanel();
    postingPanel.setLayout(null);

    initWriterSection();

    initPasswordSection();

    initTitleSection();

    initContentSection();

    initSubmitButton();

    writingFrame.add(postingPanel);
  }

  public void initWriterSection() {
    JLabel identifier = new JLabel("작성자 id");
    identifier.setBounds(50, 20, 50, 50);

    identifierBox = new JTextField(20);
    identifierBox.setBounds(110, 30, 150, 30);

    postingPanel.add(identifier);
    postingPanel.add(identifierBox);
  }

  public void initPasswordSection() {
    JLabel password = new JLabel("비밀번호");
    password.setBounds(50, 70, 100, 30);

    passwordBox = new JTextField(4);
    passwordBox.setText("숫자 4자리를 입력하세요");
    passwordBox.setBounds(110, 70, 150, 30);
    passwordBox.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        passwordBox.setText("");
      }
    });

    postingPanel.add(password);
    postingPanel.add(passwordBox);
  }

  public void initTitleSection() {
    JLabel title = new JLabel("제목");
    title.setBounds(50, 110, 30, 30);

    titleBox = new JTextField(20);
    titleBox.setBounds(110, 110, 350, 30);

    postingPanel.add(title);
    postingPanel.add(titleBox);
  }

  public void initContentSection() {
    contentBox = new JTextArea("한끼얌얌과 함께한 즐거운 식사시간을 모두에게 자랑해보세요! \n" +
        "모든 항목을 빠짐없이 기재해주세요.(기재하지 않는 경우 글 사라짐");
    contentBox.setBounds(50, 160, 405, 250);
    contentBox.setLineWrap(true);
    contentBox.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        contentBox.setText("");
      }
    });

    postingPanel.add(contentBox);
  }

  public void initSubmitButton() {
    JButton submit = new JButton("완료");
    submit.setBounds(385, 420, 70, 35);
    submit.addActionListener(event -> {
      LocalDateTime currentDateTime = LocalDateTime.now();
      DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
      String time = currentDateTime.format(formatter);

      postingRepository.addPosting(
          identifierBox.getText(),
          passwordBox.getText(),
          titleBox.getText(),
          contentBox.getText(),
          time
      );

      bulletinBoardPanel.removeAll();

      bulletinBoardPanel.setLayout(new GridLayout(postingRepository.postingsSize() + 1, 1));

      bulletinBoardPanel.initHeadline();
      bulletinBoardPanel.initPostingListsSection();

      bulletinBoardPanel.setVisible(false);
      bulletinBoardPanel.setVisible(true);

      writingFrame.setVisible(false);
    });

    postingPanel.add(submit);
  }
}
