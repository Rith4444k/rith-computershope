# rith-computershope
<<<<<<< HEAD
# Build for demo

#  Rith Computer Shop Management System

A RESTful API project for managing computer shop operations, developed using Java and Spring Boot.

##  About The Project

Rith Computer Shop Management System is a backend development project focused on building RESTful APIs, database management, and clean backend architecture.

This project is currently under development.

##  Tech Stack

- **Language:** Java 25
- **Framework:** Spring Boot
- **ORM:** Spring Data JPA
- **Database:** PostgreSQL,H2 Database for Test
- **Database Migration:** Liquibase
- **Build Tool:** Maven
- **API Documentation:** Swagger / OpenAPI
- **Version Control:** Git & GitHub

##  Features

- RESTful API development
- Brand management (CRUD operations)
- Pagination and filtering
- Dynamic searching using JPA Specifications
- DTO and Entity mapping
- Global exception handling
- PostgreSQL database integration
- Database migration with Liquibase
- API documentation with Swagger
- More Features Planed
- ....................
##  Project Structure

```text
rith-computershope/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.rith.java.developer.rith_computershope/
│   │   │       ├── config/
│   │   │       ├── controller/
│   │   │       ├── dto/
│   │   │       ├── entity/
│   │   │       ├── exception/
│   │   │       ├── mapper/
│   │   │       ├── repository/
│   │   │       ├── service/
│   │   │       ├── service.impl/
│   │   │       ├── service.util/
│   │   │       ├── specification/
│   │   │       └── utils/
│   │   │
│   │   └── resources/
│   │
│   └── test/
│       ├── java/
│       └── resources/
│
├── pom.xml
└── README.md
```

## ⚙ Getting Started

### Prerequisites

- JDK 25
- Maven
- PostgreSQL
- Git

### 1. Clone Repository

```bash
git clone https://github.com/rith-dev-404/rith-computershope.git
```

### 2. Configure Database

Configure your PostgreSQL connection in `application.properties`:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 3. Run Application

```bash
mvn spring-boot:run
```

Application URL:

```text
http://localhost:8080
```

##  API Documentation

After starting the application, access Swagger UI:

```text
http://localhost:8080/swagger-ui/index.html
```

##  Testing

Run unit tests using Maven:

```bash
mvn test
```

##  Author

**Rith**
**k.rith913158@gmail.com**

Junior Backend Developer | Computer Science Graduate

- GitHub: https://github.com/rith-dev-404

---

 This project is currently under development. More features and improvements are coming soon.

=======
Build for demo
>>>>>>> main
