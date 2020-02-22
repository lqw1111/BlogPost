package com.example.demo.service;

import com.example.demo.domain.BookDTO;
import com.example.demo.domain.PostDTO;
import com.example.demo.helper.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private AsyncResource asyncResource;

    @Override
    public PostDTO operatePostInformation(List<String> tags, String sortBy, String direction) {
        List<CompletableFuture<Optional<PostDTO>>> collect = tags.stream().map(tag -> asyncResource.getPostDTO(tag)).collect(Collectors.toList());

        List<BookDTO> resultList = collect.stream().map(CompletableFuture::join)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(PostDTO::getPosts)
                .flatMap(List::stream)
                .sorted((p1, p2) -> sortBy(direction, sortBy, p1, p2))
                .distinct().collect(Collectors.toList());
        return new PostDTO(resultList);
    }

    private int sortBy(String direction, String sortBy, BookDTO p1, BookDTO p2) {
        if (sortBy.equals(Constants.ID)) {
            return direction.equals(Constants.ASC) ? p1.getId() - p2.getId() : p2.getId() - p1.getId();
        } else if (sortBy.equals(Constants.READS)) {
            return direction.equals(Constants.ASC) ? p1.getReads() - p2.getReads() : p2.getReads() - p1.getReads();
        } else if (sortBy.equals(Constants.LIKES)) {
            return direction.equals(Constants.ASC) ? p1.getLikes() - p2.getLikes() : p2.getLikes() - p1.getLikes();
        } else if (sortBy.equals(Constants.POPULARITY)) {
            return direction.equals(Constants.ASC) ? p1.getPopularity().compareTo(p2.getPopularity()) : p2.getPopularity().compareTo(p1.getPopularity());
        }
        return 2;
    }
}
