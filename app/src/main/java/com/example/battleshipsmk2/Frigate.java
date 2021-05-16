package com.example.battleshipsmk2;

public class Frigate extends Ship {


    Frigate(int length, String name) {
        super(length, name);
    }

    @Override
    public int getLength() {
        return super.getLength();
    }

    @Override
    public boolean isSunk() {
        return super.isSunk();
    }

    @Override
    public EShipType getType() {
        return EShipType.FRIGATE;
    }

    @Override
    public String getName() {
        return super.getName();
    }

}
