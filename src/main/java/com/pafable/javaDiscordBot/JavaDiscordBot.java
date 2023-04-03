package com.pafable.javaDiscordBot;

import com.pafable.javaDiscordBot.builders.EventBuilder;
import com.pafable.javaDiscordBot.commands.CommandManager;
import com.pafable.javaDiscordBot.listeners.EventListener;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

public class JavaDiscordBot {
    private final String token = System.getenv("DISCORD_BOT_TOKEN");
    private final ShardManager shardManager;

    public JavaDiscordBot() throws LoginException {
        shardManager = EventBuilder.createShardManger(
                token,
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.GUILD_PRESENCES,
                GatewayIntent.MESSAGE_CONTENT
        );

        // register new listeners
        shardManager.addEventListener(
                new EventListener(),
                new CommandManager()
        );
    }

    public ShardManager getShardManager() {
        return shardManager;
    }

    public static void main(String[] args) {
        try {
            JavaDiscordBot bot = new JavaDiscordBot();
        } catch (LoginException e) {
            System.out.println("ERROR: Bot token is invalid");
        }
    }
}
