package com.example.myproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myproject.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
