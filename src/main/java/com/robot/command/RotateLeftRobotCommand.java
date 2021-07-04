package com.robot.command;

import java.util.Optional;

import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;
import com.robot.otherTypes.RobotPosition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RotateLeftRobotCommand implements IRobotCommand {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(RotateLeftRobotCommand.class.getSimpleName());

    @Override
    public Optional<RobotPosition> execute(final TableTop tableTop, final ToyRobot robot) {
        if (robot.isPlaced()) {
            robot.turnLeft();
            return Optional.of(robot.getCurrentPosition());
        } else {
            LOGGER.error(() -> "ToyRobot not placed yet");
        }
        return Optional.empty();
    }
}
