package org.dev;

import org.dev.models.Coordinate;
import org.dev.models.VehicleType;

public class FourWheelerParkingSpot extends BaseParkingSpot {

    public FourWheelerParkingSpot(String id, Coordinate coordinate) {
        super(id, VehicleType.FOUR_WHEELER, coordinate);
    }
}
