package com.acrylic.tictactoe.Game.Objects;

import lombok.Getter;
import lombok.Setter;

public class TicTacToeNode {

    private final static int MAX_COLUMNS_PER_ROW = 3;

    @Getter @Setter
    private int x;
    @Getter @Setter
    private int y;

    private int originSlot;

    public TicTacToeNode(int originSlot) {
        this.originSlot = originSlot;
    }

    public int getSlot(int x,int y) {
        return originSlot + x - (y * MAX_COLUMNS_PER_ROW);
    }

    public TicTacToeNode getNodeFromSlot(int slot) {
        TicTacToeNode node = new TicTacToeNode(originSlot);

        int d = slot - originSlot + 1;
        int y;
        if (d < 0) {
            y = (int) -Math.ceil((float) -d / MAX_COLUMNS_PER_ROW);
        } else {
            y = (int) Math.floor((float) d / MAX_COLUMNS_PER_ROW);
        }
        int x = slot - (MAX_COLUMNS_PER_ROW * y) - originSlot;
        node.setX(x);
        node.setY(y);
        return node;
    }


}
