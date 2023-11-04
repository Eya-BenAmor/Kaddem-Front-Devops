FROM openjdk:8
EXPOSE 80
ADD target/khaddem-4.0.1-SNAPSHOT.jar khaddem-4.0.1.jar
ENTRYPOINT ["java","-jar","khaddem-4.0.1.jar"]
