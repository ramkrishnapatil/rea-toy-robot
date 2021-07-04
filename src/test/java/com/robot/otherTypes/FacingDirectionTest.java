package com.robot.otherTypes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FacingDirectionTest {

    @Test
    public void testLeftFullCircleTurn() {
        FacingDirection direction = FacingDirection.EAST;

        direction = direction.left();
        assertEquals(FacingDirection.NORTH, direction);

        direction = direction.left();
        assertEquals(FacingDirection.WEST, direction);

        direction = direction.left();
        assertEquals(FacingDirection.SOUTH, direction);

        direction = direction.left();
        assertEquals(FacingDirection.EAST, direction);
    }

    @Test
    public void testRightFullCircleTurn() {
        FacingDirection direction = FacingDirection.NORTH;

        direction = direction.right();
        assertEquals(FacingDirection.EAST, direction);

        direction = direction.right();
        assertEquals(FacingDirection.SOUTH, direction);

        direction = direction.right();
        assertEquals(FacingDirection.WEST, direction);

        direction = direction.right();
        assertEquals(FacingDirection.NORTH, direction);

    }
}