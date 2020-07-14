package com.acrylic.tictactoe.Game.TicTacToe;

import com.acrylic.tictactoe.AcrylicUtils.GUI;
import com.acrylic.tictactoe.AcrylicUtils.ItemCreator;
import com.acrylic.tictactoe.Game.GameUI;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.ItemStack;

public class TicTacToeUI extends TicTacToeManager implements GameUI {

    public static final ItemStack SELECT_ITEM = new ItemCreator(Material.WOOL).setItemName("&e???").setLore("&eLeft Click&r&7 to &eSelect").getItem();
    public static final String GUI_NAME = "&e&lTic-Tac-Toe&r";
    public final static int MAX_COLUMNS_PER_ROW = 3;

    /**
     * Opens a GUI for the player to play.
     * @param p Player
     */
    public TicTacToeUI(Player p) {
        super.p = p;
        setup();
        gui.show(p);
    }

    /**
     * Opens a GUI for the player to play.
     * (Multiplayer mode)
     * @param p Player
     */
    public TicTacToeUI(Player p, Player p2) {
        super.p = p;
        super.p2 = p2;
        setup();
        gui.show(p);
        gui.show(p2);
    }

    /**
     * Sets up the GUI for the player(s)
     */
    public void setup() {
        gui = new GUI(GUI_NAME, InventoryType.DISPENSER);
        gui.fill(SELECT_ITEM);
        super.gameMaster = new TicTacToeGameMaster(super.getInstance());
        super.setup();
    }


    @Override
    public GUI getGUI() {
        return gui;
    }

    @Override
    public String getUITitle() {
        return GUI_NAME;
    }

    @Override
    public int getRows() {
        return MAX_COLUMNS_PER_ROW;
    }
}
