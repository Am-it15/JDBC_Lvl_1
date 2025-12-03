# 📊 Employee Management System using JDBC

A simple Java console application to manage employee records in a MySQL database using JDBC (Java Database Connectivity).

---

## 🎯 What Does This Program Do?

This program lets you:
- **View** all employee records from the database
- **Add** new employees
- **Update** employee information (name, department, salary)
- **Delete** employees from the database

Think of it as a basic employee management tool that talks directly to your MySQL database!

---

## 🛠️ Prerequisites

Before running this program, you need:

1. **Java JDK** installed (version 8 or higher)
2. **MySQL Server** installed and running
3. **MySQL JDBC Driver** (Connector/J) added to your project
4. A database named `test` in your MySQL

---

## 📦 Setup Instructions

### Step 1: Create the Database

Open MySQL and run these commands:

```sql
CREATE DATABASE test;
USE test;

CREATE TABLE employees (
    eid INT PRIMARY KEY AUTO_INCREMENT,
    ename VARCHAR(100),
    edept VARCHAR(50),
    esal DOUBLE
);
```

### Step 2: Update Database Credentials

In the `Main.java` file, update these lines if needed:

```java
public static String url = "jdbc:mysql://localhost:3306/test";
public static String user = "root";
public static String pswd = "";  // Your MySQL password here
```

### Step 3: Add MySQL JDBC Driver

Download the MySQL Connector/J and add it to your project classpath.

---

## 📋 Menu Options Explained

### 1️⃣ Retrieve Data
- Shows all employees in the database
- Displays: Employee ID, Name, Department, and Salary

### 2️⃣ Insert Data
- Adds a new employee to the database
- Currently adds: Name = "BHAVESH", Department = "CSE", Salary = 23000
- *(Note: You can modify the code to accept custom input)*

### 3️⃣ Update Data
- Lets you change employee information
- Sub-menu options:
    - Change employee name
    - Change department
    - Change salary
- Currently updates employee with ID = 20251102

### 4️⃣ Delete Data
- Removes an employee from the database
- Currently deletes employee with ID = 20251102

### 5️⃣ Exit
- Closes the program

---

## 🔍 How It Works (Simple Explanation)

### What is JDBC?
JDBC is like a **bridge** between your Java program and the MySQL database. It allows Java to:
- Send commands to the database (like "get all employees")
- Receive data back from the database

### The Flow:

1. **Connect to Database**
    - Program first loads the MySQL driver
    - Then connects to your database using username and password

2. **Execute Commands**
    - Uses `Statement` to send SQL queries
    - For reading data: uses `executeQuery()` → returns a `ResultSet`
    - For changing data: uses `executeUpdate()` → returns number of rows affected

3. **Process Results**
    - For retrieved data, loops through `ResultSet` to display each employee
    - For insert/update/delete, checks if operation was successful

---

## ⚠️ Important Notes

### Current Limitations:

1. **Hard-coded Values**: The insert, update, and delete operations use fixed values (like employee ID 20251102). You might want to modify this to accept user input.

2. **Bug in Retrieve Data**: There's an issue in the `retrieveData()` method:
   ```java
   int id = rs.findColumn("eid");  // ❌ Wrong! This returns column index
   double sal = rs.findColumn("esal");  // ❌ Wrong!
   ```
   Should be:
   ```java
   int id = rs.getInt("eid");  // ✅ Correct
   double sal = rs.getDouble("esal");  // ✅ Correct
   ```

3. **Connection Not Closed**: The program doesn't close the database connection properly. Consider adding connection cleanup.

4. **SQL Injection Risk**: Using string concatenation for SQL queries can be dangerous. Use `PreparedStatement` instead for better security.

---

## 💡 Suggestions for Improvement

- [ ] Add user input for insert/update/delete operations
- [ ] Fix the `retrieveData()` method bugs
- [ ] Use `PreparedStatement` instead of `Statement`
- [ ] Close database connections properly using try-with-resources
- [ ] Add error handling for invalid employee IDs
- [ ] Validate user input to prevent errors

---

## 📚 Key Concepts

| Concept | What It Does |
|---------|--------------|
| **Connection** | Represents the link to your database |
| **Statement** | Sends SQL commands to the database |
| **ResultSet** | Holds the data returned from a SELECT query |
| **executeQuery()** | Used for SELECT (reading data) |
| **executeUpdate()** | Used for INSERT, UPDATE, DELETE (changing data) |

---

## 🎓 Learning Points

This program teaches you:
- ✅ How to connect Java to a MySQL database
- ✅ How to perform CRUD operations (Create, Read, Update, Delete)
- ✅ How to handle user input with Scanner
- ✅ Basic exception handling with try-catch
- ✅ Working with SQL queries in Java

---

## 📝 Example Output

```
✅ JDBC Drive is connected successfully....
✅ Database is connected successfully....
================================== Basic JDBC ==================================
1 : Retrieve Data
2 : Insert Data
3 : Update Data
4 : Delete Data
5 : Exit

Enter your choice :: 1

========== DATA NO. 0 ==========
Employee id :: 1
Employee Name :: John Doe
Employee Department :: IT
Employee Salary :: 50000.0
```

---

## 🤝 Contributing

Feel free to improve this code! Some ideas:
- Add dynamic input for all operations
- Implement search functionality
- Add data validation
- Create a GUI version

---

## 📄 License

Free to use for learning purposes! 🎉

---

**Happy Coding! 💻**
```