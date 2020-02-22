package com.example.demo.domain;

import java.util.List;
import java.util.Objects;

public class PostDTO {
    private List<BookDTO> posts;

    public PostDTO() {
    }

    public PostDTO(List<BookDTO> resultList) {
        this.posts = resultList;
    }

    public List<BookDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<BookDTO> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PostDTO postDTO = (PostDTO) o;
        return Objects.equals(posts, postDTO.posts);
    }

    @Override
    public int hashCode() {

        return Objects.hash(posts);
    }
}
