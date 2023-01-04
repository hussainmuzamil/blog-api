package com.example.blogappapi.payloads;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO {
    private Long categoryId;

    @Size(min = 4,message = "This field shouldn't be empty")
    @NotNull
    private String categoryTitle;
    @NotNull
    private String categoryDescription;
}
