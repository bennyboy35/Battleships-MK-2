package com.example.battleshipsmk2.Game;

import com.example.battleshipsmk2.EDirection;
import com.example.battleshipsmk2.Grid.Grid;
import com.example.battleshipsmk2.Grid.GridGenerator;
import com.example.battleshipsmk2.Grid.Square;
import com.example.battleshipsmk2.Player.Player;
import com.example.battleshipsmk2.Ships.EShipType;
import com.example.battleshipsmk2.Ships.IShip;

import java.util.ArrayList;
import java.util.List;

public class GameSide {

    private final Player player;
    private final List<IShip> playerShips;
    private final Grid grid;
    private final GameSettings gameSettings;

    public GameSide(Player player, GameSettings gameSettings) {
        this.player = player;
        playerShips = new ArrayList<>(100);
        this.grid = GridGenerator.generateEmptyGrid(gameSettings.getNumOfColumns(), gameSettings.getNumOfRows());
        this.gameSettings = gameSettings;
    }

    public GameSettings getGameSettings() {
        return gameSettings;
    }

    public IShotResult getAttemptedShotResult(int squareIndex) {
        Square square = grid.getSquare(squareIndex);
        return square.fireAtSquare();

    }

    public IShotResult getAttemptedShotResult(int colIndex, int rowIndex) {
        Square square = grid.getSquare(colIndex, rowIndex);
        return square.fireAtSquare();
    }


    public boolean attemptToAddShipReturnSuccess(int colIndex, int rowIndex, EShipType shipType, EDirection direction) {
        IShip ship = grid.attemptToAddShipReturnShip(colIndex, rowIndex, shipType, direction);
        if (ship != null){
            playerShips.add(ship);
            return true;
        }
        return false;
    }


    public boolean attemptToAddShipReturnSuccess(int squareIndex, EShipType shipType, EDirection direction) {
        IShip ship = grid.attemptToAddShipReturnShip(squareIndex, shipType, direction);
        if (ship != null){
            playerShips.add(ship);
            return true;
        }
        return false;
    }


    public IShotResult fireAtSquare(int colIndex, int rowIndex){
        return grid.fireAtSquare(colIndex, rowIndex);
    }

    public IShotResult fireAtSquare(int squareIndex){
        return grid.fireAtSquare(squareIndex);
    }

    public boolean isFleetDestroyed(){
        for (IShip ship : playerShips){
            if (!ship.isSunk()){
                return false;
            }
        }
        return true;
    }

    public int numberOfShips(){
        return playerShips.size();
    }

    public int numberOfShipsOfType(EShipType shipType){
        int count = 0;
        for (IShip ship : playerShips){
            if (ship.getType() == shipType){
                count++;
            }
        }
        return count;
    }


}
