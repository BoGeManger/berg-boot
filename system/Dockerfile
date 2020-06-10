FROM java:8
VOLUME /tmp
RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime
RUN echo "Asia/Shanghai" > /etc/timezone
COPY target/system-1.0.0-SNAPSHOT.jar system.jar
RUN bash -c "touch /system.jar"
EXPOSE 43000
ENV w=1 d=0
ENTRYPOINT ["java","-Xms256m","-Xmx256m","-jar","system.jar","--snowflake.id.worker.workerId=${w}","--snowflake.id.worker.datacenterId=${d}"]