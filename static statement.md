# 🧩 Static Statement in JDBC

A **Static Statement** is the simplest type of SQL command you can send from a Java program to a database using JDBC. It is called "static" because the SQL query is **fixed, unchanging, and written directly inside the code**.

---


### **Because the SQL query:**

- Does **NOT** change during program execution
- Is **fixed text** inside your code
- Always runs **exactly the same way**
- Does **not accept** any user input
- Is sent to the database **as-is**, without parameters

**Think of it like:** Giving a repeated command every time without altering the sentence.

---

## 📘 Definition

1. A **static statement** is a SQL query written directly inside the Java code and executed through the `Statement` object.
2. It is **predefined, constant**, and remains the same no matter how many times you run the program.
3. It is perfect for **simple SQL commands** where no user input or variables are needed.
4. A **Static Statement in JDBC** is a **fixed SQL query** executed through the `Statement` object. It is used for **simple, unchanging commands** where no user input or conditions are required.
5. Static statements are mainly used for:
    - Running fixed `SELECT` queries
    - Creating or dropping tables
    - Deleting whole data sets
    - Performing operations that do not require filters or conditions

---

## 🏦 Real-World Example (Bus Depot)

**The girl asks for a ticket to Vadodara.
The officer gives a fixed ticket for Gujarat anyway.**

|**Scene 1**|**Scene 2**|
|:----:|:-------:|
|![Static Statement Diagram](https://raw.githubusercontent.com/Am-it15/images/main/static_statement_scene1.png)|![Static Statement Diagram](https://raw.githubusercontent.com/Am-it15/images/main/static_statement_scene2.png)|


## 🏦 Technical Example
In JDBC, a static statement works exactly like this:
```java
Statement st = con.createStatement();
ResultSet rs = st.executeQuery("SELECT * FROM Users WHERE id=123");
```

**Here:**

- `"SELECT * FROM customers"` → static SQL
- It will always fetch the **complete customer list**
- No parameters, no input, no changes

![Static Statement Diagram](https://raw.githubusercontent.com/Am-it15/images/main/static_statement_technical.png)


---


## 📌 When Should You Use a Static Statement?

### ❌ Do NOT use it when the query requires:

- User input
- Conditions (e.g., `WHERE id = ?`)
- Changing values
- Runtime decisions

### ✔ Use it for:

- Displaying full tables
- Creating/dropping tables
- Fixed `DELETE` or `UPDATE` queries
- Running DB setup operations

---

## ⚠️ Limitations of Static Statements

- **Not safe** for user inputs
- **Cannot handle dynamic data** (like searching by id)
- More prone to **SQL Injection** if used wrongly
- Much **slower** than `PreparedStatement` for repeated tasks

---



