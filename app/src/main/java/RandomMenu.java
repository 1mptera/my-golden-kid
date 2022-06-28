import panels.BulletinBoardPanel;
import panels.GenerateMenuPanel;
import panels.GreetingPanel;
import popups.PostingPopUp;

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
    // Swing 기본 세팅
    frame = new JFrame("한끼 얌얌");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(3, 1));
    frame.setSize(600, 700);
    frame.setLocation(300, 300);
    frame.setVisible(true);

    initNavigationButton();

    initContentPanel();
  }

  public void initNavigationButton() {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());
    frame.add(panel, BorderLayout.PAGE_START);
    frame.add(panel);

    panel.add(createGoHomeButton());
    panel.add(createBulletinBoardButton());
    panel.add(createWriteButton());
  }

  public void displayMain() {
    GreetingPanel greetingPanel = new GreetingPanel();
    displayContentPanel(greetingPanel);
  }

  public JButton createGoHomeButton() {
    JButton button = new JButton("홈으로");
    button.addActionListener(event -> {
      displayMain();
    });

    return button;
  }

  public JButton createBulletinBoardButton() {
    JButton button = new JButton("자랑하기");
    button.addActionListener(event -> {
      BulletinBoardPanel bulletinBoardPanel = new BulletinBoardPanel();
      displayContentPanel(bulletinBoardPanel);
    });

    return button;
  }

  private JButton createWriteButton() {
    JButton button = new JButton("글쓰기");
    button.addActionListener(event -> {

      PostingPopUp postingPopUp = new PostingPopUp();
      postingPopUp.initPopUp();


    });

    return button;
  }

  public void initContentPanel() {
    contentPanel = new JPanel();
    displayMain();
    frame.setVisible(true);
    frame.add(contentPanel);
  }

  public void displayContentPanel(JPanel panel) {
    contentPanel.removeAll();
    contentPanel.add(panel);
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }
}
