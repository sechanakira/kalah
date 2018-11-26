# kalah
6-Stone Kalah Implementation

Requirements:

1. Java SE8.
2. Maven.

Frameworks used:

1. Spring Boot.
2. Spring Data JPA for persistence.
3. Lombok for generating getters and setters.

Database:

1. H2 In memory DB.

Host:

The project will run on localhost.

Port:

The project will run on port 8080.

Setup:

1. Compile Project with mvn clean install
2. Run project with java -jar /{path-to-project}/target/kalah-0.0.1-SNAPSHOT.jar

Changing port:

1. To change port, add server.port=YOUR_PREFERRED_PORT in application.properties

Changing Context Path:

The default context path is ''. To set a context path, set the following property in application.properties:
server.servlet.context-path=YOUR_CONTEXT_PATH

Changing Database:

To change the database from H2, add your database driver dependency and the relevant Spring Boot Starter dependency to your pom and set the relevant properties in application.properties.

