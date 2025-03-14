package org.dev.parkinglot;

import org.dev.parkinglot.models.Coordinate;
import org.dev.parkinglot.models.VehicleType;

public class TwoWheelerParkingSpot extends BaseParkingSpot{

    public TwoWheelerParkingSpot(String id, Coordinate coordinate) {
        super(id, VehicleType.TWO_WHEELER, coordinate);
    }

}
