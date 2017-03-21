#!/bin/bash 

if [ ! -d generated ]; then
    mkdir generated
fi
mvn -Dmybatis.generator.overwrite=true mybatis-generator:generate
