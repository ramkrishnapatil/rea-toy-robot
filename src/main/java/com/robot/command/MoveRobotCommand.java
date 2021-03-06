package com.robot.command;

import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;
import com.robot.otherTypes.RobotPosition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Move Robot to next position.
 */
public class MoveRobotCommand implements IRobotCommand {

    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(MoveRobotCommand.class.getSimpleName());

    @Override
    public void execute(final TableTop tableTop, final ToyRobot robot) {

        if (robot.isPlaced()) {
            final RobotPosition currentLocation = robot.getCurrentPosition();
            final RobotPosition toMove = currentLocation.add(currentLocation.getDirection().moveForward());

            if (tableTop.isValidMove(toMove)) {
                robot.place(toMove);
            } else {
                LOGGER.error("Invalid move: {} ", () -> toMove);
//                throw new InvalidMoveException("Invalid move");
            }
        } else {
            LOGGER.error(() -> "ToyRobot not placed yet");
        }
    }
}