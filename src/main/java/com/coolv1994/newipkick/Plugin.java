package com.coolv1994.newipkick;

import com.coolv1994.newipkick.commands.NIKCommand;
import com.coolv1994.newipkick.listeners.LoginListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by vinnie on 11/16/15.
 */
public class Plugin extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("New IP Kick starting.");
        saveDefaultConfig();
        reloadConfig();
        new NIKCommand(this);
        new LoginListener(this);
        getLogger().info("New IP Kick enabled.");
    }

    @Override
    public void onDisable() {
        saveConfig();
        getLogger().info("New IP Kick disabled.");
    }
}
