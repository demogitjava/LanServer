#
#
#      web config 
#     
#      war - file

FROM jgsoftwares/graalce11
#FROM jgsoftwares/jgsoftwares:i386ubuntuopenjdk

# locale to german
ENV LANG=de_DE.ISO-8859-1
ENV LANGUAGE de_DE:de
ENV LC_ALL de_DE.ISO-8859-1

ENV TZ Europe/Berlin

# lan-server
EXPOSE 8443

# h2 console
EXPOSE 8082

ADD h2/demodb.mv.db /root/demodb.mv.db
ADD h2/mawi.mv.db /root/mawi.mv.db
ADD h2/shopdb.mv.db /root/shopdb.mv.db

#ADD https://raw.githubusercontent.com/demogitjava/demodatabase/master/ddclient.conf /etc/ddclient.conf

# add jar to maschine
# dropbox client
#ADD https://github.com/demogitjava/demodatabase/raw/master/Dropboxclient.jar /root/applib/dropboxclient.jar

#ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005
#COPY target/Lanserver.jar lanserver.jar
ADD target/Lanserver.jar /root/demolanserver.jar
ENTRYPOINT ["java", "-jar", "/root/demolanserver.jar"]
