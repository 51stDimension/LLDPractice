package org.dev.parkingLot.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
