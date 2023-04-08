package com.pafable.javaDiscordBot.commands;

import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CommandManager extends ListenerAdapter {

    private final List<CommandData> commandDataList = new ArrayList<>();

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        super.onSlashCommandInteraction(event);

        String command = event.getName();

        Welcome.createCommand(
                command,
                event
        );

        Roles.createCommand(
                command,
                event
        );

        Roll.createCommand(
                command,
                event
        );

        Say.createCommand(
                command,
                event
        );

        Motto.createCommand(
                command,
                event
        );

        Caution.createCommand(
                command,
                event
        );
    }

    // Guild command -- instantly updated (max 100)
    @Override
    public void onGuildReady(@NotNull GuildReadyEvent event) {
        super.onGuildReady(event);

        commandDataList.add(Welcome.commandData);
        commandDataList.add(Roles.commandData);
        commandDataList.add(Roll.commandData);
        commandDataList.add(Say.commandData);
        commandDataList.add(Motto.commandData);
        commandDataList.add(Caution.commandData);

        // add all the commands
        event.getGuild()
                .updateCommands()
                .addCommands(commandDataList)
                .queue();
    }

    @Override
    public void onGuildJoin(@NotNull GuildJoinEvent event) {
        super.onGuildJoin(event);

        commandDataList.add(Welcome.commandData);

        event.getGuild()
                .updateCommands()
                .addCommands(commandDataList)
                .queue();
    }
}
