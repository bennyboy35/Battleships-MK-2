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
    public boolean attemptToAddShipReturnSuccess(int colIndex, int rowIndex, EShipType shipType, EDirection direction){

        return attemptToAddShipReturnSuccess(gridDimensions.getSquareIndex(colIndex, rowIndex), shipType, direction);
    }


    public boolean attemptToAddShipReturnSuccess(int squareIndex, EShipType shipType, EDirection direction){
        if (!gridDimensions.willShipRemainInBounds(squareIndex, shipType, direction)){
            return false;
        }

        int[] positions = gridDimensions.getShipPositionIndexes(squareIndex, shipType, direction);

        if (checkPositionsForExistingShips(positions)){
            return false;
        }
        IShip ship = ShipFactory.buildShip(shipType);
        for (int position : positions) {
            getSquare(position).addShip(ship);
        }
        return true;
    }

    private boolean checkPositionsForExistingShips(int[] positions) {
        for (int position : positions) {
            if (getSquare(position).hasShip()) {
                return true;
            }
        }
        return false;
    }

}
