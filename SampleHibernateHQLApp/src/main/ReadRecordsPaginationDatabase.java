package main;

import main.com.myApp.controller.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ReadRecordsPaginationDatabase
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

            Query query = session.createQuery("from Product");

            query.setFirstResult(5);
            query.setMaxResults(10);

            List<Product> products = query.getResultList();

            for (Product product : products) {
                System.out.println(product);
            }

        }catch (Exception exception)
        {
            exception.printStackTrace();
        }finally {
            session.close();
        }

    }
}