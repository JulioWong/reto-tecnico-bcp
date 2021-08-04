FROM openjdk:11-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
COPY target/test-intercorp-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8040
ENTRYPOINT ["java", "-jar", "/app.jar"]