package com.udemy.controllers;

import com.udemy.entities.Product;
import com.udemy.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value ="/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = productService.findAll();
        return ResponseEntity.ok(products);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product Product  = productService.findById(id);
        return ResponseEntity.ok(Product);
    }
}
