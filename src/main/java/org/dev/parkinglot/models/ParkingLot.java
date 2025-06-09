package org.dev.parkinglot.models;

import lombok.Data;
import org.dev.parkinglot.models.parkingspotstate.EmptyState;
import org.dev.parkinglot.request.ParkingRequest;

import java.util.*;

@Data
public class ParkingLot {

    private String parkingLotId;
    private Map<ParkingEntrance, Map<VehicleType, PriorityQueue<ParkingSpot>>> parkingSpotPQ;
    private ParkingLotDimensions parkingLotDimensions;
    private Boolean isFull;

    public ParkingLot(ParkingLotDimensions parkingLotDimensions, List<ParkingEntrance> parkingEntrances) {
        this.isFull = false;
        this.parkingLotId = UUID.randomUUID().toString();
        this.parkingLotDimensions = parkingLotDimensions;
        initPQ(parkingEntrances);
    }

    private void initPQ(List<ParkingEntrance> parkingEntrances) {
        for (ParkingEntrance parkingEntrance : parkingEntrances) {

            Map<VehicleType, PriorityQueue<ParkingSpot>> priorityQueueMap = new HashMap<>();
            for (VehicleType vehicleType : VehicleType.values()) {
                priorityQueueMap.put(vehicleType, new PriorityQueue<>());
            }

            for (int i = 0; i < parkingLotDimensions.getLength(); i++) {
                for (int j = 0; j < parkingLotDimensions.getWidth(); j++) {
                    VehicleType vehicleType = VehicleType.TWO_WHEELER;
                    priorityQueueMap.get(vehicleType).add(
                            ParkingSpot
                                    .builder()
                                    .state(new EmptyState())
                                    .coordinate(Coordinate.builder().x(i).y(j).build())
                                    .vehicleType(vehicleType)
                                    .build()
                    );
                }
            }

            parkingSpotPQ.put(parkingEntrance, priorityQueueMap);
        }
    }

    public Optional<ParkingSpot> getClosestSpotForVehicleFromEntrance(ParkingEntrance parkingEntrance, ParkingRequest parkingRequest) {
        if (!parkingSpotPQ.get(parkingEntrance).get(parkingRequest.getVehicleType()).isEmpty()) {
            return Optional.ofNullable(parkingSpotPQ.get(parkingEntrance).get(parkingRequest.getVehicleType()).poll());
        }
        return Optional.empty();
    }
}
