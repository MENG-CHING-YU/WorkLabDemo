package com.kevin.productsearch.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Product")
public class Product {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "category")
    private String category;

    @Column(name = "price")
    private double price;

    @Column(name = "stock_quantity")
    private int stockQuantity;

    @Column(name = "description")
    private String description;

    public Product() {
        
    }

    public Product(String productName, String category, double price, int stockQuantity, String description) {
        this.productName = productName;
        this.category = category;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.description = description;
    }

    public int getProductId() {
         return productId; 
        }
    public void setProductId(int productId) {
         this.productId = productId; 
        }

    public String getProductName() {
         return productName; 
        }
    public void setProductName(String productName) { 
        this.productName = productName; 
    }

    public String getCategory() {
         return category;
         }
    public void setCategory(String category) {
         this.category = category; 
        }

    public double getPrice() { return price; }
    public void setPrice(double price) {
         this.price = price; 
        }

    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) {
         this.stockQuantity = stockQuantity; 
        }

    public String getDescription() { 
        return description; 
    }
    public void setDescription(String description) { 
        this.description = description; 
    }
}
