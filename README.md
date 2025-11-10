# 📚 Online Bookstore Application

## 🧾 Overview

The **Online Bookstore Application** is a backend RESTful web service built with **Spring Boot** that manages books, users, and orders.  
It includes features such as **JWT authentication**, **role-based access control**, and **secure API endpoints** for customers and admins.

---

## 🧰 Tech Stack

| Layer | Technology |
|:------|:------------|
| **Language** | Java 17 |
| **Framework** | Spring Boot |
| **ORM** | Hibernate / JPA |
| **Database** | MySQL |
| **Security** | Spring Security with JWT |
| **Build Tool** | Maven |
| **API Testing** | Postman / Swagger |
| **Version Control** | Git & GitHub |

---

## 🌟 Key Features

✅ **User Authentication & Authorization** — JWT-based login and registration with `ADMIN` and `CUSTOMER` roles.  
✅ **Book Management** — Admins can add, update, and delete books.  
✅ **Order Management** — Customers can place orders for available books.  
✅ **Role-Based Access Control** —  
   - `ADMIN` → Manage books, view all orders  
   - `CUSTOMER` → Browse books, place and view personal orders  
✅ **Database Integration** — Uses Hibernate ORM for database operations.  
✅ **Validation & Exception Handling** — Handles errors gracefully with proper messages.  
✅ **RESTful API Design** — Structured and scalable API endpoints.

---

## 🧭 System Architecture

The application follows a **layered architecture** for clean separation of concerns:

- **Controller Layer** → Handles incoming API requests.  
- **Service Layer** → Contains core business logic.  
- **Repository Layer** → Interacts with the database using Spring Data JPA.  
- **Security Layer** → Manages JWT authentication and authorization.  
- **Entity Layer** → Defines JPA entities (Book, User, Order, Role).

---

## ⚙️ Setup & Installation

### 🪜 Prerequisites
Make sure the following are installed:
- Java 17+
- Maven 3.9+
- MySQL 8+
- Postman (optional for testing)

---

### 🧩 Steps to Run the Project

### 1️⃣ Clone the repository
git clone https://github.com/yourusername/online-bookstore.git

### 2️⃣ Navigate to the project directory
cd online-bookstore

### 3️⃣ Configure database in application.properties
```
spring.datasource.url=jdbc:mysql://localhost:3306/bookstore_db
spring.datasource.username=root
spring.datasource.password=yourpassword
```
### JWT Secret (use any random string)
```
app.jwt-secret=your_jwt_secret_key
app.jwt-expiration=86400000
```
### 4️⃣ Run the application
mvn spring-boot:run

### 5️⃣  Verify Database Tables

Once the application starts successfully, open **MySQL Workbench** and verify that these tables are created:

SHOW TABLES;
```
+-------------------+
| Tables_in_online_bookstore |
+-------------------+
| users             |
| books             |
| orders            |
+-------------------+
```
### 🗄️ Database Design
```
┌────────────┐       ┌──────────────┐       ┌──────────────┐
│   USERS    │1     M│    ORDERS    │M     1│    BOOKS     │
│────────────│-------│──────────────│-------│──────────────│
│ id (PK)    │       │ id (PK)      │       │ id (PK)      │
│ name       │       │ orderDate    │       │ title        │
│ email      │       │ user_id (FK) │       │ author       │
│ password   │       │ book_id (FK) │       │ price        │
│ role       │       │ quantity     │       │ category     │
└────────────┘       └──────────────┘       └──────────────┘
```
###  Insert Sample Data (Admin, Customer, and Books)

After the database and tables are ready, insert sample users and books to test the system.
```
-- INSERT SAMPLE USERS
INSERT INTO users (name, email, password, role) VALUES
('Admin User', 'admin@example.com', 'admin@123', 'ADMIN'),
('Rohit Sharma', 'rohit@example.com', 'rohit@123', 'CUSTOMER'),
('Priya Mehta', 'priya@example.com', 'priya@123', 'CUSTOMER');

-- INSERT SAMPLE BOOKS
INSERT INTO books (title, author, price, category) VALUES
('The Java Handbook', 'Patrick Naughton', 799.00, 'Programming'),
('Spring Boot in Action', 'Craig Walls', 699.00, 'Backend Development'),
('Clean Code', 'Robert C. Martin', 999.00, 'Software Engineering'),
('Effective Java', 'Joshua Bloch', 899.00, 'Programming');

-- INSERT SAMPLE ORDERS
INSERT INTO orders (order_date, user_id, book_id, quantity) VALUES
(NOW(), 2, 1, 1),
(NOW(), 2, 3, 1),
(NOW(), 3, 4, 2);
```
### 🔍 Notes

- Passwords here are **plain text** only for testing (in production, they should be **encrypted using BCrypt**).
- Roles define **access levels** (e.g., only Admin can manage books and orders).
- You can execute these SQL commands directly in **MySQL Workbench** or **phpMyAdmin** after creating the database.
## 6️⃣ 🚀 API Endpoints Documentation
## 🔐 Authentication Workflow

1. **Register User** → `/api/auth/register`  
   - User details (username, password) are saved securely with encrypted passwords.

2. **Login User** → `/api/auth/login`  
   - Returns a **JWT token** upon successful login.

3. **Use JWT Token in Postman:**  
   - Copy the token from the login response.  
   - Go to the **Authorization** tab in Postman.  
   - Choose **Bearer Token** and paste your token.  
   - Now you can access all secured endpoints.

---

## 📡 API Endpoints

### 🔑 Authentication

| Method | Endpoint | Description |
|:-------:|:----------|:-------------|
| POST | `/api/auth/register` | Register a new user |
| POST | `/api/auth/login` | Login and get JWT token |

---

### 📚 Books

| Method | Endpoint | Description | Access |
|:-------:|:----------|:-------------|:---------|
| GET | `/api/books` | Get all books | Public |
| GET | `/api/books/{id}` | Get book by ID | Public |
| POST | `/api/books` | Add new book | Admin |
| PUT | `/api/books/{id}` | Update book details | Admin |
| DELETE | `/api/books/{id}` | Delete book | Admin |

---

### 🛒 Orders

| Method | Endpoint | Description | Access |
|:-------:|:----------|:-------------|:---------|
| GET | `/api/orders` | Get all orders (Admin) | Admin |
| GET | `/api/orders/user` | Get logged-in user’s orders | Customer |
| POST | `/api/orders` | Place new order | Customer |

---

## 🧪 Testing with Postman

### 1️⃣ Register a User
**POST** → `http://localhost:8080/api/auth/register`  
**Body (JSON):**
```json
{
  "username": "john",
  "password": "123456"
}
```

---

### 2️⃣ Login and Get JWT Token
**POST** → `http://localhost:8080/api/auth/login`  
**Body (JSON):**
```json
{
  "username": "john",
  "password": "123456"
}
```

Copy the token from the response.

---

### 3️⃣ Access Secured Endpoints
**Example:**
```http
GET http://localhost:8080/api/orders
Authorization: Bearer <your_token_here>
```

---

## 🧩 Project Structure

```
online-bookstore/
│
├── 📁 src/
│ └── 📁 main/
│ └── 📁 java/
│ └── 📁 com/sudesh/bookstore/
│ │
│ ├── 📁 config/
│ │ └── SecurityConfig.java # Spring Security configuration
│ │
│ ├── 📁 controller/
│ │ ├── AuthController.java # Handles user registration and login
│ │ ├── BookController.java # CRUD operations for books
│ │ └── OrderController.java # Manage orders
│ │
│ ├── 📁 entities/
│ │ ├── User.java # Represents users (Admin/Customer)
│ │ ├── Book.java # Represents book details
│ │ └── Order.java # Represents orders placed by users
│ │
│ ├── 📁 repositories/
│ │ ├── UserRepository.java # Handles DB operations for User
│ │ ├── BookRepository.java # Handles DB operations for Book
│ │ └── OrderRepository.java # Handles DB operations for Order
│ │
│ ├── 📁 security/
│ │ ├── JwtAuthenticationFilter.java # Filters incoming requests for JWT
│ │ ├── JwtTokenProvider.java # Generates and validates JWT tokens
│ │ └── CustomUserDetailsService.java # Loads user-specific data
│ │
│ ├── 📁 service/
│ │ ├── AuthService.java # Handles user auth logic
│ │ ├── BookService.java # Handles book management logic
│ │ ├── OrderService.java # Handles order management logic
│ │ └── impl/ # Service implementation layer
│ │ ├── AuthServiceImpl.java
│ │ ├── BookServiceImpl.java
│ │ └── OrderServiceImpl.java
│ │
│ └── BookstoreApplication.java # Main Spring Boot application class
│
├── 📄 pom.xml # Maven dependencies and plugins
├── 📄 README.md # Project documentation
└── 📄 .gitignore # Ignored files for Git
```
---


## 🏁 Project Conclusion

The **Online Bookstore Application** successfully demonstrates a complete backend implementation using **Java, Spring Boot, Hibernate, and MySQL**.  
It provides a secure, modular, and scalable solution for managing books, users, and orders efficiently.

Key highlights include:
- Secure authentication and authorization using **JWT**.
- Separation of concerns with a **layered architecture**.
- Efficient database management using **Spring Data JPA and Hibernate**.
- Fully tested **RESTful APIs** for smooth integration with any frontend application.
- Reusable and maintainable code design following **best Spring Boot practices**.

This project reflects strong backend development skills, clean API design, and practical implementation of real-world enterprise patterns.

---

## 🚀 Future Enhancements

Here are some potential improvements and features that can be added to make the system more powerful and production-ready:

✅ **Payment Gateway Integration** — Add secure payment processing (e.g., Razorpay, Stripe) for online orders.  
✅ **Inventory Management** — Track stock levels and auto-update book availability.  
✅ **Email Notifications** — Notify users about successful orders or password resets.  
✅ **Admin Dashboard** — Build a frontend dashboard using React or Angular for easier management.  
✅ **Pagination & Search Filters** — Improve book browsing with sorting, filtering, and pagination.  
✅ **Cloud Deployment** — Deploy on AWS / Render / Railway for real-world access.  
✅ **Comprehensive Testing** — Add unit and integration tests for all layers.

---

✨ *This project demonstrates a strong understanding of Spring Boot backend development and can serve as a solid foundation for any full-stack e-commerce or online management system.*

## 📞 Contact

**👨‍💻 Developer:** Sudesh Jadhav  
**📧 Email:** sudeshjadhavv@gmail.com  
**🔗 GitHub:** [https://github.com/sudeshjadhavv](https://github.com/sudeshjadhavv)  
**🚀 Live:** [https://sudeshjadhavv.github.io/online-bookstore](https://sudeshjadhavv.github.io/online-bookstore)

---
