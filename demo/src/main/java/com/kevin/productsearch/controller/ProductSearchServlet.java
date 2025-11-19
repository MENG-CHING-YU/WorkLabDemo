package com.kevin.productsearch.controller;

import com.kevin.productsearch.model.Product;
import com.kevin.productsearch.service.ProductService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


@WebServlet("/search") 
public class ProductSearchServlet extends HttpServlet {
    
   
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
   
        String keyword = request.getParameter("keyword");
        List<Product> products = productService.searchProducts(keyword);

        request.setAttribute("currentKeyword", keyword); 
        request.setAttribute("products", products); 

      
        request.getRequestDispatcher("/product_search.jsp").forward(request, response);
    }
    
  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        doGet(request, response);
    }
}