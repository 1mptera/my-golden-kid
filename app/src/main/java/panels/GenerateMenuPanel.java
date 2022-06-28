package panels;

import utils.RandomMenuGenerator;

import javax.swing.*;
import java.awt.*;

public class GenerateMenuPanel extends JPanel {
  public GenerateMenuPanel() {

    setLayout(new GridLayout(7, 1));

    RandomMenuGenerator randomMenuGenerator = new RandomMenuGenerator();

    JLabel label = new JLabel(randomMenuGenerator.rice());
    this.add(label);

    JLabel label2 = new JLabel(randomMenuGenerator.soup());
    this.add(label2);

    JLabel label3 = new JLabel(randomMenuGenerator.vegetable());
    this.add(label3);

    JLabel label4 = new JLabel(randomMenuGenerator.meat());
    this.add(label4);

    JLabel label5 = new JLabel(randomMenuGenerator.dessert());
    this.add(label5);

    JButton button1 = new JButton("다시 만들래요!");
    button1.addActionListener(event -> {
      this.removeAll();

      JPanel generateMenuPanel = new GenerateMenuPanel();

      this.setVisible(false);
      this.setVisible(true);
      this.add(generateMenuPanel);
      setVisible(true);
    });
    this.add(button1);

    JButton button2 = new JButton("자랑하기");
    button2.addActionListener(event -> {
      this.removeAll();

      JPanel bulletinBoardPanel = new BulletinBoardPanel();

      this.setVisible(false);
      this.setVisible(true);
      this.add(bulletinBoardPanel);
      setVisible(true);
    });
    this.add(button2);
  }
}
