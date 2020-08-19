# Pull base image which has Open jdk
FROM openjdk:8u191-jre-alpine3.8

# Required in executing waitForGridToUp.sh
RUN apk add curl jq

# Workspace
WORKDIR /usr/sapient/demo

# ADD .jar and libs into this image
ADD target/org.sapient.selenium.docker.demo-tests.jar 	org.sapient.selenium.docker.demo-tests.jar
ADD target/libs											libs

# ADD suite files
ADD testng.xml				testng.xml

# ADD waitForGridToUp script
ADD waitForGridToUp.sh          waitForGridToUp.sh

ENTRYPOINT sh waitForGridToUp.sh