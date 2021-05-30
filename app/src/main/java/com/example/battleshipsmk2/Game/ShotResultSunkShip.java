package com.example.battleshipsmk2.Game;

import com.example.battleshipsmk2.Ships.EShipType;

public class ShotResultSunkShip implements IShotResultWithShip {

    private final EShipType sunkShipType;

    public ShotResultSunkShip(EShipType sunkShip){
        this.sunkShipType = sunkShip;
    }

    @Override
    public EShotResult getShotResult() {
        return EShotResult.SUNK;
    }

    @Override
    public EShipType getSunkShipType() {
        return sunkShipType;
    }
}
