# Gamer Registration System

## Overview

This Java application was developed to manage registrations for a gaming competition hosted by SANCGA (South African National Computer Gamers Association). The system demonstrates key Object-Oriented Programming concepts including inheritance, polymorphism, interfaces, sorting, serialization, and exception handling.

The application supports the registration of both Amateur and Professional gamers, automatically generates registration codes, calculates registration fees and discounts, validates ID numbers, and stores gamer information for later retrieval.

## Features

* Register Amateur and Professional gamers
* Generate unique registration codes
* Calculate registration fees and discounts
* Store different gamer types in a single array using polymorphism
* Sort gamers by ID number using Arrays.sort()
* Serialize and deserialize gamer objects
* Custom exception handling for invalid ID numbers
* File input processing

## Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Inheritance
* Polymorphism
* Abstract Classes
* Interfaces
* Arrays and Sorting
* File Handling
* Serialization
* Custom Exceptions

## Project Structure

```text
src/
│
├── Gamer.java
├── AmGamer.java
├── ProGamer.java
├── FeeCalculator.java
├── InvalidIdException.java
│
├── GamerApplication.java
├── GamerTest.java
│
├── gamers.txt
├── invalid.txt
└── gamers.ser
```

## Concepts Demonstrated

### Inheritance and Polymorphism

* Abstract Gamer superclass
* AmGamer subclass
* ProGamer subclass
* Shared behavior through inheritance
* Polymorphic storage in a single array

### Sorting

* Gamers sorted by ID number
* Comparable interface implementation
* Arrays.sort() usage

### Serialization

* Save gamer objects to a .ser file
* Restore objects through deserialization

### Exception Handling

* Custom InvalidIdException
* Validation of ID length
* Validation of numeric format
* Robust try-catch handling

## Learning Outcomes

This project demonstrates:

* Object-Oriented Design
* Class Relationships
* Data Validation
* File Processing
* Sorting Algorithms
* Serialization
* Exception Handling
* Code Reusability and Maintainability

## Author

### Thusano Masalesa

Technology Student focused on continuous learning, skill growth, and exploring different areas in tech.

### Connect With Me

* LinkedIn: www.linkedin.com/in/thusano-masalesa-b4744a3a2
* GitHub: github.com/thuskijpeg

## License

This project was developed for educational purposes as part of academic coursework and practical application of Java programming concepts.
