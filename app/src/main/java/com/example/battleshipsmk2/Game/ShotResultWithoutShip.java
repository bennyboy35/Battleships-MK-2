package com.example.battleshipsmk2.Game;

import com.example.battleshipsmk2.Exceptions.ShotResultException;
import com.example.battleshipsmk2.Ships.IShip;

public class ShotResultWithoutShip implements IShotResult {

    private final EShotResult shotResult;


    public ShotResultWithoutShip(EShotResult shotResult){
        if(shotResult == EShotResult.SUNK){
            throw new ShotResultException("ShotResultSunkShip should be used when a ship is sunk");
        }
        this.shotResult = shotResult;

    }

    @Override
    public EShotResult getShotResult() {
        return shotResult;
    }
}
