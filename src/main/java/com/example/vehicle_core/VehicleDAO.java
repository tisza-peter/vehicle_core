package com.example.vehicle_core;

import java.util.List;

public class VehicleDAO {
    private VehicleEntity vehicle;
    private List<OwnerEntity> owners;

    public VehicleEntity getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleEntity vehicle) {
        this.vehicle = vehicle;
    }

    public List<OwnerEntity> getOwners() {
        return owners;
    }

    public void setOwners(List<OwnerEntity> owners) {
        this.owners = owners;
    }
}
