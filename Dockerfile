FROM openjdk:21-slim-buster
COPY /target/ /usr/app/
EXPOSE 8080  
ENTRYPOINT ["java","-jar","/usr/app/projetoIntegrador-0.0.1-SNAPSHOT.jar"]