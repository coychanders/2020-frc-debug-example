### 2020 FRC Debugging Example
Used to teach debugging

There are 3 subsystems - elevator, arm, collector
Imagine an arm on an elevator with a collector on the end that can such an object in and eject it out.
The elevator can be in one of three states - low, medium and high
The elevator will stay in a state until another state is requested
The arm can be in one of two state - retracted or extended
The arm will stay in a state until the other state is requested
The collector can in one of three states - intake, eject or stop. Stop is the defualt state.
The collector will stay in the intake or eject state for 1 second and then default to the stop state.

To pick up a game piece, the elavator would be low, the arm extended, and collector intaking
To place a game piece, the elevator would either be medium or high, the arem extended, and the collector ejecting
There is also a protect state where the arm is retracted, the elevator is low and the collector is stopped.

These are the Xbox buttons for each individual state, parallels and sequences.

*** Elevator
dpad_down is elevator low
dpad_right is elevator medium
dpad_up is elevator high

*** Arm
x is arm retract
b is arm extend

*** Collector
y is collector intake
a is collector eject

*** parallels 
left trigger is intake -> [st_elevator_low, st_arm_extend, st_collector_intake]
left bumper is protect -> [st_elevator_low, st_arm_retract] (st_collector_stop is the default)



*** sequences
right trigger is eject medium -> pl_prime_high, st_collector_eject
right bumper is eject high -> pl_prime_medium, st_collector_eject

  where:
   pl_prime_medium -> [st_elevator_medium, st_arm_extend]
   pl_prime_high -> [st_elevator_high, st_arm_extend]



### Debugging Concepts

* What's a debugger?
* Breakpoints
* Stack, stack frame
* Step Over
* Step Into
* Force Step Into
* Step Out
* Drop Frame
* Run to Cursor
* Evaluate Expression
