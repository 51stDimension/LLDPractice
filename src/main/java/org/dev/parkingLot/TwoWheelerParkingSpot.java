package org.dev;

import org.dev.models.Coordinate;
import org.dev.models.VehicleType;

public class TwoWheelerParkingSpot extends BaseParkingSpot{

    public TwoWheelerParkingSpot(String id, Coordinate coordinate) {
        super(id, VehicleType.TWO_WHEELER, coordinate);
    }

}
