package app.common;

import java.awt.*;
import javax.swing.*;

public class MyPanel extends JPanel {
  public MyPanel() {
    setBackground(Color.WHITE);
    setSize(365, 240);
    setOpaque(false);
  }

  @Override
  protected void paintComponent(Graphics g) {
    g.setColor(getBackground());
    g.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
    super.paintComponent(g);
  }
}
