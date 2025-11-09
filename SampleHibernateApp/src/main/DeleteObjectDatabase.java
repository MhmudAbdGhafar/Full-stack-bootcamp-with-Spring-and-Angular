package main;

import main.com.myApp.controller.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteObjectDatabase {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            int id = 1;

            Student student = session.get(Student.class, id);

            session.delete(student);

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