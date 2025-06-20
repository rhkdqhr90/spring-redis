FROM amazoncorretto:17-alpine

COPY build/libs/*SNAPSHOT.jar app.jar


ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/app.jar"]