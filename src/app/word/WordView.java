package app.word;

import app.common.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class WordView extends MyLayout {

  public WordView() {
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setSize(400, 965);
    scrollPane.setLocation(0, 45);
    scrollPane.getVerticalScrollBar().setUnitIncrement(16); // scroll speed

    JPanel contentPanel = new JPanel();
    contentPanel.setLayout(null);

    List<JPanel> cards = Util.makeCards("src/word.txt");

    if (cards.isEmpty()) {
      JLabel emptyText = new JLabel("The word list is empty. Try adding some words.");
      emptyText.setFont(new Font("Arial", Font.BOLD, 15));
      emptyText.setSize(380, 20);
      emptyText.setLocation(25, 100);
      add(emptyText);
      return;
    }

    int offset = 10;
    for (JPanel card : cards) {
      card.setSize(360, 100);
      card.setLocation(10, offset);
      contentPanel.add(card);
      offset += 110;
    }

    contentPanel.setPreferredSize(new Dimension(360, offset + 300));
    scrollPane.setViewportView(contentPanel);

    add(scrollPane);
  }
}
