package com.example.vehicle_core;

public interface Store_Interface {

    public void SaveBusinessObject( VehicleEntity entity);
    public VehicleEntity LoadBusinessObject();
}
