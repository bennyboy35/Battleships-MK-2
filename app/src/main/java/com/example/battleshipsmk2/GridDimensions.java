package com.example.battleshipsmk2;

import com.example.battleshipsmk2.Exceptions.GridDimensionsException;
import java.util.Arrays;

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
        if (columnIndex < 0 || columnIndex >= width || rowIndex < 0 || rowIndex >= height){

            throw new GridDimensionsException("Index out of bounds");
        }
        return (rowIndex * width) + columnIndex;

    }

    public int getNumberOfSquares(){

        return width * height;

    }

    public boolean willShipRemainInBounds(int colIndex, int rowIndex, EShipType shipType, EDirection direction) {
        int squareIndex = -1;
        try {
            squareIndex = getSquareIndex(colIndex, rowIndex);
        }
        catch(GridDimensionsException exception){

            return false;
        }


        if (squareIndex < 0 || squareIndex >= getNumberOfSquares()) {
            return false;
        }

        switch (direction) {

            case NORTH:
                return rowIndex + 1 - shipType.getLength() >= 0;

            case EAST:
                return colIndex + shipType.getLength() <= width;

            case SOUTH:
                return rowIndex + shipType.getLength() <= height;

            case WEST:
                return colIndex + 1 - shipType.getLength() >= 0;

            default:
                throw new GridDimensionsException("Unrecognised Direction");
        }
    }


    public boolean willShipRemainInBounds(int squareIndex, EShipType shipType, EDirection direction) {

        return willShipRemainInBounds(getColumnIndex(squareIndex), getRowIndex(squareIndex),shipType, direction );

    }

    public int[] getShipPositionIndexes(int colIndex, int rowIndex, EShipType shipType, EDirection direction){

        if(!willShipRemainInBounds(colIndex, rowIndex, shipType, direction)){

            return new int[0] ;
        }

        int[] positions = new int[shipType.getLength()];

        switch(direction){

            case NORTH:
                for(int i = 0; i < shipType.getLength(); i++){
                    positions[i] = getSquareIndex(colIndex, rowIndex - i);
                }
                break;
            case EAST:
                for(int i = 0; i < shipType.getLength(); i++){
                    positions[i] = getSquareIndex(colIndex + i, rowIndex);
                }
                break;
            case SOUTH:
                for(int i = 0; i < shipType.getLength(); i++){
                    positions[i] = getSquareIndex(colIndex, rowIndex + i);
                }
                break;
            case WEST:
                for(int i = 0; i < shipType.getLength(); i++){
                    positions[i] = getSquareIndex(colIndex - i, rowIndex);
                }
                break;
        }
        Arrays.sort(positions);
        return positions;
    }

    public int[] getShipPositionIndexes(int squareIndex, EShipType shipType, EDirection direction) {

        return getShipPositionIndexes(getColumnIndex(squareIndex), getRowIndex(squareIndex), shipType, direction);
    }
}


