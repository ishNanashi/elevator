package org.elevator;

import org.elevator.model.Elevator; 
import org.elevator.view.ElevatorView;
import org.elevator.controller.ElevatorController;

public class ElevatorApp {
  public static void main(String[] args) {
    System.out.println("Running elevator sim...");
    ElevatorController elevator = new ElevatorController(new Elevator(), new ElevatorView());

    elevator.initializeView();
    elevator.updateView();
    elevator.getView().render();
  }
}
