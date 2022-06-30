package popups;

import models.Post;

import panels.BulletinBoardPanel;
import repositories.PostRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PostingPopUp {
  private PostRepository postRepository;
  private BulletinBoardPanel bulletinBoardPanel;
  private JFrame writingFrame;
  private JPanel postingPanel;
  private JTextField identifierBox;
  private JTextField passwordBox;
  private JTextField titleBox;
  private JTextArea contentBox;

  public PostingPopUp(PostRepository postRepository, BulletinBoardPanel bulletinBoardPanel) {
    this.postRepository = postRepository;
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
    JLabel identifier = new JLabel("작성자");
    identifier.setBounds(50, 20, 50, 50);
    postingPanel.add(identifier);

    identifierBox = new JTextField(20);
    identifierBox.setBounds(110, 30, 150, 30);
    postingPanel.add(identifierBox);
  }

  public void initPasswordSection() {
    JLabel password = new JLabel("비밀번호");
    password.setBounds(50, 70, 100, 30);
    postingPanel.add(password);

    passwordBox = new JTextField(4);
    passwordBox.setBounds(110, 70, 150, 30);
    postingPanel.add(passwordBox);
  }

  public void initTitleSection() {
    JLabel title = new JLabel("제목");
    title.setBounds(50, 110, 30, 30);
    postingPanel.add(title);

    titleBox = new JTextField(20);
    titleBox.setBounds(110, 110, 350, 30);
    postingPanel.add(titleBox);
  }

  public void initContentSection() {
    contentBox = new JTextArea("한끼얌얌과 함께한 즐거운 식사시간을 모두에게 자랑해보세요! \n" +
        "모든 항목을 빠짐없이 기재해주세요.(기재하지 않는 경우 글이 사라집니다.)");
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

      // 글 작성하기 버튼을 누르는 순간의 시간을 해당 글의 고유값으로 부여
      LocalDateTime currentDateTime = LocalDateTime.now();
      DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
      String time = currentDateTime.format(formatter);

      // 기존 게시글의 id와 내가 원하는 id가 겹치는지 확인(겹치면 글쓸 수 없음)
      if (postRepository.postsSize() == 0) {
        postRepository.addPost(
            identifierBox.getText(),
            passwordBox.getText(),
            titleBox.getText(),
            contentBox.getText(),
            time
        );

        refreshPanel();
      }

      if (postRepository.postsSize() > 0) {

        boolean isUnique = true;

        for (int i = 0; i < postRepository.postsSize(); i += 1) {
          if (postRepository.showIdentifier(i).equals(identifierBox.getText())) {
            identifierBox.setBackground(Color.PINK);
            isUnique = false;
            break;
          }
        }

        if (isUnique) {
          postRepository.addPost(
              identifierBox.getText(),
              passwordBox.getText(),
              titleBox.getText(),
              contentBox.getText(),
              time
          );

          refreshPanel();
        }
      }
    });

    postingPanel.add(submit);
  }

  public void refreshPanel() {
    bulletinBoardPanel.removeAll();

    bulletinBoardPanel.setLayout(new GridLayout(postRepository.postsSize() + 1, 1));

    bulletinBoardPanel.initHeadline();
    bulletinBoardPanel.initPostListsSection();

    bulletinBoardPanel.setVisible(false);
    bulletinBoardPanel.setVisible(true);

    writingFrame.setVisible(false);
  }
}
