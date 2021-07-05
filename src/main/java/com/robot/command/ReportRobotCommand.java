package com.robot.command;

import java.util.Optional;

import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;
import com.robot.otherTypes.RobotPosition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Report Robot position.
 */
public class ReportRobotCommand implements IRobotCommand {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(ReportRobotCommand.class.getSimpleName());

    @Override
    public Optional<RobotPosition> execute(final TableTop tableTop, final ToyRobot robot) {
        if (robot.isPlaced()) {
            System.out.println(robot.getCurrentPosition().getX() + " " + robot.getCurrentPosition().getY() + " " + robot.getCurrentPosition().getDirection());
        } else {
            LOGGER.error(() -> "Robot not placed yet");
        }
        return Optional.empty();
    }
}