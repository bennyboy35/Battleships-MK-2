package com.example.battleshipsmk2;

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





}
