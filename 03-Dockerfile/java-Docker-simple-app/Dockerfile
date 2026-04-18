
# docker file if you already have a jar file built and want to run it in a container
# FROM eclipse-temurin:25-jdk
# WORKDIR /app
# COPY target/*.jar app.jar
# CMD ["java", "-jar", "app.jar"]

# ===================================================================
# docker file if you want to build the jar file in the container
# ===================================================================

# using base image with maven and jdk 25 to build the application
FROM maven:3.9.4-eclipse-temurin-21 AS build

# set the working directory in the container
WORKDIR /app    

# copy the pom.xml and source code to the container
COPY . .

# build the application and create the jar file
RUN mvn clean package 

# ===================================================================
# Use an official Eclipse Temurin image to run the application
# ===================================================================

# using base image with jdk 25 to run the application
FROM eclipse-temurin:25-jdk

# set the working directory in the container
WORKDIR /app

# copy the jar file from the build stage to the current stage
COPY --from=build /app/target/*.jar app.jar

# command to run the application. run java with the jar file in the app.jar
CMD ["java", "-jar", "app.jar"]