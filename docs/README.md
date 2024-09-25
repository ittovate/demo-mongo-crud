# 👋 Introduction
- CRUD Demo using MongoDB on Cloud.

# ⚠ Prerequisites
Ensure the following tools are installed to run the project smoothly:
- **Java 21.0.3**: Required to build and run the Spring Boot applications.
- **Apache Maven 3.9.8**: Used for dependency management and building the project.
- **Spring Boot 3.3.3**: Framework for building the Kafka producer and consumer demos.
- MongoDB account and a cluster.

# ⚡ Running the Project
1. **Clone the repository**:
   ```
   git clone https://github.com/ittovate/mongodb-crud
   ```
2. **Navigate to the project directory**:
   ```
   cd mongodb-crud
   ```
3. **Setup environmnet variables**:
   1. Duplicate `src/main/resources/keys.env` file.
   2. Rename the copy to `.env` and replace placeholders with your values.
5. **Build and run the project**:
   ```
   mvn clean install spring-boot:run
   ```
6. **Stop the service**: After testing, stop the project using hotkey `CTRL + C`.
