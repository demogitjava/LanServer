
FROM imglanserver:latest
#FROM jgsoftwares/jgsoftwares:linuxgraalvmce
#FROM jgsoftwares/jgsoftwares:i386ubuntuopenjdk

# locale to german
ENV LANG=de_DE.ISO-8859-1
ENV LANGUAGE de_DE:de
ENV LC_ALL de_DE.ISO-8859-1


ADD https://github.com/demogitjava/demodatabase/raw/master/demodb.mv.db /root/demodb.mv.db
ADD https://github.com/demogitjava/demodatabase/raw/master/mawi.mv.db /root/mawi.mv.db
ADD https://github.com/demogitjava/demodatabase/raw/master/shopdb.mv.db /root/shopdb.mv.db

#ADD https://raw.githubusercontent.com/demogitjava/demodatabase/master/ddclient.conf /etc/ddclient.conf

# add jar to maschine
# dropbox client
#ADD https://github.com/demogitjava/demodatabase/raw/master/Dropboxclient.jar /root/applib/dropboxclient.jar

#ENV JAVA_TOOL_OPTIONS -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005
#COPY target/Lanserver.jar lanserver.jar

#ENTRYPOINT ["java", "-jar", "lanserver.jar"]