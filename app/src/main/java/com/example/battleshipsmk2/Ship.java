package com.example.battleshipsmk2;

public abstract class Ship implements IShip {

    private final int length;
    private final int health;
    private final String name;

    Ship(int length, String name) {

        this.length = length;
        health = length;
        this.name = name;

    }

    @Override
    public int getLength() {

        return length;

    }

    @Override
    public boolean isSunk() {

        return health <= 0;

    }

    @Override
    public String getName() {

        return name;

    }

    @Override
    public boolean isShip() {
        return true;
    }

    @Override
    public boolean isWater() {
        return false;
    }
}
