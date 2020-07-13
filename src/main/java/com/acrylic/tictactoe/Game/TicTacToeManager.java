package com.acrylic.tictactoe.Game;

import com.acrylic.tictactoe.AcrylicUtils.GUI;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class TicTacToeManager {

    private static Map<Inventory, TicTacToeManager> cache = new HashMap<>();

    public static TicTacToeManager getInstance(Inventory inventory) {
        return cache.get(inventory);
    }

    @Getter
    protected GUI gui;
    @Getter
    protected TicTacToeGameMaster gameMaster;

    @Getter
    protected Player p;
    @Getter
    protected Player p2;

    public void setCache() {
        cache.put(gui.getInventory(),this);
    }

    public void deleteCache() {
        cache.remove(gui.getInventory());
    }

    public TicTacToeManager getInstance() {
        return this;
    }

    public boolean isMultiplayer() {
        return p2 != null;
    }



}
