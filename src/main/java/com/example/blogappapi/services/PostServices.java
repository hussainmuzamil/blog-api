package com.example.blogappapi.services;

import com.example.blogappapi.entity.Category;
import com.example.blogappapi.entity.Post;
import com.example.blogappapi.entity.User;
import com.example.blogappapi.payloads.PostDto;

import java.util.List;

public interface PostServices {
    public PostDto addPost(PostDto post,Long userId,Long categoryId);
    public void deletePost(Long postId);
    public PostDto updatePost(Long postId,PostDto post);
    public List<Post> getAllPost();
    public Post getPostById(Long postId);
    public List<PostDto> getAllPostsByUser(Long userId);
    public List<PostDto> getAllPostsByCategory(Long categoryId);

    List<Post> searchPosts(String keyword);
}
