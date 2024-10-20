package com.project.demo.services.impls;

import com.project.demo.dtos.requests.UserDTO;
import com.project.demo.models.User;
import com.project.demo.services.IUserService;

public class UserService implements IUserService {
    @Override
    public User createUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public User login(String phoneNumber, String password) {
        return null ;
    }
}
