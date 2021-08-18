
Demo Lanserver
============================================================

this is a demolanserver application to 
run rest-services behind a router.

To run the application over maven 

spring:boot:start

make sure tha maven is installed 
and the java path are set.


To run the server over docker type

docker build -f Dockerfile -t lanserver .

and you create a docker image with the latest openjdk version
und it runs in a container over port 8443



