FROM openjdk:8-jdk-alpine
EXPOSE 5555
ARG JAR_FILE
ARG EUREKA_SERVER=http://localhost:8761/eureka
VOLUME /tmp
COPY ${JAR_FILE} /api-gateway.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/api-gateway.jar"]