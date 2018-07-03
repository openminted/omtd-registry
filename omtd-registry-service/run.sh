# compile project and pack as war 
mvn package -DskipTests

# Undeploy previous version
echo "Undeploy previous version"
curl "http://test:test@localhost:8080/manager/text/undeploy?path=/omtd-registry"

#../../InstalledTools/apache-tomcat-8.0.45/bin/shutdown.sh
#cp target/omtd-registry.war ../../InstalledTools/apache-tomcat-8.0.45/webapps/omtd-registry.war
#../../InstalledTools/apache-tomcat-8.0.45/bin/startup.sh

# Deploy new version 
echo "Deploy new version"
curl --upload-file target/omtd-registry.war    "http://test:test@localhost:8080/manager/text/deploy?path=/omtd-registry" 

