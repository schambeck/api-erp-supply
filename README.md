# api-erp-supply
[![build](https://github.com/schambeck/api-erp-supply/actions/workflows/gradle.yml/badge.svg)](https://github.com/schambeck/api-erp-supply/actions/workflows/gradle.yml)
[![coverage](https://sonarcloud.io/api/project_badges/measure?project=schambeck_api-erp-supply&metric=coverage)](https://sonarcloud.io/summary/new_code?id=schambeck_api-erp-supply)

## ERP Supply API

### Simple Clean Architecture

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

    java -jar app/build/libs/api-erp-supply-app-1.0.0.jar

### RabbitMQ Web Interface

    http://localhost:15672
    User: guest
    Pass: guest

### Related Projects

- Sales: [erp-sales](https://github.com/schambeck/api-erp-sales)
- Contributor
