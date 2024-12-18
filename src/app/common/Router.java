package app.common;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Stack;

public class Router {
  private static final CardLayout cardLayout = new CardLayout();
  public static final JPanel mainView = new JPanel(cardLayout);
  private static final HashMap<String, JPanel> map = new HashMap<>();
  public static final Stack<String> history = new Stack<>();
  private static String current = null;

  public static void addRoute(String name, JPanel panel) {
    mainView.add(panel, name);
    map.put(name, panel);
  }

  public static void navigate(String name) {
    if (map.containsKey(name)) {
      if (current != null) {
        if (current.equals(name)) return;

        history.push(current);
      }
      current = name;
      cardLayout.show(mainView, name);
    }
  }

  public static void back() {
    if (!history.isEmpty()) {
      String previous = history.pop();
      current = previous;
      cardLayout.show(mainView, previous);
    }
  }
}
