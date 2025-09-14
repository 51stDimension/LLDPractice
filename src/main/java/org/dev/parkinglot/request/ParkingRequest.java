package org.dev.parkinglot.request;

import lombok.*;
import org.dev.parkinglot.models.VehicleType;

@Value
@Builder(toBuilder = true)
public class ParkingRequest {
    VehicleType vehicleType;
    String vehicleNumber;
}
