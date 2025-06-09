package org.dev.parkinglot.models.parkingspotstate;

public class OccupiedState implements ParkingSpotState {

    @Override
    public String getParkingState() {
        return "OCCUPIED";
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
