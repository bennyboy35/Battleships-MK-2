package com.example.battleshipsmk2;

public class PatrolBoat extends Ship {


    PatrolBoat(int length, String name) {
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
        return EShipType.PATROL_BOAT;
    }

    @Override
    public String getName() {
        return super.getName();
    }
}
