# poc-spring-graphql
This is the repository for the example of using Spring Boot, GraphQL and GraphiQL 


## Requirements to build this project

1.    Java 8
2.    Maven

## Requirements to run the examples

#### Setup the poc-spring-graphql repo

Clone or fork the repo
```
     git clone https://github.com/francois-poirier/poc-spring-graphql.git
     cd poc-spring-graphql
     mvnw spring-boot:run
```
```
You can go to http://localhost:8080/h2-console/login.jsp and enter the following information:

JDBC URL: jdbc:h2:mem:testdb
User Name: sa
Password:
```
```
Start excuting queries in http://localhost:8080/graphiql

![alt tag](https://github.com/francois-poirier/poc-spring-graphql/blob/master/screenshots/findAllAlbums.png)

OR

![alt tag](https://github.com/francois-poirier/poc-spring-graphql/blob/master/screenshots/newAlbum.png)

