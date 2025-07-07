package org.elevator.controller;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.elevator.model.Elevator; 
import org.elevator.view.ElevatorView;

public class ElevatorController {
  private Elevator model;
  private ElevatorView view;

  public ElevatorController(Elevator model, ElevatorView view) {
    this.model = model;
    this.view = view;

    // Arbitrary travel time, wait time, and totalFloors
    this.model.setTravelTime(10 * 1000); // 10 seconds
    this.model.setWaitTime(5 * 1000); // 5 seconds
    this.model.setTotalFloors(6);

    // Choose an arbitrary floor to start on 
    this.model.setCurrentFloor(1);
  }

  public void enqueueFloor(int floor) {
    // Do nothing if current floor or we're already going to that floor
    if (!this.model.queueContainsElement(floor) && this.model.getCurrentFloor() != floor) {
      this.model.enqueue(floor);  
    }
  }

  public int getCurrentFloor() {
    return this.model.getCurrentFloor();
  }

  public int updateCurrentFloor() {
    if (!this.model.queueIsEmpty()) {
      this.model.setCurrentFloor(this.model.peek());
      this.view.setFloorLabel("Travelling to Floor " + String.valueOf(this.model.peek()) + "...");
    } 

    return this.model.getCurrentFloor();
  }

  public void travelToFloor() {
    this.model.setCurrentFloor(updateCurrentFloor());
    this.model.dequeue();
    System.out.println(model.printQueue());
  }

  public String printCurrentFloorQueue() {
    return this.model.printQueue();
  } 

  public void addButtonAction(int buttonIndex) {
    view.getButton(buttonIndex).addActionListener(buttonActionListener(buttonIndex + 1));
  }

  private ActionListener buttonActionListener(int floor) {
    return new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        enqueueFloor(floor);
        System.out.println(model.printQueue());
      }
    };
  }

  // Add buttons for the view to render
  private void addButtons(){
    for (int i = 1; i <= this.model.getTotalFloors(); i++) {
      this.view.addButton(String.valueOf(i));
    }
  }

  public ElevatorView getView() {
    return this.view;
  }

  // First time initialization of the view
  public void initializeView() {
    this.view.setFloorLabel("Elevator is on Floor: " + this.model.getCurrentFloor());
    this.view.setQueueLabel("Current Queue is: " + this.model.printQueue());
    this.addButtons();
    for(int floor = 0; floor < this.view.getButtonList().size(); floor++) {
      this.addButtonAction(floor);
    }
  }

  public void updateView() {
    new Thread(() -> {
      while (true) {
        this.view.setQueueLabel("Current Queue is: " + this.model.printQueue());
      }
    }).start();

    new Thread(() -> {
      while (true) {
        try {
          if (!this.model.queueIsEmpty()) {
            System.out.println(this.model.printQueue());
            Thread.sleep(this.model.getWaitTime()); // Wait on a given floor for some amount of time before moving again.
            this.travelToFloor(); 
            Thread.sleep(this.model.getWaitTime()); // Spend some time getting to the next floor.
            this.view.setFloorLabel("Elevator is on floor: " + this.model.getCurrentFloor());
          }
        } catch (InterruptedException ie) {
          ie.printStackTrace();
        }
      }
    }).start();
  }
}
