package com.example.battleshipsmk2.Grid;

import com.example.battleshipsmk2.Exceptions.ShipException;
import com.example.battleshipsmk2.Game.EShotResult;
import com.example.battleshipsmk2.Game.IShotResult;
import com.example.battleshipsmk2.Game.ShotResultSunkShip;
import com.example.battleshipsmk2.Game.ShotResultWithoutShip;
import com.example.battleshipsmk2.Ships.IFeature;
import com.example.battleshipsmk2.Ships.IShip;

public class Square {

    private final int index;
    private boolean firedAt;
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

    public boolean hasBeenFiredAt(){

        return firedAt;
    }

    public boolean hasShip(){

        return feature.isShip();
    }

    public void addShip(IShip ship){

        feature = ship;
    }

    public IShotResult fireAtSquare(){
        if (firedAt) {
            throw new ShipException("This square has already been fired at");
        }
        firedAt = true;
        if (feature.isWater()){
            return new ShotResultWithoutShip(EShotResult.MISS);
        }
        damageShip();
        if(isShipSunk()){
            return new ShotResultSunkShip(((IShip) feature).getType());
        }

        return new ShotResultWithoutShip(EShotResult.HIT);
    }

    private void damageShip(){

        if (feature.isWater()){
            throw new ShipException("Trying to damage a ship that does not exists");
        }
        IShip ship = (IShip) feature;
        ship.hitShip(index);
    }

    private boolean isShipSunk(){
        if (feature.isWater()){
            throw new ShipException("Checking is sunk on a ship that does not exist");
        }
        return ((IShip) feature).isSunk();
    }

}
