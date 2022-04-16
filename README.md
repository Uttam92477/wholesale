![Presentation slide](md-resources/presentation.png?raw=true "")

# ANZ Wholesale Engineering - Sample Project  
The application provides the backend layer to support UI functionality to display accounts that belong to a user and to display transactions made for a specific account.  
The application is implemented using latest spring boot frameworks and components. The application is deployed into AWS cloud infrastructure and the endpoints are available to be consumed directly using the links mentioned further in this document.  


|Description           |Direct endpoint                                                 |Localhost endpoint                                                           |
|----------------------|----------------------------------------------------------------|-----------------------------------------------------------------------------|
|User accounts         |https://anzwholesale.learnerdev.com/users/1/accounts            |http://localhost:8080/users/1/accounts                                       |
|Account transactions  |https://anzwholesale.learnerdev.com/accounts/a1/transactions    |http://localhost:8080/accounts/a1/transactions                               |
|Dashes                |`-- is en-dash, --- is em-dash`                                 |-- is en-dash, --- is em-dash                                                |
|Dashes                |`-- is en-dash, --- is em-dash`                                 |-- is en-dash, --- is em-dash                                                |



#### Swagger
Swagger UI - https://anzwholesale.learnerdev.com/swagger-ui/#/
Swagger JSON specification - https://anzwholesale.learnerdev.com/v2/api-docs

#### Application endpoints
**Accounts that belong to a user** - https://anzwholesale.learnerdev.com/users/1/accounts  
The API is **GET /users/{id}/accounts**. Data is seeded during application startup for user with ID *1*.

**Accounts that belong to a user with page options** - https://anzwholesale.learnerdev.com/users/1/accounts?pageNo=1&pageSize=2

**Transactions for a given account** - https://anzwholesale.learnerdev.com/accounts/a1/transactions  
The API is **GET /accounts/{accountNumber}/transactions**. Data is seeded during application startup for account number *a1*.

**Transactions for a given account with page options** - https://anzwholesale.learnerdev.com/accounts/a1/transactions?pageNo=1&pageSize=2  
**Transactions for a given account with transactionType** - https://anzwholesale.learnerdev.com/accounts/a1/transactions?transactionType=Credit


#### How to run the application
1. Ensure Java is present in the machine
2. Download/clone this repository
3. Create the application JAR file using `./mvnw package`
4. Run the application `java -jar target/wholesale-engineering-demo-0.0.1-SNAPSHOT.jar`
5. All the endpoints mentioned above will now be available with address `http://localhost:8080`

## Deployment steps
1. `aws ecr get-login-password --region ap-southeast-2 | docker login --username AWS --password-stdin 457259096235.dkr.ecr.ap-southeast-2.amazonaws.com`
2. `./mvnw package`
3. `docker build -t wholesale-engineering-demo .`
4. `docker tag wholesale-engineering-demo:latest 457259096235.dkr.ecr.ap-southeast-2.amazonaws.com/wholesale-engineering-demo:latest`
5. `docker push 457259096235.dkr.ecr.ap-southeast-2.amazonaws.com/wholesale-engineering-demo:latest`
6. `aws ecs update-service --cluster anz-wholesale-demo --service backend --force-new-deployment`

## TODO
1. Documentation of methods
2. Documentation in this file
3. Deploy into AWS
4. Create PPT
