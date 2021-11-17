
Demo Lanserver
============================================================

this is a demolanserver application to 
run rest-services behind a router.


use ApacheNetBeans IDE


install the h2 database

http://www.h2database.com/html/download.html
an start the server h2.bat under windows.




To run the application over maven from source type

`mvn spring-boot:run`


make sure that maven is installed if you want to make a compile.

maven
https://downloads.apache.org/maven/maven-3/3.8.2/binaries/apache-maven-3.8.2-bin.zip

java 

Open JDK
https://openjdk.java.net/

or

SAPMaschine
https://sap.github.io/SapMachine/

BellSoft
https://bell-sw.com/pages/downloads/



To run the server over docker type

`docker build -f Dockerfile -t demolanserver .`

and you create a docker image with the latest openjdk version
runs in a container over port 8443

docker for windows are avalable on
https://www.docker.com/products/docker-desktop





