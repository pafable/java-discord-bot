FROM amazoncorretto:17.0.6-al2023

WORKDIR appl

COPY out/artifacts/java_discord_bot_main_jar/java-discord-bot.jar appl/

CMD ["java", "-jar", "appl/java-discord-bot.jar"]