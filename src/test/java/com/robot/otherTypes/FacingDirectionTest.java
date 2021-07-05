package com.robot.otherTypes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FacingDirectionTest {

    @Test
    public void testLeftFullCircleTurn() {
        FacingDirection direction = FacingDirection.EAST;

        direction = direction.rotateLeft();
        assertEquals(FacingDirection.NORTH, direction);

        direction = direction.rotateLeft();
        assertEquals(FacingDirection.WEST, direction);

        direction = direction.rotateLeft();
        assertEquals(FacingDirection.SOUTH, direction);

        direction = direction.rotateLeft();
        assertEquals(FacingDirection.EAST, direction);
    }

    @Test
    public void testRightFullCircleTurn() {
        FacingDirection direction = FacingDirection.NORTH;

        direction = direction.rotateRight();
        assertEquals(FacingDirection.EAST, direction);

        direction = direction.rotateRight();
        assertEquals(FacingDirection.SOUTH, direction);

        direction = direction.rotateRight();
        assertEquals(FacingDirection.WEST, direction);

        direction = direction.rotateRight();
        assertEquals(FacingDirection.NORTH, direction);

    }
}