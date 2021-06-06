package com.example.battleshipsmk2.Game;

import com.example.battleshipsmk2.EGridLayout;
import com.example.battleshipsmk2.Ships.EShipType;

public class GameSettings {

    private EGridLayout lastUsedLayout;

    public GameSettings(){
        lastUsedLayout = EGridLayout.CLASSIC;
    }

    public GameSettings(EGridLayout gridLayout){
         lastUsedLayout = gridLayout;
    }


    public int getNumOfColumns(){
        return lastUsedLayout.getNumOfColumns();
    }


    public int getNumOfRows(){
        return lastUsedLayout.getNumOfRows();
    }


    public void setLayout(EGridLayout lastUsedLayout) {
        this.lastUsedLayout = lastUsedLayout;
    }


    public void setNumberOfShips(EShipType shipType, int numberOfShips){
        shipType.setNumberOfShips(numberOfShips);
    }

    public void setCustomGridSize(int numOfColumns, int numOfRows){
        EGridLayout.CUSTOM.setCustomGridSize(numOfColumns,numOfRows);
        lastUsedLayout = EGridLayout.CUSTOM;
    }


}
