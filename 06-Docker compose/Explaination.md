# 📦 Docker Compose – Complete Guide (English)

## 🧩 What is Docker Compose?

Docker Compose is a tool that allows you to **manage multiple Docker containers together**.

Normally, when you run containers manually, you have to write separate `docker run` commands for each container. This becomes complex when your project includes multiple services (like Spring Boot + MySQL).

👉 Docker Compose solves this problem by letting you define everything in a single file: `docker-compose.yml`

---

## 🤔 Why Do We Need Docker Compose?

If your project is simple (only one container), you can use `docker run`.

But in real-world applications, there are usually multiple services:

* Backend (Spring Boot App)
* Database (MySQL)
* Cache (Redis)
* Frontend (React/Angular)

Without Docker Compose:

* You must run each container manually
* You need to create networks manually
* You must manage ports yourself
* Handling dependencies becomes difficult

With Docker Compose:

* Everything starts with a single command
* Configuration is defined in one place
* Easy to manage and scale

---

## 📄 What is docker-compose.yml File?

This is a YAML file where you define **all the services of your project**.

In this file, you can configure:

* Services (containers)
* Networks
* Volumes
* Environment variables
* Port mappings

---

## 🏗️ Basic Structure of docker-compose.yml

```yaml
version: '3.8'

services:
  app:
    image: your-app-image
    ports:
      - "8080:8080"

  db:
    image: mysql
    environment:
      MYSQL_ROOT_PASSWORD: root
```

---

## 🔗 How Docker Compose Works

1. You create a `docker-compose.yml` file
2. Define your services in it
3. Run the command:

```bash
docker-compose up
```

👉 This will automatically:

* Pull images
* Create containers
* Create a network
* Connect all services together

---

## 🌐 Networking in Docker Compose

Docker Compose automatically creates a **default network**.

Example:

* Your Spring Boot container can access MySQL using the service name

```properties
spring.datasource.url=jdbc:mysql://db:3306/mydb
```

👉 Here, `db` is the service name, not an IP address.

---

## 💾 Volumes in Docker Compose

Volumes are used to persist data.

```yaml
volumes:
  mysql-data:
```

👉 This ensures that MySQL data remains safe even if the container is deleted.

---

## ⚙️ Example: Spring Boot + MySQL Setup

```yaml
version: '3.8'

services:
  app:
    build: .
    ports:
      - "8080:8080"
    depends_on:
      - db

  db:
    image: mysql
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: mydb
    ports:
      - "3306:3306"
    volumes:
      - mysql-data:/var/lib/mysql

volumes:
  mysql-data:
```

---

## ▶️ Common Commands

### Start containers

```bash
docker-compose up
```

### Run in background

```bash
docker-compose up -d
```

### Stop containers

```bash
docker-compose down
```

### Rebuild containers

```bash
docker-compose up --build
```

---

## 🎯 Advantages of Docker Compose

* Easy multi-container management
* One-command startup
* Clean configuration
* Great for development and testing
* Scalable architecture

---

## 🚀 When Should You Use Docker Compose?

Use Docker Compose when:

* Your project has multiple services
* You want automation
* You need a repeatable environment

Avoid when:

* You only have a single simple container

---

## 🧠 Conclusion

Docker Compose is a powerful tool that makes managing multi-container applications **simple and efficient**.

If you are building a project like Spring Boot + MySQL, using Docker Compose is considered a best practice.

---

## 🙌 Next Step

As a next step, you can:

* Create your `docker-compose.yml` file
* Connect your Spring Boot application with MySQL

If you want, I can also create a **ready-to-use docker-compose file tailored to your project** 👍
