package com.acrylic.tictactoe.Game;

import com.acrylic.tictactoe.AcrylicUtils.GUI;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public abstract class AbstractGame {

    ArrayList<Player> players;

    public AbstractGame() {
        players = new ArrayList<>();
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public abstract void addPlayer();



}
