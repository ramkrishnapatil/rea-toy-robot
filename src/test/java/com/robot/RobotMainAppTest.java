package com.robot;

import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.robot.command.RobotCommandFactory;
import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;
import com.robot.otherTypes.FacingDirection;

public class RobotMainAppTest {

    private TableTop tableTop;
    private ToyRobot robot;

    @Before
    public void setup() {
        tableTop = new TableTop();
        robot = new ToyRobot();
    }

    @Test
    public void sampleATest() {
        final List<String> commands = new ArrayList<>();
        commands.add("PLACE 0,0,NORTH");
        commands.add("PLACE_OBJECT");
        commands.add("MOVE");
        commands.add("REPORT");
        executeCommands(commands);

        assertEquals("X position", 0, robot.getCurrentPosition().getX());
        assertEquals("Y position", 0, robot.getCurrentPosition().getY());
        assertEquals("Direction ", FacingDirection.NORTH, robot.getCurrentPosition().getDirection());
    }

    @Test
    public void sampleBTest() {
        final List<String> commands = new ArrayList<>();
        commands.add("PLACE 0,0,NORTH");
        commands.add("LEFT");
        commands.add("REPORT");
        executeCommands(commands);

        assertEquals("X position", 0, robot.getCurrentPosition().getX());
        assertEquals("Y position", 0, robot.getCurrentPosition().getY());
        assertEquals("Direction ", FacingDirection.WEST, robot.getCurrentPosition().getDirection());
    }

    @Test
    public void sampleCTest() {
        final List<String> commands = new ArrayList<>();
        commands.add("PLACE 1,2,EAST");
        commands.add("MOVE");
        commands.add("MOVE");
        commands.add("LEFT");
        commands.add("MOVE");
        commands.add("REPORT");
        executeCommands(commands);

        assertEquals("X position", 3, robot.getCurrentPosition().getX());
        assertEquals("Y position", 3, robot.getCurrentPosition().getY());
        assertEquals("Direction ", FacingDirection.NORTH, robot.getCurrentPosition().getDirection());
    }

    @Test
    public void testWithoutPlace() {
        final List<String> commands = new ArrayList<>();
        commands.add("LEFT");
        commands.add("REPORT");
        commands.add("RIGHT");
        commands.add("MOVE");
        executeCommands(commands);

        assertNull(robot.getCurrentPosition());
    }

    @Test
    public void fileInputTest() {
        String[] args = new String[] { "src/test/resources/SampleA.txt" };
        System.out.println(String.format("file.encoding: %s", System.getProperty("file.encoding")));
        System.out.println(String.format("defaultCharset: %s", Charset.defaultCharset().name()));
        RobotMainApp robotMainApp = new RobotMainApp();
        robotMainApp.input(args)
                        .forEach(command -> RobotCommandFactory.getInstance().getCommand(command).execute(tableTop, robot));
        assertEquals("X position", 0, robot.getCurrentPosition().getX());
        assertEquals("Y position", 1, robot.getCurrentPosition().getY());
        assertEquals("Direction ", FacingDirection.NORTH, robot.getCurrentPosition().getDirection());
    }

    @Test
    public void unknownInputFileTest() {
        String[] args = new String[] { "src/test/resources/UnknownFile.txt" };
        RobotMainApp robotMainApp = new RobotMainApp();
        robotMainApp.input(args)
                        .forEach(command -> RobotCommandFactory.getInstance().getCommand(command).execute(tableTop, robot));
        assertFalse(robot.isPlaced());
    }

    @Test
    public void unknownInputTest() {
        String[] args = new String[] { "A", "B" };
        RobotMainApp robotMainApp = new RobotMainApp();
        robotMainApp.input(args)
                        .forEach(command -> RobotCommandFactory.getInstance().getCommand(command).execute(tableTop, robot));
        assertFalse(robot.isPlaced());
    }

    private void executeCommands(final List<String> commands) {
        commands.forEach(command -> RobotCommandFactory.getInstance().getCommand(command).execute(tableTop, robot));
    }

}