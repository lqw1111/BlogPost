package com.example.demo.feign;

import com.example.demo.domain.PostDTO;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@FeignClient(value = "hatchway", url = "https://hatchways.io")
public interface HatchwaysPostApi {

    @GetMapping("/api/assessment/blog/posts")
    @Cacheable(value = "posts")
    Optional<PostDTO> getResponseFromHatchWay(@RequestParam String tag);
}
