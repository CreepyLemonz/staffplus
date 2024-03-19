package me.lexilemonz.staffplus.listeners;

import me.lexilemonz.staffplus.Staffplus;
import me.lexilemonz.staffplus.util.NotifierUtil;
import me.lexilemonz.staffplus.util.StaffChatDataUtil;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.UUID;

public class PlayerChatListener implements Listener {
    private final Staffplus plugin;

    public PlayerChatListener(Staffplus plugin) {
        this.plugin = plugin;
    }

    @EventHandler (priority = EventPriority.LOWEST)
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();
        if (player.hasPermission("staffplus.staffchat") && StaffChatDataUtil.isStaffChatEnabled(playerUUID)) {
            event.setCancelled(true);
            String message = event.getMessage();
            NotifierUtil.staffChatAll(player, message);
        }
    }
}
