FROM bellsoft/liberica-openjdk-alpine:23.0.1-cds

RUN apk add curl jq

WORKDIR /home/docker-practice

ADD target/docker-resources ./
ADD runner.sh				runner.sh

RUN dos2unix runner.sh

ENTRYPOINT sh runner.sh	   