package org.elevator.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.elevator.controller.*;
import org.elevator.model.*;
import org.elevator.view.*;

import org.mockito.Mock;

class elevatorControllerTest {
  @Mock Elevator mockModel = new Elevator();
  @Mock ElevatorView mockView = new ElevatorView();

  ElevatorController ctrl = new ElevatorController(mockModel, mockView);

  @Test
  void testEnqueueFloor() {
    
  }
}
