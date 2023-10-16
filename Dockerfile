FROM openjdk:8
EXPOSE 8082
ADD target/FlightManagement-0.0.1-SNAPSHOT.jar Flight.jar
ENTRYPOINT ["java", "-jar", "Flight.jar"]