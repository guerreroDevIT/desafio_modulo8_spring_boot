FROM amazoncorretto:8-alpine-jdk
MAINTAINER DG
COPY target/dg-0.0.1-SNAPSHOT.jar  dg-app.jar
ENTRYPOINT ["java","-jar","/dg-app.jar"]