package com.example.battleshipsmk2;

import com.example.battleshipsmk2.Grid.GridDimensions;
import com.example.battleshipsmk2.Ships.EShipType;
import com.example.battleshipsmk2.Ships.IShip;
import com.example.battleshipsmk2.Ships.ShipFactory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;


public class Test_ShipFactory {

    private GridDimensions gridDimensions;

    @Test(dataProvider = "shipTests")
    public void test_ShipCreation(EShipType shipType, String expectedName, int expectedLength) {
        gridDimensions = new GridDimensions(10,10);
        int[] positions = gridDimensions.getShipPositionIndexes(0, shipType, EDirection.EAST);
        IShip ship = ShipFactory.buildShip(shipType, positions);
        assertEquals(ship.getName(), expectedName);
        assertEquals(ship.getLength(), expectedLength);
        assertFalse(ship.isSunk());
        assertTrue(ship.isShip());
        assertFalse(ship.isWater());
    }

    @DataProvider(name = "shipTests")
    public Object[][] shipTests() {

        return new Object[][]{
                {EShipType.SUBMARINE, "Submarine", 3},
                {EShipType.DESTROYER, "Destroyer", 4},
                {EShipType.AIRCRAFT_CARRIER, "Aircraft Carrier", 5},
                {EShipType.FRIGATE, "Frigate", 3},
                {EShipType.PATROL_BOAT, "Patrol Boat", 2},


        };
    }

}