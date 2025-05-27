# Feedbacker
Feedbacker is a simple API for independent teachers and institutions to feedback their underage students in a gamefied experience. 
The idea resides in, after each class, the teacher give 1 to 5 starts in three categories: behaviuour, engagement, and difficulty. The sum of these stars can be exchanged by the children for prizes. 


## Stack 
Spring Boot Framework with Java 21: 
- Spring Framework
- JPA and Hibernate
- Maven

## Models
![image](https://github.com/CordeiroAndre/Feedbacker/blob/main/Diagrams/ER%20Diagram.svg)


## How to test it? 

All you need to do is setup your spring boot configuration: 

spring.application.name=feedbacker
spring.jpa.properties.hibernate.dialect = <org.hibernate.dialect.MySGBD>
spring.datasource.username= <MyDatabaseUsername>
spring.datasource.password= <MyDatabasePassword>
spring.datasource.url= <MyDatabaseURL>
spring.jpa.hibernate.ddl-auto= update


