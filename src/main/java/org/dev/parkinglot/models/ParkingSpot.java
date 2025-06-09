package org.dev.parkinglot.models;

import lombok.Builder;
import lombok.Data;
import org.dev.parkinglot.models.parkingspotstate.ParkingSpotState;

@Data
@Builder
public class ParkingSpot {

    private VehicleType vehicleType;
    private Coordinate coordinate;
    private ParkingSpotState state;

}
