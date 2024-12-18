package app.common;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;

public class IconButton extends JButton {
  public IconButton(Icon icon) {
    this(icon, null);
  }

  public IconButton(Icon icon, String text) {
    super(text, icon);
    setBorderPainted(false);
    setContentAreaFilled(false);
    setFocusPainted(false);
    setOpaque(false);
    setPreferredSize(new Dimension(30, 30));
    setFont(new Font("Arial", Font.BOLD, 18));
    setIconTextGap(20);
  }
}
