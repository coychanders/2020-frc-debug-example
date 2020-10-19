### 2020 FRC Debugging Example
Used to teach debugging

There are 3 subsystems - elevator, arm, collector
Imagine an arm on an elevator with a collector on the end that can such an object in and eject it out.
The elevator can be in one of three positions - low, medium and high
The arm can either be retracted or extended
The collector can either intake, eject or stop. Stop is the defualt state.
To pick up a game piece, the elavator would be low, the arm extended, and collector intaking
To place a game piece, the elevator would either be medium or high, the arem extended, and the collector ejecting
There is also a protect mode where the arm is retracted, the elevator is low and the collector is stopped.

These are the Xbox buttons for each individual action.

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
