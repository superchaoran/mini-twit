# Mini - Twit Example

## Website
http://bidlol.com:8080/twit

## Prerequisites
- JDK 1.8 or later
- Maven 3 or later
- MySQL 5.6 or later

## Stack
- Spring MVC
- Spring Security
- Spring Data JPA
- Maven
- JSP
- JPA
- MySQL
- Hibernate

## Run
- Build on tomcat 

## Remote mysql setup (root cannot be allowed always, must creat new user)
https://stackoverflow.com/questions/15663001/remote-connections-mysql-ubuntu

https://www.digitalocean.com/community/questions/how-to-connect-to-mysql-remotely


sudo vim /etc/mysql/mysql.conf.d/mysqld.cnf
change binding address

Add few points on top of apesa's excellent post:

1) You can use command below to check the ip address mysql server is listening

netstat -nlt | grep 3306

sample result:

tcp 0  0  xxx.xxx.xxx.xxx:3306  0.0.0.0:*   LISTEN
2) Use FLUSH PRIVILEGES to force grant tables to be loaded if for some reason the changes not take effective immediately

GRANT ALL ON *.* TO 'user'@'localhost' IDENTIFIED BY 'passwd' WITH GRANT OPTION;
GRANT ALL ON *.* TO 'user'@'%' IDENTIFIED BY 'passwd' WITH GRANT OPTION;
FLUSH PRIVILEGES; 
EXIT;
3) If netfilter firewall is enabled (sudo ufw enable) on mysql server machine, do the following to open port 3306 for remote access:

sudo ufw allow 3306
check status using

sudo ufw status
4) Once a remote connection is established, it can be verified in either client or server machine using commands

netstat -an | grep 3306
netstat -an | grep -i established
