package com.robot.command;

import java.util.Optional;

import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;
import com.robot.otherTypes.RobotPosition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlaceRobotCommand implements IRobotCommand {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(PlaceRobotCommand.class.getSimpleName());

    private RobotPosition robotPosition;

    public PlaceRobotCommand(final RobotPosition robotPosition) {
        this.robotPosition = robotPosition;
    }

    @Override
    public Optional<RobotPosition> execute(final TableTop tableTop, final ToyRobot robot) {
        if (tableTop.isValidMove(robotPosition)) {
            robot.place(robotPosition);
            return Optional.of(robotPosition);
        } else {
            LOGGER.error("Invalid place: {}", () -> robotPosition);
        }
        return Optional.empty();
    }
}
