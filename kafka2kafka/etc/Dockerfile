FROM alpine:stable
MAINTAINER Team FRAK IT

ENV JAVA_TOOL_OPTIONS="-Dfile.encoding=UTF-8 -XX:MinRAMPercentage=60.0 -XX:MaxRAMPercentage=90.0"

WORKDIR /app
EXPOSE 8080

ADD build/libs/kafka2kafka-all*.jar /app/kafka2kafka.jar
CMD java -noverify ${JAVA_OPTS} -jar /app/kafka2kafka.jar