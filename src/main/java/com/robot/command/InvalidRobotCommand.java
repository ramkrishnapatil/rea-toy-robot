package com.robot.command;

import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;
import com.robot.exception.InvalidMoveException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Invalid Robot command.
 */
public class InvalidRobotCommand implements IRobotCommand {

    private final String command;
    private static final Logger LOGGER = LogManager.getLogger(InvalidRobotCommand.class.getSimpleName());

    InvalidRobotCommand(String commandStr) {
        command = commandStr;
    }

    @Override
    public void execute(final TableTop tableTop, final ToyRobot robot) {
        LOGGER.error("Invalid command given {}", () -> command);
        throw new InvalidMoveException("Invalid command");
    }
}