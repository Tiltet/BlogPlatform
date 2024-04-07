package com.example.blog.controllers;

import com.example.blog.entities.Blog;
import com.example.blog.services.BlogService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** JavaDoc COMMENT. */
@SuppressWarnings("checkstyle:Indentation")
@RestController
@RequestMapping("/api/v2")
@AllArgsConstructor
public class BlogController {

    private BlogService blogService;

    @PostMapping("/addBlog")
    public Blog addCard(@RequestParam Long authorId, @RequestBody Blog blog) {
        return blogService.addBlog(authorId, blog);
    }

    @GetMapping("/blogs")
    public List<Blog> getBlogs() {
        return blogService.getBlogs();
    }

    @DeleteMapping("/deleteBlog")
    public Blog deleteBlog(@RequestParam Long blogId) {
        return blogService.deleteBlog(blogId);
    }

    @PatchMapping("/changeBlogTitle")
    public Blog changeBlogTitle(@RequestParam Long blogId, @RequestBody Blog blog) {
        return blogService.changeBlogTitle(blogId, blog);
    }

    @GetMapping("/blog")
    public Blog getBlog(@RequestParam Long blogId) {
        return blogService.getBlog(blogId);
    }
}
