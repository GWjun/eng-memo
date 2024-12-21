package app.test;

import app.common.Router;
import app.common.Util;
import app.word.WordData;
import app.word.WordView;
import java.util.List;
import javax.swing.JOptionPane;

public class EndModal {
  public EndModal(
      String src, int totalScore, List<Integer> inCorrectIdx, List<WordData> wordDataList) {
    String text = "";
    if (src.equals("src/today.txt")) {
      text = "Would you like to add the incorrect questions to your word list?";
    } else if (src.equals("src/test.txt")) {
      text =
          "Your score is "
              + totalScore
              + " !\nWould you like to add the incorrect questions to your word list?";
    }

    int result = JOptionPane.showConfirmDialog(null, text, "End", JOptionPane.YES_NO_OPTION);

    if (result == JOptionPane.YES_OPTION) {
      Util.writeWordData(inCorrectIdx, wordDataList);
    }

    if (src.equals("src/today.txt")) {
      Router.addRoute("review", new TestView("src/today.txt")); // reset review view
    } else if (src.equals("src/test.txt")) {
      Router.addRoute("test", new TestView("src/test.txt")); // reset test view
    }

    Router.addRoute("word", new WordView()); // update word view
    Router.navigate("home");
  }
}
