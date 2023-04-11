# Java Discord Bot

## Setup
Create an environment variable with the name `DISCORD_BOT_TOKEN`

This project was tested on Java 17

## Build a Jar File
```shell
./gradlew shadowJar
```

## Run the Jar File
```shell
java -jar java-discord-bot-1.0.0.jar
```

## Build Container
```shell
docker build \
  --tag java-discord-bot:1.0.0 \
  .
```

## Run Container
```shell
docker run \
  --detach \
  --name java_discord_bot \
  --env DISCORD_BOT_TOKEN=${DISCORD_BOT_TOKEN} \
  java-discord-bot:1.0.0
```

## Discord Slash Commands
| Command  | Description                                                              |
|:---------|:-------------------------------------------------------------------------|
| /caution | Bot will say a cautionary message                                        | 
| /motto   | Bot recite the Adeptus Custodes motto                                    |
| /roles   | Bot will display roles on the server                                     | 
| /roll    | Bot will roll a die. You have the option to specify the number of sides  |
| /say     | Bot will say whatever message you type in after                          |
| /welcome | Bot will welcome a user                                                  |
