FROM node:8.9.4
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY dist /usr/src/app/dist
COPY . /usr/src/app/
COPY package.json /usr/src/app/package.json
COPY webpack.config.js /usr/src/app/webpack.config.js
RUN npm install webpack
RUN npm install webpack-dev-server
RUN npm install webpack-cli
RUN npm install html-webpack-plugin
RUN npm install uglifyjs-webpack-plugin
expose 4200
CMD ["yarn", "start"]