package app.common;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class MyInput extends JTextField {
  public MyInput() {
    this("");
  }

  public MyInput(String placeholder) {
    setFont(new Font("Arial", Font.BOLD, 16));
    setBackground(new Color(251, 251, 251));
    setBorder(
        javax.swing.BorderFactory.createEmptyBorder(15, 15, 15, 15)); // remove border & padding

    addFocusListener(
        new FocusListener() {
          @Override
          public void focusGained(FocusEvent e) {
            if (getText().equals(placeholder)) {
              setText("");
              setForeground(Color.BLACK);
            }
          }

          @Override
          public void focusLost(FocusEvent e) {
            if (getText().isEmpty()) {
              setForeground(Color.LIGHT_GRAY);
              setText(placeholder);
            }
          }
        });

    // to keyboard focus
    addAncestorListener(
        new AncestorListener() {
          @Override
          public void ancestorAdded(AncestorEvent event) {
            requestFocus();
          }

          @Override
          public void ancestorRemoved(AncestorEvent event) {}

          @Override
          public void ancestorMoved(AncestorEvent event) {}
        });
  }

  @Override
  protected void paintComponent(Graphics g) {
    g.setColor(getBackground());
    g.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
    super.paintComponent(g);
  }
}
