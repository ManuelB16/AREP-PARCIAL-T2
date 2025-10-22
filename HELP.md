Comandos mvn clean package

set PORT=4567 java -cp target/searchapp-1.0-SNAPSHOT-jar-with-dependencies.jar edu.escuelaing.arep.searchapp.SearchService

set PORT=4568 java -cp target/searchapp-1.0-SNAPSHOT-jar-with-dependencies.jar edu.escuelaing.arep.searchapp.SearchService

set BACKEND1=http://localhost:4567 set BACKEND2=http://localhost:4568 set PORT=8080 java -cp target/searchapp-1.0-SNAPSHOT-jar-with-dependencies.jar edu.escuelaing.arep.searchapp.ProxyService

mvn archetype:generate -DgroupId=edu.escuelaing.arep.searchapp -DartifactId=searchapp -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false