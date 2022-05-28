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
        String statusMessage = EdenCord.getInstance().getConfig().getString("status-message");
        String[] statusMessageSplit = statusMessage.split("%player_count%", 2);
        event.reply(statusMessageSplit[0] + playerCount + statusMessageSplit[1]);
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
