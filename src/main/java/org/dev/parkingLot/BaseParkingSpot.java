package org.dev.parkingLot;

import lombok.Getter;
import org.dev.parkingLot.models.Coordinate;
import org.dev.parkingLot.models.EntryTerminal;
import org.dev.parkingLot.models.VehicleType;

//Parking spot for core logic and BaseParkingSpot for defining behaviour that will be/can be same across
//different parking spots
public abstract class BaseParkingSpot implements ParkingSpot {

    private boolean isEmpty = true;

    @Getter
    private String id;

    @Getter
    private VehicleType vehicleType;

    @Getter
    private Coordinate coordinate;

    public BaseParkingSpot(String id, VehicleType vehicleType, Coordinate coordinate) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.coordinate =  coordinate;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public void reserve() {
        isEmpty = false;
    }

    public Integer getDistanceFromEntry(EntryTerminal entryTerminal) {
        return Math.abs(entryTerminal.getCoordinate().getX() - this.getCoordinate().getX()) +
                Math.abs(entryTerminal.getCoordinate().getY() - this.getCoordinate().getY());
    }

}
