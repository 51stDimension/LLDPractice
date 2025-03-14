package org.dev.parkingLot.strategy;

import org.dev.parkingLot.BaseParkingSpot;
import org.dev.parkingLot.Parking;
import org.dev.parkingLot.models.EntryTerminal;
import org.dev.parkingLot.models.Vehicle;

import java.util.Optional;

public interface ParkingStrategy {

    Optional<BaseParkingSpot> getParkingSlot(Vehicle vehicle, EntryTerminal entryTerminal, Parking parking);

}
