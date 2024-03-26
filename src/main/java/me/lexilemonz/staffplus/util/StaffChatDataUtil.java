package me.lexilemonz.staffplus.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class StaffChatDataUtil {
    private static final Map<UUID, Boolean> staffChatStatuses = new HashMap<>();
    public static void toggleStaffChat(Player player) {
        UUID playerUUID = player.getUniqueId();
        Boolean currentStatus = staffChatStatuses.get(playerUUID);
        staffChatStatuses.put(playerUUID, !currentStatus);
        if (!currentStatus) {
            NotifierUtil.notify(player, ChatColor.GREEN + "Toggled staff chat on");
        } else {
            NotifierUtil.notify(player, ChatColor.RED + "Toggled staff chat off");
        }
    }

    public static boolean isStaffChatEnabled(UUID playerUUID) {
        Boolean enabled = staffChatStatuses.get(playerUUID);
        return enabled != null && enabled;
    }

    public static void updatePlayerFromStaffChatStatuses(UUID playerUUID) {
        if (staffChatStatuses.containsKey(playerUUID)) {
            staffChatStatuses.remove(playerUUID);
        } else {
            staffChatStatuses.put(playerUUID, false);
        }
    }
}
