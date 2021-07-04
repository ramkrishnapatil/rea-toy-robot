package com.robot.command;

import java.util.Optional;

import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;
import com.robot.exception.InvalidMoveException;
import com.robot.otherTypes.RobotPosition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class InvalidRobotCommand implements IRobotCommand {
    private static final Logger LOGGER = LogManager.getLogger(InvalidRobotCommand.class.getSimpleName());
    private final String command;

    InvalidRobotCommand(String commandStr) {
        command = commandStr;
    }

    @Override
    public Optional<RobotPosition> execute(final TableTop tableTop, final ToyRobot robot) {
        LOGGER.error("Invalid command given {}", () -> command);
        throw new InvalidMoveException("Invalid command");
    }
}