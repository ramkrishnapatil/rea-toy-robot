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

public class RotateLeftRobotCommandTest {

    private ToyRobot robot;
    private TableTop tableTop;
    private RotateLeftRobotCommand leftCommand;

    @Before
    public void setup() {
        robot = new ToyRobot();
        tableTop = new TableTop();
        leftCommand = new RotateLeftRobotCommand();
    }

    @Test
    public void leftCommandTest() {
        leftCommand.execute(tableTop, robot);
        assertFalse(robot.isPlaced());

        robot.place(new RobotPosition(0, 0, FacingDirection.EAST));
        leftCommand.execute(tableTop, robot);

        assertTrue(robot.isPlaced());
        assertEquals(FacingDirection.NORTH, robot.getCurrentPosition().getDirection());
    }
}
