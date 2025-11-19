package com.kevin.productsearch.service;

import com.kevin.productsearch.dao.ProductDAO;
import com.kevin.productsearch.model.Product;

import java.util.List;

public class ProductService {
    private final ProductDAO dao = new ProductDAO();

 
    public List<Product> searchProducts(String keyword) {
        if (keyword == null) {
            return dao.getAllProducts();
        }

        String cleaned = keyword.trim();
        if (cleaned.isEmpty()) {
            return dao.getAllProducts();
        }

      
        if (cleaned.length() > 200) {
            cleaned = cleaned.substring(0, 200);
        }

        return dao.searchAllFields(cleaned);
    }

    public List<Product> getAllProducts() {
        return dao.getAllProducts();
    }

}

