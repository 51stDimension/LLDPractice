package org.dev.tictactoe;

import lombok.Value;
import lombok.experimental.NonFinal;

@Value
@NonFinal
public abstract class ActiveSessionBoard {

    //not mixing structure with game mechanics

    Piece[][] boardGrid;

    public ActiveSessionBoard(Board board) {
        this.boardGrid = new Piece[board.getLength()][board.getLength()];
    }

    abstract void markCell(Integer row, Integer col);
}
