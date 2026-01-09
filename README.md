# JDBC-Assignment
# JDBC CRUD Operations with MySQL (Java)

This repository contains a **complete beginner-friendly JDBC project** demonstrating how to connect Java with a MySQL database and perform **CRUD operations** using **PreparedStatement**.

It is designed for students learning **Core Java + JDBC + MySQL**.

---

## 📌 Features

✔ MySQL database connection using JDBC  
✔ Insert records into database  
✔ Read (fetch) records from database  
✔ Update existing records  
✔ Delete records  
✔ Uses `PreparedStatement` (prevents SQL Injection)  
✔ Menu-driven program using `Scanner`  
✔ Proper exception handling  

---

## 🛠 Technologies Used

- **Java (JDK 8+)**
- **MySQL Database**
- **JDBC (MySQL Connector/J)**
- **PreparedStatement**
- **Scanner (User Input)**

---

## 🗄 Database Details

### Database Name
## Student_db

### Table Structure
```sql
CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT,
    marks INT DEFAULT 0
);

## Project Structure
├── Task1.java        # MySQL Connection Test
├── Task2.java        # Read (SELECT) Operation
├── Task3.java        # Insert (INSERT) Operation
├── Task4.java        # Update (UPDATE) Operation
├── Task5.java        # Delete (DELETE) Operation
├── DBJava.java       # Database Connection Utility
├── Main.java         # Menu Driven Program
├── Methods.java     # CRUD Methods
└── README.md

## 🔑 MySQL Connection Configuration
String mysqlUrl = "jdbc:mysql://localhost:3306/Student_db";
String username = "root";
String password = "your_password";

🚀 How to Run the Project

1️⃣ Start MySQL Server
Make sure MySQL is running.

2️⃣ Create Database & Table
Run the SQL commands provided above.

3️⃣ Add MySQL Connector JAR
Add mysql-connector-j.jar to your project classpath.

4️⃣ Compile & Run
javac *.java
java Main

📋 CRUD Operations Explained
➕ Insert Data
INSERT INTO students VALUES (?, ?, ?);

📖 Read Data
SELECT * FROM students;

✏ Update Data
UPDATE students SET marks = ? WHERE id = ?;

❌ Delete Data
DELETE FROM students WHERE id = ?;

🧠 Key JDBC Learnings
## ? is used only for values, not table/column names
## Always use PreparedStatement instead of Statement
## executeQuery() → SELECT
## executeUpdate() → INSERT / UPDATE / DELETE
## \t is for printing, not column names
## Table names should never be in quotes

⚠ Common Errors Solved
>SQLSyntaxErrorException
>Missing parentheses in CREATE TABLE
>Using ? for table name (WRONG)
>Incorrect column name usage in ResultSet
>Forgetting to set values for ?

🎯 Ideal For
JDBC beginners
College practicals
Viva preparation
Interview fundamentals
Mini Java projects

👨‍💻 Author
Mayur Ughade
Learning Java | JDBC | MySQL






