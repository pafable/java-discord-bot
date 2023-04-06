package com.pafable.javaDiscordBot.commands;

import net.dv8tion.jda.api.entities.channel.ChannelType;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

public class Say {
    public static void createCommand(String command, SlashCommandInteractionEvent event) {
        if (command.equals("say")) {
            OptionMapping messageOption = event.getOption("message");

            if (messageOption != null) {
                String message = messageOption.getAsString();

                MessageChannel channel;
                OptionMapping chnlOpt = event.getOption("channel");

                if (chnlOpt != null) {
                    channel = chnlOpt.getAsChannel()
                            .asGuildMessageChannel();
                } else {
                    channel = event.getChannel();
                }

                channel.sendMessage(message)
                        .queue();

                event.reply("You message was sent, hopefully it didn't suck!")
                        .setEphemeral(true)
                        .queue();
            }
        }
    }

    // command /say <message> [channel (optional)]
    private static final OptionData messageOption = new OptionData(
            OptionType.STRING,
            "message",
            "The message you want the bot to say",
            true
    );

    private static final OptionData channelOption = new OptionData(
            OptionType.CHANNEL,
            "channel",
            "Channel to send message to",
            false
    ).setChannelTypes(
            ChannelType.GUILD_PRIVATE_THREAD,
            ChannelType.GUILD_PUBLIC_THREAD,
            ChannelType.NEWS,
            ChannelType.TEXT
    );

    public static SlashCommandData commandData = Commands.slash(
            "say",
            "Make the bot say a message"
    ).addOptions(
            // required options must be first
            messageOption,
            channelOption
    );
}
