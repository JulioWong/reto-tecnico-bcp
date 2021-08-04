FROM openjdk:11-slim
VOLUME /tmp
ARG JAR_FILE
COPY target/desafio_tecnico-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8040
ENTRYPOINT ["java", "-jar", "/app.jar"]