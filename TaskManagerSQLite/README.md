/**
 * Copyright 2016 Mohamed Lubani.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

This is a simple Maven web-based task management system rapidly developed using the Spring Roo tool V.1.3.1 RC1 on Spring Tool Suite V.3.7.3.CI-B512. 
The system uses SQLite database and provides the basic CRUD operations. A new database will be created with each run. 
The menu to the left contains options to create and list available tasks in the database. The options to update and/or delete a task are available in the task details view.

To run the source code locally import the project to Spring and make sure all the dependencies are completely downloaded. 
If you have Spring Roo integrated with Spring Tool Suite V.3.x.x, import the project as a general project and then perform Maven Update Project before running on the Tomcat server on http://localhost:8080/TaskManagerSQLite/. 
In case of plugin problems, make sure you have the latest software updates for the IDE. 

===========================================================================================================
Development notes: 
As there is no direct statement in Spring Roo to create SQLite database, first need to create MYSQL database using:
	jpa setup --provider HIBERNATE --database MYSQL --databaseName TasksDB

Then the auto created files need to be changed as follows:
1- Add the following two dependencies to POM.xml file:
		<!-- SQLite Dialect with Hibernate 4 dependencies -->
		<dependency>
			<groupId>com.enigmabridge</groupId>
			<artifactId>hibernate4-sqlite-dialect</artifactId>
			<version>0.1.2</version>
		</dependency>
		<dependency>
			<groupId>org.xerial</groupId>
			<artifactId>sqlite-jdbc</artifactId>
			<version>3.8.11.2</version>
		</dependency>
		
2- In presistence.xml file change the property "hibernate.dialect" to "com.enigmabridge.hibernate.dialect.SQLiteDialect".
3- In database.properties file change the "database.driverClassName" to "org.sqlite.JDBC" and change the database url to "jdbc:sqlite:TasksDB.sqlite".

After the database is created, run the following script in the Roo shell window to create the entity and its fields:
	entity jpa --class ~.Task
	field string --fieldName taskName --notNull --sizeMax 20 --class ~.Task
	field date --fieldName deliveryDate --notNull --class ~.Task --type java.util.Date
	field string --fieldName owner --class ~.Task --notNull --sizeMax 20 
	field string --fieldName taskDescription --notNull --class ~.Task 
	field boolean --fieldName isComplete --notNull  --value false
	web mvc setup
	web mvc all --package ~.web