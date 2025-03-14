package org.dev.parkinglot.strategy;

import org.dev.parkinglot.BaseParkingSpot;
import org.dev.parkinglot.Parking;
import org.dev.parkinglot.models.EntryTerminal;
import org.dev.parkinglot.models.Vehicle;

import java.util.Optional;
import java.util.TreeSet;

public class MinDistanceStrategy implements ParkingStrategy {

    @Override
    public Optional<BaseParkingSpot> getParkingSlot(Vehicle vehicle, EntryTerminal entryTerminal, Parking parking) {
        TreeSet<BaseParkingSpot> tsMapping = parking.getTsMapping()
                .get(entryTerminal.getId())
                .get(vehicle.vehicleType().name());
        if (tsMapping != null && !tsMapping.isEmpty()) {
            BaseParkingSpot baseParkingSpot = tsMapping.pollFirst();
            baseParkingSpot.reserve();
            return Optional.of(baseParkingSpot);
        }
        return Optional.empty();
    }
}
