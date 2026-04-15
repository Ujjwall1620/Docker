# 🧪 MySQL Container Practice

## 🚀 Step 1: Run MySQL Container

```bash id="p1"
docker run -d --name mysql-container \
-e MYSQL_ROOT_PASSWORD=root123 \
mysql:8.0
```

---

## 🔍 Step 2: Verify

```bash id="p2"
docker ps
```

---

## 🔐 Step 3: Login into MySQL

```bash id="p3"
docker exec -it mysql-container mysql -u root -p
```

Password: root123

---

## ❌ Error Faced

### Error:

unknown shorthand flag: 'e'

### Reason:

Wrong command order

---

## ✅ Fix

Correct command:

```bash id="p4"
docker run -e MYSQL_ROOT_PASSWORD=root123 mysql
```

---

## 🧠 Learnings

* Correct command syntax is important
* Container runs in isolated environment
* Environment variables required for MySQL
* `docker exec` helps access container

---

## 🎯 Outcome

Successfully created and accessed MySQL container using Docker
