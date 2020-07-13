package com.acrylic.tictactoe;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.java.JavaPlugin;

public final class TicTacToe extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Tic tac toe");
        Server server = Bukkit.getServer();
        server.getPluginCommand("ttt").setExecutor(new TTTCmd());
        server.getPluginManager().registerEvents(new TTTCmd(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
