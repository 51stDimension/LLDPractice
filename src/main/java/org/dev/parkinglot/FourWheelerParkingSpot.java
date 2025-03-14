package org.dev.parkinglot;

import org.dev.parkinglot.models.Coordinate;
import org.dev.parkinglot.models.VehicleType;

public class FourWheelerParkingSpot extends BaseParkingSpot {

    public FourWheelerParkingSpot(String id, Coordinate coordinate) {
        super(id, VehicleType.FOUR_WHEELER, coordinate);
    }
}
