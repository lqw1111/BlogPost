package com.example.demo.domain;

import lombok.Data;

import java.util.List;
import java.util.Objects;

public class BookDTO {
    private Integer id;
    private String author;
    private Integer authorId;
    private Integer likes;
    private Double popularity;
    private Integer reads;
    private List<String> tags;

    public BookDTO() {
    }

    public BookDTO(Integer id, String author, Integer authorId, Integer likes, Double popularity, Integer reads, List<String> tags) {
        this.id = id;
        this.author = author;
        this.authorId = authorId;
        this.likes = likes;
        this.popularity = popularity;
        this.reads = reads;
        this.tags = tags;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Integer getReads() {
        return reads;
    }

    public void setReads(Integer reads) {
        this.reads = reads;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDTO bookDTO = (BookDTO) o;
        return Objects.equals(id, bookDTO.id) &&
                Objects.equals(author, bookDTO.author) &&
                Objects.equals(authorId, bookDTO.authorId) &&
                Objects.equals(likes, bookDTO.likes) &&
                Objects.equals(popularity, bookDTO.popularity) &&
                Objects.equals(reads, bookDTO.reads) &&
                Objects.equals(tags, bookDTO.tags);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, authorId, likes, popularity, reads, tags);
    }
}
