package com.example.battleshipsmk2;

import com.example.battleshipsmk2.Exceptions.ShipException;

import java.util.ArrayList;
import java.util.List;

public abstract class Ship implements IShip {

    private final int length;
    private int health;
    private final String name;
    private final List<Integer> hits;

    Ship(int length, String name) {

        this.length = length;
        health = length;
        this.name = name;
        hits = new ArrayList<>(length);
    }

    @Override
    public int getLength() {

        return length;

    }


    @Override
    public void hitShip(int squareIndex) {
        if (!hits.contains(squareIndex)) {
            health--;
            hits.add(squareIndex);
        } else {
            throw new ShipException("Ship has been hit twice on the same square");
        }

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
