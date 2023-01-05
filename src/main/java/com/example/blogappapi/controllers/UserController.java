package com.example.blogappapi.controllers;

import com.example.blogappapi.payloads.ApiResponse;
import com.example.blogappapi.payloads.UserDTO;
import com.example.blogappapi.services.UserServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServices services;

    @GetMapping("/User/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long  userId){
        UserDTO user = services.getUserById(userId);
        return ResponseEntity.ok(user);
    }
    @GetMapping("/User/all")
    public ResponseEntity<List<UserDTO>> getAllUser(){
        List<UserDTO> userDTOS = services.getAllUsers();
        return ResponseEntity.ok(userDTOS);
    }
    @DeleteMapping("/User/{user_id}")
    public ResponseEntity<ApiResponse> deleteUserBYId(@PathVariable("user_id") Long userId){
        this.services.deleteUser(userId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted successfully",true),HttpStatus.OK);
    }
    @PostMapping("/User")
    public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO){
        UserDTO userDTO1 = services.createUser(userDTO);
        return ResponseEntity.ok(userDTO1);
    }
    @PutMapping("/User/{id}")
    public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO user,@PathVariable("id") Long userId){
        UserDTO userDTO1 = services.updateUser(user,userId);
        return ResponseEntity.ok(userDTO1);
    }
}
