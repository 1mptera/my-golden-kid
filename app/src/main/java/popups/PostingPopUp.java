package popups;

import repositories.PostingRepository;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PostingPopUp {
  private JFrame writingFrame;
  private JPanel postingPanel;
  private JTextField identifierBox;
  private JTextField passwordBox;
  private JTextField titleBox;
  private JTextArea contentBox;

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
    contentBox = new JTextArea("한끼얌얌과 함께한 즐거운 식사시간을 모두에게 자랑해보세요!");
    contentBox.setBounds(50, 160, 405, 250);
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
      //TODO: 작성된 내용을 레포지토리로 보내주는 기능 필요

      PostingRepository postingRepository = new PostingRepository();

      String identifier = identifierBox.getText();
      postingRepository.getIdentifier(identifier);

      String password = passwordBox.getText();
      postingRepository.getPassword(password);

      String title = titleBox.getText();
      postingRepository.getTitle(title);

      String content = contentBox.getText();
      postingRepository.getContent(content);

      writingFrame.setVisible(false);
    });

    postingPanel.add(submit);
  }
}
