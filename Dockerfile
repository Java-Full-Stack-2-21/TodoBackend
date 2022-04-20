# Keywords of Dockerfiles:
#   - FROM: can pull a base image from docker hub
#   - COPY: adds files and folders in your current environment to the docker container
#   - RUN: runs bash commands in the container


# build stage
# This stage will have to do with building our application into a jar file
FROM maven:3.8.5-jdk-11-slim AS build

# We are copying the src folder in our project and putting it in a location in our container
COPY src /home/app/src
COPY pom.xml /home/app/pom.xml
RUN mvn -f /home/app/pom.xml clean package

# run stage
# Once we do the FROM command again, think of it as a completely isolated image from the other FROM
# so we need to get the jar file from the previous stage and then running it
FROM openjdk:11-jre-slim
#we are taking the jar generated from the previous stage and putting the jar in this stage
COPY --from=build /home/app/target/TodoBackend-0.0.1-SNAPSHOT.jar /home/app/App.jar
#exposing the port 9000 on the container
EXPOSE 9000
#Run the jar
ENTRYPOINT ["java", "-jar", "/home/app/App.jar"]
