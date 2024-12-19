package app.learning;

import app.common.*;
import app.word.WordCard;
import app.word.WordData;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class LearningView extends MyLayout {

  public LearningView() {
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setSize(400, 965);
    scrollPane.setLocation(0, 45);
    scrollPane.getVerticalScrollBar().setUnitIncrement(16); // scroll speed

    JPanel contentPanel = new JPanel();
    contentPanel.setLayout(null);

    List<JPanel> cards = makeCards();
    int offset = 10;
    for (JPanel card : cards) {
      card.setSize(360, 100);
      card.setLocation(10, offset);
      contentPanel.add(card);
      offset += 110;
    }
    JButton goReivewButton = new MyButton("Go Review", "lg", "secondary");
    goReivewButton.setLocation(145, offset + 50);
    goReivewButton.addActionListener(e -> Router.navigate("review"));
    contentPanel.add(goReivewButton);

    contentPanel.setPreferredSize(new Dimension(360, offset + 300));
    scrollPane.setViewportView(contentPanel);

    add(scrollPane);
  }

  private List<JPanel> makeCards() {
    List<JPanel> cards = new ArrayList<>();

    List<WordData> wordDataList = Util.readWordData("src/today.txt");
    for (int i = 0; i < wordDataList.size(); i++) {
      JPanel card = new WordCard(i + 1, wordDataList.get(i));

      card.setPreferredSize(new Dimension(360, 100));
      cards.add(card);
    }

    return cards;
  }
}
