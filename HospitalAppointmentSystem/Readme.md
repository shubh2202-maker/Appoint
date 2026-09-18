# Hospital Appointment System

## Project Overview

The Hospital Appointment System is a command-line based Java application designed to manage basic hospital operations.

The system provides separate modules for managing patients, doctors, appointments, billing, and reports. Data is stored in text files so that records remain available even after the application is closed.

## Features

### 1. Patient Management
- Add new patients
- View all patients
- Search patients using Patient ID
- Update patient information
- Delete patient records
- Prevent duplicate Patient IDs

### 2. Doctor Management
- Add new doctors
- View all doctors
- Search doctors using Doctor ID
- Update doctor information
- Delete doctor records
- Prevent duplicate Doctor IDs

### 3. Appointment Management
- Book appointments
- View all appointments
- Search appointments
- Cancel appointments
- Prevent duplicate Appointment IDs
- Prevent booking the same doctor at the same date and time

### 4. Billing
- Generate bills
- Automatically use consultation fee from a booked doctor's appointment
- Add medicine charges
- Add test charges
- Calculate total bill amount
- View all bills
- Search bills

### 5. Reports
- Patient report
- Doctor report
- Appointment report
- Billing report
- Hospital summary

## Technologies Used

- Java
- Java Collections Framework
- Java File I/O
- Java Time API
- Object-Oriented Programming
- Command Line Interface
- Git and GitHub

## Project Structure

```text
HospitalAppointmentSystem/
│
├── src/
│   ├── model/
│   │   ├── Patient.java
│   │   ├── Doctor.java
│   │   ├── Appointment.java
│   │   └── Bill.java
│   │
│   ├── service/
│   │   ├── PatientService.java
│   │   ├── DoctorService.java
│   │   ├── AppointmentService.java
│   │   └── BillService.java
│   │
│   ├── storage/
│   │   └── FileManager.java
│   │
│   └── Main.java
│
├── tests/
│   └── TestRunner.java
│
├── data/
│   ├── Patient.txt
│   ├── Doctor.txt
│   ├── Appointment.txt
│   └── Bill.txt
│
├── out/
│
└── README.md

Requirements

To run this project, the following are required:

Java Development Kit (JDK)
Command Prompt / Terminal
Git (optional, for cloning the repository)

How to Run
Step 1: Clone the Repository

//git clone YOUR_GITHUB_REPOSITORY_URL

Move into the project directory:

//cd HospitalAppointmentSystem

Step 2: Compile the Project

Run the following command from the project root:

javac -d out src/model/*.java src/storage/*.java src/service/*.java src/Main.java

Step 3: Run the Application

java -cp out Main

Running Tests

The project includes an automated test runner for checking the main functionality.

Compile the project and tests:
javac -d out src/model/*.java src/storage/*.java src/service/*.java src/Main.java tests/TestRunner.java

Run the test runner:
java -cp out TestRunner

The test runner checks:

Patient operations
Doctor operations
Appointment booking
Appointment searching
Appointment cancellation
Appointment time-slot conflict
Bill generation
Bill calculation
Duplicate ID handling

The current test suite contains 23 tests, with all 23 tests passing successfully.

Data Storage

The application uses text files for persistent storage.

The following files are used:

data/Patient.txt
data/Doctor.txt
data/Appointment.txt
data/Bill.txt

Each record is stored using the | character as a separator.

Example:

P001|Rahul|25|Male|9876543210

The application automatically creates the data directory when required.

Object-Oriented Concepts Used

The project demonstrates several Java Object-Oriented Programming concepts:

Encapsulation

Class data members are declared private and accessed using public methods.

Classes and Objects

Separate classes represent patients, doctors, appointments, and bills.

Abstraction

Service classes handle application operations while the main class handles user interaction.

Constructors

Constructors are used to initialize objects with required information.

Method Overriding

The toString() method is overridden in model classes to provide readable object information.

Association

Appointments connect patients and doctors using their respective IDs.

Validation and Error Handling

The application performs several validations, including:

Duplicate Patient ID detection
Duplicate Doctor ID detection
Duplicate Appointment ID detection
Duplicate Bill ID detection
Patient existence validation
Doctor existence validation
Appointment time-slot conflict detection
Date and time format validation
Numeric input validation

File-related errors are handled using Java exception handling.

Testing

An automated TestRunner class was created to verify the functionality of the application.

Test Result
Tests Passed : 23
Tests Failed : 0
Total Tests  : 23

ALL TESTS PASSED!
Future Enhancements

The following features can be added in future versions:

Graphical User Interface
Database integration using MySQL
User authentication
Doctor availability schedules
Patient medical history
Prescription management
Advanced reporting
Online appointment booking
Email/SMS notifications
Conclusion

The Hospital Appointment System provides a simple command-line solution for managing common hospital operations. The project demonstrates Java programming concepts including classes and objects, encapsulation, collections, file handling, exception handling, date and time APIs, and modular service-based design.

The application successfully manages patient records, doctor records, appointments, billing, and hospital reports while maintaining persistent data using text files.