package com.acrylic.tictactoe.Game.TicTacToe;

import com.acrylic.tictactoe.AcrylicUtils.GUI;
import com.acrylic.tictactoe.AcrylicUtils.Probability;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TicTacToeGameMaster {

    @Getter
    private enum SelectionState {
        PLAYER_1(0,(short)14),
        PLAYER_2(1,(short)6);

        private final int statePhase;
        private final short woolDamageValue;

        SelectionState(int statePhase, short woolDamageValue) {
            this.statePhase = statePhase;
            this.woolDamageValue = woolDamageValue;
        }
    }

    private SelectionState getState(byte index) {
        switch (index) {
            case 0:
                return SelectionState.PLAYER_1;
            default:
                return SelectionState.PLAYER_2;
        }
    }

    /**
     * Target is the player who is allowed to select.
     */
    @Getter
    private Player target;

    private SelectionState selectionState;
    private TicTacToeManager manager;

    public TicTacToeGameMaster(TicTacToeManager manager) {
        this.manager = manager;

        if (manager.isMultiplayer()) {
            byte indexSelect = (byte) new Probability().getInt(0,1);
            target = manager.getPlayers().get(indexSelect);
            selectionState = getState(indexSelect);
            Bukkit.broadcastMessage(indexSelect + "");
        } else {
            target = manager.p;
        }
    }

    public void selectCheck(int slot) {
        GUI gui = manager.getGui();
        ItemStack item = gui.getInventory().getItem(slot);
        if (item.equals(TicTacToeUI.SELECT_ITEM)) {
            item.setDurability(selectionState.getWoolDamageValue());
            gui.setItem(slot,item);
        }
    }



}
