# ⚙️ Image & Container Commands

## 📥 Pull Image

```bash id="m1"
docker pull mysql:8.0
```

---

## 📋 List Images

```bash id="m2"
docker images
```

---

## 🚀 Run Container

```bash id="m3"
docker run -d --name mysql-container \
-e MYSQL_ROOT_PASSWORD=root123 \
mysql:8.0
```

---

## 📋 Running Containers

```bash id="m4"
docker ps
```

---

## 📋 All Containers

```bash id="m5"
docker ps -a
```

---

## 🛑 Stop Container

```bash id="m6"
docker stop mysql-container
```

---

## ▶️ Start Container

```bash id="m7"
docker start mysql-container
```

---

## ❌ Remove Container

```bash id="m8"
docker rm mysql-container
```

---

## 🧹 Remove Image

```bash id="m9"
docker rmi mysql:8.0
```

---

## 🖥️ Access MySQL Container

```bash id="m10"
docker exec -it mysql-container mysql -u root -p
```
