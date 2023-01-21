package com.example.vehicle_core;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class NewVehicleRequestModel {
    private VehicleEntity vehicle;
    private List<OwnerEntity> owners;

    public JSONObject getJson()  {
        JSONObject json = new JSONObject();
        try {
            json.put("model",this.vehicle.getModel());
            json.put("vehicleType",this.vehicle.getVehicleType());
            json.put("numberOfSeats",this.vehicle.getNumberOfSeats());
            json.put("registrationNumber",this.vehicle.getRegistrationNumber());
            json.put("make",this.vehicle.getMake());
            JSONArray jsonowners = new JSONArray();
            for (OwnerEntity owner:this.owners) {
                JSONObject jsonowner = new JSONObject();
                jsonowner.put("name",owner.getName());
                jsonowner.put("address",owner.getAddress());
                jsonowners.put(jsonowner);
            }
            json.put("owners",jsonowners);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return json;
    }

    public void setByJson(JSONObject json) {
        try {
            parseJson(json);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void parseJson(JSONObject json) throws JSONException {
        this.vehicle=new VehicleEntity();
        this.vehicle.setModel(json.getString("model"));
        this.vehicle.setRegistrationNumber(json.getString("registrationNumber"));
        this.vehicle.setVehicleType(json.getString("vehicleType"));
        this.vehicle.setMake(json.getString("make"));
        this.vehicle.setNumberOfSeats(json.getInt("numberOfSeats"));
        this.owners = new ArrayList<>();
        JSONArray jsonOwners = json.getJSONArray("owners");
        for (int i = 0; i < jsonOwners.length(); i++) {
            JSONObject jsonOwner = jsonOwners.getJSONObject(i);
            this.owners.add(new OwnerEntity(
                    jsonOwner.getString("name"),
                    jsonOwner.getString("address")));
        }
    }


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
