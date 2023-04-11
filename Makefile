APPNAME = 'java-discord-bot'

.PHONY: build build_container clean

build:
	./gradlew shadowJar

build_container: build
	docker build \
      --tag $(APPNAME) \
      .

run: build_container
	docker run \
      --detach \
      --name $(APPNAME) \
      --env DISCORD_BOT_TOKEN=${DISCORD_BOT_TOKEN} \
      $(APPNAME)

clean:
	rm -r build/libs/java-discord-bot-*.jar
	docker rm -f $(APPNAME)
	docker rmi $(APPNAME)
