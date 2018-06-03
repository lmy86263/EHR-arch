#!/bin/sh
dir=$(dirname "$0")
java -cp "$dir/ehr-persistence-0.0.1-SNAPSHOT-jar-with-dependencies.jar:$CLASSPATH" com.zju.edu.PersistenceApp
