FROM adoptopenjdk/openjdk11:jdk-11.0.15_10-alpine-slim

COPY ./build/libs/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "/app.jar"]
