package com.example.battleshipsmk2;

public class GridDimensions {

    private int width;
    private int height;

    GridDimensions(int width, int height){

        this.width = width;
        this.height = height;

    }

    public int getWidth(){

        return width;

    }

    public int getHeight(){

        return height;

    }

    public int getRowIndex(int squareIndex){

        return (squareIndex - getColumnIndex(squareIndex)) / width;

    }

    public int getColumnIndex(int squareIndex){

        return (squareIndex % width);

    }

    public int getSquareIndex(int columnIndex, int rowIndex){

        return (rowIndex * width) + columnIndex;

    }

    public int getNumberOfSquares(){

        return width * height;

    }


}


