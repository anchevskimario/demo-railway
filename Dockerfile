FROM maven:3.9.9-amazoncorretto-11-alpine AS build

WORKDIR /app
COPY pom.xml .

RUN mvn de.qaware.maven:go-offline-maven-plugin:resolve-dependencies

COPY src src

RUN mvn -o --file pom.xml package -DskipTests -B
RUN java -Djarmode=layertools -jar ./target/*.jar extract

FROM amazoncorretto:11-alpine3.21-jdk
COPY --from=build /app/dependencies ./
COPY --from=build /app/spring-boot-loader ./
COPY --from=build /app/snapshot-dependencies ./
COPY --from=build /app/application ./

ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
