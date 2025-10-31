package com.ioc.example.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");

        Circle circle = container.getBean("circle", Circle.class);
        circle.draw2D();
        circle.draw3d();

        Square square = container.getBean("square", Square.class);
        square.draw2D();
        square.draw3d();

    }
}