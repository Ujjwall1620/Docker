# 🐳 Docker Basics

## 📌 What is Docker?

Docker is a tool that allows you to **build, package, and run applications in containers**.

Containers are lightweight, portable, and ensure that your application runs the same everywhere.

---

## 🧠 Why Docker?

* Eliminates "it works on my machine" problem
* Lightweight compared to virtual machines
* Fast startup time
* Easy to share and deploy applications

---

## 📦 What is an Image?

An **Image** is a blueprint or template used to create containers.

👉 Example:

* `mysql:8.0`
* `nginx`
* `openjdk:21`

---

## 📦 What is a Container?

A **Container** is a running instance of an image.

👉 Example:

* You run `mysql:8.0` → it becomes a container

---

## 🔥 Image vs Container

| Image               | Container        |
| ------------------- | ---------------- |
| Blueprint           | Running instance |
| Static              | Dynamic          |
| Cannot run directly | Can run          |

---

## ⚙️ How Docker Works

1. You pull an image
2. You run the image
3. Docker creates a container

---

## 💡 Key Concepts

* Docker Engine: Runs containers
* Docker Hub: Repository for images
* Container: Running application
* Image: Template for container

---

## 🎯 Goal of This Section

* Understand basic Docker concepts
* Learn difference between image and container
* Run your first container
