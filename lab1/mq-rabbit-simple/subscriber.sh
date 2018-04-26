export HOME="/home/ryan/Dropbox/CMPE275/lab1/mq-rabbit-simple"

JAVA_MAIN='gash.mq.rabbit.demo.SubscribeApp '$1

java -cp .:${HOME}/lib/'*':${HOME}/classes ${JAVA_MAIN}
