# srv-erp-supply
[![build](https://github.com/schambeck/srv-erp-supply/actions/workflows/gradle.yml/badge.svg)](https://github.com/schambeck/srv-erp-supply/actions/workflows/gradle.yml)

## ERP Supply API

### Tech Stack

- Java 17
- Spring Boot
- PostgreSQL, Flyway
- RabbitMQ
- JUnit 5, Mockito, JaCoCo

### Start infra (PostgreSQL and RabbitMQ)

    docker-compose up -d

### Build artifact

    ./gradlew clean bootJar

### Run backend

    java -jar app/build/libs/srv-erp-supply-app-1.0.0.jar

### RabbitMQ Web Interface

    http://localhost:15672
    User: guest
    Pass: guest
