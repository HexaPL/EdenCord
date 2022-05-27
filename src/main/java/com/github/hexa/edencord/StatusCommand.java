package com.github.hexa.edencord;

import net.essentialsx.api.v2.services.discord.InteractionCommand;
import net.essentialsx.api.v2.services.discord.InteractionCommandArgument;
import net.essentialsx.api.v2.services.discord.InteractionEvent;
import org.bukkit.Bukkit;

import java.util.List;

public class StatusCommand implements InteractionCommand {

    @Override
    public void onCommand(InteractionEvent event) {
        int playerCount = Bukkit.getOnlinePlayers().size();
        event.reply("Na serwerze jest obecnie " + playerCount + " graczy.");
    }

    @Override
    public String getName() {
        return "status";
    }

    @Override
    public String getDescription() {
        return "Sprawdza ilosc graczy na serwerze";
    }

    @Override
    public List<InteractionCommandArgument> getArguments() {
        return null;
    }

    @Override
    public boolean isEphemeral() {
        return false;
    }

    @Override
    public boolean isDisabled() {
        return false;
    }
}
