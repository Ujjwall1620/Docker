# 📦 Docker Compose Setup – Spring Boot + MySQL

## 🧩 Overview

This project uses **Docker Compose** to run a multi-container application consisting of:

* A Java Spring Boot application (`java-app`)
* A MySQL database (`mysql`)

Both services are connected using a custom Docker network and are configured to communicate with each other seamlessly.

---

## 🏗️ Services Description

### 🔹 1. Java Application (`java-app`)

* Built using the local `Dockerfile`
* Runs on port **8080**
* Connects to MySQL using environment variables
* Includes a **health check** to verify if the app is running

#### Health Check

```yaml
healthcheck:
  test: ["CMD","curl", "-f", "http://localhost:8080/health"]
```

👉 This ensures the container is marked healthy only when the app is accessible.

---

### 🔹 2. MySQL Database (`mysql`)

* Uses official MySQL 8 image
* Runs on internal port **3306** (mapped to host **3307**)
* Stores data using Docker volumes
* Includes a **health check**

#### Health Check

```yaml
healthcheck:
  test: ["CMD", "mysqladmin", "ping", "-h", "localhost"]
```

👉 Ensures MySQL is ready before other services depend on it.

---

## 🔗 Service Dependency

```yaml
depends_on:
  mysql:
    condition: service_healthy
```

👉 The Java app will only start after MySQL becomes healthy.

---

## 🌐 Networking

```yaml
networks:
  my-network:
    driver: bridge
```

* Both containers are connected to the same network
* Services can communicate using service names

👉 Example:

```
jdbc:mysql://mysql:3306/testdb
```

---

## 💾 Volume Configuration

```yaml
volumes:
  mysql-data:
```

* Persists MySQL data
* Prevents data loss when containers are removed

---

## ⚙️ Environment Variables

### Java App

```yaml
SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/testdb
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=root
```

### MySQL

```yaml
MYSQL_ROOT_PASSWORD=root
MYSQL_DATABASE=testdb
```

---

## 🚀 How to Run the Project

### 1. Build and Start Containers

```bash
docker-compose up --build
```

### 2. Run in Background

```bash
docker-compose up -d
```

---

## 🛑 Stop the Project

```bash
docker-compose down
```

---

## 🔍 Accessing the Application

* Spring Boot App: [http://localhost:8080](http://localhost:8080)
* MySQL Database:

  * Host: localhost
  * Port: 3307
  * Username: root
  * Password: root

---

## ⚠️ Important Notes

* Ensure port **8080** and **3307** are not already in use
* Health checks improve reliability but may delay startup slightly
* Always use `depends_on` with health conditions for better service coordination

---

## 🎯 Benefits of This Setup

* Automated multi-container startup
* Reliable service dependency handling
* Persistent database storage
* Clean and production-like environment

---

## 🧠 Conclusion

This Docker Compose setup provides a robust and scalable way to run a **Spring Boot + MySQL** application. It ensures proper service communication, startup order, and data persistence.

---

## 🙌 Next Improvements

You can enhance this setup by:

* Adding Redis or caching layer
* Adding a frontend (React/Angular)
* Using environment-specific configurations
* Deploying to cloud using Docker

---

Happy Coding 🚀
