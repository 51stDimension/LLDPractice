package org.dev.parkinglot.strategy;

import org.dev.parkinglot.BaseParkingSpot;
import org.dev.parkinglot.Parking;
import org.dev.parkinglot.models.EntryTerminal;
import org.dev.parkinglot.models.Vehicle;

import java.util.Optional;

public class DefaultStrategy implements ParkingStrategy {

    @Override
    public Optional<BaseParkingSpot> getParkingSlot(Vehicle vehicle, EntryTerminal entryTerminal, Parking parking) {
        return parking.getParkingSpots().
                stream().filter(parkingSpot -> parkingSpot.isEmpty() &&
                        parkingSpot.getVehicleType().equals(vehicle.vehicleType())).findFirst();
    }

}
