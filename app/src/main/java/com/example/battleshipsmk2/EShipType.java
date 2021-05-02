package com.example.battleshipsmk2;

public enum EShipType {

    DESTROYER(4, "Destroyer"),
    AIRCRAFT_CARRIER(5, "Aircraft Carrier"),
    SUBMARINE(3, "Submarine"),
    FRIGATE(3, "Frigate"),
    PATROL_BOAT(2, "Patrol Boat");

    private int length;
    private String name;

    EShipType(int length, String name){

        this.length = length;
        this.name = name;

    }

    public int getLength(){

        return length;

    }

    public String getName(){

        return name;

    }

}
