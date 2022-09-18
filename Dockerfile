FROM openjdk:17
WORKDIR /app
EXPOSE 8080
ADD target/spring-boot-started-for-web-jdbc.jar .
ENTRYPOINT ["java", "-jar", "spring-boot-started-for-web-jdbc.jar"]