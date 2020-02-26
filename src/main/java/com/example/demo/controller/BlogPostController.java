package com.example.demo.controller;

import com.example.demo.domain.PostDTO;
import com.example.demo.exception.MissingRequestParameterException;
import com.example.demo.exception.ParameterInvalidationException;
import com.example.demo.helper.Constants;
import com.example.demo.service.PostService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Slf4j
public class BlogPostController {

    public static final String APPLICATION_JSON = "application/json";

    @Autowired
    private PostService postService;

    @GetMapping(value = "ping", produces = "application/vnd.com.demo.v1+json;charset=utf-8")
    public ResponseEntity<Map<String, Boolean>> ping2() {
        Map<String, Boolean> map = new HashMap();
        map.put("success", false);
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @GetMapping(value = "ping", produces = "application/vnd.com.demo.v2+json;charset=utf-8")
    public ResponseEntity<Map<String, Boolean>> ping() {
        Map<String, Boolean> map = new HashMap();
        map.put("success", true);
        return ResponseEntity.status(HttpStatus.OK).body(map);
    }

    @GetMapping(value = "posts")
    public PostDTO getPostInformation(@RequestParam Optional<List<String>> tags,
                                      @RequestParam(value = Constants.SORT_BY, defaultValue = Constants.ID, required = false) String sortBy,
                                      @RequestParam(value = Constants.DIRECTION, defaultValue = Constants.ASC, required = false) String direction) {
        log.info("tags: " + tags + ", sortBy: " + sortBy + ", direction: " + direction);
        tags.filter(list -> !list.isEmpty()).orElseThrow(() -> new MissingRequestParameterException(Constants.TAGS));
        if (!Constants.LIST_SORT_BY.contains(sortBy)) {
            throw new ParameterInvalidationException(Constants.SORT_BY);
        } else if (!Constants.LIST_DIRECTION.contains(direction)) {
            throw new ParameterInvalidationException(Constants.DIRECTION);
        }
        return postService.operatePostInformation(tags.get(), sortBy, direction);
    }
}
