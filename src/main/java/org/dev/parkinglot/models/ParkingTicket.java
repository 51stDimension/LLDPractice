package org.dev.parkinglot.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParkingTicket {
    private String parkingLotId;
    private ParkingSpot parkingSpot;
    private String vehicleNumber;
}
