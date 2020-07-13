package com.acrylic.tictactoe.AcrylicUtils;

import org.bukkit.ChatColor;

public class ChatUtils {

    public static String get(String text) {
        return ChatColor.translateAlternateColorCodes('&',text);
    }
}
