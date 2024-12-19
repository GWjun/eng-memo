import app.InitView;
import app.common.Router;
import app.home.HomeView;
import app.learning.LearningView;
import app.learning.ReviewView;
import app.test.TestView;
import app.word.WordView;
import javax.swing.*;

public class Main extends JFrame {

  Main() {
    setTitle("English Master");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setIconImage(new ImageIcon("src/resource/images/logo.png").getImage());

    // route point start
    Router.addRoute("init", new InitView());
    Router.addRoute("home", new HomeView());
    Router.addRoute("learning", new LearningView());
    Router.addRoute("test", new TestView());
    Router.addRoute("word", new WordView());
    Router.addRoute("review", new ReviewView());
    // route point end

    add(Router.mainView);
    Router.navigate("init");

    setSize(400, 900);
    setVisible(true);
  }

  public static void main(String[] args) {
    new Main();
  }
}
