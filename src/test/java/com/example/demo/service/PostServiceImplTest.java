package com.example.demo.service;

import com.example.demo.domain.BookDTO;
import com.example.demo.domain.PostDTO;
import com.example.demo.feign.HatchwaysPostApi;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceImplTest {

    @MockBean
    private HatchwaysPostApi feign;

    @Autowired
    private PostServiceImpl postService;

    private PostDTO postDTO;

    @Before
    public void setUp() {
        postDTO = new PostDTO();
        postDTO.setPosts(Arrays.asList(new BookDTO(95, "Jon Abbott", 4, 985, 0.42, 55875, Arrays.asList("tech"))));
    }

    @Test
    public void givenTagsSortByAndDirection_WhenHittingComsumerService_thenReturnResponse() {
        given(feign.getResponseFromHatchWay("tech")).willReturn(postDTO);
        PostDTO result = postService.operatePostInformation(Arrays.asList("tech"), "id", "asc");
        assertEquals(95, result.getPosts().get(0).getId().intValue());
    }
}
