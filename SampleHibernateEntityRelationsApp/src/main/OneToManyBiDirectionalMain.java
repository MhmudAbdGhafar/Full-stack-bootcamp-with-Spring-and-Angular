package main;

import entity.Answer;
import entity.Question;
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
                .addAnnotatedClass(Question.class)
                .addAnnotatedClass(Answer.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();

        try {

            session.beginTransaction();

            Question question = new Question("question1");

            List<Answer> answers = new ArrayList<Answer>();

            Collections.addAll(answers,
                    new Answer("question1 first answer"),
                    new Answer("question1 second answer"));

            question.setAnswers(answers);

            session.save(question);

        }catch(Exception e){
            e.printStackTrace();
        }
        finally {

            session.getTransaction().commit();

            session.close();
            sessionFactory.close();

        }
    }
}