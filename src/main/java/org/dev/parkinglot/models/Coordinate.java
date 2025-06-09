package org.dev.parkinglot.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Coordinate {

    private Integer x;
    private Integer y;

}
