package org.dev.parkingLot.strategy;

import org.dev.parkingLot.BaseParkingSpot;
import org.dev.parkingLot.Parking;
import org.dev.parkingLot.models.EntryTerminal;
import org.dev.parkingLot.models.Vehicle;

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
