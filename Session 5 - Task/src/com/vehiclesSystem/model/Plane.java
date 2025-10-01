package com.vehiclesSystem.model;

import lombok.*;
import org.springframework.context.annotation.Scope;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Scope("prototype")
public class Plane implements Vehicle {

    private String id;

    private String brand;

    private Type type =  Type.PLANE;

}
