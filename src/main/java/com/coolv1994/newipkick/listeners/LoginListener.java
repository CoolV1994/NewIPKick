package com.coolv1994.newipkick.listeners;

import com.coolv1994.newipkick.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

/**
 * Created by CoolV1994 on 11/16/15.
 */
public class LoginListener implements Listener {
    private final Plugin plugin;

    public LoginListener(Plugin plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onLogin(final PlayerLoginEvent event) {
        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
            @Override
            public void run() {
                event.getPlayer().kickPlayer(
                        ChatColor.translateAlternateColorCodes('&',
                                plugin.getConfig().getString("message")));
            }
        }, 10);
    }
}
