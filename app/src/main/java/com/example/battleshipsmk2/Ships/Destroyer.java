package com.example.battleshipsmk2.Ships;

public class Destroyer extends Ship {


    Destroyer(int length, String name, int... positions) {
        super(length, name, positions);
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
