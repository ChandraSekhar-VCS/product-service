# Product Service

A Spring Boot microservice that integrates with the [DummyJSON](https://dummyjson.com/products) API to provide product listings, search, and category features. This service simulates a real-world product module for an e-commerce system and demonstrates clean API client abstraction, centralized exception handling, and DTO-layered communication.

---

## 🚀 Features

- ✅ Retrieve all products from DummyJSON
- 🔍 Search products by keyword
- 🛍️ Fetch products by category
- 📦 Get individual product by ID
- 🗂️ List all product categories
- ❌ Centralized error handling with `@ControllerAdvice`
- 🛡️ Null-safe defensive programming in the service layer
- 🧼 Clean, layered architecture using DTOs and RestTemplate

---

## 🧱 Tech Stack

| Layer         | Technology                |
|---------------|---------------------------|
| Language      | Java 17                   |
| Framework     | Spring Boot 3.x           |
| HTTP Client   | `RestTemplate`            |
| Build Tool    | Maven                     |
| IDE           | IntelliJ IDEA             |
| Source API    | DummyJSON REST API        |

---

## 🔧 How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/ChandraSekhar-VCS/product-service.git
   cd product-service
   ```

2. **Configure Base URL**  
   Add the following line in your `application.properties`:
   ```properties
   dummyjson.base-url=https://dummyjson.com
   ```

3. **Run the application**
   ```bash
   ./mvnw spring-boot:run
   ```

4. **Test health check**
   ```
   GET http://localhost:8080/products/health
   ```

---

## 📁 Project Structure

```
product-service/
├── controller/           # REST endpoints
├── service/              # Business logic
├── client/               # External API client
├── dto/                  # Data Transfer Objects
├── exception/            # Custom and global exception handling
├── application.properties
└── pom.xml
```

---

## 🌐 Sample Endpoints

| Endpoint                                 | Description                     |
|------------------------------------------|---------------------------------|
| `GET /products`                          | List all products               |
| `GET /products/{id}`                     | Get product by ID               |
| `GET /products/search?q=phone`           | Search products                 |
| `GET /products/category/{name}`          | Filter by category              |
| `GET /products/categories`               | List available categories       |
| `GET /products/health`                   | Health check endpoint           |

---

## 🧪 Sample Response

```json
{
  "products": [
    {
      "id": 1,
      "title": "iPhone 9",
      "price": 549,
      "category": "smartphones"
    },
    ...
  ]
}
```

---

## 🛠️ Future Enhancements (Optional)

- Switch to `WebClient` for reactive support
- Integrate caching using Redis
- Add Swagger/OpenAPI docs
- Add service-level unit tests using JUnit & Mockito

---

## 🧑‍💻 Author

**Chandra Sekhar Vipparla**  
[GitHub Profile](https://github.com/ChandraSekhar-VCS)

---

## 📄 License

This project is open-source and available under the [MIT License](LICENSE).
