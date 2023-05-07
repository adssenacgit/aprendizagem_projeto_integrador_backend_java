FROM maven:3.9.1-eclipse-temurin-20-alpine as build
COPY src /usr/src/app/src  
ADD pom.xml /usr/src/app
ADD mvnw /usr/src/app  
RUN mvn -f /usr/src/app/pom.xml clean package -Dmaven.test.skip=true

FROM openjdk:21-slim-buster
COPY --from=build /usr/src/app/target/projetoIntegrador-0.0.1-SNAPSHOT.jar /usr/app/projetoIntegrador-0.0.1-SNAPSHOT.jar
EXPOSE 8080  
ENTRYPOINT ["java","-jar","/usr/app/projetoIntegrador-0.0.1-SNAPSHOT.jar"]