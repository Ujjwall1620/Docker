# 🚀 Spring Boot + MySQL Docker Network Project

This project demonstrates how to connect a **Spring Boot application** with a **MySQL database** using **Docker containers and a custom bridge network**.

---

## 🧠 Project Overview

The main goal of this project is to:

* Run MySQL in a Docker container
* Containerize a Spring Boot application
* Connect both containers using a custom Docker network
* Enable seamless communication without using docker-compose

---

## ⚙️ Tech Stack

* Java 21
* Spring Boot
* MySQL
* Docker

---

## 🏗️ Architecture

```text
Spring Boot Container  --->  MySQL Container
         (my-network)
```

* Both containers are connected via a **custom Docker network**
* Communication is done using **container names**
* No `localhost` is used inside containers

---

## 🚀 How It Works

1. A custom Docker network is created
2. MySQL container is connected to the network
3. Spring Boot application is containerized
4. Spring Boot connects to MySQL using:

```properties
jdbc:mysql://mysql-container:3306/testdb
```

---

## 📦 Setup Instructions

### 1. Create Network

```bash
docker network create my-network
```

### 2. Run MySQL Container

```bash
docker run -d \
  --name mysql-container \
  --network my-network \
  -e MYSQL_ROOT_PASSWORD=root \
  -e MYSQL_DATABASE=testdb \
  mysql
```

### 3. Build Application

```bash
mvn clean package -DskipTests
```

### 4. Build Docker Image

```bash
docker build -t springboot-app .
```

### 5. Run Spring Boot Container

```bash
docker run -d \
  --name springboot-app \
  --network my-network \
  -p 8080:8080 \
  springboot-app
```

---

## ⚠️ Challenges Faced

### 1. Docker Build Failure (Tests)

* Spring Boot tests tried to connect to the database
* Database was not available during build

**Solution:**

```bash
mvn clean package -DskipTests
```

---

### 2. Database Connection Issue

* Using `localhost` inside container failed

**Solution:**

```text
Use container name (mysql-container)
```

---

### 3. Port Conflict

* Port 3306 already in use

**Solution:**

```bash
-p 3307:3306
```

---

## 🧠 Key Learnings

* Docker containers are isolated environments
* `localhost` does not work across containers
* Docker networks enable communication
* Container name works as hostname
* Tests can fail during build if dependencies are missing

---

## 🔍 Verification

```bash
docker ps
docker logs springboot-app
docker network inspect my-network
```

---

## 🚀 Future Improvements

* Use Docker Compose
* Add environment variables
* Add proper testing setup (H2 or test containers)

---

## 👨‍💻 Author

Ujjwal
