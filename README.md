![Presentation slide](md-resources/presentation.png?raw=true "")

# ANZ Wholesale Engineering - Sample Project
The application provides the backend layer to support UI functionality to display accounts that belong to a user and to display transactions made for a specific account.
The application is implemented using latest spring boot frameworks and components. The application is deployed into AWS cloud infrastructure and the endpoints are available to be consumed directly using the links mentioned further in this document. This spring boot application can also be started locally.

## How to run the application locally
1. Ensure Java is present in the machine. For development OpenJDK 11 is used
2. Download/clone this repository
3. Create the application JAR file using `./mvnw package`
4. Run the application `java -jar target/wholesale-engineering-demo-0.0.1-SNAPSHOT.jar`
5. All the endpoints mentioned above will now be available with address `http://localhost:8080`

## Accessing the application endpoints

| Description                    | Direct endpoint                                                                     | Localhost endpoint                                                    |
| ------------------------------ | ----------------------------------------------------------------------------------- | --------------------------------------------------------------------- |
| User accounts                  | https://anzwholesale.learnerdev.com/users/1/accounts                                | http://localhost:8080/users/1/accounts                                |
| Account transactions           | https://anzwholesale.learnerdev.com/accounts/a1/transactions                        | http://localhost:8080/accounts/a1/transactions                        |
| Swagger UI                     | https://anzwholesale.learnerdev.com/swagger-ui/#/                                   | http://localhost:8080/swagger-ui/#/                                   |
| Swagger JSON spec              | https://anzwholesale.learnerdev.com/v2/api-docs                                     | http://localhost:8080/v2/api-docs                                     |
| Accounts with page options     | https://anzwholesale.learnerdev.com/users/1/accounts?page=1&size=2                  | http://localhost:8080/users/1/accounts?page=1&size=2                  |
| Transactions with page options | https://anzwholesale.learnerdev.com/accounts/a1/transactions?page=1&size=5          | http://localhost:8080/accounts/a1/transactions?page=1&size=5          |
| Transaction type filter        | https://anzwholesale.learnerdev.com/accounts/a1/transactions?transactionType=Credit | http://localhost:8080/accounts/a1/transactions?transactionType=Credit |

## AWS Deployment steps using aws-cli, docker and mvn
The steps are documented here just to showcase my skills in AWS and need not be performed to access direct URLs mentioned above.
1. Get AWS ECR credentials `aws ecr get-login-password --region ap-southeast-2 | docker login --username AWS --password-stdin ${AWSAccountNumber}.dkr.ecr.ap-southeast-2.amazonaws.com`
2. Package the application `./mvnw package`
3. Build `docker build -t wholesale-engineering-demo .`
4. Tag `docker tag wholesale-engineering-demo:latest ${AWSAccountNumber}.dkr.ecr.ap-southeast-2.amazonaws.com/wholesale-engineering-demo:latest`
5. Push image to ECR `docker push ${AWSAccountNumber}.dkr.ecr.ap-southeast-2.amazonaws.com/wholesale-engineering-demo:latest`
6. Update service to spin up 1 task `aws ecs update-service --cluster anz-wholesale-demo --service backend --force-new-deployment --desired-count 1`
7. Update service to ramp down to 0 task `aws ecs update-service --cluster anz-wholesale-demo --service backend --force-new-deployment --desired-count 0`


