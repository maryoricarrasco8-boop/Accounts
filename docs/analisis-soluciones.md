# Análisis de la solución (SOLID + Patrones)

## SOLID
1. **S**RP: `AccountServiceImpl` separa lógica de negocio de acceso de datos (`AccountRepository`) y de transporte (`AccountController`).
2. **O**CP: Extensible al agregar nuevos tipos de cuenta sin modificar controladores (validaciones en servicio).
3. **L**SP: `AccountService` define contrato que `AccountServiceImpl` cumple.
4. **I**SP: Interfaces del dominio son pequeñas (`AccountService`).
5. **D**IP: Servicio depende de abstracciones (`AccountRepository`, `AccountProducer`) inyectadas.

## Patrones
- **Repository** (Spring Data JPA).
- **Port-Adapter**: el productor Kafka actúa como salida (port) y el adapter `AccountProducer` lo implementa.
- **Builder** (Lombok) para `Account`.

## Decisiones
- **MySQL** para persistencia (alineado con `application.yml` y compose).
- **Redis** para cache de consultas por `id`.
- **Kafka** para eventos de creación/actualización.
