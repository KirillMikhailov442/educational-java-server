package com.example.myproject.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myproject.dto.CategoryDTO;
import com.example.myproject.entities.Category;
import com.example.myproject.repositories.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> readyAll() {
        return categoryRepository.findAll();
    }

    public Optional<Category> readyById(Long id) {
        return categoryRepository.findById(id);
    }

    public Category create(CategoryDTO dto) {
        Category category = Category.builder().name(dto.getName()).description(dto.getDescription()).build();
        return categoryRepository.save(category);
    }

    public Boolean deleteById(Long id) {
        categoryRepository.deleteById(id);
        return true;
    }

}
