package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private final int degrees;

    public static Direction ofDegrees(int degrees) {
        int fixedDegree = (360+degrees)%360;
        for (Direction i:Direction.values()) {
            if (i.degrees==fixedDegree)
                return i;
        }
        return null;
    }

    public static Direction closestToDegrees(int degrees) {
        int fixedDegree = (360+degrees)%360;
        for (Direction i:Direction.values()) {
            if (i.degrees>fixedDegree-22 && i.degrees<fixedDegree+23)
                return i;
        }
        return null;    }

    public Direction opposite() {
        return Direction.values()[(ordinal()+4)%8];
    }

    public int differenceDegreesTo(Direction direction) {
        int difference = Math.abs(degrees-direction.degrees);
        return difference > 180 ? 360 - difference : difference;
    }
}
