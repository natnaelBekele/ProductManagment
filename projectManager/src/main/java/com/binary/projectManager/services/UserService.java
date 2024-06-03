package com.binary.projectManager.services;



import com.binary.projectManager.dtos.UserDto;
import com.binary.projectManager.entities.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User createUser(UserDto userDto);
    User updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);
    User getUserById(Long id);
    User getUserByEmail(String email);
}
