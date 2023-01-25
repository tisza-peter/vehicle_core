package com.example.vehicle_core;

public interface VehicleStorage {

    public String SaveVehicle(VehicleDAO vehicleDAO);
    public VehicleDAO LoadVehicle(String registrationNumber);
}
