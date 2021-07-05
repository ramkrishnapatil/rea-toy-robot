package com.robot.entities;

import com.robot.otherTypes.RobotPosition;

public class ToyRobot {

    private boolean placed = false;
    private RobotPosition robotPosition;

    public void turnLeft() {
        robotPosition.setDirection(robotPosition.getDirection().rotateLeft());
    }

    public void turnRight() {
        robotPosition.setDirection(robotPosition.getDirection().rotateRight());
    }

    public void place(final RobotPosition toMove) {
        placed = true;
        robotPosition = toMove;
    }

    public boolean isPlaced() {
        return placed;
    }

    public RobotPosition getCurrentPosition() {
        return robotPosition;
    }

}
