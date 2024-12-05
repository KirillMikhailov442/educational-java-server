package com.example.myproject.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myproject.dto.PostDTO;
import com.example.myproject.entities.Category;
import com.example.myproject.entities.Post;
import com.example.myproject.repositories.PostRepository;

@Service
public class PostService {

    @Autowired
    PostRepository postRepository;
    CategoryService categoryService;

    public List<Post> readyAll() {
        return postRepository.findAll();
    }

    public Optional<Post> readyById(Long id) {
        return postRepository.findById(id);
    }

    public List<Category> readyByCategoryId(Long id) {
        return postRepository.findByCategoryId(id);
    }

    public Post create(PostDTO dto) {
        Post post = Post.builder().title(dto.getTitle()).content(dto.getContent())
                .category(categoryService.readyById(dto.getCategoryId())).createdAt(LocalDate.now()).build();
        return postRepository.save(post);
    }

    public Post update(Post post) {
        return postRepository.save(post);
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}
