FROM java:8
COPY target/LanServer-0.0.1-SNAPSHOT.jar demolanserver.jar
ENTRYPOINT ["java", "-jar", "/demolanserver.jar"]