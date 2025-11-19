# WorkLabDemo# 🔍 商品搜尋系統 (Product Search System)

## 📋 專案簡介

這是一個基於 Java Web 的商品搜尋系統，使用 Servlet + JSP + Hibernate + SQL Server 開發。

### 主要功能

- ✅ 顯示所有商品列表
- ✅ 多欄位全文搜尋（商品名稱、分類、價格、庫存、描述、ID）
- ✅ 搜尋結果即時顯示
- ✅ 一鍵重置回所有商品列表

---

## 🛠️ 技術架構

### 後端技術

- **Java 17**
- **Jakarta Servlet 5.0**（使用註解配置，無需 web.xml）
- **Hibernate 6.4.4** (ORM 框架)
- **SQL Server** (資料庫)
- **Maven** (專案管理)

### 前端技術

- **JSP** (JavaServer Pages)
- **JSTL** (Jakarta Standard Tag Library)
- **CSS** (自訂樣式)

### 部署容器

- **Apache Tomcat 10.1.13**（透過 Maven Cargo Plugin 自動下載）

---

## 📁 專案結構

```
demo/
├── pom.xml                                          # Maven 配置檔
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/kevin/productsearch/
│   │   │       ├── controller/
│   │   │       │   └── ProductSearchServlet.java   # 搜尋 Servlet
│   │   │       ├── service/
│   │   │       │   └── ProductService.java         # 業務邏輯層
│   │   │       ├── dao/
│   │   │       │   └── ProductDAO.java             # 資料存取層
│   │   │       ├── model/
│   │   │       │   └── Product.java                # 商品實體類別
│   │   │       └── utils/
│   │   │           └── HibernateUtil.java          # Hibernate 工具類別
│   │   ├── resources/
│   │   │   └── hibernate.cfg.xml                   # Hibernate 配置檔
│   │   └── webapp/
│   │       └── product_search.jsp                  # 搜尋頁面
└── README.md                                        # 專案說明文件
```

---

## 📦 資料庫設定

### 1. 建立資料庫

在 SQL Server 中執行以下 SQL：

```sql
-- 建立資料庫
CREATE DATABASE ProductDB;
GO

-- 使用資料庫
USE ProductDB;
GO

-- 建立使用者（如果需要）
CREATE LOGIN kevinproduct WITH PASSWORD = '123456';
CREATE USER kevinproduct FOR LOGIN kevinproduct;
GO

-- 授予權限
ALTER ROLE db_owner ADD MEMBER kevinproduct;
GO
```

### 2. 資料表結構

Hibernate 會自動建立 `Product` 資料表，結構如下：

| 欄位名稱      | 資料型別       | 說明            |
| ------------- | -------------- | --------------- |
| productId     | INT (自動遞增) | 商品 ID（主鍵） |
| productName   | NVARCHAR       | 商品名稱        |
| category      | NVARCHAR       | 商品分類        |
| price         | FLOAT          | 商品價格        |
| stockQuantity | INT            | 庫存數量        |
| description   | NVARCHAR       | 商品描述        |

### 3. 測試資料（選用）

```sql
USE ProductDB;
GO

INSERT INTO Product (productName, category, price, stockQuantity, description)
VALUES
    ('iPhone 15 Pro', '電子產品', 35900, 50, '最新款 Apple 智慧型手機'),
    ('MacBook Air M2', '電腦', 34900, 30, '輕薄筆記型電腦'),
    ('AirPods Pro', '配件', 7990, 100, '主動降噪耳機'),
    ('Nike 運動鞋', '運動用品', 2980, 75, '舒適跑步鞋'),
    ('Adidas 外套', '服飾', 1890, 60, '防風運動外套');
GO
```

### 4. 修改資料庫連線設定（如需要）

編輯 `src/main/resources/hibernate.cfg.xml`：

```xml
<property name="hibernate.connection.url">jdbc:sqlserver://localhost:1433;databaseName=ProductDB</property>
<property name="hibernate.connection.username">kevinproduct</property>
<property name="hibernate.connection.password">123456</property>
```

---

## 🎯 啟動專案

### 使用 Maven 啟動

```bash
# 1. 進入專案目錄
cd demo

# 2. 清理、編譯、打包並啟動 Tomcat
mvn clean package cargo:run
```

### 啟動過程說明

1. **第一次執行**：會自動下載 Tomcat 10.1.13（約 10-15 MB），需要等待一段時間
2. **後續執行**：Tomcat 已下載在 `target/tomcat10x`，啟動會很快
3. **看到以下訊息代表啟動成功**：
   ```
   [INFO] [talledLocalContainer] Tomcat 10.x started on port [8080]
   ```

### 停止服務

按 `Ctrl + C` 停止 Tomcat

---

## 🌐 訪問應用程式

啟動成功後，開啟瀏覽器訪問：

- **首頁（顯示所有商品）**：http://localhost:8080/demo/
- **搜尋頁面**：http://localhost:8080/demo/search
