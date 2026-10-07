#!/bin/sh
if [ ! -f "gradle-wrapper.jar" ]; then
  curl -sL -o gradle-wrapper.jar https://github.com/gradle/gradle/raw/v8.2.0/gradle/wrapper/gradle-wrapper.jar
fi
java -jar gradle-wrapper.jar "$@"
