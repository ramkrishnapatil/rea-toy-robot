package com.robot.command;

import org.junit.Before;
import org.junit.Test;

import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;
import com.robot.exception.InvalidMoveException;

public class InvalidRobotCommandTest {

    private ToyRobot robot;
    private TableTop tableTop;
    private InvalidRobotCommand invalidCommand;

    @Before
    public void setup() {
        robot = new ToyRobot();
        tableTop = new TableTop();
        invalidCommand = new InvalidRobotCommand("PLACE1");
    }

    @Test(expected = InvalidMoveException.class)
    public void invalidCommandTest() {
        invalidCommand.execute(tableTop, robot);
    }
}
