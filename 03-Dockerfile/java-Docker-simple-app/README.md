# 🚀 Spring Boot Dockerized Application (Multi-Stage Build)

This project demonstrates how to build and run a **Spring Boot application using Docker** with a **multi-stage Dockerfile**.

---

## 📁 Project Structure

```
03-dockerfile/
└── demo/
    ├── Dockerfile
    ├── src/
    ├── pom.xml
    └── README.md
```

---

## 🐳 What is This Dockerfile Doing?

This Dockerfile uses a **multi-stage build** approach:

👉 Stage 1 → Build the JAR using Maven
👉 Stage 2 → Run the JAR using a lightweight JDK image

---

## 🧱 Dockerfile Explanation

### 🔹 Stage 1: Build the Application

```dockerfile
FROM maven:3.9.4-eclipse-temurin-21 AS build
```

* Uses Maven + JDK image
* This stage is used to **build the project**

```dockerfile
WORKDIR /app
```

* Sets working directory inside container

```dockerfile
COPY . .
```

* Copies entire project (src + pom.xml)

```dockerfile
RUN mvn clean package
```

* Builds the project
* Generates `.jar` file inside `/target`

---

### 🔹 Stage 2: Run the Application

```dockerfile
FROM eclipse-temurin:25-jdk
```

* Lightweight JDK image for running app

```dockerfile
WORKDIR /app
```

* Sets working directory

```dockerfile
COPY --from=build /app/target/*.jar app.jar
```

* Copies built JAR from **build stage**
* This is the key feature of multi-stage builds 🔥

```dockerfile
CMD ["java", "-jar", "app.jar"]
```

* Runs the Spring Boot application

---

## ⚡ Why Multi-Stage Build?

* Reduces image size
* Removes unnecessary build tools (like Maven)
* More secure & optimized

---

## ⚙️ How to Build and Run

### 🔨 Step 1: Build Docker Image

```bash
docker build -t springboot-app .
```

---

### ▶️ Step 2: Run Container

```bash
docker run -d -p 8080:8080 --name springboot-container springboot-app
```

---

### 📋 Step 3: Check Running Container

```bash
docker ps
```

---

### 🛑 Step 4: Stop Container

```bash
docker stop springboot-container
```

---

## 🌐 Access the Application

Open your browser:

```
http://localhost:8080
```

---

## 🧠 Important Concepts

### Multi-Stage Build

* Uses multiple `FROM`
* First stage builds app
* Second stage runs app

---

### COPY --from

* Copies files from one stage to another

---

### CMD

* Default command to run container

---

## 📌 Notes

* Make sure `pom.xml` and `src/` are present
* JAR file is auto-generated inside container
* No need to manually build JAR outside

---

## 🚀 Conclusion

This setup:

* Builds your Spring Boot app inside Docker
* Runs it in a clean, optimized environment
* Follows production-level best practices

---
