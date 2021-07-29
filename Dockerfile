FROM java:openjdk-8u111-jre-alpine

ADD http://github.com/demogitjava/demodatabase/raw/master/demodb.mv.db /root/demodb.mv.db
ADD http://github.com/demogitjava/demodatabase/raw/master/mawi.mv.db /root/mawi.mv.db


COPY target/LanServer-0.0.1-SNAPSHOT.jar lanserver.jar
ENTRYPOINT ["java", "-jar", "/lanserver.jar"]