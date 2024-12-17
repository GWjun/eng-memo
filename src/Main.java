import javax.swing.*;
import app.common.Router;

import app.login.*;

public class Main extends JFrame {

  Main() {
    setTitle("English Master");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setIconImage(new ImageIcon("src/resource/images/logo.png").getImage());

    // route point start
    Router.addRoute("init", new InitView());
    Router.addRoute("login", new LoginView());
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
