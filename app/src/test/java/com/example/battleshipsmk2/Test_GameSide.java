package com.example.battleshipsmk2;

import com.example.battleshipsmk2.Exceptions.ShipException;
import com.example.battleshipsmk2.Game.EShotResult;
import com.example.battleshipsmk2.Game.GameSettings;
import com.example.battleshipsmk2.Game.GameSide;
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
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.assertTrue;


public class Test_GameSide {
    Player player;
    GameSide gameSide;

    @BeforeMethod
    public void setup() {

        player = new Player("Ben", EPlayerColour.BLUE);
        GameSettings gameSettings = new GameSettings(EGridLayout.CLASSIC);
        gameSide = new GameSide(player, gameSettings);
        assertTrue(gameSide.attemptToAddShipReturnSuccess(0, 0, EShipType.SUBMARINE, EDirection.EAST));
        assertTrue(gameSide.attemptToAddShipReturnSuccess(1, 1, EShipType.PATROL_BOAT, EDirection.SOUTH));

    }

    @Test
    public void test_ShotResults() {

        final IShotResult missedShot = gameSide.fireAtSquare(5,5);
        assertTrue(missedShot instanceof ShotResultWithoutShip);
        assertEquals(missedShot.getShotResult(), EShotResult.MISS);

        final IShotResult hitShot = gameSide.fireAtSquare(1,1);
        assertTrue(hitShot instanceof ShotResultWithoutShip);
        assertEquals(hitShot.getShotResult(), EShotResult.HIT);

        final IShotResult sunkShot = gameSide.fireAtSquare(1,2);
        assertTrue(sunkShot instanceof ShotResultSunkShip);
        assertEquals(sunkShot.getShotResult(), EShotResult.SUNK);
        assertEquals(((ShotResultSunkShip) sunkShot).getSunkShipType(), EShipType.PATROL_BOAT);
    }

    @Test
    public void test_MultipleShotsAtSquareThrowException() {

        final IShotResult missedShot = gameSide.fireAtSquare(5,5);
        assertTrue(missedShot instanceof ShotResultWithoutShip);
        assertEquals(missedShot.getShotResult(), EShotResult.MISS);
        assertThrows(ShipException.class, () ->{
            gameSide.fireAtSquare(5,5);
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

    @Test
    public void test_CreatedShipsAreStored(){
        assertEquals(gameSide.numberOfShips(), 2);
        assertEquals(gameSide.numberOfShipsOfType(EShipType.SUBMARINE), 1);
        assertEquals(gameSide.numberOfShipsOfType(EShipType.PATROL_BOAT), 1);
        assertFalse(gameSide.isFleetDestroyed());

        //Destroy first ship
        int[] submarinePositions = new int[]{0,1,2};
        for (int i = 0; i < submarinePositions.length; i++){
            IShotResult shotResult = gameSide.fireAtSquare(submarinePositions[i]);
            if (i == submarinePositions.length - 1){
                assertEquals(shotResult.getShotResult(), EShotResult.SUNK);
            } else {
                assertEquals(shotResult.getShotResult(), EShotResult.HIT);
                assertFalse(gameSide.isFleetDestroyed());
            }
        }
        assertFalse(gameSide.isFleetDestroyed());
        //Destroy second ship

        int[] patrolBoatPositions = new int[]{11,21};
        for (int i = 0; i < patrolBoatPositions.length; i++){
            IShotResult shotResult = gameSide.fireAtSquare(patrolBoatPositions[i]);
            if (i == patrolBoatPositions.length - 1){
                assertEquals(shotResult.getShotResult(), EShotResult.SUNK);
            } else {
                assertEquals(shotResult.getShotResult(), EShotResult.HIT);
                assertFalse(gameSide.isFleetDestroyed());
            }
        }
        assertTrue(gameSide.isFleetDestroyed());
    }



}