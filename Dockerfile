FROM gcr.io/distroless/java
COPY target/laundryussd-0.0.1-SNAPSHOT.jar /app/app.jar
EXPOSE 8087
ENTRYPOINT ["java","-jar","/app/app.jar"]
