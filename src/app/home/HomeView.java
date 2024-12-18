package app.home;

import app.common.*;
import java.awt.Dimension;
import javax.swing.ImageIcon;

public class HomeView extends MyLayout {
  public HomeView() {
    MyPanel todayPanel = new MyPanel();
    todayPanel.setLocation(10, 70);
    IconButton learningIcon =
        new IconButton(new ImageIcon("src/resource/images/learning.png"), "Learning");
    learningIcon.setRolloverIcon(new ImageIcon("src/resource/images/learning.gif"));
    learningIcon.addActionListener(e -> Router.navigate("learning"));
    learningIcon.setPreferredSize(new Dimension(365, 220));
    todayPanel.add(learningIcon);

    MyPanel testPanel = new MyPanel();
    testPanel.setLocation(10, 335);
    IconButton testIcon = new IconButton(new ImageIcon("src/resource/images/test.png"), "Test");
    testIcon.setRolloverIcon(new ImageIcon("src/resource/images/test.gif"));
    testIcon.addActionListener(e -> Router.navigate("test"));
    testIcon.setPreferredSize(new Dimension(365, 220));
    testPanel.add(testIcon);

    MyPanel wordPanel = new MyPanel();
    wordPanel.setLocation(10, 600);
    IconButton wordIcon = new IconButton(new ImageIcon("src/resource/images/word.png"), "Word");
    wordIcon.setRolloverIcon(new ImageIcon("src/resource/images/word.gif"));
    wordIcon.addActionListener(e -> Router.navigate("word"));
    wordIcon.setPreferredSize(new Dimension(365, 220));
    wordPanel.add(wordIcon);

    add(todayPanel);
    add(testPanel);
    add(wordPanel);
  }
}
