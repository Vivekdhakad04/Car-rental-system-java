# Car Rental System

A command-line interface (CLI) based car rental management system built with Java. This application allows users to manage car rentals, customers, and rental transactions through an interactive menu system.

## Features

- **Car Management**: Add and view available cars with rental rates
- **Customer Management**: Register and manage customer information
- **Rental Operations**: Rent cars to customers with automatic cost calculation
- **Return System**: Process car returns and update availability
- **Rental History**: View complete rental transaction history
- **Data Persistence**: In-memory data storage during runtime

## Tech Stack

- **Language**: Java
- **Development Environment**: VS Code
- **Java Version**: GraalVM 17
- **Architecture**: Object-Oriented Programming (OOP)

## Project Structure

```
src/main/java/
├── Main.java              # Entry point and CLI interface
├── Car.java               # Car entity model
├── Customer.java          # Customer entity model
├── Rental.java            # Rental transaction model
└── CarRentalSystem.java   # Business logic and data management
```

## Classes Overview

- **Main**: CLI interface controller and program entry point
- **Car**: Represents car entities with properties like ID, brand, model, daily rate
- **Customer**: Manages customer information (ID, name, phone)
- **Rental**: Handles rental transactions with date management using LocalDate API
- **CarRentalSystem**: Core business logic managing collections and operations

## How to Run

```bash
# Compile all Java files
javac Main.java Car.java Customer.java Rental.java CarRentalSystem.java

# Run the application
java Main
```

## Usage

When you run the application, you'll see a menu with the following options:

1. **View Available Cars** - Display all cars available for rent
2. **Rent a Car** - Rent a car to a customer
3. **Return a Car** - Process car return using rental ID
4. **View Rental History** - Display all rental transactions
5. **Add New Car** - Register a new car in the system
6. **Add New Customer** - Register a new customer
7. **Exit** - Close the application

## Sample Data

The system comes pre-loaded with sample data:

### Cars:
- Toyota Camry (ID: C001) - $50.0/day
- Honda Accord (ID: C002) - $55.0/day
- BMW X3 (ID: C003) - $80.0/day
- Mercedes C-Class (ID: C004) - $90.0/day

### Customers:
- John Doe (ID: CUST001)
- Jane Smith (ID: CUST002)

## Key Java Concepts Demonstrated

- **Object-Oriented Programming**: Encapsulation, inheritance, abstraction
- **Collections Framework**: ArrayList, List interface
- **Exception Handling**: Input validation and error management
- **Date/Time API**: LocalDate, DateTimeFormatter
- **String Formatting**: Clean output display
- **Scanner Class**: User input handling

## Future Enhancements

- Database integration for persistent data storage
- GUI interface using JavaFX or Swing
- Advanced search and filtering options
- Late fee calculation system
- Rental reservation system

## Author

Vivek Dhakad
