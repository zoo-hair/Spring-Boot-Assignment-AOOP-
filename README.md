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
├── settings.gradle
├── .gitattributes
├── gradle
│   └── wrapper
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── src
│   ├── test
│   │   └── java
│   │       └── com
│   │           └── weekFive
│   │               └── weekFiveDb
│   │                   └── WeekFiveDbApplicationTests.java
│   └── main
│       ├── resources
│       │   └── application.yml
│       └── java
│           └── com
│               └── weekFive
│                   └── weekFiveDb
│                       ├── WeekFiveDbApplication.java
│                       ├── repository
│                       │   ├── MemberRepository.java
│                       │   └── BookRepository.java
│                       ├── config
│                       │   └── WebConfig.java
│                       ├── service
│                       │   ├── LibraryService.java
│                       │   ├── MemberService.java
│                       │   └── BookService.java
│                       ├── controller
│                       │   ├── LibraryController.java
│                       │   ├── MemberController.java
│                       │   └── BookController.java
│                       └── model
│                           ├── Member.java
│                           └── Book.java
├── .gitignore
├── gradlew.bat
├── README.md
└── gradlew
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

* JDK 17 or higher installed
* Gradle (included via Gradle wrapper)

### Steps

#### Option 1: Using Gradle Wrapper (Recommended)

**On Windows:**
```bash
gradlew.bat clean bootRun
```

**On Linux/Mac:**
```bash
./gradlew clean bootRun
```

#### Option 2: Using IDE (IntelliJ IDEA)

1. Open the project in IntelliJ IDEA
2. Wait for Gradle to sync dependencies
3. Run directly using the ▶️ button on `WeekFiveDbApplication.java`

The application will start on `http://localhost:8080`

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

## 🔧 WebConfig

The project includes CORS configuration (`WebConfig.java`) to allow cross-origin requests from the frontend application running on `http://localhost:3000`.

---

## 📝 Notes

* This project uses an **H2 in-memory database**, so data will be lost when the application stops
* The database is accessible via H2 Console at `/h2-console`
* Default credentials: username: `sa`, password: (empty)

---

## 👨‍🎓 Author

**Name:** Juhair Islam Sami  
**Department:** Computer Science & Engineering  
**Course:** CSE 2118 – Advanced Object-Oriented Programming Laboratory

---

## 📜 License

This project is for **academic purposes only**.