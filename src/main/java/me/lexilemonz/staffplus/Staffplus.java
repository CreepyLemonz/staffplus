package me.lexilemonz.staffplus;

import me.lexilemonz.staffplus.commands.StaffChatCommand;
import me.lexilemonz.staffplus.commands.StaffListCommand;
import me.lexilemonz.staffplus.listeners.PlayerChatListener;
import me.lexilemonz.staffplus.listeners.PlayerJoinLeaveListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Staffplus extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("STARTED");

        getCommand("staffchat").setExecutor(new StaffChatCommand(this));
        getCommand("stafflist").setExecutor(new StaffListCommand(this));

        getServer().getPluginManager().registerEvents(new PlayerJoinLeaveListener(this), this);
        getServer().getPluginManager().registerEvents(new PlayerChatListener(this), this);
    }
}
