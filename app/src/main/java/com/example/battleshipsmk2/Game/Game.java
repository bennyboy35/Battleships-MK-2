package com.example.battleshipsmk2.Game;

import com.example.battleshipsmk2.Player.EPlayerColour;
import com.example.battleshipsmk2.Player.Player;

import java.util.Random;

public class Game {

    private final GameSide redSide;
    private final GameSide blueSide;
    private Player whoseTurn;

    public Game(GameSettings gameSettings, Player redPlayer, Player bluePlayer){
        Random random = new Random();
        whoseTurn = random.nextBoolean() ? redPlayer : bluePlayer;
        this.redSide = new GameSide(redPlayer, gameSettings);
        this.blueSide = new GameSide(bluePlayer, gameSettings);
    }

    public Game(GameSettings gameSettings, Player redPlayer, Player bluePlayer, EPlayerColour whoGoesFirst){

        whoseTurn = whoGoesFirst == EPlayerColour.RED ? redPlayer : bluePlayer;
        this.redSide = new GameSide(redPlayer, gameSettings);
        this.blueSide = new GameSide(bluePlayer, gameSettings);
    }

}
