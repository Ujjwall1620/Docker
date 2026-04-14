# ⚙️ Docker Basic Commands

## 🔍 Check Docker version

```bash
docker --version
```

---

## 📥 Pull an image

```bash
docker pull mysql
```

👉 Downloads MySQL image from Docker Hub

---

## 🚀 Run a container

```bash
docker run mysql
```

👉 Runs a container from the image

---

## 📋 List running containers

```bash
docker ps
```

---

## 📋 List all containers (including stopped)

```bash
docker ps -a
```

---

## 🛑 Stop a container

```bash
docker stop <container_name>
```

---

## ▶️ Start a container

```bash
docker start <container_name>
```

---

## ❌ Remove a container

```bash
docker rm <container_name>
```

---

## 🧹 Remove an image

```bash
docker rmi <image_name>
```

---

## 🖥️ Execute command inside container

```bash
docker exec -it <container_name> bash
```

---

## 📜 View logs

```bash
docker logs <container_name>
```

---

## 💡 Example (MySQL container)

```bash
docker run -d --name mysql-container \
-e MYSQL_ROOT_PASSWORD=root123 \
mysql:8.0
```

---

## 🧠 Learnings

* Containers are created from images
* `docker ps` helps track running containers
* `docker exec` allows interaction inside container
* Logs help debug issues
