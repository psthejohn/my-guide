# AngularNginxDockerDemo

with a single dockerfile we can dockerize the angular.

steps:

    create a dockerfile.
    copy content

    create a folder named as nginx
    inside it put the nginx.conf file.

command to build the image :

    docker build -t angular-nginx-image .

command to build the docker container :

    docker run -d -p 8085:8085 --name angular-nginx-container angular-nginx-image

we can then verify the running application on

    localhost:8085
