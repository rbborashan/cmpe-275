#!/bin/bash
#
#

export HOME="/home/ryan/Dropbox/CMPE275/lab1/mq-rabbit-simple"

JAVA_MAIN='app.HelloDemo'

java -cp .:${HOME}/lib/'*':${HOME}/classes ${JAVA_MAIN}
#java -cp .:${HOME}/lib/'*':${HOME}/classes ${JAVA_MAIN}
