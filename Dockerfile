FROM openjdk:8
EXPOSE 80
ADD target/testDevops-4.0-SNAPSHOT.jar testDevops-docker.jar
ENTRYPOINT ["java","-jar","testDevops-docker.jar"]
