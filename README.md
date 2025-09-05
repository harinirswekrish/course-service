# 📚 Course Service – Mini School ERP

## 📌 Overview
The **Course Service** is a microservice in the **Mini School ERP System**.  
It manages all school courses and enforces **role-based access control**.

- **Admin** → Can create and view courses  
- **Staff** → Can only view courses  

---

## ⚙️ Tech Stack
- Java 8+
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA (Hibernate)
- PostgreSQL
- Maven
- Swagger (OpenAPI)

---

## 🏗️ Architecture & Flow
1. **API Gateway** validates JWT and routes requests.  
2. Requests reach **Course Service** running on port `8083`.  
3. Course Service interacts with **PostgreSQL** for persistence.  
4. Responses are returned in **JSON** with proper HTTP status codes.  

---

## 🗄️ Database Schema
**Table: courses**

| Column       | Type         | Constraints      |
| ------------ | ------------ | ---------------- |
| id           | BIGSERIAL PK | Primary Key      |
| course\_name | VARCHAR(150) | UNIQUE, NOT NULL |
| description  | TEXT         |                  |
| created\_at  | TIMESTAMP    | DEFAULT now()    |
| updated\_at  | TIMESTAMP    | ON UPDATE now()  |

---

## 🚀 Setup & Run

### Prerequisites
- JDK 8+  
- Maven 3+  
- PostgreSQL  

### Steps
```bash
# Clone repository
git clone https://github.com/harinirswekrish/course-service.git
cd course-service

# Update application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=yourpassword

jwt.secret=yourSecretKey
jwt.expiration=3600000
