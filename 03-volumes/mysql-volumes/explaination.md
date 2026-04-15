# 💾 Docker Volumes (MySQL Data Persistence)

## 📌 What is a Volume?

A Docker Volume is used to **store data outside the container**.

👉 This ensures that data is not lost when the container is removed.

---

## ❌ Problem Without Volume

* Container delete → Data lost
* Not suitable for databases

---

## ✅ Solution: Use Volume

We attach a volume to MySQL:

```bash
-v mysql-data:/var/lib/mysql
```

👉 `/var/lib/mysql` is the default MySQL data directory inside container

---

## 🧪 What We Did

1. Created a volume
2. Ran MySQL container with volume
3. Stored data inside database
4. Deleted container
5. Re-ran container with same volume

👉 Result: Data was still there ✅

---

## 🔥 Key Learnings

* Volumes persist data even after container deletion
* Important for databases like MySQL
* Volume acts as external storage

---

## 🎯 Real-world Importance

* Used in production systems
* Prevents data loss
* Essential for backend applications

---

## ⚠️ Common Mistakes

❌ Not using volume → data loss
❌ Wrong mount path
❌ Deleting volume unknowingly

---

## 🚀 Conclusion

Using volumes is mandatory when working with databases in Docker.
