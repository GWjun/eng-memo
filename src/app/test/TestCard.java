package app.test;

import app.common.*;
import app.word.WordData;
import java.awt.*;
import java.util.List;
import javax.swing.*;

public class TestCard extends MyPanel {
  private final JPanel top;
  private final JPanel bottom;
  private final JTextField answer;
  private final WordData data;

  public TestCard(WordData data) {
    this(-1, data);
  }

  public TestCard(int idx, WordData data) {
    setLayout(null);
    setLocation(10, 275);

    this.top = new MyPanel();
    this.bottom = new JPanel();
    this.answer = new MyInput("Type the word..");
    this.data = data;

    top.setLayout(null);
    top.setLocation(10, 10);
    top.setSize(345, 70);
    top.setBackground(new Color(232, 239, 252));

    bottom.setLayout(new GridLayout(0, 1));
    bottom.setLocation(10, 100);
    bottom.setSize(345, 120);
    bottom.setBackground(Color.WHITE);

    if (idx != -1) {
      JLabel titleLabel = new JLabel(idx + ".Q");
      titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
      titleLabel.setSize(40, 15);
      titleLabel.setLocation(10, 10);
      top.add(titleLabel);
    }

    makeQuestion();

    add(top);
    add(bottom);
  }

  private void makeQuestion() {
    boolean isMeaningQuestion = Math.random() < 0.5;

    // meaning -> word
    if (isMeaningQuestion) {
      JLabel meaning = new JLabel(String.join(", ", data.getMeaning()));
      meaning.setFont(new Font("Arial", Font.BOLD, 16));
      meaning.setForeground(Color.gray);
      meaning.setSize(340, 20);
      meaning.setLocation(10, 30);
      top.add(meaning);
    } else {
      // sentence -> word
      List<String> sentences = data.getSentence();
      String randomSentence = sentences.get((int) (Math.random() * sentences.size()));

      String blankedSentence = randomSentence.replace(data.getWord(), "_____");
      JLabel sentenceLabel = new JLabel(blankedSentence);
      sentenceLabel.setFont(new Font("Arial", Font.BOLD, 15));
      sentenceLabel.setForeground(Color.gray);
      sentenceLabel.setSize(340, 20);
      sentenceLabel.setLocation(10, 30);
      top.add(sentenceLabel);
    }

    bottom.add(answer);
  }

  public String getAnswer() {
    return data.getWord();
  }

  public String getInputValue() {
    if (answer.getText().equals("Type the word..")) return "";
    return answer.getText();
  }
}
