package com.geekster.InstagramPart1.controllers;

import com.geekster.InstagramPart1.models.Post;
import com.geekster.InstagramPart1.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostController {
    @Autowired
    PostService postService;

    @PostMapping("/post")
    public void savePost(@RequestBody Post post){
        postService.savePost(post);
    }

    @GetMapping("/post/{postId}")
    public Post getPostById(@PathVariable Long postId){
        return postService.fetchPost(postId);
    }
}
