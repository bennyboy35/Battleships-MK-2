package com.example.battleshipsmk2;

public interface IShip extends IFeature{

    int getLength();

    boolean isSunk();
    EShipType getType();
    void hitShip();

}
