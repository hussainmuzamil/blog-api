package com.example.blogappapi.controllers;

import com.example.blogappapi.entity.Post;
import com.example.blogappapi.payloads.PostDto;
import com.example.blogappapi.services.PostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostServices postServices;

    @PostMapping("/users/User/{user_id}/category/{category_id}/add")
    private ResponseEntity<PostDto> addPost(@PathVariable("user_id") Long userId,
                                            @PathVariable("category_id") Long categoryId,
                                            @RequestBody PostDto post){
         return ResponseEntity.ok(postServices.addPost(post, userId, categoryId));
    }
    @GetMapping("/users/User/{id}/all")
    private ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable("id") Long userId){
        return ResponseEntity.ok(postServices.getAllPostsByUser(userId));
    }
    @GetMapping("/category/{id}/all")
    private ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable("id") Long userId){
        return ResponseEntity.ok(postServices.getAllPostsByUser(userId));
    }
}
