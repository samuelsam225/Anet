package com.example.demo.repository;

import com.example.demo.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private final List<Product> list = new ArrayList<Product>();

    public List<Product> getAllProducts() {
        return list;
    }

    public Product findById(int id) {
        for(Product c: list) {
            if(c.getId() == id) {
                return list.get(id);
            }
        }
        return null;
    }

    public Product save(Product product) {
        Product p = new Product();
        p.setId(product.getId());
        p.setName(product.getName());
        p.setDescription(product.getDescription());
        p.setPrice(product.getPrice());
        p.setQuantity(p.getQuantity());
        list.add(p);
        return p;
    }
}
