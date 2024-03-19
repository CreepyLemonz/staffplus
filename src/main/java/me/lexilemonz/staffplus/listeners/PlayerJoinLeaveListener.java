package me.lexilemonz.staffplus.listeners;

import me.lexilemonz.staffplus.Staffplus;
import me.lexilemonz.staffplus.util.NotifierUtil;
import me.lexilemonz.staffplus.util.StaffChatDataUtil;
import me.lexilemonz.staffplus.util.StaffListUtil;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.UUID;

public class PlayerJoinLeaveListener implements Listener {

    private final Staffplus plugin;
    private final BukkitScheduler scheduler;

    public PlayerJoinLeaveListener(Staffplus plugin) {
        this.plugin = plugin;
        this.scheduler = plugin.getServer().getScheduler();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("staffplus.staffchat")) {
            UUID playerUUID = player.getUniqueId();
            StaffChatDataUtil.updatePlayerFromStaffChatStatuses(playerUUID);
            NotifierUtil.notifyAll(player, ChatColor.GREEN + "joined the game.");
            scheduler.runTaskLater(plugin, () -> {
                StaffListUtil.sendOnlineStaffList(player);
            }, 10);
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("staffplus.staffchat")) {
            UUID playerUUID = player.getUniqueId();
            StaffChatDataUtil.updatePlayerFromStaffChatStatuses(playerUUID);
            NotifierUtil.notifyAll(player, ChatColor.RED + "left the game.");
        }
    }
}
