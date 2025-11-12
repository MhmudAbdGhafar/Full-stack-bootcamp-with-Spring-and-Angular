package main;

import main.com.myApp.controller.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class AggregateFunctionsDatabase
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

            Query query = session.createQuery("select sum(price) from Product");

            List<Double> result = query.getResultList();

            System.out.println("Total prices is : " + result.get(0));


        }catch (Exception exception)
        {
            exception.printStackTrace();
        }finally {
            session.close();
        }

    }
}