package com.example.battleshipsmk2.Grid;

import com.example.battleshipsmk2.Ships.IFeature;
import com.example.battleshipsmk2.Ships.IShip;

public class Square {

    private final int index;
    private final boolean firedAt;
    private IFeature feature;

    Square(int index){

        this.index = index;
        firedAt = false;
        feature = new Water();
    }

    Square(int index, IShip ship){

        this.index = index;
        firedAt = false;
        feature = (IFeature) ship;
    }

    public int getIndex(){

        return index;

    }

    public boolean isFiredAt(){

        return firedAt;
    }

    public boolean hasShip(){

        return feature.isShip();
    }

    public void addShip(IShip ship){

        feature = ship;
    }


}
