package com.ecommerce.app.dao.impl;

import com.ecommerce.app.dao.ProductDAO;
import com.ecommerce.app.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public ProductDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {

        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Product> findAll() {
        return getSession()
                .createQuery("from Product", Product.class)
                .getResultList();
    }

    @Override
    public Product findById(int id) {
        return getSession().get(Product.class, id);
    }

    @Override
    public Product save(Product product) {
        getSession().persist(product);

        return product;
    }

    @Override
    public Product update(Product product) {
        getSession().merge(product);

        return product;
    }

    @Override
    public Product delete(int id) {

        Product product = findById(id);
        if (product != null) {
            getSession().remove(product);
        }

        return product;
    }
}