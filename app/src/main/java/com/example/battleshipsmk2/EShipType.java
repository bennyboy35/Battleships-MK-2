package com.example.battleshipsmk2;

public enum EShipType {

    DESTROYER(4, "Destroyer", 1),
    AIRCRAFT_CARRIER(5, "Aircraft Carrier", 1),
    SUBMARINE(3, "Submarine",1),
    FRIGATE(3, "Frigate",1),
    PATROL_BOAT(2, "Patrol Boat",1);

    private int length;
    private String name;
    private int numberOfShips;

    EShipType(int length, String name, int defaultNumOfShips){

        this.length = length;
        this.name = name;
        numberOfShips = defaultNumOfShips;
    }

    public int getLength(){

        return length;

    }

    public String getName(){

        return name;

    }

    public int getNumberOfShips(){
        return numberOfShips;
    }

    public  void setNumberOfShips(int numOfShips){
        this.numberOfShips = numOfShips;

    }


}
