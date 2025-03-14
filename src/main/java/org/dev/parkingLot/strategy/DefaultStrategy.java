package org.dev.parkingLot.strategy;

import org.dev.parkingLot.BaseParkingSpot;
import org.dev.parkingLot.Parking;
import org.dev.parkingLot.models.EntryTerminal;
import org.dev.parkingLot.models.Vehicle;

import java.util.Optional;

public class DefaultStrategy implements ParkingStrategy {

    @Override
    public Optional<BaseParkingSpot> getParkingSlot(Vehicle vehicle, EntryTerminal entryTerminal, Parking parking) {
        return parking.getParkingSpots().
                stream().filter(parkingSpot -> parkingSpot.isEmpty() &&
                        parkingSpot.getVehicleType().equals(vehicle.vehicleType())).findFirst();
    }

}
