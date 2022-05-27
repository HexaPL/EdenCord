package com.github.hexa.edencord;

import org.bukkit.plugin.java.JavaPlugin;

public class EdenCord extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("EdenCord enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("EdenCord disabled!");
    }
}
