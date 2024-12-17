package app.common;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class Router {
  private static final CardLayout cardLayout = new CardLayout();
  public static final JPanel mainView = new JPanel(cardLayout);
  private static final HashMap<String, JPanel> map = new HashMap<>();

  public static void addRoute(String name, JPanel panel) {
    mainView.add(panel, name);
    map.put(name, panel);
  }

  public static void navigate(String name) {
    if (map.containsKey(name)) {
      cardLayout.show(mainView, name);
    }
  }
}
