package org.dev.parkinglot.models;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EntryTerminal {
    private String id;
    private Coordinate coordinate;
}
