How the flow works at backend 
controller sends request to Service then Service sends request to Repository then Repository sends request to DB and then the user gets it response
Flow Diagram : Controller → Service → Repository → DB

What does API(Application Programming Interface) mean?
Set of rules and protocols that allow one software appilication to interact and communicate with another

Docker Commands
1) docker pull <image>
2) docker push <username/image>
3) docker run -it -d -p <host-port>:<container-port> --name <name> <image>
4) docker stop <container-id/container-name>
5) docker start <container-id/container-name>
6) docker rm <container-id/container-name>
7) docker rmi <image-id/image-name>
8) docker ps
9) docker ps -a
10) docker images
11) docker exec -it <container-id/container-name> bash
12) docker build -t <username/image>
13) docker logs <container-name/container-id>
14) docker inspect <container-name/container-id>

Why postgreSQL over H2?
1) Scalibility
2) Feature Set
3) Ecosystem and Tools
4) Durability

What is a Monolithic architecture?
Monolithic architectures is a design where all the components of an application are interconnected and interdependent

Problems : 
1) Difficult to Implement Changes
2) Lack of Scalibility
3) Long term Commitment to a single Technology Stack
4) Application Complexity and Its Effect on Development and Deployment
5) Slowing Down of IDEs
6) Increased Application Start Time
7) Large Project Size
8) Deploying for Small Changes
9) Team Collaboration and Autonomy

What is Microservices?
It structures an application as a collection of small autonomous services.

Principles: 
1) Single Responsibility 
2) Independence
3) Decentralization
4) Failure Isolation
5) Continuous Delivery/Deployment
   
Advantages:
1) Scalibility
2) Flexibility
3) Simplicity

Inter-service Communication : It is the communication between each independent service so that they can work together as a single application.
Ways to implement are:
1) Synchronous Communication
2) Asynchronous Communication

Service Registry : It is used in microservices architectures to enable dynamic service discovery

working : The service registry let the services register on it and the services can send a request to find that service so we can avoid hard coding using urls

Benefits :
1) Dynamic Service Discovery
2) Load Balancing
3) Fault Tolerance and Resilience
4) Scalability and Elasticity
5) Service Monitoring and Health Checks

Feign : It is a declarative web service client designed to make writing HTTP clients easier

Advantages:
1) Ease of use
2) Integration with Eureka
3) Built-in Load Balancing with Ribbon
4) Support for FallBacks and Circuit Breakers

Distributed Tracing : It enables you to trace your request from start to end.

Problems solved:
1) Request Visualization
2) Identity Performance Bottlenecks
3) Error Analysis and Debugging
4) Tracking Dependency
5) Performance Optimization

Zipkin: It is an open-source distributed tracing system

Micrometer : It provides insights that help you keep tabs on your application's performance

Configuration Management : Simply means managing and controlling the configurations of each microservice in the system

Features : 
1) Centralized and Versioned Configuration
2) Dynamic Updates
3) Security
4) Application and Profile Specific Configuration

Benefits/advantages :
1) Single source of truth
2) Easier to manage and update configurations
3) Enhances security and control
4) Easy to deploy and scale microservices 

Spring Cloud Config Server : It is part of the Spring Cloud project,a suite of tools specifically designed for building and managing cloud-native applications.

Features:
1) Storing Configurations
2) Serving Configurations
3) Refreshing Configurations
4) Easy integration with Spring Boot
5) Support for different environments
6) Encryption and Decryption

API Gateway : Is is the enterpoint for user to interact with all microservices as for a user the application is a whole thing and is not distributed in microservices so api gateway solves this issue and act as the entrypoint of the application.

Advantages:
1) It encapsulates the internal system architecture
2) Handle cross-cutting concerns like security,load balancing,rate limiting,and analytics
3) Can authenticate incoming requests and pass only valid requests to the services
4) Can aggregate responses from different microservices

Capabilities:
1) Request Routing
2) Load Balancing
3) Authentication and Authorization
4) Rate Limiting
5) Request and Response Transformation
6) Aggregation of Data from Multiple Services

Fault Tolerance : Ability to continue operating without interruption

Necessities : 
1) Fault Isolation
2) Network Latency
3) Deployment issues
4) Increased Complexity
5) Elasticity
6) Tolerating External Failures

Resilience : Ability or capacity to recover quickly from difficulties

Techniques :
1) Retries
2) Rate Limiting
3) Bulkheads
4) Circuit Breakers
5) Fallbacks
6) Timeouts
7) Graceful Degradation

Resilience4j : it is a lightweight,easy-to-use fault tolerance library

Resilience4j Modules :
1) Retry Module
2) RateLimiter
3) Bulkhead
4) CircuitBreaker


Rate Limiting: Rate limiting is a technique for limiting network traffic

Importance :
1) Preventing Abuse
2) Resource Allocation
3) Cost Management

Uses:
1) API's
2) Web Scraping
3) Login Attempts
