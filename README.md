How the flow works at backend 
controller sends request to Service then Service sends request to Repository then Repository sends request to DB and then the user gets it response
Flow Diagram : Controller → Service → Repository → DB


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
-> Scalibility
-> Feature Set
-> Ecosystem and Tools
-> Durability

What is a Monolithic architecture?
Monolithic architectures is a design where all the components of an application are interconnected and interdependent
Problems : -> Difficult to Implement Changes
           -> Lack of Scalibility
           -> Long term Commitment to a single Technology Stack
           -> Application Complexity and Its Effect on Development and Deployment
           -> Slowing Down of IDEs
           -> Increased Application Start Time
           -> Large Project Size
           -> Deploying for Small Changes
           -> Team Collaboration and Autonomy

What is Microservices?
It structures an application as a collection of small autonomous services.
Principles: -> Single Responsibility 
            -> Independence
            -> Decentralization
            -> Failure Isolation
            -> Continuous Delivery/Deployment
Advantages: -> Scalibility
            -> Flexibility
            -> Simplicity
