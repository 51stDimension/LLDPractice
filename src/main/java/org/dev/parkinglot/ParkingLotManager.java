package org.dev.parkinglot;

import lombok.extern.slf4j.Slf4j;
import org.dev.parkinglot.models.*;
import org.dev.parkinglot.observer.ParkingLotObserver;
import org.dev.parkinglot.parkingstrategy.DefaultParkingStrategy;
import org.dev.parkinglot.parkingstrategy.ParkingStrategy;
import org.dev.parkinglot.request.ParkingRequest;

import java.util.*;
import java.util.logging.Logger;

@Slf4j
public class ParkingLotManager implements ParkingLotObserver, IParkingLotManager {

    private final String parkingLotId;

    private Integer floors;

    private final ParkingLotDimensions parkingLotDimensions;
    private final List<ParkingLot> parkingLots; //For this problem, Lets assume index = floorNumber
    private final Map<String, ParkingEntrance> parkingEntrances;
    private final ParkingStrategy parkingStrategy = new DefaultParkingStrategy();

    public ParkingLotManager(Integer floors, ParkingLotDimensions parkingLotDimensions, Map<String, ParkingEntrance> parkingEntrances){
        this.parkingLotId = UUID.randomUUID().toString();
        this.floors = floors;
        this.parkingLotDimensions = parkingLotDimensions;
        this.parkingEntrances = parkingEntrances;
        this.parkingLots = new ArrayList<>();
    }

    @Override
    public ParkingTicket assignParking(ParkingRequest parkingRequest, String parkingEntranceId){
        ParkingEntrance parkingEntrance = parkingEntrances.get(parkingEntranceId);
        if(Objects.isNull(parkingEntrance)){
            throw new RuntimeException("Invalid parking entranceId provided: " + parkingEntranceId);
        }
        ParkingTicket parkingTicket = parkingStrategy.getParkingTicket(parkingRequest, parkingEntrance, parkingLots);
        if(Objects.isNull(parkingTicket)){
            System.out.println("No parking available right now!");
            return null;
        }
        return parkingTicket;
    }

    @Override
    public String addNewParkingFloor(){
        floors = floors + 1;
        parkingLots.add(new ParkingLot(parkingLotDimensions, parkingEntrances.values().stream().toList()));
    }

    @Override
    public void handleDriverExit(ParkingTicket parkingTicket) {

    }


    @Override
    public void notify(EventType eventType, String parkingLotId) {
        System.out.println("Received eventType: " + eventType + " from parkingLot: " + parkingLotId);
        //Do some operations if you want to for that event
    }
}
