package com.robot.command;

import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Rotate Robot on Left.
 */
public class RotateLeftRobotCommand implements IRobotCommand {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(RotateLeftRobotCommand.class.getSimpleName());

    @Override
    public void execute(final TableTop tableTop, final ToyRobot robot) {
        if (robot.isPlaced()) {
            robot.turnLeft();
        } else {
            LOGGER.error(() -> "ToyRobot not placed yet");
        }
    }
}
