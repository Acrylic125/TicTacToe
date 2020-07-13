package com.acrylic.tictactoe.AcrylicUtils;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

public class GUI {
        @Getter
        private Inventory inventory;
        private String guiName;

        /**
         *
         * @param guiName GUI name
         * @param rows The amount of rows in the GUI
         */
        public GUI(String guiName, int rows) {
            this.guiName = ChatUtils.get(guiName);
            inventory = Bukkit.createInventory(null,rows * 6,this.guiName);
        }

        /**
         *
         * @param guiName GUI name
         * @param inventoryType Inventory Type (i.e. Dispenser, Furnace) so no
         *                      slots needed. AVOID USING IT FOR CHESTS!
         */
        public GUI(String guiName, InventoryType inventoryType) {
            this.guiName = ChatUtils.get(guiName);
            inventory = Bukkit.createInventory(null, inventoryType,this.guiName);
        }

        /**
         *
         * @param inventory Inventory to modify
         *                  This should be used for events.
         */
        public GUI(Inventory inventory) {
            this.inventory = inventory;
        }

        /**
         *
         * @param inventoryView inventory player view
         *                  This should be used for events. The inventory variable is defined as the TOP
         *                  inventory. In most cases, the top inventory is used for comparisons.
         */
        public GUI(InventoryView inventoryView) {
            this.inventory = inventoryView.getTopInventory();
        }

        /**
         *
         * @param p Shows the inventory to the specified player.
         */
        public void show(Player p) {
            p.openInventory(inventory);
        }

        /**
         * Fills up the entire inventory with an item
         */
        public void fill() {
            for (int i = 0;i<=inventory.getSize() - 1;i++) {
                inventory.setItem(i, new ItemCreator(Material.STAINED_GLASS_PANE).setItemDamage((short) 15).setItemName("&0").getItem());
            }
        }

        /**
         *
         * @param item Specify an item to fill the entire inventory with.
         */
        public void fill(ItemStack item) {
            for (int i = 0;i<=inventory.getSize() - 1;i++) {
                inventory.setItem(i, item);
            }
        }

        public void setItem(int slot, ItemStack item) {
            inventory.setItem(slot, item);
        }

}
