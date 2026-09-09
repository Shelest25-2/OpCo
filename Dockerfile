FROM ...
WORKDIR app/
COPY .mvn/ .mvn/
COPY .pom.xml .

RUN mvn package -DskipTest -B

FROM eclipse-temurin:21-jre-jammy

COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar"," app.jar"]