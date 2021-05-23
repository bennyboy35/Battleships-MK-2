package com.example.battleshipsmk2.Ships;

public class Submarine extends Ship {


    Submarine(int length, String name, int... positions) {
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
        return EShipType.SUBMARINE;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
