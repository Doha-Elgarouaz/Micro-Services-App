# 🧾 Micro-Services-App — TP2

Application basée sur une architecture **micro-services** permettant de gérer des **factures** contenant des **produits** et appartenant à un **client**.

---

## 👤 Auteur

**Doha El Garouaz**
📧 elgarouaz.doha.19@gmail.com
🔗 [github.com/Doha-Elgarouaz](https://github.com/Doha-Elgarouaz)

---

## 🏗️ Architecture

```
[Client / Browser]
        │
        ▼
  gateway-service       :8888  — API Gateway (Spring Cloud Gateway)
   ├── /customers/**  ──────►  customer-service   :8081
   ├── /products/**   ──────►  inventory-service  :8082
   └── /BILLING-SERVICE/** ►  billing-service     :8084
                                   │
                     Feign ────────┤
                     ├── customer-service
                     └── inventory-service

  discovery-service     :8761  — Eureka Server (registre des services)
```

---

## 🔧 Services

| Service | Port | Rôle |
|---|---|---|
| `discovery-service` | 8761 | Registre Eureka (Netflix) |
| `gateway-service` | 8888 | Passerelle API (WebFlux) |
| `customer-service` | 8081 | Gestion des clients |
| `inventory-service` | 8082 | Gestion des produits |
| `billing-service` | 8084 | Gestion des factures |

---

## 🗄️ Modèle de données

- **Customer** : `id`, `name`, `email`
- **Product** : `id`, `name`, `price`, `quantity`
- **Bill** : `id`, `billingDate`, `customerId`, `productItems[]`
- **ProductItem** : `id`, `productId`, `quantity`, `price`

---

## 🚀 Lancer le projet

> ⚠️ Respecter l'ordre de démarrage !

```bash
# 1. Eureka Server
cd discovery-service && ./mvnw spring-boot:run

# 2. Services métier (dans n'importe quel ordre)
cd customer-service  && ./mvnw spring-boot:run
cd inventory-service && ./mvnw spring-boot:run

# 3. Billing Service
cd billing-service   && ./mvnw spring-boot:run

# 4. Gateway
cd gateway-service   && ./mvnw spring-boot:run
```

---

## 🌐 Endpoints

| Méthode | URL | Description |
|---|---|---|
| GET | `http://localhost:8888/customers` | Liste des clients |
| GET | `http://localhost:8888/customers/{id}` | Client par ID |
| GET | `http://localhost:8888/products` | Liste des produits |
| GET | `http://localhost:8888/products/{id}` | Produit par ID |
| GET | `http://localhost:8888/BILLING-SERVICE/api/bills/{id}` | Facture enrichie |
| GET | `http://localhost:8761` | Dashboard Eureka |

---

## 🛠️ Stack technique

- **Java 21** / **Spring Boot 4.1.x**
- **Spring Cloud 2025.1.x** (Eureka, Gateway, OpenFeign)
- **Resilience4j** — Circuit Breaker
- **Spring Data JPA + REST** — CRUD automatique
- **H2** — Base de données en mémoire
- **Lombok**
