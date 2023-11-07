FROM openjdk:8
EXPOSE 80
ADD target/5TWIN6-DevGurus-Kaddem.jar  5TWIN6-DevGurus-Kaddem.jar
ENTRYPOINT ["java","-jar","5TWIN6-DevGurus-Kaddem.jar"]
