package com.example.vehicle_core;

import org.json.JSONException;
import org.json.JSONObject;

public interface Interactor_Interface {
    void save(String vehicleJSON);
    void get(String vehicleRegistrationNumberJSON);

}
