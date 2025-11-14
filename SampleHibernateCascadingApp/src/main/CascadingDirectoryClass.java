package main;

import entity.Passport;
import entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class CascadingDirectoryClass {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Person.class)
                .addAnnotatedClass(Passport.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            Person person = new Person("Saad", "Mohamed", new Date());

            Passport passport = new Passport(person, "abc123");

            session.save(passport);

        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            session.getTransaction().commit();
            session.close();
        }
    }
}