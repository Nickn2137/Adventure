package com.comp301.a02adventure;

public class PlayerImpl implements Player {
    private String name;
    private Position position;
    private Inventory inventory;

    public PlayerImpl(String name, int startX, int startY) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
        this.position = new PositionImpl(startX, startY);
        this.inventory = new InventoryImpl();
    }

    public String getName() {
        return name;
    }

    public Position getPosition() {
        return position;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void move(Direction direction) {
        this.position = this.position.getNeighbor(direction);
    }
}
