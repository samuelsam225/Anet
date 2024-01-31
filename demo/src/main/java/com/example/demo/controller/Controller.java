package com.example.demo.controller;


import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
public class Controller {

    private final List<Product> productList = new ArrayList<Product>();

    @Autowired
    private ProductService productService;

    // Create a new product
    @PostMapping("/create")
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    // Retrieve all products
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Retrieve a specific product by ID
    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable int productId) {
        return productService.findById(productId);
    }

    // Update an existing product
    @PutMapping("/update/{productId}")
    public Product updateCustomer(@PathVariable int productId, @RequestBody Product updatedProduct) {
        for (int i = 0; i < productList.size(); i++) {
            Product existingProduct = productList.get(i);
            if (existingProduct.getId() == productId) {
                existingProduct.setName(updatedProduct.getName());
                existingProduct.setDescription(updatedProduct.getDescription());
                existingProduct.setPrice(updatedProduct.getPrice());
                existingProduct.setQuantity(updatedProduct.getQuantity());
                return existingProduct;
            }
        }
        throw new RuntimeException("Customer not found with id: " + productId);
    }

    // Delete a product by ID
    @DeleteMapping("/delete/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        productList.removeIf(product -> product.getId() == productId);
        return "Product with id " + productId + " has been deleted.";
    }


}
