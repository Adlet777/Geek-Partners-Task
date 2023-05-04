FROM maven:3.8.3-openjdk-17 AS build

WORKDIR /Geek-Partners-Task
COPY ./ .
RUN mvn clean install

CMD mvn spring-boot:run
