package com.example.battleshipsmk2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class Test_GridDimension {

    private GridDimensions gridDimensions;


    @Test
    public void test_GetRow3x3() {

        gridDimensions = new GridDimensions(3, 3);
        assertEquals(9, gridDimensions.getNumberOfSquares());

        assertEquals(0, gridDimensions.getRowIndex(0));
        assertEquals(0, gridDimensions.getRowIndex(1));
        assertEquals(0, gridDimensions.getRowIndex(2));
        assertEquals(1, gridDimensions.getRowIndex(3));
        assertEquals(1, gridDimensions.getRowIndex(4));
        assertEquals(1, gridDimensions.getRowIndex(5));
        assertEquals(2, gridDimensions.getRowIndex(6));
        assertEquals(2, gridDimensions.getRowIndex(7));
        assertEquals(2, gridDimensions.getRowIndex(8));

    }


    @Test
    public void test_GetColumn3x3() {

        gridDimensions = new GridDimensions(3, 3);
        assertEquals(9, gridDimensions.getNumberOfSquares());

        assertEquals(0, gridDimensions.getColumnIndex(0));
        assertEquals(1, gridDimensions.getColumnIndex(1));
        assertEquals(2, gridDimensions.getColumnIndex(2));
        assertEquals(0, gridDimensions.getColumnIndex(3));
        assertEquals(1, gridDimensions.getColumnIndex(4));
        assertEquals(2, gridDimensions.getColumnIndex(5));
        assertEquals(0, gridDimensions.getColumnIndex(6));
        assertEquals(1, gridDimensions.getColumnIndex(7));
        assertEquals(2, gridDimensions.getColumnIndex(8));

    }

    @Test
    public void test_GetRow10x8() {

        gridDimensions = new GridDimensions(10, 8);
        assertEquals(80, gridDimensions.getNumberOfSquares());

        assertEquals(0, gridDimensions.getRowIndex(0));
        assertEquals(1, gridDimensions.getRowIndex(19));
        assertEquals(2, gridDimensions.getRowIndex(20));
        assertEquals(7, gridDimensions.getRowIndex(70));
        assertEquals(7, gridDimensions.getRowIndex(79));
        assertEquals(1, gridDimensions.getRowIndex(12));
        assertEquals(5, gridDimensions.getRowIndex(56));
        assertEquals(4, gridDimensions.getRowIndex(43));
        assertEquals(2, gridDimensions.getRowIndex(27));

    }


    @Test
    public void test_GetColumn10x8() {

        gridDimensions = new GridDimensions(10, 8);
        assertEquals(80, gridDimensions.getNumberOfSquares());

        assertEquals(0, gridDimensions.getColumnIndex(0));
        assertEquals(9, gridDimensions.getColumnIndex(19));
        assertEquals(0, gridDimensions.getColumnIndex(20));
        assertEquals(0, gridDimensions.getColumnIndex(70));
        assertEquals(9, gridDimensions.getColumnIndex(79));
        assertEquals(2, gridDimensions.getColumnIndex(12));
        assertEquals(6, gridDimensions.getColumnIndex(56));
        assertEquals(3, gridDimensions.getColumnIndex(43));
        assertEquals(7, gridDimensions.getColumnIndex(27));

    }


    @Test
    public void test_GetSquareIndex3x3() {

        gridDimensions = new GridDimensions(3, 3);
        assertEquals(9, gridDimensions.getNumberOfSquares());

        assertEquals(0, gridDimensions.getSquareIndex(0, 0));
        assertEquals(1, gridDimensions.getSquareIndex(1, 0));
        assertEquals(2, gridDimensions.getSquareIndex(2, 0));
        assertEquals(3, gridDimensions.getSquareIndex(0, 1));
        assertEquals(4, gridDimensions.getSquareIndex(1, 1));
        assertEquals(5, gridDimensions.getSquareIndex(2, 1));
        assertEquals(6, gridDimensions.getSquareIndex(0, 2));
        assertEquals(7, gridDimensions.getSquareIndex(1, 2));
        assertEquals(8, gridDimensions.getSquareIndex(2, 2));

    }


    @Test
    public void test_GetSquareIndex10x8() {

        gridDimensions = new GridDimensions(10, 8);
        assertEquals(80, gridDimensions.getNumberOfSquares());

        assertEquals(0, gridDimensions.getSquareIndex(0 ,0));
        assertEquals(19, gridDimensions.getSquareIndex(9 ,1));
        assertEquals(20, gridDimensions.getSquareIndex(0 ,2 ));
        assertEquals(70, gridDimensions.getSquareIndex(0, 7));
        assertEquals(79, gridDimensions.getSquareIndex(9 , 7));
        assertEquals(12, gridDimensions.getSquareIndex(2, 1));
        assertEquals(56, gridDimensions.getSquareIndex(6,5));
        assertEquals(43, gridDimensions.getSquareIndex(3,4));
        assertEquals(27, gridDimensions.getSquareIndex(7,2));
    }


}