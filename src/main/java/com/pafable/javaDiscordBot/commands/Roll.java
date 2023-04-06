package com.pafable.javaDiscordBot.commands;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.OptionData;
import net.dv8tion.jda.api.interactions.commands.build.SlashCommandData;

import java.util.Random;

public class Roll {
    public static void createCommand(String command, SlashCommandInteractionEvent event) {
        if (command.equals("roll")) {
            int sides;
            int result;
            OptionMapping sidesOption = event.getOption("sides");
            String userTag = event.getUser()
                    .getAsTag();

            event.deferReply()
                    .queue();

            Random random = new Random();

            if (sidesOption != null) {
                sides = sidesOption.getAsInt();
            } else {
                sides = 6;
            }

            result = random.nextInt(sides) + 1;

            event.getHook()
                    .sendMessage(
                            "**"
                                    + userTag
                                    + "**"
                                    + " rolled a "
                                    + sides
                                    + " sided die and got *"
                                    + result
                                    + "*"
                    ).queue();
        }
    }

    // command /roll [number of sides on a die (optional)]
    // if number of sides is not specified then it defaults to 6
    private final static OptionData dieSidesOption = new OptionData(
            OptionType.INTEGER,
            "sides",
            "number of sides",
            false
    );

    public static final SlashCommandData commandData = Commands.slash(
            "roll",
            "Dice roll"
    ).addOptions(dieSidesOption);
}
