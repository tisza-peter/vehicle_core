package com.example.vehicle_core;

import org.json.JSONObject;

public interface UI_Presenter_Interface {
    public void DisplayOneVehicle( String getVehicleResponseModelJSON);

    public void DisplaySaveStatus( String newVehicleResponseModelJSON);
}
