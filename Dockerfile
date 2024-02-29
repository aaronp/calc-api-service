FROM openjdk:11

# Add Maintainer Info
LABEL maintainer="aaron.pritzlaff@gmail.com"

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=./server/target/openapi-spring-*.jar

# Add the application's jar to the container
ADD ${JAR_FILE} myapplication.jar

# Run the jar file
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/myapplication.jar"]
