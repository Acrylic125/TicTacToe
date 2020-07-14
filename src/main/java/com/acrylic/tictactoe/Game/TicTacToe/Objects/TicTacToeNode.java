package com.acrylic.tictactoe.Game.TicTacToe.Objects;

import com.acrylic.tictactoe.Game.GameUI;
import com.acrylic.tictactoe.Game.TicTacToe.TicTacToeUI;
import lombok.Getter;
import lombok.Setter;

public class TicTacToeNode {

    @Getter @Setter
    private int x;
    @Getter @Setter
    private int y;

    private final int originSlot;

    public TicTacToeNode(int originSlot) {
        this.originSlot = originSlot;
    }

    public int getSlot(int x,int y) {
        return originSlot + x - (y * TicTacToeUI.MAX_COLUMNS_PER_ROW);
    }

    public TicTacToeNode getNodeFromSlot(int slot) {
        TicTacToeNode node = new TicTacToeNode(originSlot);

        int MAX_COLUMNS_PER_ROW = TicTacToeUI.MAX_COLUMNS_PER_ROW;

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
