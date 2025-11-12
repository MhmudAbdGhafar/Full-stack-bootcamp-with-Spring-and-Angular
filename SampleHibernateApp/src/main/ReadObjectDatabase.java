package main;

import main.com.myApp.controller.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadObjectDatabase
{
    public static void main(String[] args) {
        // define the Session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        //define session
        Session session = sessionFactory.getCurrentSession();

        try {

            //open the transaction
            session.beginTransaction();

            int id = 2;

            Student student = session.get(Student.class, id);

            System.out.println(student);

            //commit the changes
            session.getTransaction().commit();

        }catch (Exception exception)
        {
            exception.printStackTrace();
        }finally {
            session.close();
        }

    }
}