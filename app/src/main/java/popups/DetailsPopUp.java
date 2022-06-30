package popups;

import models.Posting;
import panels.BulletinBoardPanel;
import repositories.PostingRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DetailsPopUp {
  private Posting posting;
  private PostingRepository postingRepository;
  private BulletinBoardPanel bulletinBoardPanel;
  private JFrame detailsFrame;
  private JPanel detailsPanel;
  private JTextField identifierBox;
  private JTextField passwordBox;
  private JTextField titleBox;
  private JTextArea contentBox;

  public DetailsPopUp(Posting posting, PostingRepository postingRepository, BulletinBoardPanel bulletinBoardPanel) {
    this.posting = posting;
    this.postingRepository = postingRepository;
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
    JLabel identifier = new JLabel("작성자 id");
    identifier.setBounds(50, 20, 50, 50);

    identifierBox = new JTextField(20);
    identifierBox.setText(posting.identifier());
    identifierBox.setEditable(false);
    identifierBox.setBounds(110, 30, 150, 30);
    detailsPanel.add(identifier);
    detailsPanel.add(identifierBox);
  }

  public void initPasswordSection() {
    JLabel password = new JLabel("비밀번호");
    password.setBounds(50, 70, 100, 30);

    passwordBox = new JTextField(4);
    passwordBox.setText(posting.password());
    passwordBox.setBounds(110, 70, 250, 30);
    passwordBox.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        passwordBox.setText("");
      }
    });

    detailsPanel.add(password);
    detailsPanel.add(passwordBox);
  }

  public void initTitleSection() {
    JLabel title = new JLabel("제목");
    title.setBounds(50, 110, 30, 30);

    titleBox = new JTextField(posting.title());
    titleBox.setBounds(110, 110, 350, 30);

    detailsPanel.add(title);
    detailsPanel.add(titleBox);
  }

  public void initContentSection() {
    contentBox = new JTextArea();
    contentBox.setText(posting.text());
    contentBox.setLineWrap(true);
    contentBox.setBounds(50, 160, 405, 250);
    detailsPanel.add(contentBox);
  }

  public void initDeleteButton() {
    JButton delete = new JButton("삭제하기");
    delete.setBounds(300, 420, 70, 35);
    delete.addActionListener(event -> {

      postingRepository.deletePosting(posting);

      bulletinBoardPanel.removeAll();

      bulletinBoardPanel.setLayout(new GridLayout(postingRepository.postingsSize() + 1, 1));

      bulletinBoardPanel.initHeadline();
      bulletinBoardPanel.initPostingListsSection();

      bulletinBoardPanel.setVisible(false);
      bulletinBoardPanel.setVisible(true);

      detailsFrame.setVisible(false);
    });

    detailsPanel.add(delete);
  }

  public void initModifyButton() {
    JButton modify = new JButton("수정하기");
    modify.setBounds(385, 420, 70, 35);
    modify.addActionListener(event -> {
      //원래 포스팅에 들어가야 함 <- 수정된 내용
      posting = new Posting(identifierBox.getText(), passwordBox.getText(), titleBox.getText(), contentBox.getText(), posting.time());
      postingRepository.modifyPosting(posting);

      // TODO: 수정 버튼을 누를 때 비밀번호를 잘못 입력했다면 fail, 잘 입력했다면 수정하시겠습니까? 그리고 이걸 리스트에 어떻게 반영할 것인가...
      bulletinBoardPanel.removeAll();

      bulletinBoardPanel.setLayout(new GridLayout(postingRepository.postingsSize() + 1, 1));

      bulletinBoardPanel.initHeadline();
      bulletinBoardPanel.initPostingListsSection();

      bulletinBoardPanel.setVisible(false);
      bulletinBoardPanel.setVisible(true);

      detailsFrame.setVisible(false);
    });

    detailsPanel.add(modify);
  }
}
