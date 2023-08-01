FROM openjdk:17-alpine

ADD library-exec-0.0.1-SNAPSHOT.jar /app/library.jar

WORKDIR /app

ENTRYPOINT ["java", "-jar", "library.jar"]
