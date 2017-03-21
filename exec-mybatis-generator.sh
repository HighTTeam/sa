#!/bin/bash 

JDBC_DRIVER=com.mysql.jdbc.Driver
JDBC_USERNAME=root
JDBC_PASSWORD=rootroot
JDBC_URL=jdbc:mysql://mysql-server:3306/sa?autoReconnect=true&characterEncoding=utf8

mvn -Dmybatis.generator.jdbcDriver=$JDBC_DRIVER \
    -Dmybatis.generator.jdbcUserId=$JDBC_USERNAME \
    -Dmybatis.generator.jdbcPassword=$JDBC_PASSWORD \
    -Dmybatis.generator.jdbcURL=$JDBC_URL \
    -Dmybatis.generator.overwrite=true \
    mybatis-generator:generate
