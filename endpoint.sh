#!/bin/bash

echo
echo "# ---------------------- [ $0 Args ] ------------------------- #"
index=1
args=""
for arg in $*
do
  echo "# [$0] arg($index) = $arg #"
  args="$args ${arg}"
  let index+=1
done
echo

export JAVA_OPTS="-Dfile.encoding=UTF-8"
export JMX_OPTS="-Djava.rmi.server.hostname=192.168.100.102 -Dcom.sun.management.jmxremote.port=9010 -Dcom.sun.management.jmxremote.rmi.port=9010 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false"
export DDG_OPTS="-Ddd.service.name=demo -Ddd.integrations.enabled=true -Ddd.trace.analytics.enabled=true -javaagent:/usr/jar/dd-java-agent.jar"

echo "java ${JAVA_OPTS} ${JMX_OPTS} ${DDG_OPTS} -jar ${APP_JAR} ${args}"
echo
java ${JAVA_OPTS} ${JMX_OPTS} ${DDG_OPTS} -jar ${APP_JAR} ${args}
RETURN_CODE=$?
echo
echo "# [$0] java exec result: $RETURN_CODE #"
echo

exit $RETURN_CODE
