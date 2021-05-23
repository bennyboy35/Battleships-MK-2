package com.example.battleshipsmk2.Player;

import com.example.battleshipsmk2.EResult;

import java.text.DecimalFormat;

public class Player {
    private String name;
    private EPlayerColour colour;
    private int gamesWon;
    private int gamesPlayed;

    public Player(String name, EPlayerColour colour) {
        this.name = name;
        this.colour = colour;
        gamesWon = 0;
        gamesPlayed = 0;
    }

    public String getName() {
        return name;
    }

    public EPlayerColour getColour() {
        return colour;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void registerResult(EResult result) {
        gamesPlayed++;
        switch (result) {
            case WIN:
                gamesWon++;
                break;
            case LOSS:
            default:
                //Do Nothing
        }
    }
    public float getWinPercentage(){

        if (gamesPlayed == 0 || gamesWon == 0){
            return 0;
        }
        float percentage = Float.valueOf(gamesWon) / Float.valueOf(gamesPlayed) * 100;
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        return Float.valueOf(decimalFormat.format(percentage));
    }
}
