# ClientFlow

# Client Management System

A Spring Boot-based web application for managing client information with full CRUD (Create, Read, Update, Delete) operations.

![Demo Screenshot](screenshots/demo.png) <!-- Add actual screenshots later -->

## Features

- Create new client records with validation
- View all clients in a responsive table
- Edit existing client information
- Delete clients with confirmation
- Form validation for all fields
- Search functionality (optional - add if implemented)
- Responsive Bootstrap UI
- H2 in-memory database integration
- Automatic timestamp for client creation

## Technologies Used

- **Spring Boot 3** - Backend framework
- **Thymeleaf** - Server-side templating
- **H2 Database** - In-memory database
- **Bootstrap 5** - Frontend styling
- **Spring Data JPA** - Database operations
- **Hibernate Validator** - Form validation
- **Maven** - Dependency management

## Prerequisites

- Java 17 or higher
- Maven 3.6.3 or higher
- Internet connection (for Bootstrap CDN)

## Getting Started

1. **Clone the repository**
  
   git clone https://github.com/your-username/client-management-system.git
   cd client-management-system


2. **Run the application**
     mvn spring-boot:run
   
4. **Access the application**

Main interface: http://localhost:8080

5. **Application Structure**
    src/
├── main/
│   ├── java/
│   │   └── com/example/Spring/
│   │       ├── Controllers/
│   │       ├── models/
│   │       ├── repositories/
│   │       └── SpringProjectApplication.java
│   └── resources/
│       ├── static/
│       ├── templates/
│       └── application.properties


**Key Endpoints**
Endpoint	Method	Description
/	GET	Home page
/clients	GET	List all clients
/clients/create	GET	Show client creation form
/clients/create	POST	Process client creation
/clients/{id}/edit	GET	Show client edit form
/clients/{id}/edit	POST	Process client update
/clients/{id}/delete	GET	Delete client


**Acknowledgments**
Spring Boot Team
Bootstrap Team
Thymeleaf Community


**ScreenShots**

![WhatsApp Image 2025-02-03 at 08 41 02_791699a0](https://github.com/user-attachments/assets/386b80bd-70ac-4122-8937-6149002e640c)

![WhatsApp Image 2025-02-03 at 08 41 27_74875199](https://github.com/user-attachments/assets/e2a9a7da-82c1-4f56-bb28-acd1d0741891)


![WhatsApp Image 2025-02-03 at 08 41 47_6fbf09e8](https://github.com/user-attachments/assets/fb62a3f2-2831-4d33-b065-3df6b962c91d)


![WhatsApp Image 2025-02-03 at 08 42 16_96300dd9](https://github.com/user-attachments/assets/4f4c5418-c05a-4dc8-a6e5-6b5f869b5312)


![WhatsApp Image 2025-02-03 at 08 43 12_c88f63f5](https://github.com/user-attachments/assets/6cd73ea8-16db-4f7d-b82e-95707b8dad42)



















   
