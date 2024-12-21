package app.learning;

import app.common.*;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LearningView extends MyLayout {

  public LearningView() {
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setSize(400, 965);
    scrollPane.setLocation(0, 45);
    scrollPane.getVerticalScrollBar().setUnitIncrement(16); // scroll speed

    JPanel contentPanel = new JPanel();
    contentPanel.setLayout(null);

    List<JPanel> cards = Util.makeCards("src/today.txt");

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
    JButton goReivewButton = new MyButton("Go Review", "lg", "secondary");
    goReivewButton.setLocation(145, offset + 50);
    goReivewButton.addActionListener(e -> Router.navigate("review"));
    contentPanel.add(goReivewButton);

    contentPanel.setPreferredSize(new Dimension(360, offset + 300));
    scrollPane.setViewportView(contentPanel);

    add(scrollPane);
  }
}
