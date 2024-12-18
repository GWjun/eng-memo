package app.word;

import app.common.MyPanel;
import java.awt.*;
import javax.swing.*;

public class WordCard extends MyPanel {
  public WordCard(WordData data) {
    this(-1, data);
  }

  public WordCard(int idx, WordData data) {
    setLayout(null);

    JPanel header = new JPanel();
    header.setLayout(new FlowLayout(FlowLayout.LEFT));
    header.setLocation(10, 10);
    header.setSize(340, 30);
    header.setBackground(Color.WHITE);

    JPanel content = new JPanel();
    content.setLayout(new GridLayout(0, 1));
    content.setLocation(20, 40);
    content.setSize(340, 45);
    content.setBackground(Color.WHITE);

    if (idx != -1) {
      JLabel titleLabel = new JLabel(idx + "");
      titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
      header.add(titleLabel);
    }

    JLabel word = new JLabel(data.getWord());
    word.setFont(new Font("Arial", Font.BOLD, 18));
    header.add(word);

    JLabel meaning = new JLabel(String.join(", ", data.getMeaning()));
    meaning.setFont(new Font("Arial", Font.BOLD, 16));
    meaning.setForeground(Color.gray);
    header.add(meaning);

    for (String text : data.getSentence()) {
      JLabel sentence = new JLabel(text);
      sentence.setFont(new Font("Arial", Font.BOLD, 15));
      sentence.setForeground(Color.gray);
      content.add(sentence);
    }

    add(header);
    add(content);
  }
}
