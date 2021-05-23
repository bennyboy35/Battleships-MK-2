package com.example.battleshipsmk2;

import com.example.battleshipsmk2.Exceptions.ShipException;
import com.example.battleshipsmk2.Ships.EShipType;
import com.example.battleshipsmk2.Ships.IShip;
import com.example.battleshipsmk2.Ships.ShipFactory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;

public class Test_Ship {

    @Test(dataProvider = "ships")
    public void test_ShipHealth(EShipType shipType, int[] positions, boolean expectException, boolean expectToBeSunk, int[] hits) {
        IShip ship = ShipFactory.buildShip(shipType, positions);
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
                {EShipType.SUBMARINE, new int[]{13, 14, 15}, false, true, new int[]{13, 14, 15}},
                {EShipType.DESTROYER, new int[]{0, 10, 20, 30}, false, true, new int[]{0, 10, 20, 30}},
                {EShipType.AIRCRAFT_CARRIER, new int[]{26, 25, 24, 23, 22}, false, true, new int[]{26, 25, 24, 23, 22}},
                {EShipType.FRIGATE, new int[]{1, 63, 149}, false, true, new int[]{1, 63, 149}},
                {EShipType.PATROL_BOAT, new int[]{0, 100}, false, true, new int[]{0, 100}},

                {EShipType.PATROL_BOAT, new int[]{13, 14}, false, false, new int[]{}},

                {EShipType.SUBMARINE, new int[]{13, 14, 15}, true, false, new int[]{13, 13, 15}},
                {EShipType.DESTROYER, new int[]{0, 10, 20, 30}, false, false, new int[]{0, 10, 20}},
                {EShipType.AIRCRAFT_CARRIER, new int[]{26, 25, 24, 23, 22}, true, false, new int[]{26, 25, 24, 26, 22}},
                {EShipType.FRIGATE, new int[]{1, 2, 3}, true, false, new int[]{1, 2, 5}},
                {EShipType.PATROL_BOAT, new int[]{90, 100}, true, false, new int[]{100, 100}},

        };
    }
}
