# Web Applications Using Servlets and JSP

This project demonstrates basic web application development using **Java Servlets**, **JSP**, and **JDBC**.
It covers user input handling, database connectivity, and dynamic content generation through three parts:

* **Part A:** User Login using Servlet and HTML Form
* **Part B:** Display Employee Records using Servlet and JDBC
* **Part C:** Student Attendance Portal using JSP and Servlet

---

## 🧩 Project Structure

```
src/
│── LoginServlet.java
│── EmployeeServlet.java
│── AttendanceServlet.java

WebContent/
├── login.html
├── employee.html
├── attendance.jsp

WEB_INF/
|-web.xml
```


---

## ⚙️ Technologies Used

* **Java Servlet API**
* **JSP (Java Server Pages)**
* **JDBC (Java Database Connectivity)**
* **HTML5 / CSS**
* **Apache Tomcat (v9 or above)**
* **MySQL / any relational database**

---

## 🧠 Part A: User Login Using Servlet and HTML Form

**Objective:**
Develop a Java Servlet that accepts user credentials via an HTML form and displays a personalized message.

**Flow:**

1. `login.html` captures username and password.
2. Form data is sent via `POST` to `LoginServlet`.
3. `LoginServlet` retrieves form parameters using:

   ```java
   String username = request.getParameter("username");
   String password = request.getParameter("password");
   ```
4. Credentials are validated (either hardcoded or via database).
5. On success → display a welcome message.
   On failure → show an error message.

**Key Concepts:**
Form submission, request handling, and dynamic response generation.

---

## 👨‍💼 Part B: Display Employee Records with JDBC and Servlet Integration

**Objective:**
Connect a Servlet to a database using JDBC to display employee records and support search by Employee ID.

**Flow:**

1. `EmployeeServlet` connects to the database using a helper class (`DBConnection`).
2. Executes SQL queries such as:

   ```sql
   SELECT * FROM Employee;
   SELECT * FROM Employee WHERE EmpID = ?;
   ```
3. Displays results in an HTML table format.
4. Provides a search form to query employee details by ID.

**Key Concepts:**
Servlet–JDBC integration, result set iteration, and dynamic HTML content generation.

---

## 🎓 Part C: Student Attendance Portal Using JSP and Servlet

**Objective:**
Create a simple attendance management portal with JSP for the UI and Servlet for database operations.

**Flow:**

1. `attendance.jsp` collects:

   * Student ID
   * Date
   * Attendance status
2. On submission, form data is sent to `AttendanceServlet` using `POST`.
3. `AttendanceServlet`:

   * Reads parameters via `request.getParameter()`
   * Inserts data into the `Attendance` table using JDBC
   * Displays a confirmation message or redirects to a success page.

**Key Concepts:**
MVC architecture (JSP as View, Servlet as Controller), form submission, and database insertion.

---

## 🧾 Database Setup

Example MySQL table structures:

```sql
CREATE TABLE Employee (
    EmpID INT PRIMARY KEY,
    Name VARCHAR(50),
    Salary DECIMAL(10,2)
);

CREATE TABLE Attendance (
    StudentID INT,
    Date DATE,
    Status VARCHAR(10)
);
```

Update your JDBC connection details in `DBConnection.java`:
```java

private static final String URL = "jdbc:mysql://localhost:3306/your_database";
private static final String USER = "root";
private static final String PASSWORD = "your_password";
```

---
