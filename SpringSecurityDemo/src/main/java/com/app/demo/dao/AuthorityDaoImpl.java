package com.app.demo.dao;

import com.app.demo.model.Authority;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorityDaoImpl implements AuthorityDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public AuthorityDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Authority authority) {
        sessionFactory
                .getCurrentSession()
                .save(authority);
    }
}
