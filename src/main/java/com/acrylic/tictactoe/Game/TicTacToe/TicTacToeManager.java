package com.acrylic.tictactoe.Game.TicTacToe;

import com.acrylic.tictactoe.AcrylicUtils.GUI;
import com.acrylic.tictactoe.Game.AbstractGame;
import lombok.Getter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TicTacToeManager extends AbstractGame {

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

    public void setup() {
        addPlayer();
        cache.put(gui.getInventory(),this);
    }

    public void deleteCache() {
        cache.remove(gui.getInventory());
    }

    public TicTacToeManager getInstance() {
        return this;
    }

    public boolean isMultiplayer() {
        return super.getPlayers().size() >= 2;
    }

    @Override
    public void addPlayer() {
        super.getPlayers().add(p);
        if (p2 != null) {
            super.getPlayers().add(p2);
        }
    }
}
