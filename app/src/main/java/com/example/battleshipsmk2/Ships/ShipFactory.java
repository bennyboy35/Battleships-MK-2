package com.example.battleshipsmk2.Ships;

public class ShipFactory {

    public static IShip buildShip(EShipType shipType, int... positions){

        switch(shipType){
            case DESTROYER:
                return new Destroyer(shipType.getLength(), shipType.getName(), positions);
            case AIRCRAFT_CARRIER:
                return new AircraftCarrier(shipType.getLength(), shipType.getName(), positions);
            case SUBMARINE:
                return new Submarine(shipType.getLength(), shipType.getName(), positions);
            case FRIGATE:
                return new Frigate(shipType.getLength(), shipType.getName(), positions);
            case PATROL_BOAT:
                return new PatrolBoat(shipType.getLength(), shipType.getName(), positions);
            default:
                throw new IllegalArgumentException("Unrecognized ship type");
        }
    }
}
