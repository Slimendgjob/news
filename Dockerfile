FROM gradle:7.5.0-jdk17-alpine AS build
WORKDIR /app
ADD --chown=gradle:gradle . /app
RUN gradle build --no-daemon

FROM openjdk:17-jdk-slim
ENV APP_HOME=/app

RUN mkdir /spring
COPY --from=build $APP_HOME/build/libs/news-0.0.1-SNAPSHOT.jar /spring/spring-boot-application.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/spring/spring-boot-application.jar"]