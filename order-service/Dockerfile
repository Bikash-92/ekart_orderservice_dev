FROM eclipse-temurin:latest
# Stage 1: Build the JAR using Maven
FROM maven:3.8.4-openjdk-17 AS build-java17


# Set the working directory inside the container
WORKDIR /app

# Copy the Maven project files
COPY pom.xml /app/pom.xml
COPY src /app/src

RUN mvn --version

# Run Maven to build the project (this will create the JAR file)
RUN mvn clean install

# Stage 2: Create a minimal image with the JAR file
#FROM openjdk:17-jdk-slim 


# Set the working directory inside the container
WORKDIR /app

RUN pwd

RUN ls -al /app

# Copy the built JAR from the builder image to the runtime image
COPY /root/.m2/repository/com/ekart/order-service/0.0.1-SNAPSHOT/order-service-0.0.1-SNAPSHOT.jar /app/order-service-0.0.1-SNAPSHOT.jar

# Expose the application port (assuming Spring Boot runs on port 8082)
EXPOSE 8082

# Run the Spring Boot application JAR
CMD ["java", "-jar", "order-service-0.0.1-SNAPSHOT.jar"]
