package com.vehiclesSystem.model;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Plane extends Vehicle {

    public Plane(String id, String brand, Type type) {
        super(id, brand, type);
    }
}