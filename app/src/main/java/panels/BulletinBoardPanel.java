package panels;

import javax.swing.*;
import java.awt.*;

public class BulletinBoardPanel extends JPanel {

  public BulletinBoardPanel() {
    setLayout(new GridLayout(8, 1));

     // 헤드라인
    JLabel headline = new JLabel("맛있게 드셨나요? 우리 아이와의 한끼얌얌 추억을 자랑해주세요!");
    this.add(headline);

    // 글 입력창
    JLabel writer = new JLabel("작성자");
    JTextField writerBox = new JTextField(20);

    JLabel password = new JLabel("비밀번호");
    JTextField passwordBox = new JTextField(20);

    JLabel content = new JLabel("내용");
    JTextField contentBox = new JTextField(20);

    this.add(writer);
    this.add(writerBox);
    this.add(password);
    this.add(passwordBox);
    this.add(content);
    this.add(contentBox);

    // 입력버튼

    JButton button = new JButton("제출하기");
    button.addActionListener(event -> {
      String post = contentBox.getText();
      JLabel label2 = new JLabel(post);
      this.add(label2);
      this.setVisible(false);
      this.setVisible(true);
    });

    this.add(button);
  }
}

