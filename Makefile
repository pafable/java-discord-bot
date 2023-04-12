APPNAME = 'java-discord-bot'
DOCKER = $(shell which docker)
DOCKER-COMPOSE = $(shell which docker-compose)
RM = $(shell which rm)

.PHONY: build build_container clean

build:
	./gradlew shadowJar

build_container: build
	$(DOCKER) build \
		--tag $(APPNAME) \
      	.

run: build_container
	$(DOCKER-COMPOSE) up --detach

clean:
	$(DOCKER-COMPOSE) down
	$(DOCKER) rmi $(APPNAME)
	$(RM) -r build/libs/java-discord-bot-*.jar
