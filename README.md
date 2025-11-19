# WorkLabDemo# 🔍 商品搜尋系統 (Product Search System)

## 🛠️ 技術架構

### 後端技術

- **Java 17**
- **Servlet**
- **Hibernate**
- **SQL Server**
- **Maven**

### 前端技術

- **JSP**
- **JSTL**
- **CSS**

### 部署容器

- **Apache Tomcat **

## 📦 資料庫設定

### 1. 建立資料庫

在 SQL Server 中執行以下 SQL：

```sql
-- 建立資料庫
CREATE DATABASE ProductDB;


-- 使用資料庫
USE ProductDB;


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



### 4. 修改資料庫連線設定（如需要）

編輯 `src/main/resources/hibernate.cfg.xml`：


<property name="hibernate.connection.url">jdbc:sqlserver://localhost:1433;databaseName=ProductDB</property>
<property name="hibernate.connection.username">kevinproduct</property>
<property name="hibernate.connection.password">123456</property>




##  啟動專案


# 1. 進入專案目錄
cd demo

# 2. 清理、編譯、打包並啟動 Tomcat
mvn clean package cargo:run
```

### 啟動過程說明

1. **第一次執行**：會自動下載 Tomcat 10.1.13（
2. **後續執行**：Tomcat 已下載在 `target/tomcat10x`，啟動會很快
3. **看到以下訊息代表啟動成功**：

### 停止服務

按 `Ctrl + C` 停止 Tomcat

## 🌐 訪問應用程式

啟動成功後，開啟瀏覽器訪問：

- **首頁（顯示所有商品）**：http://localhost:8080/demo/
- **搜尋頁面**：http://localhost:8080/demo/search
