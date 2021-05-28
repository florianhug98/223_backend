FROM openjdk:11
EXPOSE 8080
ARG JAR_FILE=target/m223_backend-0.1.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
