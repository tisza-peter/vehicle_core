package com.example.vehicle_core;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VehicleCoreApplication implements Interactor_Interface {

    private VehicleStorage myStore = null;
    private UI_Presenter_Interface myUI = null;
    public VehicleCoreApplication() {
    }

    public void SetStore(VehicleStorage store)
    {
        myStore = store;
    }

    public void SetUI(UI_Presenter_Interface ui)
    {
        myUI = ui;
    }

    @Override
    public void save(String vehicleJSON) {
        NewVehicleRequestModel RequestModel= new NewVehicleRequestModel();

        try {
            RequestModel.setByJson(new JSONObject(vehicleJSON));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        VehicleDAO vehicleDAO= new VehicleDAO();
        vehicleDAO.setVehicle(RequestModel.getVehicle());
        vehicleDAO.setOwners(RequestModel.getOwners());
        NewVehicleResponseModel responseModel= new NewVehicleResponseModel();
        String status =myStore.SaveVehicle(vehicleDAO);
        responseModel.setStatus(status);
        myUI.DisplaySaveStatus(responseModel.getJson().toString());
        // validate
        // parse
        // dtoJSON to entity
        // repository.save
    }

    @Override
    public void get(String vehicleRegistrationNumberJSON){
        String vehicleRegistrationNumber= null;
        try {
            vehicleRegistrationNumber = parseGetVehicleRequestModel(new JSONObject(vehicleRegistrationNumberJSON));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        VehicleDAO storedVehicle = myStore.LoadVehicle(vehicleRegistrationNumber);
        GetVehicleResponseModel model = new GetVehicleResponseModel();
        VehicleEntity vehicleEntity = storedVehicle.getVehicle();
        List<OwnerEntity> owners = new ArrayList<>();
        for (OwnerEntity oneOwner:storedVehicle.getOwners()) {
            owners.add(oneOwner);
        }
        model.setVehicle(vehicleEntity);
        model.setOwners(owners);
        myUI.DisplayOneVehicle(model.getJson().toString());
        // validate
        // parse
        // repository.load
        // entity to dtoJSON
        // display
    }

    private String parseGetVehicleRequestModel(JSONObject vehicleRegistrationNumberJSON) {
        try {
            return vehicleRegistrationNumberJSON.getString("registrationNumber");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
