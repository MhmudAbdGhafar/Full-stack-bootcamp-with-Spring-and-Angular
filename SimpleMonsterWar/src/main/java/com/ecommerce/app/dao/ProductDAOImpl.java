package com.ecommerce.app.dao;

import com.ecommerce.app.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Product insert(Product product) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.persist(product);

        return product;
    }

    @Override
    @Transactional
    public Product findById(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        return currentSession.get(Product.class, id);
    }

    @Override
    @Transactional
    public Product deleteById(int id) {

        Session currentSession = sessionFactory.getCurrentSession();

        Query theQuery =
                currentSession.createQuery("delete from Product where id=:productId");

        theQuery.setParameter("productId", id);

        // Retrieve the product that will be deleted
        Product product = currentSession.get(Product.class, id);

        theQuery.executeUpdate();

        return product;
    }

    @Override
    @Transactional
    public Product update(Product product) {

        Session currentSession = sessionFactory.getCurrentSession();

        // Save or update the product (Hibernate handles the merge/persist logic)
        currentSession.update(product);

        return product;
    }

    @Override
    @Transactional
    public List<Product> findAll() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Product> theQuery =
                currentSession.createQuery("from Product order by name", Product.class);

        List<Product> products = theQuery.getResultList();

        return products.isEmpty() ? null : products;
    }
}