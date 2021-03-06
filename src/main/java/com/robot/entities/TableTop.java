package com.robot.entities;

import com.robot.otherTypes.ObjectPosition;
import com.robot.otherTypes.RobotPosition;

import java.util.HashSet;
import java.util.Set;

/**
 * The TableTop where the Robot will be placed.
 */
public class TableTop {

    private final int rows;
    private final int column;

    private static final int MAX_ROWS = 5;
    private static final int MAX_COLS = 5;
    private static final int MIN_ROWS = 0;
    private static final int MIN_COLS = 0;

    private Set<ObjectPosition> objects;

    public TableTop() {
        this(MAX_ROWS, MAX_COLS);
    }

    public TableTop(final int rows, final int cols) {
        if (rows < MIN_ROWS || cols < MIN_COLS) {
            throw new IllegalArgumentException("Table top dimensions should be positive");
        }
        this.rows = rows;
        this.column = cols;
        objects = new HashSet<>();
    }

    public boolean isValidMove(final RobotPosition toMove) {
        if (toMove.getX() > column || toMove.getX() < MIN_COLS
            || toMove.getY() > rows || toMove.getX() < MIN_ROWS) {
            return false;
        }

        ObjectPosition position = new ObjectPosition(toMove.getX(), toMove.getY());
        if (objects.contains(position)) {
            return false;
        }
        return true;
    }

    public void addObject(ObjectPosition position) {
        objects.add(position);
    }

}
