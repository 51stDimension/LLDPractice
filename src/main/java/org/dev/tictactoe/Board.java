package org.dev.tictactoe;

import lombok.Value;

import java.util.Objects;

@Value
public class Board {

    Integer length;

    public Board(Integer length) {
        this.length = length;
    }

}
