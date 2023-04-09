# Java Discord Bot

## Setup
Create an environment variable with the name `DISCORD_BOT_TOKEN`

## Build Container
```shell
docker build \
  --tag java-discord-bot:<VERSION> \
  .
```

## Run Container
```shell
docker run \
  --detach \
  --name java_discord_bot \
  --env DISCORD_BOT_TOKEN=${DISCORD_BOT_TOKEN} \
  java-discord-bot:<VERSION>
```