package org.dev.tictactoe;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class DefaultActiveSessionBoard extends ActiveSessionBoard {

    private final Map<Integer, Integer> rowMetaData = new HashMap<>();
    private final Map<Integer, Integer> colMetaData = new HashMap<>();
    private Integer primaryDiagonal  = 0;
    private Integer secondaryDiagonal = 0;

    public DefaultActiveSessionBoard(Board board) {
        super(board);
    }

    @Override
    void markCell(Integer row, Integer col) {
        rowMetaData.put(row, rowMetaData.getOrDefault(row, 0) + 1);
        colMetaData.put(col, colMetaData.getOrDefault(col, 0) + 1);
        if(row.equals(col)){
            primaryDiagonal++;
        }
        else if(row+col == getBoard().getLength()-1){
            secondaryDiagonal++;
        }
        checkForWin();
    }

    private void checkForWin() {

    }
}
