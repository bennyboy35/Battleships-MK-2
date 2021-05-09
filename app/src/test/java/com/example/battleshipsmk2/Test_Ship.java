package com.example.battleshipsmk2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Test_Ship {

    @Test(dataProvider = "ships")
    public void test_ShipHealth(EShipType shipType) {
        IShip ship = ShipFactory.buildShip(shipType);
        for (int i = 0; i <= ship.getLength(); i++) {
            ship.hitShip();
            if (i >= ship.getLength() - 1) {
                assertTrue(ship.isSunk());
            } else {
                assertFalse(ship.isSunk());
            }
        }
    }


    @DataProvider(name = "ships")
    public Object[][] shipTests() {

        return new Object[][]{
                {EShipType.SUBMARINE},
                {EShipType.DESTROYER},
                {EShipType.AIRCRAFT_CARRIER},
                {EShipType.FRIGATE},
                {EShipType.PATROL_BOAT},


        };
    }
}
