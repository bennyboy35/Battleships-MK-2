package com.example.battleshipsmk2;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;


public class Test_GameSettings {

    @Test(dataProvider = "gameSettings")
    public void test_GameSettings(EShipType shipType, int numberOfShips) {
            GameSettings.setNumberOfShips(shipType, numberOfShips);
            assertEquals(shipType.getNumberOfShips(), numberOfShips);

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