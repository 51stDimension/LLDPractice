package org.dev.strategy;

import org.dev.BaseParkingSpot;
import org.dev.Parking;
import org.dev.models.EntryTerminal;
import org.dev.models.Vehicle;

import java.util.Optional;

public interface ParkingStrategy {

    Optional<BaseParkingSpot> getParkingSlot(Vehicle vehicle, EntryTerminal entryTerminal, Parking parking);

}
