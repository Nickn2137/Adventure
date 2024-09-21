package com.comp301.a02adventure;

public class MapImpl implements Map {
    private final Cell[][] grid;
    private final int width;
    private final int height;
    private final int numItems;


    public MapImpl(int width, int height, int numItems) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be positive");
        }
        this.width = width;
        this.height = height;
        this.numItems = numItems;
        this.grid = new Cell[height][width];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Cell getCell(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IndexOutOfBoundsException("Coordinates out of bounds");
        }
        return grid[y][x];
    }

    public Cell getCell(Position position) {
        if (position == null) {
            throw new IllegalArgumentException("Position null");
        }
        return getCell(position.getX(), position.getY());
    }

    public int getNumItems() {
        return numItems;
    }

    public void initCell(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IndexOutOfBoundsException("Coordinates out of bounds");
        }
        grid[y][x] = new CellImpl(x, y);
    }
}
