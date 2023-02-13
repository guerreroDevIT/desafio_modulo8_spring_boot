FROM amazoncorretto:8-alpine-jdk
MAINTAINER IsaacGuerrero
COPY target/josue-0.0.1-SNAPSHOT.jar josue-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/josue-0.0.1-SNAPSHOT.jar"]