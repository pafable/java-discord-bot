package com.pafable.javaDiscordBot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

public class Welcome {
    public static void createCommand(String command, SlashCommandInteractionEvent event) {
        if (command.equals("welcome")) {
            String userTag = event.getUser()
                    .getAsTag();

            event.deferReply()
                    .queue();

            event.getHook()
                    .sendMessage(
                            "Welcome to the server, **"
                                    + userTag
                                    + "** and FOR THE EMPEROR!"
                    ).queue();
        }
    }

    public static final SlashCommandData commandData = Commands.slash(
            "welcome",
            "Get welcomed by bot"
    );
}
