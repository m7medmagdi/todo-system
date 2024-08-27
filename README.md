# Todo System

## Overview

The Todo System is a web application designed to manage tasks and to-do items. It provides a RESTful API for creating, reading, updating, and deleting to-dos. This application uses Spring Boot for the backend, Spring Data JPA for ORM (Object-Relational Mapping), ModelMapper for DTO mapping, and MySQL for data persistence.

## Features

- **Create**: Add new to-do items.
- **Read**: Retrieve to-do items by ID or list all to-do items.
- **Update**: Modify existing to-do items.
- **Delete**: Remove to-do items.

## Technology Stack

- **Spring Boot**: Framework for building the backend REST API.
- **Spring Data JPA**: For database interactions and ORM (Object-Relational Mapping).
- **ModelMapper**: Library for mapping between DTOs and entities.
- **MySQL**: Relational database for data persistence.
- **Lombok**: Library to reduce boilerplate code (e.g., getters, setters, constructors).


## Dependencies

The following libraries and frameworks are used in this project:

- **Spring Boot**
- **Spring Data JPA**
- **MySQL Connector**
- **ModelMapper**
- **Lombok**


## Installation

### Prerequisites

- Java 11 or higher
- MySQL Server
- Maven or Gradle

### Update Application Properties

Configure the `application.properties` or `application.yml` file in the `src/main/resources` directory with your MySQL database details.

**`application.properties`:**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=your_mysql_username
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
