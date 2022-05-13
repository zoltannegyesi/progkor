FROM openjdk:17-jdk-alpine3.14

COPY "./target/carshop.jar" "/application/carshop.jar"

CMD ["java", "-jar", "/application/carshop.jar"]