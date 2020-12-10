FROM amazoncorretto:8
VOLUME /tmp
COPY ./build/libs/darksideoftherainbow-0.1.0.jar app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]