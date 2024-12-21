package app.test;

import app.common.*;
import app.word.WordData;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class TestView extends MyLayout {
  private final String src;
  private final List<WordData> wordDataList;
  private int idx;
  private boolean isCorrect;
  private final List<Integer> inCorrectIdx;
  private int totalScore;

  private final CardLayout cardLayout;
  private final JPanel cardPanel;
  private final JLabel result;
  private final JButton submitButton;
  private final JButton nextButton;

  public TestView(String src) {
    this.src = src;
    wordDataList = Util.readWordData(src);
    idx = 0;
    isCorrect = false;
    inCorrectIdx = new ArrayList<>();
    totalScore = 0;

    cardLayout = new CardLayout();
    cardPanel = new JPanel(cardLayout);
    cardPanel.setSize(365, 240);
    cardPanel.setLocation(10, 275);

    for (int i = 0; i < wordDataList.size(); i++) {
      TestCard testCard = new TestCard(i + 1, wordDataList.get(i));
      cardPanel.add(testCard, "card" + i);
    }

    result = new JLabel("");
    result.setFont(new Font("Arial", Font.BOLD, 15));

    JPanel resultPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
    resultPanel.setSize(360, 20);
    resultPanel.setLocation(10, 530);
    resultPanel.add(result);

    submitButton = new MyButton("submit", "md", "primary");
    submitButton.setLocation(150, 580);
    submitButton.addActionListener(e -> handleClick());

    nextButton = new MyButton("next", "md", "text");
    nextButton.setLocation(150, 620);
    nextButton.addActionListener(e -> showNextCard());
    nextButton.setVisible(false);

    add(cardPanel);
    add(resultPanel);
    add(submitButton);
    add(nextButton);

    // to keyboard focus
    addAncestorListener(
        new AncestorListener() {
          @Override
          public void ancestorAdded(AncestorEvent event) {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(event.getComponent());
            if (frame != null) {
              frame.getRootPane().setDefaultButton(submitButton);
            }
          }

          @Override
          public void ancestorRemoved(AncestorEvent event) {}

          @Override
          public void ancestorMoved(AncestorEvent event) {}
        });
  }

  private void handleClick() {
    if (isCorrect) {
      showNextCard();
    } else {
      checkAnswer();
    }
  }

  private void checkAnswer() {
    TestCard currentCard = (TestCard) cardPanel.getComponent(idx);
    String answer = currentCard.getAnswer();
    String input = currentCard.getInputValue();

    if (answer.equalsIgnoreCase(input)) {
      result.setText("Correct!");
      isCorrect = true;
      result.setForeground(new Color(19, 120, 19));
      submitButton.setText("next");
      nextButton.setVisible(false);
    } else {
      int lcsLength = Util.getLCS(answer, input);
      result.setText("Incorrect. " + lcsLength + " letters match!");
      result.setForeground(new Color(244, 63, 63));
      nextButton.setVisible(true);
    }
  }

  private void showNextCard() {
    if (isCorrect) {

      totalScore += wordDataList.get(idx).getScore();
      System.out.println(totalScore);
    } else {
      inCorrectIdx.add(idx);
    }

    if (idx + 1 < wordDataList.size()) {
      // reset state && render next card
      idx++;
      result.setText("");
      isCorrect = false;
      submitButton.setText("submit");
      nextButton.setVisible(false);
      cardLayout.show(cardPanel, "card" + idx);
    } else {
      // end review
      nextButton.setVisible(false);
      new EndModal(src, totalScore, inCorrectIdx, wordDataList);
    }
  }
}
