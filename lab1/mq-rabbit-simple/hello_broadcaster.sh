export HOME="/home/ryan/Dropbox/CMPE275/lab1/mq-rabbit-simple"

JAVA_MAIN='app.BroadcastClient'

java -cp .:${HOME}/lib/'*':${HOME}/classes ${JAVA_MAIN}
