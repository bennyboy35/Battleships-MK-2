package com.example.battleshipsmk2;

public class ShipFactory {

    public static IShip buildShip(EShipType shipType){

        switch(shipType){
            case DESTROYER:
                return new Destroyer(shipType.getLength(), shipType.getName());
            case AIRCRAFT_CARRIER:
                return new AircraftCarrier(shipType.getLength(), shipType.getName());
            case SUBMARINE:
                return new Submarine(shipType.getLength(), shipType.getName());
            case FRIGATE:
                return new Frigate(shipType.getLength(), shipType.getName());
            case PATROL_BOAT:
                return new PatrolBoat(shipType.getLength(), shipType.getName());
            default:
                throw new IllegalArgumentException("Unrecognized ship type");
        }
    }


    public static IShip[] buildShips(EShipType... shipTypes){
        IShip[] ships = new IShip[shipTypes.length];
        for(int i = 0; i < shipTypes.length; i++){

            ships[i] = buildShip(shipTypes[i]);

        }
        return ships;
    }

}
