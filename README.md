Instructions
-
1. [Download](http://www.oracle.com/technetwork/java/javase/downloads/index.html) and install the Java 8 sdk
2. Set the ['JAVA_HOME'](https://docs.oracle.com/cd/E19509-01/820-3208/inst_cli_jdk_javahome_t/) environmental variable on your system to point to your Java 8 sdk
3. [Download](https://maven.apache.org/download.cgi) Maven 3.3.9 source zip archive
4. To complete the Maven setup please follow steps 4-7 of this [guide](http://www.tutorialspoint.com/maven/maven_environment_setup.htm)
5. [Download & Install](https://www.postgresql.org/download/) PostgresSQL
6. To setup up PostgresSQL
	* On Linux systems follow this [guide](http://www.techrepublic.com/blog/diy-it-guy/diy-a-postgresql-database-server-setup-anyone-can-handle/) do not complete step 5.
		* For Step 3 please change the password to 'password' instead of 'postgres'
		* For Step 4 instead of 'CREATE DATABASE testdb;' type 'CREATE DATABASE StockMarket;'
	* On Windows follow this [guide](http://blog.mclaughlinsoftware.com/2014/03/02/postgresql-install-windows/)
		* For Step 6 please change the password to 'password'
		* Once the guide has been completed and your connected to the PostgresSQL command line run 'CREATE DATABASE StockMarket;'
8. Download and unzip this project
9. Open a command prompt navigate to this projects pom.xml
10. Type "mvn spring-boot:run"
11. Go to localhost:8090
12. For swagger got to localhost:8090/swagger-ui.html
13. You can change the projects database settings in the application.properties under src/main/resources