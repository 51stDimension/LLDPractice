package org.dev.parkinglot.models.parkingspotstate;

public class EmptyState implements ParkingSpotState{
    @Override
    public String getParkingState() {
        return "";
    }

    @Override
    public Boolean occupySpot() {
        return null;
    }

    @Override
    public Boolean markSpotAsEmpty() {
        return null;
    }
}
