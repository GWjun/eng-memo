package app.learning;

import app.common.Router;
import app.common.Util;
import app.word.WordData;
import app.word.WordView;
import java.util.List;
import javax.swing.JOptionPane;

public class EndModal {
  public EndModal(List<Integer> inCorrectIdx, List<WordData> wordDataList) {
    int result =
        JOptionPane.showConfirmDialog(
            null,
            "Would you like to add the incorrect questions to your word list?",
            "End",
            JOptionPane.YES_NO_OPTION);

    if (result == JOptionPane.YES_OPTION) {
      Util.writeWordData(inCorrectIdx, wordDataList);
    }

    Router.addRoute("review", new ReviewView()); // reset review view
    Router.addRoute("word", new WordView()); // update word view
    Router.navigate("home");
  }
}
