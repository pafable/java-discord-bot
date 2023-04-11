FROM amazoncorretto:17.0.6-al2023

WORKDIR appl

COPY build/libs/java-discord-bot-*.jar appl/

CMD ["/bin/sh", "-c", "java -jar appl/java-discord-bot-*.jar"]
