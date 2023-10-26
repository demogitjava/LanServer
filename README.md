Demo Lanserver
============================================================


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
** Graal VM **
GraalVM
https://github.com/graalvm/graalvm-ce-builds/releases/tag/vm-21.3.0

----------------------------------------------



**For Docker** 

To build the image type:

`docker build -f Dockerfile -t demolanserver .`

and you create a docker image with ***CentOS*** 
runs in a container over port 8443.






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

