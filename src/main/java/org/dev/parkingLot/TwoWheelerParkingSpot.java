package org.dev.parkingLot;

import org.dev.parkingLot.models.Coordinate;
import org.dev.parkingLot.models.VehicleType;

public class TwoWheelerParkingSpot extends BaseParkingSpot{

    public TwoWheelerParkingSpot(String id, Coordinate coordinate) {
        super(id, VehicleType.TWO_WHEELER, coordinate);
    }

}
