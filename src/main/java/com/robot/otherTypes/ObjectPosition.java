package com.robot.otherTypes;

import java.util.Objects;

/**
 * Robot position X, Y coordinates.
 */
public class ObjectPosition {

    private final int x;
    private final int y;

    public ObjectPosition(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ObjectPosition that = (ObjectPosition) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}