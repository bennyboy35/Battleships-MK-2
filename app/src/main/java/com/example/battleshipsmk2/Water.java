package com.example.battleshipsmk2;

public class Water implements IFeature{

    Water(){

    }

    @Override
    public String getName() {
        return "Water";
    }

    @Override
    public boolean isShip() {
        return false;
    }

    @Override
    public boolean isWater() {
        return true;
    }


}
