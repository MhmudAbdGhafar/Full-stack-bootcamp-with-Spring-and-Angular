package com.ecommerce.app.dao;

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
    public void save(Product product) {
        getSession().persist(product);
    }

    @Override
    public void update(Product product) {
        getSession().merge(product);
    }

    @Override
    public void delete(int id) {
        Product product = findById(id);
        if (product != null) {
            getSession().remove(product);
        }
    }

    @Override
    public List<Product> search(String keyword) {
        // prepare the pattern for LIKE
        String pattern = "%" + keyword.trim().toLowerCase() + "%";

        // HQL: case-insensitive search by lower(name) LIKE :pattern
        return getSession()
                .createQuery(
                        "from Product p where lower(p.name) like :pattern",
                        Product.class)
                .setParameter("pattern", pattern)
                .getResultList();
    }
}