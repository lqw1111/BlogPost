package com.example.demo.controller;

import com.example.demo.domain.BookDTO;
import com.example.demo.domain.PostDTO;
import com.example.demo.service.PostService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    private static final String TAG_TECH = "tech";

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @MockBean
    private PostService postService;

    private PostDTO postDTO;

    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
        postDTO = new PostDTO(Arrays.asList(new BookDTO(95, "Jon Abbott", 4, 985, 0.42, 55875, Arrays.asList("tech"))));
        System.out.println(postDTO.toString());
    }

    @Test
    public void test_ping() throws Exception{
        mvc.perform(get("/api/ping").contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void givenTag_WhenPathIsCorrect_thenReturnJsonObject() throws Exception{
        given(postService.operatePostInformation(Arrays.asList("tech"), "likes", "asc")).willReturn(new PostDTO(Arrays.asList(new BookDTO(1, "1",1,1,1.0,1,Arrays.asList("tech")))));
        mvc.perform(get("/api/posts?tags=" + TAG_TECH).contentType("application/json"))
                .andExpect(status().isOk());
    }

}
