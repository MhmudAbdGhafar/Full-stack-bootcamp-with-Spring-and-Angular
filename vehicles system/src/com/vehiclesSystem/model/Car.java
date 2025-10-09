package com.vehiclesSystem.model;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Car extends Vehicle {

    public Car(String id, String brand, Type type) {
        super(id, brand, type);
    }
}