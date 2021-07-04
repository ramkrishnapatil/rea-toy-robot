package com.robot.otherTypes;

public enum FacingDirection {

    NORTH {
        @Override
        public FacingDirection left() {
            return WEST;
        }

        @Override
        public FacingDirection right() {
            return EAST;
        }

        @Override
        public RobotPosition forward() {
            return new RobotPosition(0, 1, NORTH);
        }
    },
    SOUTH {
        @Override
        public FacingDirection left() {
            return EAST;
        }

        @Override
        public FacingDirection right() {
            return WEST;
        }

        @Override
        public RobotPosition forward() {
            return new RobotPosition(0, -1, SOUTH);
        }
    },
    EAST {
        @Override
        public FacingDirection left() {
            return NORTH;
        }

        @Override
        public FacingDirection right() {
            return SOUTH;
        }

        @Override
        public RobotPosition forward() {
            return new RobotPosition(1, 0, EAST);
        }
    },
    WEST {
        @Override
        public FacingDirection left() {
            return SOUTH;
        }

        @Override
        public FacingDirection right() {
            return NORTH;
        }

        @Override
        public RobotPosition forward() {
            return new RobotPosition(-1, 0, WEST);
        }
    };

    /**
     * @return left of current direction
     */
    public abstract FacingDirection left();

    /**
     * @return right of current direction
     */
    public abstract FacingDirection right();

    /**
     * @return forward move from current direction
     */
    public abstract RobotPosition forward();
}
