FROM openjdk:17-jdk-slim
LABEL authors="BIKASH"

WORKDIR /app

COPY target/order-service-0.0.1-SNAPSHOT.jar.jar /app/order-service-0.0.1-SNAPSHOT.jar.jar

EXPOSE 8082

CMD ["java", "-jar", "order-service-0.0.1-SNAPSHOT.jar"]
