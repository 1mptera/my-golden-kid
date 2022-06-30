package popups;

import models.Post;
import panels.BulletinBoardPanel;
import repositories.PostRepository;

import javax.swing.*;
import java.awt.*;

public class DetailsPopUp {
  private Post post;
  private PostRepository postRepository;
  private BulletinBoardPanel bulletinBoardPanel;
  private JFrame detailsFrame;
  private JPanel detailsPanel;
  private JTextField identifierBox;
  private JTextField passwordBox;
  private JTextField titleBox;
  private JTextArea contentBox;

  public DetailsPopUp(Post post, PostRepository postRepository, BulletinBoardPanel bulletinBoardPanel) {
    this.post = post;
    this.postRepository = postRepository;
    this.bulletinBoardPanel = bulletinBoardPanel;

    detailsFrame = new JFrame("상세보기");
    detailsFrame.setSize(500, 500);
    detailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    detailsFrame.setVisible(true);

    detailsPanel = new JPanel();
    detailsPanel.setLayout(null);

    initWriterSection();

    initPasswordSection();

    initTitleSection();

    initContentSection();

    initDeleteButton();

    initModifyButton();

    detailsFrame.add(detailsPanel);
  }

  public void initWriterSection() {
    JLabel identifier = new JLabel("작성자");
    identifier.setBounds(50, 20, 50, 50);
    detailsPanel.add(identifier);

    identifierBox = new JTextField(20);
    identifierBox.setText(post.identifier());
    identifierBox.setEditable(false);
    identifierBox.setBounds(110, 30, 150, 30);
    detailsPanel.add(identifierBox);
  }

  public void initPasswordSection() {
    JLabel password = new JLabel("비밀번호");
    password.setBounds(50, 70, 100, 30);
    detailsPanel.add(password);

    passwordBox = new JTextField(4);
    passwordBox.setBounds(110, 70, 250, 30);
    detailsPanel.add(passwordBox);
  }

  public void initTitleSection() {
    JLabel title = new JLabel("제목");
    title.setBounds(50, 110, 30, 30);
    detailsPanel.add(title);

    titleBox = new JTextField(post.title());
    titleBox.setBounds(110, 110, 350, 30);
    detailsPanel.add(titleBox);
  }

  public void initContentSection() {
    contentBox = new JTextArea();
    contentBox.setText(post.text());
    contentBox.setLineWrap(true);
    contentBox.setBounds(50, 160, 405, 250);
    detailsPanel.add(contentBox);
  }

  public void initDeleteButton() {
    JButton delete = new JButton("삭제하기");
    delete.setBounds(300, 420, 70, 35);
    delete.addActionListener(event -> {

      if (post.password().equals(passwordBox.getText())) {
        postRepository.deletePost(post);

        refreshPanel();
      }

      passwordBox.setBackground(Color.PINK);
    });

    detailsPanel.add(delete);
  }

  public void initModifyButton() {
    JButton modify = new JButton("수정하기");
    modify.setBounds(385, 420, 70, 35);
    modify.addActionListener(event -> {

      if (post.password().equals(passwordBox.getText())) {

        post = new Post(identifierBox.getText(), passwordBox.getText(),
            titleBox.getText(), contentBox.getText(), post.time());

        postRepository.modifyPost(post);

        refreshPanel();
      }

      passwordBox.setBackground(Color.PINK);
    });

    detailsPanel.add(modify);
  }

  public void refreshPanel() {
    bulletinBoardPanel.removeAll();

    bulletinBoardPanel.setLayout(new GridLayout(postRepository.postsSize() + 1, 1));

    bulletinBoardPanel.initHeadline();
    bulletinBoardPanel.initPostListsSection();

    bulletinBoardPanel.setVisible(false);
    bulletinBoardPanel.setVisible(true);

    detailsFrame.setVisible(false);
  }
}
