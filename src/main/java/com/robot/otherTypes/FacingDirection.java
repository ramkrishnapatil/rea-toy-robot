package com.robot.otherTypes;

public enum FacingDirection {

    NORTH {
        @Override
        public FacingDirection rotateLeft() {
            return WEST;
        }

        @Override
        public FacingDirection rotateRight() {
            return EAST;
        }

        @Override
        public RobotPosition moveForward() {
            return new RobotPosition(0, 1, NORTH);
        }
    },
    SOUTH {
        @Override
        public FacingDirection rotateLeft() {
            return EAST;
        }

        @Override
        public FacingDirection rotateRight() {
            return WEST;
        }

        @Override
        public RobotPosition moveForward() {
            return new RobotPosition(0, -1, SOUTH);
        }
    },
    EAST {
        @Override
        public FacingDirection rotateLeft() {
            return NORTH;
        }

        @Override
        public FacingDirection rotateRight() {
            return SOUTH;
        }

        @Override
        public RobotPosition moveForward() {
            return new RobotPosition(1, 0, EAST);
        }
    },
    WEST {
        @Override
        public FacingDirection rotateLeft() {
            return SOUTH;
        }

        @Override
        public FacingDirection rotateRight() {
            return NORTH;
        }

        @Override
        public RobotPosition moveForward() {
            return new RobotPosition(-1, 0, WEST);
        }
    };

    /**
     * @return Rotate left of current direction
     */
    public abstract FacingDirection rotateLeft();

    /**
     * @return Rotate right of current direction
     */
    public abstract FacingDirection rotateRight();

    /**
     * @return forward move from current direction
     */
    public abstract RobotPosition moveForward();
}
