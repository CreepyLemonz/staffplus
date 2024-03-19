package me.lexilemonz.staffplus.util;

import com.earth2me.essentials.Essentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class StaffListUtil {
    private static Essentials essentials = (Essentials) Bukkit.getPluginManager().getPlugin("Essentials");

    public static void sendOnlineStaffList(Player player) {
        StringBuilder list = new StringBuilder(ChatColor.GRAY + "---[" + ChatColor.GOLD + "Online Staff" + ChatColor.GRAY + "]---");
        for (Player player_ : Bukkit.getOnlinePlayers()) {
            if (player_.hasPermission("staffplus.staffchat")) {
                String vanishStatus = essentials.getUser(player_).isHidden() ?  ChatColor.RED + "[Vanished]" : ChatColor.GREEN + "[Visible]";
                String afkStatus = essentials.getUser(player_).isAfk() ? ChatColor.RED + "[AFK]" : ChatColor.GREEN + "[Active]";
                String staffmember = "\n" + ChatColor.GRAY + " - "  + ChatColor.GOLD + player_.getName() + " " + vanishStatus + " " + afkStatus;
                list.append(staffmember);
            }
        }
        player.sendMessage(list.toString());
    }
}
