package com.robot.otherTypes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RobotPositionTest {

    @Test
    public void testRobotPosition() {
        RobotPosition position = new RobotPosition(0, 0, FacingDirection.NORTH);

        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
        assertEquals(FacingDirection.NORTH, position.getDirection());
    }
}