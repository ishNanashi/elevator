package org.elevator.model;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Elevator {
  private int travelTime;
  private int waitTime;
  private int currentFloor;
  private int totalFloors;
  private BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();

  public void enqueue(int floor) {
      this.queue.add(floor);
  }

  public void dequeue() {
      this.queue.poll();
  }

  public Integer peek() {
    return this.queue.peek();
  }

  public String printQueue() {
    return this.queue.toString();
  }

  public boolean queueIsEmpty() {
    return this.queue.isEmpty();
  }

  public boolean queueContainsElement(int val) {
    return this.queue.contains(val);
  }

  public void setTravelTime(int val) {
    this.travelTime = val; 
  }

  public int getTravelTime() {
    return this.travelTime;
  }

  public void setWaitTime(int val) {
    this.waitTime = val; 
  }

  public int getWaitTime() {
    return this.waitTime;
  }

  public void setCurrentFloor(int val) {
    this.currentFloor = val; 
  }

  public int getCurrentFloor() {
    return this.currentFloor;
  }

  public void setTotalFloors(int val) {
    this.totalFloors = val; 
  }

  public int getTotalFloors() {
    return this.totalFloors;
  }
}
