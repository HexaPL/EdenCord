package com.github.hexa.edencord;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class CommandEngine implements CommandExecutor {
    FileConfiguration config = EdenCord.getInstance().getConfig();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
       if (args.length == 0) {
           sender.sendMessage("[EdenCord] Usage: /edencord reload");
           return true;
       }
        if (args[0].equalsIgnoreCase("reload")) {
           EdenCord.getInstance().reloadConfig();
           sender.sendMessage("[EdenCord] Config reloaded!");
           return true;
       }
       return false;
    }
}
