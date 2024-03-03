FROM eclipse-temurin:17-focal

WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src

CMD ["./mvnw", "spring-boot:run"]