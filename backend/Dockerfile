#
# Build stage
#
FROM maven:3.8.4-openjdk-17-slim AS BUILD
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

#
# Package stage
#
FROM openjdk:17-slim
COPY --from=BUILD /home/app/target/backend-1.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]