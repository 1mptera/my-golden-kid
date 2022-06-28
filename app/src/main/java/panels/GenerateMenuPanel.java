package panels;

import utils.RandomMenuGenerator;

import javax.swing.*;
import java.awt.*;

public class GenerateMenuPanel extends JPanel {
  private final JButton button;
  private JLabel label;
  private JLabel label2;
  private JLabel label3;
  private JLabel label4;
  private JLabel label5;

  public GenerateMenuPanel() {

    setLayout(new GridLayout(7, 1));

    RandomMenuGenerator randomMenuGenerator = new RandomMenuGenerator();

    initRandomMenuLabel(randomMenuGenerator);

    button = new JButton("다시 만들래요!");
    button.addActionListener(event -> {
      this.removeAll();

      initRandomMenuLabel(randomMenuGenerator);

      this.add(button);

      this.setVisible(false);
      this.setVisible(true);
    });

    this.add(button);
  }

  private void initRandomMenuLabel(RandomMenuGenerator randomMenuGenerator) {
    label = new JLabel(randomMenuGenerator.rice());
    this.add(label);

    label2 = new JLabel(randomMenuGenerator.soup());
    this.add(label2);

    label3 = new JLabel(randomMenuGenerator.vegetable());
    this.add(label3);

    label4 = new JLabel(randomMenuGenerator.meat());
    this.add(label4);

    label5 = new JLabel(randomMenuGenerator.dessert());
    this.add(label5);
  }
}
