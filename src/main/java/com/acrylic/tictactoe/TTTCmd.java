package com.acrylic.tictactoe;

import com.acrylic.tictactoe.AcrylicUtils.ChatUtils;
import com.acrylic.tictactoe.Game.TicTacToeManager;
import com.acrylic.tictactoe.Game.TicTacToeUI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class TTTCmd implements CommandExecutor, Listener {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        TicTacToeUI ticTacToeUI = new TicTacToeUI(p,p);
        //TicTacToeUI ticTacToe = new TicTacToeUI(p);
        return true;
    }

    @EventHandler
    public void inventoryClick(InventoryClickEvent e) {
        Inventory inventory = e.getInventory();

        if (inventory.getTitle().equals(ChatUtils.get(TicTacToeUI.GUI_NAME))) {
            e.setCancelled(true);

            TicTacToeManager manager = TicTacToeManager.getInstance(inventory);

            Bukkit.broadcastMessage(manager.getP() + "");

        }
    }

}
