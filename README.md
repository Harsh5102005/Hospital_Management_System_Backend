# 🏥 Hospital Management System

A comprehensive RESTful backend API for managing hospital operations, including patient records, doctor schedules, appointments, insurance information, and departments.

---

## ✨ Features

- **🔐 Secure Authentication**: JWT-based stateless authentication with Spring Security
- **👥 User Management**: User registration and login with role-based access control
- **🏥 Patient Management**: Complete patient lifecycle management with CRUD operations
- **👨‍⚕️ Doctor Management**: Doctor profile management and department assignment
- **📋 Appointment Scheduling**: Schedule and manage medical appointments
- **🏢 Department Management**: Organize doctors by departments
- **💼 Insurance Management**: Assign and manage patient insurance information
- **🔄 Bidirectional Relationships**: Complex JPA relationships between entities
- **✅ Data Validation**: Comprehensive input validation and error handling
- **💾 Transaction Management**: Ensure data consistency with @Transactional operations

---

## 🛠️ Tech Stack

| Component | Technology |
|-----------|------------|
| **Language** | Java 25 |
| **Framework** | Spring Boot 4.0.5 |
| **Security** | Spring Security + JWT |
| **Database** | MySQL |
| **ORM** | Hibernate + Spring Data JPA |
| **Build Tool** | Maven |
| **Code Generation** | Lombok |
| **API Pattern** | RESTful |

---

## 📋 Prerequisites

- **Java 25** or higher
- **Maven 3.6+**
- **MySQL 8.0+**
- **Postman** (for API testing)

---

## 🚀 Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/hospital-management-system.git
cd system
```

### 2. Configure Database

Create a MySQL database:
```sql
CREATE DATABASE hospital_db;
```

Update `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/hospital_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### 3. Build the Project
```bash
mvn clean install
```

### 4. Run the Application
```bash
mvn spring-boot:run
```

Or use Java directly:
```bash
java -jar target/system-0.0.1-SNAPSHOT.jar
```

The server will start on: **http://localhost:8080**

---

## 📂 Project Structure

```
hospital-management-system/
├── src/
│   ├── main/
│   │   ├── java/com/hospital/system/
│   │   │   ├── SystemApplication.java          # Main entry point
│   │   │   ├── Config/                         # Configuration classes
│   │   │   ├── Controller/                     # REST endpoints
│   │   │   │   ├── AuthController.java
│   │   │   │   ├── PatientController.java
│   │   │   │   ├── DoctorController.java
│   │   │   │   ├── DepartmentController.java
│   │   │   │   ├── InsuranceController.java
│   │   │   │   └── AppointmentController.java
│   │   │   ├── Service/                        # Business logic
│   │   │   │   ├── PatientService.java
│   │   │   │   ├── DoctorService.java
│   │   │   │   ├── InsuranceServiceDto.java
│   │   │   │   ├── DepartmentService.java
│   │   │   │   └── AppointmentService.java
│   │   │   ├── Repository/                     # Data access layer
│   │   │   │   ├── UserRepository.java
│   │   │   │   ├── PatientRepository.java
│   │   │   │   ├── DoctorRepository.java
│   │   │   │   ├── InsuranceRepository.java
│   │   │   │   └── DepartmentRepository.java
│   │   │   ├── Entity/                         # Database entities
│   │   │   │   ├── User.java
│   │   │   │   ├── Patient.java
│   │   │   │   ├── Doctor.java
│   │   │   │   ├── Insurance.java
│   │   │   │   ├── Department.java
│   │   │   │   └── Appointment.java
│   │   │   ├── dto/                            # Data Transfer Objects
│   │   │   │   ├── LoginRequestDto.java
│   │   │   │   ├── LoginResponseDto.java
│   │   │   │   ├── PatientRequestDto.java
│   │   │   │   ├── PatientResponseDto.java
│   │   │   │   ├── DoctorRequestDto.java
│   │   │   │   ├── DoctorResponseDto.java
│   │   │   │   ├── InsuranceRequestDto.java
│   │   │   │   ├── InsuranceResponseDto.java
│   │   │   │   ├── DepartmentRequestDto.java
│   │   │   │   └── DepartmentResponseDto.java
│   │   │   └── Security/                       # Security components
│   │   │       ├── JwtUtil.java                # JWT token generation
│   │   │       ├── JwtAuthFilter.java          # JWT authentication filter
│   │   │       ├── AuthService.java            # Authentication service
│   │   │       ├── UserDetailsImplementation.java
│   │   │       └── WebSecurity.java            # Security configuration
│   │   └── resources/
│   │       └── application.properties          # Application configuration
│   └── test/
│       └── java/                               # Unit tests
├── pom.xml                                     # Maven configuration
└── README.md                                   # This file
```

---

## 🔌 API Endpoints

### Authentication
| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/auth/register` | Register a new user |
| POST | `/auth/login` | Login and get JWT token |

### Patient Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/patient` | Get all patients |
| GET | `/patient/{id}` | Get patient by ID |
| POST | `/patient` | Create new patient |
| PUT | `/patient/{id}` | Update patient |
| DELETE | `/patient/{id}` | Delete patient |

### Doctor Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/doctor` | Get all doctors |
| GET | `/doctor/{id}` | Get doctor by ID |
| POST | `/doctor` | Create new doctor |
| PUT | `/doctor/{id}` | Update doctor |
| DELETE | `/doctor/{id}` | Delete doctor |

### Department Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/department` | Get all departments |
| GET | `/department/{id}` | Get department by ID |
| POST | `/department` | Create new department |
| PUT | `/department/{id}` | Update department |
| DELETE | `/department/{id}` | Delete department |

### Insurance Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/insurance` | Get all insurance records |
| GET | `/insurance/{id}` | Get insurance by ID |
| POST | `/insurance` | Create new insurance |
| PUT | `/insurance/{id}` | Update insurance |
| DELETE | `/insurance/{id}` | Delete insurance |
| POST | `/insurance/assign/{insuranceId}/patient/{patientId}` | Assign insurance to patient |
| POST | `/insurance/disassociate/{patientId}` | Remove insurance from patient |

### Appointment Management
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/appointment` | Get all appointments |
| GET | `/appointment/{id}` | Get appointment by ID |
| POST | `/appointment` | Create new appointment |
| PUT | `/appointment/{id}` | Update appointment |
| DELETE | `/appointment/{id}` | Delete appointment |

---

## 🔐 Authentication

All endpoints (except `/auth/**`) require JWT authentication.

### 1. Register a New User
```bash
POST /auth/register
Content-Type: application/json

{
  "username": "harshmaury",
  "password": "yourpassword"
}
```

### 2. Login
```bash
POST /auth/login
Content-Type: application/json

{
  "username": "harshmaury",
  "password": "yourpassword"
}
```

**Response:**
```json
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
```

### 3. Use Token in Requests
Add the token to the Authorization header:
```bash
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...
```

---

## 📝 Example API Usage

### Create a Patient
```bash
POST /patient
Authorization: Bearer YOUR_JWT_TOKEN
Content-Type: application/json

{
  "name": "John Doe",
  "gender": "Male",
  "email": "john@example.com",
  "birthdate": "1990-05-15"
}
```

### Get All Doctors
```bash
GET /doctor
Authorization: Bearer YOUR_JWT_TOKEN
```

### Assign Insurance to Patient
```bash
POST /insurance/assign/1/patient/5
Authorization: Bearer YOUR_JWT_TOKEN
```

---

## 🏗️ Architecture

### Layered Architecture
```
Controller Layer (REST Endpoints)
        ↓
Service Layer (Business Logic)
        ↓
Repository Layer (Data Access)
        ↓
Entity/Database Layer (MySQL)
```

### Key Design Patterns
- **DTO Pattern**: Separate internal models from API responses
- **Repository Pattern**: Abstract data access logic
- **Service Layer**: Centralized business logic
- **Builder Pattern**: Used with Lombok for entity construction

---

## 🔒 Security Features

- **JWT Authentication**: Stateless token-based authentication
- **Spring Security**: Role-based access control
- **Password Encryption**: BCrypt password hashing
- **CORS Disabled**: CSRF protection enabled
- **Stateless Sessions**: No session storage on server

---

## 📊 Database Schema

### Key Entities
- **User**: Authentication and user management
- **Patient**: Patient information and medical history
- **Doctor**: Doctor profiles and specializations
- **Department**: Hospital departments
- **Insurance**: Patient insurance information
- **Appointment**: Medical appointment scheduling

### Relationships
- **Patient ↔ Insurance**: One-to-One (bidirectional)
- **Patient ↔ Appointment**: One-to-Many
- **Doctor ↔ Department**: Many-to-One
- **Doctor ↔ Appointment**: One-to-Many

---

## 🧪 Testing

Run unit tests:
```bash
mvn test
```

Use Postman for API testing:
1. Import the API endpoints
2. Set up Authentication in Postman
3. Test each endpoint with sample data

---

## 🚧 Future Enhancements

- [ ] Add appointment notifications (Email/SMS)
- [ ] Implement role-based access (Admin, Doctor, Patient)
- [ ] Add medical records management
- [ ] Implement billing and payment system
- [ ] Add prescription management
- [ ] Create frontend dashboard
- [ ] Add API documentation (Swagger/OpenAPI)
- [ ] Implement audit logging
- [ ] Add advanced search and filtering
- [ ] Deploy to cloud (AWS/Azure/GCP)

---

## 🤝 Contributing

Contributions are welcome! Here's how:

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 👤 Author

**Harsh Maurya**
- GitHub: [@harsh5102005](https://github.com/harsh5102005)


## 🎯 Key Achievements

✅ Developed secure JWT authentication system  
✅ Designed complex relational database with 6+ entities  
✅ Built 30+ RESTful API endpoints  
✅ Implemented bidirectional JPA relationships  
✅ Applied transaction management for data consistency  
✅ Clean layered architecture with separation of concerns  
✅ Comprehensive error handling and validation  

---

**Last Updated**: April 24, 2026  
**Version**: 1.0.0

