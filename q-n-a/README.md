q-n-a

This application allows you to ask questions and give comments about the topics that are present.


To Start the application:

Short way:
1.Open terminal inside qnaV1-java-boilerplate/ and run this command
`sudo docker-compose up`
2.Open browser with url http://localhost:8080/ and your application is ready to use


Long way:

1. Download the application from this git repository
2. Open MySql and create a database qnadb. (create database qnadb;)
2. Go to the path q-n-a/Server/AuthenticationService and open the terminal and type souce ./env-variable.sh
3. Type the command 'mvn spring-boot:run' and the authentication application will start.
4. Go to the path q-n-a/Server/qnaService and open the terminal and type souce ./env-variable.sh
5. Type the command 'mvn spring-boot:run' and the q-n-a service application will start.
6. Go to the folder q-n-a and open the terminal and type ng serve and the angular application will start.
7. Open your browser with url http://localhost:4200 to launch the application

Note:
Once registered and Logged in successfully, the Topic page will be displayed. Add any 5 topics and its description of your wish.
Once added you can disable the adding Topic option by correcting the following html document.

q-n-a/src/app/modules/qna/components/topicthumbnailcomponent.html
