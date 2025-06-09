package org.dev.parkinglot.parkingstrategy;

import org.dev.parkinglot.models.ParkingEntrance;
import org.dev.parkinglot.models.ParkingLot;
import org.dev.parkinglot.models.ParkingTicket;
import org.dev.parkinglot.request.ParkingRequest;

import java.util.List;

public interface ParkingStrategy {
    ParkingTicket getParkingTicket(ParkingRequest parkingRequest, ParkingEntrance parkingEntrance, List<ParkingLot> parkingLots);
}
