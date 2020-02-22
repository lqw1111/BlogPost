package com.example.demo.service;

import com.example.demo.domain.PostDTO;
import com.example.demo.feign.HatchwaysPostApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class AsyncResource {
    @Async
    public CompletableFuture<Optional<PostDTO>> getPostDTO(String tag) {
        log.debug(Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return CompletableFuture.completedFuture(Optional.of(new PostDTO(new ArrayList<>())));
    }
    //    @Autowired
//    private HatchwaysPostApi feign;
//
//    @Async
//    public CompletableFuture<Optional<PostDTO>> getPostDTO(String tag) {
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return CompletableFuture.completedFuture(feign.getResponseFromHatchWay(tag));
//    }

}
