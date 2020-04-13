# Customer Order NoSQL Demo with Spring Boot, MongoDB, JPA, REST API

## Steps to Setup

**1. Clone the repository**

```bash
git clone https://github.com/481833/CustomerOrderNoSQL.git
```

**2. Configure MongoDB**

First, create a database named `customerorderdb`. Then, open `src/main/resources/application.properties` file and change the spring datasource username and password as per your MongoDB installation.

**3. Run the app**

Type the following command from the root directory of the project to run it -

```bash
mvn spring-boot:run
```

Alternatively, you can package the application in the form of a JAR file and then run it like so -

```bash
mvn clean package
java -jar target/CustomerOrderNoSQL-0.0.1-SNAPSHOT.jar
```
