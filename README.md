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
      ### **Role Service Request:**
      
      #### 1. **Create Role**
      - **Endpoint**: `POST /api/roles`
        - **Request Body**:
      ```json
      {
        "roleName": "ADMIN"
      }
      ```
      
      #### 2. **Update Role**
      - **Endpoint**: `PUT /api/roles/{id}`
        - **Request Body**:
      ```json
      {
        "roleName": "USER"
      }
      ```
      
      #### 3. **Get Role by ID**
      - **Endpoint**: `GET /api/roles/{id}`
      
      #### 4. **Delete Role**
      - **Endpoint**: `DELETE /api/roles/{id}`
      
      ### **User Service Request:**
      
      #### 1. **Create User**
      - **Endpoint**: `POST /api/users`
        - **Request Body**:
      ```json
      {
        "username": "johndoe",
        "email": "john.doe@example.com",
        "password": "P@ssw0rd"
      }
      ```
      
      #### 2. **Update User**
      - **Endpoint**: `PUT /api/users/{id}`
        - **Request Body**:
      ```json
      {
        "username": "johnupdated",
        "email": "john.updated@example.com",
        "password": "NewP@ssw0rd"
      }
      ```
   
      #### 3. **Get User by ID**
      - **Endpoint**: `GET /api/users/{id}`
      
      #### 4. **Delete User**
      - **Endpoint**: `DELETE /api/users/{id}`

## Access resources
Base URL : http://localhost:9080
ms-school-user : http://localhost:9080/api/v1/user
ms-school-study : http://localhost:9080/api/v1/study

## Access swagger docs via API Gateway
Base URL : http://localhost:9080/swagger-ui.html

    
