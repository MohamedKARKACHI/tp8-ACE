# tp8-ACE

# Account Management Service

A RESTful API service for managing banking accounts built with Spring Boot.

## Overview

This service provides a complete CRUD (Create, Read, Update, Delete) API for managing bank accounts. It supports both JSON and XML data formats and uses an in-memory H2 database for data persistence.

## Features

- RESTful API endpoints for account management
- Support for JSON and XML data formats
- In-memory H2 database with console access
- Spring Data JPA for data persistence
- Lombok for reducing boilerplate code
- OpenAPI/Swagger documentation support
- CORS enabled for cross-origin requests

## Technology Stack

- **Java 11**
- **Spring Boot 2.7.5**
- **Spring Data JPA**
- **H2 Database** (in-memory)
- **Lombok**
- **Maven**

## Project Structure

```
src/
├── main/
│   ├── java/
│   │   └── com/finance/management/
│   │       ├── AccountServiceApplication.java
│   │       ├── controllers/
│   │       │   └── AccountController.java
│   │       ├── entities/
│   │       │   ├── Account.java
│   │       │   └── AccountType.java
│   │       └── repositories/
│   │           └── AccountRepository.java
│   └── resources/
│       └── application.properties
└── test/
    └── java/
        └── com/finance/management/
            └── AccountServiceApplicationTests.java
```

## Getting Started

### Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

### Installation

1. Clone or download the project
2. Navigate to the project directory
3. Build the project:
   ```bash
   mvn clean install
   ```

### Running the Application

Run the application using Maven:
```bash
mvn spring-boot:run
```

The application will start on port 8080 by default.

## API Endpoints

Base URL: `http://localhost:8080/api/v1/accounts`

### Get All Accounts
- **GET** `/api/v1/accounts`
- Returns a list of all accounts
- Supports: `application/json`, `application/xml`

### Get Account by ID
- **GET** `/api/v1/accounts/{id}`
- Returns a specific account by ID
- Supports: `application/json`, `application/xml`

### Create Account
- **POST** `/api/v1/accounts`
- Creates a new account
- Request body: Account object (JSON or XML)
- Returns: Created account with 201 status

### Update Account
- **PUT** `/api/v1/accounts/{id}`
- Updates an existing account
- Request body: Account object (JSON or XML)
- Returns: Updated account

### Delete Account
- **DELETE** `/api/v1/accounts/{id}`
- Deletes an account by ID
- Returns: 200 OK or 404 Not Found

## Account Entity

```json
{
  "id": 1,
  "balance": 5000.0,
  "creationDate": "2024-01-15",
  "accountType": "CHECKING"
}
```

### Account Types
- `CHECKING` - Checking account
- `SAVINGS` - Savings account

## H2 Database Console

Access the H2 console at: `http://localhost:8080/h2-console`

- JDBC URL: `jdbc:h2:mem:accountdb`
- Username: `admin`
- Password: (leave empty)

## Example API Calls

### Create Account (JSON)
```bash
curl -X POST http://localhost:8080/api/v1/accounts \
  -H "Content-Type: application/json" \
  -d '{
    "balance": 5000.0,
    "creationDate": "2024-01-15",
    "accountType": "CHECKING"
  }'
```

### Get All Accounts
```bash
curl http://localhost:8080/api/v1/accounts
```

### Get Account by ID
```bash
curl http://localhost:8080/api/v1/accounts/1
```

### Update Account
```bash
curl -X PUT http://localhost:8080/api/v1/accounts/1 \
  -H "Content-Type: application/json" \
  -d '{
    "balance": 7500.0,
    "creationDate": "2024-01-15",
    "accountType": "SAVINGS"
  }'
```

### Delete Account
```bash
curl -X DELETE http://localhost:8080/api/v1/accounts/1
```

## Configuration

Application configuration can be modified in `src/main/resources/application.properties`:

- Server port: `server.port=8080`
- Database name: `spring.datasource.url=jdbc:h2:mem:accountdb`
- H2 console path: `spring.h2.console.path=/h2-console`

## Testing

Run tests with:
```bash
mvn test
```

## License

This project is provided as-is for educational and development purposes.

