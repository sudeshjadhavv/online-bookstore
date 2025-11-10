# 📚 Online Bookstore Application

## 🧾 Overview

The **Online Bookstore Application** is a backend RESTful web service built with **Spring Boot** that manages books, users, and orders.  
It includes features such as **JWT authentication**, **role-based access control**, and **secure API endpoints** for customers and admins.

---

## 🧱 Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Security (JWT)**
- **Hibernate / JPA**
- **MySQL Database**
- **Maven**
- **Postman** (for testing)

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

```bash
# 1️⃣ Clone the repository
git clone https://github.com/yourusername/online-bookstore.git

# 2️⃣ Navigate to the project directory
cd online-bookstore

# 3️⃣ Configure database in application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/bookstore_db
spring.datasource.username=root
spring.datasource.password=yourpassword

# 4️⃣ Build the project
mvn clean install

# 5️⃣ Run the application
mvn spring-boot:run
```

---

## 🧮 Database Design

**Tables:**
- **users** — stores user details  
- **roles** — defines user roles (`ADMIN`, `CUSTOMER`)  
- **books** — contains book information  
- **orders** — tracks orders made by users  
- **order_items** — links orders with books  

**Relationships:**
- One **User** → Many **Orders**  
- One **Order** → Many **OrderItems**  
- One **Book** → Many **OrderItems**

---

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
OnlineBookstore/
│
├── src/
│   ├── main/
│   │   ├── java/com/sudesh/bookstore/
│   │   │   ├── controller/        # REST Controllers
│   │   │   ├── service/           # Business Logic Layer
│   │   │   ├── repository/        # JPA Repositories
│   │   │   ├── model/             # Entity Classes
│   │   │   ├── security/          # JWT Authentication & Config
│   │   │   └── BookstoreApplication.java  # Main Application Class
│   │   └── resources/
│   │       ├── application.properties
│   │       └── data.sql (optional sample data)
│   └── test/
│       └── BookstoreApplicationTests.java
│
├── pom.xml
└── README.md
```

---

## 🏁 Conclusion

The **Online Bookstore Application** demonstrates a full-fledged backend service with secure APIs, robust data handling, and scalable architecture.  
It can be easily extended to integrate with a frontend or mobile app.

---

## 📞 Contact

**👨‍💻 Developer:** Sudesh Jadhav  
**📧 Email:** sudeshjadhav@gmail.com  
**🔗 GitHub:** [https://github.com/sudeshjadhavv](https://github.com/sudeshjadhavv)  
**🚀 Live Demo:** [https://sudeshjadhavv.github.io/online-bookstore](https://sudeshjadhavv.github.io/online-bookstore)

---
