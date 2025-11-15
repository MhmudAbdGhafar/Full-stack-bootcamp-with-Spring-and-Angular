package main;

import entity.Passport;
import entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BiDirectionalDirectoryClass {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            Person person = session.get(Person.class, 1);
            System.out.println(person);

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.getTransaction().commit();
            session.close();
        }
    }
}