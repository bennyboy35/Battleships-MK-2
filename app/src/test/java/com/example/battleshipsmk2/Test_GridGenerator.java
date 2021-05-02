package com.example.battleshipsmk2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Test_GridGenerator {

    private GridDimensions gridDimensions;


    @Test
    public void test_GenerateGrid3x3() {
        Grid grid = GridGenerator.generateGrid(3,3);
        assertEquals(9, grid.getGridDimensions().getNumberOfSquares());
        assertEquals(2, grid.getSquare(2).getIndex());
        assertEquals(7, grid.getSquare(1,2).getIndex());

    }

    @Test
    public void test_GenerateGrid10x8() {
        Grid grid = GridGenerator.generateGrid(10,8);
        assertEquals(80, grid.getGridDimensions().getNumberOfSquares());
        assertEquals(54, grid.getSquare(54).getIndex());
        assertEquals(76, grid.getSquare(6,7).getIndex());
    }


}