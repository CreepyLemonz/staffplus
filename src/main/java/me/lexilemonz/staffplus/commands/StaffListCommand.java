package me.lexilemonz.staffplus.commands;

import me.lexilemonz.staffplus.Staffplus;
import me.lexilemonz.staffplus.util.StaffListUtil;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffListCommand implements CommandExecutor {
    private final Staffplus plugin;

    public StaffListCommand(Staffplus plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Player only command.");
            return true;
        }

        Player player = (Player) sender;

        if (!player.hasPermission("staffplus.staffchat")) {
            sender.sendMessage(ChatColor.RED + "No permission.");
            return true;
        }

        StaffListUtil.sendOnlineStaffList(player);
        return true;
    }
}
