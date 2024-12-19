package app.learning;

import app.common.*;
import app.test.TestCard;
import app.word.WordData;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ReviewView extends MyLayout {
  public ReviewView() {

    add(
        new TestCard(
            1,
            new WordData(
                "apple",
                Arrays.asList("sagwa"),
                Arrays.asList("You ate an apple.", "She loves apple pie."))));

    JButton submitButton = new MyButton("submit", "md", "primary");
    submitButton.setLocation(150, 580);
    submitButton.addActionListener(e -> System.out.println("kjdsljf"));

    // enter key action
    SwingUtilities.invokeLater(
        () -> {
          JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
          if (frame != null) {
            frame.getRootPane().setDefaultButton(submitButton);
          }
        });

    add(submitButton);
  }
}
