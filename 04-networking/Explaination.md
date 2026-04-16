# 🧠 Docker Networking Explained (Detailed)

This document explains how Docker networking works, especially in a multi-container setup like **Spring Boot + MySQL**.

---

## 🌐 What is Docker Networking?

Docker networking allows containers to communicate with each other and with the outside world.

By default, every container runs in an **isolated environment**.
To enable communication, Docker provides different types of networks.

---

## 🔗 Types of Docker Networks

### 1. Bridge Network (Default)

* Default network created by Docker
* Containers can communicate using IP addresses
* Not ideal for scalable setups

---

### 2. Custom Bridge Network (Recommended ✅)

```bash
docker network create my-network
```

* Provides automatic DNS resolution
* Containers can communicate using **container names**
* Best for multi-container applications

---

## 🧠 How Communication Works

When two containers are on the same network:

```text
Spring Boot Container  --->  MySQL Container
         (my-network)
```

Docker automatically provides:

* Internal DNS
* Name resolution

So instead of IP, you can use:

```properties
jdbc:mysql://mysql-container:3306/testdb
```

---

## ❌ Why `localhost` Does Not Work

Inside a container:

```text
localhost = the container itself
```

So:

* `localhost` in Spring Boot container ≠ MySQL container
* It only refers to itself

👉 Therefore, we use:

```text
container-name
```

---

## 🔌 Port Mapping Explained

Example:

```bash
-p 3307:3306
```

| Part | Meaning           |
| ---- | ----------------- |
| 3307 | Host machine port |
| 3306 | Container port    |

---

### When to use port mapping?

✔ When accessing container from **host machine**

❌ Not needed for container-to-container communication

---

## 🔄 Internal vs External Communication

| Type     | Example            | Needed       |
| -------- | ------------------ | ------------ |
| Internal | springboot → mysql | Same network |
| External | browser → app      | Port mapping |

---

## 🧪 Network Inspection

```bash
docker network inspect my-network
```

Shows:

* Connected containers
* IP addresses
* Network details

---

## 🔁 Container Lifecycle & Networking

| Action             | Network Status      |
| ------------------ | ------------------- |
| Stop container     | Connection remains  |
| Start container    | Connection resumes  |
| Remove container   | Connection lost     |
| Disconnect network | Communication stops |

---

## ⚠️ Common Issues & Fixes

---

### ❌ Containers not communicating

**Cause:**

* Not on same network

**Fix:**

```bash
docker network connect my-network container-name
```

---

### ❌ Using localhost inside container

**Fix:**

```text
Use container name instead
```

---

### ❌ Port already in use

**Fix:**

```bash
-p 3307:3306
```

---

### ❌ Docker build failing (tests issue)

**Cause:**

* DB not available during build

**Fix:**

```bash
mvn clean package -DskipTests
```

---

## 🧠 Key Concepts to Remember

* Containers are **isolated systems**
* Docker network acts like a **private LAN**
* Container name = hostname
* Build phase ≠ Runtime phase
* Port mapping is only for external access

---

## 🚀 Summary

Docker networking enables seamless communication between containers using:

* Shared network
* Container names
* Internal DNS

This makes it ideal for microservices and multi-container applications.

---
