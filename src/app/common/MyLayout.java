package app.common;

import javax.swing.*;

public class MyLayout extends JPanel {
  private final JPanel header;

  public MyLayout() {
    setLayout(null);

    header = new JPanel();
    header.setSize(400, 35);
    header.setLayout(null);

    IconButton back = new IconButton(new ImageIcon("src/resource/images/chevron-left.png"));
    back.addActionListener(e -> Router.back());
    back.setSize(20, 20);
    back.setLocation(10, 10);

    IconButton house = new IconButton(new ImageIcon("src/resource/images/house.png"));
    house.addActionListener(e -> Router.navigate("home"));
    house.setSize(32, 32);
    house.setLocation(345, 6);

    header.add(back);
    header.add(house);

    add(header);
  }
}
