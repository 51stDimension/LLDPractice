package org.dev.parkingLot;

import org.dev.parkingLot.models.Coordinate;
import org.dev.parkingLot.models.VehicleType;

public class FourWheelerParkingSpot extends BaseParkingSpot {

    public FourWheelerParkingSpot(String id, Coordinate coordinate) {
        super(id, VehicleType.FOUR_WHEELER, coordinate);
    }
}
