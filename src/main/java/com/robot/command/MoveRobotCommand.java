package com.robot.command;

import java.util.Optional;

import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;
import com.robot.exception.InvalidMoveException;
import com.robot.otherTypes.RobotPosition;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MoveRobotCommand implements IRobotCommand {
    /**
     * Logger.
     */
    private static final Logger LOGGER = LogManager.getLogger(MoveRobotCommand.class.getSimpleName());

    @Override
    public Optional<RobotPosition> execute(final TableTop tableTop, final ToyRobot robot) {

        if (robot.isPlaced()) {
            final RobotPosition currentLocation = robot.getCurrentPosition();
            final RobotPosition toMove = currentLocation.add(currentLocation.getDirection().forward());

            if (tableTop.isValidMove(toMove)) {
                robot.place(toMove);
                return Optional.of(robot.getCurrentPosition());
            } else {
                LOGGER.error("Invalid move: {} ", () -> toMove);
                throw new InvalidMoveException("Invalid move");
            }
        } else {
            LOGGER.error(() -> "ToyRobot not placed yet");
        }
        return Optional.empty();
    }
}