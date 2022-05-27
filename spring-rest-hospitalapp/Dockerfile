FROM openjdk:11
EXPOSE 8098
COPY /target/spring-rest-hospitalapp-0.0.1-SNAPSHOT.jar hospital-api.jar
ENTRYPOINT ["java","-jar","/hospital-api.jar"]