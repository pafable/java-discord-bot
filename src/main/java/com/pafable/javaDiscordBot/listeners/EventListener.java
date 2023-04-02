package com.pafable.javaDiscordBot.listeners;

import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.react.MessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class EventListener extends ListenerAdapter {
    // when a user sends a specific message this will respond
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String message = event.getMessage()
                .getContentRaw();

        if (message.contains("ping") || message.contains("PING")) {
            event.getChannel()
                    .sendMessage("pong")
                    .queue();
        }
    }

    // when a user reacts with any emoji the bot will send a message
//    @Override
//    public void onMessageReactionAdd(MessageReactionAddEvent event) {
//        User user = event.getUser();
//
//        String emoji = event.getReaction()
//                .getEmoji()
//                .getAsReactionCode();
//
//        String channelMention = event.getChannel()
//                .getAsMention();
//
//        String jumpLink = event.getJumpUrl();
//
//        String message = user.getAsTag() + " reacted to a message with "
//                + emoji + " in the "
//                + channelMention
//                + " channel!";
//
//
//        // sends bot messages to default channel
//        /**
//        event.getGuild()
//                .getDefaultChannel()
//                .asStandardGuildMessageChannel()
//                .sendMessage(message)
//                .queue();
//         **/
//
//        // sends bot message to a channel with the name "bot-testing"
//        final String botChannel = "bot-testing";
//        TextChannel textChannel = event.getGuild()
//                .getTextChannelsByName(botChannel, true).get(0);
//
//        textChannel.sendMessage(
//                message + " " + jumpLink
//        ).queue();
//    }

    @Override
    public void onGuildMemberJoin(GuildMemberJoinEvent event) {
        super.onGuildMemberJoin(event);
        final String name = event.getUser()
                .getName();

        final String avatar = event.getUser()
                .getEffectiveAvatarUrl();

        final String serverName = event.getGuild()
                .getName();

        System.out.printf(
                "%s: %s",
                name,
                avatar
        );

        String message = "Welcome to the " + serverName
                + " discord server, "
                + name
                + "!";

        event.getGuild()
                .getDefaultChannel()
                .asStandardGuildMessageChannel()
                .sendMessage(message)
                .queue();
    }
}
