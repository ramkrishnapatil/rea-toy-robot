package com.robot.command;

import java.util.Optional;

import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;
import com.robot.otherTypes.RobotPosition;

/**
 * Robot command.
 */
public interface IRobotCommand {

    /**
     * Execute the Robot command
     * @param tableTop TableTop where the Robot is placed
     * @param toyrobot Robot
     * @return The RobotPosition after command execution.
     */
    Optional<RobotPosition> execute(final TableTop tableTop, final ToyRobot toyrobot);
}
