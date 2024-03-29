package com.example.demo.controller;

import com.example.demo.entity.ProductItems;
import com.example.demo.lookupservices.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    
    
    //http://localhost:9083/api/products/all
    @GetMapping("/all")
    public List<ProductItems> getAllProducts() {
        return productService.getAllProducts();
    }

    // http://localhost:9083/api/products/add
    @PostMapping("/add")
    public void addItem(@RequestBody ProductItems item) {
        productService.addItem(item);
    }
    //http://localhost:9083/api/products/delete/ProductA
    @DeleteMapping("/delete/{productName}")
    public void deleteItem(@PathVariable String productName) {
    	productService.deleteItem(productName);
    }

    //http://localhost:9083/api/products/update
    @PutMapping("/update")
    public void updateItem(@RequestBody ProductItems updatedItem) {
        productService.updateItem(updatedItem);
    }
}
