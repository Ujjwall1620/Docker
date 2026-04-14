# 🚀 Docker 

A complete hands-on repository to learn Docker from **basics to advanced**, with real-world projects using **MySQL, Spring Boot, Kafka, and multi-container applications**.

---

## 📌 What You'll Learn

* 🐳 Docker Basics (Images, Containers)
* ⚙️ Container Lifecycle Management
* 💾 Volumes & Data Persistence
* 🌐 Docker Networking
* 🏗️ Writing Dockerfiles
* 🔗 Docker Compose (Multi-container apps)
* 🚀 Real-world Project Deployment

---

## 📂 Repository Structure

```
docker-mastery/
│
├── 01-basics/                # Docker fundamentals & commands
├── 02-images-containers/    # Running and managing containers
├── 03-volumes/              # Data persistence
├── 04-networking/           # Container communication
├── 05-dockerfile/           # Building custom images
├── 06-docker-compose/       # Multi-container setup
├── 07-multi-container-app/  # Real-world applications
├── 08-advanced/             # Advanced Docker concepts
│
└── projects/                # Production-level projects
```

---

## 🛠️ Tech Stack

* Docker
* MySQL
* Spring Boot
* Kafka
* Linux / Shell

---

## 🚀 Getting Started

### 1️⃣ Clone the repository

```bash
git clone https://github.com/<your-username>/docker-mastery.git
cd docker-mastery
```

### 2️⃣ Run a simple MySQL container

```bash
docker run -d --name mysql-container \
-e MYSQL_ROOT_PASSWORD=root123 \
mysql:8.0
```

### 3️⃣ Verify running containers

```bash
docker ps
```

---

## 💡 Key Learnings

* Containers are lightweight and portable
* Docker ensures consistent environments
* Volumes prevent data loss
* Networking enables container communication
* Docker Compose simplifies multi-service setups

---

## 🔥 Real Projects Included

* ✅ MySQL container setup
* ✅ Spring Boot + MySQL integration
* ✅ Kafka-based system (event-driven architecture)
* 🚀 Multi-container restaurant management system (in progress)

---

## ⚠️ Common Issues Covered

* Container not starting
* Port binding problems
* Environment variable mistakes
* Data loss without volumes
* Networking confusion (localhost vs container name)

---

## 🎯 Goal of This Repository

> To build a strong foundation in Docker and apply it to real-world backend systems.

---

## 🤝 Contributions

This is a personal learning repository, but suggestions and improvements are always welcome!

---

## 📬 Connect

If you're also learning Docker or backend development, feel free to connect and collaborate 🚀

---

⭐ If you find this helpful, consider giving it a star!
