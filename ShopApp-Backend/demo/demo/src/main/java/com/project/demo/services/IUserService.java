package com.project.demo.services;

import com.project.demo.dtos.requests.UserDTO;
import com.project.demo.models.User;

public interface IUserService {
    public User createUser(UserDTO userDTO);
    public User login(String phoneNumber , String password);
}
