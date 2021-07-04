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
        this.x = robotPosition.getX();
        this.y = robotPosition.getY();
        this.facingDirection = robotPosition.facingDirection;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public FacingDirection getDirection() {
        return facingDirection;
    }

    public void setDirection(FacingDirection direction) {
        facingDirection = direction;
    }

    public RobotPosition add(final RobotPosition toAdd) {
        return new RobotPosition(x + toAdd.getX(), y + toAdd.getY(), facingDirection);
    }

    @Override
    public String toString() {
        return "x=" + x + " y=" + y  + " direction=" + facingDirection.toString();
    }
}