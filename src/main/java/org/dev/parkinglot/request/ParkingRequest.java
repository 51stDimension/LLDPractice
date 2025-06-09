package org.dev.parkinglot.request;

import lombok.Data;
import org.dev.parkinglot.models.VehicleType;

@Data
public class ParkingRequest {
    private VehicleType vehicleType;
    private String vehicleNumber;
}
