package com.robot.command;

import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Rotate Robot on right.
 */
public class RotateRightRobotCommand implements IRobotCommand {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(RotateRightRobotCommand.class.getSimpleName());

    @Override
    public void execute(final TableTop tableTop, final ToyRobot robot) {
        if (robot.isPlaced()) {
            robot.turnRight();
        } else {
            LOGGER.error(() -> "Robot not placed yet");
        }
    }
}