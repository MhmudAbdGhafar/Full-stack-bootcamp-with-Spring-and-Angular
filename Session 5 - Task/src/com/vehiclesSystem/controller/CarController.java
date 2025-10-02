package com.vehiclesSystem.controller;

import com.vehiclesSystem.config.AppConfig;
import com.vehiclesSystem.model.Car;
import com.vehiclesSystem.model.Type;
import com.vehiclesSystem.service.CarService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CarController {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        CarService carService = (CarService) context.getBean("carService");

        carService.saveCar(new Car("id8", "brand", Type.CAR));

        Car car = carService.getCarById("id3");

        context.close();

    }

}