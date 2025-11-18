package com.ecommerce.app.dao;

import com.ecommerce.app.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    public List<Product> listProducts() {

        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.createQuery("from Product", Product.class).list();
    }

    @Override
    public void saveProduct(Product product) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.persist(product);
    }

    @Override
    public Product findById(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.get(Product.class, id);
    }

    @Override
    public void deleteProduct(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        Product theProduct = findById(id);

        currentSession.remove(theProduct);
    }
}