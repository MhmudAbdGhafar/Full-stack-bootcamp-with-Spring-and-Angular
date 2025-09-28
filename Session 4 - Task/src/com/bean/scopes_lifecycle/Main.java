package com.bean.scopes_lifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Circle circle = (Circle) context.getBean("circle");
        circle.draw2DShape();
        circle.draw3DShape();

        Rectangle rectangle = (Rectangle) context.getBean("rectangle");
        rectangle.draw2DShape();
        rectangle.draw3DShape();

        context.close();

    }
}