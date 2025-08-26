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
