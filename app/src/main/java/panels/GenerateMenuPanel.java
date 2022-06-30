package panels;

import utils.RandomMenuGenerator;

import javax.swing.*;
import java.awt.*;

public class GenerateMenuPanel extends JPanel {
  private final JButton restartButton;
  private JLabel riceLabel;
  private JLabel soupLabel;
  private JLabel vegetableLabel;
  private JLabel meatLabel;
  private JLabel dessertLabel;

  public GenerateMenuPanel() {

    setLayout(new GridLayout(7, 1));

    RandomMenuGenerator randomMenuGenerator = new RandomMenuGenerator();

    initRandomMenuLabel(randomMenuGenerator);

    restartButton = new JButton("다시 만들래요!");
    restartButton.addActionListener(event -> {
      this.removeAll();

      initRandomMenuLabel(randomMenuGenerator);

      this.add(restartButton);

      this.setVisible(false);
      this.setVisible(true);
    });

    this.add(restartButton);
  }

  public void initRandomMenuLabel(RandomMenuGenerator randomMenuGenerator) {
    riceLabel = new JLabel("밥: " + randomMenuGenerator.rice());
    this.add(riceLabel);

    soupLabel = new JLabel("국: " + randomMenuGenerator.soup());
    this.add(soupLabel);

    vegetableLabel = new JLabel("채소반찬: " + randomMenuGenerator.vegetable());
    this.add(vegetableLabel);

    meatLabel = new JLabel("고기반찬: " + randomMenuGenerator.meat());
    this.add(meatLabel);

    dessertLabel = new JLabel("간식: " + randomMenuGenerator.dessert());
    this.add(dessertLabel);
  }
}
