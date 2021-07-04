package com.robot.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;
import com.robot.exception.InvalidMoveException;
import com.robot.otherTypes.FacingDirection;
import com.robot.otherTypes.RobotPosition;

public class MoveRobotCommandTest {

    private ToyRobot robot;
    private TableTop tableTop;
    private MoveRobotCommand moveCommand;

    @Before
    public void setup() {
        robot = new ToyRobot();
        tableTop = new TableTop();
        moveCommand = new MoveRobotCommand();
    }

    @Test
    public void moveCommandTest() {
        moveCommand.execute(tableTop, robot);
        assertFalse(robot.isPlaced());

        robot.place(new RobotPosition(0, 0, FacingDirection.EAST));
        moveCommand.execute(tableTop, robot);

        assertTrue(robot.isPlaced());
        assertEquals(FacingDirection.EAST, robot.getCurrentPosition().getDirection());
        assertEquals(1, robot.getCurrentPosition().getX());
        assertEquals(0, robot.getCurrentPosition().getY());

        // place at 3, 4, EAST
        robot.place(new RobotPosition(3, 4, FacingDirection.EAST));
        moveCommand.execute(tableTop, robot);
        assertEquals(FacingDirection.EAST, robot.getCurrentPosition().getDirection());
        assertEquals(4, robot.getCurrentPosition().getX());
        assertEquals(4, robot.getCurrentPosition().getY());

        // place at 4, 3, NORTH
        robot.place(new RobotPosition(4, 3, FacingDirection.NORTH));
        moveCommand.execute(tableTop, robot);
        assertEquals(FacingDirection.NORTH, robot.getCurrentPosition().getDirection());
        assertEquals(4, robot.getCurrentPosition().getX());
        assertEquals(4, robot.getCurrentPosition().getY());

        // place at 4, 4, SOUTH
        robot.place(new RobotPosition(4, 4, FacingDirection.SOUTH));
        moveCommand.execute(tableTop, robot);
        assertEquals(FacingDirection.SOUTH, robot.getCurrentPosition().getDirection());
        assertEquals(4, robot.getCurrentPosition().getX());
        assertEquals(3, robot.getCurrentPosition().getY());
    }

    @Test(expected = InvalidMoveException.class)
    public void invalidMoveCommandTest() {
        moveCommand.execute(tableTop, robot);
        assertFalse(robot.isPlaced());

        robot.place(new RobotPosition(0, 0, FacingDirection.WEST));

        // cannot move further
        moveCommand.execute(tableTop, robot);
        // confirm that robot hasn't moved at all.
        assertEquals(FacingDirection.WEST, robot.getCurrentPosition().getDirection());
        assertEquals(0, robot.getCurrentPosition().getX());
        assertEquals(0, robot.getCurrentPosition().getY());

        // place at 4, 4 EAST
        robot.place(new RobotPosition(4, 4, FacingDirection.EAST));

        // cannot move further
        moveCommand.execute(tableTop, robot);
        // confirm that robot hasn't moved at all.
        assertEquals(FacingDirection.EAST, robot.getCurrentPosition().getDirection());
        assertEquals(4, robot.getCurrentPosition().getX());
        assertEquals(4, robot.getCurrentPosition().getY());
    }
}