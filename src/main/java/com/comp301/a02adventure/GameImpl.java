package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class GameImpl implements Game {
    private final Map map;
    private final Player player;
    public GameImpl(Map map, Player player) {
        if (map == null || player == null) {
            throw new IllegalArgumentException("Null");
        }
        this.map = map;
        this.player = player;
    }

    public Position getPlayerPosition() {
        return player.getPosition();
    }

    public String getPlayerName() {
        return player.getName();
    }

    public List<Item> getPlayerItems() {
        List<Item> second;
        second = new ArrayList<>(player.getInventory().getItems());
        return second;
    }

    public boolean getIsWinner() {
        return map.getNumItems() == 0;
    }

    public void printCellInfo() {
        Cell currCell = map.getCell(player.getPosition());
        System.out.println("Location: " + currCell.getName());
        System.out.println(currCell.getDescription());
        if(currCell.getIsVisited()) {
            System.out.println("You have already visited this location.");
        }
        if(currCell.hasChest()) {
            System.out.println("You found a chest! Type 'open' to see what's inside, or keep moving.");
        }
        currCell.visit();
    }
    public void openChest() {
        Cell currCell = map.getCell(player.getPosition());
        if (!currCell.hasChest()) {
            System.out.println("No chest to open, sorry!");
            return;
        }

        Inventory chest = currCell.getChest();
        if (chest.isEmpty()) {
            System.out.println("The chest is empty.");
        } else {
            player.getInventory().transferFrom(chest);
            System.out.println("You collected these items: " + chest.getItems());
        }
    }

    public boolean canMove(Direction direction) {
        Position newPos = player.getPosition().getNeighbor(direction);
        if (newPos.getX() < 0 || newPos.getX() >= map.getWidth() || newPos.getY() < 0 || newPos.getY() >= map.getHeight()) {
            return false;
        }

        Cell nullCell = map.getCell(newPos);
        return nullCell != null;
    }

    public void move(Direction direction) {
        if (canMove(direction)) {
            player.move(direction);
            printCellInfo();
        } else {
            System.out.println("You can't go that way! Try another direction.");
        }
    }
}
