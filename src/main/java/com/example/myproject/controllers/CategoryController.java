package com.example.myproject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myproject.dto.CategoryDTO;
import com.example.myproject.entities.Category;
import com.example.myproject.services.CategoryService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> readyAll() {
        return new ResponseEntity<>(categoryService.readyAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> readyById(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.readyById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Category> registration(@RequestBody CategoryDTO dto) {
        return new ResponseEntity<>(categoryService.create(dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteById(@PathVariable Long id) {
        categoryService.deleteById(id);
        return true;
    }

}
