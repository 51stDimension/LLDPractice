package org.dev.parkinglot.models.parkingspotstate;

public interface ParkingSpotState {
    String getParkingState();
    Boolean occupySpot();
    Boolean markSpotAsEmpty();
}
