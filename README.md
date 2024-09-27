# Spring Cloud

## How To Run
1. Execute database query
   - init_database.txt
2. Configure database
   - ms-school-study : src/main/resources/application.yml
   - ms-school-user : src/main/resources/application.yml
3. Running the program
   - ms-school-eureka
   - ms-school-user
   - ms-school-study
   - ms-school-apigateway

## Sample Request
1. ms-school-user
    - USER
      - Create user : POST /api/users
          ```json
         {
           "username": "johndoe",
           "email": "john.doe@example.com",
           "password": "P@ssw0rd"
         }
          ```
      - Update User : PUT /api/users/{id}
          ```json
         {
            "username": "johnupdated",
            "email": "john.updated@example.com",
            "password": "NewP@ssw0rd"
         }
          ```
    - ROLE

## Access resources
Base URL : http://localhost:9080
ms-school-user : http://localhost:9080/api/v1/user
ms-school-study : http://localhost:9080/api/v1/study

## Access swagger docs via API Gateway
Base URL : http://localhost:9080/swagger-ui.html

    
