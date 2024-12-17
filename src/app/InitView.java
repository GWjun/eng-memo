package app;

import app.common.*;
import java.awt.*;
import javax.swing.*;

/** Initial Onboarding if not log in */
public class InitView extends JPanel {
  public InitView() {
    setLayout(null);

    JLabel label = new JLabel();
    ImageIcon gif = new ImageIcon("src/resource/images/book.gif");
    label.setIcon(gif);
    label.setSize(200, 193);
    label.setLocation(100, 80);
    add(label);

    JLabel text1 = new JLabel("Let's study English");
    text1.setFont(new Font("Arial", Font.BOLD, 20));
    text1.setSize(200, 30);
    text1.setLocation(105, 330);
    add(text1);

    JLabel text2 = new JLabel("Together!");
    text2.setFont(new Font("Arial", Font.BOLD, 20));
    text2.setSize(200, 30);
    text2.setLocation(150, 350);
    add(text2);

    MyButton loginButton = new MyButton("Start", "md", "primary");
    loginButton.setLocation(160, 700);
    loginButton.addActionListener(e -> Router.navigate("home"));

    add(loginButton);
  }
}
