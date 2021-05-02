package com.example.battleshipsmk2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class Test_ShipFactory {

    private GridDimensions gridDimensions;


    @Test
    public void test_GenerateGrid3x3() {
        List<IFeature> ships = new ArrayList<>();


        for(EShipType type: EShipType.values()){

            ships.add(ShipFactory.buildShip(type));

        }
    }


    @Test
    public void Test_scratch() {
        List<IFeature> ships = new ArrayList<>();

        ships.add(new Frigate(3, "Frigate"));
        ships.add(new Water());


    }


}