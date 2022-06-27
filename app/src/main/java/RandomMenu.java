import panels.BulletinBoardPanel;
import panels.GenerateMenuPanel;

import javax.swing.*;
import java.awt.*;

public class RandomMenu {
  private JFrame frame;
  private JPanel contentPanel;

  public static void main(String[] args) {
    RandomMenu application = new RandomMenu();
    application.run();
  }

  public void run() {

    frame = new JFrame("한끼 얌얌");

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(3, 1));
    frame.setSize(600, 700);

    frame.setVisible(true);

    initNavigationButton();

    initContentPanel();

  }

  public void initNavigationButton() {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());

    frame.add(panel);

    panel.add(createGenerateMenuButton());
    panel.add(createBulletinBoardButton());

    frame.setVisible(true);
  }

  public JButton createGenerateMenuButton() {
    JButton button = new JButton("메뉴 만들기");
    button.addActionListener(event -> {
      // content panel 바꾸기
      JPanel generateMenuPanel = new GenerateMenuPanel();
      displayContentPanel(generateMenuPanel);
    });
    return button;
  }

  public JButton createBulletinBoardButton() {
    JButton button = new JButton("자랑하기");
    button.addActionListener(event -> {
      // content panel 바꾸기
      BulletinBoardPanel bulletinBoardPanel = new BulletinBoardPanel();
      displayContentPanel(bulletinBoardPanel);
    });
    return button;
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    frame.add(contentPanel);
  }

  public void displayContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    frame.setVisible(true);
  }
}
