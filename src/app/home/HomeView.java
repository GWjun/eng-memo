package app.home;

import app.common.MyLayout;
import app.common.MyPanel;

public class HomeView extends MyLayout {
  public HomeView() {
    MyPanel panel = new MyPanel();
    panel.setLocation(10, 70);
    add (panel);

  }
}
