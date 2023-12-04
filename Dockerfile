# Use a base image with Java and a minimal OS
FROM openjdk:17

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at the working directory
COPY target/spring-jar.jar /app/spring-jar.jar

# Expose the port your application runs on
EXPOSE 8089

# Specify the command to run your application
CMD ["java", "-jar", "spring-jar.jar"]
