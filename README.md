# User-CRUD-Web-Application
# 📌 Project Overview 

This is a Java-based CRUD (Create, Read, Update, Delete) web application built using Servlets, JSP, and JDBC. 

The project allows users to perform basic operations such as:  

* User Registration Login & Logout
* View all users 
* Update user details 
* Delete users

# It follows a simple MVC architecture:

* Controller Layer → Servlets
* Model Layer → Java classes & DAO
* View Layer → JSP & CSS

 # 🔐 Login Page
 
  ![image alt]()

 # 📋 User List Page
 
 ![image alt]()

 # ➕ Add New User
 
  ![image alt]()

 # 🏗️ Project Structure
 
 ![image alt]()

# ⚙️ Technologies Used

* Java (Servlets & JSP) 
* JDBC (Database Connectivity)
* Apache Tomcat (Server)
* Maven (Build Tool)
* HTML, CSS

# 🔍 Features Explained

# 1. User Registration

* Handled by: save_userservlet.java
* Stores user details into the database using UserDao
  
# 2. Login System

* Handled by: Login_servlet.java
* Validates user credentials
* Redirects to home/dashboard page
  
# 3. Logout

* Handled by: Logout_servlet.java
* Invalidates session and redirects to login page
  
# 4. Fetch All Users

* Handled by: Fetchall_servlet.java
* Displays all users in Fetchall.jsp

# 5. Find User

* Handled by: Find_userservlet.java
* Retrieves a specific user based on ID
  
# 6. Update User

* Handled by: Updateuser_servlet.java
* Updates user data in database
  
# 7. Delete User

* Handled by: Delete_userservlet.java
* Deletes user record from database
  
# 🧠 Model Layer

User.java

Plain Old Java Object (POJO)

Contains user attributes like:

* id
* name
* email
* password (if included)
* UserDao.java
  
# Handles all database operations:

* Insert
* Update
* Delete
* Fetch
  
# 🎨 View Layer (JSP)

index.jsp → Home page
Login.jsp → Login page
Saveuser.jsp → Registration page
Fetchall.jsp → Display all users

CSS files are used for styling UI.

# 🚀 How to Run the Project

Clone the repository:

* git clone <>
* Import project into IDE (Eclipse recommended)
* Configure Apache Tomcat Server
* Set up your database:
* Create a database
* Update DB credentials inside UserDao.java

# Build using Maven:

* mvn clean install
* Run on server:
Right click → Run on Server


 
