package org.elevator.view;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class ElevatorView {
  private JFrame frame;
  private JLabel floorLabel = new JLabel();
  private JLabel queueLabel = new JLabel();
  private JPanel buttonPanel;
  private ArrayList<JButton> buttonList = new ArrayList<JButton>();

  public void render() {
    frame = new JFrame("Elevator Sim");

    // I apologize if you view this on a 4k monitor, as it does not scale with resolution...
    frame.setSize(500, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.setLayout(new BorderLayout());

    buttonPanel = ButtonPanel();

    frame.add(floorLabel, BorderLayout.PAGE_START);
    frame.add(buttonPanel, BorderLayout.CENTER);
    frame.add(queueLabel, BorderLayout.PAGE_END);

    frame.setLocationRelativeTo(null);
    frame.setAlwaysOnTop(true);
    frame.setVisible(true);
  }

  private JPanel ButtonPanel() {
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new GridLayout(2, 3));

    for (JButton button : buttonList) {
      buttonPanel.add(button);
    }

    return buttonPanel;
  }

  public void addButton(String buttonName) {
    buttonList.add(new JButton(buttonName));
  }

  public JButton getButton(int index) {
    return buttonList.get(index);
  }

  public ArrayList<JButton> getButtonList() {
    return buttonList;
  }

  public void setFloorLabel(String text) {
    floorLabel.setHorizontalAlignment(JLabel.CENTER);
    floorLabel.setText(text);
  }

  public void setQueueLabel(String text) {
    queueLabel.setHorizontalAlignment(JLabel.CENTER);
    queueLabel.setText(text);
  }
  
}
