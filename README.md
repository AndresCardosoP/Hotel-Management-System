# Hotel Management System

## Introduction
Welcome to the Hotel Management System, a comprehensive project developed for the CSCI 3240 Web Application Development course. This system is designed using Spring Boot, Thymeleaf, HTML, CSS, and backed by an H2 database to manage hotel operations efficiently, handling rooms, bookings, customers, and services.

## Project Setup

### Prerequisites
- Java 8 or above
- Maven
- Spring Tool Suite (STS) or any preferred IDE that supports Spring Boot

### Installation
1. Clone the repository to your local machine.
2. Open the project in STS or your preferred IDE.
3. Ensure Maven dependencies are correctly downloaded and updated.
4. Run the application as a Spring Boot App.

## Running the Application from Eclipse

To run the Hotel Management System from Eclipse, follow these steps:

### Setting Up the Project
1. **Import the Project**:
    - Open Eclipse and go to `File` > `Import`.
    - Choose `Existing Maven Projects` under the `Maven` folder.
    - Browse to the location where you cloned the repository and select the project to import it into Eclipse.

2. **Resolve Maven Dependencies**:
    - Right-click on the project in the Project Explorer and select `Maven` > `Update Project`. This will download all the required dependencies specified in the `pom.xml` file.

### Running the Application
1. **Find the Main Class**:
    - Navigate to the `src/main/java` directory in the Project Explorer.
    - Locate the main application class. This class should be annotated with `@SpringBootApplication` and located in the `com.webdevuoit3230.FinalProject` package.

2. **Run the Application**:
    - Right-click on the main application class file.
    - Select `Run As` > `Spring Boot App`. Eclipse will start the Spring Boot application.

3. **Access the Web Interface**:
    - Once the application is running, open your web browser.
    - Navigate to `http://localhost:8080/` to access the Hotel Management System.

### Troubleshooting
- If you encounter issues with the project setup, ensure that your Eclipse workspace is using Java 8 or above and that Maven is correctly configured.
- For problems related to dependencies not being found, try running `Maven` > `Update Project` again and ensure your internet connection is stable.

### Accessing the Application
Once the application is running, you can access the web interface via `http://localhost:8080/`. 

## Project Structure
The project follows a structured package organization for clarity and maintainability:

- `src/main/java/com/webdevuoit3230/FinalProject`
  - `controller`: Contains controllers to handle HTTP requests.
  - `model`: Contains entity classes for the database models.
  - `repository`: Contains Spring Data JPA repository interfaces.
  - `service`: Contains service classes for business logic.
- `src/main/resources`
  - `templates`: Contains Thymeleaf templates for the frontend.
  - `static`: Contains static resources like CSS for styling.
 
![image](https://github.com/MirisanRavindran/webdevfinalproject/assets/91202768/d120fdd5-ab85-428d-b7ed-6827d13974da)
  

## Features
The system allows managing:
- **Customers**: Store and manage customer details.
- **Rooms**: Handle room details and availability.
- **Bookings**: Keep track of room bookings.
- **Services**: Manage services offered by the hotel.

## Database Configuration
This project uses H2, an in-memory database, facilitating easy setup and testing. The database is automatically configured and populated through Spring Boot's configuration properties.

## Running Tests
To run the test suite, execute the Maven test command:
```sh
mvn test
```

## Contributers
- Andres Cardoso
- Mirisan Ravindran
- Taijbir Kohli
- Jaden Ngo
