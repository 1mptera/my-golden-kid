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

    this.add(new JButton("다시 만들래요!"));
    this.add(new JButton("지랑하기"));
  }
}
