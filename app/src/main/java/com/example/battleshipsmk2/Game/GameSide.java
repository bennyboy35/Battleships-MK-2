package com.example.battleshipsmk2.Game;

import com.example.battleshipsmk2.Grid.Grid;
import com.example.battleshipsmk2.Grid.Square;
import com.example.battleshipsmk2.Player.Player;

public class GameSide {

    private final Player player;
    private final Grid grid;

    public GameSide(Player player, Grid grid) {
        this.player = player;
        this.grid = grid;
    }
    public IShotResult getAttemptedShotResult(int squareIndex){
        return getAttemptedShotResult(grid.getGridDimensions().getColumnIndex(squareIndex), grid.getGridDimensions().getRowIndex(squareIndex));

    }

    public IShotResult getAttemptedShotResult(int colIndex, int rowIndex){
        Square square = grid.getSquare(colIndex, rowIndex);
        return square.fireAtSquare();
    }

}
