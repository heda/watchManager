# Watch Manager
## Install
mvn install
## Run
mvn spring-boot:run
## Kill tomcat server on mac os  
netstat -vanp tcp | grep 8080  
kill -9 PID  
## Start and stop postgres on mac os
./pgc start  
./pgc stop