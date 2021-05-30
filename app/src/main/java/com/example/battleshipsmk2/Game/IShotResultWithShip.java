package com.example.battleshipsmk2.Game;

import com.example.battleshipsmk2.Ships.EShipType;
import com.example.battleshipsmk2.Ships.IShip;

public interface IShotResultWithShip extends IShotResult{

    EShipType getSunkShipType();

}
