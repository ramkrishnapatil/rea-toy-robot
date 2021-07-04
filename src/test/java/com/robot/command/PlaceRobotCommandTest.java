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

public class PlaceRobotCommandTest {

    private ToyRobot robot;
    private TableTop tableTop;

    @Before
    public void setup() {
        robot = new ToyRobot();
        tableTop = new TableTop();
    }

    @Test
    public void validPlaceCommandTest() {
        PlaceRobotCommand placeCommand = new PlaceRobotCommand(new RobotPosition(0, 0, FacingDirection.EAST));

        assertFalse(robot.isPlaced());
        placeCommand.execute(tableTop, robot);
        assertTrue(robot.isPlaced());
        assertEquals(FacingDirection.EAST, robot.getCurrentPosition().getDirection());
        assertEquals(0, robot.getCurrentPosition().getX());
        assertEquals(0, robot.getCurrentPosition().getY());
    }

    @Test
    public void invalidPlaceCommandTest() {
        PlaceRobotCommand placeCommand = new PlaceRobotCommand(new RobotPosition(-1, -5, FacingDirection.EAST));

        assertFalse(robot.isPlaced());
        placeCommand.execute(tableTop, robot);
        assertFalse(robot.isPlaced());
    }
}