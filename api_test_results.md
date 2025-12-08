# API Input and Output Documentation

Here are the inputs and actual outputs from the end-to-end testing of the RideShare Backend.

## 1. Register User
**Request:**
`POST http://localhost:8081/api/auth/register`
```json
{
  "username": "john_doe_2",
  "password": "password123",
  "role": "ROLE_USER"
}
```
**Output:**
```text
User registered successfully
```

## 2. Register Driver
**Request:**
`POST http://localhost:8081/api/auth/register`
```json
{
  "username": "driver_mike_2",
  "password": "password123",
  "role": "ROLE_DRIVER"
}
```
**Output:**
```text
User registered successfully
```

## 3. Login User
**Request:**
`POST http://localhost:8081/api/auth/login`
```json
{
  "username": "john_doe_2",
  "password": "password123"
}
```
**Output:**
```json
{
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2huX2RvZV8yIiwicm9sZSI6IlJPTEVfVVNFUiIsImlhdCI6MTc2NTA5ODQ2NCwiZXhwIjoxNzY1MTg0ODY0fQ.x4_SXz-_5-abMXp2_AfDGsB2jgZVOkUbJE5QfhadYlUX_S_B_enRdQYQufiHbtUiW0uoidT891h_DMiLZN9Lfw"
}
```

## 4. Login Driver
**Request:**
`POST http://localhost:8081/api/auth/login`
```json
{
  "username": "driver_mike_2",
  "password": "password123"
}
```
**Output:**
```json
{
  "token": "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkcml2ZXJfbWlrZV8yIiwicm9sZSI6IlJPTEVfRFJJVkVSIiwiaWF0IjoxNzY1MDk4NDY0LCJleHAiOjE3NjUxODQ4NjR9.hjpQ8lbrIdQfAzZyoA6byzHlXbFbGSpltebVXdpBQdjwrW78NTYfRQr4uiPinSXjR5s1rvD6cRtteQVilWoCjg"
}
```

## 5. Create Ride (User)
**Request:**
`POST http://localhost:8081/api/v1/rides`
*Header:* `Authorization: Bearer <USER_TOKEN>`
```json
{
  "pickupLocation": "Koramangala",
  "dropLocation": "Indiranagar"
}
```
**Output:**
```json
{
  "id": "693543e17f9853664b26ddc1",
  "userId": "69349e97e9f8c40304e36e17",
  "driverId": null,
  "pickupLocation": "Koramangala",
  "dropLocation": "Indiranagar",
  "status": "REQUESTED",
  "createdAt": "2025-12-07T09:07:45.012+00:00"
}
```

## 6. Get User Rides
**Request:**
`GET http://localhost:8081/api/v1/user/rides`
*Header:* `Authorization: Bearer <USER_TOKEN>`
**Output:**
```json
[
  {
    "id": "693543e17f9853664b26ddc1",
    "userId": "69349e97e9f8c40304e36e17",
    "driverId": null,
    "pickupLocation": "Koramangala",
    "dropLocation": "Indiranagar",
    "status": "REQUESTED",
    "createdAt": "2025-12-07T09:07:45.012+00:00"
  }
]
```

## 7. Get Pending Rides (Driver)
**Request:**
`GET http://localhost:8081/api/v1/driver/rides/requests`
*Header:* `Authorization: Bearer <DRIVER_TOKEN>`
**Output:**
```json
[
  {
    "id": "693543e17f9853664b26ddc1",
    "userId": "69349e97e9f8c40304e36e17",
    "driverId": null,
    "pickupLocation": "Koramangala",
    "dropLocation": "Indiranagar",
    "status": "REQUESTED",
    "createdAt": "2025-12-07T09:07:45.012+00:00"
  }
]
```

## 8. Accept Ride (Driver)
**Request:**
`POST http://localhost:8081/api/v1/driver/rides/693543e17f9853664b26ddc1/accept`
*Header:* `Authorization: Bearer <DRIVER_TOKEN>`
**Output:**
```json
{
  "id": "693543e17f9853664b26ddc1",
  "userId": "69349e97e9f8c40304e36e17",
  "driverId": "69349e98e9f8c40304e36e18",
  "pickupLocation": "Koramangala",
  "dropLocation": "Indiranagar",
  "status": "ACCEPTED",
  "createdAt": "2025-12-07T09:07:45.012+00:00"
}
```

## 9. Complete Ride (Driver)
**Request:**
`POST http://localhost:8081/api/v1/rides/693543e17f9853664b26ddc1/complete`
*Header:* `Authorization: Bearer <DRIVER_TOKEN>`
**Output:**
```json
{
  "id": "693543e17f9853664b26ddc1",
  "userId": "69349e97e9f8c40304e36e17",
  "driverId": "69349e98e9f8c40304e36e18",
  "pickupLocation": "Koramangala",
  "dropLocation": "Indiranagar",
  "status": "COMPLETED",
  "createdAt": "2025-12-07T09:07:45.012+00:00"
}
```

## 10. Verify Ride Status (User)
**Request:**
`GET http://localhost:8081/api/v1/user/rides`
*Header:* `Authorization: Bearer <USER_TOKEN>`
**Output:**
```json
[
  {
    "id": "693543e17f9853664b26ddc1",
    "userId": "69349e97e9f8c40304e36e17",
    "driverId": "69349e98e9f8c40304e36e18",
    "pickupLocation": "Koramangala",
    "dropLocation": "Indiranagar",
    "status": "COMPLETED",
    "createdAt": "2025-12-07T09:07:45.012+00:00"
  }
]
```
