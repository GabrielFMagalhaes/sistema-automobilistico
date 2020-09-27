FROM openjdk:8-jdk-alpine
EXPOSE 8081
ARG JAR_FILE
ARG EUREKA_SERVER=http://localhost:8761/eureka
VOLUME /tmp
COPY ${JAR_FILE} automovel-api.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/automovel-api.jar"]