![Presentation slide](md-resources/presentation.png?raw=true "")

## Documentation
The application is deployed in AWS and available to consume via below direct links,
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
