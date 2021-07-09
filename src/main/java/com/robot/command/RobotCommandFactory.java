package com.robot.command;

import com.robot.otherTypes.FacingDirection;
import com.robot.otherTypes.RobotPosition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Robot command factory
 */
public class RobotCommandFactory {
    private static final Pattern PLACE_COMMAND_PATTERN = Pattern.compile("^(PLACE)\\s(\\d+),(\\d+),((NORTH|WEST|EAST|SOUTH))$");

    private static final RobotCommandFactory instance = new RobotCommandFactory();
    private static final int X_VALUE_GRP = 2;
    private static final int Y_VALUE_GRP = 3;
    private static final int DIRECTION_VALUE_GRP = 4;

    private RobotCommandFactory() {
    }

    public static RobotCommandFactory getInstance() {
        return instance;
    }

    public IRobotCommand getCommand(final String commandStr) {

        final String upperCaseCommand = commandStr.trim().toUpperCase();
        final Matcher matcher = PLACE_COMMAND_PATTERN.matcher(upperCaseCommand);
        if (matcher.find()) {
            final int x = Integer.parseInt(matcher.group(X_VALUE_GRP));
            final int y = Integer.parseInt(matcher.group(Y_VALUE_GRP));
            final FacingDirection facingDirection = FacingDirection.valueOf(matcher.group(DIRECTION_VALUE_GRP));

            return new PlaceRobotCommand(new RobotPosition(x, y, facingDirection));
        }

        try {
            return CommandType.valueOf(upperCaseCommand).getCommand();
        } catch (final IllegalArgumentException e) {
            return new InvalidRobotCommand(upperCaseCommand);
        }
    }
}
