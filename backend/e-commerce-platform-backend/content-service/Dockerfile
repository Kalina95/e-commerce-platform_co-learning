FROM eclipse-temurin:17-focal

WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
COPY assets/ assets
RUN ./mvnw dependency:go-offline
COPY src ./src

CMD ["./mvnw", "spring-boot:run"]