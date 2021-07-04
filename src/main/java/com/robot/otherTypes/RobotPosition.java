package com.robot.otherTypes;

public class RobotPosition {

    private final int x;
    private final int y;
    private FacingDirection facingDirection;

    public RobotPosition(final int x, final int y, final FacingDirection facingDirection) {
        this.x = x;
        this.y = y;
        this.facingDirection = facingDirection;
    }


    RobotPosition(RobotPosition robotPosition) {
        x = robotPosition.getX();
        y = robotPosition.getY();
        facingDirection = robotPosition.getFacingDirection();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public FacingDirection getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(FacingDirection direction) {
        facingDirection = direction;
    }

    @Override
    public String toString() {
        return "x=" + x + " y=" + y  + " direction=" + facingDirection.toString();
    }

}