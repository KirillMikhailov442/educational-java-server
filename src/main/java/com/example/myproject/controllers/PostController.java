package com.example.myproject.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myproject.dto.PostDTO;
import com.example.myproject.entities.Post;
import com.example.myproject.services.PostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    PostService postService;

    @GetMapping
    public ResponseEntity<List<Post>> getAll() {
        return new ResponseEntity<>(postService.readyAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Post>> getOne(@PathVariable Long id) {
        return new ResponseEntity<>(postService.readyById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Post> registration(@RequestBody PostDTO post) {
        return new ResponseEntity<>(postService.create(post), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteOne(@PathVariable Long id) {
        postService.deleteById(id);
        return true;
    }

}
