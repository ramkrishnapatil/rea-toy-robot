package com.robot.command;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;
import com.robot.otherTypes.FacingDirection;
import com.robot.otherTypes.RobotPosition;

public class RotateRightRobotCommandTest {

    private ToyRobot robot;
    private TableTop tableTop;
    private RotateRightRobotCommand rightCommand;

    @Before
    public void setup() {
        robot = new ToyRobot();
        tableTop = new TableTop();
        rightCommand = new RotateRightRobotCommand();
    }

    @Test
    public void rightCommandTest() {
        rightCommand.execute(tableTop, robot);
        assertFalse(robot.isPlaced());

        robot.place(new RobotPosition(0, 0, FacingDirection.EAST));
        rightCommand.execute(tableTop, robot);

        assertTrue(robot.isPlaced());
        assertEquals(FacingDirection.SOUTH, robot.getCurrentPosition().getDirection());
    }
}
