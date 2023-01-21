package com.example.vehicle_core;

import org.json.JSONException;
import org.json.JSONObject;

public class NewVehicleResponseModel {
    String status;

    public String getStatus() {
        return status;
    }

    public JSONObject getJson()  {
        JSONObject json= new JSONObject();
        try {
            json.put("status", status);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return json;
    }


    public void setByJson(JSONObject json) {
        try {
            this.status =json.getString("status");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
