package com.app.demo.dao;

import com.app.demo.model.User;

public interface UserDao {

    void save(User user);

    boolean existsByUsername(String username);
}