package org.dev.parkinglot.parkingstrategy;

import org.dev.parkinglot.models.ParkingEntrance;
import org.dev.parkinglot.models.ParkingLot;
import org.dev.parkinglot.models.ParkingSpot;
import org.dev.parkinglot.models.ParkingTicket;
import org.dev.parkinglot.request.ParkingRequest;

import java.util.List;
import java.util.Optional;

public class DefaultParkingStrategy implements ParkingStrategy{

    @Override
    public ParkingTicket getParkingTicket(ParkingRequest parkingRequest, ParkingEntrance parkingEntrance, List<ParkingLot> parkingLots) {
        for(ParkingLot parkingLot : parkingLots){
            Optional<ParkingSpot> parkingSpot = parkingLot.getClosestSpotForVehicleFromEntrance(parkingEntrance, parkingRequest);
            if(parkingSpot.isPresent()){
                return ParkingTicket.builder()
                        .parkingLotId(parkingLot.getParkingLotId())
                        .parkingSpot(parkingSpot.get())
                        .vehicleNumber(parkingRequest.getVehicleNumber())
                        .build();
            }
        }
        return null;
    }
}
