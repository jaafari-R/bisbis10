# Restaurant Management System

## Overview
The bisbis10 restaurant management system is a backend service designed to handle various operations related to restaurants, their dishes, and ratings. The system aims to provide a comprehensive platform for managing restaurant data, including details about the restaurants, their cuisines, dishes, and customer ratings.

## Functionality
The system provides the following APIs:

- **Restaurants API**: Manages restaurant data.
- **Ratings API**: Manages customer ratings for restaurants.
- **Dishes API**: Manages the dishes offered by each restaurant.

## Technical Aspects
The system is built using Java Spring Boot, leveraging its robust framework for creating RESTful APIs. Data persistence can be managed using an in-memory database like H2 for simplicity, or a more robust solution like PostgreSQL for production.

## Homework Task
Candidates are expected to design and implement the above APIs, adhering to RESTful principles.

## APIs

### Restaurants APIs

| API Description               | Endpoint                                                              | Request Body                                                                  | Response Status | Response Body |
|-------------------------------|-----------------------------------------------------------------------|-------------------------------------------------------------------------------|-----------------|--------------------------------------------------------------------------------------------------------|
| Get all restaurants           | GET /restaurants?page={page}&pageSize={pageSize}                      |                                                                               | 200 OK          | [{"id": "1","name": "Taizu","averageRating" : 4.83,"isKosher" : false,"cuisines": ["Asian","Mexican","Indian"]}] |
| Get restaurants by cuisine    | GET /restaurants?cuisine={cuisine}&page={page}&pageSize={pageSize}    |                                                                               | 200 OK          | [{"id": "1","name": "Taizu","averageRating" : 4.83,"isKosher" : false,"cuisines": ["Asian","Mexican","Indian"]}] |
| Get restaurant                | GET /restaurants/{restaurantId}                                       |                                                                               | 200 OK          | {"id": "1","name": "Taizu","averageRating" : 4.83,"isKosher" : false,"cuisines": ["Asian","Mexican","Indian"],"dishes": [{"id": "1","name": "Noodles","description": "Amazing one","price": 59}]} |
| Add a restaurant              | POST /restaurants                                                     | {"name": "Taizu","isKosher": false,"cuisines": ["Asian","Mexican","Indian"]}  | 201 CREATED     | {"id": "1","name": "Taizu","averageRating" : 0.00,"isKosher" : false,"cuisines": ["Asian","Mexican","Indian"]} |
| Update a restaurant           | PUT /restaurants/{restaurantId}                                       | {"cuisines": ["Asian"]}                                                       | 200 OK          | {"id": "1","name": "Taizu","averageRating" : 4.83,"isKosher" : false,"cuisines": ["Asian"]} |
| Delete a restaurant           | DELETE /restaurants/{restaurantId}                                    |                                                                               | 204 No Content  | |

### Ratings APIs

| API Description           | Endpoint               | Request Body                          | Response Status | Response Body |
|---------------------------|------------------------|---------------------------------------|-----------------|---------------|
| Add a restaurant rating   | POST /ratings          | {"restaurantId": 2, "rating":3.3}     | 200 OK          |               |

#### Constraints Note:
rating: min = 1, max = 5

### Order APIs

| API Description           | Endpoint               | Request Body                          | Response Status | Response Body |
|---------------------------|------------------------|---------------------------------------|-----------------|---------------|
| Order    | POST /order          | {"restaurantId": 2, "orderItems":[{"dishId":12,"amount":1},{"dishId":14,"amount":1} ]}  | 200 OK          |  {orderId:"ef401fc8-d545-424b-928d-4789cd47bb6e"}             |

#### Constraints Note:
amount: min = 1 

### Dishes APIs

| API Description           | Endpoint                | Request Body                             | Response Status | Response Body                                                     |
|---------------------------|-------------------------|------------------------------------------|-----------------|------------------------------------------------------------------|
| Add a dish                | POST /restaurants/{restaurantId}/dishes | {"name":"Shakshuka","description":"Great one","price": 34} | 201 CREATED     | {"id":"2","name":"Shakshuka","description":"Great one","price": 34} |
| Update a dish             | PUT /restaurants/{restaurantId}/dishes/{dishId} | {"description":"The Best!","price": 35} | 200 OK          | {"id":"2","name":"Shakshuka","description":"The Best!","price": 35} |
| Delete a dish             | DELETE /restaurants/{restaurantId}/dishes/{dishId} |                                        | 204 No Content  |                                                                  |
| Get dishes by a restaurant| GET /restaurants/{restaurantId}/dishes?page={page}&pageSize={pageSize}  |                                         | 200 OK          | [{"id":"1","name":"Humus","description":"Good one","price": 48}] |

#### Constraints Note:
price: min = 0

## Jump Start
For your convenience, compose.yml includes Postgresql DB, the app is already pointing to this connection. In addition, you have the schema and data SQL files that can setup your DB schema and init data.

## Prerequisite
1. Java SDK (java 21) - https://www.oracle.com/java/technologies/downloads/#java21
2. Java IDE - https://www.jetbrains.com/idea/download or any other IDE
3. Docker - https://www.docker.com/products/docker-desktop/

## Instructions
1. Fork this repo to your GitHub account.
2. Clone it to your local machine.
3. You may use the compose.yml file to spin up a local PostgreSQL Docker container
4. Complete the task.
5. On completion, send your repo link to the rm-tdpisraelhomework@intl.att.com email, (a snapshot will be taken from your repo once you submit the homework). please do not update your repo after you submit the homework.
