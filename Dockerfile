FROM openjdk:8u222-jdk

ADD http://github.com/demogitjava/demodatabase/raw/master/demodb.mv.db /root/demodb.mv.db
ADD http://github.com/demogitjava/demodatabase/raw/master/mawi.mv.db /root/mawi.mv.db
ADD http://github.com/demogitjava/demodatabase/raw/master/shopdb.mv.db /root/shopdb.mv.db

ADD http://github.com/demogitjava/demodatabase/raw/master/h2/bin/h2-1.4.199.jar /root/h2.jar

COPY target/Lanserver.jar lanserver.jar

EXPOSE 8443


ENTRYPOINT ["java", "-jar", "lanserver.jar"]



