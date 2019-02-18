### STAGE 1: Build ###
FROM node:8.11.1-alpine 

# Preparing working environment.
RUN mkdir -p /usr/src/
WORKDIR /usr/src/

# Installing dependencies.
COPY package*.json /usr/src/
RUN npm install

# copy all the content to the usr/src folder
COPY . /usr/src/

# Building app. , we can use npm run-script --prod also
RUN npm build --prod

### STAGE 2: Setup ###

FROM nginx:1.13.12-alpine

# checking the content 
RUN ls /usr/share/nginx/html/
# Removing nginx default page.
RUN rm -rf /usr/share/nginx/html/*

# Copying nginx configuration.
COPY /nginx/nginx.conf /etc/nginx/conf.d/default.conf
 
# to copy all the contents of the dist/app-name/ folder to the doker folder
COPY /dist/angular-nginx-docker-demo/ /usr/share/nginx/html/

# to verify the contents of the docker folder
RUN ls /usr/share/nginx/html/

# Expose the port to bind with the system port.
EXPOSE 8085

# Starting server.
CMD ["nginx", "-g", "daemon off;"]
