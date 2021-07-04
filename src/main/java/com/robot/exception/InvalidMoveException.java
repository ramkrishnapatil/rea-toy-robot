package com.robot.exception;

public class InvalidMoveException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public InvalidMoveException(final String message) {
        super(message);
    }
}
