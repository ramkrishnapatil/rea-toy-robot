package com.robot.command;

import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;
import com.robot.otherTypes.ObjectPosition;
import com.robot.otherTypes.RobotPosition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Place Robot on TableTop.
 */
public class PlaceObjectCommand implements IRobotCommand {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(PlaceObjectCommand.class.getSimpleName());

    @Override
    public void execute(final TableTop tableTop, final ToyRobot robot) {

        if (robot.isPlaced()) {
            RobotPosition position = robot.getCurrentPosition();
            final RobotPosition toPosition = position.add(position.getDirection().moveForward());
            ObjectPosition objectPosition = new ObjectPosition(toPosition.getX(), toPosition.getY());
            tableTop.addObject(objectPosition);
        } else {
            LOGGER.error(() -> "ToyRobot not placed yet");
        }
    }
}
