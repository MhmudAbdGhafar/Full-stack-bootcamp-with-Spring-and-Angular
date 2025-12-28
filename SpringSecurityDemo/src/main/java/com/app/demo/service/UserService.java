package com.app.demo.service;

import com.app.demo.model.UserRegistrationDto;

public interface UserService {

    void registerUser(UserRegistrationDto dto);

    boolean usernameExists(String username);
}