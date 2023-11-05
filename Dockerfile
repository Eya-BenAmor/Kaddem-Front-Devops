FROM openjdk:8
EXPOSE 80
ADD target/khaddem.jar  khaddem.jar
ENTRYPOINT ["java","-jar","khaddem.jar"]
