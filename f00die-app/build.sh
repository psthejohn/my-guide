#!/bin/bash

cd Server
source ./env-variable.sh
mvn clean package
cd ..
