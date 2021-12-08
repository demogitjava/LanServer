FROM ghcr.io/graalvm/native-image:latest
#FROM ghcr.io/graalvm/graalvm-ce:latest

USER root

# locale to german
ENV LANG=de_DE.UTF-8
ENV LANGUAGE de_DE:de
ENV LC_ALL de_DE.UTF-8

ADD http://github.com/demogitjava/demodatabase/raw/master/demodb.mv.db /root/demodb.mv.db
ADD http://github.com/demogitjava/demodatabase/raw/master/mawi.mv.db /root/mawi.mv.db
ADD http://github.com/demogitjava/demodatabase/raw/master/shopdb.mv.db /root/shopdb.mv.db

ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005

COPY target/Lanserver.jar lanserver.jar


ENTRYPOINT ["java", "-jar", "lanserver.jar"]