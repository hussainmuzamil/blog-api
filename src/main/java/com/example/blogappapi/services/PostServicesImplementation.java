package com.example.blogappapi.services;

import com.example.blogappapi.entity.Category;
import com.example.blogappapi.entity.Post;
import com.example.blogappapi.entity.User;
import com.example.blogappapi.exceptions.ResourceNotFoundException;
import com.example.blogappapi.payloads.PostDto;
import com.example.blogappapi.repositories.CategoryRepository;
import com.example.blogappapi.repositories.PostRepository;
import com.example.blogappapi.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PostServicesImplementation implements PostServices{
    @Autowired
    private PostRepository postRepository;
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public PostDto addPost(PostDto postDto,Long userId,Long categoryId) {
        User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","User id",userId));
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","CategoryId",categoryId));
        Post post = mapper.map(postDto, Post.class);
        post.setImageName("default.png");
        post.setDateAdded(new Date());
        post.setCategory(category);
        post.setUser(user);
        Post post1 = this.postRepository.save(post);
        return this.mapper.map(post1,PostDto.class);
    }

    @Override
    public void deletePost(Long postId) {

    }

    @Override
    public PostDto updatePost(Long postId, PostDto post) {
        return null;
    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public Post getPostById(Long postId) {
        return null;
    }

    @Override
    public List<PostDto> getAllPostsByUser(Long userId) {
        User user = this.userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException("User","User id",userId));
        List<Post> posts= this.postRepository.findByUser(user);
        List<PostDto> postDtos = new ArrayList<>();
        for (Post post:
             posts) {
            postDtos.add(this.mapper.map(post, PostDto.class));
        }
        return postDtos;
    }

    @Override
    public List<PostDto> getAllPostsByCategory(Long categoryId) {
        Category category = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category id",categoryId));
        List<Post> post = this.postRepository.findByCategory(category);
        List<PostDto> postDtos = new ArrayList<>();
        for (Post p:
             post) {
            postDtos.add(this.mapper.map(p,PostDto.class));
        }
        return postDtos;
    }

    @Override
    public List<Post> searchPosts(String keyword) {
        return null;
    }
}
