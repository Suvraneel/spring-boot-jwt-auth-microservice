# Use the Eclipse Temurin (AdoptOpenJDK) Alpine base image with Java 17
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the JAR file into the container and rename it
COPY target/vishnu-0.0.1-SNAPSHOT.jar /app/vishnu.jar

# Set the default entry point to execute the Java application
ENTRYPOINT ["java", "-jar", "/app/vishnu.jar"]