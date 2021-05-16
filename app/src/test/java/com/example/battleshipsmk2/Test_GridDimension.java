package com.example.battleshipsmk2;

import com.example.battleshipsmk2.Exceptions.GridDimensionsException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.junit.Assert.*;


public class Test_GridDimension {

    private GridDimensions gridDimensions;

    @Test(dataProvider = "outOfBounds")
    public void Test_IndexOutOfBounds(int width, int height, int colIndex, int rowIndex) {
        gridDimensions = new GridDimensions(width, height);
        assertThrows(GridDimensionsException.class,() ->{
            gridDimensions.getSquareIndex(colIndex, rowIndex);
        });

    }

    @Test(dataProvider = "indexes")
    public void Test_Indexes(int width, int height, int expectedNoOfSquares, int squareIndex, int colIndex, int rowIndex) {
        gridDimensions = new GridDimensions(width, height);
        assertEquals(expectedNoOfSquares, gridDimensions.getNumberOfSquares());
        assertEquals(rowIndex ,gridDimensions.getRowIndex(squareIndex));
        assertEquals(colIndex ,gridDimensions.getColumnIndex(squareIndex));
        assertEquals(squareIndex, gridDimensions.getSquareIndex(colIndex, rowIndex));

    }

    @Test(dataProvider = "inBounds")
    public void Test_InBounds(int width, int height, int colIndex, int rowIndex, EShipType shipType, EDirection direction, boolean inbounds) {
        gridDimensions = new GridDimensions(width, height);
        assertEquals(inbounds, gridDimensions.willShipRemainInBounds(colIndex, rowIndex, shipType, direction));

    }

    @Test(dataProvider = "shipPositions")
    public void Test_shipPositions(int width, int height, int colIndex, int rowIndex, EShipType shipType, EDirection direction, int[] positions) {
        gridDimensions = new GridDimensions(width, height);
        assertArrayEquals(positions, gridDimensions.getShipPositionIndexes(colIndex, rowIndex, shipType, direction));

    }

    @DataProvider(name = "outOfBounds")
    public Object[][] OutBoundTests() {

        return new Object[][]{
                {5, 5, 7, 2},
                {5, 5, 3, 9},
                {7, 9, 3, 9}
        };
    }

    @DataProvider(name = "inBounds")
    public Object[][] inBoundTests() {

        return new Object[][]{
                {5, 5, 7, 2, EShipType.PATROL_BOAT, EDirection.SOUTH, false},
                {5, 5, 3, 9, EShipType.PATROL_BOAT, EDirection.SOUTH, false},

                {5, 5, 0, 0, EShipType.PATROL_BOAT, EDirection.NORTH, false},
                {5, 5, 0, 0, EShipType.DESTROYER, EDirection.NORTH, false},
                {5, 5, 0, 0, EShipType.DESTROYER, EDirection.SOUTH, true},
                {5, 5, 2, 1, EShipType.DESTROYER, EDirection.SOUTH, true},
                {5, 5, 2, 2, EShipType.DESTROYER, EDirection.SOUTH, false},
                {5, 5, 2, 2, EShipType.SUBMARINE, EDirection.SOUTH, true},

                {5, 5, 0, 0, EShipType.PATROL_BOAT, EDirection.WEST, false},
                {5, 5, 0, 0, EShipType.DESTROYER, EDirection.WEST, false},
                {5, 5, 0, 0, EShipType.DESTROYER, EDirection.EAST, true},
                {5, 5, 2, 1, EShipType.DESTROYER, EDirection.EAST, false},
                {5, 5, 2, 2, EShipType.DESTROYER, EDirection.EAST, false},
                {5, 5, 2, 2, EShipType.SUBMARINE, EDirection.EAST, true},

                {10, 8, 2, 1, EShipType.FRIGATE, EDirection.NORTH, false},
                {10, 8, 6, 6, EShipType.AIRCRAFT_CARRIER, EDirection.EAST, false},
                {10, 8, 2, 9, EShipType.FRIGATE, EDirection.SOUTH, false},
                {10, 8, 11, 2, EShipType.AIRCRAFT_CARRIER, EDirection.WEST, false},
                {10, 8, 2, 2, EShipType.FRIGATE, EDirection.NORTH, true},
                {10, 8, 2, 2, EShipType.AIRCRAFT_CARRIER, EDirection.EAST, true},
                {10, 8, 2, 2, EShipType.FRIGATE, EDirection.SOUTH, true},
                {10, 8, 6, 7, EShipType.AIRCRAFT_CARRIER, EDirection.WEST, true},
        };
    }

    @DataProvider(name = "indexes")
    public Object[][] shipTests() {

        return new Object[][]{
                {3, 3, 9, 0, 0, 0},
                {3, 3, 9, 1, 1, 0},
                {3, 3, 9, 2, 2, 0},
                {3, 3, 9, 3, 0, 1},
                {3, 3, 9, 4, 1, 1},
                {3, 3, 9, 5, 2, 1},
                {3, 3, 9, 6, 0, 2},
                {3, 3, 9, 7, 1, 2},
                {3, 3, 9, 8, 2, 2},

                {10, 8, 80, 0, 0, 0},
                {10, 8, 80, 19, 9, 1},
                {10, 8, 80, 20, 0, 2},
                {10, 8, 80, 70, 0, 7},
                {10, 8, 80, 79, 9, 7},
                {10, 8, 80, 12, 2, 1},
                {10, 8, 80, 56, 6, 5},
                {10, 8, 80, 43, 3, 4},
                {10, 8, 80, 27, 7, 2},

        };
    }

    @DataProvider(name = "shipPositions")
    public Object[][] ShipPositions() {

        return new Object[][]{
                {5, 5, 7, 2, EShipType.PATROL_BOAT, EDirection.SOUTH, new int[0]},
                {5, 5, 3, 9, EShipType.PATROL_BOAT, EDirection.SOUTH, new int[0]},

                {5, 5, 0, 0, EShipType.PATROL_BOAT, EDirection.NORTH, new int[0]},
                {5, 5, 0, 0, EShipType.DESTROYER, EDirection.NORTH, new int[0]},
                {5, 5, 0, 0, EShipType.DESTROYER, EDirection.SOUTH, new int[]{0,5,10,15}},
                {5, 5, 2, 1, EShipType.DESTROYER, EDirection.SOUTH, new int[]{7,12,17,22}},
                {5, 5, 2, 2, EShipType.DESTROYER, EDirection.SOUTH, new int[0]},
                {5, 5, 2, 2, EShipType.SUBMARINE, EDirection.SOUTH, new int[]{12,17,22}},

                {5, 5, 0, 0, EShipType.PATROL_BOAT, EDirection.WEST, new int[0]},
                {5, 5, 0, 0, EShipType.DESTROYER, EDirection.WEST, new int[0]},
                {5, 5, 0, 0, EShipType.DESTROYER, EDirection.EAST, new int[]{0,1,2,3}},
                {5, 5, 2, 1, EShipType.DESTROYER, EDirection.EAST, new int[0]},
                {5, 5, 2, 2, EShipType.DESTROYER, EDirection.EAST, new int[0]},
                {5, 5, 2, 2, EShipType.SUBMARINE, EDirection.EAST, new int[]{12,13,14}},

                {10, 8, 2, 1, EShipType.FRIGATE, EDirection.NORTH, new int[0]},
                {10, 8, 6, 6, EShipType.AIRCRAFT_CARRIER, EDirection.EAST, new int[0]},
                {10, 8, 2, 9, EShipType.FRIGATE, EDirection.SOUTH, new int[0]},
                {10, 8, 11, 2, EShipType.AIRCRAFT_CARRIER, EDirection.WEST, new int[0]},
                {10, 8, 2, 2, EShipType.FRIGATE, EDirection.NORTH, new int[]{2,12,22}},
                {10, 8, 2, 2, EShipType.AIRCRAFT_CARRIER, EDirection.EAST, new int[]{22,23,24,25,26}},
                {10, 8, 2, 2, EShipType.FRIGATE, EDirection.SOUTH, new int[]{22,32,42}},
                {10, 8, 6, 7, EShipType.AIRCRAFT_CARRIER, EDirection.WEST, new int[]{72,73,74,75,76}},
        };
    }

}