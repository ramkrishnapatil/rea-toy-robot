package com.robot.command;

import java.util.Optional;

import com.robot.entities.TableTop;
import com.robot.entities.ToyRobot;
import com.robot.otherTypes.RobotPosition;

public interface IRobotCommand {
    Optional<RobotPosition> execute(final TableTop tableTop, final ToyRobot toyrobot);
}
