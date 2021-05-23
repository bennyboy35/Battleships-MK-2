package com.example.battleshipsmk2;

import com.example.battleshipsmk2.Player.EPlayerColour;
import com.example.battleshipsmk2.Player.Player;
import com.example.battleshipsmk2.Ships.EShipType;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class Test_Player {

    @Test(dataProvider = "playerCreation")
    public void test_PlayerCreation(String playerName, EPlayerColour colour) {

        Player player = new Player(playerName, colour);
        assertEquals(player.getName(), playerName);
        assertEquals(player.getColour(), colour);
        assertEquals(player.getGamesWon(), 0);
        assertEquals(player.getGamesPlayed(), 0);
    }


    @DataProvider(name = "playerCreation")
    public Object[][] playerCreationDP() {

        return new Object[][]{
                {"Ben", EPlayerColour.BLUE},
                {"Chloe", EPlayerColour.RED},

        };
    }


    @Test
    public void test_PlayerScoring() {
        Player player = new Player("Ben", EPlayerColour.BLUE);
        assertEquals(player.getGamesPlayed(), 0);
        assertEquals(player.getWinPercentage(), 0f);

        player.registerResult(EResult.LOSS);
        assertEquals(player.getGamesPlayed(), 1);
        assertEquals(player.getWinPercentage(), 0f);

        player.registerResult(EResult.WIN);
        assertEquals(player.getGamesPlayed(), 2);
        assertEquals(player.getWinPercentage(), 50f);

        player.registerResult(EResult.WIN);
        assertEquals(player.getGamesPlayed(), 3);
        assertEquals(player.getWinPercentage(), 66.67f);
    }
}
