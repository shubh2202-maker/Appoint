# Hospital Appointment System — Project Statement

## Problem Statement

Hospitals manage information about patients, doctors, appointments, and billing on a continuous basis. Manual handling of these records can make searching, updating, and maintaining information difficult and may lead to duplicate records or appointment scheduling conflicts.

The Hospital Appointment System is a command-line Java application developed to provide a simple and organized way to manage these common hospital operations. The system maintains patient and doctor records, allows appointments to be booked and cancelled, generates bills, and provides summary reports. Data is persisted in text files so that records remain available after the application is restarted.

## Scope of the Project

The project covers:
- Patient record management
- Doctor record management
- Appointment booking and cancellation
- Appointment time-slot conflict checking
- Bill generation and total calculation
- Hospital reports and summary
- File-based persistent storage
- Input validation and exception handling
- Automated functional testing

The project is a CLI-based academic application. It does not currently include online booking, graphical interface, authentication, or database connectivity.

## Target Users

- Hospital reception or administrative staff
- Doctors and clinic staff
- Students learning Java and object-oriented programming
- Small clinics requiring a simple record-management prototype

## High-Level Features

### Patient Management
- Add, view, search, update, and delete patient records
- Prevent duplicate Patient IDs

### Doctor Management
- Add, view, search, update, and delete doctor records
- Store specialization and consultation fee
- Prevent duplicate Doctor IDs

### Appointment Management
- Book, view, search, and cancel appointments
- Validate patient and doctor IDs
- Prevent duplicate Appointment IDs
- Prevent two booked appointments for the same doctor at the same date and time

### Billing
- Generate, view, and search bills
- Use the consultation fee associated with a booked doctor when available
- Add medicine and test charges
- Calculate the total bill amount

### Reports
- Patient report
- Doctor report
- Appointment report
- Billing report
- Hospital summary

## Technology

- Java
- Object-Oriented Programming
- Java Collections Framework
- Java File I/O
- Java Time API
- Command Line Interface

## Project Structure

```text
HospitalAppointmentSystem/
├── src/
│   ├── model/
│   ├── service/
│   ├── storage/
│   └── Main.java
├── tests/
│   └── TestRunner.java
├── data/
├── out/
├── README.md
└── statement.md
```
