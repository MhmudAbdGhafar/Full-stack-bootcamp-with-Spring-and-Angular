package com.ioc.example.task2;

public class Car implements Vehicle {

    private DatabaseOperation databaseOperation;

    public Car(DatabaseOperation databaseOperation) {
        this.databaseOperation = databaseOperation;
    }

    public Car() {
    }

    @Override
    public void save() {
        databaseOperation.saveData(getVehicleName());
    }

    @Override
    public String getVehicleName() {
        return "Car";
    }
}
