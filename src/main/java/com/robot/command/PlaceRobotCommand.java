package com.robot.command;

import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;
import com.robot.otherTypes.RobotPosition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Place Robot on TableTop.
 */
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
    public void execute(final TableTop tableTop, final ToyRobot robot) {
        if (tableTop.isValidMove(robotPosition)) {
            robot.place(robotPosition);
        } else {
            LOGGER.error("Invalid place: {}", () -> robotPosition);
        }
    }
}
