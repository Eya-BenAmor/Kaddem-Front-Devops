FROM openjdk:8
EXPOSE 80
ADD target/khaddem-4.0.2.jar.original  khaddem-4.0.2.jar
ENTRYPOINT ["java","-jar","khaddem-4.0.2.jar"]
