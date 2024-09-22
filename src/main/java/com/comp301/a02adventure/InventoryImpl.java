package com.comp301.a02adventure;

import java.util.ArrayList;
import java.util.List;

public class InventoryImpl implements Inventory {
  private final List<Item> items;

  public InventoryImpl() {
    this.items = new ArrayList<>();
  }

  @Override
  public boolean isEmpty() {
    return items.isEmpty();
  }

  @Override
  public int getNumItems() {
    return items.size();
  }

  public List<Item> getItems() {
    List<Item> second;
    second = new ArrayList<>(items);
    return second;
  }

  public void addItem(Item item) {
    items.add(item);
  }

  public void removeItem(Item item) {
    items.remove(item);
  }

  public void clear() {
    items.clear();
  }

  public void transferFrom(Inventory other) {
    List<Item> otherItems = other.getItems();
    items.addAll(otherItems);
    other.clear();
  }
}
