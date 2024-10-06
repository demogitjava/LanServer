Demo Lanserver - Jakarta Persistence
============================================================

used java version
openjdk version "11.0.2" 2019-01-15
OpenJDK Runtime Environment 18.9 (build 11.0.2+9)
OpenJDK 64-Bit Server VM 18.9 (build 11.0.2+9, mixed mode)

the java jdk 
http://demogitjava.ddns.net:8000/Java_JDK/openjdk-11.0.2_linux-x64_bin.tar.gz


`tls is disabled by default the connection`
`is over port http 8843`

install the h2 database

http://www.h2database.com/html/download.html
an start the server h2.bat under windows.


the console is enabled by default

`http://->yourip/8082/`
and you get access to the database
the default password for the h2 database by default ist

admin
jj78mvpr52k1


for more information go to 
`demogitjava.ddns.net`





used databases:

https://github.com/demogitjava/demodatabase

- demodb.mv.db
- mawi.mv.db

                

To run the application over maven from source type

`mvn spring-boot:run`

or

`mvn spring-boot:build-image`

for a native spring boot build jar on the target folder.

If you get an compile error from jar use recompile with -> `use classpath of module`


make sure that maven is installed if you want to make a compile.

maven
https://downloads.apache.org/maven/maven-3/3.8.2/binaries/apache-maven-3.8.2-bin.zip



start H2 console
download form here and start the h2 jar with
http://www.h2database.com/html/download.html

'java -cp h2.jar org.h2.tools.Console -webAllowOthers'





Java 

Java JDK
----------------------------------------------

used jdk:
** OpenJDK 11 **
http://demogitjava.ddns.net:8000/Java_JDK/oracleopenjdk-11.0.2_linux-x64_bin.tar.gz

----------------------------------------------



**For Docker** 

To build the image type:

LAN
`docker build -f LanDockerfile -t demolanserverlan .`

WEB
`docker build -f Dockerfile -t demolanserverweb .`

and you create a docker image with ***CentOS*** 
runs in a container over port 8443.



copy jar to container
`docker cp /root/git/LanServer/target/LanServer-0.0.1-SNAPSHOT.jar oraclelinuxlanservertcp:/root` 

access to lanserver container 
`docker exec oraclelinuxlanservertcp /bin/bash`  



Run the application and open ports by create a new container

8443

9092 (ptional for h2 database connect)

5005 (optional for debug)



docker for windows are available on
https://www.docker.com/products/docker-desktop

for config on an docker image make a backup with

`docker save -o jgsoftwares.tar jgsoftwares/jgsoftwares`


to load your image to docker desktop type:
`docker load --input jgsoftwares.tar`

