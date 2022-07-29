#!/bin/zsh

# Compile and Run Groovy Script. Forward shell arguments to Groovy app.
# The groovy script gets compiled into a class with a main method.
docker run --rm -v `pwd`/app/src/main/groovy/groovy/gradle/intro:/home/groovy/scripts -w /home/groovy/scripts groovy:4.0-jdk18-alpine groovy AppScript.groovy $@
