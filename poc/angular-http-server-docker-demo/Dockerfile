### STAGE 1: Build ###
FROM node:8.11.1-alpine 

# Preparing working environment.
RUN mkdir -p /usr/src/

WORKDIR /usr/src/

### STAGE 2: Setup ###

RUN npm i http-server -g
 
 # make sure you already dist folder is there( npm run build)

# to copy all the contents of the dist/app-name/ folder to the doker folder
COPY /dist/angular-http-server-docker-demo/ /usr/src/

# to verify the contents of the docker folder
RUN ls /usr/src/

# Expose the port to bind with the system port.
EXPOSE 8080

# Starting server.
CMD ["http-server", "/usr/src/"]
