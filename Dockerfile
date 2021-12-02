FROM ghcr.io/graalvm/graalvm-ce:latest


ADD http://github.com/demogitjava/demodatabase/raw/master/demodb.mv.db /root/demodb.mv.db
ADD http://github.com/demogitjava/demodatabase/raw/master/mawi.mv.db /root/mawi.mv.db
ADD http://github.com/demogitjava/demodatabase/raw/master/shopdb.mv.db /root/shopdb.mv.db

ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005

COPY target/Lanserver.jar lanserver.jar

EXPOSE 8443/tcp
EXPOSE 5005/tcp


ENTRYPOINT ["java", "-jar", "lanserver.jar"]