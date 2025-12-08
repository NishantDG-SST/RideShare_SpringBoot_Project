# RideShare Backend

This is a mini Ride Sharing backend application built with Spring Boot and MongoDB. It simulates the core functionality of a ride-hailing service like Uber or Ola.

## Understanding the Task
The goal of this project was to build a backend system where:
1.  **Users (Passengers)** can register, log in, and request rides.
2.  **Drivers** can register, log in, view pending ride requests, and accept them.
3.  **Rides** go through a lifecycle: `REQUESTED` -> `ACCEPTED` -> `COMPLETED`.
4.  **Security** is handled using JWT (JSON Web Tokens) to ensure that only authorized users can access specific features (e.g., only a driver can accept a ride).

## ✅ What Has Been Implemented

### 1. User Authentication & Authorization
- **Registration**: Users can sign up as either a `PASSENGER` (ROLE_USER) or a `DRIVER` (ROLE_DRIVER).
- **Login**: Users receive a secure JWT token upon successful login.
- **Role-Based Access**:
    - Passengers can request rides and view their history.
    - Drivers can view requests and accept rides.

### 2. Ride Management
- **Request a Ride**: Passengers can create a ride request by specifying pickup and drop locations.
- **View Requests**: Drivers can see a list of all available (pending) rides.
- **Accept Ride**: A driver can accept a ride, which assigns them to it and updates the status to `ACCEPTED`.
- **Complete Ride**: The driver (or passenger) can mark the ride as `COMPLETED` once the trip is over.

### 3. Security & Validation
- **JWT Filter**: Every request is checked for a valid token.
- **Input Validation**: Ensures that required fields (like username, password, locations) are not empty.
- **Ownership Checks**: Added logic to ensure that only the specific driver or passenger involved in a ride can mark it as completed.

### 4. Error Handling
- **Global Exception Handler**: Provides clear and consistent error messages (e.g., "User not found", "Ride not available") instead of crashing or showing technical jargon.

## Test Results
Detailed input and output examples for all API endpoints can be found in the **[api_test_results.md](api_test_results.md)** file. This file documents the successful execution of:
- User/Driver Registration
- Login Flow
- Ride Creation, Acceptance, and Completion
- Status Verification

## How to Run
1.  Ensure MongoDB is running on `localhost:27017`.
2.  Run the application:
    ```bash
    ./mvnw spring-boot:run
    ```
3.  The server will start on `http://localhost:8081`.
