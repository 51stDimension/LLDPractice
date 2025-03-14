package org.dev.parkingLot;

import lombok.Getter;
import org.dev.parkingLot.models.Coordinate;
import org.dev.parkingLot.models.EntryTerminal;
import org.dev.parkingLot.models.Vehicle;
import org.dev.parkingLot.strategy.ParkingStrategy;

import java.util.*;

@Getter
public class Parking {

    private final List<BaseParkingSpot> parkingSpots;
    private final List<EntryTerminal> entryTerminals;
    private final Map<String, Map<String, TreeSet<BaseParkingSpot>>> tsMapping = new HashMap<>();

    public Parking() {
        // Constructor for dummy init
        this.parkingSpots = List.of(
                new FourWheelerParkingSpot(UUID.randomUUID().toString(), new Coordinate(0,0)),
                new FourWheelerParkingSpot(UUID.randomUUID().toString(), new Coordinate(0,1)),
                new TwoWheelerParkingSpot(UUID.randomUUID().toString(), new Coordinate(1,1)),
                new TwoWheelerParkingSpot(UUID.randomUUID().toString(), new Coordinate(1,0))
        );
        this.entryTerminals = List.of(
                EntryTerminal.builder().id(UUID.randomUUID().toString()).coordinate(new Coordinate(0,0)).build(),
                EntryTerminal.builder().id(UUID.randomUUID().toString()).coordinate(new Coordinate(0,1)).build()
        );
        initParking();
    }

    public Parking(List<BaseParkingSpot> parkingSpots, List<EntryTerminal> entryTerminals) {
        this.parkingSpots = parkingSpots;
        this.entryTerminals = entryTerminals;
        initParking();
    }

    private void initParking() {
        validateParkingStructure();
        entryTerminals.forEach(
                entryTerminal -> {
                    tsMapping.putIfAbsent(entryTerminal.getId(), new HashMap<>());
                    parkingSpots.forEach(
                            parkingSpot -> {
                                tsMapping.get(entryTerminal.getId()).putIfAbsent(
                                        parkingSpot.getVehicleType().name(),
                                        new TreeSet<>(Comparator.comparingInt(spot -> spot.getDistanceFromEntry(entryTerminal)))
                                );
                                tsMapping.get(entryTerminal.getId()).get(parkingSpot.getVehicleType().name()).add(parkingSpot);
                            }
                    );
                }
        );
    }

    private void validateParkingStructure() {
        // Run validation if any during init
    }

    public Optional<BaseParkingSpot> getParkingSpotForVehicle(Vehicle vehicle, EntryTerminal entryTerminal, ParkingStrategy parkingStrategy) {
        return parkingStrategy.getParkingSlot(vehicle, entryTerminal, this);
    }
}
