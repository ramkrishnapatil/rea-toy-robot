package com.robot.entities;

import com.robot.otherTypes.RobotPosition;

public class ToyRobot {

    private boolean placed = false;
    private RobotPosition robotPosition;

    public boolean isPlaced() {
        return placed;
    }

    public RobotPosition getCurrentPosition() {
        return robotPosition;
    }
}
