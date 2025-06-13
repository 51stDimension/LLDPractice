package org.dev.parkinglot;

import org.dev.parkinglot.models.ParkingTicket;
import org.dev.parkinglot.request.ParkingRequest;

public interface IParkingLotManager {

    ParkingTicket assignParking(ParkingRequest parkingRequest, String parkingEntranceId);

    void addNewParkingFloor();

    void handleDriverExit(ParkingTicket parkingTicket);
}
