![Presentation slide](md-resources/presentation.png?raw=true "")

## Assumptions

Swagger UI available at http://localhost:8080/swagger-ui/#/
Swagger JSON available at http://localhost:8080/v2/api-docs

aws ecr get-login-password --region ap-southeast-2 | docker login --username AWS --password-stdin 457259096235.dkr.ecr.ap-southeast-2.amazonaws.com
./mvnw package
docker build -t wholesale-engineering-demo .
docker tag wholesale-engineering-demo:latest 457259096235.dkr.ecr.ap-southeast-2.amazonaws.com/wholesale-engineering-demo:latest
docker push 457259096235.dkr.ecr.ap-southeast-2.amazonaws.com/wholesale-engineering-demo:latest
docker run -p 8080:8080 wholesale-engineering-demo
aws ecs update-service --cluster anz-wholesale-demo --service backend --force-new-deployment

## TODO
1. DONE- Enums - convert pending enums currency, transactionType
2. DONE - Service layer - pending TransactionService
3. DONE - Swagger
4. DONE - Pagination if time permits
5. DONE - Use projections
6. DONE - Unit tests
7. DONE - Filters basic
8. Documentation of methods
9. Documentation in this file
10. Deploy into AWS
11. Create PPT
