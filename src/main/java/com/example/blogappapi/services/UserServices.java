package com.example.blogappapi.services;

import com.example.blogappapi.payloads.UserDTO;

import java.util.List;

public interface UserServices {
    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user,Long userId);
    UserDTO getUserById(Long userId);
    List<UserDTO> getAllUsers();
    void deleteUser(Long userId);
}
