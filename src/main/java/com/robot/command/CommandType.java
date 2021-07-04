package com.robot.command;

import com.robot.otherTypes.FacingDirection;
import com.robot.otherTypes.RobotPosition;

/**
 * Commandtypes which Robot can accept.
 */
public enum CommandType {
    PLACE(new PlaceRobotCommand(new RobotPosition(0, 0, FacingDirection.EAST))),
    LEFT(new RotateLeftRobotCommand()),
    RIGHT(new RotateRightRobotCommand()),
    MOVE(new MoveRobotCommand()),
    REPORT(new ReportRobotCommand());

    private final IRobotCommand command;

    CommandType(IRobotCommand command) {
        this.command = command;
    }

    public IRobotCommand getCommand() {
        return command;
    }
}
