package org.dev.parkinglot.observer;

import org.dev.parkinglot.models.EventType;

public interface ParkingLotObserver {
    void notify(EventType eventType, String parkingLotId)
}
