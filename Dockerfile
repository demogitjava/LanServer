FROM java:openjdk-9-jre

ADD http://github.com/demogitjava/demodatabase/raw/master/demodb.mv.db /root/demodb.mv.db
ADD http://github.com/demogitjava/demodatabase/raw/master/mawi.mv.db /root/mawi.mv.db


COPY target/LanServer-0.0.1-SNAPSHOT.jar lanserver.jar
EXPOSE 8443
ENTRYPOINT ["java", "-jar", "/lanserver.jar"]