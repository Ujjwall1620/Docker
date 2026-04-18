# 📘 Complete Dockerfile Commands Explanation

## 🐳 What is a Dockerfile?

A **Dockerfile** is a script that contains instructions to build a Docker image automatically.

👉 It defines how your container will be created and run.

---

## 🧱 All Important Dockerfile Instructions

---

## 1. FROM

```dockerfile
FROM ubuntu:22.04
```

* Base image define karta hai
* Har Dockerfile ka starting point hota hai

👉 Example:

* `node`
* `openjdk`
* `mysql`

---

## 2. WORKDIR

```dockerfile
WORKDIR /app
```

* Container ke andar working directory set karta hai
* Agar folder exist nahi karta → automatically create ho jata hai

---

## 3. COPY

```dockerfile
COPY . .
```

* Local system se files container me copy karta hai

👉 Format:

```dockerfile
COPY <source> <destination>
```

---

## 4. ADD

```dockerfile
ADD file.tar.gz /app/
```

* COPY jaisa hi hai but extra features ke sath:

  * ZIP extract kar sakta hai
  * URL se file download kar sakta hai

👉 Prefer: `COPY` (simple use cases ke liye)

---

## 5. RUN 🔥

```dockerfile
RUN apt-get update && apt-get install -y curl
```

* Build time pe command execute hoti hai

👉 Use cases:

* Dependencies install karna
* Software setup

---

## 6. CMD 🔥

```dockerfile
CMD ["node", "app.js"]
```

* Default command jo container start hone par run hota hai

👉 Override ho sakta hai:

```bash
docker run image-name new-command
```

---

## 7. ENTRYPOINT 🔥

```dockerfile
ENTRYPOINT ["node", "app.js"]
```

* Fixed command hoti hai
* Easily override nahi hoti

---

## 8. ENV

```dockerfile
ENV PORT=8080
```

* Environment variables set karta hai

---

## 9. ARG

```dockerfile
ARG VERSION=1.0
```

* Build-time variables define karta hai
* Sirf build ke time available hota hai

---

## 10. EXPOSE

```dockerfile
EXPOSE 8080
```

* Container ka port declare karta hai

👉 Note:

* Ye port open nahi karta, sirf inform karta hai

---

## 11. VOLUME

```dockerfile
VOLUME /data
```

* Persistent storage define karta hai
* Data container ke bahar save hota hai

---

## 12. USER

```dockerfile
USER root
```

* Container kis user ke naam se run hoga

---

## 13. LABEL

```dockerfile
LABEL version="1.0"
```

* Metadata add karta hai (author, version, etc.)

---

## 14. SHELL

```dockerfile
SHELL ["/bin/bash", "-c"]
```

* Default shell change karta hai

---

## 15. HEALTHCHECK

```dockerfile
HEALTHCHECK CMD curl --fail http://localhost:8080 || exit 1
```

* Container health check karta hai

---

## 16. ONBUILD

```dockerfile
ONBUILD COPY . .
```

* Jab koi dusra image isko base banata hai tab run hota hai

---

## ⚖️ CMD vs ENTRYPOINT

| Feature  | CMD             | ENTRYPOINT    |
| -------- | --------------- | ------------- |
| Override | Easy            | Difficult     |
| Purpose  | Default command | Fixed command |

---

## ⚙️ Commands to Build & Run

### Build Image

```bash
docker build -t my-app .
```

---

### Run Container

```bash
docker run -d -p 8080:8080 my-app
```

---

### List Images

```bash
docker images
```

---

### List Containers

```bash
docker ps
```

---

### Stop Container

```bash
docker stop <container-id>
```

---

## 🔄 Complete Workflow

1. Write Dockerfile
2. Build Image
3. Run Container
4. Access Application

---

## 🚀 Conclusion

Dockerfile instructions help you:

* Build images
* Configure environment
* Run applications efficiently

---
