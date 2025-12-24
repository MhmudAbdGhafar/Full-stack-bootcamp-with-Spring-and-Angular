package com.app.demo.dao;

import com.app.demo.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public boolean existsByUsername(String username) {

        return sessionFactory
                .getCurrentSession()
                .get(User.class, username) != null;
    }

    @Override
    public void save(User user) {

        sessionFactory
                .getCurrentSession()
                .save(user);

    }
}