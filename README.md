# 🚀 Spring Boot 3 vs Spring Boot 4 – API Versioning Comparison

This repository demonstrates the difference between **manual API versioning in Spring Boot 3** and the new **built-in API versioning support in Spring Boot 4**.

The goal of this project is to clearly show how Spring Boot 4 reduces complexity, boilerplate, and maintenance effort compared to Spring Boot 3.

---

## 📂 Project Structure


Springboot-Versioning-Comparison

│

├── springboot3-versioning → Manual API versioning implementation

├── springboot4-versioning → Built-in API versioning implementation

└── README.md



---

# 🔴 Spring Boot 3 – Manual Versioning

Spring Boot 3 does **not provide built-in API versioning support**.

Developers must implement versioning manually using:

- URI versioning (`/api/v1/...`)
- Multiple controllers
- Custom interceptors
- Manual version validation
- Custom configuration logic



### Characteristics

- Multiple controllers for different versions
- Manual validation for unsupported versions
- Higher boilerplate
- More maintenance effort
- Greater complexity

---

# 🟢 Spring Boot 4 – Built-in API Versioning

Spring Boot 4 introduces **native API versioning support**.

Key features:

- `@GetMapping(version = "...")`
- `ApiVersionConfigurer`
- Automatic validation
- Automatic 400 response for unsupported versions
- Cleaner architecture

### Example Configuration

```java
@Configuration
public class ApiVersionConfig implements WebMvcConfigurer {

    @Override
    public void configureApiVersioning(ApiVersionConfigurer configurer) {
        configurer
            .usePathSegment(1)
            .addSupportedVersions("1.0", "2.0");
    }
}
