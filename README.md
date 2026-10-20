# Insurance Policy Management System

A Spring Boot based REST API application for managing customers, insurance policies, premium payments, and claims.

## Project Overview

The Insurance Policy Management System is a CRUD-based REST API application developed using Spring Boot.

The application is divided into two functional modules:

- Admin Module
- Customer Module

The system manages:

- Customer information
- Insurance policies
- Premium payments
- Insurance claims
- Basic customer login accounts

The project follows a layered architecture consisting of Controller, Service, Repository, Entity, and Exception layers.

## Objectives

- Build a CRUD-based REST API using Spring Boot.
- Understand Entity, Repository, Service, and Controller layers.
- Implement relationships between Customer, Policy, PremiumPayment, and Claim.
- Use Spring Data JPA and Hibernate for database operations.
- Store application data in MySQL.
- Provide separate Admin and Customer APIs.
- Implement basic username/password login.
- Implement request validation.
- Implement centralized exception handling.
- Test REST APIs using Postman.

## Technologies Used

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Jakarta Bean Validation
- Postman
- Git
- GitHub
- Lombok

## Architecture

The application follows a layered Spring Boot architecture:

Client / Postman
        |
        v
REST Controller Layer
        |
        v
Service Layer
        |
        v
Repository Layer
        |
        v
MySQL Database

### Layer Responsibilities

| Layer | Responsibility |
|---|---|
| Entity | Represents database tables and relationships |
| Repository | Handles database CRUD and query operations |
| Service | Contains business logic |
| Controller | Receives HTTP requests and returns responses |
| Exception | Provides centralized exception handling |

## Project Modules

### Admin Module

The Admin module provides APIs to manage:

- Customers
- Policies
- Premium Payments
- Claims

Admin operations include creating, viewing, updating, and deleting records where applicable.

### Customer Module

The Customer module allows customers to:

- View profile information
- View their policy
- View premium payment history
- Create premium payments
- View payment details
- Create claims
- View claims
- Update claim information

## Entities

The project contains the following entities:

1. Customer
2. Policy
3. PremiumPayment
4. Claim
5. LoginAccount

## Entity Relationships

```text
Customer
    |
    | 1 : 1
    v
  Policy
    |
    |----------------------|
    |                      |
    | 1 : Many             | 1 : Many
    v                      v
PremiumPayment           Claim