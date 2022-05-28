package com.github.hexa.edencord;

import net.essentialsx.api.v2.services.discord.DiscordService;
import net.essentialsx.api.v2.services.discord.InteractionException;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class EdenCord extends JavaPlugin {
    public static EdenCord instance;
    public FileConfiguration config = getConfig();

    @Override
    public void onEnable() {
        instance = this;
        getLogger().info("EdenCord enabled!");
        this.saveDefaultConfig();
        this.reloadConfig();
        this.getCommand("edencord").setExecutor(new CommandEngine());
        DiscordService api = Bukkit.getServicesManager().load(DiscordService.class);
        if (api != null) {
            try {
                api.getInteractionController().registerCommand(new StatusCommand());
            } catch (InteractionException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("EdenCord disabled!");
    }

    public static EdenCord getInstance() {
        return instance;
    }

    @Override
    public void reloadConfig() {
        super.reloadConfig();
        saveDefaultConfig();
        config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();
    }
}
