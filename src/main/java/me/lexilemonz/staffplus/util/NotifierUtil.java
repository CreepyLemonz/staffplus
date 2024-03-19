package me.lexilemonz.staffplus.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class NotifierUtil {
    static String CHAT_PREFIX = ChatColor.GRAY + "[" + ChatColor.GOLD + "Staff" + ChatColor.GRAY + "] ";
    public static void notify(Player player, String message) {
        player.sendMessage(CHAT_PREFIX + message);
    }
    public static void staffChatAll(Player player, String message) {
        for (Player playeri : Bukkit.getOnlinePlayers()) {
            if (playeri.hasPermission("staffplus.staffchat")) {
                playeri.sendMessage(CHAT_PREFIX + ChatColor.GOLD + player.getName() + ChatColor.GRAY + " > " + ChatColor.GRAY + message);
            }
        }
    }
    public static void notifyAll(Player player, String message) {
        for (Player playeri : Bukkit.getOnlinePlayers()) {
            if (playeri.hasPermission("staffplus.staffchat")) {
                playeri.sendMessage(CHAT_PREFIX + ChatColor.GOLD + player.getName() + " " + message);
            }
        }
    }
}
