FROM maven:3.8-openjdk-8-slim as builder
WORKDIR /app
COPY . .
RUN mvn package

FROM tomcat:8.0.51-jre8-alpine
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=builder /app/target/*.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh","run"]