# Getting Started

### 
For further reference, please consider the following steps:

For prepare the enviroment:

* Download apache TomCat v9.0
	* After link the this project to tomcat serve, please include on "Modules" the "Path" /zed
	
* Before start the application, Install Oracle Db 11g if you don't have one;

* Change the configs at the archive "application.properties" on this project (\zed\src\main\resources);
	* You will need Host/port/Service Name/User(Owner Schema)/Pass;

* For next step do you will need to create the tables on your enviroment;
	* Open the archive "zed.sql" on this project (\zed\src\main\resources);
	* Execute the DDL command for create the tables and yours constraints;

For execute the application:
* Start your Tomcat Server
* Go to your browser and enter on page "http://localhost:8080/zed/"
* Before check the services to find, create on application, please execute the service "getJson" loadJson, this service will be load the pdv.json to the base;

Thanks for opportunite
Rodolfo Zonta