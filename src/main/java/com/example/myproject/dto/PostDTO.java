package com.example.myproject.dto;

import lombok.Data;

@Data
public class PostDTO {
    private String title;
    private String content;
    private Long categoryId;
}
