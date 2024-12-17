package app.common;

import java.awt.Dimension;
import javax.swing.*;

public class IconButton extends JButton {
  public IconButton(Icon icon) {
    super(icon);
    setBorderPainted(false);
    setContentAreaFilled(false);
    setFocusPainted(false);
    setOpaque(false);
    setPreferredSize(new Dimension(30, 30));
  }
}
