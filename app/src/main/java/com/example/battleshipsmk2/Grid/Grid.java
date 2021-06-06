package com.example.battleshipsmk2.Grid;

import com.example.battleshipsmk2.EDirection;
import com.example.battleshipsmk2.Exceptions.GridDimensionsException;
import com.example.battleshipsmk2.Exceptions.GridException;
import com.example.battleshipsmk2.Game.IShotResult;
import com.example.battleshipsmk2.Ships.EShipType;
import com.example.battleshipsmk2.Ships.IShip;
import com.example.battleshipsmk2.Ships.ShipFactory;

import javax.annotation.CheckForNull;

public class Grid {

    private Square[] squares;

    private GridDimensions gridDimensions;

    public Grid(GridDimensions gridDimensions, Square[] squares){

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

    @CheckForNull
    public IShip attemptToAddShipReturnShip(int colIndex, int rowIndex, EShipType shipType, EDirection direction){
        try{
            return attemptToAddShipReturnShip(gridDimensions.getSquareIndex(colIndex, rowIndex), shipType, direction);
        }
        catch(GridDimensionsException exception) {
            return null;
        }
    }

    @CheckForNull
    public IShip attemptToAddShipReturnShip(int squareIndex, EShipType shipType, EDirection direction){
        if (!gridDimensions.willShipRemainInBounds(squareIndex, shipType, direction)){
            return null;
        }

        int[] positions = gridDimensions.getShipPositionIndexes(squareIndex, shipType, direction);

        if (checkPositionsForExistingShips(positions)){
            return null;
        }
        IShip ship = ShipFactory.buildShip(shipType, positions);
        for (int position : positions) {
            getSquare(position).addShip(ship);
        }
        return ship;
    }

    private boolean checkPositionsForExistingShips(int[] positions) {
        for (int position : positions) {
            if (getSquare(position).hasShip()) {
                return true;
            }
        }
        return false;
    }

    public IShotResult fireAtSquare(int colIndex, int rowIndex){
        if (colIndex < 0 || colIndex >= gridDimensions.getWidth() || rowIndex < 0 || rowIndex >= gridDimensions.getHeight()){
            throw new GridException("Firing at a square that is out of bounds");
        }
        return fireAtSquare(gridDimensions.getSquareIndex(colIndex, rowIndex));
    }

    public IShotResult fireAtSquare(int squareIndex){
        if (squareIndex < 0 || squareIndex >= squares.length){
            throw new GridException("Firing at a square that is out of bounds");

        }
        return squares[squareIndex].fireAtSquare();

    }

}
