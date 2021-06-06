package com.example.battleshipsmk2.Ai;

import com.example.battleshipsmk2.EDirection;
import com.example.battleshipsmk2.Exceptions.CpuAiException;
import com.example.battleshipsmk2.Game.GameSettings;
import com.example.battleshipsmk2.Game.GameSide;
import com.example.battleshipsmk2.Grid.GridDimensions;
import com.google.common.primitives.Ints;

import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CpuAi {
    private final GameSide opponent;
    private final GameSettings gameSettings;
    private final GridDimensions gridDimensions;
    private final List<Integer> squareIndexesRemaining;
    private final List<Integer> shotIndexesInCurrentCycle;
    private EThoughtProcess currentThoughtProcess;
    private EDirection lastDirection;

    public CpuAi(GameSide opponent){
        this.opponent = opponent;
        gameSettings = opponent.getGameSettings();
        gridDimensions = new GridDimensions(gameSettings.getNumOfColumns(), gameSettings.getNumOfRows());
        squareIndexesRemaining = new ArrayList<>(gridDimensions.getNumberOfSquares());
        for (int i = 0; i < gridDimensions.getNumberOfSquares(); i++){
            squareIndexesRemaining.add(i);
        }
        shotIndexesInCurrentCycle = new ArrayList<>(gridDimensions.getNumberOfSquares());
        currentThoughtProcess = EThoughtProcess.LOCATE_SHIP;
    }

    public int getNextShot(){
        switch (currentThoughtProcess){
            case LOCATE_SHIP:
                return getRandomShot();
            case FOLLOW_FIRST_HIT:
                return getFollowUpFirstHit();
            case CONTINUE_DIRECTION:
                break;
            case REVERSE_DIRECTION:
                break;
            case CONTINUE_FROM_FIRST_HIT:
                break;
            case ATTEMPT_TO_LOCATE_SUNK_SHIP:
                break;
            case REMOVE_SUNK_SHIP:
                break;
            default:
                throw new CpuAiException("Un-recognised thought process");
        }
        //This will be removed
        throw new CpuAiException("Un-recognised thought process");
    }

    private int getFollowUpFirstHit() {
        int lastShot = shotIndexesInCurrentCycle.get(shotIndexesInCurrentCycle.size() - 1);
        int[] validIndexesToExplore = getValidIndexesToExplore(lastShot);
        Random random = new Random();
        return validIndexesToExplore[random.nextInt(validIndexesToExplore.length)];
    }

    private int[] getValidIndexesToExplore(int lastShot) {
        List<Integer> validIndexes = new ArrayList<>(4);
        for (EDirection direction : EDirection.values()){
            switch (direction){
                case NORTH:
                    //TODO  Need method to calculate indexes for a given direction
                    break;
                case EAST:
                    break;
                case SOUTH:
                    break;
                case WEST:
                    break;
                default:
                    throw new CpuAiException("Unrecognised direction");
            }

        }
        return Ints.toArray(validIndexes);
    }

    private boolean hasShotBeenPreviouslyAttempted(int squareIndex){
        return squareIndexesRemaining.contains(squareIndex);
    }

    private boolean hasShotBeenPreviouslyAttempted(int colIndex, int rowIndex){
        return squareIndexesRemaining.contains(gridDimensions.getSquareIndex(colIndex, rowIndex));
    }

    private int getRandomShot() {
        Random random = new Random();
        int index = random.nextInt(squareIndexesRemaining.size());
        int nextShot = squareIndexesRemaining.get(random.nextInt(squareIndexesRemaining.size()));
        squareIndexesRemaining.remove(index);
        return nextShot;
    }

}
