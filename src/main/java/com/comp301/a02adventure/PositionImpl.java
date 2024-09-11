package com.comp301.a02adventure;

public class PositionImpl implements Position {

    private final int x;
    private final int y;
    public PositionImpl(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position getNeighbor(Direction direction) {
        if (direction == Direction.NORTH) {
            return new PositionImpl(x, y + 1);
        }
        if (direction == Direction.SOUTH) {
            return new PositionImpl(x, y - 1);
        }
        if (direction == Direction.EAST) {
            return new PositionImpl(x + 1, y);
        }
        if (direction == Direction.WEST) {
            return new PositionImpl(x - 1, y);
        }
        throw new IllegalArgumentException("Invalid direction");
    }
}
