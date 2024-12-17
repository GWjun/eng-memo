package app.common;

import javax.swing.*;
import java.awt.*;

public class MyLayout extends JPanel {
  private final JPanel header;
  private final JPanel footer;

  public MyLayout() {
    setLayout(null);

    header = new JPanel();
    header.setSize(400, 35);
    header.setLayout(new FlowLayout(FlowLayout.LEFT));

    IconButton back = new IconButton(new ImageIcon("src/resource/images/chevron-left.png"));
    back.addActionListener(e -> Router.back());
    header.add(back);

    footer = new JPanel();
    footer.setBackground(Color.WHITE);
    footer.setSize(400, 50);
    footer.setLocation(0, 810);
    footer.setLayout(new FlowLayout(FlowLayout.CENTER, 80, 10));

    IconButton notebook = new IconButton(new ImageIcon("src/resource/images/notebook.png"));
    notebook.addActionListener(e -> Router.navigate("test"));
    IconButton house = new IconButton(new ImageIcon("src/resource/images/house.png"));
    house.addActionListener(e -> Router.navigate("home"));
    IconButton user = new IconButton(new ImageIcon("src/resource/images/user.png"));
    user.addActionListener(e -> Router.navigate("user"));
    footer.add(notebook);
    footer.add(house);
    footer.add(user);

    add(header);
    add(footer);
  }
}
