# Use the official Maven image for building the Spring Boot application
FROM maven:3.8.4-openjdk-17-slim AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the entire project to the working directory
COPY . /app

# Build the Spring Boot application using Maven
RUN mvn clean install -DskipTests

# Use the official OpenJDK image for the runtime
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the compiled Spring Boot application from the build stage
COPY --from=build /app/target/ProjectManagementBoardAPI-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port that the Spring Boot application will run on
EXPOSE 8080

# Start the Spring Boot application
CMD ["java", "-jar", "app.jar"]
