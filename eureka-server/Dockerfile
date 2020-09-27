FROM openjdk:8-jdk-alpine
EXPOSE 8761
ARG JAR_FILE
VOLUME /tmp
COPY ${JAR_FILE} eureka-server.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/eureka-server.jar"]