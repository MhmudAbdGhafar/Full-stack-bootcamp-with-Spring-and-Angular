package com.vehiclesSystem.model;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class Bike extends Vehicle {

    public Bike(String id, String bmw, Type type) {
        super(id, bmw, type);
    }
}