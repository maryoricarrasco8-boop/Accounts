# AccountMS – Entrega Final

Incluye:
- JUnit 5 + Mockito (pruebas unitarias y reactivas).
- JaCoCo para coverage (`mvn verify` genera `target/site/jacoco/index.html`).
- Checkstyle (`mvn validate`).
- Dockerfile y `docker-compose.yml` con **MongoDB**, **Redis** y **Kafka**.
- Carpeta `docs/` con evidencias y diagramas.

## Comandos
```bash
# pruebas + coverage
mvn clean verify

# solo checkstyle
mvn validate

# build jar
mvn -DskipTests package

# levantar stack
docker compose up -d --build
```
