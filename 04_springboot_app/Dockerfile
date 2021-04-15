# Build a JAR File
FROM maven:3.6.3-jdk-8-slim AS stage1
WORKDIR /home/app
COPY . /home/app/
RUN mvn -f /home/app/pom.xml clean package

From tomcat:8.0.51-jre8-alpine
RUN rm -rf /usr/local/tomcat/webapps/*
COPY --from=stage1 /home/app/target/*.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh","run"]

# Create an Image
#FROM openjdk:8-jdk-alpine
#EXPOSE 8080
#COPY --from=stage1 /home/app/target/todo-web-application-mysql.jar todo-web-application-mysql.jar
#ENTRYPOINT ["sh", "-c", "java -jar /todo-web-application-mysql.jar"]
