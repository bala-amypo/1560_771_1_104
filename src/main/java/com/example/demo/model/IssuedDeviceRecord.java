package com.example.demo.Model;

import java.time.LocalDate;

public class IssuedDeviceRecord {
    private long id;
    private long employeeID;
    private long deviceItemId;
    private LocalDate issuDate;
    private LocalDate returDate;
    private String status;

    public IssuedDeviceRecord(){

    }

    public IssuedDeviceRecord(long employeeID, long deviceItemId, LocalDate issuDate, LocalDate returDate,
            String status) {
        this.employeeID = employeeID;
        this.deviceItemId = deviceItemId;
        this.issuDate = issuDate;
        this.returDate = returDate;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(long employeeID) {
        this.employeeID = employeeID;
    }

    public long getDeviceItemId() {
        return deviceItemId;
    }

    public void setDeviceItemId(long deviceItemId) {
        this.deviceItemId = deviceItemId;
    }

    public LocalDate getIssuDate() {
        return issuDate;
    }

    public void setIssuDate(LocalDate issuDate) {
        this.issuDate = issuDate;
    }

    public LocalDate getReturDate() {
        return returDate;
    }

    public void setReturDate(LocalDate returDate) {
        this.returDate = returDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
