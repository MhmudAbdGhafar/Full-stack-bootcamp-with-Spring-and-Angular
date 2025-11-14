package main;

import main.com.myApp.controller.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class UpdateObjectDatabase {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            Query query = session.createQuery("update Product set productName = :name where productId = :id");
            query.setParameter("name", "Samsung Mobile A56s");
            query.setParameter("id", 1);

            int status = query.executeUpdate();

            System.out.println("Updated records: " + status);

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.getTransaction().commit();
            session.close();
        }
    }
}