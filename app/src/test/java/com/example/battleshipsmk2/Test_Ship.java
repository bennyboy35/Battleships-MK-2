package com.example.battleshipsmk2;

import com.example.battleshipsmk2.Exceptions.ShipException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class Test_Ship {

    @Test(dataProvider = "ships")
    public void test_ShipHealth(EShipType shipType, boolean expectException, boolean expectToBeSunk, int[] hits) {
        IShip ship = ShipFactory.buildShip(shipType);
        if (expectException) {
            assertThrows(ShipException.class, () -> {
                for (int hitIndex : hits) {
                    ship.hitShip(hitIndex);
                }
            });
        } else {
            for (int hitIndex : hits) {
                ship.hitShip(hitIndex);
            }
            assertEquals(ship.isSunk(), expectToBeSunk);
        }
    }


    @DataProvider(name = "ships")
    public Object[][] shipTests() {

        return new Object[][]{
                {EShipType.SUBMARINE, false, true, new int[]{13, 14, 15}},
                {EShipType.DESTROYER, false, true, new int[]{0, 10, 20, 30}},
                {EShipType.AIRCRAFT_CARRIER, false, true, new int[]{26, 25, 24, 23, 22}},
                {EShipType.FRIGATE, false, true, new int[]{1, 63, 149}},
                {EShipType.PATROL_BOAT, false, true, new int[]{0, 100}},

                {EShipType.PATROL_BOAT, false, false, new int[]{}},

                {EShipType.SUBMARINE, true, false, new int[]{13, 13, 15}},
                {EShipType.DESTROYER, false, false, new int[]{0, 10, 20}},
                {EShipType.AIRCRAFT_CARRIER, true, false, new int[]{26, 25, 24, 26, 22}},
                {EShipType.FRIGATE, true, false, new int[]{1, 63, 1, 63}},
                {EShipType.PATROL_BOAT, true, false, new int[]{100, 100}},

        };
    }
}
