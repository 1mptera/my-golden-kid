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
    // Swing 기본 세팅
    frame = new JFrame("한끼 얌얌");

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new GridLayout(3, 1));
    frame.setSize(600, 700);

    frame.setVisible(true);

    // 최상단 네비게이션 버튼 생성(메뉴 만들기, 자랑하기)
    initNavigationButton();

    // 컨텐트 패널 생성
    initContentPanel();
  }

  public void initNavigationButton() {
    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());

    frame.add(panel);

    // 메뉴 만들기 버튼 생성 및 패널에 추가
    panel.add(createGenerateMenuButton());

    // 게시판 바로가기 버튼 생성 및 패널에 추가
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
      JPanel bulletinBoardPanel = new BulletinBoardPanel();
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
    contentPanel.setVisible(false);
    contentPanel.setVisible(true);
    frame.setVisible(true);
  }
}
