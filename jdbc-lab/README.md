# JDBC Lab Assignment: Student Database Operations

## 1. Project Overview

This project demonstrates Java Database Connectivity (JDBC) using Java and MySQL. It performs basic database operations on a student database named `StudentsDB`.

## 2. Objectives

* Establish a connection between Java and MySQL using JDBC.
* Create a database and a students table.
* Insert student records into the database.
* Retrieve and display student records.
* Update a student's first name.
* Delete a student record.
* Calculate the average grade of students.

## 3. Technologies Used

* **Java** — programming language
* **MySQL** — relational database management system
* **JDBC** — Java Database Connectivity API
* **Apache Maven** — project and dependency management
* **MySQL Connector/J** — JDBC driver for MySQL

## 4. Database Structure

**Database:** `StudentsDB`

**Table:** `students`

| Column      | Data Type    | Description                |
| ----------- | ------------ | -------------------------- |
| `id`        | INT          | Student ID and primary key |
| `firstname` | VARCHAR(255) | Student's first name       |
| `lastname`  | VARCHAR(255) | Student's last name        |
| `grade`     | INT          | Student's grade            |

## 5. Implemented Operations

1. Create the `StudentsDB` database.
2. Create the `students` table.
3. Insert 11 student records.
4. Retrieve and display five student records.
5. Update a student's first name using their ID.
6. Delete a student record using their ID.
7. Calculate and display the average grade.

## 6. Project Structure

```text
jdbc-lab/
├── README.md
├── pom.xml
└── src/
    └── main/
        └── java/
            └── StudentDatabaseOperations.java
```

## 7. Prerequisites

* Java Development Kit (JDK)
* MySQL Server
* Apache Maven
* A Java IDE, such as IntelliJ IDEA or Eclipse

## 8. Database Configuration

The program connects to MySQL using JDBC. Before running it, ensure that the MySQL server is running and configure the database username and password for your environment.

**Note:** Do not commit real database passwords or other credentials to a public repository.

## 9. How to Run

1. Install the prerequisites.
2. Open the project in a Java IDE or Maven-compatible environment.
3. Configure the MySQL connection credentials.
4. Ensure the MySQL Connector/J dependency is available through Maven.
5. Run `StudentDatabaseOperations.java`.
6. Verify the database operations and results.

## 10. Author

Prepared as part of a JDBC lab assignment on Java and MySQL database connectivity.
