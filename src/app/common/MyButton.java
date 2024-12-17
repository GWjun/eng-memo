package app.common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyButton extends JButton {

  private String size;
  private String variant;
  private Color pressedBackgroundColor;

  public MyButton(String text, String size, String variant) {
    super(text);
    this.size = size;
    this.variant = variant;
    this.pressedBackgroundColor = new Color(214, 214, 229);
    applyStyles();
  }

  public MyButton(String text, String size, String variant, ActionListener onClick) {
    this(text, size, variant);
    this.addActionListener(onClick);
  }

  @Override
  protected void paintComponent(Graphics g) {
    if (getModel().isPressed() && pressedBackgroundColor != null) {
      g.setColor(pressedBackgroundColor);
    } else {
      g.setColor(getBackground());
    }
    g.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
    super.paintComponent(g);
  }

  private void applyStyles() {
    setContentAreaFilled(false); // for custom color
    setBorderPainted(false);

    switch (variant) {
      case "primary" -> {
        setBackground(new Color(66, 133, 244));
        setForeground(Color.white);
        this.pressedBackgroundColor = new Color(12, 87, 205);
      }
      case "secondary" -> setBackground(new Color(169, 198, 255));
      case "destructive" -> {
        setBackground(new Color(234, 67, 53));
        setForeground(Color.white);
        this.pressedBackgroundColor = new Color(180, 21, 21);
      }
      case "outline" -> {
        setBorder(new RoundedBorder(15));
        setBorderPainted(true);
      }
      case "text" -> {
        this.pressedBackgroundColor = null;
      }
    }

    switch (size) {
      case "sm" -> setSize(60, 28);
      case "md" -> setSize(80, 35);
      case "lg" -> setSize(100, 40);
    }
  }
}
