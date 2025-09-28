package com.ioc.example.task2;

public class Plane implements Vehicle {

    private DatabaseOperation databaseOperation;

    public void setDatabaseOperation(DatabaseOperation databaseOperation) {
        this.databaseOperation = databaseOperation;
    }

    @Override
    public void save() {
        databaseOperation.saveData(getVehicleName());
    }

    @Override
    public String getVehicleName() {
        return "Plane";
    }
}
