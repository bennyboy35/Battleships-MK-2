package com.example.battleshipsmk2;

import com.example.battleshipsmk2.Ai.CpuAi;
import com.example.battleshipsmk2.Game.GameSettings;
import com.example.battleshipsmk2.Game.GameSide;
import com.example.battleshipsmk2.Player.EPlayerColour;
import com.example.battleshipsmk2.Player.Player;
import com.example.battleshipsmk2.Ships.EShipType;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Test_CpuAi {

    private CpuAi cpu;

    @BeforeMethod
    public void setup(){
        GameSettings gameSettings = new GameSettings();
        Player player = new Player("Ben", EPlayerColour.BLUE);
        GameSide gameSide = new GameSide(player, gameSettings);
        cpu = new CpuAi(gameSide);
    }


    @Test
    public void test_GameSettings() {

    }


   /* @DataProvider(name = "gameSettings")
    public Object[][] gameSettings() {

        return new Object[][]{

                {EShipType.PATROL_BOAT, 0},
                {EShipType.FRIGATE, 4},
                {EShipType.DESTROYER, 7},
                {EShipType.AIRCRAFT_CARRIER, 60}
        };
    }
    */
}
