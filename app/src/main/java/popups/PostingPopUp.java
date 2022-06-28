package popups;

import javax.swing.*;
import java.awt.*;

public class PostingPopUp {
  public void initPopUp() {
    JFrame writingFrame = new JFrame("글쓰기");
    writingFrame.setSize(500, 500);
    writingFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JPanel panel = new JPanel();
    panel.setLayout(null);

    // 작성자
    JLabel identifier = new JLabel("작성자 id");
    identifier.setBounds(50, 20, 50, 50);

    JTextField identifierBox = new JTextField(20);
    identifierBox.setBounds(110, 30, 100, 30);

    // 비밀번호
    JLabel password = new JLabel("비밀번호");
    password.setBounds(50, 70, 100, 30);

    JTextField passwordBox = new JTextField(20);
    passwordBox.setBounds(110, 70, 100, 30);

    // 제목과 제목바
    JLabel title = new JLabel("제목");
    title.setBounds(50, 110, 30, 30);

    JTextField titleBox = new JTextField(20);
    titleBox.setBounds(110, 110, 350, 30);

    // 내용 입력박스
    JTextArea contentBox = new JTextArea();
    contentBox.setBounds(50, 160, 405, 250);

    // 완료버튼
    JButton submit = new JButton("완료");
    submit.setBounds(385, 420, 70, 35);
    submit.addActionListener(event -> {
      //TODO: 글 제출 시 어떤 일이 일어날것인지 정의해야 함
    });

    panel.add(identifier);
    panel.add(identifierBox);
    panel.add(password);
    panel.add(passwordBox);
    panel.add(title);
    panel.add(titleBox);
    panel.add(contentBox);
    panel.add(submit);

    writingFrame.add(panel);

    writingFrame.setVisible(true);
  }
}
