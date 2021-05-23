package com.example.battleshipsmk2;

import com.example.battleshipsmk2.Grid.Grid;
import com.example.battleshipsmk2.Grid.GridGenerator;
import com.example.battleshipsmk2.Ships.EShipType;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.fail;

public class Test_Grid {

    private Grid grid;

    @BeforeTest
    public void setup(){
        grid = GridGenerator.generateEmptyGrid(10,10);
    }


    @Test
    public void test_ShipsCannotOverlap() {
        //TODO Create Data provider for this
        //Add first ship
        EShipType shipType = EShipType.SUBMARINE;
        if (!grid.attemptToAddShipReturnSuccess(5,5,shipType,EDirection.NORTH)){
            fail("Unable to add first ship");
        }
        if (grid.attemptToAddShipReturnSuccess(5,5,shipType,EDirection.NORTH)){
            fail("Should be unable to add ship");
        }

    }


    @DataProvider(name = "ships")
    public Object[][] shipTests() {

        return new Object[][]{
                {EShipType.SUBMARINE, false, true, new int[]{13, 14, 15}},
        };
    }

}
