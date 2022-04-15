FROM openjdk:17
COPY target/wholesale-engineering-demo-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-server", "-jar","/app.jar"]