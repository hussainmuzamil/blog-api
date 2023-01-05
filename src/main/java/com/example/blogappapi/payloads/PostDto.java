package com.example.blogappapi.payloads;

import com.example.blogappapi.entity.Category;
import com.example.blogappapi.entity.User;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private String title;
    private String content;

    private String imageName;
    private  Date dateAdded;

    private UserDTO user;
    private CategoryDTO category;

}
