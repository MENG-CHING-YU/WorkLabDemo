<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>商品搜尋</title>
    <style>
      body {
        font-family: Arial, sans-serif;
        margin: 20px;
        background-color: #f5f5f5;
      }
      .container {
        max-width: 1200px;
        margin: 0 auto;
        background-color: white;
        padding: 20px;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
      }
      h1 {
        color: #333;
        text-align: center;
      }
      .search-box {
        display: flex;
        gap: 10px;
        margin-bottom: 20px;
        justify-content: center;
      }
      .search-box input {
        padding: 10px;
        width: 300px;
        border: 1px solid #ddd;
        border-radius: 4px;
        font-size: 14px;
      }
      .search-box button {
        padding: 10px 20px;
        background-color: #007bff;
        color: white;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        font-size: 14px;
      }
      .search-box button:hover {
        background-color: #0056b3;
      }
      .results {
        margin-top: 30px;
      }
      .result-count {
        color: #666;
        margin-bottom: 15px;
        font-size: 14px;
      }
      .product-table {
        width: 100%;
        border-collapse: collapse;
      }
      .product-table thead {
        background-color: #f8f9fa;
      }
      .product-table th {
        padding: 12px;
        text-align: left;
        font-weight: bold;
        border-bottom: 2px solid #dee2e6;
      }
      .product-table td {
        padding: 12px;
        border-bottom: 1px solid #dee2e6;
      }
      .product-table tbody tr:hover {
        background-color: #f9f9f9;
      }
      .no-results {
        text-align: center;
        color: #999;
        padding: 30px;
        font-size: 16px;
      }
      .keyword-display {
        font-weight: bold;
        color: #007bff;
      }
    </style>
  </head>
  <body>
    <div class="container">
      <h1>🔍 商品搜尋系統</h1>

      <!-- 搜尋表單 -->
      <div class="search-box">
        <form
          action="/demo/search"
          method="get"
          style="display: flex; gap: 10px"
        >
          <input
            type="text"
            name="keyword"
            placeholder="輸入商品名稱、分類、價格等..."
            value="${currentKeyword != null ? currentKeyword : ''}"
          />
          <button type="submit">搜尋</button>
          <!-- 重置按鈕，清空 keyword -->
          <a href="/demo/search"><button type="button">重置</button></a>
        </form>
      </div>

      <!-- 搜尋結果 -->
      <div class="results">
        <c:if test="${not empty products}">
          <c:if test="${not empty currentKeyword}">
            <div class="result-count">
              搜尋關鍵字:
              <span class="keyword-display">${currentKeyword}</span> | 共找到
              <strong>${products.size()}</strong> 筆商品
            </div>
          </c:if>

          <table class="product-table">
            <thead>
              <tr>
                <th>商品ID</th>
                <th>商品名稱</th>
                <th>分類</th>
                <th>價格</th>
                <th>剩餘數量</th>
                <th>描述</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="product" items="${products}">
                <tr>
                  <td>${product.productId}</td>
                  <td>${product.productName}</td>
                  <td>${product.category}</td>
                  <td>NT$ ${product.price}</td>
                  <td>${product.stockQuantity}</td>
                  <td>${product.description}</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </c:if>

        <c:if test="${empty products}">
          <div class="no-results">
            <c:if test="${empty currentKeyword}">
              尚無商品資料。請先新增商品。
            </c:if>
            <c:if test="${not empty currentKeyword}">
              查無符合 "<span class="keyword-display">${currentKeyword}</span>"
              的商品。
            </c:if>
          </div>
        </c:if>
      </div>
    </div>
  </body>
</html>
