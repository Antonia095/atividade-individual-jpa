FROM maven:3.8.3-openjdk-11 AS build

COPY pom.xml /app/

COPY src /app/src

RUN mvn -f /app/pom.xml clean package

FROM openjdk:11

COPY --from=build /app/target/atividade-jpa-1.0-SNAPSHOT.jar /app/atividade-jpa.jar

ENTRYPOINT ["java","-Dserver.port=$PORT","-Xmx268M","-Xss512K","-XX:CICompilerCount=2","-Dfile.encoding=UTF-8","-XX:+UseContainerSupport","-Djava.security.egd=file:/dev/./urandom","-Xlog:gc","-jar","/app/atividade-jpa.jar"]