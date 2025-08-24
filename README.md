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
