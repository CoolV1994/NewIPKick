package com.coolv1994.newipkick.commands;

import com.coolv1994.newipkick.Plugin;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by CoolV1994 on 11/16/15.
 */
public class NIKCommand implements CommandExecutor {
    private final Plugin plugin;

    public NIKCommand(Plugin plugin) {
        this.plugin = plugin;
        plugin.getCommand("nik").setExecutor(this);
    }

    private String getMessage(String[] args) {
        if (args == null)
            return "";

        int end = args.length - 2;
        if (end == -1)
            return "";

        StringBuilder b = new StringBuilder();
        for (int i = 1; ; i++) {
            b.append(args[i]);
            if (i == end)
                return b.toString();
            b.append(" ");
        }
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            plugin.reloadConfig();
            return true;
        }
        if (args.length > 1 && args[0].equalsIgnoreCase("setmsg")) {
            plugin.getConfig().set("message", getMessage(args));
            plugin.saveConfig();
            return true;
        }
        sender.sendMessage("Use command: " + ChatColor.RED + "/nik setmsg <message>" + ChatColor.WHITE + " to change kick message.");
        sender.sendMessage("Use command: " + ChatColor.RED + "/nik reload" + ChatColor.WHITE + " to reload config.");
        return true;
    }
}
