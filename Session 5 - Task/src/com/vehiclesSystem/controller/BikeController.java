package com.vehiclesSystem.controller;

import com.vehiclesSystem.config.AppConfig;
import com.vehiclesSystem.model.Bike;
import com.vehiclesSystem.model.Type;
import com.vehiclesSystem.service.BikeService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BikeController {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        BikeService bikeService = (BikeService) context.getBean("bikeService");
        bikeService.saveBike(new Bike("id3", "brand", Type.BIKE));

        Bike bike = bikeService.getBikeById("id3");

        context.close();

    }

}