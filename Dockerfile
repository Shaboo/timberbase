FROM amazoncorretto:11-alpine-jdk AS base
RUN apk add --no-cache nss

WORKDIR /opt/sawmill

ENV JAVA_OPTS ""

COPY ./target/sawmill*.jar sawmill.jar

CMD ["/bin/sh", "-c", "java $JAVA_OPTS -jar sawmill.jar --server.port=8080"]
