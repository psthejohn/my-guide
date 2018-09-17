## Description:
    A simple spring boot Hello World running in a docker with a simple endpoint that return "Hi Service is up now".
### Things must be installed in your system for running this appliccation:
    java
    maven
    docker
## Setup and Configuration:
Go to the root directory and build the application by command:

    mvn clean compile package
It will clean the target package and then will compile the complete code and then will build the new jar
To start the application on local port 8080

    mvn spring-boot:run
open browser and type

    localhost:8080 
to access the application.

## using docker building the app and running:
Build the docker image with
    
    docker build -t spring-boot-image .
Where -t is for a tty session and dot in the last stands for the current working folder
verify image build by
    
    docker image ls
Now start the docker container by 

    docker run -p 8080:8080 spring-boot-image
And you can access the application on
    
    localhost:8080
To provide the container some name use
    
    docker run -p 8080:8080 --name spring-container spring-boot-image
