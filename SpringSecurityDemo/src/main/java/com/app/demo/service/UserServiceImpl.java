package com.app.demo.service;

import com.app.demo.dao.AuthorityDao;
import com.app.demo.dao.UserDao;
import com.app.demo.model.Authority;
import com.app.demo.model.User;
import com.app.demo.model.UserRegistrationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    private final AuthorityDao authorityDao;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(
            UserDao userDao,
            AuthorityDao authorityDao,
            PasswordEncoder passwordEncoder) {

        this.userDao = userDao;
        this.authorityDao = authorityDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(UserRegistrationDto dto) {

            if (!dto.getPassword().equals(dto.getConfirmPassword())) {
                throw new RuntimeException("Passwords do not match");
            }

            if (usernameExists(dto.getUsername())) {
                throw new RuntimeException("Username already exists");
            }

            String encodedPassword =
                    passwordEncoder.encode(dto.getPassword());

            User user = new User(
                    dto.getUsername(),
                    encodedPassword,
                    dto.getEnabled(),
                    dto.getFirstName(),
                    dto.getLastName(),
                    dto.getEmail()
            );

            userDao.save(user);

            // assign default role
            Authority authority = new Authority(user.getUsername(), "ROLE_USER");
            authorityDao.save(authority);
    }

    @Override
    public boolean usernameExists(String username) {
        return userDao.existsByUsername(username);
    }
}