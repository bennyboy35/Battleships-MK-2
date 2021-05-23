package com.example.battleshipsmk2.Ships;

public interface IShip extends IFeature{

    int getLength();

    boolean isSunk();
    EShipType getType();
    void hitShip(int squareIndex);
}
