FROM openjdk:17

WORKDIR /app
COPY . /app

RUN chmod +x gradlew
RUN ./gradlew clean build
RUN cp $(ls build/libs/*.jar | grep -v "plain") app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]