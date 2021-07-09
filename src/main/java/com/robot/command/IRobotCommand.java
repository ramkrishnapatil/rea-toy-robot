package com.robot.command;

import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;

/**
 * Robot command.
 */
public interface IRobotCommand {

    /**
     * Execute the Robot command
     * @param tableTop TableTop where the Robot is placed
     * @param toyrobot Robot
     */
    void execute(final TableTop tableTop, final ToyRobot toyrobot);
}
