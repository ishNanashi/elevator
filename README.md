# Instructions

The Elevator

Provide code that simulates an elevator.  You may use any language (recommend using java or Python). 
Please upload your code Git Hub for a discussion during your interview with our team.
Additionally, document all assumptions and any features that weren't implemented.
Please be prepared to discuss the assumptions and features that were not implemented during your interview.


# Elevator
A single-elevator simulator.

This was tested on both Arch Linux + KDE, and Windows 11, and worked on both. I didn't test on other operating systems so results may vary.

# Assumptions
- There should be some kind of interactive UI
- There can be an arbitrary amount of floors (Chose 6)
- There's a set of buttons to choose which floor to go to.
- The elevator has an arbitrary travel time (10 seconds)
- The elevator waits at a floor for an arbitrary amount of time (5 seconds)

# Not implemented
- Close doors functionality (To start moving sooner)
- Open-doors functionality (To stop at the next floor)
- Emergency stop
- Fault detection/error-handling
- Cancelling a request (eg, pushing the button again)
- Sophisticated scheduling (eg, stopping at nearest floors, instead of just the order the elevator was summoned in)
- Updating the travel-path in real-time.
- Unit testing :(

# Running the program
- Via Gradle: open a terminal, cd to where ever this project is, build and then run it: `./gradlew build` and `./gradlew run` 
- If on Windows: use `gradlew.bat` instead of `gradlew`

# Troubleshooting
"Gradle won't build"
Your JDK may be set to an incompatible version. This project uses version 21.

"I get an UnknownHostException when attempting to build or run gradle"
By default Gradle requires an internet connection in order to download the dependencies you specify in your project.
It's possible to configure Gradle to work in offline mode with cached dependencies, but I didn't look into this too extensively, would require more research.
The easiest solution to this problem is simply to establish an internet connection so that Gradle can download the dependencies.
