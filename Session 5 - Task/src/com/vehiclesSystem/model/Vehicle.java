package com.vehiclesSystem.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public abstract class Vehicle {

    private String id;

    private String brand;

    private Type type;

}
