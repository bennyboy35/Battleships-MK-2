package com.example.battleshipsmk2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class Test_ShipFactory {

    private GridDimensions gridDimensions;

    @Test(dataProvider = "shipTests")
    public void test_ShipCreation(EShipType shipType, String expectedName, int expectedLength) {

            IShip ship = ShipFactory.buildShip(shipType);
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