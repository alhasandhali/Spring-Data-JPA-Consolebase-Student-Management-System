# SpringJPA-CRUD

A comprehensive Spring Boot application for managing student records using Spring Data JPA and MySQL database. This project demonstrates CRUD (Create, Read, Update, Delete) operations with a console-based user interface.

## Project Overview

**SpringJPA-CRUD** is a full-featured student management system built with Spring Boot and Spring Data JPA. It provides an interactive command-line interface for performing various operations on student records including adding, updating, searching, and deleting student information.

### Key Features

- **Add Students**: Create new student records with detailed information
- **Update Students**: Modify existing student information
- **Search Students**: Find students by ID with instant results
- **View All Students**: Display all registered students in the database
- **Delete Students**: Remove student records from the database
- **Search by Name**: Find students using their names
- **Search by Email**: Find students using their email addresses
- **Console-Based UI**: Interactive menu-driven command-line interface

## Technology Stack

| Component       | Version                    |
| --------------- | -------------------------- |
| Java            | 17                         |
| Spring Boot     | 4.0.2                      |
| Spring Data JPA | 4.0.2                      |
| MySQL           | Latest (mysql-connector-j) |
| Maven           | 4.0.0                      |
| Lombok          | 1.18.42                    |

## Project Structure

```
SpringJPA-CRUD/
├── src/
│   ├── main/
│   │   ├── java/com/spring/jpa/crud/
│   │   │   ├── SpringJpaCrudApplication.java    # Main application & CLI interface
│   │   │   ├── entity/
│   │   │   │   └── Student.java                 # Student entity model
│   │   │   └── repository/
│   │   │       └── StudentRepository.java       # JPA repository interface
│   │   └── resources/
│   │       └── application.properties           # Spring Boot configuration
│   └── test/
│       └── java/com/spring/jpa/crud/
│           └── SpringJpaCrudApplicationTests.java
├── pom.xml                                      # Maven dependencies
├── mvnw / mvnw.cmd                              # Maven wrapper scripts
└── README.md                                    # Project documentation
```

## Database Schema

### Student Table (`student_jpa`)

| Column       | Type         | Description                             |
| ------------ | ------------ | --------------------------------------- |
| studentID    | VARCHAR(255) | Primary Key - Unique student identifier |
| studentName  | VARCHAR(255) | Full name of the student                |
| studentEmail | VARCHAR(255) | Email address of the student            |
| studentPhone | VARCHAR(255) | Contact phone number                    |
| program      | VARCHAR(255) | Academic program/course                 |
| batch        | INT          | Batch/year of enrollment                |
| password     | VARCHAR(255) | Student password                        |
| dob          | VARCHAR(255) | Date of birth                           |

## Installation & Setup

### Prerequisites

Before you begin, ensure you have the following installed on your system:

- **Java Development Kit (JDK)**: Version 17 or higher
  - [Download JDK](https://www.oracle.com/java/technologies/downloads/#java17)
- **MySQL Server**: Version 5.7 or higher
  - [Download MySQL](https://dev.mysql.com/downloads/mysql/)
- **Maven**: Version 3.6.0 or higher (optional, can use provided mvnw)
  - [Download Maven](https://maven.apache.org/download.cgi)
- **Git**: For cloning the repository (optional)
  - [Download Git](https://git-scm.com/)

### Step-by-Step Installation

#### 1. Clone the Repository

```bash
git clone https://github.com/yourusername/SpringJPA-CRUD.git
cd SpringJPA-CRUD
```

Or download the project ZIP file and extract it.

#### 2. Create MySQL Database

Open your MySQL command line or MySQL Workbench and execute:

```sql
-- Create the database
CREATE DATABASE practice;

-- Use the database
USE practice;
```

**Note**: The `student_jpa` table will be automatically created by Hibernate when the application runs for the first time (thanks to `spring.jpa.hibernate.ddl-auto=update` configuration).

#### 3. Configure Database Connection

Edit the file `src/main/resources/application.properties`:

```properties
spring.application.name=SpringJPA-CRUD

# Database Configuration
spring.datasource.name=practice
spring.datasource.url=jdbc:mysql://localhost/practice
spring.datasource.username=root
spring.datasource.password=your_mysql_password

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.hibernate.ddl-auto=update
```

**Important**: Replace `your_mysql_password` with your actual MySQL root password.

#### 4. Build the Project

Using Maven Wrapper (Windows):

```bash
mvnw.cmd clean install
```

Using Maven Wrapper (Linux/Mac):

```bash
./mvnw clean install
```

Or with installed Maven:

```bash
mvn clean install
```

#### 5. Run the Application

Using Maven Wrapper (Windows):

```bash
mvnw.cmd spring-boot:run
```

Using Maven Wrapper (Linux/Mac):

```bash
./mvnw spring-boot:run
```

Or with installed Maven:

```bash
mvn spring-boot:run
```

Or run the built JAR file:

```bash
java -jar target/SpringJPA-CRUD-0.0.1-SNAPSHOT.jar
```

## Usage Guide

Once the application is running, you'll see the main menu:

```
1. Add Student
2. Update Student
3. Search Student
4. Find All Students
5. Remove a Students
6. Find Student by Name
7. Find Student by Email
8. Exit
Enter your choice:
```

### Operation Examples

**Option 1: Add Student**

- Enter student ID, name, email, phone, program, batch, password, and date of birth
- Student record will be saved to the database

**Option 2: Update Student**

- Enter the student ID you want to update
- Provide new values for the fields you wish to modify

**Option 3: Search Student**

- Enter the student ID to retrieve their complete information

**Option 4: Find All Students**

- Displays all students currently in the database

**Option 5: Remove Student**

- Enter the student ID to delete from the database

**Option 6: Find Student by Name**

- Enter the student's name to search for all matching records

**Option 7: Find Student by Email**

- Enter the student's email to search for matching record(s)

**Option 8: Exit**

- Terminates the application

## Project Dependencies

### Core Dependencies

- **spring-boot-starter-data-jpa**: Spring Data JPA for database operations
- **mysql-connector-j**: MySQL JDBC driver for database connectivity
- **lombok**: Reduces boilerplate code with annotations

### Test Dependencies

- **spring-boot-starter-data-jpa-test**: Testing support for Spring Data JPA

All dependencies are automatically managed by Maven through the Spring Boot parent POM.

## Key Classes

### SpringJpaCrudApplication.java

- **Purpose**: Main application class with CLI menu and business logic
- **Responsibilities**:
  - Initializes Spring Boot application
  - Provides interactive command-line interface
  - Handles all CRUD operations
  - Manages user input and data validation

### Student.java

- **Purpose**: JPA Entity representing a student record
- **Annotations Used**:
  - `@Entity`: Marks as a JPA entity
  - `@Table(name = "student_jpa")`: Maps to the database table
  - `@Id`: Defines studentID as primary key
  - `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`: Lombok annotations for getters/setters

### StudentRepository.java

- **Purpose**: Data access layer using Spring Data JPA
- **Methods**:
  - `findByStudentName(String studentName)`: Find students by name
  - `findByStudentEmail(String studentEmail)`: Find students by email
  - Inherited CRUD methods from `CrudRepository`

## Configuration Details

### application.properties

- **spring.datasource.url**: MySQL connection URL (default: localhost:3306)
- **spring.datasource.username**: Database username (default: root)
- **spring.datasource.password**: Database password
- **spring.jpa.hibernate.ddl-auto**: Set to `update` for automatic table creation/update
  - Other options: `create`, `create-drop`, `validate`, `none`

## Troubleshooting

### Issue: "Access denied for user 'root'@'localhost'"

**Solution**: Verify your MySQL password in `application.properties` matches your actual MySQL password.

### Issue: "Unknown database 'practice'"

**Solution**: Ensure the `practice` database exists in MySQL. Create it using the SQL command provided above.

### Issue: "The driver has not received any packets from the server"

**Solution**:

- Verify MySQL server is running
- Check the `spring.datasource.url` is correct
- Ensure MySQL port 3306 is accessible

### Issue: "No Java Development Kit (JDK) found"

**Solution**: Install JDK 17 or higher and set the JAVA_HOME environment variable.

### Issue: Maven build fails

**Solution**:

- Clean and rebuild: `mvn clean install`
- Delete `.m2` local repository and re-download dependencies
- Ensure you have internet connection for downloading dependencies

## Building & Deployment

### Build JAR File

```bash
mvn clean package
```

The compiled JAR will be located at: `target/SpringJPA-CRUD-0.0.1-SNAPSHOT.jar`

### Run JAR File

```bash
java -jar target/SpringJPA-CRUD-0.0.1-SNAPSHOT.jar
```

### Running Tests

```bash
mvn test
```

## Future Enhancements

- RESTful API endpoints for web-based integration
- Web UI with Spring MVC or Thymeleaf
- Advanced search and filtering capabilities
- User authentication and authorization
- Email verification system
- Batch import/export functionality
- Database connection pooling optimization
- Logging and monitoring features

## Notes

- The application uses the Lombok library to minimize boilerplate code
- Hibernate automatically handles the creation and updating of the `student_jpa` table
- All database operations are performed through Spring Data JPA
- The application follows a simple single-threaded console model

## License

This project is available for educational and development purposes.

## Support

For issues, questions, or contributions, please contact the development team or create an issue in the repository.

---

**Last Updated**: February 2026

**Java Version Required**: 17+

**Spring Boot Version**: 4.0.2
