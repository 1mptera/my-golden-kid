package panels;

import javax.swing.*;
import java.awt.*;

public class GreetingPanel extends JPanel {
  public GreetingPanel() {
    setLayout(new GridLayout(3, 1));

    JLabel title1 = new JLabel("오늘은 우리아이 뭐 해먹이지?");
    this.add(title1);
    title1.setBounds(100, 100, 100, 100);

    JLabel title2 = new JLabel("한끼얌얌으로 식사메뉴 걱정 끝!");
    this.add(title2);

    JButton button = new JButton("오늘의 한끼얌얌 보러가기");
    button.addActionListener(event -> {
      this.removeAll();

      JPanel generateMenuPanel = new GenerateMenuPanel();

      this.setVisible(false);
      this.setVisible(true);
      this.add(generateMenuPanel);
      setVisible(true);
    });

    this.add(button);
  }
}
