package io.msdalp.rest;


import io.msdalp.dsone.Blog;
import io.msdalp.dsone.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogController {

    private final BlogRepository blogRepository;

    @Autowired
    public BlogController(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }


    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Blog> getBlogs() {
        return blogRepository.findAll();
    }
}

