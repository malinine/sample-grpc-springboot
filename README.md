# sample-grpc-springboot
For learning the basics of building Microservice using the Spring Boot framework with gRPC.

**prerequisite** <br/>
+ Java 17 <br/>
+ Spring Boot 2.7.13 <br/>
+ Postman <br/>

**How to run project** <br/>
+ Intellij <br/>

1. Go to **Proto** module and load dependencies then double click compile
![Screenshot 2566-06-26 at 17 14 49](https://github.com/malinine/sample-grpc-springboot/assets/11505428/36a3f011-022a-450e-8b73-a2417eea1d66)

2. For **Student-service** , **Course-service** and **Aggregator-service** , Go to individual module then execute main class.
![Screenshot 2566-06-26 at 17 19 48](https://github.com/malinine/sample-grpc-springboot/assets/11505428/0ce42349-b606-4746-9406-24bddcda75ff)

+ Command line <br/>

1. Go to sample-grpc-spring-boot
```
cd sample-grpc-springboot
```
2. Run command
```
mvn clean package
```
![Screenshot 2566-06-26 at 17 25 14](https://github.com/malinine/sample-grpc-springboot/assets/11505428/b76c96d3-b6af-4338-a497-85a7a4f9abc1)

3. For **Student-service** , **Course-service** and **Aggregator-service** , cd to individual module and run command
```
mvn spring-boot:run
```
![Screenshot 2566-06-26 at 17 28 48](https://github.com/malinine/sample-grpc-springboot/assets/11505428/f1a67960-7ca6-4ee8-8653-bc4c0c10c794)

**How to test** <br/>

Call API using Postman
+ GET /student/{name}
+ PUT /student <br/>
```
Request body

{
    "name" : "thee",
    "level" : "advanced"
}
```
  
