package com.comp301.a02adventure;

public class ItemImpl implements Item {

  private final String name;

  public ItemImpl(String name) {

    if (name == null) {
      throw new IllegalArgumentException("Name is null");
    }
    this.name = name;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) {
      return true;
    } else if (other == null) {
      return false;
    }
    ItemImpl var = (ItemImpl) other;
    return name.equals(var.name);
  }

  @Override
  public String toString() {
    return this.name;
  }
}
