package com.example.battleshipsmk2;

import com.example.battleshipsmk2.Exceptions.ShipException;
import com.example.battleshipsmk2.Game.EShotResult;
import com.example.battleshipsmk2.Game.IShotResult;
import com.example.battleshipsmk2.Game.ShotResultSunkShip;
import com.example.battleshipsmk2.Game.ShotResultWithoutShip;
import com.example.battleshipsmk2.Grid.Grid;
import com.example.battleshipsmk2.Grid.GridGenerator;
import com.example.battleshipsmk2.Player.EPlayerColour;
import com.example.battleshipsmk2.Player.Player;
import com.example.battleshipsmk2.Ships.EShipType;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;


public class Test_GameSide {
    Player player;
    Grid grid;

    @BeforeMethod
    public void setup() {

        player = new Player("Ben", EPlayerColour.BLUE);
        grid = GridGenerator.generateEmptyGrid(10, 10);
        assertTrue(grid.attemptToAddShipReturnSuccess(0, 0, EShipType.SUBMARINE, EDirection.EAST));
        assertTrue(grid.attemptToAddShipReturnSuccess(1, 1, EShipType.PATROL_BOAT, EDirection.SOUTH));

    }

    @Test
    public void test_ShotResults() {

        final IShotResult missedShot = grid.fireAtSquare(5,5);
        assertTrue(missedShot instanceof ShotResultWithoutShip);
        assertEquals(missedShot.getShotResult(), EShotResult.MISS);

        final IShotResult hitShot = grid.fireAtSquare(1,1);
        assertTrue(hitShot instanceof ShotResultWithoutShip);
        assertEquals(hitShot.getShotResult(), EShotResult.HIT);

        final IShotResult sunkShot = grid.fireAtSquare(1,2);
        assertTrue(sunkShot instanceof ShotResultSunkShip);
        assertEquals(sunkShot.getShotResult(), EShotResult.SUNK);
        assertEquals(((ShotResultSunkShip) sunkShot).getSunkShipType(), EShipType.PATROL_BOAT);
    }

    @Test
    public void test_MultipleShotsAtSquareThrowException() {

        final IShotResult missedShot = grid.fireAtSquare(5,5);
        assertTrue(missedShot instanceof ShotResultWithoutShip);
        assertEquals(missedShot.getShotResult(), EShotResult.MISS);
        assertThrows(ShipException.class, () ->{
            grid.fireAtSquare(5,5);
        });
    }

    @DataProvider(name = "gameSettings")
    public Object[][] gameSettings() {

        return new Object[][]{

                {EShipType.PATROL_BOAT, 0},
                {EShipType.FRIGATE, 4},
                {EShipType.DESTROYER, 7},
                {EShipType.AIRCRAFT_CARRIER, 60}
        };
    }

}