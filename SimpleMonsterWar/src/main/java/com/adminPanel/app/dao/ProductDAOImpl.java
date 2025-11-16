package com.adminPanel.app.dao;

import com.adminPanel.app.model.Product;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@NoArgsConstructor
public class ProductDAOImpl implements ProductDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public ProductDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Product insert(Product product) {

        Session currentSession = sessionFactory.getCurrentSession();

        currentSession.persist(product);

        return product;
    }

    @Override
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
    public List<Product> findAll() {

        Session currentSession = sessionFactory.getCurrentSession();

        Query<Product> theQuery =
                currentSession.createQuery("from Product order by name", Product.class);

        List<Product> products = theQuery.getResultList();

        return products.isEmpty() ? null : products;
    }
}