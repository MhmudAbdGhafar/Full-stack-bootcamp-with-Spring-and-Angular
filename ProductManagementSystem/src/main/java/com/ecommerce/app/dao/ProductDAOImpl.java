package com.ecommerce.app.dao;

import com.ecommerce.app.model.Product;
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

    @Override
    public List<Product> listProducts() {

        Session session = getSession();

        return session.createQuery("from Product", Product.class).list();
    }

    @Override
    public void saveProduct(Product product) {

        Session session = getSession();

        session.persist(product);
    }

    @Override
    public void updateProduct(Product product) {

        Session session = getSession();

        Product existing = findById(product.getId());

        product.getProductDetails().setId(existing.getProductDetails().getId());

        session.merge(product);
    }

    @Override
    public Product findById(int id) {

        Session session = getSession();

        return session.get(Product.class, id);
    }

    @Override
    public void deleteProduct(int id) {

        Session session = getSession();

        Product theProduct = findById(id);

        session.remove(theProduct);
    }

    private Session getSession() {

        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Product> searchProductsByName(String keyword) {
        Session session = getSession();

        // prepare the pattern for LIKE
        String pattern = "%" + keyword.trim().toLowerCase() + "%";

        // HQL: case-insensitive search by lower(name) LIKE :pattern
        return session.createQuery(
                        "from Product p where lower(p.name) like :pattern", Product.class)
                .setParameter("pattern", pattern)
                .list();
    }
}