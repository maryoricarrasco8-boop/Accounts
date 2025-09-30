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

## 🧭 Arquitectura (Mermaid)
```mermaid
flowchart LR
    subgraph Client Apps
      A[Postman / Frontend] -->|HTTP/JSON| B((API Gateway opcional))
    end

    B -->|REST| S[AccountMS (Spring Boot)]
    A -->|REST| S

    subgraph Integrations
      K[(Kafka)]:::kafka
      R[(Redis Cache)]:::redis
      D[(DB: MySQL/MongoDB)]:::db
    end

    S -- publish/consume --> K
    S -- cache read/write --> R
    S -- CRUD --> D

    classDef kafka fill:#f6e05e,stroke:#b7791f,stroke-width:1px,color:#1a202c;
    classDef redis fill:#fed7d7,stroke:#c53030,stroke-width:1px,color:#1a202c;
    classDef db fill:#bee3f8,stroke:#2b6cb0,stroke-width:1px,color:#1a202c;
