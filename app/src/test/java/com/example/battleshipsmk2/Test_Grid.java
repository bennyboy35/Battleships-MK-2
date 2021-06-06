package com.example.battleshipsmk2;

import com.example.battleshipsmk2.Grid.Grid;
import com.example.battleshipsmk2.Grid.GridGenerator;
import com.example.battleshipsmk2.Ships.EShipType;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.fail;
import static org.testng.AssertJUnit.assertNull;

public class Test_Grid {

    private Grid grid;

    @BeforeMethod
    public void setup() {
        grid = GridGenerator.generateEmptyGrid(10, 10);
    }


    @Test(dataProvider = "overlappingShips")
    public void test_ShipsCannotOverlap(int colIndex, int rowIndex, EShipType shipType, EDirection direction,
                                        int colIndex2, int rowIndex2, EShipType shipType2, EDirection direction2) {
        //Add first ship
        assertNotNull(grid.attemptToAddShipReturnShip(colIndex, rowIndex, shipType, direction));
        //Add second ship
        assertNull(grid.attemptToAddShipReturnShip(colIndex2, rowIndex2, shipType2, direction2));
    }


    @DataProvider(name = "overlappingShips")
    public Object[][] overlappingShipsDP() {

        return new Object[][]{
                {5, 5, EShipType.SUBMARINE, EDirection.EAST, 5, 5, EShipType.SUBMARINE, EDirection.SOUTH},
                {0, 5, EShipType.SUBMARINE, EDirection.SOUTH, 1, 6, EShipType.PATROL_BOAT, EDirection.WEST},
                {3, 3, EShipType.AIRCRAFT_CARRIER, EDirection.EAST, 5, 3, EShipType.DESTROYER, EDirection.WEST},
                {6, 8, EShipType.FRIGATE, EDirection.NORTH, 6, 2, EShipType.AIRCRAFT_CARRIER, EDirection.SOUTH},
                {6, 6, EShipType.FRIGATE, EDirection.WEST, 5, 7, EShipType.SUBMARINE, EDirection.NORTH},
        };
    }

    @Test(dataProvider = "shipPlacement")
    public void test_AttemptToAddShip(int colIndex, int rowIndex, EShipType shipType, EDirection direction, boolean expectedSuccess) {
        if (expectedSuccess){
            assertNotNull(grid.attemptToAddShipReturnShip(colIndex, rowIndex, shipType, direction));

        } else {
            assertNull(grid.attemptToAddShipReturnShip(colIndex, rowIndex, shipType, direction));
        }

    }


    @DataProvider(name = "shipPlacement")
    public Object[][] shipPlacementDP() {

        return new Object[][]{
                {5, 5, EShipType.SUBMARINE, EDirection.EAST, true},
                {6, 2, EShipType.AIRCRAFT_CARRIER, EDirection.SOUTH, true},
                {9, 5, EShipType.DESTROYER, EDirection.WEST, true},
                {5, 1, EShipType.PATROL_BOAT, EDirection.NORTH, true},
                {4, 7, EShipType.FRIGATE, EDirection.EAST, true},

                {8, 9, EShipType.SUBMARINE, EDirection.EAST, false},
                {6, 8, EShipType.AIRCRAFT_CARRIER, EDirection.SOUTH, false},
                {2, 5, EShipType.DESTROYER, EDirection.WEST, false},
                {5, 0, EShipType.PATROL_BOAT, EDirection.NORTH, false},
                {100, 5, EShipType.SUBMARINE, EDirection.EAST, false},
                {4, 100, EShipType.FRIGATE, EDirection.WEST, false},
        };
    }
}
