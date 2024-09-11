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
        if (this.toString() == other.toString()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
