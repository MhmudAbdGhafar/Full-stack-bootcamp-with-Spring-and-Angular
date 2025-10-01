package com.vehiclesSystem.model;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
@Scope("prototype")
public class Car implements Vehicle {

    private String id;

    private String brand;

    private Type type = Type.CAR;


}
