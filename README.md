Demo Lanserver
============================================================



this is a demolanserver application to 
run rest-services behind a router.



Used IDE is Apache Netbeans

https://netbeans.apache.org/download/nb125/nb125.html






install the h2 database

http://www.h2database.com/html/download.html
an start the server h2.bat under windows.



used databases:

https://github.com/demogitjava/demodatabase

- demodb.mv.db
- mawi.mv.db





To run the application over maven from source type

`mvn spring-boot:run`


make sure that maven is installed if you want to make a compile.

maven
https://downloads.apache.org/maven/maven-3/3.8.2/binaries/apache-maven-3.8.2-bin.zip



Java 

Java JDK

GraalVM

https://github.com/graalvm/graalvm-ce-builds/releases/tag/vm-21.3.0

or

https://openjdk.java.net/

or

SAPMaschine
https://sap.github.io/SapMachine/

BellSoft
https://bell-sw.com/pages/downloads/



**For Docker** 

To build the image with graalvm type:

`docker build -f Dockerfile -t demolanserver .`

and you create a docker image with ***Arch Linux*** 
runs in a container over port 8443.









Run the application and open ports by create a new container

8443

9092

5005 (optional for debug)





docker for windows are available on
https://www.docker.com/products/docker-desktop





