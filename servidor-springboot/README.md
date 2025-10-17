********************************************
Servidor (Java Spring Boot) - Unidad 6 / Web Services
********************************************
Endpoints requeridos:
- GET    /clientes/{id}
- GET    /sucursales
- GET    /transacciones?fecha=YYYY-MM-DD
- POST   /transferencias      (X-Token: abc123)
- PUT    /clientes/{id}       (X-Token: abc123)
- DELETE /beneficiarios/{id}  (X-Token: abc123)

DB con Docker:
  docker compose -f postgres.yml up -d

Servidor:
  mvn spring-boot:run
