package panels;

import javax.swing.*;
import java.awt.*;

public class GenerateMenuPanel extends JPanel {
  public GenerateMenuPanel() {

    setLayout(new GridLayout(7, 1));

    this.add(new JLabel("현미밥"));
    this.add(new JLabel("팽이버섯 미소된장국"));
    this.add(new JLabel("미역줄기볶음"));
    this.add(new JLabel("새우완자볼"));
    this.add(new JLabel("플레인요거트"));

    this.add(new JButton("다시 만들래요!"));
    this.add(new JButton("지랑하기"));
  }
}