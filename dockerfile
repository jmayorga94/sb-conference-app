FROM openjdk:11-jre-slim
VOLUME /tmp
COPY target/*.jar conference-demo-api-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=dev","/conference-demo-api-0.0.1-SNAPSHOT.jar"]