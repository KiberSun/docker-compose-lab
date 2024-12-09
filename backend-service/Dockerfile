FROM openjdk:21
COPY . /usr/src/myapp
WORKDIR /usr/src/myapp
EXPOSE 8080

RUN microdnf install findutils

ENTRYPOINT ["./gradlew", "run"]