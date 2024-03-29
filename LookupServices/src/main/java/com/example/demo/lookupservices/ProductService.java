package com.example.demo.lookupservices;

import com.example.demo.entity.ProductItems;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addItem(ProductItems item) {
        productRepository.addItem(item);
    }

    public List<ProductItems> getAllProducts() {
        return productRepository.getAllProducts();
    }

    // Add methods for delete and update
    public void deleteItem(String productName) {
        productRepository.deleteItem(productName);
    }

    public void updateItem(ProductItems updatedItem) {
        productRepository.updateItem(updatedItem);
    }

	

}
