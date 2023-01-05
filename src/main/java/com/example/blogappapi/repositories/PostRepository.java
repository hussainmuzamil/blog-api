package com.example.blogappapi.repositories;

import com.example.blogappapi.entity.Category;
import com.example.blogappapi.entity.Post;
import com.example.blogappapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    public List<Post> findByUser(User user);
    public List<Post> findByCategory(Category category);
}
