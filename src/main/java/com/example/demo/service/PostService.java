package com.example.demo.service;

import com.example.demo.domain.PostDTO;

import java.util.List;

public interface PostService {
    PostDTO operatePostInformation(List<String> tags, String sortBy, String direction);
}
