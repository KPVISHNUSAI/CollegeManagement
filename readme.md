
# College Directory Application

## Overview

The College Directory Application is a web application designed to manage various aspects of a college environment. It includes features for user authentication, profile management, course and enrollment handling, and more. The application supports different roles, including Students, Faculty Members, and Administrators, each with specific permissions.

## Technologies Used

- **Frontend**: React, HTML, CSS, JavaScript
- **Backend**: Java Spring Boot
- **Authentication**: JWT (JSON Web Tokens)
- **Database**: PostgreSQL

## Project Structure

### Backend

- **/src/main/java/com/college**
  - **/config**: Contains security configuration classes.
  - **/controller**: REST controllers for handling HTTP requests.
  - **/dto**: Data Transfer Objects for request and response payloads.
  - **/entity**: JPA entities representing database tables.
  - **/exception**: Custom exception handlers and classes.
  - **/repository**: JPA repositories for database interactions.
  - **/service**: Business logic and service classes.
  - **/util**: Utility classes like JWT utility.
  - **CollegeManagementBackendApplication.java**: Main application class.

- **/src/main/resources**
  - **application.properties** or **application.yml**: Configuration files for setting properties.
  - **data.sql**: SQL script for initializing the database.

### Frontend

- **/src**
  - **/components**: React components for various parts of the UI.
  - **/pages**: React components for different pages/views.
  - **/services**: API service functions.
  - **App.js**: Main application component.
  - **index.js**: Entry point for the React application.

## Setup

### Prerequisites

- **Java 17+** (for Spring Boot)
- **Node.js and npm** (for React frontend)
- **PostgreSQL** (or any other database supported)

### Backend Setup

1. **Clone the repository**:
   ```sh
   git clone https://github.com/yourusername/college-directory-backend.git
   cd college-directory-backend
   ```

2. **Configure the database**:
   - Update `src/main/resources/application.properties` or `application.yml` with your database connection details:
     ```properties
     spring.datasource.url=jdbc:postgresql://localhost:5432/college_directory
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     jwt.secret=your_secret_key
     jwt.expiration=3600
     ```

3. **Build and run the application**:
   ```sh
   ./mvnw clean install
   ./mvnw spring-boot:run
   ```

### Frontend Setup

1. **Clone the repository**:
   ```sh
   git clone https://github.com/yourusername/college-directory-frontend.git
   cd college-directory-frontend
   ```

2. **Install dependencies**:
   ```sh
   npm install
   ```

3. **Start the development server**:
   ```sh
   npm start
   ```

### API Endpoints

- **Authentication**:
  - POST `/api/v1/auth/login`: Login endpoint.

- **Students**:
  - GET `/api/v1/students`: Retrieve student profiles.
  - POST `/api/v1/students`: Create a new student profile.

- **Faculty Members**:
  - GET `/api/v1/faculty`: Retrieve faculty profiles.
  - POST `/api/v1/faculty`: Create a new faculty profile.

- **Administrators**:
  - GET `/api/v1/admin`: Retrieve administrator profiles.
  - POST `/api/v1/admin`: Create a new administrator profile.

- **Courses**:
  - GET `/api/v1/courses`: Retrieve course information.
  - POST `/api/v1/courses`: Create a new course.

- **Enrollments**:
  - GET `/api/v1/enrollments`: Retrieve enrollment information.
  - POST `/api/v1/enrollments`: Create a new enrollment record.


## Contact

For any inquiries, please reach out to [kpvishnusai1111@.com](mailto:kpvishnusai1111@gmail.com).
