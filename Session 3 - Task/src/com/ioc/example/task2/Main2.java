package com.ioc.example.task2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Car car = context.getBean("car", Car.class);
        car.save();

        Plane plane = context.getBean("plane", Plane.class);
        plane.save();

    }
}