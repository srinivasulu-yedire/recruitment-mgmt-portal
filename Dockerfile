FROM openjdk:11
#FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app_recruitment.jar
ENTRYPOINT ["java","-jar","/app_recruitment.jar"]