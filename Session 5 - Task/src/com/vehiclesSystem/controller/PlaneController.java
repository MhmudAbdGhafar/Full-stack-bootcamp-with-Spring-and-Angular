package com.vehiclesSystem.controller;

import com.vehiclesSystem.config.AppConfig;
import com.vehiclesSystem.model.Plane;
import com.vehiclesSystem.model.Type;
import com.vehiclesSystem.service.PlaneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PlaneController {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        PlaneService planeService = (PlaneService) context.getBean("planeService");

        planeService.savePlane(new Plane("id9", "brand", Type.PLANE));

        Plane plane = planeService.getPlaneById("id");

        context.close();

    }

}