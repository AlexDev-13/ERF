FROM openjdk:16
EXPOSE 8080
ADD target/erf-docker.jar erf-docker.jar
ENTRYPOINT ["java","-jar","/erf-docker.jar"]