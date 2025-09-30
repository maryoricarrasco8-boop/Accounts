# AccountMS – Entrega Final 🚀

Microservicio de **gestión de cuentas bancarias** desarrollado en **Spring Boot** como parte del sistema **Banking Manager**. Incluye pruebas automatizadas, control de calidad de código, integración con **Kafka**, **Redis**, **DB** y despliegue con **Docker**.

---

## 📦 Incluye
- **JUnit 5 + Mockito** → pruebas unitarias y reactivas.  
- **JaCoCo** para coverage → `mvn verify` genera `target/site/jacoco/index.html`.  
- **Checkstyle** → `mvn validate`.  
- **Dockerfile** y `docker-compose.yml` con **MongoDB/MySQL**, **Redis** y **Kafka**.  
- Carpeta `docs/` con evidencias y diagramas.  

---

## ⚙️ Tecnologías
Java 17 • Spring Boot 3 • Maven • MySQL/MongoDB • Redis • Kafka • Docker/Compose • Swagger/OpenAPI

---
DB_HOST=localhost
DB_PORT=3306
DB_NAME=accounts
DB_USER=root
DB_PASS=secret

REDIS_HOST=localhost
REDIS_PORT=6379

KAFKA_BROKER=localhost:9092
