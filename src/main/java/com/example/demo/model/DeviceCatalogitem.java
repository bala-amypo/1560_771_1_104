package com.example.demo.model;

public class DeviceCatalogitem {
    private long id;
    private String deviceCode;
    private String deviceType;
    private String model;
    private int maxAllowedPerEmployee;
    private Boolean active;

    public DeviceCatalogitem(){

    }

    public DeviceCatalogitem(String deviceCode, String deviceType, String model, int maxAllowedPerEmployee,
            Boolean active) {
        this.deviceCode = deviceCode;
        this.deviceType = deviceType;
        this.model = model;
        this.maxAllowedPerEmployee = maxAllowedPerEmployee;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDeviceCode() {
        return deviceCode;
    }

    public void setDeviceCode(String deviceCode) {
        this.deviceCode = deviceCode;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getMaxAllowedPerEmployee() {
        return maxAllowedPerEmployee;
    }

    public void setMaxAllowedPerEmployee(int maxAllowedPerEmployee) {
        this.maxAllowedPerEmployee = maxAllowedPerEmployee;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
    
}
