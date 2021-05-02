package com.example.battleshipsmk2;

public class GridGenerator {

    public static Grid generateGrid(int width, int height){

        GridDimensions gridDimensions = new GridDimensions(width, height);
        Square[] squares = new Square[gridDimensions.getNumberOfSquares()];
        for(int i = 0; i < gridDimensions.getNumberOfSquares(); i++){
            squares[i] = new Square(i);
        }

        return new Grid(gridDimensions, squares);

    }

}