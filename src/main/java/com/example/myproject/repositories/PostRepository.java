package com.example.myproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.myproject.entities.Category;
import com.example.myproject.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    List<Category> findByCategoryId(Long id);
}
