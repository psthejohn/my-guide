FROM java:8-jre
WORKDIR usr/src
#ENV MYSQL_DATABASE=foodiedb
#ENV MYSQL_USER=app_root
#ENV MYSQL_PASSWORD=root123
#ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/foodiedb
ADD ./target/foodie-api-1.0.0.jar /usr/src/foodie-api-1.0.0.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar", "/usr/src/foodie-api-1.0.0.jar"]