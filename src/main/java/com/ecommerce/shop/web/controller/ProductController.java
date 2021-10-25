package com.ecommerce.shop.web.controller;

import com.ecommerce.shop.data.model.Product;
import com.ecommerce.shop.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productServiceImpl;

    @GetMapping("/")
    public List<Product> findAll(){
        return productServiceImpl.findAll();
    }

    @PostMapping("/")
    public Product save(@RequestBody Product product){
        log.info("Product request -> {}", product);
        return productServiceImpl.save(product);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productServiceImpl.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
