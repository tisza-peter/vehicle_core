package com.example.vehicle_core;

public interface Store_Repository_Interface {

    public String SaveBusinessObject( VehicleDAO vehicleDAO);
    public VehicleDAO LoadBusinessObject(String registrationNumber);
}
