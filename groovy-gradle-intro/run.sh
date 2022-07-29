#!/bin/zsh

# Compile and Run Groovy through a traditional main(..) method. Forward shell arguments to Groovy app.
docker run --rm -v `pwd`/app/src/main/groovy/groovy/gradle/intro:/home/groovy/scripts -w /home/groovy/scripts groovy:4.0-jdk18-alpine groovy App.groovy $@
