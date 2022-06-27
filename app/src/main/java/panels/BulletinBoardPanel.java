package panels;

import javax.swing.*;
import java.awt.*;

public class BulletinBoardPanel extends JPanel {
  private JLabel label2;
  private String task;
  public BulletinBoardPanel() {
    setLayout(new GridLayout(5, 1));

     // 헤드라인
    JLabel label = new JLabel("오늘의 식단 자랑하기");
    this.add(label);

    // 글씨 입력창
    JTextField textField = new JTextField(20);
    this.add(textField);

    // 입력버튼
    JButton button = new JButton("입력하기");

    button.addActionListener(event -> {
      task = textField.getText();
      label2 = new JLabel(task);
      JButton botton2 = new JButton("x");
      this.add(label2);
      this.add(botton2);
      this.setVisible(false);
      this.setVisible(true);
    });

    this.add(button);
  }
}

