# Java Discord Bot

## Setup
Create an environment variable with the name `DISCORD_BOT_TOKEN`

This project was built on Java 17 using [Amazon Corretto 17 JDK](https://docs.aws.amazon.com/corretto/latest/corretto-17-ug/downloads-list.html).

The bot is designed to run on a docker container.

## Build a Jar File
```shell
make build
```
Jar file will be located in `build/libs` directory.

## Run the Jar File
```shell
java -jar java-discord-bot-1.0.0.jar
```

## Build and Run a Container
```shell
make run
```

## Destroying the Container and Removing Build Artifacts
```shell
make clean
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
