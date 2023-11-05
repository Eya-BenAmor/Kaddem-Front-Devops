FROM openjdk:8
EXPOSE 80
ADD target/khaddem.jar.original  khaddem.jar
ENTRYPOINT ["java","-jar","khaddem.jar"]
