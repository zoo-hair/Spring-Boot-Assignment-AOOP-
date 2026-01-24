# 📚 Spring Boot Library Management System

**Course:** Advanced Object-Oriented Programming Laboratory (CSE 2118)
**Assignment:** Week Five – Database & Spring Boot
**Technology:** Spring Boot, Spring Data JPA, H2 Database

---

## 📌 Project Overview

This project is a **simple Library Management System** built using **Spring Boot**.
It demonstrates core concepts taught in the course, including:

* Layered architecture (Controller → Service → Repository)
* Dependency Injection
* RESTful APIs
* JPA & H2 in-memory database
* Validation using Jakarta Bean Validation

The system allows:

* Managing books and members
* Borrowing and returning books
* Preventing duplicate borrowing

---

## 🏗 Project Structure

```
src/main/java/com/weekFive/WeekFiveDb/
├── controller/
│   ├── BookController.java
│   ├── MemberController.java
│   └── LibraryController.java
├── service/
│   ├── BookService.java
│   ├── MemberService.java
│   └── LibraryService.java
├── repository/
│   ├── BookRepository.java
│   └── MemberRepository.java
├── model/
│   ├── Book.java
│   └── Member.java
└── WeekFiveDbApplication.java

src/main/resources/
└── application.yml
```

---

## ⚙️ Technologies Used

* **Java 17**
* **Spring Boot 3.x**
* **Spring Web**
* **Spring Data JPA**
* **H2 In-Memory Database**
* **Gradle**
* **Postman** (for API testing)

---

## 🛠 Configuration

### application.yml

```yaml
spring:
  datasource:
    url: jdbc:h2:mem:librarydb
    driver-class-name: org.h2.Driver
    username: sa
    password:
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
  h2:
    console:
      enabled: true
      path: /h2-console
server:
  port: 8080
```

H2 Console URL:

```
http://localhost:8080/h2-console
```

---

## 🚀 How to Run the Project

### Prerequisites

* JDK 17 installed
* IntelliJ IDEA

### Steps

```bash
./gradlew clean bootRun
```

OR run directly from IntelliJ using the ▶️ button on:

```
WeekFiveDbApplication.java
```

---

## 🔗 API Endpoints

### 📘 Book Endpoints

| Method | Endpoint             | Description         |
| ------ | -------------------- | ------------------- |
| POST   | /api/books           | Add a new book      |
| GET    | /api/books           | Get all books       |
| GET    | /api/books/available | Get available books |
| GET    | /api/books/{id}      | Get book by ID      |

### 👤 Member Endpoints

| Method | Endpoint          | Description         |
| ------ | ----------------- | ------------------- |
| POST   | /api/members      | Register new member |
| GET    | /api/members      | Get all members     |
| GET    | /api/members/{id} | Get member by ID    |

### 📚 Library Endpoints

| Method | Endpoint            | Description   |
| ------ | ------------------- | ------------- |
| POST   | /api/library/borrow | Borrow a book |
| POST   | /api/library/return | Return a book |

---

## 🧪 Sample JSON Requests

### Create Book

```json
{
  "title": "Clean Code",
  "author": "Robert Martin",
  "isbn": "1234567890123",
  "price": 450.0
}
```

### Register Member

```json
{
  "name": "Zuhair Islam",
  "email": "zuhair@gmail.com"
}
```

### Borrow / Return Book

```json
{
  "memberId": 1,
  "bookId": 1
}
```

---

## ✅ Validation Rules (Bonus Task)

* Book title and author cannot be empty
* ISBN must be exactly 13 characters
* Price must be positive
* Member email must be valid

Invalid input returns **400 Bad Request**.

---


## 👨‍🎓 Author

**Name:** Juhair Islam Sami
**Department:** Computer Science & Engineering
**Course:** CSE 2118 – Advanced Object-Oriented Programming Laboratory

---

## 📜 License

This project is for **academic purposes only**.
