import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import ui.common.Button;

public class Main extends JFrame {

  Main() {
    setTitle("English Master");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setResizable(false);
    setIconImage(new ImageIcon("src/resource/images/logo.png").getImage());

    Container c = getContentPane();
    c.setLayout(null);

    Button loginButton = new Button("Login", "md", "primary");
    loginButton.setLocation(160, 700);

    Button registerButton = new Button("Register", "sm", "text");
    registerButton.setSize(90, 28);
    registerButton.setLocation(155, 750);

    c.add(loginButton);
    c.add(registerButton);

    setSize(400, 900);
    setVisible(true);
  }

  public static void main(String[] args) {
    new Main();
  }
}
