package org.dev.strategy;

import org.dev.BaseParkingSpot;
import org.dev.Parking;
import org.dev.models.EntryTerminal;
import org.dev.models.Vehicle;

import java.util.Optional;

public class DefaultStrategy implements ParkingStrategy {

    @Override
    public Optional<BaseParkingSpot> getParkingSlot(Vehicle vehicle, EntryTerminal entryTerminal, Parking parking) {
        return parking.getParkingSpots().
                stream().filter(parkingSpot -> parkingSpot.isEmpty() &&
                        parkingSpot.getVehicleType().equals(vehicle.vehicleType())).findFirst();
    }

}
