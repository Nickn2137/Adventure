package com.comp301.a02adventure;

public class CellImpl implements Cell {
    private PositionImpl position;
    private String name;
    private String description;
    private Inventory chest;
    private boolean visited;
    public CellImpl (int x, int y, String name, String description) {
        if (name == null || description == null) {
            throw new IllegalArgumentException("Something is null");
        }
        this.position = new PositionImpl(x,y);
        this.name = name;
        this.description = description;
        this.visited = false;
    }

    public CellImpl(int x, int y) {
        this(x, y, "", "");
    }
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Position getPosition() {
        return this.position;
    }

    public Inventory getChest() {
        return chest;
    }

    public boolean getIsVisited() {
        return visited;
    }

    public boolean hasChest() {
        return chest != null;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Null");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null) {
            throw new IllegalArgumentException("Null");
        }
        this.description = description;
    }

    public void setChest(Inventory chest) {
        if (chest == null) {
            throw new IllegalArgumentException("Null");
        }
        this.chest = chest;
    }

    public void visit() {
        this.visited = true;
    }
}
