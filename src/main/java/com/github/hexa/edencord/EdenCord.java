package com.github.hexa.edencord;

import net.essentialsx.api.v2.services.discord.DiscordService;
import net.essentialsx.api.v2.services.discord.InteractionException;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class EdenCord extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("EdenCord enabled!");
        final DiscordService api = Bukkit.getServicesManager().load(DiscordService.class);
        try {
            api.getInteractionController().registerCommand(new StatusCommand());
        } catch (InteractionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("EdenCord disabled!");
    }
}
