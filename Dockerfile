# Start with a base image containing Java runtime
FROM public.ecr.aws/docker/library/openjdk:17-alpine

LABEL authors="danielabonilla"

# Add a volume pointing to /tmp
VOLUME /tmp

# The application's jar file
ARG JAR_FILE=target/franchise.jar

# Add the application's jar to the container
COPY ${JAR_FILE} franchise.jar

# Make port 8080 available to the world outside this container
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java","-jar","/franchise.jar"]