package main;

import entity.Course;
import entity.Instructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OneToManyBiDirectionalMain {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate-config.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            Instructor instructor = new Instructor("instructor1");

            List<Course> courses = new ArrayList<>();

            Collections.addAll(courses,
                    new Course("instructor1 first course"),
                    new Course("instructor1 second course"));

            instructor.setCourseList(courses);

            session.persist(instructor);

            session.getTransaction().commit();

        }catch(Exception e){
            e.printStackTrace();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
    }
}