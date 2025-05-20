FROM maven:3.9.9-amazoncorretto-21-alpine as build

WORKDIR /app
COPY pom.xml .

RUN mvn de.qaware.maven:go-offline-maven-plugin:resolve-dependencies

COPY src .
RUN mvn -o --file pom.xml package -DskipTests -B

FROM amazoncorretto:21-alpine

# Copy the jar from the build stage
COPY --from=build /app/target/*.jar /app/app.jar

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

