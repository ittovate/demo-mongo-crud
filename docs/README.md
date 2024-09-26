# 👋 Introduction
- This is a CRUD demo project that demonstrates basic Create, Read, Update, and Delete (CRUD) operations using MongoDB on the cloud.
### Visual Representation
- The following video demonstrates how to interact with the application:
  - **Left window**: Using Swagger UI to perform CRUD operations.
  - **Right window**: MongoDB Compass to validate the CRUD operations visually.

<div align="center">
  <video src=https://github.com/user-attachments/assets/acdd81e7-2e88-430a-88f2-eaa99f9fda67></video>
</div>

# ⚠ Prerequisites
Before you can run the project, ensure that the following are installed:
- **Java 21.0.3**: Required to compile and run the Spring Boot application.
- **Apache Maven 3.9.8**: Manages dependencies and builds the project.
- **Spring Boot 3.3.3**: Framework for building RESTful services and connecting to MongoDB.
- **MongoDB Atlas Account**: A cloud MongoDB cluster is needed to store and retrieve data.

# ⚡ Running the Project
Follow these steps to set up and run the project:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/ittovate/mongodb-crud
   ```
2. **Navigate to the project directory**:
   ```bash
   cd mongodb-crud
   ```
3. **Set up environment variables**:
   Configure your environment variables to connect to MongoDB:
   1. Duplicate the `src/main/resources/keys.env` file.
   2. Rename the copied file to `.env`.
   3. Open `.env` and replace the placeholder with your MongoDB credentials.

4. **Build and run the project**:
   Use Maven to build the project and start the application:
   ```bash
   mvn clean install spring-boot:run
   ```
5. [Try it out!](http://localhost:8080/swagger-ui/index.html)
6. **Stop the service**:
   Once you're done testing, stop the service by pressing `CTRL + C` in the terminal.
