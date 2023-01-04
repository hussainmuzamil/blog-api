package com.example.blogappapi.payloads;

import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long userId;
    @NotBlank
    @Size(min = 4, message = "User Name Should be of minimum 4 characters")
    private String userName;
    @Email
    private String userEmail;

    @NotBlank
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{6,}$"
            ,message = "password should contain Minimum six characters,at least one letter, one number and one special character")
    private String userPassword;

    @NotBlank
    private String about;
}
