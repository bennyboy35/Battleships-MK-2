package com.example.battleshipsmk2;

public class Destroyer extends Ship {


    Destroyer(int length, String name) {
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
        return EShipType.DESTROYER;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
