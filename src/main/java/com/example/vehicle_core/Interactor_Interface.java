package com.example.vehicle_core;

import org.json.JSONException;
import org.json.JSONObject;

public interface Interactor_Interface {
    void save(JSONObject vehicle);
    void get(JSONObject vehicleRegistrationNumber);

}
