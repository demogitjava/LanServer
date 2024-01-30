FROM alpine:edge



RUN apk add openjdk11

# install data to set time 
# to germany
RUN apk add tzdata
RUN ln -s /usr/share/zoneinfo/Europe/Berlin /etc/localtime



# locale to german
ENV LANG=de_DE.ISO-8859-1
ENV LANGUAGE de_DE:de
ENV LC_ALL de_DE.ISO-8859-1

ENV TZ Europe/Berlin



# h2 default port
EXPOSE 8082
EXPOSE 9092

# lan server port 
EXPOSE 8443



ADD target/Lanserver.jar /root/demolanserver.jar
ENTRYPOINT ["java", "-jar", "/root/demolanserver.jar"]




