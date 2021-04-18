FROM maven:3.6.3-jdk-8slim as stage1
WORKDIR /home/app
copy . /home/app
run mvn -f /home/app/pom.xml clean package

From tomcat:8.0.51-jre8-alpine
RUN rm -rf /usr/local/tomcat/webapps/*
copy --from=stage1 /home/app/target/*.war /usr/local/tomcat/webapps/ROOT.war
CMD ["catalina.sh","run"]