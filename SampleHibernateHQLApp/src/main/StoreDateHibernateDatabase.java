package main;

import main.com.myApp.controller.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class StoreDateHibernateDatabase
{
    public static void main(String[] args) {

        // define the Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        //define session
        Session session = sessionFactory.getCurrentSession();

        try {

            //open the transaction
            session.beginTransaction();

            Product product = new Product(
                    "Product31",
                    "Description for Product31",
                    319.99,
                    270,
                    "ManufacturerA",
                    new Date());

            session.persist(product);

        }catch (Exception exception)
        {
            exception.printStackTrace();
        }finally {
            session.getTransaction().commit();
            session.close();
        }

    }
}