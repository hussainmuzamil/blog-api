package com.example.blogappapi.services;

import com.example.blogappapi.entity.User;
import com.example.blogappapi.exceptions.ResourceNotFoundException;
import com.example.blogappapi.payloads.UserDTO;
import com.example.blogappapi.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServicesImplementation implements UserServices{

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = this.dtoToUser(userDTO);
        User savedUser = userRepository.save(user);
        return this.userToDto(savedUser);
    }

    @Override
    public UserDTO updateUser(UserDTO user, Long userId) {
        User oldUser = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
        oldUser.setUserEmail(user.getUserEmail());
        oldUser.setUserName(user.getUserName());
        oldUser.setUserPassword(user.getUserPassword());
        oldUser.setAbout(user.getAbout());
        User updatedUser = userRepository.save(oldUser);
        return this.userToDto(updatedUser);
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","id",userId));
        return this.userToDto(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
       List<UserDTO> userDTOS = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user:
             users) {
            userDTOS.add(this.userToDto(user));
        }
        return userDTOS;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
    public User dtoToUser(UserDTO userDTO){
       // User user = new User(userDTO.getUserId(),userDTO.getUserName(),userDTO.getUserEmail(),userDTO.getUserPassword(),userDTO.getAbout());
        return this.modelMapper.map(userDTO,User.class);
    }
    public UserDTO userToDto(User user){
      //  UserDTO userDTO = new UserDTO(user.getUserId(),user.getUserName(),user.getUserEmail(),user.getUserPassword(),user.getAbout());
        return this.modelMapper.map(user,UserDTO.class);
    }
}
