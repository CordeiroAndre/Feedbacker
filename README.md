<h1 align="center">Feedbacker</h1>
Feedbacker is a simple API designed for independent teachers and educational institutions to provide feedback to their underage students through a gamified experience.

After each class, the teacher rates the student with 1 to 5 stars in three categories: behavior, engagement, and difficulty. The total number of stars accumulated can then be exchanged by the students for rewards or prizes, creating a fun and motivating feedback loop.

In addition to recording the feedback, the system also automatically logs the student's attendance for that session.



## Stack 
Spring Boot Framework with Java 21: 
- Spring Framework
- JPA and Hibernate
- Maven

## Models
![image](https://github.com/CordeiroAndre/Feedbacker/blob/main/Diagrams/ER%20Diagram.png)


## How to test it? 

All you need to do is setup your spring boot configuration: 

- spring.application.name=feedbacker
- spring.jpa.properties.hibernate.dialect = <org.hibernate.dialect.DBMS>
- spring.datasource.username= <MyDatabaseUsername>
- spring.datasource.password= <MyDatabasePassword>
- spring.datasource.url= <MyDatabaseURL>
- spring.jpa.hibernate.ddl-auto= update

After that, run the command: _*mvn spring-boot:run*_
