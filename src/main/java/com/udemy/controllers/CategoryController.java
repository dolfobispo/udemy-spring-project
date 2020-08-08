package com.udemy.controllers;

import com.udemy.entities.Category;
import com.udemy.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value ="/categories")
public class CategoryController {

    @Autowired
    private CategoryService CategoryService;
    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        List<Category> Categories = CategoryService.findAll();
        return ResponseEntity.ok(Categories);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category Category  = CategoryService.findById(id);
        return ResponseEntity.ok(Category);
    }
}
