package com.example.blogappapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(name = "user_name",nullable = false,length = 100)
    private String userName;
    private String userEmail;
    private String userPassword;
    private String about;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Post> posts = new HashSet<>();

}
