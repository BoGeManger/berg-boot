#!/bin/bash
#use:sh run.sh name.jar
echo "begin"

pid0=`netstat -nlp | grep -w 20000 | sed -r 's#.* (.*)/.*#\1#'`

echo "kill pid" $pid0
kill -9 $pid0
sleep 1
echo "run 43000" $1
nohup java -jar ./$1 --server.port=43000 --spring.profiles.active=prod --snowflake.id.worker.workerId=1 --snowflake.id.worker.datacenterId=0 >/dev/null 2>&1 &

sleep 1

netstat -nplt
