# 🛒 Promotion Engine

A simple, extensible Promotion Engine built with Java and Spring Boot that calculates the total price of a shopping cart after applying active promotional discounts.

---

## ✅ Objective

To apply available bulk and combo promotions to cart items and return the final total. Designed with clean OOP principles and TDD using JUnit.

---

## 💡 Problem Description

### 📦 Available SKUs and Unit Prices:
| SKU | Unit Price |
|-----|------------|
| A   | 50         |
| B   | 30         |
| C   | 20         |
| D   | 15         |

### 🎁 Active Promotions:
| Type   | Description   | Promo Price |
|--------|---------------|-------------|
| Bulk   | 3 of A        | 130         |
| Bulk   | 2 of B        | 45          |
| Combo  | C + D         | 30          |

---

## 🧠 Design Goals

- ✅ Modular and extensible
- ✅ Follows OOP design principles
- ✅ Built using TDD with JUnit
- ✅ Supports future promotion types easily
- ✅ Clear Git commit history

---

## 🧱 Architecture Overview

### 📁 Models

class CartItem {
    String sku;
    int quantity;
    int unitPrice;
}

class Cart {
    List<CartItem> items;
}
💡 Promotions Interface

interface Promotion {
    boolean isApplicable(Cart cart);
    int apply(Cart cart);
}

👇 Promotion Implementations
BulkPromotion – Applies when quantity meets threshold
ComboPromotion – Applies for C + D combo

🧮 Promotion Engine

class PromotionEngine {
    List<Promotion> promotions;
    public int calculateTotal(Cart cart);
}

🧪 Test Scenarios
Scenario	            Cart Items	          Expected Total
A	                  1 A, 1 B, 1 C	            100
B	                  5 A, 5 B, 1 C	            370
C	                  3 A, 5 B, 1 C, 1 D	      280

Tests written using JUnit 5 in PromotionEngineTest.java

🚀 API Endpoint (Spring Boot)
Method	Endpoint	Description
POST	/api/calculate	Calculates total cart value

🧾 Sample Request

{
  "items": [
    { "sku": "A", "quantity": 3, "unitPrice": 50 },
    { "sku": "B", "quantity": 5, "unitPrice": 30 },
    { "sku": "C", "quantity": 1, "unitPrice": 20 },
    { "sku": "D", "quantity": 1, "unitPrice": 15 }
  ]
}
✅ Sample Response

{
  "total": 280
}
🛠️ Running Locally
🧱 Prerequisites

Java 17+
Maven 3+

🔧 Build & Run

mvn clean install
mvn spring-boot:run

🧪 Run Tests

mvn test

📁 Git Commit Guide (TDD-style)

Commit Message	                          Description
Add CartItem and Cart model	        Data structure for cart
Add BulkPromotion class	            Bulk discount logic
Write test for 3 A's promo	        TDD for bulk promotion
Implement PromotionEngine	          Core engine logic
Add test for Scenario A	            End-to-end integration test

📦 Deployment
To deploy on Render/Railway:

Add GitHub repo
Set build command: mvn clean install
Set run command: mvn spring-boot:run
Set port: 8080

🙌 Contributing
Feel free to fork and submit PRs for:

New promotion types
Bug fixes
REST API improvements

📜 License
This project is open-source and free to use.
