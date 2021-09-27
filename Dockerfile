FROM java:8u111-jdk

ADD http://github.com/demogitjava/demodatabase/raw/master/demodb.mv.db /root/demodb.mv.db
ADD http://github.com/demogitjava/demodatabase/raw/master/mawi.mv.db /root/mawi.mv.db
ADD http://github.com/demogitjava/demodatabase/raw/master/shopdb.mv.db /root/shopdb.mv.db

COPY target/Lanserver.jar lanserver.jar

EXPOSE 8443
ENTRYPOINT ["java", "-jar", "lanserver.jar"]
