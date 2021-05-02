package com.example.battleshipsmk2;

public class Grid {

    private Square[] squares;

    private GridDimensions gridDimensions;

    Grid(GridDimensions gridDimensions, Square[] squares){

        this.gridDimensions = gridDimensions;
        this.squares = squares;

    }

    public GridDimensions getGridDimensions(){

        return gridDimensions;

    }

    public Square getSquare(int squareIndex){

        return squares[squareIndex];

    }

    public Square getSquare(int columnIndex, int rowIndex){

        return squares[gridDimensions.getSquareIndex(columnIndex, rowIndex)];

    }


    private void validateGrid(){

        if(gridDimensions.getNumberOfSquares() != squares.length){

            throw new IllegalArgumentException("Number of Squares does not match grid dimensions");

        }

    }

    public boolean attemptToAddShipReturnSuccess(IShip ship, int... positions){
        if(ship.getLength() != positions.length){
            return false;
        }

        for (int position : positions) {

            if(getSquare(position).hasShip()){

                return false;
            }
        }

        return true;
    }

}
